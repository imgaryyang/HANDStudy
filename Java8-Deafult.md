## Java8新特性之Lambda表达式，函数式接口，方法引用和default关键字

### Lambda表达式
Lambda表达式,也成为闭包，允许把函数作为一个参数，使代码更简洁

#### 那什么是函数式编程呢？
```
函数式编程就是一种抽象程度很高的编程范式,纯粹的函数式编程语言编写的函数没有变量,因此,任意一个函数,只要输入是确定的,这种纯函数我们称之为没有副作用.而允许使用变量的程序设计语言,由于函数内部的变量状态不确定,同样输入,可能得到不同的输出,因此,这种函数是有副作用的.函数式编程的特点就一个,允许把函数本身作为参数传入另一个函数,还允许返回一个函数.
```


#### 基本语法
```
//1.不需要参数,返回值为5
() -> 5

//2.接受一个参数(数字类型),返回其2倍的值
x -> 2 * x

// 3. 接受2个参数(数字),并返回他们的差值  
(x, y) -> x – y  

// 4. 接收2个int型整数,返回他们的和  
(int x, int y) -> x + y  

// 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)  
(String s) -> System.out.print(s)
```

#### 基础例子
- 创建线程
```
public static void noParam() {
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("hello world by xx");
        }

    }).start();
}

public static void noParamUseLambda() {
    //使用Lambda表达式创建线程
    new Thread(() -> System.out.println("hello world by lambda")).start();
}
```

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191231140617407-497870568.png)

`测试结果`
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191231140801187-2076912761.png)

- 遍历map集合

```
public static void mapForeach(Map<String, String> map) {
    //使用增强for的方式来遍历hashMap
    for (Map.Entry<String, String> entry : map.entrySet()) {
        System.out.println(entry.getKey() + "....." + entry.getValue());
    }
    System.out.println();
}

public static void mapForeachUseLambda(Map<String, String> map) {
    map.forEach((key, value) -> {
        System.out.println(key + ":" + value);
    });
}
```

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191231140838047-1353355835.png)

`测试结果`
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191231140927980-96022793.png)

>引入lambda表达式的一个最大的好处就是大大的简化了代码的开发。当然，不是所有的接口都可以通过这种方法来调用，只有函数式接口才行。


---


### 函数式接口
- 只包含一个抽象方法的接口,称为函数式接口。
- 可以通过Lambda表达式来创建该接口的对象(若Lambda表达式抛出一个受检异常，那么该异常需要在目标接口的抽象方法上进行声明)。
- 可以在任意函数式接口上使用 `@FunctionalInterface` 注解，这样做可以检查它是否是一个函数式接口，同时 javadoc 也会包 含一条声明，说明这个接口是一个函数式接口。
- 之所以Lambda必须和函数式接口配合是因为，接口如果多个函数，则Lambda表达式无法确定实现的是哪个


#### 基础例子
- 自定义函数接口
```
/**
 * 转换大写字母(自定义函数式接口)
 *
 * @param interStr
 * @param str
 */
public static String toUpperString(MyInterface<String> interStr, String str) {
    return interStr.getValue(str);
}


//ABC
log.info("{}", toUpperString(str -> str.toUpperCase(), "abc"));
System.out.println(toUpperString(str -> str.toUpperCase(), "abc"));

//匿名内部类的写法
System.out.println(toUpperString(new MyInterface<String>() {
    @Override
    public String getValue(String s) {
        return s;
    }
}, "abc"));
```

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191231143929734-1804593386.png)


`测试结果`
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191231143815446-93696708.png)

>作为参数传递 Lambda 表达式：为了将 Lambda 表达式作为参数传递，接 收Lambda 表达式的参数类型必须是与该 Lambda 表达式兼容的函数式接口 的类型。



### Java内置四大核心函数式接口

| 函数式接口      |    参数类型 |  返回类型  |用途 |
| :-------- | --------:| :------: |
| Consumer消费型接口|   T |  void| 对类型为T的对象应用操作包含方法：void accept(T t) |
| Supplier供给型接口|  无 |  T| 返回类型为T的对象，包 含方法：T get(); |
| Function<T,R> 函数行接口 |   T |  R| 对类型为T的对象应用操 作，并返回结果。结果 是R类型的对象。包含方 法：R apply(T t); |
| Predicate 断言型接口 |   T |  boolean | 确定类型为T的对象是否 满足某约束，并返回 boolean 值。包含方法 boolean test(T t); |


#### 使用场景
之前 MyInterface 这种接口配合Lambda 使用，可以发现必须先声明接口，很麻烦，而内置的接口借口就是解决这种问题的；而这些内置的接口也存在大量的内部实现，或者编程者自己定义的类，只要符合对应的参数类型和返回值类型的，都可以使用。例如：定义MyClass只要符合参数T返回R，则都可以使用Function<T, R> 函数型接口对应形式，包含下面的构造器引用，方法引用等等形式

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191231150831377-1747575881.png)

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191231150852237-1339779085.png)

