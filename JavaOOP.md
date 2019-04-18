# Java面向对象
##1.Java中类与对象的概念和使用
### 1.1 方法的定义/创建
- 定义
>方法就是一段可重复调用的代码段
>定义格式：方法修饰符   返回值类型   方法名(){ 方法体}

### 1.2 方法的重载
```
方法名称相同，但是参数的类型和个数不同，通过传递参数的个数和类型不同来完成不同的功能。
```

### 1.3 类的创建以及类与对象的关系
- 类的创建
```
(类名的第一个首字母要大写)
定义
   class  类名{
   
   }
```

- 类与对象的关系
```
类是对某一类事物的描述，是抽象、概念上你的意义，对象是实际存在的该类事物的每一个个体，也称为对象或实例。
```

- 内存的划分
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319092118852-1750294011.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319092058143-325671186.png)

赋值后
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319092300732-1529643567.png)


### 1.4 Java面向对象思想编程
- 了解面向对象
```
程序的发展历程：面向过程、面向对象

解释面向过程和面向对象：
	面向过程：不去想做什么样子的盒子,随机取工具制作
	面向对象：先想好做一个什么样的盒子，再去找对应的工具去做
```

- 面向对象的三大特征
```
1.封装性
   对外部不可见

2.继承
   扩展类功能

3.多态性   
   方法的重载
   对象的多态性
```

### 1.5 Java方法的递归调用
```
递归调用是一种特殊的方法调用形式，就是方法自己调用自己
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319094825407-1458797708.png)


****

## 2.封装性
```
封装性的目的
	保护某些属性和方法不被外部所看见

封装的实现
	为属性和方法进行封装是通过关键字private声明的
	实现属性的set和get方法，为外部所访问
```


## 3. Java构造方法
- 构造方法
```
特点：
	不需要调用，自动执行；而且没有返回值类型。

构造方法一定要与类名一致；可以是有参构造和无参构造函数

每一个类在实例化之后都会调用构造方法，如果没有构造方法，程序在编译的时候会创建一个无参的什么都不做的构造方法

```
- 构造方法主要是为类中的属性初始化

- 构造方法也可以实现重载

- 匿名对象的使用
>没有名字的对象    new People().tell;


## 4. Java面向对象中引用的传递
- 引用传递
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319105727054-1697645479.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319104827638-59890169.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319111250117-836676217.png)


String类型的引用传递 
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319111505635-1296191381.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319110010630-1253658231.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319111536668-192824895.png)

- this关键字
```
1.表示类中的属性和调用方法
2.调用本类中的构造方法
3.表示当前对象
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319113533028-688372962.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319113850607-444910328.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319114134221-1603124774.png)


- static关键字
```
1.使用static声明属性
    static声明全局属性

2.使用static声明方法
	直接通过类名调用

3.注意点：
	使用static方法的时候，只能访问static声明的属性和方法，非static声明的属性和方法是不能访问的
```
>静态的是在实例化之前就被调用了

## 5.继承
###5.1 继承实现
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320095547465-679400294.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320095607532-1789838026.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320095625554-581305303.png)

###5.2 继承的限制
```
在Java中只允许单继承

子类不能直接访问父类的私有成员
```

### 5.3 子类对象实例化过程

```
在子类对象实例化之前，必须调用父类中的构造方法，之后调用子类构造方法
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320100231132-694186764.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320100551975-551431784.png)

### 5.4 方法重写与super关键字
- 定义
```
在继承中，也存在着重写的概念，就是子类定义了和父类同名的方法

方法名称相同，返回值类型相同，参数相同
```

```
package com.legend.extendDemo;

//人类
class A{
    public void tell(){
        System.out.println("我是tell方法");
    }
}

//学生类
class B extends A{
    @Override
    public void tell(){
        super.tell();//调用父类方法,默认是不调用父类方法
        System.out.println("我重写了tell方法");
    }
}

public class ExtendsTest3 {
    public static void main(String[] args){
        B b = new B();
        b.tell();
    }
}

```

- 重写限制
```
被子类重新的方法不能拥有比父类拥有更加严格的访问权限(一般是跟父类一样的访问修饰符或者比父类高)
```

- super关键字
```
强行调用父类的方法的执行

super不一定在重写中使用，也可也表示哪些方法时从父类中继承而来的
```

### 5.5 重写与重载的区别
- 重写与重载
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320102008027-1529173689.png)


## 6.抽象类与接口
### 6.1 final关键字的作用
```
final关键字在Java中被称为完结器，表示最终的意思

