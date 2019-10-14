# Hzero官方文档
## 平台概念
### HZERO简介
#### 企业级产品技术中台
```
Hzero是一个企业产品开发平台,是基于Choerodon的基础服务和组件进行拓展,抽象、封装的大量的应用标准服务及功能,避免大量产品和项目重复造轮子带来的成本浪费,Hzero平台主要包含业务中台和数据中台,目标是搭建一个可支持各种产品快速组建、开发的平台,可支持微服务的方便集成、组合重用。
```
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191010090900293-1058311376.png)

```
同时,HZero使用Spring Cloud 作为微服务分布式系统,并且HZero还使用Spring Boot进行了通用性模块的封装,例如鉴权服务、调度服务、消息服务等等;前端使用React作为开发组件,基于AntD进行二次封装和改造,使之更适合企业级应用系统的使用、
```

#### 为什么要使用HZero?
```
HZero解决了产品研发、项目实施面临的许多重复性工作,降低了交付成本并提高成本效率。同时，统一技术路线,统一开发规范,使基于HZero平台开发的各种产品能够无缝对接,形成融合的产品,降了各自产品技术路线不一直带来的兼容性问题。
```

### 系统架构
#### 逻辑架构
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191010092530323-226016099.png)

**从总体技术架构上主要分为以下4个方面**
- 辅助开发包，主要针对技术开发中进行技术支持,提供了一些通用的技术开发支持功能，减少重复造轮子。定义了基础实现累、异常封装、常用工具等。

- 平台组件，主要包含通用的Starter组件，例如Excel导入导出、数据防串改等，另外包含服务客户端组件，便与服务开发能够快速使用通用服务提供的能力。

- 通用服务，主要指开发业务中台系统中所需要的基础服务，比如主数据、消息、权限、文档管理等，能适配后续各产品线的通用服务对接需求。

- 平台功能，HZERO平台提供的通用业务服务，目前主要包括平台管理、门户管理、报表管理及工作流等服务


### 开源组件
#### HZERO 使用的开源组件
```
HZERO 完全基于开源产品打造。HZERO 的本身是使用 Spring Cloud 作为微服务架构，并使用了一些主流的开源工具进行DevOps及监控管理等。同时建议服务运行在 Docker 上，并 Kubernetes 作为容器管理和编排工具。
```

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191010093503037-1779713435.png)

#### 应用前端
HZero前端使用AntD Pro 进行封装拓展。
核心组件有：
- **React**：一个用于构建用户界面的JavaScript库
- **AntD Pro**：基于React 的开箱即用的中台前端、设计解决方案。
- **Node.js**：采用Node 打包、构建前端应用


#### 应用后端
HZERO 的微服务后端采用 Spring Cloud 作为微服务框架,使用 Spring Boot 作为开发脚手架。

核心组件有：
- **Spring Cloud**：Spring Cloud 是一个集成了众多开元的框架，利用Spring Boot 的开发便利实现了服务智力、服务注册与发现、负载均衡、数据监控、REST API 发布方式等，基本囊括了分布式框架所需要的所有功能。是一套易部署、易维护的分布式的开发工具包，如下是hzero用到的一些Spring Cloud的组件
	- Spring Cloud Eureka ：Eureka 是Netflix 开发的服务发现框架
	- Spring Cloud Config：分布式配置中心组件
	- Spring Cloud Zuul ：网关
	- Spring Cloud Ribbon：客户端负载均衡
	- Spring Cloud Feign：声明式服务调用
	- Spring Cloud Hystrix：熔断器
	- Spring Cloud Security：为构建安全的应用程序和服务提供了一组简单的原语（原语（primitive or atomic action）属于操作系统或计算机网络用语，是由若干条指令组成的，用于完成一定功能的一个过程。 原语是由若干个机器指令构成的完成某种特定功能的一段程序，具有不可分割性。即原语的执行必须是连续的，在执行过程中不允许被中断。）
	- Spring Websocket：消息实时推送
	- Oauth2：授权的开放表标准
	- JWT：Json Web Token（JWT）是一个开放标准（RFC 7519），用于作为JSON对象在各方之间安全地传输信息
	- Undertow：基于NIO 实现的高并发轻量级的服务器
	- Swagger：Swagger是一个贵方和完整的框架，用于生成、描述、调用和可视化RESTful风格的Web服务

- **Spring Boot**：Spring Boot 是由Pivotal 团队 提供的全新框架，其设计目的是用来简化新Spring 应用的初始搭建以及开发过程。该框架使用了特定的方式开进行配置，从而使开发人员不在需要定义样板化的配置。

- **Mybatis**：一款优秀的持久化框架，它支持订花SQL、存储过程以及高级映射。

- **其他常用工具**
	- Jackson：处理JSON和XML格式化的类库
	- Slf4j：即简单日志门面(Simple Logging Facade for Java)，不是具体的日志解决方案，它只服务于各种的日志系统。
	- Log4j：日志组件
	- Guava：Google核心工具包
	- Apache POI：Java 编写用来操作 Microsoft Office的框架
	- Okhttp3 ：一个高效的HTTP客户端
	- Cglib：动态代理框架
	- Httpclient：HTTP协议的客户端编程工具包

#### 数据服务层
HZERO采用MySQL、Oracle、SQLServer作为关系型数据存储库、Redis作为缓存库。

核心组件有：
- **MySQL**：Mysql是最刘赐你个的开源关系型数据库管理系统
- **Oracle**：Oracle 是主流的企业级关系型数据库管理系统。
- **SqlServer**：SqlServer 是主流的企业级关系型数据库管理系统。

- **Redis**：Redis 是一个开源的使用 ANSI C 语言编写、支持网络、可基于内存亦可持久化的日志型、Key-Value 数据库，并提供多种语言的 API。

#### 运行环境
HZERO 可运行在 Docker、VM、Server 上。

核心组件有：
- **Docker**：Docker是一个开源的应用容器引擎,让开发者可以打包他们的应用以及依赖包到一个可移植的容器中，然后发布到任何流行的Linux机器上，也可实现虚拟化。


#### 开发测试
HZERO 采用多个代码检查和测试工具，其中，JUnit、Spock 作为后端 Java 代码的测试工具；Selenium 作为前端测试的工具。

核心组件有：
- **JUnit**：JUnit 是一个 Java 语言的单元测试框架
- **Spock**：Spock 是一个用于Java或Groovy应用的测试框架。
- **Selenium**：Selenium 是一套完整的 web 应用程序测试系统，包含了测试的录制（selenium IDE），编写及运行（Selenium Remote Control）和测试的并行处理（Selenium Grid）。

##### 系统监控
HZERO 利用主流的开源监控工具，从日志、服务运行环境、调用链等进行全面监控，以便在发生问题时能够快速定位和解决问题。

核心组件有：
- **Zipkin**：Zipkin为分布链路调用监控系统,聚合各业务系统调用延迟数据，达到链路调用监控跟踪。
- **Grafana**：Grafana 是一个开箱即用的可视化工具，具有功能齐全的度量仪表盘和图形编辑器，优灵活丰富的图像化选项
- **Promethues**：Promethues是由SoundCloud开发的开元监控报警系统和时序列数据(TSDB)。
- **Micrometer**：Micrometer 是一个监控指标的度量类库。

---

---
## 服务列表
**基础组件列表**   
- Minio	对象存储服务	RELEASE.2018-05-25T19-49-13Z
- Redis	缓存数据库	    4.0.2
- Mysql	数据库	         5.7.22

**前端版本信息**
```
模块						版本				描述
hzero-front	  			1.0.0			父项目
hzero-front-runtime				1.0.0			公共脚手架依赖
hzero-front-hagd				1.0.0			分布式事务模块
hzero-front-hcnf				1.0.0			配置中心模块
hzero-front-hdtt				1.0.0			数据分发模块
hzero-front-hfile				1.0.0			文件服务模块
hzero-front-hiam				1.0.0			IAM模块
hzero-front-himp				1.0.0			导入服务模块
hzero-front-hitf				1.0.0			服务注册模块
hzero-front-hmsg				1.0.0			消息服务模块
hzero-front-hmnt				1.0.0			监控审计服务模块
hzero-front-hnlp				1.0.0			自然语言处理模块
hzero-front-hpay				1.0.0			支付服务模块
hzero-front-hpfm				1.0.0			平台服务模块
hzero-front-hrpt				1.0.0			报表服务模块
hzero-front-hsdr				1.0.0			调度服务模块
hzero-front-hsgp				1.0.0			服务治理模块
hzero-front-hwfp				1.0.0			新版工作流模块
```

>注意：hzero-front-hwfl 服务 最新版本为 0.11.1 后续不再维护； hzero-front-hptl 最新版本为0.11.2, 后续不再维护；


**HZERO 父依赖**  <br/>
HZERO提供提供统一的版本控制，只需要声明父依赖的版本，项目中只需要添加groupId和artifactId声明就可以了，使用父依赖可以极大的简化项目对HZERO版本的管理。

`父项目POM坐标`
```
<parent>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-parent</artifactId>
    <version>1.0.0.RELEASE</version>
</parent>
```


