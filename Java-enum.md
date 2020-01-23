## Java枚举

![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200123211953361-1823694972.png)


### 枚举类型是什么
JDK5引入了一种新特性，关键字enum 可以将一组具名的值的有限集合创建为一种新的类型，而这些具名的值可以作为常规的程序组件使用，这就是枚举类型。

`一个枚举的简单例子`

```
enum SeasonEnum {
    SPRING,SUMMER,FALL,WINTER;
}
```


### 枚举类的常用方法
`Enum 常用方法有以下几种：`

- name():返回enum实例声明时的名字
- ordinal();返回一个int值，表示enum 实例在声明的次序
- equals();返回布尔值，enum实例判断相等
- compareTo();比较enum实例与指定对象的顺序
- values();返回enum 实例的数组
- valuesOf(String name) 由名称获取枚举类中定义的常量


`结合例子实现`
```
package com.legend.enumdemo;

/**
 * 枚举测试类
 */
enum Shrubbery {
    GROUND, CRAWLING, HANGING
}


/**
 * @author legend
 */
public class EnumClassTest {
    public static void main(String[] args) {
        //values 返回enum实例的数组
        for (Shrubbery temp : Shrubbery.values()) {
            // name 返回实例enum声明的名字
            System.out.println(temp.name() + " ordinal is " + temp.ordinal() + " ,equal result is " +
                    Shrubbery.CRAWLING.equals(temp) + ",compare result is " + Shrubbery.CRAWLING.compareTo(temp));
        }
        //由名称获取枚举类中定义的常量值
        System.out.println(Shrubbery.valueOf("CRAWLING"));
    }
}
```

![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200123213220315-1971566810.png)


### 枚举类的真面目
枚举类型到底是什么类呢?

- 新建一个简单枚举
```
public enum Shrubbery {
    GROUND,CRAWLING, HANGING
}
```

- 使用javac编译上面的枚举类，可得Shrubbery.class文件。
```
javac Shrubbery.java
```

- 再用javap命令，反编译得到字节码文件。如：执行javap Shrubbery.class可到以下字节码文件。

```
Compiled from "Shrubbery.java"
public final class enumtest.Shrubbery extends java.lang.Enum<enumtest.Shrubbery> {
  public static final enumtest.Shrubbery GROUND;
  public static final enumtest.Shrubbery CRAWLING;
  public static final enumtest.Shrubbery HANGING;
  public static enumtest.Shrubbery[] values();
  public static enumtest.Shrubbery valueOf(java.lang.String);
  static {};
}
```

从字节码文件可以发现：
```
- Shrubbery 枚举变成了一个final修饰的类，也就是说，他不能被继承
- Shrubbery是java.lang.Enum的子类
- Shrubbery定义的枚举值都是 public static final 修饰的，即都是静态变量
```


### 枚举类的优点
枚举类有什么优点呢?  就是我们为什么要选择使用枚举类呢? 因为它增强代码的可读性，可维护性，同时，它也具有安全性。


#### 枚举类可以增强可读性、可维护性

假设现在有这样的业务场景：订单完成后，通知买家评论。很容易有以下代码：
```
//订单已完成
if(3==orderStatus){
	//do something    
}
```

很显然，这段代码出现了魔法数，如果你没写注释，谁知道3表示订单什么状态呢，不仅阅读起来比较困难，维护起来也很蛋疼？如果使用枚举类呢，如下：

```
public enum OrderStatusEnum {
    UNPAID(0, "未付款"),
    PAID(1, "已付款"),
    SEND(2, "已发货"),
    FINISH(3, "已完成"),
    ;

    private int index;

    private String desc;

    public int getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }

    OrderStatusEnum(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }
}


//订单已完成
 if(OrderStatusEnum.FINISH.getIndex()==orderStatus){
  //do something
 }
```

>可见，枚举类让这段代码可读性更强，也比较好维护，后面加个新的订单状态，直接添加多一种枚举状态就可以了，有些人认为，public static final int这种静态常量也可以实现该功能呀

```
public class OrderStatus {
    //未付款
    public static final int UNPAID = 0;
    public static final int PAID = 1;
    public static final int SENDED = 2;
    public static final int FINISH = 3;
    
}

//订单已完成
if(OrderStatus.FINISH==orderStatus){
    //do something
}
```

>当然静态常量这种方式实现，可读性是没有任何问题的
>但是，定义int值相同的变量，容易混淆，如你定义PAID和SENDED状态都是2，编译器是不会报错的。


**因此，枚举类第一个优点就是可读性，可维护性都不错，所以推荐。**


#### 枚举类安全性
除了可读性、可维护性外，枚举类还有个巨大的优点，就是安全性。

从上一节枚举类字节码分析我们知道：
- 一个枚举类是final关键字修饰的，不能被继承
- 并且它的变量都是public static final 修饰的，都是静态常量


>当一个Java类第一次被真正使用到的时候静态资源被初始化、Java类的加载和初始化过程都是线程安全的。


### 枚举的常见用法

#### enum 组织常量 
