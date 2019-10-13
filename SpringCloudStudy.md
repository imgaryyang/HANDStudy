# Spring Cloud
### 微服务的优点缺点?说下开发项目中遇到的坑?
#### 优点
- 每个服务直接足够内聚，代码容易理解
- 开发效率高，一个服务只做一件事，适合小团队开发
- 松耦合，有功能意义的服务
- 可用不同的语言开发，面向接口编程
- 易于第三方集成
- 微服务只是业务逻辑代码，不会和HTML，CSS或其他界面结合。
- 可以灵活搭配，连接公共库、连接独立库

#### 缺点
- 分布式系统的责任性
- 多服务运维难度加大
- 系统部署依赖，服务间通信成本，数据统一性，系统集成测试，性能监控。

### 什么是Spring Cloud?
>Spring Cloud 流应用程序启动器是基于SpringBoot的Spring集成应用程序，提供与外部系统的集成。Spring Cloud Task ，一个生命周期短暂的微服务框架，用于快速构建执行有限数据处理的应用程序


### Spring Cloud 和dubbo 区别？
- 服务调用方式 dubbo 是RPC；SpringCloud Rest Api
- 注册中心，dubbo是zookeeper； Spring Cloud是Eureka，也可以是zookeeper。
- 服务网关，dubbo本身没有实现，只能通过其他第三方技术整合；Spring Cloud 有Zuul 路由网关，作为路由服务器，进行消费者的请求分发，Spring Cloud支持断路器，与git 完美集成配置文件支持版本控制，事物总线实现配置文件的更新与服务自动装配等等一系列的微服务架构要素。

### REST 和RPC对比
- RPC 主要的缺陷是服务提供方和调用方式之间的依赖太强，需要对每一个微服务进行接口的定义，并通过持续继承发布，严格版本控制才不会出现冲突。
- REST是轻量级的接口，服务的提供和调用不存在代码之间的耦合，只需要一个约定进行规范。


### 你所知道的微服务技术栈
- 维度（Spring Cloud）
- 服务开发：SpringBoot Spring SpringMVC
- 服务配置与管理：Netfix公司的Archaiusm，阿里的Diamond
- 服务注册与发现：Eureka，zookeeper
- 服务调用：REST RPC gRpc
- 服务熔断器：Hystrix
- 服务负载均衡：Ribbon Nginx
- 服务接口调用：Feign
- 消息队列：Kafka Rabbitmq activemq
- 服务配置中心管理：Spring Cloud Config
- 服务路由：API网关 Zuul
- 事件消息总线：SpringCloudBus

### 负载均衡的意义是什么?
>在计算中，负载均衡可以改善跨计算机，计算机集群，网络连接，中央处理单元或磁盘驱动器等多种计算资源的工作负载分布。负载均衡旨在优化资源使用，最大吞吐量，最小响应时间并避免任何单一资源的过载。使用多个组件进行负载均衡而不是单个组件可能会通过冗余来提高可靠性和可用性。负载均衡通常涉及专用软件或硬件，例如多层交换机或域名系统服务进程。

### 微服务之间是如何独立通信的?
- 1.远程调用，比如Feign 调用，直接通过远程过程调用来访问别的service。
- 2.消息中间件

### Spring Cloud 如何实现服务的注册?
- 服务发布时，制定对应的服务名，将服务注册到注册中心(eureka，zookeeper)
- 注册中心加 @EnableEurekaServer，服务用@EurekaDiscoverClient，然后用ribbon或Feign进行服务直接的调用发现。

### Eureka和zookeeper区别
- Eureka 取CAP的AP，注重可用性，Zookeeper取CAP的CP注重一致性。
- Zookeeper在选举期间注册服务瘫痪，虽然服务最终会恢复，但选举期间不可用。
- Eureka的自我保护机制，会导致一个结果就是不会从注册列表移除因长时间没收到心跳而过期的服务。依然能接受新服务的注册和查询请求，但不会被同步到其他节点。不会服务瘫痪。
- Zookeeper有Leader和Follower 角色，Eureka各个节点平等。
- zookeeper采用过半数存货原则，Eureka采用自我保护机制解决分区问题。
- Eureka本质是一个工程，zookeeper只是一个进程。

### eureka自我保护机制是什么?
>Eureka server 节点在短时间内丢失了过多的实例的连接时(比如网络故障或频繁启动关闭客户端)节点会进入自我保护模式，保护注册信息，不再删除注册数据，故障修复时，自动退出自我保护模式。