**Starter 列表** |  <br/>
以下是HZERO提供的基础依赖信息。
```
hzero-starter-core		1.0.0.RELEASE	基础依赖，用户信息相关和一些工具类

hzero-starter-dynamic-route		1.0.0.RELEASE	动态路由依赖

hzero-starter-export		1.0.0.RELEASE	导出组件依赖

hzero-starter-local-feign		1.0.0.RELEASE	Feign转本地调用依赖

hzero-starter-lock		1.0.0.RELEASE	Redis锁依赖

hzero-starter-mybatis-mapper		1.0.0.RELEASE	通用Mapper依赖

hzero-starter-register-event		1.0.0.RELEASE	服务注册依赖

hzero-starter-websocket		1.0.0.RELEASE	WebSocket依赖

hzero-starter-zuul-ratelimit		1.0.0.RELEASE	网关限流依赖

hzero-starter-apollo-config		1.0.0.RELEASE	阿波罗配置中心客户端依赖

hzero-starter-config-client		1.0.0.RELEASE	配置中心客户端组件

hzero-starter-feign-replay		1.0.0.RELEASE	Feign调用客户端支持组件

hzero-starter-hitoa		1.0.0.RELEASE	JVM监控组件

hzero-starter-integration-sdk		1.0.0.RELEASE	接口平台SDK

hzero-starter-social-core		1.0.0.RELEASE	三方登录核心依赖

hzero-starter-social-qq		1.0.0.RELEASE	三方QQ登录

hzero-starter-social-wechat		1.0.0.RELEASE	三方微信登录
```

**Boot列表** |  <br/>
以下是HZERO提供的客户端依赖信息。
```
hzero-boot-common		1.0.0.RELEASE	公共依赖，服务声明等

hzero-boot-iam		1.0.0.RELEASE	IAM客户端依赖

hzero-boot-file		1.0.0.RELEASE	文件客户端依赖

hzero-boot-import		1.0.0.RELEASE	导入客户端依赖

hzero-boot-message		1.0.0.RELEASE	消息客户端依赖

hzero-boot-platform		1.0.0.RELEASE	平台服务客户端依赖，数据权限，值集等

hzero-boot-scheduler		1.0.0.RELEASE	调度服务客户端依赖

hzero-boot-workflow-plus		1.0.0.RELEASE	新版工作流客户端依赖

hzero-boot-monitor		1.0.0.RELEASE	监控审计客户端

hzero-boot-interface		1.0.0.RELEASE	接口平台客户端依赖

hzero-boot-transfer		1.0.0.RELEASE	数据分发客户端依赖

hzero-boot-tenant		1.0.0.RELEASE	租户初始化客户端依赖

hzero-boot-api-customize		1.0.0.RELEASE	API客制化组件

hzero-boot-data-change		1.0.0.RELEASE	数据变更识别组件

hzero-boot-oauth		1.0.0.RELEASE	OAuth客户端组件

hzero-gateway-helper-api		1.0.0.RELEASE	网关鉴权API客户端

hzero-gateway-helper-default		1.0.0.RELEASE	网关鉴权API客户端默认实现
```

**Plugin 列表** |   <br/>
以下是HZERO提供的插件依赖信息。
```
组件			版本				SaaS和OP说明		描述
platform-mdm	1.0.0.RELEASE	区分		主数据依赖
platform-hr	1.0.0.RELEASE	区分		组织架构依赖
platform-org	1.0.0.RELEASE	区分		业务组织信息依赖
```

**基础服务列表**
>在引用服务依赖时,请区分Saas版和OP版本；Saas包含多租户的功能，分平台级和租户级，多用于开发产品；OP版本一般用于单租户（无租户概念），只包含租户级功能，多用于开发单系统项目；用Saas还是OP版本取决于你的项目。

以下是主要介绍HZERO平台相关微服务架构下的基础服务信息，可按照如下顺序安装服务。
```
组件	简称	默认端口	描述	SaaS和OP说明	版本
hzero-register	HREG	8000	注册中心		不区分		1.0.0.RELEASE
hzero-config	HCFG	8010	配置服务		区分			1.0.0.RELEASE
hzero-gateway	HGWY	8080	网关服务		不区分		1.0.0.RELEASE
hzero-oauth		HOTH	8020	认证服务		不区分		1.0.0.RELEASE
hzero-iam		HIAM	8030	IAM服务		区分			1.0.0.RELEASE
hzero-swagger	HSWG	8050	Swagger测试服务	不区分	1.0.0.RELEASE

```

**系统服务列表** |   <br/>
以下是主要介绍HZERO平台相关的通用服务信息。
>HZERO前端服务包括了平台所有服务所有的前端功能。
老版工作流服务 `hzero-workflow` 和 `hzero-workflow-editor` 最终版本定为 `0.10.0.RELEASE`，后续不再提供支持，可升级使用 `hzero-workflow-plus`

```
组件	简称	默认端口	描述	SaaS和OP说明	版本
hzero-platform	HPFM	8100	平台服务	区分	1.0.0.RELEASE

hzero-asgard	HAGD	8040	事务服务	不区分	1.0.0.RELEASE

hzero-file	HFLE	8110	文件服务	区分	1.0.0.RELEASE

hzero-message	HMSG	8120	消息服务	区分	1.0.0.RELEASE

hzero-scheduler	HSDR	8130	调度服务	区分	1.0.0.RELEASE

hzero-import	HIMP	8140	通用导入服务	区分	1.0.0.RELEASE

hzero-interface	HITF	8150	接口服务	区分	1.0.0.RELEASE

hzero-transfer	HDTT	8180	数据分发服务	区分(仅SaaS)	0.10.0.RELEASE

hzero-workflow-plus	HWFP	8220	新版工作流	区分	0.10.0.RELEASE

hzero-portal	HPTL	8200	门户服务	区分	0.10.0.RELEASE

hzero-report	HRPT	8210	报表服务	区分	0.10.0.RELEASE

hzero-monitor	HMNT	8260	监控审计服务	区分	1.0.0.RELEASE

hzero-pay	HPAY	8250	支付服务	不区分	1.0.0.RELEASE

hzero-nlp	HNLP	8230	内容提取服务	不区分	1.0.0.RELEASE

hzero-invoice	HIVC	8015	发票服务	区分	1.0.0.RELEASE

hzero-im	HIMS	8025	即时通讯服务	不区分	1.0.0.RELEASE

hzero-front	HFNT	80	HZERO前端	不区分	1.0.0.RELEASE
```

**组件仓库**  |    <br/>
在POM中依赖Hzero组件需要保证项目POM中制定了HZERO仓库信息
```
<repositories>
    <repository>
        <id>HzeroRelease</id>
        <name>Hzero-Release Repository</name>
        <url>http://nexus.saas.hand-china.com/content/repositories/Hzero-Release/</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
    <repository>
        <id>HzeroSnapshot</id>
        <name>Hzero-Snapshot Repository</name>
        <url>http://nexus.saas.hand-china.com/content/repositories/Hzero-Snapshot/</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>
```


### 注册中心  （hzero-register）
`组件编码 hzero-register`

#### 简介
**1.概述**   <br/>
基于Eureka的平台注册服务

**2.组件坐标**
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-register</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

**3.主要功能**
- 服务注册发现
- 服务健康检查
- 服务监控
- 注册中心其他功能


#### 服务配置
**1. Eureka版本配置**
```
eureka:
  client:
    # 检索服务选项，注册中心不需要检索服务
    fetch-registry: false
    # 注册中心将自己作为客户端来尝试注册自己，注册中心集群环境下需开启此配置
    register-with-eureka: false
    serviceUrl:
      # 注册中心地址，集群时，用逗号分隔多个地址
      defaultZone: http://dev.hzero.org:8000/eureka
    registryFetchIntervalSeconds: 10
  server:
    # Eureka server 清理无效节点的时间间隔，默认60000毫秒，即60秒
    evictionIntervalTimerInMs: 4000
    # 自我保护模式，当出现出现网络分区、eureka在短时间内丢失过多客户端时，会进入自我保护模式。
    # 即一个服务长时间没有发送心跳，eureka  也不会将其删除，默认为true
    enable-self-preservation: false
```


**2.启动类配置**      <br/>
register的启动类上需排除SecurityAutoConfiguration 配置类,因为注册中心不需要Security安全配置
```
@EnableHZeroRegister
@EnableEurekaServer
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class, args);
    }

}
```


### 配置中心 （hzero-config）
`组件编码 hzero-config`

#### 简介
**概述**  |  <br/>
微服务配置管理服务
 
**2.组件坐标**
- OP版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-config</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```

- SAAS版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-config-saas</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```

**3.主要功能**
- 服务管理
- 服务配置管理
- 服务动态路由

#### 服务配置
**1.服务配置**
```
hzero:
  config:
    route:
      # 跳过刷新服务路由的服务
      skip-parse-services: register, gateway, oauth
```

**2.启动类配置**  |   <br/>
config 的启动类上需排除 ConfigServerAutoConfiguration 配置类。

```
@EnableHZeroConfig
@EnableDiscoveryClient
@SpringBootApplication(exclude = ConfigServerAutoConfiguration.class)
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
```

**路由管理**   <br/>
config 服务有一个重要的功能是服务路由管理，正常情况下，其他服务启动成功并注册到注册中心后，config服务监听到服务注册后，会自动获取服务的文档信息，可惜服务路由信息，并更新到 `hzero_governance 的hsgp_service_routee `表中，在非正常情况下，如果无法自动更新路由，可在`路由管理`功能下手动维护


### 网关服务
`组件编码 hzero-gateway`

#### 简介
**1.概述**  <br/>
基于zuul的微服务网关服务

**2.组件坐标**
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-gateway</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

**3.主要功能**
- 动态路由
- API访问限流
- API访问熔断
- 用户鉴权
- 整体运维


#### 服务配置
**1. 服务配置**

