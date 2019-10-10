# Hzero官方文档
## 平台概念
### HZERO简介
#### 企业级产品技术中台
```
Hzero是一个企业产品开发平台,是基于Choerodon的基础服务和组件进行拓展,抽象、封装的大量的应用标准服务及功能,避免大量产品和项目重复造轮子带来的成本浪费,Hzero平台主要包含业务中台和数据中台,目标是搭建一个可支持各种产品快速组建、开发的平台,可支持微服务的方便集成、组合重用。
```
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191010090900293-1058311376.png)

```
同时,HZero使用Spring Cloud 作为微服务分布式系统,并且HZero还使用Spring Boot进行了通用性模块的封装,例如鉴权服务、调度服务、消息服务等等;其阿奴按使用React作为开发组件,基于AntD进行二次封装和改造,使之更适合企业级应用系统的使用、
```

#### 为什么要使用HZero?
```
HZero解决了产品研发、项目实施面临的许多重复性工作,降低了交付成本并提高成本效率。同时，统一技术路线,统一开发规范,使基于HZero平台开发的各种产品能够无缝对接,形成融合的产品,降了各自产品技术路线不一直带来的兼容性问题。
```

### 系统架构
#### 逻辑架构
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191010092530323-226016099.png)

**从总体技术架构上主要分为以下4个方面**
- 辅助开发包,主要针对技术开发中进行技术支持,提供了一些通用的技术开发支持功能，减少重复造轮子。定义了基础实现累、异常封装、常用工具等。

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
- **React：**一个用于构建用户界面的JavaScript库
- **AntD Pro：**基于React 的开箱即用的中台前端、设计 解决方案。
- **Node.js：**采用Node 打包、构建前端应用


#### 应用后端
HZERO 的微服务后端采用 Spring Cloud 作为微服务框架,使用 Spring Boot 作为开发脚手架。

核心组件有：
- **Spring Cloud：**Spring Cloud 是一个集成了众多开元的框架，利用Spring Boot 的开发便利实现了服务智力、服务注册与发现、负载均衡、数据监控、REST API 发布方式等，基本囊括了分布式框架所需要的所有功能。是一套易部署、易维护的分布式的开发工具包，如下是hzero用到的一些Spring Cloud的组件
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

- **Spring Boot：**Spring Boot 是由Pivotal 团队 提供的全新框架，其设计目的是用来简化新Spring 应用的初始搭建以及开发过程。该框架使用了特定的方式开进行配置，从而使开发人员不在需要定义样板化的配置。

- **Mybatis：**一款优秀的持久化框架，它支持订花SQL、存储过程以及高级映射。

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
HZERO采用MySQL、Oracle、SQLServer作为关系型数据存储库、Redis作为缓存库

核心组件有：
- **MySQL：**Mysql是最刘赐你个的开源关系型数据库管理系统
- **Oracle：**Oracle 是主流的企业级关系型数据库管理系统。
- **SqlServer：**SqlServer 是主流的企业级关系型数据库管理系统。

- **Redis：**Redis 是一个开源的使用 ANSI C 语言编写、支持网络、可基于内存亦可持久化的日志型、Key-Value 数据库，并提供多种语言的 API。

#### 运行环境
HZERO 可运行在 Docker、VM、Server 上。

核心组件有：
- **Docker：**Docker是一个开源的应用容器引擎,让开发者可以打包他们的应用以及依赖包到一个可移植的容器中，然后发布到任何流行的Linux机器上，也可实现虚拟化。


#### 开发测试
HZERO 采用多个代码检查和测试工具，其中，JUnit、Spock 作为后端 Java 代码的测试工具；Selenium 作为前端测试的工具。

核心组件有：
- **JUnit：**JUnit 是一个 Java 语言的单元测试框架
- **Spock：**Spock 是一个用于Java或Groovy应用的测试框架。
- **Selenium：**Selenium 是一套完整的 web 应用程序测试系统，包含了测试的录制（selenium IDE），编写及运行（Selenium Remote Control）和测试的并行处理（Selenium Grid）。

##### 系统监控
HZERO 利用主流的开源监控工具，从日志、服务运行环境、调用链等进行全面监控，以便在发生问题时能够快速定位和解决问题。

