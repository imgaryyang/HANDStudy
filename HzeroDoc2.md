接上
####  数据导出组件
##### 简介

**概述** <br />
`hzero-starter-export` 导出组件基于 apache poi 4.0.0 开发，使用 SXSSF 支持大数据量导出，导出格式为*.xlsx。在项目中只需依赖该jar包，再结合三个注解即可完成数据的导出。对于导出Excel样式，提供了两种默认实现，同时支持自定义导出样式。

**组件坐标** <br />
```
<dependency>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-export</artifactId>
    <version>${hzero.starter.version}</version>
</dependency>
```

**特性** <br />
- 支持大数据量导出，不存在内存溢出
- 支持可选择列导出
- 支持头行结构导出、头行打平导出
- 支持自定义Excel导出样式
- 支持自定义单元格格式
- 支持一个DTO中的列分组
- 支持数据自定义渲染
- 使用及其方便简单

##### 使用指南
使用该组件导出数据主要会用到三个注解：`@ExcelSheet、@ExcelColumn、@ExcelExport`。

**@ExcelSheet** <br />
在导出的`DTO类`上，使用`@ExcelSheet` 标注导出的sheet，头行结构中，行上也需要使用该注解标注。在`@ExcelSheet`中，可配置导出Sheet的标题，分页查询大小等，基本不需配置，使用默认的即可。

```
/**
 * Sheet(Excel)标题 首先根据多语言取，如果多语言为空则取title，title为空则取类名
 */
@AliasFor("zh")
String title() default "";

/**
 * 中文标题
 */
@AliasFor("title")
String zh() default "";

/**
 * 英文标题
 */
String en() default "";

/**
 * 多语言KEY 根据 key & code 获取多语言
 * @see #promptCode
 * @see #title
 */
String promptKey() default "";

/**
 * 多语言CODE 根据 key & code 获取多语言
 * @see #promptKey
 * @see #title
 */
String promptCode() default "";

/**
 * 行偏移量 从第几行开始显示数据 大于等于0
 */
int rowOffset() default 0;

/**
 * 占位符，偏移的列可使用占位符显示
 */
String placeholder() default "*****";

/**
 * 列偏移量 从第几列开始显示数据 大于等于0
 */
int colOffset() default 0;

/**
 * 分页大小 每次查询的数量
 */
int pageSize() default 5000;
```

**@ExcelColumn** <br />
在导出DTO类中，在需要作为导出`列`的字段上，使用`@ExcelColumn`标注，该注解可配置列标题、显示顺序等。
- 头行结构多sheet 导出中，如果某列需要显示到子Sheet中，可配置 `showInChildren=true；`
- 如果某个字段是List子列表，需要配置 child=true。
- 对于一个DTO，想要分组导出不同字段的组合，可设置 groups 属性，通过定义不同的接口来分组，同时需要在@ExcelExport 配置对应的 groups 标识。
- 导出的`Cell`格式可通过 pattern 设置，在 `BaseConstants.Pattern `里定义了一些基础的日期、数字、金额的格式。
- 如果想要对某个字段自定义显示样式，可设置 renders 属性，需实现 ValueRenderer 接口。

```
/**
 * 列标题 首先根据多语言取，如果多语言为空则取title，title为空则取类名
 */
@AliasFor("zh")
String title() default "";

/**
 * 中文标题
 */
@AliasFor("title")
String zh() default "";

/**
 * 英文标题
 */
String en() default "";

/**
 * 多语言KEY 根据 key & code 获取多语言
 * @see #promptCode
 * @see #title
 */
String promptKey() default "";

/**
 * 多语言CODE 根据 key & code 获取多语言
 * @see #promptKey
 * @see #title
 */
String promptCode() default "";

/**
 * 在子列表中显示该列
 */
boolean showInChildren() default false;

/**
 * 列顺序
 */
int order() default 1;

/**
 * Cell 格式，参考 {@link BaseConstants.Pattern}
 */
String pattern() default "";

/**
 * 是否子节点
 */
boolean child() default false;

/**
 * 列宽度
 */
String width() default "3000";

/**
 * 是否可编辑
 */
boolean editable() default true;

/**
 * 分组标识
 */
Class<?>[] groups() default {};

/**
 * 数据渲染器，根据需求自行实现渲染器，设置Cell数据时会通过该渲染器来渲染数据和类型。
 *
 * <pre> example:
 *  public static class ExampleRenderer implements ValueRenderer {
 *
 *      public Object render(Object value, Object data) {
 *          ExampleDTO dto = (ExampleDTO) data;
 *          return "template name = " + dto.name;
 *      }
 *  }
 * </pre>
 */
Class<? extends ValueRenderer>[] renders() default {};
```