```
spring:
  # 文件上传大小限制
  http:
    multipart:
      max-file-size: 30MB
      max-request-size: 30MB
  cloud:
    config:
      # 如果设置为 true，当从配置中心获取配置势必，则服务报错无法启动，一般设置为 false 即可
      fail-fast: false
      # 启用配置中心，向配置中心拉去服务路由信息
      enabled: true
      # 配置中心地址
      uri: http://dev.hzero.org:8010

zuul:
  addHostHeader: true
  # Zuul 路由配置，配置文件中的为静态配置
  # 如果启用了配置中心，则从网关获取路由信息；如果不启用配置中心，可将所有路由维护到网关即可。
  routes:
    # 服务简码
    hiam:
      # 路由前缀，与前端接口对应
      path: /iam/**
      # 服务编码
      serviceId: hzero-iam
    hoth:
      # 路由
      path: /oauth/**
      # 服务名
      serviceId: hzero-oauth
      # 去否去掉路由前缀
      stripPrefix: false
      # 自定义敏感头信息
      sensitiveHeaders: none
  # zuul 超时时间
  host:
    connect-timeout-millis: 120000
    socket-timeout-millis: 120000    

hzero:
  gateway:
    ## gateway-helper 配置
    filter:
      collect-span:
        # 是否统计API访问情况
        # 开启此配置会统计每个API的调用次数，数据存储在 Redis 缓存中
        enabled: false
      common-request:
        # 组织级API是否必须检查组织参数
        # 设置为 false 则不强制检查租户级API的 organiztionId 参数
        check-organization: true
        # 项目级API是否必须检查项目参数
        # 设置为 false 则不强制检查项目级API的 projectId 参数
        check-project: true
    helper:
      # 是否打印 JWT
      enabled-jwt-log: false
      # 跳过权限校验的路由
      # 对于需要跳过 gateway-helper 权限校验的路径可加到这个参数列表中
      helper-skip-paths:
        - /oauth/**
        - /swagger/swagger-ui.html
        - /swagger/swagger-resources/**
        - /swagger/webjars/**
        - /swagger/docs/**
        - /hwfe/**
        - /hwfp/editor-app/**
        - /hwfp/lib/**
        - /hwfp/activiti-editor
        - /hwfp-*/editor-app/**
        - /hwfp-*/lib/**
        - /hwfp-*/activiti-editor
        - /hmsg/sock-js/**
  ## 服务整体运维配置
  maintain:
    # 全局运维信息
    global-info:
      state: NORMAL
    # 服务运维信息
    service-maintain-info:
      oauth:
        state: NORMAL
    # 运维接口密钥，不配置则在程序启动时生成随机key
    secret-key: hzero
```

**2.启动类配置**  |   <br/>
gateway的启动类上徐排除SecurityAutoConfiguration 配置类，因为网关只做路由转发，不需要Security安全配置
```
@EnableHZeroGateway
@EnableDiscoveryClient
@SpringBootApplication(
        exclude = {SecurityAutoConfiguration.class}
)
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
```

**GatewayHelper鉴权** |
`1.鉴权过滤器`
GatewayHelper 组件提供了一组过滤器来对API鉴权，具体可参考 [基础服务链路调用](http://hzerodoc.saas.hand-china.com/zh/docs/installation-configuration/service-config/service-chain/)

`2.自定义鉴权`
hzero提供了`hzero-gateway-helper-api` 鉴权接口包 和 `hzero-gateway-helper-default` 默认实现

如果需要对鉴权逻辑进行整体改造，可以通过实现 `org.hzero.gateway.helper.api.AuthenticationHelper ` 接口来完全定制化鉴权部分。

如果仅需要对现有鉴权逻辑新增逻辑，可以实现 `org.hzero.gateway.helper.api.HelperFilter ` 接口来新增鉴权逻辑

`3.权限`
IAM刷新权限，并缓存到网关所在的Redis database 下，网关默认redis。database=4 ，如果要修改此配置，确保在IAM 服务中加入 `hzero.service.gateway.redis-db=xx`。


#### 整体运维
**1.功能说明**   <br/>
整体运维功能用于在服务运维期间提示用户某些服务不可用或全局服务运维，但前提必须保证网关服务可用。运维人员可通过调用网关的运维接口，通过传参设置运维模式和运维信息，或者关闭运维。

**2.配置样例**
```
hzero:
  maintain:
    global-info:
      state: NORMAL
    service-maintain-info:
      oauth:
        state: NORMAL
    secret-key: hzero  
```
`配置项介绍`
- 枚举类型：NORMAL、PAUSED、STOPED
	- 分别代表的含义为：正常运行、暂停服务、停止服务(通常用于将要被废弃的服务)
		- hzero.maintain.global-info.state=NORMAL

- 枚举类型如上
	- *表示服务路由前缀，如hzero-oauth独舞的路由前缀为 /oauth  
		- hzero.maintain.service-maintain-info.*.state=NORAM

- 运维接口秘钥，不配置则在程序启动时生成随机key
	- hzero.maintain.secret-key=key

**3.运维方式**

- open api 方式
	- 请求路径：/maintain?secretKey=&openAll=&openList=&closeList
	- 请求样例： http://localhost:8080/maintain?secretKey=a2fe79b5-bc8c-4d0b-bb95-a9aeada2a47a&openAll=true
	- 响应样例： 200 [空]

`请求参数:`
```
参数名       参数含义               是否必输
secretKey   秘钥                      是     
openAll     全局状态              true or false
openList    开启NORMAL状态的路径       否  
closeList   开启PAUSED状态的路径列表    否
```

- 配置文件配置
	- 如果没有接入配置中心，直接在应用中配置并重启。
	- 如果接入配置中心，通过配置中心配置即可，利用配置中心的机制刷新配置

### 认证服务 （hzero-oauth）
`组件编码 hzero-oauth`

#### 简介
**1.概述**   <br/>
`hzero-oauth` 服务是基于`Spring Security`、`Spring OAuth2`、`JWT` 实现的统一认证服务，登录基于Spring Security 的标准登录流程，客户端授权支持 oauth2.0 的四中授权模式：`授权码模式`、`简化模式`、`密码模式`、`客户端模式`，授权流程跟标准的oauth2 流程一致。web端采用`简化模式(implicit)`登录系统，移动端可使用`密码模式(password)`登录系统。并支持基于`Spring Social` 的第三方账号登录方式

**2.组件坐标**
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-oauth</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

**3.主要功能**
- 统一登录界面
- 账户、手机、邮箱登录
- 短信登录
- 第三方登录功能
- 可定制化登录模板

**4.服务配置**    <br/>
OAuth 服务的参数配置使用场景具体参考OAuth 服务下的其它文档
```
hzero:
  send-message:
    # 手机登录发送验证码模板代码
    mobile-login: HOTH.MOBILE_LOGIN
    # 修改密码发送验证码模板代码
    modify-login-password: HOTH.MODIFY_PASSWORD
  oauth:
    # 认证服务器 自定义资源匹配器
    # 可实现 ResourceMatcher 接口，自定义 OAuth ResourceServer 对哪些API认证
    custom-resource-matcher: false
    # 授权码模式验证 client 时不检查 client 的一致性
    not-check-client-equals: false
    # 移动设备ID参数
    device-id-parameter: device_id
    # 登录设备来源参数
    source-type-parameter: source_type
    # 移动端开启图形验证码校验，默认不开启
    enable-app-captcha: false
    # 始终开启图形验证码校验，默认否
    # 设置为 true 时，在进入登录页面时就显示图形验证码
    enable-always-captcha: false
    # client_credentials 模式是否返回 refresh_token，标准模式不返回
    credentials-allow-refresh: false
    # 登录页面标题
    title: HZERO
    login:
      # 允许使用的登录名，默认有 用户名、邮箱、手机号
      support-fields: username,email,phone
      # 手机登录参数
      mobile-parameter: phone
      # 登录页面默认模板，oauth 提供了两套模板
      # 在请求 /oauth/authorize 接口时，可通过 template 参数指定使用的模板
      default-template: main
      # 默认登录成功跳转地址
      # 在直接访问 oauth 的登录地址时，登录成功后会跳转到这个默认地址
      success-url: http://dev.hzero.org/workplace
    logout:
      # 退出时是否清理token
      clear-token: true
    sso:
      # 是否启用二级域名单点登录
      enabled: false
      service: 
        # oauth 服务地址
        baseUrl: http://dev.hzero.org:8080/oauth
      # SAML 协议登录相关配置  
      saml:
        entity_id: hzero:org:sp
        passphrase: secret
        private_key: MIIEvQIBADANBgk......
        certificate: MIIDEzCCA.......
    password:
      # 是否启用 RSA 加密
      enable-encrypt: true
      # 密码传输加密：公钥
      public-key: MFwwDQYJKoZIhvcNAQEBB......
      # 密码传输加密：私钥
      private-key: MIIBVQIBADANBgkqhkiG......
```

#### OAuth授权介绍
##### 标准登录
可直接访问OAuth 登录地址进行登录，`http://domain/oauth/login`，需配置默认的登录成功跳转地址，否则登录成功后会默认跳回登录页面

登录的字段默认支持 `用户名(username)、邮箱(email)、手机号(phone)`，可通过`support-fields`配置限制登录方式

```
hzero:
  oauth:
    # 标题
    title: ${HZERO_OAUTH_TITLE:HZERO}
    login:
      # 允许使用的登录名，默认有 用户名、邮箱、手机号
      support-fields: ${HZERO_OAUTH_LOGIN_SUPPORT_FIELDS:username,email,phone}
      # 默认登录成功跳转地址
      success-url: ${HZERO_OAUTH_LOGIN_SUCCESS_URL:http://domain/index}
```

##### 用户锁定
登录流程中，用户校验主要会涉及账号有效性、租户有效性、角色分配等校验。

其中，如果用户输入密码错误，增加密码错误次数（通过缓存记录），查询用户所属租户的安全策略，接着检查是否达到了`最大错误次数`，如果`允许锁定用户`，则`将用户锁定`

用户密码错误，如果启用了验证码，且密码错误次数超过`验证码检查阀值`则会校验验证码，进入登录页面时会判断是否显示验证码。

用户锁定之后可以通过`忘记密码`找回，或者在`账户管理`处理解锁用户

- 与用户密码、登录相关的请在`安全策略`下配置
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011103620504-1012564945.png)


