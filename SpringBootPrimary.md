## Springboot面试题
### 什么是 Springboot ?
```
SpringBoot是Spring开源组织下的子项目,是Spring组件一站式处理方式,主要是简化了使用Spring的难度,简省了繁重的配置,提供了各种启动器,开发者能快速上手.
```

### 为什么要用 SpringBoot?
```
独立运行
简化配置
自动配置
无代码生成和XML配置
应用监控
上手容易
```

### SpringBoot的核心配置文件有哪几个?它们的区别是什么?
```
Spring Boot的核心配置文件是 application 和 bootstrap 配置文件

application配置文件主要用于SpringBoot项目的自动化配置


bootstrap配置文件有以下几个应用场景
	使用Spring Cloud Config 配置中心时,这时需要在bootstrap配置文件中增肌连接到配置中心大的配置属性来加载外部配置中心的配置信息;
	少量固定的不能被覆盖的属性;
	少量加密/解密的场景;
```

### SpringBoot 的配置文件有哪几种格式?他们有什么区别?
```
.properties 和 .yml 他们的区别主要是书写格式不用
	1) .properties
	2) .yml 
另外  .yml 格式不支持 @PropertySource 注解导入配置	
```

### SpringBoot的核心注解是哪个?它主要由那几个注解组成?
```
启动类上的注解是 @SpringBootApplication,他也是SpringBoot的和核心注解,主要包含了以下3个注解：
	@SpringBootConfiguration：组合了 @Configuration 注解,实现配置文件的功能
	@EnableAutoConfiguration：打开自动配置的功能,也可以关闭某个自动配置的选项,如关闭数据源自动配置功能:@SpringBootApplication(exculde={DataSourceAutoConfiguration.class})
	@ComponentScan:Spring组件扫描
```

### 开启SpringBoot 特性有哪几种方式?
```
1.继承spring-boot-starter-parent 项目
2.导入spring-boot-dependencies 项目依赖
```

### SpringBoot 需要独立的容器运行吗?
```
可以不需要,内置了 Tomcat/Jetty 等容器
```

### 运行 SpringBoot有哪几种方式
```
1.打包用命令或者放到容器中运行
2.用Maven/Gradle 插件运行
3.直接执行main 方法运行
```

### Spring Boot 自动配置原理是什么?
```
注解
	@EnableAutoConfiguration, 
	@Configuration, 
	@ConditionalOnClass 就是自动配置的核心，首先它得是一个配置文件，其次根据类路径下能否有这个类去自动配置
```

### 你如何了解 SpringBoot中的staters ? 
```
Starters 可以了解为启动器,它包含了一系列可以继承到应用里面的依赖包,你可以一站式继承Spring 及其余技术,而不需要四处找示例代码和依赖包.如你想使用Spring JPA 访问数据库,只需要加入spring-boot-starter-data-jpa 启动器依赖就能使用了.
	Starters 包含了许多项目中需要用到的依赖,它们能快速持续地运行,都是一系列得到支持的管理传递性依赖.
```

### 如何在Spring Boot 启动的时候运行少量特定的的代码
```
可以实现接口 ApplicationRunner 或者CommandLineRunner,这两个接口实现方式一样,他们都只提供一个 run方法
```

### Spring Boot 有哪几种读取配置的方式
```
SpringBoot 可以通过 @PropertySource,
@Value,@Environment, @ConfigurationProperties 来绑定变量
```


### Spring Boot 支持哪些日志框架?推荐和默认的日志框架是哪个?
```
Spring Boot 支持 Java Util Logging, Log4j2, Lockback 作为日志框架，假如你使用 Starters 启动器，Spring Boot 将使用 Logback 作为默认日志框架，
```

### SpringBoot实现热部署有哪几种方式
```
主要有两种方式:
	Spring Loaded
	Spring-boot-devtools
```

### 你如何了解SpringBoot 配置加载顺序
```
在Spring Boot 里面,可以使用以下几种方式来加载配置
	properties文件
	YAML文件
	系统环境变量
	命令行参数
```

### Spring Boot 可以兼容老Spring项目吗,如何做
```
可以兼容,使用 @ImportResource 注解导入老Spring项目配置文件
```


### 保护Spring Boot 应用有哪些方法
```
在生产中使用HTTPS
使用Snyk检查你的依赖的关系
更新到最新版本
启用CRSF保护
使用内容安全策略防止XSS攻击
```

### Spring Boot 2.x 有什么新特性,与 1.x 有什么区别
```
配置变更
JDK版本更新
第三方类库更新
响应式Spring编程支持
HTTP/2支持
配置属性绑定
更多改进与增强
```