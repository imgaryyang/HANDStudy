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

#### IAM特殊接口介绍
##### 数据处理及初始化接口
在新部署环境或升级服务完成后，由于有些数据不是从界面维护，导致某些字段不能自动生成，需调用IAM服务的初始化接口进行一些初始化操作。

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191015140307343-1021739586.png)

- [GET /v1/init/cache-user]
缓存用户信息到 Redis

- [GET /v1/init/menu-level-path]
初始化菜单层级路径(h_level_path)，如果发现有些 level_path 不正确，可以直接将本列清掉并调用该接口重新生成。

- [GET /v1/init/role-level-path]
初始化角色层级路径(h_level_path、h_inherit_level__path)，如果发现有些 level_path 不正确，可以直接将这两列清掉并调用该接口重新生成。

- [GET /v1/init/super-role-permission-sets]
将权限集分别分配到平台超级管理员和租户超级管理员上。



##### 权限刷新接口
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191015141818980-868646855.png)

- [POST /v1/permission/cache/{serviceName}]
传入服务名，缓存服务权限，此操作会删除缓存中旧的权限，重新刷新。权限缓存到网关服务所在的 Redis database 下，网关默认 redis.database=4，如果修改了此配置，确保在IAM服务中加入 `hzero.service.gateway.redis-db=xx。

服务报错 PERMISSION_MISSMATCH 错误时，可先检查 Redis 缓存中是否存在访问的API，如果没有可调用此接口手动缓存服务权限。

- [POST /v1/permission/fresh/{serviceName}]
刷新 iam_permission 权限表中的数据。如果 iam_permission 中不存在访问的API时，可调用此接口手动刷新服务权限。该接口会自动更新缓存。

此接口有两个参数：serviceName 为服务名；metaVersion 为 swagger 列表中的 version。version 等于服务配置中的 eureka.instance.metadata-map.VERSION。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016094545057-1847157139.png)


### Swagger测试服务
#### 简介
**概述** <br />
平台开发测试的API文档和调试管理服务

**组件坐标** <br/>
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-swagger</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

**主要功能**  <br />
- API文档测试
- 服务API文档刷新
- API调试

#### 服务配置
```
hzero:
  swagger:
    # swagger 使用的客户端ID
    client: client
    # oauth 服务认证地址，配置此地址才能跳转到 oauth 服务登录认证
    oauth-url: http://dev.hzero.org:8080/oauth/oauth/authorize
    # swagger 上不需要显示的服务
    skip-service: register, gateway, oauth
    # 网关的地址，不要加 http 前缀
    gateway-domain: dev.hzero.org:8080
```

### 平台基础服务（hzero-platform）
`组件编码 hzero-platform`

#### 简介
**概述** <br/>
平台功能基础服务，主要涵盖平台开发支持功能，平台主数据模块、系统管理模块等

**组件坐标** <br/>
- OP版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-platform</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```

- Saas版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-platform-saas</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```

`插件坐标`
HR组织架构(可选用插件)
- OP版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>platform-hr</artifactId>
	<version>${hzero.plugin.version}</version>
</dependency>
```

- Saas版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>platform-hr-saas</artifactId>
	<version>${hzero.plugin.version}</version>
</dependency>
```

**主数据模块（可选用插件）** <br/>
- OP版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>platform-mdm</artifactId>
	<version>${hzero.plugin.version}</version>
</dependency>
```

- Saas版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>platform-mdm-saas</artifactId>
	<version>${hzero.plugin.version}</version>
</dependency>
```

`组织信息模块（可选用插件）`
- OP版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>platform-org</artifactId>
	<version>${hzero.plugin.version}</version>
</dependency>
```

- Saas版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>platform-org-saas</artifactId>
	<version>${hzero.plugin.version}</version>
</dependency>
```

**主要功能** <br/>
- 系统配置
- 值列表维护、值列表视图
- 多语言描述维护
- 编码规则管理
- 配置管理
- 规则引擎
- 数据源、数据库管理


**服务配置管理** <br/>
```
hzero:
  platform:
    init-cache: ${HZERO_PLATFORM_INIT_CACHE:true} # 是否执行Redis初始化
    http-protocol: ${HZERO_PLATFORM_HTTP_PROTOCOL:http} # 请求协议，可选值：http，https，用于值集、弹性域、个性化等功能
    role-template-codes: # 如果角色继承自列表中的角色，那么该角色可以看到分配到列表中角色的卡片
      - role/organization/default/administrator
    regist-entity: 
      enable: true # 开启实体类的注册
  data:
    permission:
      db-owner: ${HZERO_DB_OWNER:} # 数据库所有者模式，例如在MSSQL下数据库前缀拼接规则为：db-prefix.db-owner.table-name
```


### 文件服务（hzero-file）
`服务简码HFLE`
`默认端口 8100`
`组件编码 hzero-file`

#### 简介

**概述** <br/>
对接多种云存储、本地存储的文件管理服务，并能够通过配置，对文件上传进行控制

**组件坐标** <br/>

- OP版本
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-file</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

- Saas版本
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-file-saas</artifactId>
    <version>${hzero.service.version}</version>
</dependency>

```

**主要功能** <br />
- 文件存储配置
- 文件上传控制
- 文件汇总查询
- 文件在线编辑
- 文件变更记录

**服务配置参数** <br/>
```
# 租户允许的最大存储容量,String类型,单位允许MB和KB,   默认值 10240MB  
hzero.file.maxCapacitySize

# 文件授权url的有效访问时间,Long类型,默认值300L
hzero.file.defaultExpires

# 华为、百度跨域配置 List<String>  若不设置，表示允许所有跨域
hzero.file.origins

# 文件预览的方式 String类型 允许的值： aspose  kkFileView  onlyOffice
hzero.file.previewType

# kkFileView的文件预览地址，previewType为kkFileView时需要指定
hzero.file.kkFileViewUrl
```

#### 开发指导

##### onlyOffice文件在线编辑
**文件在线编辑搭建documentServer**

`使用Docker安装，镜像文件向平台管理员要`

`导入镜像`
```
# if file suffix is XXXX.tar.gz
docker load < hoffice.tar.gz

# if file suffix is XXX.tar
docker load -i hoffice.tar
```
`使用docker-compose创建容器`

`创建docker-compose.yml 文件，内容如下:`
```
version: '3'
services:
  hoffice:
    container_name: hoffice
    image: hoffice:1.2
    restart: always
    privileged: true
    stdin_open: true
    tty: true
    ports:
      - '8000:8000'
      - '7000:7000'
    environment:
      DOC_SERVER: http://127.0.0.1:8000
    command: /bin/sh -c /root/start.sh
    volumes:
      - "./hoffice/logs:/root/documentserver/logs"
      - "./hoffice/cache:/root/documentserver/server/App_Data"
```

image中的版本根据实际的镜像版本修改，如hoffice:1.2、hoffice:1.1


ports可根据实际情况映射到空闲的端口 DOC_SERVER必须替换为服务器地址，端口与容器中8000端口映射的端口一致，如果使用了代理或https，应设置为代理后的地址 如：通过nginx将hoffice的doc_server服务代理到了 https://www.example.com/hoffice/docserver

则DOC_SERVER应设置为 https://www.example.com/hoffice/docserver

volumes映射的分别为日志文件和缓存文件，如果服务器磁盘不足，可进入容器，执行sh /root/documentserver/shell/clear-cache.sh清除缓存 在docker-compose.yml文件所在目录执行以下命令，创建容器

```
docker-compose up -d
```
`查看Token`
```
token用于服务对接时接口的header中携带
# 进入容器
docker exec -it hoffice /bin/bash 
# 查看token
sh /root/documentserver/shell/token.sh
```

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016101400527-489249195.png)

如果token出现多个，请使用第一个即可

检测服务是否正常启动，可访问如下地址：
```
http://${host}:7000/ // => true

http://${host}:8000/healthcheck // => true
```

查看日志 容器中的日志文件映射到了当前目录的hoffice/logs下，查看日志的方式如下：

```
# doc-server日志
tail -f hoffice/logs/doc-server.log
# server-manager日志
tail -f hoffice/logs/server-manager/server-manager-web.log
# file-converter日志
tail -f hoffice/logs/file-converter.log
```

**版本升级** <br/>
`导入新版本的镜像`
`修改docker-compose.yml中image的版本号`
`执行docker-compose up -d重新构建容器`
`更新应用程序中的token配置`

```
# 进入容器
docker exec -it hoffice /bin/bash 
# 查看token
sh /root/documentserver/shell/token.sh
```

**调整服务的配置文件** <br/>
```
hzero:
  file:
    only-office:
      token: xxxx   # 上面在容器中查到的token
      doc-server-url: http://ip:7000/document   # IP为documentServer的服务ip,端口根据实际映射端口调整
      call-back-prefix: http://xxxxx/hfle/v1/only-office/save # 文件服务提供的回调地址
```

##### 文件预览配置
文件服务支持三种文件预览的方式`Aspose.Words for Java`，`kkFileView`和 `onlyOffice`

- onlyOffice 文件预览
onlyOffice的搭建参考文件在线编辑的说明。

`修改文件服务配置文件`
```
hzero:
  file:
    preview-type: onlyOffice
    converter-url: http://xxxxx:8000/converter   # 搭建的onlyOffice，8000端口的那个服务
```
>说明： onlyOffice预览方式，支持的文件类型:jpeg jpg png doc docm docx dot dotm dotx epub fodt html mht odt ott pdf rtf txt xpscsv fods ods ots xls xlsm xlsx xlt xltm xltx fodp odp otp pot potm potx pps ppsm ppsx ppt pptm pptx
>对于复杂的word格式支持不是太好，但大多数格式还是支持的。

- Aspose
使用Apose需要购买版权，授权文件的放置在文件服务中 classpath:license/license.xml

`修改文件服务配置文件`
```
hzero:
  file:
    preview-type: aspose
```
>说明： 该文件预览方式支持的文件类型较少，目前仅支持：jpeg jpg png doc docx pdf, 但该预览方式对word文件中的一些特殊格式支持很好，对格式要求比较高的推荐使用