##### Web端授权
**OAuth标准登录授权流程**   <br/>
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011104020082-1185778795.png)

前后端分离下，web端采用`简化模式`授权，由前端页面跳转到oauth 登录页面统一登录，前端检查到用户未登录时（返回`401状态码`），跳转到oauth 进行用户认证，获取 `access_token`。

- 1.用户接口返回 401
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011104516786-563401654.jpg)

- 2. 访问 `/oauth/authorize` 授权端点
前端检测到401时，访问 `http://domain/oauth/oauth/authorize?response_type=token&client_id=client&redirect_uri=redirect_uri` 地址，将用户引导到oauth 登录。
```
response_type:授权类型,固定token
client_id:客户端名称，需在oauth_client 表中配置客户端
redirect_uri:登陆成功后的重定向地址，需与client对应的重定向地址保持一致
```

**其他可传参数**
```
template:使用的登录模板，默认有main、portal，也可以自己按照标准目录开发模板，请求/authirize 接口时通过该参数传入要使用的模板即可

logout_redirect_uri:退出后重定向地址，可通过该参数指定退出成功后跳转的地址

user_type:控制登录用户类型，中台用户-P/C端用户-C
```
>实际上该地址是进入到`spring security`的过滤器链，spring security 检查到用户未登录，会重定向到登录界面
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011105655968-1614919587.jpg)

- 3.用户登录
用户登录成功后，重定向到  `/oauth/authorize` 端点，获取`access_token`。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011105743466-481344437.jpg)

- 4.登陆成功，返回access_token
`/oauth/authorize`端点成功创建`access_token`后，根据`redirect_uri` 并在uri后拼接access_token相关参数，重定向回去，至此授权完成。前端拿到 access_token 后，在访问后端服务。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011110312353-1502373934.jpg)

```
access_token:授权令牌
expire_in:令牌过期时间
scope:授权范围
```

- 5.access_token 唯一性
web端通过加入sessionId来控制access_token 的唯一性，这个session是来自oauth服务的session。

- 6.图片验证码
如果想每次进入登录页面时，都启用验证码，需启用如下配置
```
hzero:
  oauth:
    # 始终开启图形验证码校验，默认否
    enable-always-captcha: ${HZERO_OAUTH_ENABLE_ALWAYS_CAPTCHA:false}
```

##### 移动端授权
移动端授权可以使用`密码模式`给用户认证授权，移动端有自己的app登录入口，不能跳转到web页面登录。APP登录页面，用户输入用户名和密码即可完成登录。

`注意：移动端登录时，密码需要用RSA加密后传输到后端。`
- 1.访问`/oauth/token`授权端点
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011112027295-1661079453.jpg)

```
grant_type:授权类型,固定为password
client_id:客户端名称
client_secret:客户端秘钥
source_type:登录来源，移动设备固定为 app
device_id:登录设备ID，如果不传入设备ID，用户在多个设备登录返回的access_token 是一样的
username:登录用户名
password:登录密码
user_type:用户类型，中台用户-P/C端用户-C
```
`移动设备登录，需传入source_type=app标识`

- 2.配置项说明
```
hzero:
  oauth:
    # 验证 client 时不检查 client 的一致性
    not-check-client-equals: ${HZERO_OAUTH_NOT_CHECK_CLIENT_EQUALS:false}
    # 移动设备ID参数
    device-id-parameter: ${HZERO_OAUTH_DEVICE_ID_PARAMETER:device_id}
    # 登录设备来源参数
    source-type-parameter: ${HZERO_OAUTH_SOURCE_TYPE_PARAMETER:source_type}
```

##### 并发登录控制
可在安全策略下配置WEB端或移动端 是否允许同一个用户在多处登录，移动端和WEB端互不影响。当不允许用户多处登录时，用户在一处登录，自动失效其他的access_token。允许多处登录时，一个用户可同时在多处登录，由于access_token不一样，也互不影响
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011133634441-1148101391.png)

##### 其他配置
- 手机登录可配置发送验证码的模板，以及修改密码发送验证码的模板。
- 退出时若不清理token，那么下次登录时返回的access_token跟之前的登录的一样。若清理Token，每次登陆都会创建新的access_token。
```
hzero:
  send-message:
    # 手机登录发送验证码模板代码
    mobile-login: HOTH.MOBILE_LOGIN
    # 修改密码发送验证码模板代码
    modify-login-password: HOTH.MODIFY_PASSWORD
  oauth:
    logout:
      # 退出时是否清理token
      clear-token: ${HZERO_OAUTH_LOGOUT_CLEAR_TOKEN:true}
```

##### 刷新access_token
前端通过判断access_token 过期时间，自动调用 `/oauth/token`端点刷新access_token
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011140726977-1830475415.jpg)

```
grant_type:授权类型，固定为 refresh_token
refresh_token:获取access_token是返回的refresh_token
client_id:客户端名称
client_secret:客户端秘钥
```

##### 冻结下线用户
子账户冻结用户后，会使用户下线。oauth服务提供两个接口，可删除access_token，使用户下线

- 根据clientId和登录名下线
	- URI：【DELETE】/admin/token/{clientId}
	- 参数：clientId-客户端ID；loginNameList-用户登录名集合

- 根据登录名下线
	- URI：【DELETE】/admin/token
	- 参数：loginNameList-用户登录名集合

##### 授权码获取用户信息
授权码标准模式是通过授权码换取access_token，通过【GET】/oauth/user 接口可通过授权码直接返回用户信息，请求参数跟授权码标准模式一致。

##### OAuth配置
```
hzero:
  captcha:
    # 是否启用验证码
    enable: true
  send-message:
    # 手机登录发送验证码模板代码
    mobile-login: HOTH.MOBILE_LOGIN
    # 修改密码发送验证码模板代码
    modify-login-password: HOTH.MODIFY_PASSWORD
  oauth:
    # 认证服务器 自定义资源匹配器
    custom-resource-matcher: ${HZERO_OAUTH_CUSTOM_RESOURCE_MATCHER:false}
    # 验证 client 时不检查 client 的一致性
    not-check-client-equals: ${HZERO_OAUTH_NOT_CHECK_CLIENT_EQUALS:false}
    # 移动设备ID参数
    device-id-parameter: ${HZERO_OAUTH_DEVICE_ID_PARAMETER:device_id}
    # 登录设备来源参数
    source-type-parameter: ${HZERO_OAUTH_SOURCE_TYPE_PARAMETER:source_type}
    # 始终开启图形验证码校验，默认否
    enable-always-captcha: ${HZERO_OAUTH_ENABLE_ALWAYS_CAPTCHA:false}
    # 标题
    title: ${HZERO_OAUTH_TITLE:HZERO}
    login:
      # 允许使用的登录名，默认有 用户名、邮箱、手机号
      support-fields: ${HZERO_OAUTH_LOGIN_SUPPORT_FIELDS:username,email,phone}
      # 手机登录参数
      mobile-parameter: phone
      # 前端默认模板
      default-template: ${HZERO_OAUTH_LOGIN_DEFAULT_TEMPLATE:main}
      # 默认登录成功跳转地址
      success-url: ${HZERO_OAUTH_LOGIN_SUCCESS_URL:http://hzeronf.saas.hand-china.com/workplace}
    logout:
      # 退出时是否清理token
      clear-token: ${HZERO_OAUTH_LOGOUT_CLEAR_TOKEN:true}
```

#### OAuth Token API
##### OAuth密码模式
- API：【POST】 /oauth/oauth/token
- 场景：需要用户登录：通过`【用户名+密码】`获取token
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011145433565-752253943.png)

##### OAuth客户端模式
- API：POST  /oauth/oauth/token
- 场景：无需用户登录，只获取Token，一般用于外部系统接口调用
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011151249005-1361022728.png)

##### 标准登录接口
- API：POST /oauth/oauth/token
- 场景：仿Web端登录，需要用户登录，且需要用户输入验证码

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011151356101-1192854008.png)

- 请求参数
```
参数				说明							必输
grant_type  	授权类型，固定password		Y
client_id   	客户端ID						Y						
client_secret  	客户端密钥					Y
username		登录账号：可以使用 登录账号/手机号/邮箱 进行认证				Y
password		登录密码：使用 RSA 加密后传输	Y
source_type		设备来源，web-Web端/app-移动设备端	Y
device_id	设备ID，可以使用UUID，用于设置 Token 的唯一性	Y
user_type	用户类型：P-平台用户/C-C端用户，默认 P	N
login_field	登录字段，控制只能使用某个字段登录，username/phone/email，默认三个字段都支持	N
captcha	用户输入的验证码	N
captchaKey	生成验证码返回的 captchaKey	N

```

**获取初始化参数**
- API：GET /oauth/login/init-params?channel={channel}&client_id={clientId}
- 场景：进入登录页面时，调用该接口获取一些初始化信息
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011152009020-423881010.png)

- 请求参数
```
参数			说明
channel		登录渠道，查询对应渠道的三方登录方式
clientId	客户端ID，用于查询客户端所属租户
username	用户登录失败时可以传入用户名，用于查询用户所属租户
```

- 响应参数
```
参数				说明
openLoginWays	三方登录方式
isNeedCaptcha	是否需要输入图形验证码
```

**生成验证码**
- API：GET /oauth/public/captcha-code
- 场景：如果 isNeedCaptcha = true，首先调用该接口获取验证码的 Key

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011154414186-51467699.png)


