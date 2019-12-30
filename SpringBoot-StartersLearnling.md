## Spring Boot Starters启动器

### Starters是什么?
Starters可以理解为启动器,它包含了一系列可以集成到应用里面的依赖包，你可以一站式集成Spring及其它技术，而不需要导出找示例代码和依赖包，如你想使用Spring JPA 访问数据库，只要加入spring-boot-starter-data-jpa 启动器依赖就能使用了。

Starters包含了许多项目中需要用到的依赖，它们能快速持续的运行，都是一系列的到支持的管理传递性依赖。


### Starters命名
Spring Boot 官方的启动器都是以spring-boot-starter-命名的,代表一个特定的应用类型。


第三方的启动器不能以spring-boot开头命名，它们都被Spring Boot 官方保留。一般一个第三方的应该这样命名,像mybatis的mybatis-spring-boot-starter。
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191227102604134-495880402.png)


### Starters分类
#### 1. Spring Boot应用类启动器

| 启动器名称|  功能描述 |  
| :-------- | --------:| 
| spring-boot-starter|   包含自动配置、日志、YAML的支持。|  
| spring-boot-starter-web|   使用Spring MVC构建web 工程，包含restful，默认使用Tomcat容器。|  
|....|....|



#### 2. Spring Boot生产启动器
|启动器名称|功能描述|
| :-------- | --------:| 
|spring-boot-starter-actuator|提供生产环境特性，能监控管理应用。|
|....|....|


#### 3. Spring Boot技术类启动器
|启动器名称|功能描述|
| :-------- | --------:| 
|spring-boot-starter-json|提供对JSON的读写支持|
|spring-boot-starter-logging|默认的日志启动器，默认使用Logback。|
|....|....|
