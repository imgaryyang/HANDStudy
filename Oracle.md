# Oracle����
##1.���к���
>���壺ֻ��һ�н��б任�����������

### 1.1 �ַ�����---��Сд���ƺ���
- Сд����  lower
```
select lower('HelloWorld') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312195048624-471743042.png)

-----

- ��д���� upper
```
select upper('HelloWorld') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312195351202-608388769.png)

- ����ĸ��д����
```
select initcap('HelloWorld') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312195511766-1668224461.png)

- �ַ������Ӻ���
```
select concat('Hello',' world') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312200014960-953733211.png)
>ֻ��ƴ����������

- ��ȡ����
# �����ȡ
```
select substr('Hello',1,1) from dual;

select substr('Hello',0,1) from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312200339797-27864658.png)

---
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312200359207-767007720.png)

>�����������һ����֤����0��1��ʼ���Ǵ���H��ĸ


- ���ַ������Ⱥ���
```
select length('Hello') from dual;--�޿ո�

select length('Hello World') from dual;--�пո�
```


```
select lengthb('Hello World') from dual;--�ֽ�
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312200832260-1541170348.png)


- ���ַ����е�λ��
```
select instr('Hello Oracle','oracle') from dual;--0

select instr('Hello Oracle','Oracle') from dual;--7
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312201321842-897099940.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312201416405-1200432817.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312201543011-581125956.png)

>�ó����ۣ���instr�����У��ո�Ҳ����һ��λ�ã����������ִ�Сд��ĸ�����ص�����ͬ��ĸ�µ�һ����ĸ���ڵ�λ��

- ����亯��
```
select LPAD(666,10,'*') from dual;
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312201726287-32604870.png)

- ����亯��

```
select RPAD(666,10,'*') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312201953908-77070769.png)

- ȥ��ǰ��ָ�����ַ�---���ִ�Сд
```
select TRIM('H' FROM 'HelloWorld') from dual;

select TRIM('H' FROM 'helloWorld') from dual;

select TRIM(' HelloWorld') from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312202223981-647690267.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312202345344-1589253459.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312202552876-155877943.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312202659017-473565264.png)

>ȥָ���ַ������ִ�С�ģ�ȥ�ո�ֻ���ǵ�һ����ĸǰ��ģ�������������ĸ�м�Ŀո�����MySQL��Oracleת����ʱ����Ҫtrim����

- �滻����
```
select replace('Hello World','l','*') from dual;

select replace('Hello World',' ','*') from dual;

```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312203036772-771797175.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312203129104-1672739994.png)

>�滻�����п��Խ��ո��滻��ָ�����ַ�������������˼�ǣ���Hello World�еġ�l����ĸ�滻�� �� *��

### 1.2 ��ֵ����
- ��������ĺ���round
```
select ROUND(45.926, 2)  from dual;

select round(45.926,-1) from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190312203551354-921682638.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313093342902-1632786189.png)

>�ڶ����������������С������ǰ��ȡ��������С��������ȡ����5��1

- ��ȡ���� trunc
```
select TRUNC(45.926, 2) from dual;

select trunc(45.926,-1) from dual;

select trunc(sysdate) from dual; 
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313083704628-598670306.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313093217730-1456214935.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313093636324-1384586358.png)

>��ȡ�����ǽ�ָ�������ְ���С������λ����ȡû���������롣


- ���ຯ��mod
```
select MOD(1600, 300) from dual;
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313083749637-1768594828.png)


### 1.3 ���ں���
- ϵͳ��ǰʱ���������
```
select sysdate from dual;--��ǰʱ��

select sysdate-1 from dual;--����

select sysdate+1 from dual;--����
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313084623861-1643294292.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190313084657655-674712040.png)


- �·ݲ�ֵ����
```
select MONTHS_BETWEEN ('01-SEP-95','11-JAN-94') from dual;
```
>�õ��Ľ�����·ݵĲ�ࣻ��12 ����õ�������ݣ���ȡ mod �õ��������·�

-  ����·ݺ���
```
select ADD_MONTHS ('11-JAN-94',6) from dual;
```
### �ϸ������һ��
```
select ADD_MONTHS(LAST_DAY(to_date()),-1);
```



- 
```
select NEXT_DAY('01-SEP-95','FRIDAY') from dual;
```

### 1.4ת������
>�ڲ�ͬ����������֮�������ֵ��ת������Ϊ��ʽת������ʽת��
>��ʽת�����壺��Oracle�Զ����
```
Դ�� varchar2 or char ת���� number

Դ�� varchar2 or char ת���� date

Դ�� number ת����varchar2 or char

Դ��date ת���� varchar2
```
>��ʽ����ת������



oracleĬ����ʲô��ʽ�ж��ֶ�����ֵ�ͺ��ַ��ͺ���


to_char(1255555,'9,999,999');

to_date to_char  to_number

```
decode(job_id,
	'aaa',1.10*salary,
	'bbb',2*salary
)

��ֲ���

��ֵ�����ж�
```

```
SELECT e.last_name, e.department_id, d.department_name
FROM cux_employees e, cux_departments d
WHERE e.department_id(+) = d.department_id ;--?���Ǳ߾���������ǿ���,�յ��ֶο��Ը�����ı�������

```


grant ��Ȩ��