**获取图形验证码**
- API：GET /oauth/public/captcha/{captchaKey}
- 场景：通过上一步得到 captchaKey 后，再调用该接口获取验证码图片

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011154539009-462202665.png)

##### 手机短信登录
**登录接口**
- API：POST /oauth/token/mobile
- 场景：通过 `手机+短信验证码` 登录，需要用户输入手机验证码

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011162810130-1895115648.png)

- 请求参数
```
参数				说明							必输
grant_type		授权类型，固定 implicit		Y
client_id		客户端ID						Y
client_secret	客户端密钥					Y
phone			手机号						Y
source_type	设备来源，web-Web端/app-移动设备端	Y
device_id	设备ID，可以使用UUID，用于设置 Token 的唯一性	Y
user_type	用户类型：P-平台用户/C-C端用户，默认 P	N
captcha			用户输入的手机验证码			Y
captchaKey		发送手机验证码返回的captchaKey	Y
```

**获取手机验证码**
- API：/oauth/public/send-phone-captcha
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011163631150-1692997045.png)

##### 接口返回说明
**请求失败**      <br/>
可通过 `success=false` 判断接口是否调用失败，如果调用失败，返回失败编码 `code` 及消息 `message`。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011163751020-1250049556.png)

**请求成功**      <br/>
请求成功则返回 `access_token`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011163846540-770966151.png)

**接口返回码**
```
返回编码							说明
hoth.warn.usernameNotFound	您输入的登录账户不存在
hoth.warn.phoneNotFound	您输入的手机号未注册
hoth.warn.userNotActive	您的账号未激活，无法登录
hoth.warn.accountLocked	您的账户已锁定，请通过找回密码解锁，或联系平台运维中心
hoth.warn.accountExpire	您的账户已过期，无法登录
hoth.warn.tenantInvalid	您的所属组织无效，请联系管理员
hoth.warn.tenantDisabled	您的所属组织已被禁用，请联系管理员
hoth.warn.passwordError	您的密码错误，还可以尝试{0}次
hoth.warn.usernameNotFoundOrPasswordIsWrong	您输入的账号或密码错误
hoth.warn.loginErrorMaxTimes	密码错误次数超过限制，您的账户已锁定！请通过找回密码解锁，或联系平台运维中心！
hoth.warn.ldapIsDisable	LDAP已被禁用
hoth.warn.captchaNull	请输入验证码
hoth.warn.captchaWrong	您输入的验证码有误
hoth.warn.phoneNotCheck	您的手机未验证，可使用邮箱或账号登录
hoth.warn.emailNotCheck	您的邮箱未验证，可使用手机或账号登录
hoth.warn.phoneAndEmailNotCheck	您的手机和邮箱均未验证，可使用账号登录
hoth.warn.defaultTenantRoleNull	您的默认租户下没有分配角色，请联系管理员分配角色
hoth.warn.loginMobileCaptchaNull	请输入手机验证码
hoth.warn.validCaptchaFirst	请先验证手机/邮箱
hoth.warn.accountNotEquals	您的账号与验证的账号不一致
hoth.warn.captcha.sendPhoneCaptchaError	发送手机验证码失败，请稍后重试
hoth.warn.phoneOrEmailNotnull	请输入手机/邮箱
hoth.warn.phoneOrEmailNotFound	您输入的手机/邮箱不存在
hoth.warn.phoneOrEmailNotInvalid	您输入的手机/邮箱格式不正确
hoth.user.phone.not-register	手机未注册，请先注册后再登录
hoth.warn.captchaNotnull	请输入验证码
hoth.warn.ldapCannotChangePassword	LDAP用户不能进行修改密码操作
hoth.warn.roleNone	您没有任何角色，请联系管理员分配角色
hoth.warn.decodePasswordError	解码密码错误，请用Base64加密后传输
hoth.warn.createClientError	创建Token错误
```

#### 多域名单点登录 
- 概述
```
用于集成外部CAS，OAUTH2，SAML等协议的单点登录，访问配置好的二级域名，自动跳转到对应单点登录页进行认证。
```

- 单点登录启用配置：
```
hzero:
  ### SSO配置 ###
  oauth:
    sso:
      # 是否启用二级域名单点登录
      enabled: true
      # oauth服务基础地址，用于单点登录回调
      service: 
        baseUrl: http://dev.hzero.org:8080/oauth
```

- 多域名单点登录效果：
`1.在系统管理-》域名配置中，创建单点登录配置`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011184936674-128042574.png)

`2.浏览器打开配置的域名 http://cas.hzero.org ,自动跳转到单点登录页面，并附带回调地址`

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011185827832-855360612.png)

`3.单点登录页登录成功后，跳转回 http://cas.hzero.org`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011185900923-70165678.png)


##### Cas 单点登录集成
- Cas单点登录流程
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011185946670-361916235.png)

- Cas单点登录配置如下：
	- 1.单点域名：平台域名的代理地址；
	- 2.单点登录类型选择：CAS协议；
	- 3.单点登录服务器地址：CAS服务器地址
	- 4.单点登录地址：CAS认证地址
	- 5.客户端地址：登录成功后的回调地址；

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011184936674-128042574.png)

##### Oauth2 单点登录集成
- OAuth2单点登录流程
单点登录时，判断二级域名对应的单点登录类型为Oauth2单点登录跳转到OAUTH2单点登录系统，登陆成功后调用回调地址并附带授权码参数，回调api处理逻辑中，会根据授权码获取对应的Token，再根据Token获取用户名。

- Oauth2单点登录配置如下：
	- 1.单点域名：平台域名的代理地址；
	- 2.单点登录类型选择：Oauth2协议；
	- 3.单点登录服务器地址：Oauth2服务器地址；
	- 4.单点登录地址：OAUTH2认证地址；
	- 5.客户端地址：登陆成功后的回调地址；
	- 6.clientId：Oauth2认证客户端ID；
	- 7.client密码：Oauth2认证客户端密码；
	- 8.Oauth2认证用户信息：Oauth2根据Token获取用户信息地址；
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011191809371-1447981603.png)

- Oauth2单点登录效果：
	- 1.在系统管理-》域名配置中，创建单点登录配置
	- 2.浏览器打开配置的域名 http://auth.hzero.org ,自动跳转到单点登录页面，并附带回调地址
	- 3.单点登录页登录成功后，跳转回 http://auth.hzero.org

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011192027931-1706247631.png)

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191011185900923-70165678.png)


#### 三方登录
#####三方登录简介
三方登录目前 HZERO 支持 微信、QQ 三方登录，同时支持项目上开发特定的三方登录，只需按规范开发相应的实现，然后在 oauth 服务中引入依赖即可。
	
**1.组件依赖**    <br/>
如果使用某个组件，需自行在oauth服务中引入相关依赖

- QQ
```xml
<dependency>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-social-qq</artifactId>
    <version>${hzero.starter.version}</version>
</dependency>
```

- 微信
```xml
<dependency>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-social-wechat</artifactId>
    <version>${hzero.starter.version}</version>
</dependency>
```


**2.三方登录组件**        <br/>
hzero-starter-social 三方登录组件基于 spring-social、spring-security、oauth2.0 扩展开发，hzero 三方组件如下：
- hzero-starter-social-core : 三方登录核心组件，抽象了三方认证流程，及相关API封装
- hzero-starter-social-qq : 三方QQ登录
- hzero-starter-social-wechat : 三方微信登录


##### 三方登录流程
Spring Social 三方登录流程是基于 oauth2.0 标准的授权码模式来完成的，所以 hzero-starter-social 组件只能在三方应用平台的授权方式是授权码模式才可以使用。具体的流程可以参考如下流程图。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191012110449720-1141008877.jpg)

##### 三方应用管理
**1.申请授权信息**    <br/>
在使用某种三方登录时，首先需要大对应三方开放平台上申请三方应用的授权信息。
- QQ 开放平台 ：https://connect.qq.com/index.html
- 微信 开放平台：https://open.weixin.qq.com/cgi-bin/index
- 微博 开放平台：https://open.weibo.com/

`在申请三方应用授权信息时，需要填入网站回调地址，回调地址在 oauth 服务中，且回调地址必须能让外网访问，否则三方平台无法回调。`

回调地址格式为：`http://{domain}/oauth/open/{appCode}/callback`

其中 `domain` 为`网站网关域名`，`appCode` 为三方应用编码。
- QQ 回调地址 : http://domain/oauth/open/qq/callback
- 微信 回调地址 : http://domain/oauth/open/wechat/callback
- 微博 回调地址 : http://domain/oauth/open/sina/callback

>申请成功后，将得到三方应用平台的 APP ID 以及 APP Key，例如 QQ 开放平台申请的应用：


**2.配置三方应用**   <br/>
首先需要在 `三方应用管理` 功能下配置系统的三方应用信息，维护好之后，才可以在个人中心三方账号及oauth登录页面看到三方应用的图标。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191012134518809-1619203107.png)

- 应用编码：
	- 取自值集：HIAM.OPEN_APP_CODE，应用编码的值就是回调地址中的 appCode