`such as` 
```
@ExcelSheet(zh = "收货记录", en = "Receiving record")
public class ReveRecodeDTO {
    @ExcelColumn(zh = "事务编号", en = "trxNum", showInChildren=true)
    private String trxNum;
    @ExcelColumn(zh = "客户", en = "companyName", groups = {Group2.class})
    private String companyName;
    @ExcelColumn(zh = "物品编码", en = "itemCode", order = 4, groups = {Group1.class})
    private String itemCode;
    @ExcelColumn(zh = "物品名称", en = "itemName", order = 3, groups = {Group1.class})
    private String itemName;
    @ExcelColumn(zh = "日期", en = "trxDate", pattern = BaseConstants.Pattern.DATE)
    private Date trxDate;
    @ExcelColumn(zh = "数量", en = "quantity", groups = {Group2.class})
    private BigDecimal quantity;
    @ExcelColumn(zh = "金额", en = "netAmount", pattern = BaseConstants.Pattern.TB_ONE_DECIMAL)
    private BigDecimal netAmount;
    @ExcelColumn(zh = "原因", en = "moveReason")
    private String moveReason;
    @ExcelColumn(zh = "接收人", en = "receiptPerson")
    private String receiptPerson;
    @ExcelColumn(zh = "备注", en = "remark", renders = RemarkValueRenderer.class)
    private String remark;
    @ExcelColumn(zh = "详情列表", en = "detailsList", child = true)
    List<RecordLineDTO> detailsList;

    public interface Group1 {}

    public interface Group2 {}

    public class RemarkValueRenderer implements ValueRenderer {
        @Override
        public Object render(Object value, Object data) {
            RecordLineDTO dto = (RecordLineDTO) data;
            return "显示备注：" + dto.remark;
        }
    }

    // getter/setter
}
```

**@ExcelExport** <br />
在`导出接口`上，使用`@ExcelExport`标注，注解需配置导出的DTO。

- 对于只有行的数据，一般可以直接使用已有的List、Page方法即可。
- 接口方法必须有`HttpServletResponse`和`ExportParam`参数，HttpServletResponse用于输出Excel，ExportParam用于封装参数。
- 在ExportParam中，通过exportType=COLUMN请求导出列；通过exportType=DATA导出Excel；通过fillerType指定导出样式；
- 对于头行结构，选择了行后，会将行字段名称放入selection中，在查询头行数据时，即可按需查询行数据。
- 接口方法如果有PageRequest参数，将会分批次查询数据填充到Sheet中，如果没有，则默认一次性查询所有数据。
- 导出时，所有的查询已经控制在一个事务内，不会出现幻读的问题。

```
/**
 * 将该注解加在请求数据的接口上：<br/>
 *
 * 接口方法必须带有 {@link HttpServletResponse} 参数，将通过 {@link HttpServletResponse#getWriter()} 返回数据 <br/>
 * 接口方法必须带有 {@link ExportParam} 参数：
 *  <ul>
 *      <li>通过 {@link ExportParam#fillerType} 指定导出方式</li>
 *      <li>通过 {@link ExportParam#exportType} 指定导出类型</li>
 *      <ul>
 *          <li>{@link ExportType#COLUMN} 查询导出的列</li>
 *          <li>{@link ExportType#DATA} 导出数据</li>
 *          <li>{@link ExportType#TEMPLATE} 导出模板</li>
 *      </ul>
 *      <li>通过 {@link ExportParam#ids} 传入选择导出的列</li>
 *  </ul>
 * 接口方法最好带有分页参数 {@link PageRequest}，支持分页查询数据，从而避免大数据量导致内存溢出 <br/>
 *
 * @author bojiangzhou 2018/07/25
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelExport {

    /**
     * 导出对象
     */
    Class<?> value();

    /**
     * 分组标识
     */
    Class<?>[] groups() default {};
}
```

