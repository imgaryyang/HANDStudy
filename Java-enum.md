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
在JDK5之前，常量定义都是这样，先定义一个类或者接口，属性类型都是public static final...，有了枚举之后，可以把常量组织到枚举类了，如下：

```
enum SeasonEnum {
    SPRING,SUMMER,FALL,WINTER,;
}
```

#### enum与switch 环环相扣
一般来说，switch-case 中只能使用整数值，但是枚举实例天生就具备整数值的次序，因此，在switch语句中是可以使用enum的，如下：
```
enum OrderStatusEnum {
   UNPAID, PAID, SEND, FINISH
}

package com.legend.enumdemo.advantage;

/**
 * enum-switch 相结合使用测试
 *
 * @author legend
 */
public class OrderStatusTest {
    public static void main(String[] args) {
        //改变订单状态
        changeByOrderStatus(OrderStatusEnum.FINISH);

    }

    /**
     * 改变订单状态
     *
     * @param orderStatusEnum
     */
    private static void changeByOrderStatus(OrderStatusEnum orderStatusEnum) {
        switch (orderStatusEnum) {
            case UNPAID:
                System.out.println("你下单了，赶紧付钱吧");
                break;
            case PAID:
                System.out.println("我已经付钱啦");
                break;
            case SEND:
                System.out.println("已发货");
                break;
            case FINISH:
                System.out.println("订单完成啦");
                break;
        }
    }
}
```
>在日常开发中，enum与switch一起使用，会让你的代码可读性更好


#### 向枚举类添加新方法的，如get方法，普通方法等，一下是日常工作最常用的一种枚举写法：


```
public static OrderStatusEnum of(int index) {
    for (OrderStatusEnum temp : values()) {
        if (temp.getIndex() == index) {
            return temp;
        }
    }
    return null;
}
```

#### 枚举实现接口
所有枚举类都继承与java.lang.Enum 所以枚举不能再继承其他类了。但是枚举可以实现接口，如下：

```
public interface Food {
    enum Coffee implements Food{
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
    }

    enum Dessert implements Food{
        FRUIT, CAKE, GELATO
    }
}
```

### 枚举类比较是用 == 还是 equals?

```
package com.legend.enumdemo.equals;

/**
 * 枚举类比较
 *
 * @author legend
 */
public class EnumTest {

    public static void main(String[] args) {

        Shrubbery s1 = Shrubbery.CRAWLING;
        Shrubbery s2 = Shrubbery.GROUND;
        Shrubbery s3 = Shrubbery.CRAWLING;

        System.out.println("s1==s2,result: " + (s1 == s2));
        System.out.println("s1==s3,result: " + (s1 == s3));
        System.out.println("Shrubbery.CRAWLING.equals(s1)，result: " + Shrubbery.CRAWLING.equals(s1));
        System.out.println("Shrubbery.CRAWLING.equals(s2),result: " + Shrubbery.CRAWLING.equals(s2));

    }
}
```

`运行结果:`
```
s1==s2,result: false
s1==s3,result: true
Shrubbery.CRAWLING.equals(s1)，result: true
Shrubbery.CRAWLING.equals(s2),result: false
```

>可以发现不管用 ==  还是equals 都是可以的。其实美剧的equals 方法，就是用 == 比较的

```
public final boolean equals(Object other) {
    return this==other;
}
```



### 枚举实现的单例

effective java提过，最佳的单例模式就是枚举模式。单例模式的实现有好几种方式，为什么枚举实现的方式最佳?

因为枚举实现的单例有以下优点：
- 枚举单例写法简单
- 枚举可解决线程安全问题
- 枚举可解决反序列化会破坏单例的问题

一个枚举单例demo如下：
```
package com.legend.enumdemo.singleton;

/**
 * 枚举实现的单例
 *
 * @author legend
 */
public class SingletonEnumTest {

    public static void main(String[] args) {
        SingletonEnum.INSTANCE.setName("legend@qichunlin");
        System.out.println(SingletonEnum.INSTANCE.getName());
    }


    public enum SingletonEnum {
        INSTANCE,
        ;

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

```


### EnumSet 和 EnumMap

#### EnumSet
`先来看看EnumSet的继承体系图`
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125123706774-1994413904.png)


>显然，EnumSet也实现了set接口，相比于HashSet，它有以下优点:
- 消耗较少的内存
- 效率更高，因为是位向量实现的。
- 可以预测的遍历顺序(enum 常量的声明顺序)
- 拒绝加 null


**EnumSet就是set的高性能实现，它的要求就是存放必须是同一枚举类型。EnumSet的常用方法：**
- allof()   创建一个包含指定枚举类里所有枚举值的EnumSet集合
- range()  获取某个范围的枚举实例
- of()   创建一个包括参数中所有枚举元素的EnumSet集合
- complementOf()   初始枚举集合包括指定枚举集合的补集


```
package com.legend.enumdemo.enumset;

import java.util.EnumSet;

/**
 * EnumSet枚举
 *
 * @author legend
 */
public class EnumTest {

    public static void main(String[] args) {

        EnumSet<SeasonEnum> set1, set2, set3, set4;

        set1 = EnumSet.of(SeasonEnum.SPRING, SeasonEnum.FALL, SeasonEnum.WINTER);
        set2 = EnumSet.complementOf(set1);
        set3 = EnumSet.allOf(SeasonEnum.class);
        set4 = EnumSet.range(SeasonEnum.SUMMER, SeasonEnum.WINTER);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Set 3: " + set3);
        System.out.println("Set 4: " + set4);

    }
}
```

`运行结果:`

```
Set 1: [SPRING, FALL, WINTER]
Set 2: [SUMMER]
Set 3: [SPRING, SUMMER, FALL, WINTER]
Set 4: [SUMMER, FALL, WINTER]
```


### EnumMap
EnumMap的继承体系图如下：
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125125624960-543222768.png)

>显然，EnumMap也实现了Map接口，相比于HashMap，它有以下优点:
- 消耗较少的内存
- 效率更高
- 可以预测的遍历顺序
- 拒绝 null

EnumMap就是map的高性能实现。 它的常用方法跟HashMap是一致的，唯一约束是枚举相关。

看实例
```
package com.legend.enumdemo.enummap;

import java.util.EnumMap;
import java.util.Map;

/**
 * enumMap 实现
 */
public class EnumTest {
    public static void main(String[] args) {
        Map<SeasonEnum, String> map = new EnumMap<SeasonEnum, String>(SeasonEnum.class);
        map.put(SeasonEnum.SPRING, "春天");
        map.put(SeasonEnum.SUMMER, "夏天");
        map.put(SeasonEnum.FALL, "秋天");
        map.put(SeasonEnum.WINTER, "冬天");

        System.out.println(map);
        System.out.println(map.get(SeasonEnum.SPRING));
    }
}

```
`运行结果:`
```
{SPRING=春天, SUMMER=夏天, FALL=秋天, WINTER=冬天}
春天
```
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125143601266-1272818066.png)