- 登录渠道：
	- 取自值集：HIAM.CHANNEL，前端根据渠道查询对应渠道的三方应用，且在调用 /open/** 接口时传入渠道参数(channel=xx)

- APP ID：申请的三方应用的授权 APP ID
- APP Key：申请的三方应用的授权 APP Key
- 应用图片：三方应用的图标
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191012140951449-1064919291.png)

##### 三方登录接口
下面以 QQ 三方登录为例介绍三方授权相关的一些接口。

**1.获取三方登录方式**    <br/>
调用`/oauth/login/init-params?channel={channel}&client_id={clientId}` 获取三方登录方式

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191012141221928-34539374.png)

```
openLoginWays: 三方登录方式
isNeedCaptcha: 是否需要输入图形验证码
```

**2. PC端跳转三方授权平台**  <br/>
PC 端需跳转到三方平台让三方用户授权登录，APP 端则直接使用 SDK 拉起本地应用授权。

访问 http://domain/oauth/open/qq?channel=pc，后台自动跳转到 QQ 授权页面

**3. 用户授权回调**    <br/>
用户授权后，三方平台将回调 `http://domain/oauth/open/qq/callback?code=XXXXX&state=xxx`，并带上授权码返回。移动端则会将授权码返回本地应用

之后的获取 access_token、认证用户是否已绑定，都是在后端自动进行，无需特别处理。（用户如果未绑定，默认返回错误信息到登录页面，将在下个迭代中支持跳转到绑定账号页面）

**4. 移动端三方认证接口** <br/>
移动端在本地获取到三方平台的 access_token 和 open_id 之后，调用后端接口 /oauth/token/open 认证用户及获取 oauth access_token。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191012142947077-1850798085.png)

>认证成功将返回 access_token，认证失败将返回对应的失败信息。

`接口返回码`
```
返回编码	说明
hoth.social.providerUserNotFound	未查询到您的三方用户信息
hoth.social.openIdNotFound	无法获取到您的三方账号
hoth.social.userAlreadyBind	您已绑定三方账户
hoth.social.openIdAlreadyBindOtherUser	您的三方账户已绑定其他用户，您可以先解绑再绑定当前用户
hoth.social.providerNotBindUser	三方账号未绑定系统用户
hoth.social.userNotFound	系统用户不存在
```


**5. PC端用户绑定三方账号** <br/>
用户登录后，可在个人中心绑定三方账号。绑定账号访问 http://domain/oauth/open/qq?channel=pc&access_token=xxxxx&bind_redirect_uri=redirectUrl

```
channel: 登录渠道
access_token: 用户登录后的 access_token
bind_redirect_uri: 绑定成功或失败的重定向地址，绑定失败将在重定向地址后通过 `social_error_message` 参数返回。
```

##### 开发三方登录
HZERO 目前已支持 微信、QQ 三方登录方式，如果项目上需要开发其它的三方登录，可按照如下步骤开发。三方应用平台相关的接口、参数、返回内容等请到对应三方开放平台查找。

**1. 创建三方组件**  <br/>
开发三方登录时，建议新建一个项目或模块，开发完成后在 oauth 服务中依赖该组件即可。parent 依赖 hzero-starter-social-parent，引入 hzero-starter-social-core 组件。下面以QQ开发的流程为例讲解如何基于 hzero-starter-social-core 开发三方登录。

- QQ Pom
```xml
<parent>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-social-parent</artifactId>
    <version>1.0.0.RELEASE</version>
</parent>
<artifactId>hzero-starter-social-qq</artifactId>

<dependencies>
    <dependency>
        <groupId>org.hzero.starter</groupId>
        <artifactId>hzero-starter-social-core</artifactId>
        <version>${hzero.starter.version}</version>
    </dependency>
</dependencies>
```

**2. 三方API封装**  <br />
① 三方用户信息类：实现 org.hzero.starter.social.core.common.api.SocialUser 接口，根据三方开放平台文档，封装三方用户信息

```java
public class QQUser implements SocialUser {

    private String ret;

    private String msg;

    private String openId;

    private String nickname;

    private String figureurl;

    private String gender;

    // getter/setter...
}
```

② 三方接口类：继承 org.hzero.starter.social.core.common.api.SocialApi 接口，该接口类有一个默认的 getUser 接口方法，用于向三方平台获取用户信息。
```java
public interface QQApi extends SocialApi {

}
```

③ 三方接口默认实现：继承 org.hzero.starter.social.core.common.api.AbstractSocialApi 抽象类，并实现 QQApi 三方接口。

在勾走按方法中，必须包含access_token 参数，Provider则封装了三方平台的信息，包括APP ID、APP Key、Token 地址、用户地址等等。
在构造方法中调用三方平台获取open_id 的接口，根据access_token 查询open_id 。有些三方登录再返回access_token 时会将open_id 直接返回，这时可以不用查询open_id；有些则需要一次接口调用。

实现getUser方法，调用三方平台用户信息查询接口，根据APP ID及openId查询用户信息

```java
public class DefaultQQApi extends AbstractSocialApi implements QQApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultQQApi.class);

    private String userInfoUrl;
    private String openIdUrl;

    /**
     * 客户端 appId
     */
    private String appId;
    /**
     * openId
     */
    private String openId;

    private static final ObjectMapper mapper = new ObjectMapper();

    public DefaultQQApi(String accessToken, Provider provider) {
        super(accessToken);
        // APP ID
        this.appId = provider.getAppId();
        // 获取用户信息的地址
        this.userInfoUrl = provider.getUserInfoUrl() + "?oauth_consumer_key={appId}&openid={openId}";
        // 获取 open_id 的地址
        this.openIdUrl = provider.getOpenIdUrl() + "?access_token={accessToken}";
        // 根据 access_token 获取 open_id
        this.openId = getOpenId(accessToken);
    }

    @Override
    public QQUser getUser() {
        // 获取用户信息
        String result = getRestTemplate().getForObject(userInfoUrl, String.class, appId, openId);

        QQUser user = null;
        try {
            user = mapper.readValue(result, QQUser.class);
        } catch (Exception e) {
            LOGGER.error("parse qq UserInfo error. result : {}", result);
        }
        if (user == null) {
            throw new ProviderUserNotFoundException(SocialErrorCode.PROVIDER_USER_NOT_FOUND);
        }
        user.setOpenId(openId);
        return user;
    }

    /**
     * 获取用户 OpenId
     */
    private String getOpenId(String accessToken) {
        // 返回结构：callback( {"client_id":"YOUR_APPID","openid":"YOUR_OPENID"} );
        String openIdResult = getRestTemplate().getForObject(openIdUrl, String.class, accessToken);
        if (StringUtils.isBlank(openIdResult) || openIdResult.contains("code")) {
            throw new CommonSocialException(SocialErrorCode.OPEN_ID_NOT_FOUND);
        }
        // 解析 openId
        String[] arr = StringUtils.substringBetween(openIdResult, "{", "}").replace("\"", "").split(",");
        String openid = null;
        for (String s : arr) {
            if (s.contains("openid")) {
                openid = s.split(":")[1];
            }
        }
        return openid;
    }
}

``` 

**3. API 适配器**
开发三方引用与本地应用用户之间的适配器，继承`org.hzero.starter.social.core.common.connect.SocialApiAdapter` 抽象类，覆盖`setConnectionValues`，在方法中，首先调用api获取用户信息，然后向 `ConnectionValues`中设置用户昵称、open_id 等。

```java
public class QQApiAdapter extends SocialApiAdapter {
    /**
     * QQApi 与 Connection 做适配
     * @param api QQApi
     * @param values Connection
     */
    @Override
    public void setConnectionValues(SocialApi api, ConnectionValues values) {
        // 调用三方接口获取用户信息
        QQUser user = (QQUser) api.getUser();
        // 设置昵称
        values.setDisplayName(user.getNickname());
        values.setImageUrl(user.getFigureurl());
        // 设置 open_id
        values.setProviderUserId(user.getOpenId());
    }
}
```

**4. 三方服务提供商** <br/>
服务商用于提供具体的API，需继承`org.hzero.starter.social.core.common.connect.SocialServiceProvider`抽象类，在getSocialApi 方法中，返回三方API的具体实现类。

```
public class QQServiceProvider extends SocialServiceProvider {

    private Provider provider;

    public QQServiceProvider(Provider provider, SocialTemplate template) {
        super(provider, template);
        this.provider = provider;
    }

    @Override
    public QQApi getSocialApi(String accessToken) {
        // 构造服务提供商API
        return new DefaultQQApi(accessToken, provider);
    }
}
```


**5. OAuth token 模板类** <br/>
OAuth token 模板类用于获取三方应用 access_token，刷新Token 等等，需继承`org.hzero.starter.social.core.common.connect.SocialTemplate`抽象类，根据实际API获取情况获取授权信息。
```
public class QQTemplate extends SocialTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(QQTemplate.class);

    public QQTemplate(Provider provider) {
        super(provider);
        // 设置带上 client_id、client_secret
        setUseParametersForClientAuthentication(true);
    }

    /**
     * 解析 QQ 返回的令牌
     */
    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        // 返回格式：access_token=FE04********CCE2&expires_in=7776000&refresh_token=88E4***********BE14
        String result = getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);
        if (StringUtils.isBlank(result)) {
            throw new RestClientException("access token endpoint returned empty result");
        }
        LOGGER.debug("==> get qq access_token: " + result);
        String[] arr = StringUtils.split(result, "&");
        String accessToken = "", expireIn = "", refreshToken = "";
        for (String s : arr) {
            if (s.contains("access_token")) {
                accessToken = s.split("=")[1];
            } else if (s.contains("expires_in")) {
                expireIn = s.split("=")[1];
            } else if (s.contains("refresh_token")) {
                refreshToken = s.split("=")[1];
            }
        }
        return createAccessGrant(accessToken, null, refreshToken, Long.valueOf(expireIn), null);
    }

    /**
     * QQ 响应 ContentType=text/html;因此需要加入 text/html; 的处理器
     */
    @Override
    protected RestTemplate createRestTemplate() {
        RestTemplate restTemplate = super.createRestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charsets.UTF_8));
        return restTemplate;
    }
}
```

**6. 连接工厂** <br/>
连接工厂用于创建 Connection 连接信息，需继承 `org.hzero.starter.social.core.common.connect.SocialConnectionFactory`类。
```
public class QQConnectionFactory extends SocialConnectionFactory {

