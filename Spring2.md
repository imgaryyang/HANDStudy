## Spring2
接Spring.md 文档


转移连接了流程中的状态。流程终除结束状态之外的每个状态，至少需要一个转移，这样就能够知道一旦这个状态完成时流程要去向哪里。状态可以有多个转移，分别对应于当前状态结束时可以执行的不同路径。



当流程从一个状态进行到另一个状态时，它会带走一些流程数据。有时候，这些数据只需要很短的时间（可能只要展现页面给用户）。有时候，这些数据会在整个流程中传递并在流程结束的时候使用。


### Spring Web Flow
Spring Web  Flow 可以构建会话式应用程序的Web框架，这是好的，但是感觉其配置只能用xml这个设计不太合理，尤其是当bean 很多或者流程节点很多的时都不好维护。

安全对于许多应用都是一个非常关键的切面，因为安全性是超越应用程序功能的一个关注点，应用系统的绝大部分内容不应该参与到与自己相关的安全性处理中。尽管我们可以直接在应用程序中编写安全性功能相关的代码，但更好的方式还是将安全性相关的关注点与应用程序本身的关注点进行分离，作为系统的一个切面，Sping Security 就是通过AOP和Filter 来为应用程序实现安全性的。


使用Servlet规范中的Filter保护Web请求并限制URL级别的访问。Spring Security 还能够使用Spring AOP 保护方法调用一一借助于对象代理和使用通知，能够确保只有具备适当权限的用户才能访问安全保护的方法。


### Spring Security

Spring Security非常灵活，能够基于各种数据存储来认证用户。它内置了多种常见的用户存储场景，如内存、关系型数据库以及LDAP。但我们也可以编写并插入自定义的用户存储实现。

当为浏览器渲染HTML内容时，你可能希望视图中能够反映安全限制和相关的信息。一个简单的样例就是渲染用户的基本信息（比如显示“您已经以。。。。身份登陆”）。或者你想根据用户被授予了什么权限，有条件地渲染特定的视图元素。Spring Security 本身提供了一个JSP标签库，而Thymeleaf 铜鼓特定的方言实现了与Spring Security 的集成。借助于这些，可以很容易的实现对视图的保护。


### Spring Data
Spring Data 是为了简化构建基于Spring 框架应用的数据访问技术，包括关系数据库、NoSQL、Map-Reduce框架、云数据服务等等，旨在提供一种通用、统一的编码模式（但是并不似代码完全一样），使得在Spring中使用任何数据库都变得非常容易。


Spring Data作为Spring Source的其中一个父项目，旨在统一和简化对各类型持久化存储，而不拘泥于是关系型数据库还是NoSQL数据存储。

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191209101123839-1914723452.png)


目前的Spring Data 包含如下的模块（或者说子项目）：
- Spring Data Commons
- Spring Data JPA
- Spring Data KeyValue
- Spring Data LDAP
- Spring Data MongoDB
- Spring Data Gemfire
- Spring Data REST
- Spring Data Redis
- Spring Data for Apache Cassandra
- Spring Data for Apache Solr
- Spring Data Couchbase (community module)
- Spring Data Elasticsearch (community module)
- Spring Data Neo4j (community module)


>无论是那种持久化存储，数据访问对象（DAO，即Data Access Objects）通常都会提供单一域对象得CRUD（创建、读取、更新、删除）操作、查询方法、排序和分页方法等。Spring Data 则提供了基于这些层面得统一接口（CrudRepository，PagingAndSortingRepository）以及对持久化存储的实现。


所有Spring Data的子项目都支持：
- 模板：处理资源分配和异常处理
- 对象、数据存储映射：如ORM
- 对数据访问对象的支持：帮助我们编写一些模板式语句如分页排序

>然而一些Spring Data子项目，如Spring Data Redis和Spring Data Riak都只是提供模板，这是由于其相应的数据存储都只支持非结构化的数据，而不适用于对象的映射和查询。


### Spring Boot

Spring诞生时是Java企业版（Java Enterprise Edition， JEE，也称J2EE）的轻量级代替品。


虽然Spring的组件代码是轻量级的，但它的配置却是重量级的。一开始，Spring用XML配置，而且是很多的XML配置，即使后来有基于注解的改善。而Spring Boot让这一切成为了过去，Spring的目的是简化程序的开发，Spring Boot为了简化Spring本身的开发。


Spring Boot依赖于自动配置技术将Spring应用中样板式的配置移除掉，这样就能让我们免受于一大堆的配置之苦，更加专注于业务功能。Spring Boot同时还提供了多个Starter项目，拿来即可用，极大地简化了编程任务。


它提供了四个主要的特性，能够改变开发Spring应用程序的方式：

- Spring Boot Starter：它将常用的依赖分组进行了整合，将其合并到了一个依赖中，这样就可以一次性添加到项目的Maven 或Gradle构建中，这里可以找到目前所有的starter项目。
- 自动配置：Spring Boot 的自动配置特性利用了Spring4 对条件化配置的支持，合理地推测应用所需的bean并自动化配置它们，减少了自己需要配置的数量。
- 命令行接口（Command-line interface，CLI）：Spring Boot的CLI发挥了Groovy编程语言的优势，并结合自动配置进一步简化Spring应用的开发。
- Actuator：它为Spring Boot应用添加了一定的管理特性。



### Spring Cloud
先来看看微服务，简单说来就是将原本单个独立的大系统拆分为分布式的多个小型的服务，这些小型服务各自独立运行，它们通过HTTP和RESTFUL API进行通信。



一个微服务一般完成某个特定的功能，比如下单管理、客户管理等等。每一个微服务都是微型六角形应用，都有自己的业务逻辑和适配器。一个微服务还会发布API给其他微服务和应用客户端使用。其他微服务完成一个WebUI，运行时，每一个实例可能是一个云VM或者是Docker容器。

微服务具有分布式系统的特性，如微服务发现，负载均衡，故障转移，多版本，灰度升级，服务降级，分布式跟踪。

Spring Cloud是一套完整的分布式系统解决方案，它的子项目涵盖了所有实现分布式系统所需要的基础软件设施`（包括配置管理、服务治理、智能路由、全局锁等等）。`基于Spring Boot，Spring Boot做较少的配置，便可成为Spring Cloud中的一个微服务，使用Spring Cloud的开发者可以快速的启动服务或构建应用、同时能够快速和云平台资源进行对接,使得开发部署极其简单。


Spring Cloud专注于提供良好的开箱即用经验的典型用例和可扩展性机制覆盖：
- 分布式/版本化配置：Spring Cloud Config
- 服务注册和发现：Netflix Eureka 或者Spring Cloud Eureka（对前者的二次封装）
- 路由：Spring Cloud Zuul 基于Netflix Zuul
- service - to - service调用：Spring Cloud Feign