`ALL`
```
package com.legend.test;

import com.legend.interfaces.MyInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


/**
 * @author legend
 */
public class TestDemo2 {

    private static Logger log = LoggerFactory.getLogger(TestDemo2.class);

    public static void main(String[] args) {
        //传统写法
        noParam();
        //Lambda语法
        noParamUseLambda();

        Map<String, String> map = new HashMap<>();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("legend", "HAND");
        //传统写法
        mapForeach(map);
        //Lambda语法
        mapForeachUseLambda(map);


        //ABC
        log.info("{}", toUpperString(str -> str.toUpperCase(), "abc"));
        System.out.println(toUpperString(str -> str.toUpperCase(), "abc"));

        //匿名内部类的写法
        System.out.println(toUpperString(new MyInterface<String>() {
            @Override
            public String getValue(String s) {
                return s;
            }
        }, "abc"));


        //匿名内部类的写法
        System.out.println(toUpperString1(new MyInterface<String>() {
            @Override
            public String getValue(String s) {
                return s;
            }
        }, "abc"));

        //使用内置的函数式接口的lambda写法
        System.out.println(toUpperString(str->str.toUpperCase(),"abc"));
    }

    /**
     * 内置函数式接口
     *
     * @param mn
     * @param str
     * @return
     */
    public static String toUpperString1(Function<String, String> mn, String str) {
        return mn.apply(str);
    }

    /**
     * 定义的函数接口
     *
     * @param mn
     * @param str
     * @return
     */
    public static String toUpperString1(MyInterface<String> mn, String str) {
        return mn.getValue(str);
    }


    /**
     * 转换大写字母(自定义函数式接口)
     *
     * @param interStr
     * @param str
     */
    public static String toUpperString(MyInterface<String> interStr, String str) {
        return interStr.getValue(str);
    }


    /**
     * 遍历map集合
     *
     * @param map
     */
    public static void mapForeach(Map<String, String> map) {
        //使用增强for的方式来遍历hashMap
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "....." + entry.getValue());
        }
        System.out.println();
    }

    public static void mapForeachUseLambda(Map<String, String> map) {
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }


    /**
     * 空参数
     */
    public static void noParam() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world by xx");
            }

        }).start();
    }

    public static void noParamUseLambda() {
        //使用Lambda表达式创建线程
        new Thread(() -> System.out.println("hello world by lambda")).start();
    }
}

```
	
### 方法引用与构造器引用
#### 方法引用
当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！（实现抽象方法的参数列表，必须与方法引用方法的参数列表保持一致！） 方法引用：使用操作符 “::” 将方法名和对象或类的名字分隔开来。 如下三种主要使用情况：
- 对象:: 实例方法
- 类::静态方法
- 类:: 实例方法

#### 基础例子
```
//例如：此时Consumer参数类型和返回值和println方法一致
//对象::实例方法名
//为什么这样用,因为 ConSumer这个函数接口就是传入参数，返回为void ,并且println 方法就是这样的
/**我们看下面的源码 和那个函数接口一样
 *     public void println(String x) {
 *         synchronized (this) {
 *             print(x);
 *             newLine();
 *         }
 *     }
 */

PrintStream printStream=System.out;
Consumer<String> con= printStream::println;
con.accept("haha");


//类::静态方法名
Comparator<Integer> com=Integer::compare;
Comparator<Integer> com1=(x,y)->Integer.compare(x,y);
```

#### 构造器引用
格式:CLassName:: new

与函数式接口相结合，自动与函数式接口中方法兼容。可以吧构造器引用赋值给定义的方法，与构造器参数列表要与接口中抽象方法的参数列表一致。
```
Function<Integer,MyClass> fun= n->new MyClass(1);
Function<Integer,MyClass> fun1=MyClass::new;
MyClass apply = fun1.apply(1);
```
>如果存在多个构造器，会自动匹配对应参数或者无参的构造器,取决于apply传递的参数。


### default关键字
在Java里面，我们通常都是认为接口里面是只能有抽象方法，不能有任何方法的实现的，那么在jdk1.8 里面打破了这个规定，引入了新的关键字default，通过使用default修饰方法，可以让我们在接口里面定义具体的方法实现，如下

```
public interface NewCharacter {
    public void test1();
    public default void test2(){
        System.out.println("legend我是新特性xxxx");
    }
}
```

`那这么定义一个方法的作用是什么呢?为什么不在接口的实现类里面再去实现方法呢?`

>其实这么定义一个方法的主要意义是定义一个默认方法，也就是说这个接口的实现类实现了这个接口之后，不用管这个default修饰的方法，也可以直接调用，如下。


```
package com.legend.interfaces.impl;

import com.legend.interfaces.NewCharacter;

/**
 * 新特性关键字--default
 */
public class NewCharacterImpl implements NewCharacter {

    @Override
    public void test1() {
        System.out.println("test1");
    }
    public static void main(String[] args) {
        NewCharacter nca = new NewCharacterImpl();
        nca.test2();
    }
}
```

`测试结果`
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191231155617134-1955720023.png)


>所以说这个default方法是所有的实现类都不需要去实现的就可以直接调用,比如说jdk的集合List里面新增一个sort方法那么如果定义为一个抽象方法，其所有的实现类如arrayList,LinkedList等都需要对其添加实现，那么现在用default定义一个默认的方法之后，其实现类可以直接使用这个方法了，这样不管是开发还是维护项目，都会大大简化代码量。