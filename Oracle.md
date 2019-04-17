# Oracle函数
##1.单行函数
>定义：只对一行进行变换，并产生结果

### 1.1 字符函数---大小写控制函数
- 小写函数  lower
```
select lower('HelloWorld') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312195048624-471743042.png)

-----

- 大写函数 upper
```
select upper('HelloWorld') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312195351202-608388769.png)

- 首字母大写函数
```
select initcap('HelloWorld') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312195511766-1668224461.png)

- 字符串连接函数
```
select concat('Hello',' world') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312200014960-953733211.png)
>只能拼接两个参数

- 截取函数
# 反向截取
```
select substr('Hello',1,1) from dual;

select substr('Hello',0,1) from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312200339797-27864658.png)

---
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312200359207-767007720.png)

>两个语句结果都一样，证明从0跟1开始都是代表H字母


- 求字符串长度函数
```
select length('Hello') from dual;--无空格

select length('Hello World') from dual;--有空格
```


```
select lengthb('Hello World') from dual;--字节
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312200832260-1541170348.png)


- 求字符串中的位置
```
select instr('Hello Oracle','oracle') from dual;--0

select instr('Hello Oracle','Oracle') from dual;--7
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312201321842-897099940.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312201416405-1200432817.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312201543011-581125956.png)

>得出结论：在instr函数中，空格也算是一个位置，还有是区分大小写字母，返回的是相同字母下第一个字母所在的位置

- 左填充函数
```
select LPAD(666,10,'*') from dual;
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312201726287-32604870.png)

- 右填充函数

```
select RPAD(666,10,'*') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312201953908-77070769.png)

- 去掉前后指定的字符---区分大小写
```
select TRIM('H' FROM 'HelloWorld') from dual;

select TRIM('H' FROM 'helloWorld') from dual;

select TRIM(' HelloWorld') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312202223981-647690267.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312202345344-1589253459.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312202552876-155877943.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312202659017-473565264.png)

>去指定字符是区分大小的；去空格只能是第一个字母前面的，不包括两个字母中间的空格，在做MySQL和Oracle转换的时候需要trim函数

- 替换函数
```
select replace('Hello World','l','*') from dual;

select replace('Hello World',' ','*') from dual;

```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312203036772-771797175.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312203129104-1672739994.png)

>替换函数中可以将空格替换成指定的字符；上面语句的意思是：将Hello World中的“l”字母替换成 “ *”

### 1.2 数值函数
- 四舍五入的函数round
```
select ROUND(45.926, 2)  from dual;

select round(45.926,-1) from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312203551354-921682638.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313093342902-1632786189.png)

>第二个参数如果负数是小数点往前截取，正数是小数点后面截取，满5进1

- 截取函数 trunc
```
select TRUNC(45.926, 2) from dual;

select trunc(45.926,-1) from dual;

select trunc(sysdate) from dual; 
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313083704628-598670306.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313093217730-1456214935.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313093636324-1384586358.png)

>截取函数是将指定的数字按照小数点后的位数截取没有四舍五入。


- 求余函数mod
```
select MOD(1600, 300) from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313083749637-1768594828.png)


### 1.3 日期函数
- 系统当前时间操作函数
```
select sysdate from dual;--当前时间

select sysdate-1 from dual;--昨天

select sysdate+1 from dual;--明天
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313084623861-1643294292.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313084657655-674712040.png)


- 月份差值函数
```
select MONTHS_BETWEEN ('01-SEP-95','11-JAN-94') from dual;
```
>得到的结果是月份的差距；除12 结果得到的是年份，再取 mod 得到的是总月份

-  添加月份函数
```
select ADD_MONTHS ('11-JAN-94',6) from dual;
```
### 上个月最后一天
```
select ADD_MONTHS(LAST_DAY(to_date()),-1);
```



- 
```
select NEXT_DAY('01-SEP-95','FRIDAY') from dual;
```

### 1.4转换函数
>在不同的数据类型之间完成数值的转换，分为隐式转换和显式转换
>隐式转换定义：由Oracle自动完成
```
源码 varchar2 or char 转换成 number

源码 varchar2 or char 转换成 date

源码 number 转换成varchar2 or char

源码date 转换成 varchar2
```
>显式数据转换类型



oracle默认用什么方式判断字段是数值型和字符型函数


to_char(1255555,'9,999,999');

to_date to_char  to_number

```
decode(job_id,
	'aaa',1.10*salary,
	'bbb',2*salary
)

拆分参数

空值参与判断
```

```
SELECT e.last_name, e.department_id, d.department_name
FROM cux_employees e, cux_departments d
WHERE e.department_id(+) = d.department_id ;--?在那边就允许可以是控制,空的字段可以跟另外的表做关联

```


grant 赋权限