    public QQConnectionFactory(Provider provider, SocialServiceProvider serviceProvider, SocialApiAdapter apiAdapter) {
        super(provider, serviceProvider, apiAdapter);
    }
}
```

**7. 连接工厂构造器** <br/>
连接工厂构造器用于创建连接工厂，需实现 `org.hzero.starter.social.core.common.configurer.SocialConnectionFactoryBuilder` 接口并实现三个方法，getChannel 返回登录渠道，getProviderId 返回应用编码，在builderConnectionFactory 中构造连接工厂。

参数provider 会自动根据channel 和provider 查询并传入，相关授权地址需自行到三方平台开放平台获取。

```
@Configuration
public class QQSocialBuilder implements SocialConnectionFactoryBuilder {

    @Override
    public String getChannel() {
        return ChannelEnum.pc.name();
    }

    @Override
    public String getProviderId() {
        return ProviderEnum.qq.name();
    }

    @Override
    public SocialConnectionFactory buildConnectionFactory(Provider provider) {
        // 获取授权码地址
        final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
        // 获取令牌地址
        final String URL_GET_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";
        // 获取 openId 的地址
        final String URL_GET_OPEN_ID = "https://graph.qq.com/oauth2.0/me";
        // 获取用户信息的地址
        final String URL_GET_USER_INFO = "https://graph.qq.com/user/get_user_info";

        provider.setAuthorizeUrl(URL_AUTHORIZE);
        provider.setAccessTokenUrl(URL_GET_ACCESS_TOKEN);
        provider.setOpenIdUrl(URL_GET_OPEN_ID);
        provider.setUserInfoUrl(URL_GET_USER_INFO);
        // 创建适配器
        QQApiAdapter apiAdapter = new QQApiAdapter();
        // 创建三方模板
        QQTemplate template = new QQTemplate(provider);
        // 创建服务提供商
        QQServiceProvider serviceProvider = new QQServiceProvider(provider, template);
        // 创建连接工厂
        return new QQConnectionFactory(provider, serviceProvider, apiAdapter);
    }
}
```

**8. 添加配置** <br/>
在 resources 资源目录下，新建 `META-INF` 目录，添加 `spring.factories` 文件，并将 QQSocialBuilder 添加到自动配置。内容如下：
```
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
org.hzero.starter.social.qq.config.QQSocialBuilder
```

**9. API 测试** <br/>
开发完成后，就可以打包发布，然后在 oauth 服务中引入依赖即可使用。

正常情况下，个人中心或登录页面，我们可以看到在三方应用管理配置的三方登录方式。

点击QQ图标会访问 http://domain/oauth/open/qq?channel=pc，接着会跳转到三方应用平台，后续的流程可参考三方登录流程图。

#### 客制化开发
待完善


### 事务服务 （hzero-asgard）
`组件编码 hzero-asgard`
#### 简介
**概述** <br/>
采用SAGA模型的分布式事务管理服务

**组件坐标**
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-asgard</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```
**3.主要功能** <br/>
- 事务定义
- 事务实例

**消费端配置项说明 ** <br/>
```
choerodon:  
  # saga 消费端配置说明
  saga:
    consumer:
      enabled: false # 是否开启saga消费端，默认关闭
      max-thread-num: 10 # saga消息消费线程池大小，默认大小为10
      max-poll-size: 200 # 每次拉取消息最大数量，默认大小200
      core-thread-num: 5 # 核心线程数，默认大小为5
      poll-interval-ms: 1000 # 拉取间隔（毫秒），默认1000
    producer:
      consistency-type: memory # 设置数据一致性处理器，memory为基于内存实现的回查方式，db为基于数据库表实现的回查方式
  # 任务调度消费端配置说明
  schedule:
    consumer:
      enabled: false # 是否开启系统定时清理过期数据，默认关闭
      poll-interval-ms: 1000 # 拉取间隔（毫秒），默认1000
      max-thread-num: 2 # saga消息消费线程池大小，默认大小为2
      core-thread-num: 1 # 核心线程数，默认大小为1
```

### IAM服务
`组件编码 hzero-iam`

##### 简介

**1.概述** <br/>
权限管理服务，平台统一的权限体系架构

**2.组件坐标** <br/>
- OP 版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-iam</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```

- Saas版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-iam-saas</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```

**3.主要功能** <br/>
- 角色管理
- 菜单管理
- 账户管理
- 用户组管理
- 租户管理
- 权限刷新
- 单据权限管理

##### 服务配置
```
hzero:
  data:
    permission:
      # 是否启用数据权限屏蔽
      enabled: true
      # 数据库所有者模式，例如 SqlServer 下的 dbo/guest
      db-owner: 
  ## 发送验证码相关    
  send-message:
    # 修改密码成功是否发送消息
    send-modify-password-success: true
    # 修改密码成功消息代码
    modify-password-success: HIAM.MODIFY_PASSWORD_SUCCESS
    # 创建用户是否发送消息
    send-create-user: true
    # 创建用户成功消息代码
    create-user: HIAM.CREATE_USER
    # 用户注册消息代码
    register-user: HIAM.REGISTER_USER
    # 找回密码消息代码
    find-password: HIAM.FIND_PASSWORD
    # 验证码手机消息代码
    validate-phone: HIAM.VALIDATE_PHONE
    # 验证码邮箱消息代码
    validate-email: HIAM.VALIDATE_EMAIL
    # 修改手机消息代码
    modify-phone: HIAM.MODIFY_PHONE
    # 修改邮箱消息代码
    modify-email: HIAM.MODIFY_EMAIL
  ## 验证码配置
  captcha:
    sms:
      # 短信验证码过期时间(分)
      expire: 5
      # 验证码发送间隔时间(秒)
      interval: 60
      # 同一个账号发送次数限制
      limit-time: 10
      # 次数限制的间隔时间(时)
      limit-interval: 12
    enable: true
    # 测试时禁用验证码功能
    # 设置为 true 时，则不会真正发送验证码，一般在压测时开启此配置
    test-disable: false
  ## 服务启动数据初始化相关
  start-init:
    # 是否初始化三方登陆方式到缓存
    open-login-way: true
    # 是否初始化密码策略到缓存
    password-policy: true
    # 是否初始化用户到缓存
    user: true
  import:
    # 初始化导入表，第一次启动服务的时候需开启此设置
    init-table: false
  tenant:
    init:
      # 是否开启拦截，只有开启才会拦截租户的新增和更新
      aspect:
        enabled: false
  field-permission:
    # 是否启用字段权限
    enable: true
  ## 刷新权限相关
  permission:
    # 是否自动刷新服务权限
    parse-permission: true
    # 不需要刷新权限的服务
    skip-parse-services: register, gateway, oauth, swagger
    # 刷新权限时是否清除旧的权限
    clean-permission: false
  sso:
    # 启用二级域名单点登录
    enabled: ${HZERO_OAUTH_SSO_ENABLED:true}
    provider:
      # cas key
      key: ${HZERO_OAUTH_SSO_PROVIDER_KEY:hzero}
    service: 
      # Cas 客户端地址
      baseUrl: ${HZERO_OAUTH_SSO_SERVICE_BASE_URL:http://dev.hzero.org:8080/oauth}
    # SAML 相关配置  
    saml:
      entity_id: hzero:org:sp
      passphrase: secret
      private_key: MIIEvQIBADANB.........
      certificate: MIIDEzCCAfugA.........
  password:
    # 密码加密公钥
    public-key: ${HZERO_OAUTH_PASSWORD_PUBLIC_KEY:MFwwDQYJKo.......}
    # 密码加密私钥
    private-key: ${HZERO_OAUTH_PASSWORD_PRIVATE_KEY:MIIBVQI........}  
```


##### 刷新权限
IAM服务有一个重要的功能是刷新服务权限，正常情况下，其他服务启动成功并注册到注册中心后，IAM监听到服务注册后，会自动获取服务的文档信息，并解析权限更新到iam_permission。在一些非正常情况下，需要手动调用接口刷新服务权限，可参考
[IAM 特殊接口介绍](http://hzerodoc.saas.hand-china.com/zh/docs/service/iam/inter/)

#### 用户相关API
##### 1.简介 
与用户相关的API主要分布在 `hzero-iam` 服务的如下几个Controller中，包含了管理端的接口、用户登录后可操作的接口、以及Public的接口。

- 用户管理
分平台级和组户级API，大部分API用在子账户管理功能下，如创建用户、查询用户列表、锁定用户等等。

- 登录用户接口
用户登录后可访问的API，大部分API用在 `个人中心`功能下，如修改手机号、修改密码、查询个人信息等

- 用户公开接口
与用户相关的Public API，一般用于 `外部系统调用`、`移动端接口调用`等，如找回密码、注册用户、发送验证码等

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014093207414-1142913021.png)

`主要介绍与用户相关的部分功能的流程，以及一些特殊的说明，具体的可根据本文档在Swagger或具体功能上测试后在对接接口。`

##### 登录用户-修改密码
说明：登录用户修改自己的密码

**第一步：修改密码** <br />
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014095529336-1467593781.png)


- 请求参数
```
参数	说明	必输	类型控制
originalPassword	原始密码	Y	string
password	新密码	Y	控制至少两种不同字符且长度大于6位
```
- 响应参数
`响应204 则代表成功`

- 返回码
```
返回编码	说明
error.ldap.user.can.not.update.password	LDAP用户不能修改密码
error.password.originalPassword	原始密码错误
error.password.same	新密码不能与原始密码相同
```

