## SpringBoot Annotate
### 一、注解(annotations)列表 
#### @SpringBootApplication：
包含了`@ComponentScan`、`@Configuration`和`@EnableAutoConfiguration`注解。其中`@ComponentScan`让spring Boot扫描到Configuration类并把它加入到程序上下文。


#### @Configuration:
等同于spring的XML配置文件；使用Java代码可以检查类型安全。

#### @EnableAutoConfiguration 
自动配置


#### @ComponentScan 
组件扫描，可自动发现和装配一些Bean。


#### @Component
可配合CommandLineRunner使用，在程序启动后执行一些基础任务。

#### @RestController
该注解是@Controller和@ResponseBody的合集,表示这是个控制器bean,并且是将函数的返回值直 接填入HTTP响应体中,是REST风格的控制器。

#### @Autowired
自动导入、自动装载

#### @PathVariable
获取url路径中的参数。

#### @JsonBackReference
解决嵌套外链问题。



#### @RepositoryRestResourcepublic
配合spring-boot-starter-data-rest使用。