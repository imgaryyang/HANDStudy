# HAP考核时间记录

## 第一天任务 2019.4.19
```
环境搭建
配置数据库导入数据
需求文档熟悉,了解需要做的内容
表结构分析
功能设置
页面搭建
```


### 环境搭建
```
基于HAP框架版本为3.4.0 基础上搭建

数据库配置完成
```


### 功能设置  --->完成
```
1、角色：新建两个角色，销售员、销售经理

2、功能：新建一个功能，销售订单管理

3.把销售订单功能挂到“销售员”、“销售经理”角色下
```


### 页面搭建--->完成
```
完成销售订单汇总页面

完成销售订单汇总页面的LOV级联功能
```

****
## 第二---三天任务 2019.4.20- 4.21
```
将需求文档抽取核心模块,定义内容

修改销售订单汇总页面

思考:
	销售订单汇总页面数据加载,关联表,数据多对象绑定,如何编写mapper文件


遇到的问题:
	在销售订单汇总页面数据列不是我们对应某个表的数据,而是5个对象中某个字段的属性,处理Mapper的sql语句编写测试.

处理方案:
	新建一个DTO文件里面存放5个对象然后在mapper文件中使用关联属性来处理.  (不可行)
	页面数据列需要绑定主键id但是新建的DTO没有id主键.
```

### 需求文档分析
```
查看HapExam文件夹下面的Analysis.md
```

### 测试sql  (mapper.xml)
```
SELECT
	hooh.order_number,
	hoc.company_name,
	hac.customer_name,
	hooh.order_date,
	hooh.order_status,
	hool.ORDERD_QUANTITY * hool.unit_selling_price
FROM
	hap_org_companys hoc,
	hap_om_order_headers hooh,
	hap_ar_customers hac,
	hap_om_order_lines hool,
	hap_inv_inventory_items hiii
WHERE
	hoc.company_id = hac.company_id
AND hooh.customer_id = hac.customer_id
AND hool.header_id = hooh.header_id
AND hiii.INVENTORY_ITEM_ID = hool.INVENTORY_ITEM_ID


(
	SELECT
		sum(
			ORDERD_QUANTITY * unit_selling_price
		)
	FROM
		hap_om_order_lines line,hap_om_order_headers hooh
	WHERE
		line.header_id = hooh.header_id
)
```



## 第四天--->2019.4.22
```
修改两个页面,基本修改结束,页面定型

完成代码维护,中英文切换正常

测试好查询订单汇总页面,数据加载成功

完成Excel导出,过滤条件后的导出也能使用

修复金额无法加载不显示的bug
```


## 第五天--->2019.4.23
```
完成保存头行信息录入

修改页面之间的跳转逻辑

修复昨天的bug(sql)
```



## 第六天--->2019.4.24
```
完成excel导出

修改删除头行信息方法

权限添加操作 代码维护
```
