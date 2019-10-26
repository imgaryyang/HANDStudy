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
**** <br />
**** <br />
**** <br />
**** <br />
**** <br />
**** <br />
**** <br />
**** <br />
