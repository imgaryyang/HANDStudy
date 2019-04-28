## 问题记录

### 无法创建bean类
```
在做第一个模块的时候,将查询的条件放到一个新的Vo类里面,直接赋值属性,无法添加,报错启动
```

### Mapper文件出错
```
在测试Mapper文件sql的时候,没注意取值写的是数据库的字段,报错,要写对应的dto属性字段
```

### LOV级联,第二个LOV无法获取第一个LOV的数据
```
要注意在自定义sql的时候需要注意语法:
	语句不需要写分号,还有关键字的时候需要空格不能连起来


#{XXX},花括号里面的字段是我们DTO所对应的属性而不是数据库对应的字段.
```

### 页面tab跳转
```
使用之前的parent方法不能实现,修改为jQuery原生方法:$(location).attr("href","XXX.html");
```


### 跳转页面字段回显
```
通过ajax异步请求(传过来的headerId),然后将查询出来的数据循环设置进去ViewModel   

	viewModel.model.set(i, row[i]);


处理LOV
	$("#customer_name_input").data("kendoLov").text(row["customerName"]);
                $("#company_name_input").data("kendoLov").text(row["companyName"]);
```

### 头行信息保存
```
保存头行结构的时候,有些字段是我们没有录入的但是后台需要这个字段.


参考:
	在重写batchUpdate方法,HeaderService层上定义两个方法完成自定义创建,有选择的插入和更新
```

### 行信息错误,但是头信息保存了
```
在保存订单头行信息的时候,行信息有错,但是头信息却插入成功了.

我在保存投行结构的时候service层添加了,事务的回滚,要么全部成功要么全部不成功
```


### 动态实现计算数量价格 金额
```
通过一个模板来返回当前的值,动态保存到viewModel.model的具体值上
```


### 订单行不可编辑状态,金额不计算
```
在订单状态为已提交,已审批的时候订单价格不能回显,在其他状态下可以显示
```


### 如何同时删除两张表的数据
```
关联两表删除两表内容
delete t1,t2 
from t_pic as t1 left join t_pic_muc_comments as t2 on t1.pmcid=t2.pmcid 
where t1.pid=1


使用join删除两个数据表中的数据，如下：
delete a,b from  a left join  b on a.id = b.cat_id where a.id=6；
```

### Excel导出
```
之前写的方案只能是当前页面下的columns信息,无法实现将查出来但是未在表格显示的数据列显示.

重新参考hap-parent的项目导出Excel
```

### PDF实现
```
使用freemaker结合kendoui框架实现,用到了自定义模板,
UI模板
	显示字面量 #=#
	显示HTML元素 #：#
	执行任意的Javascript代码 #if() {# …#}#
```


### 未解决的Bug
```
当订单状态是除了新建的其他的行总金额在订单行下面无法显示;

行号实现当前最大行数+1,只能手动输入,不能自动添加

权限部分设置值Y  无法理解  获取的值是null

```

