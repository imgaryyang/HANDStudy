## SpringBoot 自动配置原理、实战

### Spring Boot自动配置原理
Spring Boot的自动配置注解是`@EnableAutoConfiguration`，从上面的@Import的类可以找到下面自动加载自动配置的映射。

`org.springframework.core.io.support.SpringFactoriesLoader.loadFactoryNmes(Class<?>, ClassLoader)`

```java
public static List<String> loadFactoryNames(Class<?> factoryClass, @Nullable ClassLoader classLoader) {
	String factoryClassName = factoryClass.getName();
	return loadSpringFactories(classLoader).getOrDefault(factoryClassName, Collections.emptyList());
}
```
**调用下面的方法**


```java
private static Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader) {
	MultiValueMap<String, String> result = cache.get(classLoader);
	if (result != null) {
		return result;
	}

	try {
		Enumeration<URL> urls = (classLoader != null ?
				classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
				ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
		result = new LinkedMultiValueMap<>();
		while (urls.hasMoreElements()) {
			URL url = urls.nextElement();
			UrlResource resource = new UrlResource(url);
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			for (Map.Entry<?, ?> entry : properties.entrySet()) {
				List<String> factoryClassNames = Arrays.asList(
						StringUtils.commaDelimitedListToStringArray((String) entry.getValue()));
				result.addAll((String) entry.getKey(), factoryClassNames);
			}
		}
		cache.put(classLoader, result);
		return result;
	}
	catch (IOException ex) {
		throw new IllegalArgumentException("Unable to load factories from location [" +
				FACTORIES_RESOURCE_LOCATION + "]", ex);
	}
}
```

这个方法会加载类路径及所有jar包下META-INF/spring.factories配置中映射的自动配置的类。

```
public static final String FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories"
```

>以上的代码来源下面的图
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191227105130683-1564131330.png)


- `查看Spring Boot自带的自动配置的包：`
spring-boot-autoconfigure-2.0.6.RELEASE.jar，打开其中的META-INF/spring.factories文件会找到自动配置的映射。
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191227105258895-259365197.png)

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191227105354219-207667120.png)


- `再来看看数据源自动配置的实现注解`
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191227105521388-1844872490.png)

`@Configuration,@ConditionalOnClass`就是自动配置的核心，首先它得是一个配置文件，其次根据类路径下是否有这个类去自动配置。


### 自动配置实战
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191227145403339-1983300262.png)
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191227145438913-348796084.png)

创建META-INF/spring.factories文件，添加自动配置映射：
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191227145526440-139075945.png)

这样就搞定了。


### 查看自动配置报告
怎么查看自己加的自动配置类有没有被加载，或者查看所有自动配置的和未激活的可以通过以下集中方式查看

- 1.spring-boot:run 运行的在对话框Environment中加入debug=true 变量
- 2.java -jar xx.jar  --debug
- 3.main方法运行，在VM Argumanets加入-Ddebug
- 4.直接在application文件中加入debug=true
- 5.如果集成了spring-boot-starter-actuator 监控，通过autoconfig端点也可以查看。


启动后会在控制台看到以下自动配置报告信息：
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191227160912958-1745115011.png)

- Positive matches：已经启用的自动配置
- Negative matches：未启用的自动配置

>从报告中看到自己添加的EnvAutoConfig已经自动配置了。