final能声明类、方法、属性：	
	使用final声明的类不能被继承
	使用final声明的方法不能被重写
	使用final声明的变量变成常量，常量是不可以被修改的


final声明的属性名大写规范
```

### 6.2抽象类
- 概念
```
包含一个抽象方法的类就是抽象类
```

- 抽象方法
```
声明未被实现的方法，抽象方法必须使用abstract关键字声明

抽象类被子类继承，子类（如果不是抽象类）必须重写抽象类中的所有抽象方法
```

- 定义格式
```
abstract class className{
	属性
	方法
	抽象方法
}


```
- 抽象类不能直接实例化,要通过其子类进行实例化


### 6.3 接口的实现
```
接口可以理解位一种特殊的类，里面全部是由全局变量和公共的抽象方法所组成


接口的实现也必须通过子类，使用关键字implements，而且接口是可以多实现的

一个子类可以同时继承抽象类和实现接口

一个接口不能继承一个抽象类，但是却可以通过extends关键字同时继承多个接口，实现接口的多继承。
```



## 7.面向对象多态性
### 7.1 多态性
- 多态性的体现：
```
	方法的重载和重写
	对象的多态性
```

- 对象的多态性
```
向上转型：程序会自动完成
		父类  父类对象 = 子类实例

向下转型：强制类型转换
		子类   子类对象  =(子类)父类实例
```
- 



### 7.2 多态性的应用
```
package com.legend.POL;


class A{
    public void tell1(){
        System.out.println("A----tell1");
    }

    public void tell2(){
        System.out.println("A----tell2");
    }
}


class B extends A{
    public void tell1(){
        //super.tell1();
        System.out.println("B----tell1");//重写后的方法
    }

    public void tell3(){
        System.out.println("B----tell3");
    }
}

public class PolDemo {
    public static void main(String[] args){
        //向上转向
       /* A a = new B();
        a.tell1();
        a.tell2();*/

        //向下转型
        A a = new B();
        B b = (B) a;
        b.tell1();
        b.tell2();
        b.tell3();
    }
}

```

### 7.3 instanceof 关键字
```
在Java中可以使用instance of关键字判断一个对象是不是一个类的实例
```

### 7.4 抽象类应用
```
package com.legend.absDemo;

class Person{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}


class Student extends Person{
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public Student(int age,String name,int score){
        super(age,name);
        this.score = score;

    }
    public void want(){
        System.out.println("name:"+this.getName()+" age:"+this.getAge()+" Score:"+this.getScore());
    }
}



class Worker extends Person{
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Worker(int age,String name,int money){
        super(age,name);
        this.money = money;
    }

    public void want(){
        System.out.println("name:"+this.getName()+" age:"+this.getAge()+" money:"+this.getMoney());
    }
}

public class AbsDemo {
    public static void main(String[] args){
        Student s = new Student(13,"hh",90);
        s.want();
        Worker w = new Worker(33,"a",1000);
        w.want();
    }
}
 
```
### 7.5 接口的使用
```
package com.legend.interfce;

//接口类
interface USB{
    public void start();
    public void stop();
}

//电脑类
class Computer {

    public static void work(USB u) {
        u.start();
        System.out.println("工作中");
        u.stop();
    }
}

//U盘
class USBDisk implements USB{

    @Override
    public void start() {
        System.out.println("U盘工作中");
    }

    @Override
    public void stop() {
        System.out.println("U盘停止工作");
    }
}

class Printer implements USB{

    @Override
    public void start() {
        System.out.println("打印机开始工作了");
    }

    @Override
    public void stop() {
        System.out.println("打印机停止工作");
    }
}


public class InterDemo2 {
    public static void main(String[] args){
        Computer.work(new USBDisk());
        Computer.work(new Printer());
    }
}

```


## 8 Java面向对象之泛型
### 8.1 认识泛型（Generic）
```
泛型可以解决数据类型的安全性问题，它主要的原理，是在类声明的时候通过一个标识表示类中某个书信的类型或者是某个方法的返回值及参数类型。

格式：
	访问权限 class类名称<泛型,泛型>{
		属性
		方法
	}



对象的创建
	类名称<具体类型>  对象名称 = new 类名称<具体类型>();