`Example`
```
@GetMapping("/export")
@ExcelExport(ReveRecodeDTO.class)
public ResponseEntity export(ReveRecodeDTO record, ExportParam exportParam, HttpServletResponse response, PageRequest pageRequest) {
    List<ReveRecodeDTO> list = repository.export(record, exportParam, pageRequest);
    return Results.success(list);
}
```

##### 导出数据
导出数据需要发起`两次请求：`

- 第一次请求可导出的列：host/v1/events/export?exportType=COLUMN
- 第二次传入列ID导出数据：host/v1/events/export?exportType=DATA&fillerType=multi-sheet&ids=1&ids=2&ids=3&ids=4&ids=5&ids=6&ids=7……
	- 单 sheet 页导出：fillerType=single-sheet
	- 多 sheet 页导出：fillerType=multi-sheet


##### 异步导出
**注意事项** <br />

- 目前异步导出支持默认使用hzero-file文件服务存储异步导出文件，文件大小受限，最大为40MB。
- 异步导出组件支持扩展，可自定义实现，将文件存储到自己部署的文件服务器。
- 支持中断异步导出任务，需要开启management端口并开放async-export-endpoint

```
management:
  server:
    port: 8080
  endpoints:
    web:
      exposure:
        include: async-export-endpoint #or '*'
```
- 默认关闭异步导出，开启需要增加配置。
```
hzero:
  export:
    enable-async: true
    #异步线程池默认配置如下，如无需修改，可省略以下配置
    core-pool-size: 3
    maximum-pool-size: 10
    keep-alive-time: 0
    queue-size: 2147483645
    async-thread-name: async-export-executor
```

#### 动态路由组件
`组件编码hzero-starter-dynamic-route`

##### 简介
**概述** <br />
动态路由组件用于服务治理中 feign 调用及 zuul 网关层动态路由和URL客制化，将根据发布节点实例时配置的节点组规则以及当前请求的租户或用户选择配置的节点，从而做到动态路由。


**组件坐标** <br />
```
<dependency>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-dynamic-route</artifactId>
    <version>${hzero.starter.veresion}</version>
</dependency>
``` 


**特性** <br />
- 在服务内，拦截 feign 调用，根据调用服务和URL以及当前租户，为URL加上租户编码前缀，做到URL客制化。
- 在 Zuul 网关层，根据获取的服务路由及当前租户，为URL加上租户编码前缀，做到URL客制化。
- 通过修改 Ribbon 选择服务节点的方法，根据当前请求的服务、租户、用户获取配置的节点组，从而将请求路由到特定的节点上。
- 可用于灰度发布，支持租户级、用户级灰度。


##### 节点组规则
首先需要明白这个组件是为了解决什么问题：

- 灰度发布时，想让一部分租户或用户使用新版本的服务功能，使用没问题才会正式发布服务。
- 对于某些 API 要做客制化开发，访问网关或 feign 调用时，服务名、地址都不变，但是要求能正确路由到客制化的API上。
- 无论是灰度发布还是客制化URL都要求对代码无侵入，不能修改代码中的服务名、URL。

解决这些问题的手段主要是通过配置规则，在发布服务时为节点实例打上节点组标签(nodeGroupId)，从而根据配置找到相应的节点组。

**规则配置** <br />
- 在 [服务治理>节点组规则] 配置节点组规则。先选择租户，之后可以选择租户下的用户，代表只对这些用户生效，否则对整个租户生效；
- 或选择URL进行客制化，当该租户访问这个URL时，组件为URL会加上租户编码前缀，如 /v1/{organizationId}/notices -> /tenant_code/v1/{organizationId}/notices。这就要求客制化开发的服务中，客制化URL需要加上租户编码前缀。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191026153756162-15117084.jpg)

节点组标签配置
- 首先需要在代码中添加节点组标签，最终通过配置找节点组时就是与这个标签的值进行对比。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191026153835743-190493550.jpg)