### 什么是服务熔断?什么是服务降级?
- 服务的直接调用，比如在该并发情况下出现进程阻塞，导致当前线程不可用，慢慢的全部线程阻塞，导致服务器雪崩。
- 服务熔断：相当于保险丝，出现某个异常，直接熔断整个服务，而不是一直等到服务超时。
- 通过维护一个自己的线程池，当线程到达阀值的时候就启动服务降级，如果其他请求继续访问就直接返回fallback的默认值。

### 什么是Ribbon
>Ribbon 是一个负载均衡客户端，可以很好的控制http和tcp的一些行为。Feign默认集成了Ribbon。

### 什么是Feign?它的优点是什么?
- Feign采用的是基于接口的注释
- Feign整合了Ribbon，具有负载均衡的能力
- 整合了hystrix，具有熔断能力

**使用**
- 添加pom依赖
- 启动类添加@EnableFeignClients
- 定义一个接口 @FeignClient(name=“xxx”)指定调用那个服务


### Ribbon和Feign 的区别?
- 1.Ribbon都是调用其它服务，但方式不同。
- 2.启动类注解不同，Ribbon是@RibbonClient Feign的是@EnableFeignClients
- 3.服务指定的位置不同，Ribbon是在@Ribbonclient注解上声明，Feign则是在定义抽象方法的接口中使用@FeignClient声明。
- 4.调用方式不同，Ribbon需要自己的构建http请求，模拟http请求然后使用RestTemplate发送给其他服务，步骤相当繁琐。Feign需要将调用的方法定义成抽象方法即可。


### 什么是Spring Cloud Bus ？
Spring Cloud bus 将分布式节点用轻量的消息代理连接起来，它可以用于广播配置文件的更改或者服务直接的通讯，也可用于监控。

如果修改了配置文件，发送一次请求，所有的客户端便会重新读取配置文件。

**使用:**
```
添加依赖

配置rabbitmq
```

### SpringCloud断路器作用?
>当一个服务调用另一个服务由于网络原因或自身原因出现问题，调用者就会等待被调用者的响应 当更多的服务请求到这些资源导致更多的请求等待，发生连锁效应(雪崩效应)
>断路器有完全打开状态：一段时间内 达到一定的次数无法调用  并且多次检测没有会恢复吉祥 断路器完全打开，那么下次请求就不会请求到该服务
>半开：短时间内 有恢复迹象 断路器会将部分请求发给该服务，正常调用时，断路器关闭
>关闭：当服务一直处于正常状态 能正常调用

### 什么是Spring Cloud Config
在分布式系统中，由于服务数量居多，为了方便服务配置文件统一管理，实时更新，所以需要分布式配置中心组件。在Spring Cloud中，有分布式配置中心组件SpringCloud config ，它支持配置服务放在配置服务的内存中(即本地)，也支持放在远程仓库git仓库中。在Spring Cloud config 组件中，分两个角色，意识config server，二是config client。

**使用:**
```
使用pom依赖

配置文件添加相关配置
启动类添加注解@EnableConfigServer
```

### spring cloud gateway
>Spring Cloud Gateway是Spring Cloud官方推出的第二代网关框架，取代Zuul网关。网关作为流量的，在微服务系统中有着非常作用，网关常见的功能有路由转发、权限校验、限流控制等作用。
>使用了一个RouteLocatorBuilder的bean去创建路由，除了创建路由RouteLocatorBuilder可以让你添加各种predicates和filters，predicates断言的意思，顾名思义就是根据具体的请求的规则，由具体的route去处理，filters是各种过滤器，用来对请求做各种判断和修改。



### 架构
在微服务架构中，需要几个基础的服务治理组件，包括服务注册与发现、服务消费、负载均衡、断路器、智能路由、配置管理等，由这几个基础组件相互协作，共同组建了一个简单的微服务系统
在Spring Cloud微服务系统中，一种常见的负载均衡方式是，客户端的请求首先经过负载均衡（zuul、Ngnix），再到达服务网关（zuul集群），然后再到具体的服。，服务统一注册到高可用的服务注册中心集群，服务的所有的配置文件由配置服务管理，配置服务的配置文件放在git仓库，方便开发人员随时改配置。

### 什么是Hystrix?
防雪崩利器，具备服务降级，服务熔断，依赖隔离，监控（Hystrix Dashboard）
服务降级:
双十一 提示 哎哟喂，被挤爆了。app秒杀 网络开小差了，请稍后再试。
优先核心服务，非核心服务不可用或弱可用。通过HystrixCommand注解指定。
fallbackMethod(回退函数)中具体实现降级逻辑。