```

### 8.2 构造方法中使用泛型
```
构造方法可以为类中的属性初始化，那么如果类中的属性通过泛型指定，而又需要通过构造方法设置属性内容的时候，那么构造方法的定义与之前不无不同，不需要像声明类那样指定泛型
```

- 定义格式
```
 public 类名(T value){
        this.value = value;
    }
```


### 8.3 指定多个泛型
- 定义格式
```
class Gen<K,T>{}

```

```
package com.legend.Generic;

class Gen<K,T>{
    private T take;
    private K key;

    public T getTake() {
        return take;
    }

    public void setTake(T take) {
        this.take = take;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }
}

//使用多种泛型
public class GenericDemo3 {
    public static void main(String[] args){
        Gen<String,Integer> g = new Gen<String,Integer>();
        g.setTake(10);
        g.setKey("aaa");
        System.out.println(g.getKey()+" "+g.getTake());
    }
}

```

### 8.4  通配符
- 定义格式
```
public static void tell(Info<?> o){
        System.out.println("Hello Hand");

    }
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320134112774-1003515376.png)

### 8.5 泛型接口
- 定义格式
```
interface GenInter<T>{
   public void say();
}
```

```
package com.legend.Generic;

interface GenInter<T>{
   public void say();
}

class Gin<T> implements GenInter<String>{
    private String info;

    public Gin(String info){
        this.info = info;
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public void say() {
        System.out.println(this.getInfo());
    }
}

//泛型在接口中的使用
public class GenericDemo5 {
    public static void main(String[] args){
       Gin<String> g = new Gin<String>("HAND");

       System.out.println(g.getInfo());
    }
}

```


### 8.6 泛型方法
- 定义格式
```
public <T>T tell(T t){
       return t;
   }
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320135440213-1071537502.png)


### 8.7 泛型数组
- 定义格式
```
 public static <T>void tell(T arr[]) {
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320135358860-998076641.png)


## 9.Java集合类详解
### 9.1 Collection
- Collection 接口
```
集合可以理解为一个动态的对象数组，不同的是集合中的对象内容可以任意扩充
```
- 集合特点
```
性能高

容易扩展和修改
```

- Collection的常用子类
```
List

Set

Queue
```


### 9.2 List
```
List接口可以存放任意的数据，而且在List接口中内容是可以重复的
```

- List 接口常用子类
```
ArrayList

Vector
```

- 常用操作
```
判断集合是否为空:boolean isEmpty()

查找指定的对象是否存在：int indexOf(Object o)
```

- 实际操作
```
List<String> list = new ArrayList<>();//创建方式
        list.add("a");//添加操作

遍历打印数据
for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+"\t");
        }

list.remove(4);//删除操作

//是否为空
System.out.println("\n"+list.isEmpty());

//查找位置   存在返回具体的索引，不存在返回-1
System.out.println(list.indexOf("b"));
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320143404787-1133426301.png)


### 9.3 Set
- 定义
```
Set接口不能加入重复元素，但是可以排序
```
- 常用子类
```
散列存放：HashSet

有序存放：TreeSet
```

### 9.4 Iterator 迭代器
- 集合输出的标准操作：
```
标准做法，使用Iterator接口
```

- 操作原理
```
Iterator是专门的迭代输出接口，迭代输出就是将元素一个个进行判断,判断其是否有内容，如果有内容则把内容输出
```
### 9.5 Map
- 保存形式
```
key--->value 的方式保存
```

- 常用子类
```
HashMap：无序存放，key不允许重复

Hashtable：无序存放，key不允许重复
```

- 实际操作
```
package com.legend.MapDemo;

import java.util.*;

public class MapDemo {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("name","HAND");
        map.put("time","2019");
        map.put("date","03");
        System.out.print(map.get("name")+"\t");//通过键获取值

        //判断键是否存在
        if(map.containsKey("time")){
            System.out.print(map.get("time")+"\n");
        }

        //判断值是否存在
        if(map.containsValue("time")){
            System.out.println("不存在值");
        }

        //获取所有的键
        System.out.println("\n获取所有的键");
        Set<String> s = map.keySet();
        Iterator<String> it = s.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+"\t");
        }

        //获取所有的值
        System.out.println("\n获取所有的值");
        Collection<String> values = map.values();
        Iterator<String> v = values.iterator();
        while (v.hasNext()){
            System.out.print(v.next()+"\t");
        }
    }
}

```

## 10 Java本地文件操作