核心组件有：
- **Zipkin：**Zipkin为分布链路调用监控系统,聚合各业务系统调用延迟数据，达到链路调用监控跟踪。
- **Grafana：**Grafana 是一个开箱即用的可视化工具，具有功能齐全的度量仪表盘和图形编辑器，优灵活丰富的图像化选项
- **Promethues： **Promethues是由SoundCloud开发的开元监控报警系统和时序列数据(TSDB)。
- **Micrometer：**Micrometer 是一个监控指标的度量类库。




## 服务列表
**基础组件列表**
- Minio	对象存储服务	RELEASE.2018-05-25T19-49-13Z
- Redis	缓存数据库	    4.0.2
- Mysql	数据库	         5.7.22

**前端版本信息**
```
模块								版本				描述
hzero-front	  					1.0.0			父项目
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

**HZERO 父依赖**
HZERO提供提供统一的版本控制，只需要声明父依赖的版本，项目中只需要添加groupId和artifactId声明就可以了，使用父依赖可以极大的简化项目对HZERO版本的管理。

父项目POM坐标
```
<parent>
    <groupId>org.hzero</groupId>
    <artifactId>hzero-parent</artifactId>
    <version>1.0.0.RELEASE</version>
</parent>
```


**Starter 列表**
以下是HZERO提供的基础依赖信息。
```
hzero-starter-core	1.0.0.RELEASE	基础依赖，用户信息相关和一些工具类

hzero-starter-dynamic-route	1.0.0.RELEASE	动态路由依赖

hzero-starter-export	1.0.0.RELEASE	导出组件依赖

hzero-starter-local-feign	1.0.0.RELEASE	Feign转本地调用依赖

hzero-starter-lock	1.0.0.RELEASE	Redis锁依赖

hzero-starter-mybatis-mapper	1.0.0.RELEASE	通用Mapper依赖

hzero-starter-register-event	1.0.0.RELEASE	服务注册依赖

hzero-starter-websocket	1.0.0.RELEASE	WebSocket依赖

hzero-starter-zuul-ratelimit	1.0.0.RELEASE	网关限流依赖

hzero-starter-apollo-config	1.0.0.RELEASE	阿波罗配置中心客户端依赖

hzero-starter-config-client	1.0.0.RELEASE	配置中心客户端组件

hzero-starter-feign-replay	1.0.0.RELEASE	Feign调用客户端支持组件

hzero-starter-hitoa	1.0.0.RELEASE	JVM监控组件

hzero-starter-integration-sdk	1.0.0.RELEASE	接口平台SDK

hzero-starter-social-core	1.0.0.RELEASE	三方登录核心依赖

hzero-starter-social-qq	1.0.0.RELEASE	三方QQ登录

hzero-starter-social-wechat	1.0.0.RELEASE	三方微信登录
```

**Boot列表**
以下是HZERO提供的客户端依赖信息。
```
hzero-boot-common	1.0.0.RELEASE	公共依赖，服务声明等

hzero-boot-iam	1.0.0.RELEASE	IAM客户端依赖

hzero-boot-file	1.0.0.RELEASE	文件客户端依赖

hzero-boot-import	1.0.0.RELEASE	导入客户端依赖

hzero-boot-message	1.0.0.RELEASE	消息客户端依赖

hzero-boot-platform	1.0.0.RELEASE	平台服务客户端依赖，数据权限，值集等

hzero-boot-scheduler	1.0.0.RELEASE	调度服务客户端依赖

hzero-boot-workflow-plus	1.0.0.RELEASE	新版工作流客户端依赖

hzero-boot-monitor	1.0.0.RELEASE	监控审计客户端

hzero-boot-interface	1.0.0.RELEASE	接口平台客户端依赖

hzero-boot-transfer	1.0.0.RELEASE	数据分发客户端依赖

hzero-boot-tenant	1.0.0.RELEASE	租户初始化客户端依赖

hzero-boot-api-customize	1.0.0.RELEASE	API客制化组件

hzero-boot-data-change	1.0.0.RELEASE	数据变更识别组件

hzero-boot-oauth	1.0.0.RELEASE	OAuth客户端组件

hzero-gateway-helper-api	1.0.0.RELEASE	网关鉴权API客户端