- 在 values.yaml 中添加节点组ID配置，之后发布服务时，会自动用节点组ID替换这两个值，部署服务时，则替换上面的节点组ID标签的值。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191026153949585-802173536.jpg)


- 在 deployment.yaml 文件中添加节点组标签，这个标签最终会打到K8S的标签上。
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191026154019248-2017087080.jpg)

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191026154128083-1971824549.jpg)

- 最后，在需要灰度的项目中引入该组件，然后构建项目。
```
<dependency>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-dynamic-route</artifactId>
</dependency>
```

创建节点组
- 准备工作做完之后，在 [服务治理>节点组维护] 创建节点组，如果选择了 通用，则代表该节点为通用节点，节点组标签(nodeGroupId=0)，该服务的请求若没有找到规则，则路由到该节点。
- 这里如果选择了灰度，则不会立即发布节点，需要在[灰度发布管理]处创建灰度发布来发布节点。如果没有选择灰度，则会立即发布服务。
- 非通用节点，必须添加节点组规则。

![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191026154240154-125088237.jpg)

- 发布服务时，会自动将该节点组ID设置到配置文件中，并且在服务发布时替换
![](https://img2018.cnblogs.com/blog/1231979/201910/1231979-20191026154243548-1552280610.jpg)


缓存规则
- 服务发布成功后，会将节点组对应的规则缓存起来，请求时，则从缓存中查找规则，如果有匹配的规则，就会寻找相应的节点组，否则走通用节点。

一共有三种类型的缓存，结构都为 HASH：
- 如果该规则只选择了租户，则缓存 租户-节点 关系，key 包含服务名称
```
nodegroup:{serviceName}:tenant-node
    - {tenantId}:{nodeGroupId}
```

- 如果租户下选择了用户，则缓存 用户-节点 关系，key 包含服务名和租户ID
```
nodegroup:{serviceName}:{tenantId}:user-node
    - {userId}:{nodeGroupId} 
```

- 如果租户下选择了客制化URL，则缓存 URL-节点 关系，key 包含服务名和租户ID

```
nodegroup:{serviceName}:{tenantId}:url-node
    - {url#method}:{urlPrefix#nodeGroupId}
```


**组件核心思想** <br />
- 网关层URL客制化：
	- 通过 ZuulPathFilter 拦截所有请求，获取当前租户ID和用户ID，并放入线程变量中。ZuulPathFilter 继承自 ZuulFilter。
	- MemoryRouteLocator 重写路由定位器获取匹配路由的方法，获取到匹配的路由 Route 后，根据服务名、租户ID、URL获取客制化的URL编码前缀，并改写 Route 的 path。 MemoryRouteLocator 继承自 SimpleRouteLocator。

- 服务间 feign 调用URL客制化：
	- 通过 TenantHeaderInterceptor 拦截所有服务请求，获取当前租户ID和用户ID，并放入线程变量中。TenantHeaderInterceptor 继承自 HandlerInterceptorAdapter。
	- 使用AOP FeignClientAspect 拦截所有 infra.feign 包下的被 @FeignClient 注解的接口，缓存 feign 调用的服务名称。
	- 通过 FeignRouteInterceptor 拦截器修改 RequestTemplate，根据服务名、租户ID、URL获取客制化的URL编码前缀，向 RequestTemplate 插入URL编码前缀。FeignRouteInterceptor 继承自 RequestInterceptor。

- 3.3 节点定位：
	- 核心思想是通过修改 Ribbon 选择节点的方法，因为不论是网关层、还是 feign 调用、还是使用 LoadBalanced 标注的 RestTemplate，最终都会通过 Ribbon 来从注册中心选择一个节点进行服务请求。


#### 分布式组件
`组件编码 hzero-starter-lock`

##### 简介
**概述** <br />
hzero-starter-lock 分布式锁组件基于 Redisson 开发，开发中可以通过注解的方式进行分布式锁控制，使项目拥有分布式锁变得非常简单。

**组件坐标** <br />
```
<dependency>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-lock</artifactId>
    <version>${hzero.starter.version}</version>
</dependency>
```

**特性** <br />
- 依赖Redis，支持单节点模式、集群模式、云托管模式、哨兵模式、主从模式
- 通过注解的方式进行使用，控制细节对开发者透明
- 多种锁类型：可重入锁、公平锁、联锁、红锁、读锁、写锁
- 注解多种常用属性

##### 使用指南
**配置** <br />
考虑到支持多种redis运行模式，没有使用redis的默认配置方式
```
// 单节点模式示例
hzero:
  lock:
    pattern: single
    single-server:
      address: 127.0.0.1
      port: 6379

// 集群模式示例
hzero:
  lock:
    pattern: cluster
    cluster-server:
      nodeAddresses: 127.0.0.1:6379,127.0.0.1:6389

// 主从模式示例
hzero:
  lock:
    pattern: master_slave
    master-slave-server:
      master-address: 127.0.0.1:6379
      slave-addresses: 127.0.0.1:6389,127.0.0.1:6399

// 哨兵模式示例
hzero:
  lock:
    pattern: sentinel
    sentinel-server:
      master-name: mymaster
      sentinel-addresses: 127.0.0.1:6389,127.0.0.1:6399

// 云托管模式示例
hzero:
  lock:
    pattern: replicated
    replicated-server:
      node-addresses: 127.0.0.1:6379,127.0.0.1:6389
```
>redis连接配置参数详细说明：
单节点模式
```
// 节点地址
hzero.lock.singleServer.address
// 节点端口
hzero.lock.singleServer.port
// 发布和订阅连接的最小空闲连接数
hzero.lock.singlServer.subConnMinIdleSize = 1
// 发布和订阅连接池大小
hzero.lock.singleServer.subConnPoolSize = 50
// 最小空闲连接数
hzero.lock.singleServer.connMinIdleSize = 32
// 连接池大小
hzero.lock.singleServer.connPoolSize = 64
// 是否启用DNS监测
hzero.lock.singleServer.dnsMonitoring = false
// DNS监测时间间隔，单位：毫秒，该配置需要dnsMonitoring设为true
hzero.lock.singleServer.dnsMonitoringInterval = 5000
// 连接空闲超时，单位：毫秒
hzero.lock.singleServer.idleConnTimeout = 10000
hzero.lock.singleServer.keepAlive = false
// 连接超时，单位：毫秒
hzero.lock.singleServer.connTimeout = 10000
// 命令等待超时，单位：毫秒
hzero.lock.singleServer.timeout = 3000
// 命令失败重试次数 如果尝试达到 retryAttempts（命令失败重试次数） 仍然不能将命令发送至某个指定的节点时，将抛出错误。如果尝试在此限制之内发送成功，则开始启用timeout（命令等待超时） 计时。
hzero.lock.singleServer.retryAttempts = 3
// 命令重试发送时间间隔，单位：毫秒
hzero.lock.singleServer.retryInterval = 1500
// 数据库编号
hzero.lock.singleServer.database = 0
// 密码
hzero.lock.singleServer.password
// 单个连接最大订阅数量
hzero.lock.singleServer.subPerConn = 5
```

集群模式
```
// 集群节点地址
hzero.lock.clusterServer.nodeAddresses
// 集群扫描间隔时间
hzero.lock.clusterServer.scanInterval = 1000
// 读取操作的负载均衡模式
hzero.lock.clusterServer.readMode = SLAVE
// 订阅操作的负载均衡模式
hzero.lock.clusterServer.subMode = SLAVE
// 负载均衡算法类的选择，默认：轮询调度算法
hzero.lock.clusterServer.loadBalancer = RoundRobinLoadBalancer
// 默认权重值，当负载均衡算法是权重轮询调度算法时该属性有效
hzero.lock.clusterServer.defaultWeight = 0
// 权重值设置，格式为 host1:port1,权重值1host2:port2,权重值2 当负载均衡算法是权重轮询调度算法时该属性有效
hzero.lock.clusterServer.weightMaps
// 从节点发布和订阅连接的最小空闲连接数
hzero.lock.clusterServer.subConnMinIdleSize = 1
// 从节点发布和订阅连接池大小
hzero.lock.clusterServer.subConnPoolSize = 50
// 从节点最小空闲连接数
hzero.lock.clusterServer.slaveConnMinIdleSize = 32
// 从节点连接池大小
hzero.lock.clusterServer.slaveConnPoolSize = 64
// 主节点最小空闲连接数
hzero.lock.clusterServer.masterConnMinIdleSize = 32
// 主节点连接池大小
hzero.lock.clusterServer.masterConnPoolSize = 64
// 连接空闲超时，单位：毫秒
hzero.lock.clusterServer.idleConnTimeout = 10000
// 连接超时，单位：毫秒
hzero.lock.clusterServer.connTimeout = 10000
// 命令等待超时，单位：毫秒
hzero.lock.clusterServer.timeout = 3000
// 命令失败重试次数
hzero.lock.clusterServer.retryAttempts = 3
// 命令重试发送时间间隔，单位：毫秒
hzero.lock.clusterServer.retryInterval = 1500
// 密码
hzero.lock.clusterServer.password
// 单个连接最大订阅数量
hzero.lock.clusterServer.subPerConn = 5
```

主从模式
```
// DNS监控间隔，单位:毫秒
hzero.lock.masterSlaveServer.dnsMonitoringInterval = 5000
// 主节点地址，可以通过host:port的格式来指定主节点地址。
hzero.lock.masterSlaveServer.masterAddress
// 从节点地址
hzero.lock.masterSlaveServer.slaveAddresses
// 读取操作的负载均衡模式
hzero.lock.masterSlaveServer.readMode = SLAVE
// 订阅操作的负载均衡模式
hzero.lock.masterSlaveServer.subMode = SLAVE
// 负载均衡算法类的选择，默认：轮询调度算法
hzero.lock.masterSlaveServer.loadBalancer = RoundRobinLoadBalancer
// 默认权重值，当负载均衡算法是权重轮询调度算法时该属性有效
hzero.lock.masterSlaveServer.defaultWeight = 0
// 权重值设置，格式为 host1:port1,权重值1host2:port2,权重值2 当负载均衡算法是权重轮询调度算法时该属性有效
hzero.lock.masterSlaveServer.weightMaps
// 从节点发布和订阅连接的最小空闲连接数
hzero.lock.masterSlaveServer.subscriptionConnectionMinimumIdleSize = 1
// 从节点发布和订阅连接池大小
hzero.lock.masterSlaveServer.subscriptionConnectionPoolSize = 50
// 从节点最小空闲连接数
hzero.lock.masterSlaveServer.slaveConnectionMinimumIdleSize = 32
// 从节点连接池大小
hzero.lock.masterSlaveServer.slaveConnectionPoolSize = 64
// 主节点最小空闲连接数
hzero.lock.masterSlaveServer.masterConnectionMinimumIdleSize = 32
// 主节点连接池大小
hzero.lock.masterSlaveServer.masterConnectionPoolSize = 64
// 连接空闲超时，单位：毫秒
hzero.lock.masterSlaveServer.idleConnectionTimeout = 10000
// 连接超时，单位：毫秒
hzero.lock.masterSlaveServer.connectTimeout = 10000
// 命令等待超时，单位：毫秒
hzero.lock.masterSlaveServer.timeout = 3000
// 命令失败重试次数
hzero.lock.masterSlaveServer.retryAttempts = 3
// 命令重试发送时间间隔，单位：毫秒
hzero.lock.masterSlaveServer.retryInterval = 1500
// 重新连接时间间隔，单位：毫秒
hzero.lock.masterSlaveServer.reconnectionTimeout = 3000
// 执行失败最大次数
hzero.lock.masterSlaveServer.failedAttempts = 3
// 数据库编号
hzero.lock.masterSlaveServer.database = 0
// 密码，用于节点身份验证的密码
hzero.lock.masterSlaveServer.password
// 单个连接最大订阅数量
hzero.lock.masterSlaveServer.subscriptionsPerConnection = 5
```

哨兵模式
```
// DNS监控间隔，单位：毫秒；用-1来禁用该功能。
hzero.lock.sentinelServer.dnsMonitoringInterval = 5000
// 主服务器的名称
hzero.lock.sentinelServer.masterName
// 哨兵节点地址，多个节点可以一次性批量添加。
hzero.lock.sentinelServer.sentinelAddresses
// 读取操作的负载均衡模式
hzero.lock.sentinelServer.readMode = SLAVE
// 订阅操作的负载均衡模式
hzero.lock.sentinelServer.subMode = SLAVE
// 负载均衡算法类的选择，默认：轮询调度算法
hzero.lock.sentinelServer.loadBalancer = RoundRobinLoadBalancer
// 默认权重值，当负载均衡算法是权重轮询调度算法时该属性有效
hzero.lock.sentinelServer.defaultWeight = 0
// 权重值设置，格式为 host1:port1,权重值1host2:port2,权重值2 当负载均衡算法是权重轮询调度算法时该属性有效
hzero.lock.sentinelServer.weightMaps
// 从节点发布和订阅连接的最小空闲连接数
hzero.lock.sentinelServer.subscriptionConnectionMinimumIdleSize = 1
// 从节点发布和订阅连接池大小
hzero.lock.sentinelServer.subscriptionConnectionPoolSize = 50
// 从节点最小空闲连接数
hzero.lock.sentinelServer.slaveConnectionMinimumIdleSize = 32
// 从节点连接池大小
hzero.lock.sentinelServer.slaveConnectionPoolSize = 64
// 主节点最小空闲连接数
hzero.lock.sentinelServer.masterConnectionMinimumIdleSize = 32
// 主节点连接池大小
hzero.lock.sentinelServer.masterConnectionPoolSize = 64
// 连接空闲超时，单位：毫秒
hzero.lock.sentinelServer.idleConnectionTimeout = 10000
// 连接超时，单位：毫秒
hzero.lock.sentinelServer.connectTimeout = 10000
// 命令等待超时，单位：毫秒
hzero.lock.sentinelServer.timeout = 3000
// 命令失败重试次数
hzero.lock.sentinelServer.retryAttempts = 3
// 命令重试发送时间间隔，单位：毫秒
hzero.lock.sentinelServer.retryInterval = 1500
// 数据库编号
hzero.lock.sentinelServer.database = 0
// 密码，用于节点身份验证的密码
hzero.lock.sentinelServer.password
// 单个连接最大订阅数量
hzero.lock.sentinelServer.subscriptionsPerConnection = 5
```

云托管模式
```
// 集群节点地址
hzero.lock.replicatedServer.nodeAddresses
// 主节点变化扫描间隔时间
hzero.lock.replicatedServer.scanInterval = 1000
// DNS监控间隔，单位：毫秒；用-1来禁用该功能。
hzero.lock.replicatedServer.dnsMonitoringInterval = 5000
// 读取操作的负载均衡模式
hzero.lock.replicatedServer.readMode = SLAVE
// 订阅操作的负载均衡模式
hzero.lock.replicatedServer.subscriptionMode = SLAVE
// 负载均衡算法类的选择，默认：轮询调度算法
hzero.lock.replicatedServer.loadBalancer = RoundRobinLoadBalancer
// 默认权重值，当负载均衡算法是权重轮询调度算法时该属性有效
hzero.lock.replicatedServer.defaultWeight = 0
// 权重值设置，格式为 host1:port1,权重值1host2:port2,权重值2 当负载均衡算法是权重轮询调度算法时该属性有效
hzero.lock.replicatedServer.weightMaps
// 从节点发布和订阅连接的最小空闲连接数
hzero.lock.replicatedServer.subscriptionConnectionMinimumIdleSize = 1
// 从节点发布和订阅连接池大小
hzero.lock.replicatedServer.subscriptionConnectionPoolSize = 50
// 从节点最小空闲连接数
hzero.lock.replicatedServer.slaveConnectionMinimumIdleSize = 32
// 从节点连接池大小
hzero.lock.replicatedServer.slaveConnectionPoolSize = 64
// 主节点最小空闲连接数
hzero.lock.replicatedServer.masterConnectionMinimumIdleSize = 32
// 主节点连接池大小
hzero.lock.replicatedServer.masterConnectionPoolSize = 64
// 连接空闲超时，单位：毫秒
hzero.lock.replicatedServer.idleConnectionTimeout = 10000
// 连接超时，单位：毫秒
hzero.lock.replicatedServer.connectTimeout = 10000
// 命令等待超时，单位：毫秒
hzero.lock.replicatedServer.timeout = 3000
// 命令失败重试次数
hzero.lock.replicatedServer.retryAttempts = 3
// 命令重试发送时间间隔，单位：毫秒
hzero.lock.replicatedServer.retryInterval = 1500
// 数据库编号
hzero.lock.replicatedServer.database = 0
// 密码，用于节点身份验证的密码
hzero.lock.replicatedServer.password
// 单个连接最大订阅数量
hzero.lock.replicatedServer.subscriptionsPerConnection = 5
```

**使用注解** <br />
```
@Service
public class TestService {
    @Lock(keys = {"#user.name","#user.id"},waitTime = Long.MAX_VALUE)
    public String updateUser(User user,@LockKey Long tenantId) throws Exception {
        return "Test Lock";
    }
}
```

>@Lock注解参数说明（此注解使用在需要加锁的方法上）
```
@Lock可以标注四个参数，作用分别如下

name：lock的name，对应redis的key值。默认为：类名+方法名+指定参数，如指定了名称，则直接使用指定名称

lockType：锁的类型，目前支持（公平锁LockType.FAIR，可重入锁LockType.REENTRANT，读锁LockType.READ，写锁LockType.WRITE，红锁LockType.RED，联锁LockType.MULTI）。默认为：公平锁

waitTime：获取锁最长等待时间。默认为：60s。同时也可通过spring:redis:lock:waitTime统一配置

leaseTime：获得锁后，自动释放锁的时间。默认为：60s。同时也可通过spring:redis:lock:leaseTime统一配置

keys：自定义业务Key，针对参数为对象，可使用此种方式进行申明，如：keys = {"#user.name","#user.id"}

```
>@LockKey注解参数说明（此注解使用在需要加锁方法的参数上）
```
@LockKey可以标注的参数如下：

value：默认值
```

#### 长连接组件
`组件编码 hzero-starter-websocket`

##### 简介
**概述** <br/>
hzero-starter-websocket 长连接组件，支持前端websocket和sock-js两种连接方式，用于后端的主动消息推送。

**组件坐标** <br/>
```
<dependency>
    <groupId>org.hzero.starter</groupId>
    <artifactId>hzero-starter-websocket</artifactId>
    <version>${hzero.starter.version}</version>
</dependency>
```

** 特性** <br />
- 支持ws和http协议
- 包含在线用户记录
- 支持自定义连接路径

##### 使用指南
**配置** <br />
```
hzero:
  websocket:
    # websocket方式连接路径
    websocket: /websocket
    # sock-js连接路径
    sockJs: /sock-js
    # oauth地址
    oauthUrl： http://dev.hzero.org:8080/oauth/api/user
    # redis库
    redisDb： 1
```
>以上均为默认配置

**前端连接** <br/>
前端连接需要在路径上拼接参数access_token，用于获取用户信息
**使用说明** <br />
后端发送消息
```
@Autowired
private SocketSendHelper socketSendHelper;
```

SocketSendHelper提供了三个消息发送的方法：
- sendBySession(String sessionId, String key, String message);
	- 根据长连接的sessionId发送消息

- sendByUserId(Long userId, String key, String message);
	- 根据用户Id发送消息

- sendToAll(String key, String message);
	- 向所有在线人员发送消息


>**需要注意的是：**HZERO的长连接是默认建立的，连接服务为消息服务，在HZERO的系统架构下，无需自行依赖本组件。boot-message组件提供了上述三个方法用于消息推送。

key为消息的类型key，用于标识业务，HZERO的前端会根据key进行消息下发，所以key必须是唯一的。message为消息内容，一般为json字符串。


**在线用户记录** <br/>
```
@Autowired
private OnlineUserHelper userHelper;

```

- List<UserVO> getUser();
获取所有在线用户信息
- List<UserVO> getUser(Long userId)；
指定用户Id，获取在线用户信息

boot-message组件也提供了上述方法。