- 其他
修改密码成功后，默认会发送站内消息，消息模板可配置 `HIAM.MODIFY_PASSWORD_SUCCESS`


##### 登录用户-认证手机

说明：管理端创建用户后，手机需要用户自行认证

**第一步：给手机发送验证码** <br />
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014102237632-1957505253.png)

- 请求参数
```
参数	说明	必输	类型控制
phone	手机号	Y	string
```

- 响应参数
```
参数	说明
captchaKey	验证码的Key，验证码生成后会缓存，只返回验证码对应的uuid
message	返回消息，可直接提示给用户
```

- 其他
给自己的手机发送验证码的模板 `HIAM.VALIDATE_PHONE`，可在 消息模板 里修改短信内容。


**第二步:认证手机** <br />
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014103027071-1414485831.png)

- 请求参数
```
参数	说明	必输	类型控制
captchaKey	上一步得到的验证码 Key	Y	string
captcha	用户输入的验证码	Y	string
```

- 响应参数
响应`204` 则代表成功


##### 登录用户-认证邮箱 
说明：管理端创建用户后，邮箱需要用户自行认证，流程与认证手机一致，只是与 phone 相关的接口或参数改为 email 即可。


##### 登录用户-修改手机 
说明：用户修改自己的手机号，可以通过两种方式修改手机，一是验证原手机号，而是如果原手机无法接收验证码可通过密码找回。

**通过验证手机修改**<br />
`第一步：给原手机发送验证码`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014102237632-1957505253.png)

- 请求参数
```
参数	说明	必输	类型控制
phone	手机号	Y	string
```

- 请求参数
```
参数	说明	必输	类型控制
phone	手机号	Y	string
```

- 响应参数
```
参数	说明
captchaKey	验证码的Key，验证码生成后会缓存，只返回验证码对应的uuid
message	返回消息，可直接提示给用户
```

`第二步：前置验证码校验`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014103714621-1322020573.png)

- 请求参数
```
参数	说明	必输	类型控制
captchaKey	上一步得到的验证码 Key	Y	string
captcha	用户输入的验证码	Y	string
```

- 响应参数
```
参数	说明
lastCheckKey	验证通过后缓存结果，返回一个UUID代表验证通过
```

`第三步：向新手机号发送验证码`

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014103843593-1024229278.png)

- 请求参数
```
参数	说明	必输	类型控制
lastCheckKey	上一步得到的验证结果 Key	Y	string
phone	用户输入的新手机号	Y	string
```

- 响应参数
```
参数	说明
captchaKey	验证码的Key，验证码生成后会缓存，只返回验证码对应的uuid
message	返回消息，可直接提示给用户
```

- 其他
给新手机号发送验证码的模板：`HIAM.MODIFY_PHONE`


`第四步：新手机号验证并修改手机号`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014112012860-742773248.png)

- 请求参数
```
参数	说明	必输	类型控制
phone	用户输入的新手机号	Y	string
lastCheckKey	第二步得到的验证结果 Key	Y	string
captchaKey	上一步得到的验证码 Key	Y	string
captcha	用户输入的验证码	Y	string
```

- 响应参数
响应`204` 则代表成功

**通过验证密码修改**<br />
`第一步：校验原密码`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014112150746-1600081995.png)

```
参数	说明	必输	类型控制
password	用户输入的密码	Y	string
```

- 响应参数
```
参数	说明
lastCheckKey	验证通过后缓存结果，返回一个UUID代表验证通过
```
>后续：与 [通过验证手机修改] 方式第三步、第四步一致


##### 登录用户-修改邮箱 
说明：修改邮箱与修改手机流程一致，只是与 phone 相关的接口或参数改为 email 即可。


##### Public -用户注册（创建）
`获取国际冠码`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014113301749-501789957.png)


`用户输入密码后，可调用该API检测密码强度(可选)`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014113327970-1148796830.png)

`根据需要校验 手机/邮箱/用户名 是否已注册`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014113400872-235642274.png)

`通过手机注册发送手机验证码，通过邮箱注册则发送邮箱验证码`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014113457387-196926724.png)


`用户注册`
- 如果直接调用IAM服务注册，可直接调用通过手机或邮箱注册用户的接口，这两个接口默认为用户分配平台和游客角色
- 如果自行做一些处理后在创建用户，可调用内部创建接口，需要自行传入分配的角色编码。

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014132436501-401450513.png)

- 请求参数
```
参数	说明	必输	类型控制
captchaKey	发送验证码时返回的验证码 Key	Y	string
captcha	用户输入的验证码	Y	string
type	创建类型	N	仅在内部调用时需传入该参数，手机-phone/邮箱-email
—	—	—	—
loginName	登录账号	N	未传则生成默认账号
email	邮箱	N	邮箱正则：^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$
organizationId	所属租户	Y	integer
password	密码	Y	
realName	真实姓名	Y	
phone	手机	Y	手机正则：^134[0-8]\\d{7}$\|^13[^4]\\d{8}$\|^14[5-9]\\d{8}$\|^15[^4]\\d{8}$\|^16[6]\\d{8}$\|^17[0-8]\\d{8}$\|^18[\\d]{9}$\|^19[89]\\d{8}$
internationalTelCode	国际冠码	N	默认+86
userType	用户类型	N	默认中台用户，中台用户-P/C端用户-C
startDateActive	有效日期起	N	默认当前时间
endDateActive	有效日期止	N	
userSource	用户来源	N	
birthday	生日	N	
nickname	昵称	N	
gender	性别	N	性别, 男-1/女-0
```

- 如果是内部调用，需自行传入角色参数 `memberRoleList`
```
参数	说明	必输	类型控制
roleCode	角色编码	Y	注意角色编码取 iam_role.code
assignLevel	分配层	N	租户层-organization/组织层-org，非必须，默认 organization
assignLevelValue	分配层级值	N	租户层-角色所属租户ID/组织层-组织ID，非必须，默认取角色所属租户ID
```

##### Public - 找回密码
`发送验证码：根据需求调用发送手机或邮箱验证码的接口`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014134844288-1287540823.png)

`找回密码`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191014134919127-1233121466.png)


##### 定制化
如果对用户创建流程需要客制化，例如用户信息校验、默认角色分配等，可通过继承如下 Service 个性化开发
- UserCheckService：用户信息校验服务
- UserCreateService：创建用户服务
- UserCreateInternalService：内部调用创建用户服务
- UserUpdateService：更新用户服务
- UserRegisterService：注册用户服务
- UserCaptchaService：用户验证码相关服务

##### 返回码
```
phone.format.incorrect	您输入的手机[{0}]格式不正确
email.format.incorrect	您输入的邮箱[{0}]格式不正确
captcha.send.interval	请{0}秒后再发送验证码
captcha.send.time-over	您今天发送验证码的次数已达上限，请{0}小时后再试
captcha.send.phone	短信验证码已发送至手机:{0}，请在{1}分钟内完成验证
captcha.send.email	邮件验证码已发送至邮箱:{0}，请在{1}分钟内完成验证
captcha.validate.overdue	验证码失效，请重新获取
captcha.validate.number-not-match	与发送验证码的号码不匹配
captcha.validate.number-not-null	验证码账号不能为空
captcha.validate.incorrect	您输入的验证码有误，请重新输入
captcha.validate.error.too-many-time	验证错误次数太多，请重新获取
captcha.validate.last-check-incorrect	前置验证码校验未通过或已过期，请返回上一步进行验证
captcha.validate.captcha.notnull	验证码不能为空
captcha.validate.captcha.incorrect	验证码不正确
user.validation.phone.exists	您输入的手机号已注册！
user.validation.username.exists	您输入的账号已注册！
user.validation.email.exists	您输入的邮箱已注册！
user.send-captcha.phone.error	您填写的手机号不正确
user.send-captcha.email.error	您填写的邮箱不正确
user.validate-password.incorrect	密码错误
user.validation.tow-password.incorrect	您输入的两次密码不一致
hiam.warn.user.defaultTenantIncorrect	您选择的租户必须与您的当前租户一致
hiam.warn.user.notFound	您操作的用户不存在
hiam.warn.user.assignLeastOneRole	请为新创建的用户分配至少一个有效角色
hiam.warn.user.siteGuestRoleNotFound	平台层游客角色不存在，请联系管理员
hiam.warn.user.organizationGuestRoleNotFound	租户层游客角色不存在，请联系管理员
hiam.warn.user.tenantNotFound	所属租户不存在，请联系管理员
hiam.warn.user.loginNameExists	您输入的账号已注册，请重新输入
hiam.error.active_users.reached	有效用户数已达到上限,请联系管理员
hiam.warn.user.emailFormatIncorrect	您输入的邮箱格式不正确
hiam.warn.user.phoneFormatIncorrect	您输入的手机格式不正确
hiam.warn.user.endDateBiggerThenStartDate	有效日期止必须大于有效日期起
hiam.warn.user.parameterNotBeNull	参数 {0} 不能为空
hiam.warn.roleNotFoundForCode	角色编码[{0}]对应的角色不存在
```


**登录用户-修改手机** <br />
**** <br/>
**** <br/>
### Swagger测试服务
**** <br/>
**** <br/>
**** <br/>
**** <br/>
### 平台基础服务
**** <br/>
**** <br/>
**** <br/>
**** <br/>
### 消息服务
### 调度服务
### 通用导入服务
### 接口服务
### 数据分发服务
### 新版工作流服务
### 审计监控服务
### 报表服务
### 内容提取
### 即时通讯
### 支付服务
### 发票服务
### 前端服务




## 部署配置


## 用户手册

## 开发规范

## 开发指引

## 平台组件

## HZERUI

## Q&A

## 版本更新