hzero-gateway-helper-default	1.0.0.RELEASE	网关鉴权API客户端默认实现
```

**Plugin 列表**
以下是HZERO提供的插件依赖信息。
```
组件				版本				SaaS和OP说明		描述
platform-mdm	1.0.0.RELEASE	区分		主数据依赖
platform-hr	1.0.0.RELEASE	区分		组织架构依赖
platform-org	1.0.0.RELEASE	区分		业务组织信息依赖
```

**基础服务列表**
>在引用服务依赖时,情趣分Saas版和OP版本；Saas包含多租户的功能，分平台级和租户级，多用于开发产品；OP版本一般用于单租户（无租户概念），只包含租户级功能，多用于开发单系统项目；用Saas还是OP版本取决于你的项目。

以下是主要介绍HZERO平台相关微服务架构下的基础服务信息，可按照如下顺序安装服务。
```
组件				简称		默认端口		描述		SaaS和OP说明		版本
hzero-register	HREG	8000	注册中心		不区分		1.0.0.RELEASE
hzero-config	HCFG	8010	配置服务		区分			1.0.0.RELEASE
hzero-gateway	HGWY	8080	网关服务		不区分		1.0.0.RELEASE
hzero-oauth		HOTH	8020	认证服务		不区分		1.0.0.RELEASE
hzero-iam		HIAM	8030	IAM服务		区分			1.0.0.RELEASE
hzero-swagger	HSWG	8050	Swagger测试服务	不区分	1.0.0.RELEASE

```

**系统服务列表**
以下是主要介绍HZERO平台相关的通用服务信息。
>HZERO前端服务包括了平台所有服务所有的前端功能。
老版工作流服务 `hzero-workflow` 和 `hzero-workflow-editor` 最终版本定为 `0.10.0.RELEASE`，后续不再提供支持，可升级使用 `hzero-workflow-plus`

```
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

**组件仓库**
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
**1.概述**
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

**2.启动类配置**
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

### 配置中心
`组件编码 hzero-config`

#### 简介
**概述**
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

**2.启动类配置**
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

**路由管理**
config 服务有一个重要的功能是服务路由管理，正常情况下，其他服务启动成功并注册到注册中心后，config服务监听到服务注册后，会自动获取服务的文档信息，可惜服务路由信息，并更新到 `hzero_governance 的hsgp_service_routee `表中，在非正常情况下，如果无法自动更新路由，可在`路由管理`功能下手动维护


### 网关服务
`组件编码 hzero-gateway`

#### 简介
**1.概述**
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

**2.启动类配置**
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

**GatewayHelper鉴权**
`1.鉴权过滤器`
GatewayHelper 组件提供了一组过滤器来对API鉴权，具体可参考 [基础服务链路调用](http://hzerodoc.saas.hand-china.com/zh/docs/installation-configuration/service-config/service-chain/)

`2.自定义鉴权`
hzero提供了`hzero-gateway-helper-api` 鉴权接口包 和 `hzero-gateway-helper-default` 默认实现

如果需要对鉴权逻辑进行整体改造，可以通过实现 `org.hzero.gateway.helper.api.AuthenticationHelper ` 接口来完全定制化鉴权部分。

如果仅需要对现有鉴权逻辑新增逻辑，可以实现 `org.hzero.gateway.helper.api.HelperFilter ` 接口来新增鉴权逻辑

`3.权限`
IAM刷新权限，并缓存到网关所在的Redis database 下，网关默认redis。database=4 ，如果要修改此配置，确保在IAM 服务中加入 `hzero.service.gateway.redis-db=xx`。


#### 整体运维
**1.功能说明**
整体运维功能yongyu在服务运维期间提示用户某些服务不可用或全局服务运维，但前提必须保证网关服务可用。运维人员可通过调用网关的运维接口，通过传参设置运维模式和运维信息，或者关闭运维。

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
- #枚举类型：NORMAL、PAUSED、STOPED
	- #分别代表的含义为：正常运行、暂停服务、停止服务(通常用于将要被废弃的服务)
	- hzero.maintain.global-info.state=NORMAL

- 枚举类型如上
	- *表示服务路由前缀，如hzero-oauth独舞的路由前缀为 /oauth  
	- hzero.maintain.service-maintain-info.*.state=NORAM

****
http://hzerodoc.saas.hand-china.com/zh/docs/service/gateway/
### 认证服务
****
****
****
****
****
****

### 事务服务
### IAM服务
### Swagger测试服务
### 平台基础服务
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

##版本更新