- kkFileView
kkFileView是开源免费的，服务搭建参考[官方文档](https://gitee.com/kekingcn/file-online-preview/wikis/pages)

`服务创建完成后，修改文件服务配置文件`
```
hzero:
  file:
    preview-type: kkFileView
    kk-file-view-url: http://xxxxxx:8012/onlinePreview   # kkFileView的文件预览地址
```
>说明： kkFileView预览方式支持的文件类型比较多，字体问题在官方文档也有说明。 kkFileView的文件预览是基于openOffice的，对于复杂的word格式支持不是太好，但大多数格式还是支持的。


### 消息服务（hzero-message）
`服务简码 HMSG`
`默认端口 8120`
`组件编码 hzero-message`

#### 简介
**概述** <br/>
支持短信、邮箱、站内消息发送，并能够灵活管理消息模板和对接云平台支持的微服务

**组件坐标** <br/>
- OP版本
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-message</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

- Saas版本
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-message-saas</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

**主要功能** <br/>
- 模板管理
- 短信账户配置
- 邮箱账户配置
- 消息发送配置

**服务配置参数** <br />
```
# 页面右上角铃铛预览未读消息的数量，默认值5
hzero.message.maxUnreadMessageCount

# 伪装动作：如果为真则不会发送短信到目标用户，默认值false
hzero.message.sms.fakeAction
# 伪装账号
# 如果有值且fakeAction为真，则所有短信都会被拦截发送至该伪装账号
# 如果无值且fakeAction为真，则不会发生发送短信的动作，但是会返回发送成功
hzero.message.sms.fakeAccount
# 伪装账号的国际冠码，默认值 +86
hzero.message.sms.fakeIdd

# 伪装动作：如果为真则不会发送邮件到目标用户，默认值false
hzero.message.sms.fakeAction
# 伪装账号
# 如果有值且fakeAction为真，则所有邮件都会被拦截发送至该伪装账号
# 如果无值且fakeAction为真，则不会发生发送邮件的动作，但是会返回发送成功
hzero.message.sms.fakeAccount
```

#### 开发指导

**邮箱账户配置** <br/>
使用163邮箱时，用户名发送人都要是邮箱账号，邮件才能正常发送

`25端口不可用`
25端口因为各种原因不可用，需要使用465端口。需要添加服务器配置项
```
属性编码	属性值
mail.smtp.socketFactory.class	javax.net.ssl.SSLSocketFactory
mail.smtp.socketFactory.port	465
mail.smtp.ssl.enable	true
```


### 调度服务（hzero-scheduler）
`服务简码 HSDR`
`默认端口 8130`
`组件编码 hzero-scheduler`

#### 简介
**概述** <br/>
调度服务是基于Quartz 2.3.0自研的分布式调度平台，服务端负责任务调度，任务的执行由执行器来完成。该服务具体包含执行器管理、并发任务管理、日志管理以及并发请求等。

**组件坐标** <br/>
- OP版本
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-scheduler</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

- Saas版本
```
<dependency>
	<groupId>org.hzero</groupId>
    <artifactId>hzero-scheduler-saas</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

**主要功能** <br/>
- 执行器管理
- 调度任务管理
- 并发可执行
- 并发请求

**服务配置参数** <br/>
```
# 串行任务锁的自动释放时间，默认值300 ，单位秒
hzero.scheduler.lockTime

# 调度任务告警邮件的发送配置模板编码，默认值：HSDR.SCHEDULER_ALARM
hzero.scheduler.alarmEmail.messageCode
```

#### 开发指导
**quartz配置文件** <br/>
`quartz集群模式配置文件示例`
```
#==============================================================
#Configure Main Scheduler Properties
#==============================================================
org.quartz.scheduler.instanceName = defaultScheduler
# 调度器编号自动生成，集群中编号不可以重复，所以最好设成auto
org.quartz.scheduler.instanceId = AUTO

#==============================================================
#Configure JobStore
#==============================================================
org.quartz.jobStore.class = org.quartz.impl.jdbcjobstore.JobStoreTX
org.quartz.jobStore.driverDelegateClass = org.quartz.impl.jdbcjobstore.StdJDBCDelegate
org.quartz.jobStore.tablePrefix = QRTZ_
# 开启分布式部署
org.quartz.jobStore.isClustered = true
# 分布式节点有效性检查时间间隔，单位：毫秒
org.quartz.jobStore.clusterCheckinInterval = 10000
org.quartz.jobStore.maxMisfiresToHandleAtATime = 10
# 任务等待时间，单位：毫秒
org.quartz.jobStore.misfireThreshold = 30000
org.quartz.jobStore.txIsolationLevelSerializable = true
# 数据库支持for update操作的尽量使用 SELECT * FROM {0}LOCKS WHERE LOCK_NAME = ? FOR UPDATE
org.quartz.jobStore.selectWithLockSQL = SELECT * FROM {0}LOCKS WHERE LOCK_NAME = ?

#==============================================================
#Configure ThreadPool
#==============================================================
org.quartz.threadPool.class = org.quartz.simpl.SimpleThreadPool
org.quartz.threadPool.threadCount = 30
org.quartz.threadPool.threadPriority = 5
org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread = true

#==============================================================
#Skip Check Update
#update:true
#not update:false
#==============================================================
org.quartz.scheduler.skipUpdateCheck = true
```


### 通用导入服务（hzero-import）
`服务简码 HIMP`
`默认端口 8140`
`组件编码 hzero-import`

#### 简介
**通用excel导入服务** <br/>
通用Excel导入服务，支持配置Excel导入模板，上传自动校验规则控制，并插入到数据库等

**组件坐标** <br/>
- OP版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-import</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```

- SaaS版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-import-saas</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```

**主要功能** <br/>
- 模版管理
- 模板下载
- 通用上传界面
- 通用上传封装接口拓展


### 接口服务（hzero-interface）
`组件编码 hzero-interface`

#### 简介
**概述** <br/>
接口平台服务主要提供了服务注册、认证配置、接口透传、协议转换、接口监控、文档配置生成、测试用例、健康状态检查等功能。

**组件坐标** <br/>
- OP版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-interface</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```

- Saas版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-interface-saas</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```

**功能特性** <br/>
`接口配置`
- 服务注册：注册服务、接口，配置服务级别的认证细腻；以及配置接口的运维信息、文档、测试用例等管理信息
- 接口能力汇总: 汇总展示平台通用接口能力以及本租户内的接口能力, 并标识自己所拥有的接口能力; 无权限的接口能力可通过接口文档查看接口信息; 有权限的接口能力可配置不同维度的认证信息。

`接口授权`
- 角色授权：将接口能力授权给角色
- 客户端授权：将角色授权给客户端

`接口运维`
- 接口监控：可监控接口调用详情信息
- 健康状况监控：配置健康检查功能后，可通过此处查看近期健康检查的异常情况。

**前提条件** <br/>
- 依赖hzero-oauth版本0.8.3以上, 影响客户端授权
- 依赖hzero-gateway-helper版本0.8.3以上, 影响HZERO API通过客户端方式调用的校验逻辑
- 依赖hzero-iam前端需要0.8.3以上, 影响HZERO API通过客户端方式调用时的客户端授权
- 本接口平台发布的Rest API当前仅接受两种Content-Type:
	- application/json;charset=UTF-8: 目标API无文件类型的参数。
	- multipart/form-data: 目标API存在文件类型参数的情况
- 依赖客户端组件 
```
<dependency> 
	<groupId>org.hzero.boot</groupId> <artifactId>hzero-boot-interface</artifactId> <version>${hzero.boot.version}</version> </dependency>
```

**安装** <br />
- 首先初始化groovy表结构脚本
- 其次初始化相关基础数据: 值级、值级视图、菜单、权限集、管理员角色权限等基础数据, 参考hzero-resource

- 运行
```
mvn spring-boot:run
```

**使用** <br />
- 功能使用：注册服务并授权即可
- 客户端使用：可通过SDK直接调用平台接口

**约束限制** <br />
- 测试用例尚不支持目标API携带文件类型参数（SDK支持）


### 数据分发服务（hzero-transfer）
#### 功能特性
`初始化`
- 初始化时自动同步表结构
- 仅初始化表结构
- 单库历史数据初始化

`同步类型`
- 单表变更同步
- 单表批量变更同步
- 主表+多语言表变更同步

`同步维度`
- 整张表维度同步
- 租户维度同步

#### 前提条件
- 该服务需要提前部署RocketMQ作为消息队列组件
- 源服务需要安装客户端组件

#### 安装
```
mvn spring-boot:run
```

#### 使用
`源客户端`
- 源服务依赖数据分发客户端
```
<dependency>
	<groupId>org.hzero.boot</groupId>
	<artifactId>hzero-boot-transfer</artifactId>
	<version>${hzero.boot.version}</version>
</dependency>
```
- 配置客户端启用数据分发
```
# application.yml
hzero:
transfer:
monitor:
  enabled: true # 是否启用数据变更监控功能
dataTransfer:
  enabled: true # 是否启用数据变更分发功能
dataAudit:
  enabled: true # 是否启用数据变更审计功能
```
- 初始化数据分发需要的表结构
- 生产事件表: hdtt_producer_event, 数据变更消息首先保存至本地事件表
- 生产事件归档表: hdtt_producer_event_arch, 变更数据同步至服务器端之后的归档

`目标客户端`
- 初始化目标服务表结构
- 消费事件表: hdtt_consumer_event, 数据变更消费前首先同步保存至本地消费事件表
- 消费事件归档表: hdtt_consumer_event_arch, 数据消费成功后归档

`服务器端`
- 运行RocketMQ
- 运行本服务, 提供数据分发服务器端支持
- 配置数据分发基础设置 包括数据分发服务、表、初始化DB信息; 数据消费服务、DB信息、租户信息等。同时, 需要首先做初始化, 初始化后自动启用数据变更消费。

**过程** <br />
术语: 生产DB、消费DB、主表(正式表)、多语言表(正式表)、临时表、备份表


### 新版工作流服务（hzero-workflow-plus）
`组件编码 hzero-workflow-plus`
#### 简介
**概述** <br />
基于Activiti的工作流引擎服务

**组件坐标** <br />
- OP版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-workflow-plus</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```
- SAAS版本
```
<dependency>
	<groupId>org.hzero</groupId>
	<artifactId>hzero-workflow-plus-saas</artifactId>
	<version>${hzero.service.version}</version>
</dependency>
```

**主要功能** <br />
在原工作流的基础上整合配置，修复若干Bug，将编辑器和服务整合在一起

**服务配置参数**  <br />
```
hzero:
  workflow:
    activiti: # 如果没有用到Activiti的Mail组件，该配置可随意配置
      mail-server-host: ${HZERO_WORKFLOW_MAIL_HOST:stmp.163.com} # 邮件发送服务
      mail-server-port: ${HZERO_WORKFLOW_MAIL_PORT:25} # 工发送端口
      mail-server-username: ${HZERO_WORKFLOW_MAIL_USERNAME:hzero@163.com} # 邮件发送账号
      mail-server-password: ${HZERO_WORKFLOW_MAIL_PASSWORD:hzero} # 邮件发送账号密码
      database-type: ${DATABASE_TYPE:mysql} # 数据库类型
      databaseSchemaUpdate: true # 数据库更新模式
      asyncExecutorActivate: true # 开启异步任务
      uppercaseTableName: true # 数据库名称大写，针对TiDB数据库名称大小写无法识别的bug做的兼容，一般可不配置
      requestProtocol: http # 接口定义请求协议，默认http
    engineUrl: ${HZERO_WORKFLOW_SERVICE_URL:http://dev.hzero.org:8080/hwfp} # 流程编辑器中使用的服务地址，网关地址/工作流服务简码
```

### 审计监控服务
`组件编码 hzero-monitor`

#### 简介
**概述** <br />
提供监控审计功能。监控包括服务监控、日志监控、调用链路追踪等监控功能。审计包括数据审计和操作审计。

**组件坐标** <br />
- OP版本
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-monitor</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

- SaaS版本
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-monitor-saas</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

**功能列表** <br />
`操作审计`
```
hzero:
  audit:
    operation:
      enable: false     # 全局开关，默认 false
      api-audit:
        enable: true    # API 审计开关，默认 true，如果全局开关关闭，此值无效
      annotation-audit:
        enable: true    # 注解审计（在Bean的方法上添加@OperationalAudit）开关，默认 true，如果全局开关关闭，此值无效
```

`数据审计`
```
# application.yml
hzero:
  transfer:
    monitor:
      enabled: true # 是否启用数据变更监控功能
    dataAudit:
      enabled: true # 是否启用数据变更审计功能
```


### 报表服务
`服务简码 HRPT`
`默认端口 8210`
`组件编码 hzero-report`

#### 简介
**概述** <br />
通过配置数据集，通过SQL查询方式的平面报表、单据报表、图形报表的服务

**组件坐标** <br />
- OP版本
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-report</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

- Saas版本
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-report-saas</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

**主要功能** <br />
- 数据集管理
- 报表定义
- 报表查询
- 报表模板管理
- 其他报表使用的API

**服务配置参数** <br />
```
# 生成报表时，每页允许的最大数量，默认值100000
hzero.report.maxRows

# 字体文件的文件路径
hzero.report.fontPaths

# 服务使用的文件存储桶的名称
hzero.report.bucketName

# 服务使用的文件存储文件夹的名称
hzero.report.outputDirectory
```

#### 开发指导
**报表数据隔离** <br />
sql中可以使用一些预定义参数来获取当前用户的信息，可用于数据隔离
eg:
```
select user_id, name from user where user_id='${u-userId}'  
```

在数据集管理功能中,以u-开头的自定义参数,不会是被初始化为参数
以下为所有预定义参数:
```
字段名	含义
u-userId	当前用户Id
u-language	当前会话语言
u-roleId	当前角色Id
u-roleIds	当前会话可访问的角色集合
u-tenantId	当前租户
u-tenantIds	当前会话可访问的租户集合
u-organizationId	所属租户
```

**定义模板列表** <br />
- HTML模板 报表的格式要求不高时建议使用此类型模板
```
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
<meta charset="utf-8" /> 
<style> 
	 body{ padding:0; margin:0; font-family:SimHei;} 
</style>
</head>
<body>
	<table cellpadding="0" cellspacing="0" border="1">
		<thead>
			<tr align="center">
				<th width="300px">公司名称</th>
				<th width="200px">公司编码</th>
				<th width="100px">汉得</th>
				<th width="100px">中台</th>
				<th width="100px">产品</th>
			</tr>
		</thead>
		#foreach( $elem in $DATA)
		<tbody>
			<tr class="hreport-row">
				<td class="hreport-fixed-column">${elem.COMPANY_NAME}</td>
				<td class="hreport-fixed-column">${elem.COMPANY_NUM}</td>
				<td><font color="red" size="5">帅</font></td>
				<td><font color="green" size="5">到</font></td>
				<td><font color="blue" size="5">爆</font></td>
			</tr>
		</tbody>
		#end
	</table>
</body>
</html>
```

- RTF模板 为了简化模板开发,可以安装offic的BI Publisher插件,[下载地址](https://www.oracle.com/technetwork/middleware/bi-publisher/downloads/index.html)
安装成功后word会新增一个功能如图:
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016134430755-1844325232.png)

```
1.使用数据集的xml示例功能,获取一个可用的xml数据文件
2.点击word中的示例XML,导入数据
3.点击所有字段按钮,即可生成一个最初的rtf模板文件,根据需求调整模板的样式即可
4.offic提供了预览功能,可以导出多种文件格式
```

- EXCEL 模板
EXCEL模板与RTF 模板类似，是在Excel中进行编辑的

需要注意的是: 报表平台的字体默认只支持黑体,若报表打印时,出现乱码,很可能是字体缺失
用户可以自定义需要的字体:
1.将所有需要的字体文件上传至报表服务所在服务器
2.ymal文件中指定字体名称和字体文件的绝对路径

```
hzero:
    report:
        fontPaths:
      		- 宋体|C:\Windows\Fonts\simsun.ttc
```

### 内容提取
`服务简码 HNLP`
`默认端口 8230`
`组件编码 hzero-nlp`

#### 简介
**概述** <br />
自然语言提取。

**组件坐标** <br />
- OP版本
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-nlp</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

- Saas版本
```
<dependency>
	<groupId>org.hzero</groupId>
    <artifactId>hzero-nlp-saas</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

**主要功能** <br />
- 基础数据管理
- 模板管理
- 词语映射
- 内容提取测试

**服务配置参数** <br />
```
# 文本识别接口
nlp.python.url: ${NLP_PYTHON_URL:http://python.hzero.org:5000/text_extract}
# 缓存获取接口
nlp.python.evict: ${NLP_PYTHON_EVICT:http://python.hzero.org:5000/cache_evict}
```

#### 部署指导
**CoreNLP** <br />
`硬件要求：`
```
4GB RAM+
2 Cores+
```
`操作系统:`
```
Centos,Ubuntu等linux发行版
Docker
```
`部署命令:`
```
docker run --name=corenlp -p 9000:9000 -d registry.saas.hand-china.com/hzero/corenlp:1.0
```
容器内监听端口：tcp/9000

**Python NLP** <br />
`硬件要求：`
```
4GB RAM+
4Cores+
```

`操作系统:`
```
Centos,Ubuntu等linux发行版
Docker
```
`部署镜像：`
```
docker run --name=nlp-worker\
 -p 5000:5000\
 -d -e CORE_NLP_HOST=http://192.168.11.167\
 registry.choerodon.com.cn/hzero-hzero/hzero-nlp-worker:0.10.1.RELEASE
```
>通过-p指定外部监听端口号，通过-e 指定环境变量参数，具体参数见下表
容器内监听端口：tcp/5000 也可由WSGI_BIND参数指定

```
WSGI_WORKERS	WSGI web服务器工作线程数，建议不要超过服务器cpu核心数两倍	4
WSGI_BIND	Web服务监听端口	0.0.0.0:5000
CACHE_NUM	内存缓存条目数量，文本识别时所有的内存缓存，根据服务器内存大小调整	60000
CACHE_TTL	内存缓存失效时间，单位是秒	86400
CORE_NLP_HOST	CoreNLP服务host地址	http://localhost
CORE_NLP_PORT	CoreNLP服务端口号	9000
MONGO_URL	mongodb的url	mongodb://user:passsword@172.20.0.201:27017
MONGO_DB	mongodb中的数据库名称	hzero_nlp
REDIS_HOST	redis服务ip	redis.hzero.org
REDIS_PORT	redis端口号	6379
REDIS_DB	redis db号	1
```

### 即时通讯
#### 简介
**概述** <br />

**组件坐标** <br />
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-im</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

**主要功能** <br />
- 群组管理
- 好友管理
- 消息单聊
- 消息群聊


### 支付服务
`服务简码 HPAY`
`默认端口 8250`
`组件编码 hzero-pay`

#### 简介
**概述** <br />
HZERO支付平台，对接了支付宝、微信、银联的支付方式，同时提供额外的支付订单管理与退款订单管理。

**组件坐标** <br />
- OP版本
```
<dependency>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-pay</artifactId>
    <version>${hzero.service.version}</version>
</dependency>
```

**主要功能** <br />
- 支付配置
- 支付订单
- 退款订单

**服务配置参数** <br />
```
# 回调地址根路径  例：http://gateway:8080/hpay/v1/
hzero.pay.callback
```

#### 开发指导
**支付宝支付相关** <br />
- [POST] /v1/{organizationId}/alipay/pay 订单数据支付
```
{
  "paymentAmount": "0.01",                              支付金额
  "currencyCode": "CNY",                                币种
  "paymentCustomer": "12345",                           支付客户
  "paymentSubject": "测试订单",                         商品名称/交易标题/订单标题/订单关键字等
  "paymentDescription": "测试商品",                     商品名称/交易标题/订单标题/订单描述等
  "returnUrl":"http://hzerodevf.saas.hand-china.com",   支付完成后返回的页面，若不指定使用支付配置定义的回调地址
  "merchantOrderNum": "21781782",                       商户支付订单号，单号相同不会创建新订单
  "channelTrxType": "PC",                               渠道事务类型  PC(网页支付)WAP(手机网站支付)APP(APP支付)BAR(条码支付)
  "expireTime":"2019-06-20 10:10:10"                    到期时间
}
```
`响应实例`
```
{
    "code": "success",
    "data": "<form id=\"_alipaysubmit_\" name=\"alipaysubmit\" action=\"https://openapi.alipay.com/gateway.do?app_id=2018110561993668&charset=UTF-8&format=json&method=alipay.trade.page.pay&notify_url=http%3A%2F%2Fhzeronb.saas.hand-china.com%2Fhpay%2Fv1%2F0%2Falipay%2FALIPAY%2Fcallback&return_url=http%3A%2F%2Fhzeronf.saas.hand-china.com&sign=k82GOoztI6SczR8y9JtgQa0ipSCoxqyR%2BMQYgfOMd9wuICViOHj2OfOJ1HgJy1Uz%2F2Qmu8F%2FLsjs4oOr7sIoEhQCW%2FpM4ZVeesS2VBsinEM9l8JSuRNvGPwrUyVHTr2UnrfUr7VeqiOgIQ1vNRG%2F06n%2FeBqMWywRR9XmFz9XCCQrZdT0qEe%2FQT6gJGN8%2BmcZgXifX5LjxJofxupVZ9I%2FZzRMvZOaxw5CB2UAO7w5Q2i%2BbPFbIan1wra%2FeudzTl0klp23FcPTWD6Dt0uNv9s0mV4J%2BZ2QIPS5q9LsLiPZESZeHmWWHJ8CyLNJaFZdQzOQkkxcW81P2AqNpMbMDC%2FJBQ%3D%3D&sign_type=RSA2&timestamp=2019-07-24+11%3A34%3A37&version=1.0\" method=\"post\"><input type=\"hidden\" name=\"biz_content\" value='{\"body\":\"测试商品\",\"out_trade_no\":\"21781783\",\"product_code\":\"FAST_INSTANT_TRADE_PAY\",\"subject\":\"测试订单\",\"total_amount\":\"0.01\"}'/></form><script>document.forms['_alipaysubmit_'].submit();</script>"
}
```

前端根据data中的标签渲染即可得到支付页面
- [GET] /v1/{organizationId}/alipay/pay/{paymentOrderNum} 根据订单号支付

- [POST] /v1/{organizationId}/alipay/pay/qrcode 二维码支付 获取二维码图片

`报文示例`
```
{
  "paymentAmount": "0.01",
  "currencyCode": "CNY",
  "paymentCustomer": "12345",
  "paymentSubject": "支付测试订单",
  "returnUrl":"http://hzerodevf.saas.hand-china.com",
  "merchantOrderNum": "21781782",
  "paymentDescription": "测试支付"
}
```

- [POST] /v1/{organizationId}/alipay/pay/micro 刷卡付，pos主动扫码付款(条码付)
`报文示例：`
```
{
  "paymentAmount": "0.01",
  "currencyCode": "CNY",
  "paymentCustomer": "12345",
  "paymentSubject": "支付测试订单",
  "returnUrl":"http://hzerodevf.saas.hand-china.com",
  "merchantOrderNum": "21781782",
  "paymentDescription": "测试支付"
}
```

- [POST] /v1/{organizationId}/alipay/pay/query 支付查询
`报文示例：`
```
{
  "outTradeNo": "21781782"       商户支付订单号
}
```

- [POST] /v1/{organizationId}/alipay/pay/close 请求关闭交易
`报文示例：`
```
{
  "outTradeNo": "21781782 ",                    商户支付订单号
  "tradeNo": "2019061222001478271043735658"     支付流水号
}
```

- [POST]/v1/{organizationId}/alipay/refund/apply/{paymentOrderNum} 根据订单号申请退款

- [POST] /v1/{organizationId}/alipay/refund 申请退款
`报文示例`
```
{
  "outTradeNo": "21781782",                     商家支付订单号
  "refundAmount": 0.01                          退款金额
}
```

- [POST] /v1/{organizationId}/alipay/refund/query 查询退款

`报文示例：`

```
{
  "outTradeNo": "21781782",                     商家支付订单号
  "tradeNo": "2019061222001478271043735658",    支付流水号
  "refundAmount": 0.01,                         退款金额
  "refundNo": "R02019061319094520800"           退款订单号
}
```

- [POST] /v1/{organizationId}/alipay/download-bill 下载对账单

`报文示例：`

```
{
"billDate":"2019-06-18 13:56:01",               账单时间：具体请查看对应支付平台
"billType":"trade"                              账单类型：具体请查看对应支付平台
}
```
>平台记录的订单数据也可用于对账，但不保证数据的绝对准确！！

#### 通用支付
可以通过channelCode动态指定支付方式， alipay支付宝 wxpay微信 unionpay银联


### 发票服务
`服务简码 HIVC`
`默认端口 8015`
`组件编码 hzero-invoice`

#### 简介
**概述** <br />
通过传入发票六要素，或者发票图片地址，识别发票结构化信息，并完成发票真实性检查。

**主要功能** <br />
- 根据发票六要素手工查验发票
- 根据发票图片识别，并完成发票查验

#### 开发指导
**服务配置** <br />
手动查验的订单号，需要向海马汇购买
```
hzero:
  invoice:
    helios:
      check-order-no: ${HELIOS_CHECK_ORDER_NO:}
```

OCR查验的订单号，需要向海马汇购买
```
hzero:
  invoice:
    helios:
      ocr-order-no: ${HELIOS_OCR_ORDER_NO:}
```

查验使用的接口需要定义在hzero接口平台，以下为接口平台的参数： 接口定义的服务编码
```
hzero:
  invoice:
    interface-config:
      server-code: ${INTERFACE_SERVER_CODE:}
```

接口定义，手工查验接口的编码
```
hzero:
  invoice:
    interface-config:
      check-interface-code: ${INTERFACE_CHECK_CODE:}
```

接口定义，ocr查验接口的编码
```
hzero:
  invoice:
    interface-config:
      ocr-interface-code: ${INTERFACE_OCR_CODE:}
```
>上述配置都是必须的，否则查验功能不能使用。

**发票六要素查验** <br />
`POST /v1/{organizationId}/invoice/check`

传入参数
```
{
    "invoiceTypeNo": "04",
    "invoiceCode": "3100164320",
    "invoiceNo": "59957351",
    "billingDate": "20190306",
    "invoiceAmount": 123,
    "checkCode": "315048"
}
```

`参数说明`
```
字段名	含义
invoiceTypeNo	发票类型代码
invoiceCode	发票代码
invoiceNo	发票号码
billingDate	开票日期
checkCode	校验码后六位
```

`发票类型解释`
```
发票类型代码	类型说明
01	增值税专用发票
02	货运运输业增值税专用发票
03	机动车销售统一发票
04	增值税普通发票
10	增值税普通发票(电子)
11	增值税普通发票(卷式)
14	通行费发票
```

`返回参数`
```
[
  {
    "data": {
      "beginTime": 0,
      "billingTime": 0,
      "checkCode": "string",
      "checkPlatform": "string",
      "detail": "string",
      "deviceNumber": "string",
      "draweeAddressPhone": "string",
      "draweeBankAccount": "string",
      "draweeNo": "string",
      "endTime": 0,
      "fee": 0,
      "feeWithoutTax": 0,
      "invalidStatus": "string",
      "invoiceCode": "string",
      "invoiceGoods": [
        {
          "amount": 0,
          "brandModel": "string",
          "carType": "string",
          "certificateNumber": "string",
          "commodityInspectionNo": "string",
          "count": "string",
          "detailNo": "string",
          "engineNumber": "string",
          "expenseItem": "string",
          "frameNumber": "string",
          "goodsName": "string",
          "importCertificate": "string",
          "invoiceUniqueCode": "string",
          "limitMultiplier": "string",
          "organizationCode": "string",
          "passDateFrom": "string",
          "passDateTo": "string",
          "placeOfOrigin": "string",
          "plateNumber": "string",
          "specificationModel": "string",
          "taxPrice": 0,
          "taxRate": "string",
          "tonnage": "string",
          "unit": "string",
          "unitPrice": 0,
          "vehicleType": "string"
        }
      ],
      "invoiceNo": "string",
      "invoiceTypeNo": "string",
      "payee": "string",
      "payeeAddressPhone": "string",
      "payeeBankAccount": "string",
      "payeeNo": "string",
      "remark": "string",
      "tax": 0,
      "taxAuthorityName": "string",
      "taxAuthorityNo": "string",
      "taxCertificateNumber": "string",
      "taxRate": 0,
      "title": "string",
      "tollType": "string",
      "tollZeroTaxFlag": "string",
      "type": "string"
    },
    "error": "string",
    "errorCode": "string",
    "error_description": "string",
    "message": "string",
    "resultId": 0
  }
]
```

`状态字段`
```
字段名	含义
resultId	查验结果id，存在则表示查验成功
message	查验结果描述
errorCode	公共错误码
```

`发展对象`
```
参数名	类型	说明	备注
beginTime	String	发票的有效期起始时间	无
endTime	String	发票的有效期截止时间	无
type	String	发票的类型，如广东增值税普通发票	无
payee	String	发票的收款方(销售方）	无
fee	Double	发票价税合计金额	无
vatInvoiceCurrencyCode	String	增值税发票币种	无
title	String	发票的抬头	无
billingTime	String	开票时间，为十位时间戳(utc+8)	无
invoiceNo	String	发票号码	无
invoiceCode	String	发票代码	无
feeWithoutTax	Double	不含税金额	无
pdfUrl	String	这张发票对应的 PDF_URL	无
tax	Double	税额,以分为单位	无
reimburseStatus	String	发票报销状态	无
draweeNo	String	购方识别号	无
payeeNo	String	销方识别号	无
draweeAddressPhone	String	购方地址电话	无
payeeAddressPhone	String	销方地址电话	无
draweeBankAccount	String	购方开户行及账号	无
payeeBankAccount	String	销方开户行及账号	无
deviceNumber	String	设备号码	无
invoiceTypeNo	String	发票类型编号	无
invalidStatus	String	作废标志	无
checkCode	String	校验码	无
taxAuthorityName	String	主管税务机关名称	无
taxAuthorityNo	String	主管税务机关代码	无
taxCertificateNumber	String	完税凭证号码	无
remark	String	备注	无
tollType	String	通行费标志	06-可抵扣通行费，07-不可抵扣通行费
tollZeroTaxFlag	String	零税率标志	空:非零税率，1:税率栏位显示“免税”，2:税率栏位显示“不征收”，3:零税率
```

`商品行invoiceGood对象`
```
参数名	类型	说明	备注
invoiceUniqueCode	String	发票code拼接发票号码，一般为发票唯一码	无
goodsName	String	商品/服务名称	无
specificationModel	String	规格型号	无
unit	String	单位	无
count	String	数量	无
unitPrice	String	单价	无
amount	String	金额	无
taxRate	String	税率	无
taxPrice	String	税额	无
organizationCode	String	身份证号码/组织机构代码	无
vehicleType	String	车辆类型	无
brandModel	String	厂牌型号	无
placeOfOrigin	String	产地	无
certificateNumber	String	合格证号	无
commodityInspectionNo	String	商检单号	无
engineNumber	String	发动机型号	无
frameNumber	String	车架号码	无
importCertificate	String	进口证明书号	无
tonnage	String	吨位	无
limitMultiplier	String	限乘人数	无
carType	String	车辆类型	无
plateNumber	String	车牌号	无
passDateFrom	String	通行日期起	无
passDateTo	String	通行日期止	无
detailNo	String	明细编号	无

```

**错误说明** <br />
`公共错误码`
```
errorCode	message	说明
121800	查验成功，发票一致	无
121801	超过该张票当天查验次数	无
121802	发票代码、号码正确，请修改其他参数	无
121708	参数不能为空	无
121803	所查发票不存在	无
121805	超过一年的不能查验	无
121806	日期当天的不能查验	无
121807	发票类型不支持	无
121984	不存在的发票类型	无
121995	发票类型不能为空	无
121993	发票代码不能为空	无
121994	发票代码长度不合法	无
121996	检验码不能为空	无
121997	检验码长度不合法	无
121998	发票号码不能为空	无
121999	发票号码长度不合法	无
121980	开票日期不能为空	无
121981	开票日期格式不合法	无
121982	开票金额不能为空	无
126015	开票金额长度不合法	无
126105	发票代码、号码不规范，请修改后重试！	无
129999	税局系统不稳定，请稍后再试	无
120998	无可用订单	无
```

#### 发票Ocr识别查验
POST /v1/{organizationId}/invoice/ocr/check
`传入参数`
```
{
  "imageURL": "string"
}
```

`参数说明`
```
字段名	含义
imageURL	图片地址
```

`返回参数`
```
[
  {
    "data": {
      "beginTime": 0,
      "billingTime": 0,
      "checkCode": "string",
      "checkPlatform": "string",
      "detail": "string",
      "deviceNumber": "string",
      "draweeAddressPhone": "string",
      "draweeBankAccount": "string",
      "draweeNo": "string",
      "endTime": 0,
      "fee": 0,
      "feeWithoutTax": 0,
      "invalidStatus": "string",
      "invoiceCode": "string",
      "invoiceGoods": [
        {
          "amount": 0,
          "brandModel": "string",
          "carType": "string",
          "certificateNumber": "string",
          "commodityInspectionNo": "string",
          "count": "string",
          "detailNo": "string",
          "engineNumber": "string",
          "expenseItem": "string",
          "frameNumber": "string",
          "goodsName": "string",
          "importCertificate": "string",
          "invoiceUniqueCode": "string",
          "limitMultiplier": "string",
          "organizationCode": "string",
          "passDateFrom": "string",
          "passDateTo": "string",
          "placeOfOrigin": "string",
          "plateNumber": "string",
          "specificationModel": "string",
          "taxPrice": 0,
          "taxRate": "string",
          "tonnage": "string",
          "unit": "string",
          "unitPrice": 0,
          "vehicleType": "string"
        }
      ],
      "invoiceNo": "string",
      "invoiceTypeNo": "string",
      "payee": "string",
      "payeeAddressPhone": "string",
      "payeeBankAccount": "string",
      "payeeNo": "string",
      "remark": "string",
      "tax": 0,
      "taxAuthorityName": "string",
      "taxAuthorityNo": "string",
      "taxCertificateNumber": "string",
      "taxRate": 0,
      "title": "string",
      "tollType": "string",
      "tollZeroTaxFlag": "string",
      "type": "string"
    },
    "error": "string",
    "errorCode": "string",
    "error_description": "string",
    "message": "string",
    "resultId": 0
  }
]
```

`状态字段`
```
字段名	含义
resultId	查验结果id，存在则表示查验成功
message	查验结果描述
errorCode	公共错误码
```

`发票对象`
同上


#### 错误码说明：
`公共错误码`
同上


### 前端服务（hzero-front）
`组件编码 hzero-front`
#### 简介
**概述** <br />
hzero 服务前端

**前端服务依赖版本** <br />
[前端服务依赖源](http://nexus.saas.hand-china.com/content/repositories/hzero-ui/)

```
hzero-front	1.0.0	公共基础依赖
hzero-front-runtime	1.0.0	公共脚手架依赖
hzero-front-hagd	1.0.0	分布式事务模块
hzero-front-hcnf	1.0.0	配置中心模块
hzero-front-hdtt	1.0.0	数据分发模块
hzero-front-hfile	1.0.0	文件服务模块
hzero-front-hiam	1.0.0	IAM模块
hzero-front-himp	1.0.0	导入服务模块
hzero-front-hmsg	1.0.0	消息服务模块
hzero-front-hpay	1.0.0	支付服务模块
hzero-front-hpfm	1.0.0	平台服务模块
hzero-front-hitf	1.0.0	服务注册模块
hzero-front-hrpt	1.0.0	报表服务模块
hzero-front-hsdr	1.0.0	调度服务模块
hzero-front-hsgp	1.0.0	服务治理模块
hzero-front-hwfp	1.0.0	新版工作流模块
hzero-front-hnlp	1.0.0	自然语言处理模块
hzero-front-hmnt	1.0.0	监控审计服务模块
```
>注意：hzero-front-hwfl 服务 最新版本为 0.11.1 后续不再维护； hzero-front-hptl 最新版本为0.11.2, 后续不再维护；

**环境变量：** <br />
```
变量名	含义	构建后需要替换
BASE_PATH	部署在子目录时需要改变。 例如 部署在 /demo/ 下; 则该变量的值为 /demo/	是
CLIENT_ID	hzero 后端进行 OAUTH 认证所需要的客户端参数	是
API_HOST	请求接口的地址	是
WEBSOCKET_HOST	websocket 地址	是
ESLINT	由于在提交的时候已经校验过了 所以这里不执行校验以提升打包速度	否
PLATFORM_VERSION	系统是OP版还是SAAS版	是
IM_ENABLE	IM 功能是否启用，默认不启用	否
IM_WEBSOCKET_HOST	IM WebSocket 地址	否
```
>注意：
>1.  0.11.0及以上版本的 BPM_HOST 和 WFP_EDITOR 两个变量默认使用 API_HOST 配置的值，无需再单独配置。

>2.  IM_ENABLE 环境变量配置 IM 功能是否启用(true/false)，默认是不启用(false)；启用IM功能后，还需配置IM_WEBSOCKET_HOST 设置 websocket地址，才能正常使用IM功能。


## 部署配置
HZERO平台的服务清单，安装部署步骤及相关指导。

### 服务创建
#### 前端项目快速创建
HZERO 微服务应用开发平台链接：http://hzero.saas.hand-china.com/

**创建项目** <br />
- 输入字段：
	- 前端版本: 指定对应前端的大版本号
	- 项目名: 项目的名字(不能为hzero, 必须为小写字母及中划线), 下载下来的文件名为 项目名-front
    - 新服务名: 指定一个新的服务名, 服务名必须为4位小写字母 且不能以 h开头, 如需以h开头, 需设置为5个字母(包含h)
	- HZERO服务: 需要依赖的 hzero 平台服务, 默认当前版本全部选中
	- 覆盖HZERO服务: 需要覆盖的 平台的服务, 下载后为空服务, 需要去覆盖对应的路由来覆盖平台服务; eg 选中 用户管理(hzero-front-hiam), 创建的服务为 srm-front-hiam


- 2.修改完成后，点击导出文件按钮，即可导出zip包，解压后项目基本不需任何手动处理即可启动测试。
生成的代码结构 

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016150953986-254119077.png)

**服务部署** <br />
前端部署及启动请参考 [开始](http://hzerodoc.saas.hand-china.com/zh/docs/development-specification/font-development-specification/start/)

#### 创建前端项目
##### 环境变量
- node.js: v10.x or v8.x(>= v8.10)
- yarn: 推荐使用yarn管理本项目
```
npm install --global yarn 
```
>关于yarn请参考 https://yarnpkg.com

- lerna: 用于管理具有多个package的JavaScript项目的工具。
```
npm install --global lerna
or
yarn global add lerna
```
- hzero-front-cli: HZERO Front客户端工具,用于创建/更新基于HZERO Front的客户端工具

- HZERO Front npm源地址: http://nexus.saas.hand-china.com/content/groups/hzero-npm-group/

**安装HZERO Front客户端工具: hzero-front-cli** <br />
```
npm install -g hzero-front-cli --registry=http://nexus.saas.hand-china.com/content/groups/hzero-npm-group/
```

安装完成后执行如下命令即可查看HZERO Front客户端工具(hzero-front-cli)的相关命令
```
hzero-front-cli -h
```

##### 创建项目
```
# 命令格式如下
# hzero-front-cli <project name>

# 例如:
$ hzero-front-cli hzero-front-demo
```
由于HZERO Front默认使用了puppeteer Chrome DevTools工具,所以在安装过程中会自动下载Chromium相关,所以可以执行如下命令

使用hzero-front-cli的辅助命令
```
# hzero-front-cli <project name> --puppeteer-skip
$ hzero-front-cli hzero-front-demo --puppeteer-skip
```

##### 新建目录结构
```
.
├── README.md                                                   # 项目说明文档
├── config                                                      # 项目基本配置,包含webpakc相关/路由相关/测试相关/样式相关
│   ├── alias.js                                                # webpack.config别名alias配置
│   ├── env.js                                                  # node.js环境变量配置
│   ├── jest                                                    # jest单元测试工具配置文件
│   │   ├── cssTransform.js
│   │   └── fileTransform.js
│   ├── paths.js                                                # 静态文件路径配置文件
│   ├── routers.js                                              # 项目菜单路由配置文件
│   ├── theme.js                                                # 默认样式配置文件
│   ├── webpack.config.js                                       # webpack默认配置文件
│   ├── webpack.dll.config.js                                   # webpack dll插件配置文件
│   └── webpackDevServer.config.js                              # webpack dev server开发者模式配文件
├── dll                                                         # webpack dll静态资源输出目录
│   └── ...
├── lerna.json                                                  # lerna多package JavaScript项目管理配置文件
├── mock                                                        # mock静态数据服务配置相关
│   └── index.js
├── package.json                                                # 本项目配置node.js 配置文件
├── packages
├── public                                                      # 公共静态资源目录
│   ├── ...
│   └── index.html                                              # 本项目主页面html文件
├── scripts
│   ├── build.js                                                # 生产环境编译脚本文件
│   ├── start.js                                                # 项目开发者模式dev server启动脚本文件
│   └── test.js                                                 # 单元测试脚本工具
├── src
│   ├── index.js                                                # 项目入口文件
│   ├── index.less                                              # 项目全局样式
│   ├── models                                                  # 项目数据模型
│   │   └── global.js                                           # 全局数据模型
│   ├── router.js                                               # 路由管理逻辑文件
│   ├── routes                                                  # 项目核心业务逻辑/页面 
│   │   └── index.js                                            # 页面入口文件
│   ├── serviceWorker.js                                        # 静态缓存service worker
│   ├── setupProxy.js                                           # mock静态数据代理服务器配置文件
│   └── utils                                                   # 项目业业务逻辑通用方法 
│       ├── getModuleRouters.js                                 # hzero-front相关模块依赖注册
│       └── router.js                                           # 路由控制逻辑文件
└── yarn.lock                                                   # 项目yarn node.js模块配置文件 
```
##### 启动项目
请确保dll静态资源已编译完成,否则请执行如下命令
```
$ yarn build:dll
```
>请注意dll无需频繁编译,若有新的依赖安装,且需要加入config/webpack.dll.config.js配置中,则需要重新编译dll

执行如下命令即可启动项目
```
$ yarn start
```
>启动成功后,请访问如下地址即可     http://localhost:8000
```
cross-env BASE_PATH=/ CLIENT_ID=localhost BPM_HOST=http://192.168.12.103:8330 API_HOST=http://hzeronb.saas.hand-china.com WEBSOCKET_HOST=ws://172.20.0.202:8260 HARD_SOURCE=none node --max_old_space_size=4096 ./node_modules/roadhog/bin/roadhog.js dev
```

start 会设置几个环境变量, 您可以改变他们来适应自己的项目
```
BASE_PATH: 部署在子目录时需要改变。 例如 部署在 /demo/ 下; 则该变量的值为 /demo/
CLIENT_ID: 是hzero后端所需要的客户端参数
BPM_HOST: 工作流的接口地址
API_HOST: 请求接口的地址
WEBSOCKET_HOST: websocket 地址
```
#### 下载压缩包之后 执行命令 运行项目

```
npm install or yarn add ./packagejson  安装依赖
yarn --registry http://nexus.saas.hand-china.com/content/groups/hzero-npm-group/

yarn build:dll

yarn transpile:prod

yarn start
```

#### 初始化项目
执行如下命令即可重新安装项目依赖
```
$ yarn --registry http://nexus.saas.hand-china.com/content/groups/hzero-npm-group/
```
请注意npm源地址

若使用了lerna工具管理packages,则需要为packages安装依赖,在项目根目录下执行如下命令
```
$ lerna bootstrap --registry http://nexus.saas.hand-china.com/content/groups/hzero-npm-group/
```
关于lerna请参考 https://lernajs.io/    关于lerna在HZERO Front/基于HZERO Front的项目中的使用请参考lerna


##### 发布生产环境
请确保dll已编译完成,然后执行如下命令
```
$ yarn build
```

编译完成后在项目根目录下生成静态文件
```
/dist
```

接下来您可以将该静态文件用于nginx/node.js serve/docker等服务器部署

build 会设置几个环境变量, 您可以改变他们来适应自己的项目。


#### 后端项目快速创建 看下面的部分
# Hzero搭建过程
## 1 前提条件
### 1.1 后端条件
```
开发工具
Git
JDK 1.8.0 及以上
maven 3.3 及以上
Docker
IDE
Mysql
Redis
```

#### IDEA配置的注意事项
```
	菜单栏File > Setting打开设置， Editor > Code Style > Line separator (for new lines): Unix and OS X (n).
	确保idea使用utf-8编码.
	安装Docker插件。在File-Settings-Plugins中，搜索Docker integration，点击Install安装，并重启软件加载插件.
	IDEA中配置Docker，在File-Settings-Build，Execution，Deployment-Clouds中，点击加号新建，会自动读取docker信息，直接保存即可.
	安装 Lombok 插件，在File-Settings-Plugins中，搜索Lombok，点击Install安装，并重启软件加载插件.
```

#### 其他软件安装
- 通过docker 启动镜像
```
在本地创建docker-compose的运行路径
编写docker-compose.yaml 文件
打开git bash 执行docker-compose up -d
执行docker ps 或docker-compose ps 查看容器是否启动

```

`mysql_db.cnf`
```
# mysql_db.cnf
[mysqld]
lower_case_table_names=1
character_set_server=utf8
max_connections=500
```

`init_user.sql`
```
/** init_user.sql */
CREATE USER 'hzero'@'%' IDENTIFIED BY "hzero";
CREATE DATABASE IF NOT EXISTS hzero_platform DEFAULT CHARACTER SET utf8;
CREATE DATABASE IF NOT EXISTS hzero_governance DEFAULT CHARACTER SET utf8;
GRANT ALL PRIVILEGES ON hzero_platform.* TO choerodon@'%';\
GRANT ALL PRIVILEGES ON hzero_governance.* TO choerodon@'%';\
FLUSH PRIVILEGES;
```

`docker-compose.yaml`
```
# docker-compose.yaml
version: "3"
services:
  mysql:
    container_name: mysql
    hostname: mysql
    image: registry.cn-hangzhou.aliyuncs.com/choerodon-tools/mysql:5.7.17
    ports:
    - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: root
    volumes:
    - ./mysql/mysql_data:/var/lib/mysql
    - ./mysql/mysql_db.cnf:/etc/mysql/conf.d/mysql_db.cnf
    - ./mysql/init_user.sql:/docker-entrypoint-initdb.d/init_user.sql
    expose:
    - "3306"
    networks:
    - "c7nNetwork"
  redis:
    container_name: redis
    hostname: redis
    image: redis:4.0.11
    ports:
    - "6379:6379"
    expose:
    - "6379"
    networks:
    - "c7nNetwork"
networks:
  c7nNetwork:
    driver: bridge
```
>停止容器通过命令docker-compose down。


### 1.2 前端条件
[Hzero官方前端环境Linux配置文档](http://hzerodoc.saas.hand-china.com/zh/docs/development-guide/front-develop-guid/develop-env/)

```
Git
Node.js 推荐v10.x版本，或者 >v8.10.x版本
yarn
eslint
hzero-front-cli
```

#### 安装工具的命令
```
sudo apt-get update && sudo apt-get install yarn
yarn -v

npm install eslint -g
或者yarn global add eslint
eslint -v

npm install -g hzero-front-cli --registry=http://nexus.saas.hand-china.com/content/groups/hzero-npm-group/
```


#### 安装NodeJS的一些问题
`这里注意需要建立软连接`
```
cd /home/legend/software
tar xf node-v10.16.3-linux-x64.tar.gz nodejs #这里是将解压后的文件名字改为了nodejs
ln -s /home/legend/software/nodejs/bin/npm /usr/local/bin/ 
ln -s /home/legend/software/nodejs/bin/node /usr/local/bin/

npm -v
node -v
```

![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901102117498-1649508586.png)

-----

## 2. HZero项目创建

[推荐使用hzero项目图形化界面创建](http://hzero.saas.hand-china.com/frontCreate/)

### 2.1 前端项目创建
![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901103902239-1933790397.png)

#### 前端项目运行过程
```
解压下载的压缩包

运行以来安装 yarn add package.json 会报错,可以使用 yarn install 来安装

运行 yarn build:dll 编译静态资源文件

运行项目 yarn start

http://localhost:8000
```


#### 修改的参数
```
start 会设置几个环境变量, 您可以改变他们来适应自己的项目
BASE_PATH: 部署在子目录时需要改变。 例如 部署在 /demo/ 下; 则该变量的值为 /demo/
CLIENT_ID: 是hzero后端所需要的客户端参数
BPM_HOST: 工作流的接口地址
API_HOST: 请求接口的地址
WEBSOCKET_HOST: websocket 地址
```

#### 错误截图
![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901095247591-73158127.png)
>没有编译静态资源文件 运行  yarn build:dll


### 2.2 命令行创建前端项目
[文档命令创建项目]((http://hzerodoc.saas.hand-china.com/zh/docs/development-specification/font-development-specification/start/))

```
# 创建新项目
#hzero-front-demo 为新项目名称，--puppeteer-skip 为省略非必需的 puppeteer 依赖的下载
hzero-front-cli hzero-front-demo --puppeteer-skip

# 创建主模块 hzero-front-demo, 项目 hzero-front-demo
cd hzero-front-demo
hzero-front-cli . --create-packages 'hzero-front-demo'

# 创建其他模块 spfm-front-sslm
hzero-front-cli . --create-packages 'hzero-front-demo2'
yarn start
```


### 2.3 后端环境搭建以及项目创建
#### 先维护本机的host文件
```
192.168.xx.xxx db.hzero.org
192.168.xx.xxx redis.hzero.org
192.168.xx.xxx dev.hzero.org
```

[查看后端开发指南操作](http://hzerodoc.saas.hand-china.com/zh/docs/development-guide/backend-develop-guid/)


#### 第一种:创建基于HZERO平台图像化界面创建项目
![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901114026532-1587191082.png)


#### 第二种:创建Maven项目单独配置
```
mkdir -p hzero-todo-service
cd hzero-todo-service
```

`添加项目依赖`
- 添加POM.xml   touch pom.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!--hzero-parent dependency-->
    <parent>
        <groupId>org.hzero</groupId>
        <artifactId>hzero-parent</artifactId>
        <version>0.10.0.RELEASE</version>
    </parent>
    <artifactId>hzero-todo-service</artifactId>

    <dependencies>
        <!--hzero-->
        <dependency>
            <groupId>org.hzero.starter</groupId>
            <artifactId>hzero-starter-core</artifactId>
        </dependency>

        <!-- undertow -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-undertow</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!-- actuator -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <!-- config client -->
        <dependency>
            <groupId>io.choerodon</groupId>
            <artifactId>choerodon-starter-config-client</artifactId>
        </dependency>
        <!-- swagger -->
        <dependency>
            <groupId>io.choerodon</groupId>
            <artifactId>choerodon-starter-swagger</artifactId>
        </dependency>

        <!--resource server-->
        <dependency>
            <groupId>io.choerodon</groupId>
            <artifactId>choerodon-starter-oauth-resource</artifactId>
        </dependency>
    </dependencies>

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

</project>
```


- 添加默认配置文件(根目录执行)
```
mkdir -p src/main/java
mkdir -p src/main/resources
```

- 在resource文件夹中创建 application.yml, bootstrap.yml
```
cd src/main/resources
touch application.yml
touch bootstrap.yml
```
>bootstrap.yml: 存放不会通过环境变量替换和必须在bootstrap中指定的变量。包括项目端口，应用名，hzero-config地址等
 
 >application.yml: 存放项目的基础配置，包含默认的线上数据库连接配置，注册中心地址等，这些变量可以通过profile或者环境变量修改。

`二者区别：bootstrap.yml 在程序引导时执行，应用于更加早期配置信息读取，如可以配置application.yml中使用到参数。application.yml 是应用程序特有配置信息，可以用来配置后续各个模块中需使用的公共参数等。bootstrap.yml 先于 application.yml 加载。`


` bootstrap.yml`
```
server:
  # 服务端口
  port: 8088
management:
  server:
    # 监控管理端口
    port: 8089
  endpoints:
    web:
      exposure:
        # 需要开放的 Actuator 监控端点，默认开放所有
        include: '*'

spring:
  application:
    name: hzero-todo-service
  profiles:
    active: ${SPRING_PROFILES_ACTIVE:default}
  cloud:
    config:
      fail-fast: false
      # 是否启用配置中心
      enabled: ${SPRING_CLOUD_CONFIG_ENABLED:false}
      # 配置中心地址
      uri: ${SPRING_CLOUD_CONFIG_URI:http://dev.hzero.org:8010}
      retry:
        # 最大重试次数
        maxAttempts: 6
        multiplier: 1.1
        # 重试间隔时间
        maxInterval: 2000
      # 标签
      label: ${SPRING_CLOUD_CONFIG_LABEL:}
    inetutils:
      # 本地多网卡时，忽略回环网卡
      ignored-interfaces[0]: lo
      # 本地多网卡时，选择注册的网段
      preferred-networks[0]: 192.168
```

`application.yml`
```
# 日志配置
logging:
  level:
    org.hzero: ${LOG_LEVEL:debug}
    org.apache.ibatis: ${LOG_LEVEL:debug}
    io.choerodon: ${LOG_LEVEL:debug}
```

- 编写TodoApplication类
```
mkdir -p src/main/java/org/hzero/todo
touch src/main/java/org/hzero/todo/TodoApplication.java
```

`TodoApplication.java`
```
package org.hzero.todo;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import io.choerodon.swagger.annotation.Permission;

@SpringBootApplication
@RestController
// 开启资源认证、关闭 Security 安全认证
@EnableChoerodonResourceServer
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @GetMapping
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @ApiOperation(value = "demo")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello hzero!", HttpStatus.OK);
    }
}
```

- 根目录下执行  mvn clean spring-boot:run   启动项目
![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901115127830-803452541.png)

`浏览器输出两个信息,一个简单的Spring boot 应用就已经搭建成功`
![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901115539065-562633198.png)

![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901115650298-588257519.png)

### 2.4 初始化数据库
##### 创建用户
```
CREATE USER 'hzero'@'%' IDENTIFIED BY "hzero";
```

#### 创建数据库
```
CREATE DATABASE todo_service DEFAULT CHARACTER SET utf8;
GRANT ALL PRIVILEGES ON todo_service.* TO hzero@'%';
FLUSH PRIVILEGES;
```
>用户创建成功之后，创建项目对应的数据库，并将新创建的数据库权限赋予用户。

#### 编写表结构对应的groovy脚本
```
mkdir -p src/main/resources/script/db
cd src/main/resources/script/db
touch todo_user.groovy todo_task.groovy
```

`todo_user.groovy`
```
package script.db

databaseChangeLog(logicalFilePath: 'todo_user.groovy') {
    changeSet(id: '2018-11-20-todo_user', author: 'your.email@email.com') {
        createTable(tableName: "TODO_USER") {
            column(name: 'ID', type: 'BIGINT UNSIGNED', remarks: 'ID', autoIncrement: true) {
                constraints(primaryKey: true)
            }
            column(name: 'EMPLOYEE_NAME', type: 'VARCHAR(32)', remarks: '员工名')
            column(name: 'EMPLOYEE_NUMBER', type: 'VARCHAR(32)', remarks: '员工号') {
                constraints(unique: true)
            }
            column(name: 'EMAIL', type: 'VARCHAR(32)', remarks: '邮箱')

            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT", defaultValue: "1")
            column(name: "CREATED_BY", type: "BIGINT", defaultValue: "-1")
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT", defaultValue: "-1")
            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
    }
}
```


`todo_task.groovy`
```
package script.db

databaseChangeLog(logicalFilePath: 'todo_task.groovy') {
    changeSet(id: '2018-11-20-todo_task', author: 'your.email@email.com') {
        createTable(tableName: "TODO_TASK") {
            column(name: 'ID', type: 'BIGINT UNSIGNED', remarks: 'ID', autoIncrement: true) { constraints(primaryKey: true) }
            column(name: 'EMPLOYEE_ID', type: 'BIGINT', remarks: '员工ID') { constraints(nullable:"false") }
            column(name: 'STATE', type: 'VARCHAR(30)', remarks: '状态') { constraints(nullable:"false") }
            column(name: 'TASK_NUMBER', type: 'VARCHAR(60)', remarks: '任务编号') { constraints(unique: true, nullable:"false") }
            column(name: 'TASK_DESCRIPTION', type: 'VARCHAR(240)', remarks: '任务描述')
            column(name: 'TENANT_ID', type: 'BIGINT', remarks: '租户ID') { constraints(nullable:"false") }
            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT", defaultValue: "1")
            column(name: "CREATED_BY", type: "BIGINT", defaultValue: "-1")
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT", defaultValue: "-1")
            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
    }
}
```

#### 初始化表结构
```
touch init-local-database.sh
```

`init-local-database.sh`
```
#!/bin/bash
version="0.10.0.RELEASE"
mkdir -p tool-jar
if [ ! -f bin/choerodon-tool-liquibase.jar ]
then
    curl https://oss.sonatype.org/content/groups/public/io/choerodon/choerodon-tool-liquibase/${version}/choerodon-tool-liquibase-${version}.jar -o ./tool-jar/choerodon-tool-liquibase.jar
fi
java -Dspring.datasource.url="jdbc:mysql://db.hzero.org:3306/todo_service?useUnicode=true&characterEncoding=utf-8&useSSL=false" \
 -Dspring.datasource.username=hzero \
 -Dspring.datasource.password=hzero \
 -Ddata.drop=false -Ddata.init=true \
 -Ddata.dir=./src/main/resources \
 -jar ./tool-jar/choerodon-tool-liquibase.jar
```

>根目录执行   sh ./init-local-database.sh,注意:如果没有配置hosts文件可能会报错,我是改成127.0.0.1 才运行成功的

![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901190703807-893765450.png)

![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901190829784-205673635.png)

![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901190924266-1248616615.png)


### 2.5 应用开发流程
#### 修改项目数据库配置
`修改pom.xml文件增加操作数据库的依赖`
```
<dependency>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-mybatis-mapper</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

`application.yml 文件中添加数据库连接信息`
```
spring:
  datasource:
    url: ${SPRING_DATASOURCE_URL:jdbc:mysql://db.hzero.org:3306/todo_service?useUnicode=true&characterEncoding=utf-8&useSSL=false}
    username: ${SPRING_DATASOURCE_USERNAME:hzero}
    password: ${SPRING_DATASOURCE_PASSWORD:hzero}

# MyBatis Mapper 扫描
mybatis:
  mapperLocations: classpath*:/mapper/*.xml
  configuration:
    mapUnderscoreToCamelCase: true
```
![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901191617489-2035338086.png)

`根目录执行  mvn clean spring-boot:run`
![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190901191955723-1097491328.png)

#### 开发功能步骤
>此 demo 需涉及到 domain 层的 entity、多 entity 的 service、repository 接口类以及 infra 层的 repository 实现类.

- 编写domain-领域模型层
	- 编写entity 实体规范
```
1.实体继承 AuditDomain,AuditDomain包含标准的审计字段

2.使用@Table (javax.persistence.Table) 映射表名

3.使用 @ModifyAudit 注解标明在更新数据时需要更新 lastUpdateDate、lastUpdatedBy 两个审计字段

4.使用 @VersionAudit 注解标明在更新数据时需要更新版本号 objectVersionNumber

5.使用 @ApiModel 注解说明实体含义,在实体类上使用该注解,在 Swagger 文档上就可以看到实体说明。

6.实体主键使用 @Id(javax.persistence.Id)注解标注

7.对于自增张、序列（SEQUENCE）类型的主键,需要添加注解 @GeneratedValue.序列命名规范：表名_S.例如：表SYS_USER对应的序列为 SYS_USER_S.

8.非数据库字段使用 @Transient 注解标注，如果页面用到的非数据库字段比较多，建议使用 DTO 封装数据。

9.所有属性均为private属性,每一个属性需要生成对应的 getter、setter 方法

10.字段名称应根据驼峰命名规则从数据库列名转换过来。例如：数据库列名为 USER_NAME ，则字段名为 userName，特殊字段名称，可以在字段在添加 @Column(name = "xxx")注解，指定数据库列名。

11.不使用基本类型,全部使用基本类型的包装类,如 Long 对应数据库中的 INTEGER,而不是使用 long.不然在数据转换的时候会报错空指针异常.

12.数字类型主键统一采用 Long,金额、数量 等精度严格浮点类型采用 BigDecimal (注意：BigDecimal 在计算、比较方面的特殊性)

13.实体中可以包含一些实体自治的方法，这些方法通常用于对本身的属性做一些计算、操作等
```


- 编写infra-基础设施层
- 编写app-应用层
- 编写api-展现层
- 运行测试


### 服务部署
#### 服务本地安装
##### 基础环境安装
**安装清单** <br />
```
组件	描述	版本
JDK	Java运行环境	1.8.0_172
Nginx	前端代理	1.8.1
Node	JavaScript 运行环境	10.15.0
Docker	应用容器引擎	18.09.0
Docker-Compose	Docker容器编排	1.23.2
Git	源码管理	2.9.4
Maven	项目构建	3.3.9
```

**yum 源更新** <br />
- 进入源目录：cd /etc/yum.repos.d/
- 下载163源：wget http://mirrors.163.com/.help/CentOS6-Base-163.repo
- 把文件里面的`$releasever全部替换为版本号6：sed -i 's#$releasever#6#g' CentOS6-Base-163.repo`
- 清除原有缓存：yum clean all
- 重建缓存，以提高搜索安装软件的速度：yum makecache
- 更新系统：yum update
- gcc等环境安装，后续有些软件安装需要这些基础环境

```
gcc安装：yum install gcc-c++
PCRE pcre-devel 安装：yum install -y pcre pcre-devel
zlib 安装：yum install -y zlib zlib-devel
OpenSSL 安装：yum install -y openssl openssl-devel
```

**Nginx** <br />
- 准备nginx：
	- 下载：# wget http://nginx.org/download/nginx-1.8.1.tar.gz
	- 解压：# tar -zxvf nginx-1.8.1.tar.gz
	- 进入目录：# cd nginx-1.8.1

- 配置nginx：# ./configure --prefix=/usr/src/nginx --with-http_stub_status_module --with-http_ssl_module

- 编译安装：# make && make install
- 查看nginx版本：
	- 进入安装目录：# cd /usr/src/nginx/sbin
	- 查看版本：# ./nginx -v

- 设置开机启动
	- 编辑/etc/rc.local：# vim /etc/rc.local
	- 添加一行：/usr/src/nginx/sbin/nginx，之后，开机会自动启动nginx

- nginx 命令
	- 进入nginx目录：# cd /usr/src/nginx/sbin
	- 启动服务：# ./nginx
	- 停止服务：# ./nginx -s stop
	- 重启服务：# ./nginx -s reopen
	- 重新载入配置文件：# ./nginx -s reload


**Node** <br />
- 准备 Node
	- 下载：# wget https://nodejs.org/dist/v10.15.0/node-v10.15.0-linux-x64.tar.xz
	- 解压：# tar -xvf node-v10.15.0-linux-x64.tar.xz
	- 移动到/usr/local/：# mv node-v10.15.0-linux-x64 /usr/local/node-v10.15.0

- 创建软链接：
```
ln -s /usr/local/node-v10.15.0/bin/node /usr/local/bin/node

ln -s /usr/local/node-v10.15.0/bin/npm /usr/local/bin/npm

ln -s /usr/local/node-v10.15.0/bin/npx /usr/local/bin/npx


验证：
	node -v
	npm -v
	npx -v
```
**Docker** <br />
- 卸载旧版本：# yum remove docker docker-common docker-selinux
- 安装需要的依赖包：# yum install -y yum-utils device-mapper-persistent-data
- 配置稳定仓库：# yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
- 安装：# yum install docker-ce
- 启动docker：# systemctl start docker
- 加入开机启动：# systemctl enable docker
- 验证安装是否成功：# docker -v

**Docker-Compose** <br />
- 安装epel-release依赖：# yum -y install epel-release
- 安装python-pip：# yum -y install python-pip
- 升级pip组件：# pip install --upgrade pip
- 检查pip环境：# pip -V
- 安装docker-compose：# pip install docker-compose
- 检查安装是否成功：# docker-compose -version


**Git** <br />
- 准备Git
	- 下载：wget https://www.kernel.org/pub/software/scm/git/git-2.9.4.tar.gz
	- 解压：tar -zxvf git-2.9.4.tar.gz

- 安装编译Git时需要的包
```
yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel
yum install gcc perl-ExtUtils-MakeMaker
```
- 创建软链：# ln -s /usr/local/git/bin/* /usr/local/bin/
- 删除已有的git：# yum remove git
- 生成 ssh-key：# ssh-keygen -t rsa -C "xxx@hand-china.com"
- 拷贝 id_rsa.pub 的SSH-Key 到 git


**Maven** <br />
- 准备maven
	- 下载：# wget http://mirror.bit.edu.cn/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
	- 解压：# tar -zxvf apache-maven-3.3.9-bin.tar.gz
	- 移动到/usr/local：# mv apache-maven-3.3.9 /usr/local/maven3

- 添加环境变量：# vim /etc/profile，在最后添加如下两行
```
export MAVEN_HOME=/usr/local/maven3
export PATH=$MAVEN_HOME/bin:$PATH
```
- 保存退出后输入命令使配置生效：# source /etc/profile
- 检验是否安装成功：# mvn -v


##### 数据服务安装
**安装清单** <br />
```
组件	描述	版本
Redis	缓存数据库	4.0.2
Mysql	数据库	5.7.17
Minio	对象存储服务	RELEASE.2018-05-25T19-49-13Z
```

**Redis** <br />
- 拉取镜像：# docker pull redis

- 启动容器：# docker run -d -p 6379:6379 --name redis -v /hzero/data-server/redis/data:/data redis

**MySql** <br />
- 拉取镜像：# docker pull registry.cn-hangzhou.aliyuncs.com/choerodon-tools/mysql:5.7.17

数据库配置
设置数据库表名不区分大小写，在 `/hzero/data-server/mysql/mysql_db.cnf` 下新建 `my.cnf` 文件，增加 `lower_case_table_names=1` ，其它配置可自行根据需求添加。

**域名映射** <br />
程序中基于域名映射各个服务器IP地址，因此需要在服务器和本地开发环境 hosts 文件中配置域名映射
```
192.168.xx.xxx db.hzero.org
192.168.xx.xxx redis.hzero.org
192.168.xx.xxx dev.hzero.org
```

##### 表及数据初始化
```
CREATE DATABASE hzero_platform DEFAULT CHARACTER SET utf8mb4;
GRANT ALL PRIVILEGES ON hzero_platform.* TO hzero@'%';
FLUSH PRIVILEGES;
```
[hzero-resource](https://code.choerodon.com.cn/hzero-hzero/hzero-resource/tree/1.0.0.RELEASE)

表结构及初始化数据在 [hzero-resource](https://code.choerodon.com.cn/hzero-hzero/hzero-resource/tree/1.0.0.RELEASE)
 项目下。

groovy：表结构 groovy 脚本
init-data：初始化数据
tool-jar：执行初始化的工具
database-init.sh：执行初始化的脚本


`database-init.sh`
```
#!/usr/bin/env bash
mkdir -p tool-jar
if [ ! -f tool-jar/hzero-tool-liquibase.jar ]
then
    curl http://nexus.saas.hand-china.com/content/repositories/Hzero-Release/org/hzero/tool/liquibase-tool/1.0.0.RELEASE/liquibase-tool-1.0.0.RELEASE.jar -o ./tool-jar/hzero-tool-liquibase.jar
fi

# 指定更新的服务，用下划线分隔
service=hzero_platform
# 更新的 schema
schema=$service
# 更新的目录，Groovy 脚本在 groovy 目录下，Excel 期初数据在 init-data 目录下
dir=init-data/$service/

java -Dspring.datasource.url="jdbc:mysql://db.hzero.org:3306/$schema?useUnicode=true&characterEncoding=utf-8&useSSL=false" \
     -Dspring.datasource.username=hzero \
     -Dspring.datasource.password=hzero \
     -Ddata.drop=false \
	 -Ddata.init=true \
     -Ddata.dir=$dir \
	 -Ddata.update.exclusion=iam_role \
	 -Dlogging.level.root=info \
     -jar tool-jar/hzero-tool-liquibase.jar
```

- 需要替换以下配置
	- spring.datasource.url：数据库连接URL
	- spring.datasource.username：数据库名称
	- spring.datasource.password：数据库密码
	- data.update.exclusion:排除数据更新的表或列
	- service：要初始化或升级的服务，不同的服务需更改此处执行
	- dir：要初始化或升级的脚本路径，不同的数据库需更改此处执行

>注意：表结构和初始化数据是分开执行的，便于服务升级。如果更新表结构，设置 `dir=groovy/$service 即可`；如果更新数据，设置 `dir=init-data/$service` 即可。特别需要注意的是，hzero-iam 服务下的数据分 SaaS 版本和 OP 版本，请选择对应版本的数据初始化。


**默认登录用户** <br />
hzero-iam 的数据初始化好之后，默认的用户名密码为 [admin/Admin@123]，可使用此用户密码登陆系统。

**数据处理** <br />
在`部署后端服务` 完成后，需调用IAM服务的初始化接口进行一些初始化操作。

调用 `data-init-controller [GET /v1/init/super-role-permission-sets]` 将权限集分别分配到平台超级管理员和租户超级管理员上。

>服务初始化前，请先确定项目或产品是使用SaaS版还是OP版，SaaS 版本支持多租户，OP版本没有租户概念。

- 正常情况下依赖于 hzero 的服务进行开发，hzero 服务发新版之后可自行决定是否升级服务。注：所有HZERO服务及组件在发布时都会统一升级一个版本，升级服务时可定一个稳定版本即可。

- 以 hzero-gateway 服务为例，首先创建一个空的工程，一般以产品或编码为前缀命名，如 demo-gateway。

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016182602537-586530847.jpg)

- 修改 pom.xml，可以 hzero-parent 为父 pom，也可自行建一个所属产品或项目的顶级 parent 项目进行统一版本管理，接着引入依赖的服务。

>引用服务坐标时，可在服务清单下找到服务的坐标，SaaS 版本的 artifactId 是以 -saas 结尾的，请注意区分。

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016182735687-589701760.jpg)

```
<parent>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-parent</artifactId>
    <version>1.0.0.RELEASE</version>
</parent>

<dependencies>
    <!-- hzero-gateway -->
    <dependency>
        <groupId>org.hzero</groupId>
        <artifactId>hzero-gateway</artifactId>
    </dependency>

    <!-- eureka-client -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    <!-- config-client -->
    <dependency>
        <groupId>io.choerodon</groupId>
        <artifactId>choerodon-starter-config-client</artifactId>
    </dependency>
    <!-- mysql -->
    <dependency>
        <artifactId>mysql-connector-java</artifactId>
        <groupId>mysql</groupId>
    </dependency>

</dependencies>
```

- 第一次使用需在 pom 中加入HZERO的Maven仓库地址：
```
<repositories>
    <repository>
        <id>HandPublic</id>
        <name>Hand-Public Repository</name>
        <url>http://nexus.saas.hand-china.com/content/repositories/public/</url>
        <releases>
            <enabled>true</enabled>
        </releases>
    </repository>
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

- 从依赖包中复制出配置文件到 resources/ 目录下，主要修改 application.yml 中的一些配置即可。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016182942703-525550501.jpg)

- 修改启动类，加入对应的 @EnableHZeroXxx 注解，会自动扫描依赖服务的包。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016183019943-1914648284.jpg)

- 添加客户端依赖
需自行根据使用的注册中心、配置中心、数据库驱动不同，加入相应的依赖，具体的依赖或配置请参考 [客户端依赖](http://hzerodoc.saas.hand-china.com/zh/docs/installation-configuration/service-config/dependency/)

- 之后就可以运行服务测试了。

##### 部署后端服务
`后端服务`主要包括`基础服务`和`平台通用服务`，因为服务间有依赖，服务需`按一定顺序安装`，可根据下面的列表按装HZero平台必备服务。每个服务可按 `服务初始化` 中的流程创建自己产品或项目的服务。
```
服务	简码	默认端口	描述
hzero-register	HREG	8000	注册中心
hzero-config	HCFG	8010	配置服务
hzero-gateway	HGWY	8080	网关服务
hzero-oauth	HOTH	8020	认证服务
hzero-iam	HIAM	8030	IAM服务
hzero-swagger	HSWG	8050	Swagger测试服务（开发环境可装）
hzero-platform	HPFM	8100	平台服务
```

- 服务都部署成功后，可以查看注册中心上的服务是否都注册成功

注册中心地址：http://dev.hzero.org:8000
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016183359310-1605791201.jpg)

- 访问 swagger 页面，测试API是否可用

Swagger地址：http://dev.hzero.org:8080/swagger/swagger-ui.html

`查看服务列表：`
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016183459824-599000987.jpg)

>例如：找平台服务的API进行测试，首先需要授权，默认会跳转到 oauth 登录页面进行登录授权。之后便可访问API测试。 

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016183558643-1201386175.jpg)
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016183601592-784484266.jpg)


##### 部署前端
- 请确保如下环境变量已配置完成
- 内存:
	- 开发者模式运行内存: >4GB
	- 生产环境编译运行内存: >4GB

- yarn: 推荐使用yarn管理本项目
```
npm install --global yarn 

npm install --global lerna

请注意安装完lerna,在linux服务器可能需要执行如下命令,才能使lerna生效
ln -s /usr/local/node-v10.15.0/bin/yarn /usr/local/bin/yarn ln -s /usr/local/node-v10.15.0/bin/lerna /usr/local/bin/lerna 
```

- 下载源码后，将前端构建脚本 [run.sh](http://hzerodoc.saas.hand-china.com/files/docs/installation-configuration/install/front-run.sh) 放到 hzero-front/ 根目录下。
该脚本会构建项目，然后替换环境变量，其中：
	- BUILD_API_HOST：网关地址
	- BUILD_BPM_HOST：工作流地址
	- BUILD_CLIENT_ID：客户端参数
	- BUILD_WEBSOCKET_HOST：websocket 地址
	- BUILD_PLATFORM_VERSION: OP/SAAS

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016183905821-1209402204.jpg)

- 之后配置客户端的重定向地址，修改 hzero_platform.oauth_client 表，hzero_front_dev ，修改重定向地址为 
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016183949153-2144024422.jpg)

- 修改nginx配置
```
cd /usr/src/nginx/conf
vim nginx.conf
```
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016184043661-1876348936.jpg)

- 启动 nginx：
```
cd /usr/src/nginx/sbin

./nginx
```

- 之后即可访问前端服务，访问前端地址，默认会跳转到登录页面进行登录
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191016184218770-1172336370.jpg)

##### 其他
- 服务的一些通用配置和重要项配置可参考：[服务配置](http://hzerodoc.saas.hand-china.com/zh/docs/installation-configuration/service-config/config/)

- 基础服务的调用链路可参考：[基础服务调用链](http://hzerodoc.saas.hand-china.com/zh/docs/installation-configuration/service-config/service-chain/)

- 前端工程构建脚本的命令说明如下:
由于本项目使用lerna管理项目packages,所以初始化项目请务必执行如下初始化命令,确保主体项目和packages子项目依赖安装正确

执行如下命令,安装本项目packages依赖(即初始化workspace)
```
lerna bootstrap --registry http://nexus.saas.hand-china.com/content/groups/  hzero-npm-group/
```

执行如下命令,安装本项目依赖
```
yarn --registry http://nexus.saas.hand-china.com/content/groups/hzero-npm-group/
```

>在开发模式下,可以执行如下命令可以跳过puppeteer安装过程中下载Chromium
export PUPPETEER_SKIP_CHROMIUM_DOWNLOAD=1 #macos/linux

>`build dll`: 本项目开启`webpack dll`插件,所以在执行`启动/build`操作之前,`请务必执行如下命令`$ yarn build:dll

hzero-front主体工程依赖于packages下的各模块,所以需要编译packages下的各模块,执行如下命令
```
	 yarn transpile:prod
or 
	lerna run transpile
```
最后执行如下命令即可构建用于生产环境的静态资源文件dist
```
 yarn build:production
```

### 服务配置
#### 服务通用配置
几乎每个服务都会有的配置，如端口、服务名、连接信息等配置。

##### 服务端口等配置
```
server:
  # 服务端口
  port: 8030
management:
  server:
    port: 8031
  endpoints:
    web:
      exposure:
        # 需要开放的 Actuator 监控端点，默认开放所有
        include: '*' 

spring:
  application:
    # 服务名
    name: hzero-platform 
  profiles:
     # 激活环境，开发环境设置为 dev 时，支持在返回信息中返回异常栈信息
    active: default
```

##### 数据库连接信息
```
spring:
  ## 数据库连接信息
  datasource: 
    # MySql：jdbc:mysql://db.hzero.org:3306/hzero_platform?useUnicode=true&characterEncoding=utf-8&useSSL=false
    # Oracle：jdbc:oracle:thin:@db.hzero.org:1521:XE
    # SqlServer：jdbc:sqlserver://db.hzero.org:1433;DatabaseName=hzero_platform
    url: jdbc:mysql://db.hzero.org:3306/hzero_platform?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: xxxxx
    password: xxxxx
    hikari:
      # 连接池最小空闲连接数
      minimum-idle: 20
      # 连接池允许的最大连接数
      maximum-pool-size: 200
      # 等待连接池分配连接的最大时长（毫秒）
      connection-timeout: 30000

  # redis 配置  
  redis:
    host: redis.hzero.org
    port: 6379
    database: 1
    jedis:
      pool:
        # 资源池中最大连接数
        # 默认8，-1表示无限制；可根据服务并发redis情况及服务端的支持上限调整
        max-active: 50
        # 资源池运行最大空闲的连接数
        # 默认8，-1表示无限制；可根据服务并发redis情况及服务端的支持上限调整
        # 一般建议和max-active保持一致，避免资源伸缩带来的开销
        max-idle: 50
        # 当资源池连接用尽后，调用者的最大等待时间(单位为毫秒)
        # 默认 -1 表示永不超时，设置5秒
        max-wait: 5000
```


##### 配置中心客户端
```
spring:
  # 配置中心
  cloud:
    config:
      # 是否启用配置中心
      # 若启用，服务启动时会自动向 hzero-config 拉去服务配置信息
      enabled: true
       # 快速失败，为 true 时，如果从配置中心获取配置失败，则无法启动服务
      fail-fast: false
      # 配置中心地址
      uri: http://dev.hzero.org:8010
      # 重试配置
      retry: 
        maxAttempts: 6
        multiplier: 1.1
        maxInterval: 2000
      label: 
```

##### 本地多网卡配置
```
spring:
  cloud:
    inetutils:
      # 设置首选网卡，对于本机有多块网卡的情况，可以设置首选网卡来注册
      # 忽略回环网卡
      ignored-interfaces[0]: lo
      # 选择网段
      preferred-networks[0]: 192.168
```

##### 容器undertow
```
# 服务器配置，使用 undertow 
server:
  undertow:
    # 设置IO线程数, 它主要执行非阻塞的任务,它们会负责多个连接
    # 默认值为8，建议设置每个CPU核心一个线程
    io-threads: 4
    # 阻塞任务线程池, 当执行类似servlet请求阻塞操作, undertow会从这个线程池中取得线程
    # 默认等于 io-threads*8，它的值设置取决于系统的负载，可适当调大该值
    worker-threads: 128
    # 每块buffer的空间大小，越小空间被利用越充分
    # 不要设置太大，以免影响其他应用，合适即可
    buffer-size: 1024
    # 是否分配的直接内存(NIO直接分配的堆外内存)
    # 默认false
    direct-buffers: true
    # HTTP POST请求最大的大小
    # 默认0，无限制，可设置10M
    max-http-post-size: 10485760
```

##### Eureka客户端
```
eureka:
  instance:
    # 以IP形式注册到注册中心，如果为false，将以主机名称注册
    preferIpAddress: true
    # Eureka 客户端向服务端发送心跳的间隔时间
    leaseRenewalIntervalInSeconds: 10 
    # Eureka 服务端在收到最后一次心跳后等待的时间上限
    leaseExpirationDurationInSeconds: 30 
    metadata-map: 
      # 服务版本，在 swagger 中看到的版本号就是此处的版本号
      VERSION: 0.11.0 
  client:
    serviceUrl:
      # 注册中心地址，多个注册中心用逗号隔开
      defaultZone: http://dev.hzero.org:8000/eureka
    # 从 eureka 服务端获取注册信息的间隔时间，单位为秒  
    registryFetchIntervalSeconds: 10 
```

##### 数据库模式
数据库所有者模式，例如 SqlServer 下的 dbo/guest，配置后，自动加上所有者，如：hzero-platform.dbo.fd_icon
```
hzero:
  data:
    permission:
      db-owner: 
```

##### 熔断 & 超时时间设置
```
# zuul 超时时间，仅在网关层设置，可设置大一点
zuul:
  host:
    connect-timeout-millis: 120000
    socket-timeout-millis: 120000

# 是否启用 feign
feign:
  hystrix:
    enabled: true

hystrix:
  threadpool:
    default:
      # 执行命令线程池的核心线程数，也是命令执行的最大并发量；默认10
      coreSize: 1000
      # 最大执行线程数
      maximumSize: 1000
  command:
    default:
      execution:
        isolation:
          thread:
            # HystrixCommand 执行的超时时间，超时后进入降级处理逻辑。 默认 1000 毫秒，最高设置 2000足矣。
            # 如果超时，首先看能不能优化接口相关业务、SQL查询等
            # 不要盲目加大超时时间，否则会导致线程堆积过多，hystrix 线程池卡死，最终服务不可用。
            timeoutInMilliseconds: 40000

ribbon:
  # 客户端读取超时时间，超时时间要小于Hystrix的超时时间，否则重试机制就无意义了
  ReadTimeout: 30000
  # 客户端连接超时时间
  ConnectTimeout: 3000
  # 访问实例失败(超时)，允许自动重试，设置重试次数
  # 失败后会更换实例访问，请一定确保接口的幂等性，否则重试可能导致数据异常。
  OkToRetryOnAllOperations: true
  MaxAutoRetries: 1
  MaxAutoRetriesNextServer: 1
```

##### 服务路由配置
在 config/ 包下建一个 ExtraDataManager 的子类来描述该服务的路由信息。服务注册成功后，hzero-config 会自动刷新路由到数据库，并通知 gateway 服务拉取最新的路由。

- 建议项目上，每个服务自定义一个 ExtraDataManager 的实现类，使用配置的形式注入服务配置，便于开发人员本地开发。
```
@ChoerodonExtraData
public class HiamExtraDataManager implements ExtraDataManager {
    @Autowired
    private org.springframework.core.env.Environment environment;

    @Override
    public ExtraData getData() {
        ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
        choerodonRouteData.setName(environment.getProperty("hzero.service.current.name", "hiam"));
        choerodonRouteData.setPath(environment.getProperty("hzero.service.current.path", "/iam/**"));
        choerodonRouteData.setServiceId(environment.getProperty("hzero.service.current.service-name", "hzero-iam"));
        choerodonRouteData.setPackages("org.hzero.iam");
        extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
        return extraData;
    }
}

# name：表示路由唯一ID，一般用服务简码表示  
# path：表示路由前缀，也可用服务简码表示，前端调用服务API时需加上路由前缀  
# serviceId：服务名称，网关通过路由前缀匹配到服务后，将基于Ribbon请求该服务
# packages: 指定扫描API的包，多个可用逗号分隔，可为空
```

- 本地开发时，则可以在环境变量或本地配置文件中配置带后缀的服务名
```
hzero:
  service:
    current:
      name: hiam-16007
      path: /iam-16007/**
      service-name: hzero-iam-16007
```

>个人本地开发建议服务名加上后缀做区分，如 hzero-platform-16007，同时需要修改 ExtraDataManager 中的路由配置，分别加上后缀，保持配置文件中的服务名和 ExtraDataManager 中配置的服务名一致。

##### 用户访问配置
在服务启动类上，一般都会加上 @EnableChoerodonResourceServer 注解，该注解的主要功能是开启一个过滤器JwtTokenFilter，解析 Jwt_Token，得到用户信息，因此可以在程序中通过 DetailsHelper.getUserDetails() 得到当前访问的用户信息。同时，该过滤器默认对/v1/*接口生效，如果其它前缀的路由也需要用户信息，需手动配置。

```
hzero:
  resource:
    pattern: /v1/*,/v2/*
```

##### 服务名设置
对于继承HZERO开发的服务，如果要修改hzero服务名，需要在所有服务中配置新的服务名称。
HZeroService 里维护了所有HZERO服务的服务简码及名称等信息，服务名称以变量形式表示，对于服务中的Feign调用一般都使用HZeroService里的服务常量表示，因此如果改动了服务名称，需要在配置文件里加上响应的配置。

服务中需要用到服务简码、服务名称、服务RedisDB的情况下，可以使用HZeroService中配置的常量。

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191017092049637-1567195563.jpg)

```
hzero:
  service:
    # 注册中心
    register:
      name: hzero-register
      redis-db: 1
      port: 8000
    # 网关服务  
    gateway:
      name: hzero-gateway
      redis-db: 4
      port: 8080
    # 配置中心  
    config:
      name: hzero-config
      redis-db: 1
      port: 8010
    # 认证服务  
    oauth:
      name: hzero-oauth
      redis-db: 3
      port: 8020
    # IAM 身份服务  
    iam:
      name: hzero-iam
      redis-db: 1
      port: 8030
    # 事务服务  
    asgard:
      name: hzero-asgard
      port: 8040
      redis-db: 4
    # 文档测试服务  
    swagger:
      name: hzero-swagger
      port: 8050
      redis-db: 4
    # 平台服务  
    platform:
      name: hzero-platfor
      port: 8100
      redis-db: 1
    # 文件服务  
    file:
      name: hzero-file
      port: 8110
      redis-db: 1
    # 消息服务  
    message:
      name: hzero-message
      port: 8120
      redis-db: 1
    # 调度服务  
    scheduler:
      name: hzero-scheduler
      port: 8130
      redis-db: 1
    # 导入服务  
    import:
      name: hzero-import
      port: 8140
      redis-db: 1
    # 接口服务  
    interface:
      name: hzero-interface
      port: 8150
      redis-db: 1
    # 数据传输服务  
    transfer:
      name: hzero-transfer
      port: 8180
      redis-db: 1
    # 报表服务  
    report:
      name: hzero-report
      port: 8210
      redis-db: 1
    # 工作流（Plus）  
    workflow-plus:
      name: hzero-workflow-plus
      port: 8220
      redis-db: 1
    # 自然语言处理  
    nlp:
      name: hzero-nlp
      port: 8230
      redis-db: 1
    # 监控服务  
    monitor:
      name: hzero-monitor
      port: 8260
      redis-db: 1
    # 支付服务  
    pay:
      name: hzero-pay
      port: 8250
      redis-db: 1
```


#### 客户端依赖
##### 注册中心
HZERO 注册中心提供多个版本的支持，根据实际使用的注册中心引入相应的依赖和修改对应的配置即可。

###### Eureka版本
`依赖`
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

`配置`
```
eureka:
  instance:
    # 以IP注册到注册中心
    preferIpAddress: ${EUREKA_INSTANCE_PREFER_IP_ADDRESS:true}
    leaseRenewalIntervalInSeconds: 10
    leaseExpirationDurationInSeconds: 30
    # 服务的一些元数据信息
    metadata-map:
      VERSION: 0.10.0
      NODE_GROUP_ID: ${HZERO_NODE_GROUP_ID:0}
      PRODUCT_CODE: ${HZERO_PRODUCT_CODE:DEFAULT}
      PRODUCT_VERSION_CODE: ${HZERO_PRODUCT_VERSION_CODE:DEFAULT}
      PRODUCT_ENV_CODE: ${HZERO_PRODUCT_ENV_CODE:DEFAULT}
      SERVICE_VERSION_CODE: ${HZERO_SERVICE_VERSION_CODE:DEFAULT}
  client:
    serviceUrl:
      # 注册中心地址
      defaultZone: ${EUREKA_DEFAULT_ZONE:http://dev.hzero.org:8000/eureka}
    registryFetchIntervalSeconds: 10
    disable-delta: true
```

###### Zookeeper版本
`依赖`
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
</dependency>
```
`配置`
```
spring:
  cloud:
    zookeeper:
      connect-string: localhost:2181
      discovery:
        enabled: true
        metadata:
          VERSION: 0.10.0
```
>注意：使用过程中需要注意zookeeper的版本对应关系，使用3.4.x版本zookeeper server时，需要先移除3.5.x.beta的zookeeper再引入3.4.x版本的zookeeper。

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.apache.zookeeper</groupId>
    <artifactId>zookeeper</artifactId>
    <version>3.4.12</version>
    <exclusions>
        <exclusion>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

###### Nacos(edas) 版本
`依赖`
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```


`配置`
```
spring:
  cloud:
	nacos:
  	  discovery:
        server-addr: 127.0.0.1:8848
        namespace: 3767dfeb-ec5f-4611-97bb-ee530d19ef89
        metadata:
          VERSION: 0.10.0
```

###### Formula(cnap) 版本
`依赖`
```
<dependency>
    <groupId>com.baidu.formula</groupId>
    <artifactId>discovery-spring-boot-starter</artifactId>
</dependency>
<dependency>
    <groupId>com.baidu.formula</groupId>
    <artifactId>env-core-spring-boot-starter</artifactId>
</dependency>
```

`配置`
```
formula:
  discovery:
    service-url: http://cnapregistry.bj.baidubce.com:443/api/service-center
    customs: 
      VERSION: 0.10.0
```
>注意：在对接cnap的过程中需要注意，目前formula并没有提供ribbon的实现，如果服务中有使用到ribbon相关的功能（如@LoadBalance restTemplate或feign+ribbon），那么需要确保服务引入了spring-cloud-starter-netflix-ribbon。

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
```

#### 配置中心
HZERO 配置中心提供多版本的支持，根据实际使用的配置中心引入相应的依赖和修改对应的配置即可。

##### SpringCloud 版本
`依赖`
```
<dependency>
    <groupId>io.choerodon</groupId>
    <artifactId>choerodon-starter-config-client</artifactId>
</dependency>
```

`配置`
hzero-config 基于 Spring Cloud Config 实现，配置方式是继承Spring Cloud Config的配置方式。

```
spring:
  profiles:
    active: ${SPRING_PROFILES_ACTIVE:default}
  cloud:
    config:
      fail-fast: false
      # 是否启用配置中心
      enabled: ${SPRING_CLOUD_CONFIG_ENABLED:false}
      # 配置中心地址
      uri: ${SPRING_CLOUD_CONFIG_URI:http://dev.hzero.org:8010}
      retry:
        # 最大重试次数
        maxAttempts: 6
        multiplier: 1.1
        # 重试间隔时间
        maxInterval: 2000
      # 标签
      label: ${SPRING_CLOUD_CONFIG_LABEL:}
```

##### Nacos(edas) 版本
`依赖`
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
``` 

`配置`
```
spring:
  profiles:
    active: ${SPRING_PROFILES_ACTIVE:default}
  cloud:
    nacos:
      config:
        server-addr: 127.0.0.1:8848
        namespace: 3767dfeb-ec5f-4611-97bb-ee530d19ef89
```

##### Formula(cnap) 版本
`依赖`
```
<dependency>
    <groupId>com.baidu.formula</groupId>
    <artifactId>config-client-spring-boot-starter</artifactId>
</dependency>
<dependency>
    <groupId>com.baidu.formula</groupId>
    <artifactId>env-core-spring-boot-starter</artifactId>
</dependency> 
```
`配置`

formula-config基于Spring Cloud Config实现，所以配置方式与 Spring Cloud Config的配置方式相似。

```
spring:
  profiles:
    active: ${SPRING_PROFILES_ACTIVE:default}
  cloud:
    config:
      fail-fast: false
      # 是否启用配置中心
      enabled: ${SPRING_CLOUD_CONFIG_ENABLED:true}
      # 配置中心地址
      uri: ${SPRING_CLOUD_CONFIG_URI:http://cnapregistry.bj.baidubce.com:443/api/config}
      retry:
        # 最大重试次数
        maxAttempts: 6
        multiplier: 1.1
        # 重试间隔时间
        maxInterval: 2000
      # 标签
      label: ${SPRING_CLOUD_CONFIG_LABEL:}
```
>注意：必须确保引入了spring-cloud-starter-config-client且开启配置中心，否则会启动失败。 原因：formula目前打包的all依赖formula-cnap依赖了formula-parent，但formula-parent暂未发布，所以无法为我们自动引入spring-cloud-starter-config-client等依赖。

```
spring.cloud.config.enabled: true
```

##### Apollo

简介 apollo本身提供了apollo-client的sdk，但apollo配置中心定位是在Spring、Spring Boot及更轻量的微服务架构中，如果需要整合到Spring Cloud体系中（如网关），则需要用户增强实现一些功能，所以Hzero提供了hzero-starter-apollo-client包来帮助用户将apollo轻松整合到Spring Cloud应用中。

`依赖`
```
<dependency>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-apollo-config</artifactId>
</dependency>
```

`配置`
```
spring:
  cloud:
    apollo:
      config:
        enable: true
        listener:
          interestedKeyPrefixes: zuul.
          interestedKeys: zuul.test.path, zuul.test.service-id
```
>Note: 使用细节可以参考hzero-starter-apollo-client

#### 数据库
>HZERO 至少支持 MySql、TiDB、Oracle、SqlServer 等数据库，根据使用的数据库类型引入不同的数据库驱动


##### MySql、TiDB
`依赖`
```
<dependency>
    <artifactId>mysql-connector-java</artifactId>
    <groupId>mysql</groupId>
</dependency>
```

`数据源配置`
```
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://db.hzero.org:3306/hzero_xxxx?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: hzero
    password: hzero
```

##### Oracle
`依赖`
```
<dependency>
    <groupId>com.oracle</groupId>
    <artifactId>ojdbc7</artifactId>
</dependency>
```

`数据源配置`
```
spring:
  datasource:
    driver-class-name: oracle.jdbc.driver.OracleDriver
    url: jdbc:oracle:thin:@db.hzero.org:1521:XE
    username: hzero
    password: hzero
```

##### SqlServer
`依赖`
```
<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>sqljdbc4</artifactId>
</dependency>
```

`数据源配置`

```
spring:
  datasource:
    driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
    url: jdbc:sqlserver://db.hzero.org:1433;DatabaseName=hzero_xxxx
    username: SA
    password: hzero
```    


### 升级指南
将 HAP3.X 版本升级至 HZERO，并注册为 HZERO 的微服务使用。本文档案例基于 HAP 3.5.6 进行，对应的 HZERO 平台需使用 1.1.0.RELEASE 版本及以上。

后续调整代码会用到一些工具包及源码文件，已上传至汉得网盘，密码请向HZERO平台获取，请提前下载，：[HAP升HZERO相关文件](http://pan.hand-china.com/owncloud/index.php/s/LMc04esar7q6gxE)

## 用户手册
[看官方文档](http://hzerodoc.saas.hand-china.com/zh/docs/user-guide/)


## 开发规范
### 基础开发规范
#### 分支管理
目前比较流行的分支管理模型有三个，即`GitFlow`、`GitLabFlow`、`GitHubFlow`。下面将介绍这三种分支模型的原理，使用场景和优缺点等。

##### GitFlow
该模型中存在两种长期分支：master 和 develop。 master中存放对外发布的版本，只有稳定的发布版本才会合并到master中。 develop用于日常开发，存放最新的开发版本。

也存在三种临时分支：`feature, hotfix, release`。

- feature分支是为了开发某个特定功能，从develop分支中切出，开发完成后合并到develop分支中。

- hotfix分支是修复发布后发现的Bug的分支，从master分支中切出，修补完成后再合并到master和develop分支。

- release分支指发布稳定版本前使用的预发布分支，从develop分支中切出，预发布完成后，合并到develop和master分支中。

**** <br />
- feature 分支使开发代码隔离，可以独立的完成开发、构建、测试

- feature 分支开发周期长于release时，可避免未完成的feature进入生产环境


**缺点：**

- 无法支持持续发布。
- 过于复杂的分支管理，加重了开发者的负担，使开发者不能专注开发。


##### GitHubFlow

## 开发指引

## 平台组件
### 辅助开发包
`组件编码 hzero-starter-core`

#### 简介
**概述** <br />
定义了基础实现类，异常封装，常用工具等。

**组件坐标** <br />
```
<dependency>
     <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-core</artifactId>
    <version>${hzero.starter.version}</version>
</dependency>

```

#### 组件功能
##### base
base 包主要定义了一些基础常量、BaseController 等。
- BaseController：
	- 提供了校验单个对象和集合元素的方法 validObject、validList，只需在 Controller 接口方法里使用这些方法即可对 @NotBlank、@Size、@NotNull 等常用 hibernate-validator 包的校验注解进行校验。
	- 提供了getMessage、getExceptionResponse、locale 等与返回消息相关的便捷方法使用。

- BaseConstants
	- 定义了常用的字段常量：
```
Long DEFAULT_TENANT_ID = 0L;
String PAGE = "0";
String SIZE = "10";
String FIELD_BODY = "body";
String FIELD_CONTENT = "content";
String FIELD_MSG = "message";
String FIELD_FAILED = "failed";
```
>在 Pattern 接口定义了各种格式的日期时间格式常量：interface Pattern {

在 Symbol 接口定义了常用的特殊符号：
```
interface Symbol {
    String SIGH = "!";
    String AT = "@";
    String WELL = "#";
    String DOLLAR = "$";
    String RMB = "￥";
    String PERCENTAGE = "%";
    String AND = "&";
    String STAR = "*";
    String MIDDLE_LINE = "-";
    String LOWER_LINE = "_";
    String EQUAL = "=";
    String PLUS = "+";
    String COLON = ":";
    String SEMICOLON = ";";
    String COMMA = ",";
    String POINT = ".";
    String SLASH = "/";
    String DOUBLE_SLASH = "//";
    String BACKSLASH = "\\";
    String QUESTION = "?";
}

```

- AopProxy
提供self()方法便于获取自身接口代理对象，常用在一个事务方法里调用当前类的其它事务方法，如果不使用代理对象调用方法，本质使用的是原始对象，因而可能导致事务或AOP拦截不生效。 

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191020124100369-692963455.jpg)


##### config
config 包提供了配置工具。

- Configurer：
```
程序中自定义的 Properties 类，可实现该接口。在项目启动时，Configurer 配置器会获取 CustomProperties 子类中配置的属性并缓存起来，在程序运行期间，可通过 Configurer 提供的静态方法根据编码获取对应的配置值，比较方便。但注意Configurer是运行时获取配置属性，不支持编译时获取属性。
```
- Covered/Extended：
```
在依赖扩展开发中，我们一般需要自定义 Covered/Extended 接口，如果完全替换了某个类，需要标识该类为Covered，如果是基于某个类新增了某些功能，需要标识该类为Extended。主要目的在于方便我们知道扩展开发中哪些是继承的，哪些是覆盖的。 一般情况不会使用。
```

##### exception
exception 包提供了基础的异常类，以及全局异常处理器：
- BaseExceptionHandler：异常处理器，拦截各类异常，获取多语言消息，返回 ResponseEntity。
- CheckedException：受检异常类，继承自Exception，程序中需要抛出一定需要捕捉的异常时，可使用该异常类。
- IllegalOperationException：非法操作异常，对于某些不能进入的方法、操作，可直接抛出该异常。
- MessageException：在程序中，某些消息在抛出时已经处理过，不需要异常处理器再去获取多语言消息，可使用该异常，异常处理器会直接将消息返回。
- NotLoginException：未登录异常。
- OptimisticLockException：乐观锁检查异常。

##### util
util 包提供了一些常用的扩展的工具类：
- AssertUtils：Assert 扩展
- CheckStrength：检测密码强度工具
- FieldNameUtils： 驼峰-下划线互转
- EncoderUtils： 对文件名称进行编码，处理一些特殊字符。
- EncryptionUtils：加解密工具类，提供了 MD5、AES、RSA、RSA2 等加密方式
- Reflections： 反射工具类
- Regexs： 正则表达式工具类，提供了常用的正则表达式常量及校验方法
- Results：返回 ResponseEntity 对象
- UUIDUtils：生成UUID
- ValidUtils： 数据校验工具
- EncryptionUtils：加密解密工具类，如：MD5 非对称加密、AES 对称加密、RSA 对称加密、RSA2 对称加密
- Sequence：分布式高效有序ID生产工具
- StringPool：String 相关常量
- SensitiveUtils：敏感信息工具类
- ResponseUtils：响应处理工具类
- PinyinUtils：拼音处理工具类

##### redis
- redis 包提供封装好的 RedisHelper 工具类，可以方便地操作各类redis数据结构。

- 同时，提供了线程安全的支持动态切换 redis database 的 DynamicRedisHelper，DynamicRedisHelper 继承自 RedisHelper，在代码中只需注入 RedisHelper 即可。

- 动态切 redis database 的功能默认开启，可配置 hzero.redis.dynamic-database=false 关闭该功能。

- 在需要切换 database 的地方，调用 redisHelper.setCurrentDatabase(int database) 即可，同时必须调用 redisHelper.clearCurrentDatabase() 清除当前操作 database，否则当前线程将一直使用这个 database ，对于同一个线程内多次 redis 操作可能会有影响。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191020133151760-1007603689.jpg)


##### cache
cache下主要提供了一个功能，使用注解根据配置从缓存中获取值。

- 此功能默认不开启，可配置 hzero.cache-value.enable=true 来开启该功能。

- 使用方式，比如，将用户ID和用户名缓存到redis中，大部分情况下我们只有用户ID，此时我们可以根据用户ID来获取用户名。主要使用到的注解有两个：@CacheValue 和 @ProcessCacheValue。对于某个DTO，有字段用到该功能时，需要实现 Cacheable 接口，标识为可从缓存中取值的对象，这样便于对头行结构中的字段进行处理。

- 如下，DTO中有一个 createdBy 字段，我们需要根据该创建人ID获取到创建人姓名，通过 @CacheValue 来从redis中获取值: key 指定缓存的key，支持占位符的形式；primaryKey指定根据哪个字段匹配；searchKey指定从redis结构中要查找的字段；structure指定redis的数据结构。缓存的数据结构不同，CacheValue的配置也不同，具体可参考源码注释详解。

```
public class DemoDTO implements Cacheable {

private Long createdBy; // 创建人ID

@CacheValue(key = HZeroCacheKey.USER, primaryKey = "createdBy", searchKey = "realName",
        structure = CacheValue.DataStructure.MAP_OBJECT)
private String createdUserName; // 创建人姓名

// getter/setter
}
```
- 配置好后，还需在查询的 service 或 controller 的方法上加上 @ProcessCacheValue 注解，以此进行AOP拦截处理。

##### captcha
captcha 下提供了基础的验证码功能封装。

- 如果需要开启验证码功能，首先需要配置hzero.captcha.enable=true。

- CaptchaProperties：提供了图片验证码和信息验证码的常用配置，如验证码的长宽，验证码来源、过期时间等。对于信息验证码，可配置发送验证码间隔时间(interval)、限制时间内发送次数上限(limitTime)、次数限制在多长时间内(limitInterval)等等。
- CaptchaImageHelper：提供图片验证码功能，调用generateAndWriteCaptchaImage生成图片验证码，会将验证码缓存到redis中，并将 captchaKey 和 captcha 写到 cookie 中。调用checkCaptcha 方法检查验证码正确与否，调用 getCaptcha 方法从缓存中获取验证码。
- CaptchaMessageHelper：用于短信验证码或者邮箱验证码，只用于生成、校验验证码，并不会直接发送验证码，发送验证码可使用hzero-boot-message客户端。该helper主要封装了生成验证码、校验验证码时的各种验证，并返回相应的多语言消息，验证码及各种key、消息都封装到CaptchaResult返回，需要自行处理结果。


##### message
- HZeroCoreMessageSource：hzero-starter-core 默认的 MessageSource，由于在项目中，自动注入的 MessageSource 只能获取到当前 classpath 下的资源文件，无法获取到 jar 包内的资源文件，因此建议每个独立的 jar 包都开发一个独有的 MessageSource 来获取当前 jar 下的资源文件。

- MessageAccessor：获取当前 classpath 下资源多语言的工具，封装 Spring 的 MessageSourceAccessor，提供多种便捷的方法。

- algorithm
常用算法工具
tree(递归构建树)
	- 功能说明：将具有层级结构的数据使用递归关联起来，父对象中会有一个children列表对象来存放子子对象。
	- 使用方式
		- Bean对象继承org.hzero.core.algorithm.tree.Child类，泛型为子对象的类型，也就是当前Bean的类
		- 调用org.hzero.core.algorithm.tree.TreeBuilder.buildTree(...)静态方法构建树
		- List<T> objList ： 该参数为原数据列表
Node<P, T> nodeOperation : 该参数为接口，继承了Key和ParentKey接口，需要自行实现，包含两个方法，getKey()方法用户获取当前节点的Key，getParentKey()用于获取父节点的Key，当前节点的key等于子节点的parentKey()时建立关联关系
		- P rootKey : 该参数为根节点的key，这个参数非必须，但请尽可能提供这个参数，如果不提供，会多遍历一次列表取构建根节点
		- Key<P, T> key : 获取当前节点的key
		- ParentKey<P, T> parentKey : 获取父节点的Key 


- 使用实例
```
class Entity extentds org.hzero.core.algorithm.tree.Child<Entity> {
    Integer id;
    Integer parentId;
    // other field ...
    // getter and setter ...
}

// method
List<Entity> objList = // from anywhere...
List<Entity> result = org.hzero.core.algorithm.tree.TreeBuilder.buildTree(objList, null, Entity::getId, Entity::getParentId)
```

```
[                                                   [
    {                                                   {
        "id":1,                                             "id":1,
        "parentId":null,                                    "parentId":null,
        ...                                                 "children":[{
    },{                                                         "id":2,
        "id":2,                                                 "parentId":1,
        "parentId":1,               ->                          ...
        ...                                                 },{
    },{                                                         "id":3,
        "id":3,                                                 "parentId":1,
        "parentId":1,                                           ...
        ...                                                 }]
    }                                                       ...
    ...                                                 }
]                                                   ]
```


##### structure（自定义数据结构）
- 功能说明：提供一些自定义的数据结构
- 使用说明
	- org.hzero.core.algorithm.structure.LinkedQueue：有序队列，基于LinkedList实现，线程不安全，每次add/append元素之后的数据都是按照顺序排列的，每次插入时使用二分法查找插入的位置。


##### jackson
封装了一些jackson序列化和反序列化的操作，支持Java8时间格式的序列化，使用前需要在Spring Boot启动类上添加`org.hzero.core.jackson.annotation.EnableObjectMapper`注解。

** 忽略时区转换 ** <br />
- 功能说明：默认情况下，所有java.util.Date在序列化和反序列化时会按照当前用户设置的时区对时间进行转换(固定格式yyyy-MM-dd HH:mm:ss)，如果时间不需要做转换，可以使用该功能忽略时区转换。
- 使用说明
	- 序列化和反序列化时忽略时区转换：在字段上添加`@org.hzero.core.jackson.annotation.IgnoreTimeZone`注解
	- 序列化时忽略时区转换：在字段上添加`@com.fasterxml.jackson.databind.annotation.JsonSerialize(using = org.hzero.core.jackson.serializer.IgnoreTimeZoneDateSerializer)`注解
	- 反序列化时忽略时区转换：在字段上添加`@com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = org.hzero.core.jackson.serializer.IgnoreTimeZoneDateDeserializer)`注解

**字符串两端空格过滤 ** <br />
- 功能说明：前端往后端传输数据时，有些字段需要过滤两端空格，例如编码等，添加注解可以在反序列化时过滤掉空格。
- 使用说明：在字段上添加注解`@org.hzero.core.jackson.annotation.Trim`注解，可以指定不同的过滤策略，默认两端过滤，也可以设置左或者右一端。

**敏感信息加密** <br />
- 功能说明：后端往前端传输数据时，有些数据可能需要按照某种规则屏蔽掉敏感信息，例如电话号码中间四位显示“*”。
- 使用说明
	- 在数据返回前端之前，调用org.hzero.core.jackson.sensitive.SensitiveHelper.open()方法，开启敏感信息屏蔽，当前线程内有效，一次序列化之后自动关闭。
	- 在返回Bean的字段上添加@org.hzero.core.jackson.annotation.Sensitive注解，注解中可以指定多种规则取屏蔽敏感信息。
		- left : 从左边开始前 n 位替换
		- right : 从右边开始后 n 位替换
		- cipher : 复杂密文规则，下标从1开始，屏蔽某一位字符直接指定下标即可；屏蔽某一个范围可用下标1-下标2，或者下标1-表示屏蔽某一位及之后所有；多个规则之间可以用,分割，或者用数组形式传递。例如：4-7,9,11-表示第4，5，6，7，9，11以及11之后的位使用加密字符替换
		- clear : 明文规则，使用方式痛cipher，结果相反
		- symbol : 加密字符，默认*
		- reverse : 规则反转，指定cipher/clear时无效。

##### convert
封装了一些自定义的参数转换，可以通过 `hzero.date.converter.enable`配置关闭或开启这些转换器，默认开启。

**Date** <br />
- 功能说明 : 按照用户设置的时区对时间做反序列化，固定格式`yyyy-MM-dd HH:mm:ss`

- 使用说明 : 需要使用`java.util.Date`

**LocalDate** <br />
- 功能说明 : Java8日期类型，仅包含年月日，固定格式`yyyy-MM-dd`
- 使用说明 : 需要使用`java.time.LocalDate`


### 通用开发组件
#### HZERO 父组件
组件编码 `hzero-parent`

##### 简介
**概述** <br />
HZERO产品平台开发项目的Parent组件，所有平台服务、组件项目的父级依赖项目，提供统一的三方应用版本。

**组件坐标** <br />
```
<parent>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-parent</artifactId>
    <version>${hzero.starter.version}</version>
</parent>
```

**特性** <br />
- 通过抽象HZero平台项目的Parent，提供统一的 GroupId
- hzero-parent 父 POM spring-boot-starter-parent-2.0.6.RELEASE，因此项目中使用的 Spring boot 版本为 2.0.6.RELEASE
- 管理通用依赖，统一管理版本，便于后续升级维护，如 SpringBoot、SpringCloud、Choerodon、commons、hzero-starters 等
- 通过版本号 hzero.service.version 统一升级所有服务
- 打包时如果需要跳过spring-boot-maven-plugin插件，使用参数-Dmaven.springboot.skip=true
- 打包时如果需要跳过maven-source-plugin，使用参数-Dmaven.javadoc.skip=true

**使用** <br />
在POM中依赖 hzero-parent

```
<parent>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-parent</artifactId>
    <version>版本号</version>
</parent>
<groupId>org.demo</groupId>
<artifactId>demo-name</artifactId>
```

#### Apollo客户端组件
组件编码 `hzero-starter-apollo-config`

>替换步骤简介:
>去除hzero默认的配置中心hzero-config
>加入apollo-config相关依赖
>加入apollo-config相关配置

**依赖** <br />
```
<dependency>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-apollo-config</artifactId>
</dependency>
```

**配置** <br />
- 在资源根路径下/META-INF文件夹下存在app.properties文件，并指定appId。
```
appId=hzero-gateway
```

- 由于apollo能支持加载bootstrap配置前的配置，所以需要这样去指定：
	- 【开发应用时】idea界面，在运行按钮左侧处编辑运行配置，在VM Options一栏填入-Denv=dev -Dapollo.meta=http://localhost:8080
	- 【部署应用时】在java -jar app.jar -Denv=dev -Dapollo.meta=http://localhost:8080

- 在引导程序上开启apollo配置，并指定namespaces等配置
```
@EnableHzeroApolloConfig({
        "application",
        "application2"
})
```
关于@EnableHzeroApolloConfig的使用，与@EnableApolloConfig使用方式完全一致。

为了便于hzero对apollo-client的增强，所以使用了新的注解@EnableHzeroApolloConfig代替原生的@EnableApolloConfig。

- 在bootstrap.yml文件中可以增加如下配置：
```
spring:
  cloud:
    apollo:
      config:
        # 默认开启
        enable: true
        # 监听配置, 可以筛选监听key
        listener:
          interestedKeys: com.xcxcxcxcx.name
          interestedKeyPrefixes: zuul.
```

这两条配置表示对apollo监听的配置的筛选，如：

interestedKeyPrefixes=zuul.表示仅监听key为“zuul.”开头的配置

interestedKeys=com.xcxcxcxcx.name表示仅监听key为“com.xcxcxcxcx.name”的配置

#### MyBatis 增强组件
`组件编码 hzero-starter-mybatis-mapper`

##### 简介
**概述** <br />
增强ORM框架Mybatis的数据库DML处理能力，支持分页、数据多语言、基于对象的SQL编写，数据防篡改等功能。

**组件坐标** <br />
```
<dependency>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-boot-starter-mybatis-mapper</artifactId>
    <version>${hzero.starter.version}</version>
</dependency>

```

**特性** <br />
- 基于猪齿鱼choerodon-starter-mybatis-mapper组件拓展
- 支持复杂条件查询
- 扩展多语言支持
- 添加数据防篡改功能
- 添加数据加密存储功能
- 添加唯一校验功能

##### 组件功能
**CRUD支持** <br />
新增支持
- int insert(T record) : 插入一条记录
- int insertSelective(T record) ： 插入一条记录，Bean中null的字段不会被插入
- int insertOptional(T record) : 插入一条记录，指定插入的列，插入前调用io.choerodon.mybatis.helper.OptionalHelper#optional(java.util.List<java.lang.String>)方法
- int insertList(List<T> recordList) : 批量插入，如果主键名称不叫id，需要再mapper中重新覆写该方法，在注解中声明主键的名称。
```
@Options(useGeneratedKeys = true, keyProperty = "主键名称")
@InsertProvider(type = SpecialProvider.class, method = "dynamicSql")
int insertList(List<T> recordList);
```

更新支持
- int updateByPrimaryKey(T record) : 根据主键更新实体全部字段，null值会被更新
- int updateByPrimaryKeySelective(T record) ： 根据主键更新属性不为null的值
- int updateOptional(T record) : 更新一条记录，指定更新的列，更新前调用io.choerodon.mybatis.helper.OptionalHelper#optional(java.util.List<java.lang.String>)方法

删除支持
- int delete(T record) : 根据实体属性作为条件进行删除，查询条件使用等号
- int deleteByPrimaryKey(Object key) ： 根据主键字段进行删除，方法参数必须包含完整的主键属性

查询支持
- List<T> select(T record) : 根据实体中的属性值进行查询，查询条件使用等号
- List<T> selectAll() : 查询全表结果，慎用
T selectByPrimaryKey(Object key) : 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
- List<T> selectByIds(String ids) : 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段，多个主键使用,分割
- int selectCount(T record) : 根据实体中的属性查询总数，查询条件使用等号
- T selectOne(T record) : 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
- List<T> selectByCondition(Object condition) : 根据Condition条件进行查询
- int selectCountByCondition(Object condition) : 根据Condition条件进行查询总数

```
mapper.selectByCondition(
    org.hzero.mybatis.domian.Condition.builder(Entity.class)
    .andWhere(
        org.hzero.mybatis.util.Sqls.custom()
            .andEnqualTo(FIELD1, VALUE1)
            .andLike(FIELD2, VALUE2)
    ).build()
);
```

- List<T> selectOptional(T condition, Criteria criteria)：复杂查询，condition参数是查询条件，criteria可以指定查询的列以及一些其他的查询参数，以及排序等。该方法支持多表关联查询，使用关联查询时需要在与其他表的关联字段上添加 `@org.hzero.mybatis.common.query.JoinTable`注解，该注解指定关联的表以及关联方式和关联字段，然后需要在Entity中新建关联表中的字段，并且添加`@org.hzero.mybatis.common.query.JoinColumn`注解，如果字段作为查询条件，必须添加`@Where`注解。

```
// Entity
@Table(name = "hmsg_user_receive_config")
class UserReceiveConfig extends AuditDomain {
    // other field ...
    @Where
    private Long userId;
    @ApiModelProperty(value = "hmsg_receive_config .receiver_code", required = true)
    @JoinTable(name = "receiveConfigJoin", target = ReceiveConfig.class, on = @JoinOn(joinField = ReceiveConfig.FIELD_RECEIVE_CODE))
    private String receiveCode;
    @Transient
    @JoinColumn(joinName = "receiveConfigJoin", field = ReceiveConfig.FIELD_DEFAULT_RECEIVE_TYPE)
    private String defaultReceiveType;
    // getter and setter ...
}

// Entity
@Table(name = "hmsg_receive_config")
class ReceiveConfig extends AuditDomain {
    // other field ...
    private String receiveCode;
    private String defaultReceiveType;
    // getter and setter ...
}

// Repository
userReceiveConfigRepository
    .selectOptional(new UserReceiveConfig().setUserId(1L), 
            new Criteria().select("userReceiveId", "receiveCode", "receiveType", "defaultReceiveType", "userId"));
```
---

```
-- Result SQL
SELECT 
    A.object_version_number, 
    A.user_receive_id, 
    A.receive_code, 
    A.receive_type, 
    B.default_receive_type AS default_receive_type, 
    A.user_id 
FROM 
    hmsg_user_receive_config A 
    INNER JOIN hmsg_receive_config B 
        ON A.receive_code = B.receive_code 
WHERE 
    (A.user_id = ?) 
```


**多语言支持** <br />
- 功能说明
	- 在业务处理中，经常会有有一些数据需要做多语言支持，根据用户选择的语言来动态切换显示内容。使用多语言组件时，提供的查询方法会自动join多语言表，不必开发人员再去手写SQL，自己创建的mapper接口需要自行join多语言表。

- 使用说明
	- 创建表时创建对应的多语言表，多语言表的表明需要在原表明的基础上增加_tl，多语言表中需要包含对应表的主键，以及需要多语言的列，再加上lang varchar(30)字段。
	- 在数据库对应的多语言java实体类上继承io.choerodon.mybatis.domain.AuditDomain类，添加@io.choerodon.mybatis.annotation.MultiLanguage注解，在对应的多语言列上添加@io.choerodon.mybatis.annotation.MultiLanguageField注解
	- 新增/更新数据时，实体类json中需要添加多语言map，结构示例：

```
{
    // other field ...
    _tls:{
    roleName : {
        zh_CN : '管理员',
        en_GB : 'Admin'
    },
    description : {
        zh_CN : '管理员',
        en_GB : 'administrator'
    }
}
}
```

- 如果因为一些特殊需求，`需要在新增或者删除时关闭多语言支持，可以调用org.hzero.mybatis.helper.MultiLanguageHelper#close方法临时关闭多语言支持，在一次mybatis操作之后，恢复启用状态，只在当前线程内生效`。


- 自行创建的mapper方法，在关联多语言时，可以在xml中添加 `<bind name="lang" value="@io.choerodon.mybatis.helper.LanguageHelper@language()"/>` 标签来获取当前用户的语言。

```
<select id="selectEntity" resultType="c.x.Entity">
    <bind name="lang" value="@io.choerodon.mybatis.helper.LanguageHelper@language()"/>
    SELECT
        t.id,
        ttl.multi_lang
        -- other column ..
    FROM table1 t
        JOIN table1_tl ttl ON t.id = ttl.id AND ttl.lang = #{lang}
    WHERE
        -- condition
</select>
```

**数据防篡改** <br />
- 功能说明
```
数据从后端传输到前端之后，在进行更新操作时，经常需要对主键字段做校验，防止恶意篡改主键导致后端数据被破坏，数据防篡改功能将数据主键进行加密，进行数据更新时，对加密信息做校验用来验证主键信息有没有被篡改。多语言支持也是基于数据防篡改实现的。
```

- 使用说明
```
如果是和数据库对应的实体类，只需要继承io.choerodon.mybatis.domain.AuditDomain即可，如果是自定义的VO/DTO，也可以继承AuditDomain类，或者实现 org.hzero.mybatis.domian.SecurityToken接口，接口中的set_token方法用于往VO/DTO中保存加密信息，get_token方法用于获取VO/DTO中保存的加密信息，associateEntityClass方法用于将VO/DTO与数据库对应的实体类关联在一起，需要注意在VO/DTO中必须和实体类主键属性。
```

在更新数据前调用org.hzero.mybatis.helper.SecurityTokenHelper#validToken(..)方法校验主键有没有被篡改。

```
class Entity extends io.choerodon.mybatis.domain.AuditDomain {
    @Id
    private long id;
    // other field ...
    // getter and setter ...
}

class EntityDTO implements org.hzero.mybatis.domian.SecurityToken {
    private long id;
    // other field ...
    // getter and setter ...
    private String _token;
    @Override
    public void set_token(String _token) {
        this._token = _token;
    }
    @Override
    public String get_token() {
        return this._token;
    }
    @Override
    public Class<? extends SecurityToken> associateEntityClass() {
        return Entity.class;
    }
}

// controller
// GET
public ResponseEntity<List<EntityDTO>> selectEntity(...){
    List<EntityDTO> list = // select ...
    return Results.success(list)
}
// PUT
public ResponseEntity<Entity> updateEntity(Entity entity){
    org.hzero.mybatis.helper.SecurityTokenHelper.validToken(entity);
    // update ...
}
```


**数据加密存储** <br />
- 功能说明
有一些保密新比较强的信息需要加密之后保存到数据库，例如配置的用户的邮箱密码，某些其他服务的密钥等，在数据库做加密存储主要是防止数据库信息被盗取导致用户信息泄露。

-  使用说明
	- 在数据库对应的实体类只需要加密的字段上添加`@org.hzero.mybatis.annotation.DataSecurity`注解。

	- 在新增/更新数据之前，调用`org.hzero.mybatis.helper.DataSecurityHelper#open`方法开启数据加密

	- 在查询数据之前，调用`org.hzero.mybatis.helper.DataSecurityHelper#open`方法

	- 加密使用AES加密

**租户条件过滤** <br />
- 功能说明
为了防止Saas模式下的租户功能越权（查询到不属于自己租户的数据），在没有租户参数进行数据过滤控制的情况下，增加了后端通用过滤规则。

- 使用说明
1.注解模式，此模式针对使用平台封装好的查询方法生效。

1.1 在Controller类方法上添加注解@org.hzero.mybatis.annotation.TenantLimitedRequest注解，默认SQL拼装为IN模式，如：

```
WHERE 1 = 1
  AND tenant_id IN (可访问租户ID列表)
```

1.2 设置注解属性TenantLimitedRequest(equal=true)，SQL拼装为=模式，如：
```
WHERE 1 = 1
  AND tenant_id = (当前租户ID)

```

针对自定义Mapper的SQL语句，注解方式不支持自动改写，需要在Mapper中使用bind的方式进行引用


获取可访问租户列表函数，示例：
```
<bind name="__tenantIds" value="@org.hzero.mybatis.helper.TenantLimitedHelper@tenantIds()" />
```

引入后，在使用到的地方进行使用，如：
```
<if test="__tenantIds != null and !__tenantIds.isEmpty()">
  and tenant_id in 
  <foreach colletion="__tenantIds" item="__tenantId" separator="," open="(" close=")">
    #{__tenantId}
  </foreach>
</if>
```


获取当前租户函数，示例：
```
<bind name="__tenantId" value="@org.hzero.mybatis.helper.TenantLimitedHelper@tenantId()" />
```

引入后，在使用到的地方进行使用，如：
```
<if test="__tenantId != null">
  and tenant_id = #{__tenantId}
</if>
```



**数据唯一校验** <br />
- 功能说明
在开发过程中，经常需要到传到后端的数据在数据库中做唯一校验，该功能是对该需求的封装，旨在简化开发过程中重复的工作，降低开发量。


- 声明说明
声明唯一校验字段：在Entity需要校验唯一的字段上添加注解@org.hzero.mybatis.annotation.Unique

调用校验方法：org.hzero.mybatis.helper.UniqueHelper#valid(T)方法，该方法返回一个布尔值，如果返回true表示校验通过，返回false表示数据已存在。

```
Assert.isTrue(UniqueHelper.valid(bank), BaseConstants.ErrorCode.DATA_EXISTS);
```

添加复杂查询selectOptional



### 服务客户端组件


**** <br />


**** <br />
**** <br />
**** <br />
**** <br />


## HZERUI

## Q&A

## 版本更新