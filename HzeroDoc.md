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

### 注册中心
### 配置中心
### 网关服务
### 认证服务
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