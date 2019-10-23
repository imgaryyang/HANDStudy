## String源码分析 ---哈希篇
基于JDK1.8

`从一段代码开始`
```
System.out.println("a"  +  "b"  ==  "ab");//true
System.out.println(new  String("ab")  ==  "ab");//false
```


>第一行结果为true，第二行结果为false，两者结果不同的原因在于Java中的  ==  符号判断的是对象是否相等，其实质上是比较两者的内存地址，很显然第一行两边指向同一对象，而第二行指向不同对象。
>String中判断字符串的字面值是否相等要用equals() 方法而不是 == ，那么String类中 equals() 究竟是怎么实现的?

深入String类中有关哈希的部分，主要有以下几个要点：
- equals() 方法的实现
- 哈希值、字面值与内存地址之间的关系
- 哈希碰撞与生日攻击



### equals() 方法的实现
String类属于 "值类"。程序员在比较字符串时，希望指导它们在逻辑上是否相等，而不是想了解它们是否指向同一个对象。

值类仅仅是一个表示值的类，具有自己特有的 "逻辑相等" 概念，因此为了满足比较的需求，String类需要覆盖Object类的equals()  方法。
```
每个值至多至存在一个对象的"值类"不需要覆盖 equals 方法。如枚举类型
```

String 的equals() 实现如下：
```
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

如果比较的两个字符串指向同一个对象或者每个位子上的字符相等，则返回true。以上实现遵守了Object 的规范[JavaSE6]：
- 自反性。对于任何非null 的引用值x，x.equals(x)必须返回true。
- 对称性：对于任何非null的引用值x和y，当且仅当y.equals(x) 返回true时，x.equals(y)必须返回true。
- 传递性。对于任何非null的引用值x和y和z，如果x.equals(y)返回true，并且y.equals(z)也返回true，那么x.equals(z)d也必须返回true。

- 一致性。对于任何非null的引用值x和y，只要equals的比较操作在对象中所用的信息没有被修改，多次调用x.equals(y)就会一致地返回true，或者一致地返回false

### hashcode的实现
那么，在覆盖了Object.equals()方法之后是否就可以进行比较了呢？回答当然是不。覆盖equals时总要覆盖hashCode

#### 哈希是什么
所谓哈希(hash)就是讲不通的输入映射成独一无二的、固定长度的值(又称哈希值)，它是软件常见的运算之一。如果我们在覆盖了equals()  方法之后没有覆盖hashCode()  将会导致String类无法结合所有基于散列的集合一起正常运作，这样的集合包括hashMap、HashSet和HashTable。

>无法运作的原因在于我们违反了一条关键的约定，相等的对象必须具有相同的散列码(hashcode)

`String类中的hashCode()方法`

```
public int hashCode() {
   int h = hash;
   if (h == 0 && value.length > 0) {
	char val[] = value;
	for(int i = 0;i < value.length;i++){
	   h = 31 * h + val[i];
	}   
	hash = h;
   }
   return h;
}
```
>一个String实例的hash值只与其内容有关。从代码实现来看，String类计算哈希值实际上就是通过公式(s代表字符串，n代表字符串长度)： s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]

在Java Effective中有提及：

之所以选择31，是因为它是一个奇素数。如果乘数是偶数，并且乘法溢出的话，信息就会丢失，因为与2相乘等价于移位运算。使用素数的好处并不明显，但是习惯上都使用素数来计算散列结果。31有个很好的特性。即用移位和减法来代替乘法，可以得到更好的性能：31 * i == (i << 5) - i。现代的VM可以自动完成这种优化。

一个好的散列函数通常倾向于"为不相等的对象产生不相等的散列码"。理想情况下，	散列函数应该把集合中不相等的实例均匀地分布到所有可能的散列值上。

31是一个奇素数，如果使用非奇素数，非奇素数代表着乘以偶数会导致较少的位包含"变化"信息，即若低位变为零，乘完之后还是零。用偶数会失去一点“可变性”。结果是可能的哈希值分布较差。

除此之外。31可以保证比较少的哈希碰撞， 31i=32i-i=(i<<5)-i，这种位移与减法结合的计算相比一般的运算快很多。

### String类为什么要设计成不可继承？
讲方法或类声明为final主要目的是：确保他们不会在子类中改变语义。String基本预定中最重要的一条是 `immutable(不可变性)`，加入String是可集成的，那么你的String Child类就有可能被覆写为 `mutable(可变的)`这样就打破了成为共识的基本约定。


简单说来，整个JDK体系中依赖了 String的的不可变性，不可继承就是为了守护不变性。

String不可变，通过底层的实现 +　声明的final 的双重保证实现了不可变性

### String类不可变性的好处?
不可变对象，顾名思义就是其创建后不改变的对象，请看如下代码：

```
String s = "ABC"; 
s.toLowerCase();
```
>toLowerCase() 并没有改变 “ABC”的值，而是创建了一个新的String 实例 “abc” ，然后将新的实例的指向变量s

相对于可变对象，不可变对象好处：
- 不可变对象可以提高String pool的效率和安全性，如果你知道吗一个对象是不可变的，那么需要拷贝这个对象的内容时，就不用复制它的本身只是复制它的地址，复制地址(通常一个指针的大小)需要很小的内存效率也很高。对于同时引用这个“ABC”的其他变量也不会造成影响。
- 不可变对象对于多线程是安全的，因为在多线程同时进行的情况下，一个可变对象的值 很可能被其他进程改变，这样会造成不可预期的结果，而使用不可变对象就可避免这种情况。

>当然也有其他方面的原因，但是最初Java把String设成immutable最大的原因应该就是效率和安全的


### 成员变量是为何
```
/** The value is used for character storage. */
private final char value[];
/** Cache the hash code for the string */
private int hash; // Default to 0
/** use serialVersionUID from JDK 1.0.2 for interoperability */
private static final long serialVersionUID = -6849794470754667710L;
/** Class String is special cased within the Serialization Stream Protocol. */
private static final ObjectStreamField[] serialPersistentFields =
new ObjectStreamField[0];
```

>以上是String中的所有成员变量

#### 字符存储
在JDK8时，是将字符存储在char数据中，每个字符将使用两个字节(十六位)。从许多不同的应用程序收集的数据表明字符串是堆使用的主要组成部分，而且，大多数String对象只包含Latin-1字符，这些字符只需要一个字节的存储空间，因此char 型的String对象的内部数组有一半的空间未使用。

但是JDK9开始，空间占用方面有了一个优化。String的数据存储格式从
```
private final char[] value;

-->

private final byte[] value;
```

在JDK9及以后的版本，String源码内部多定义了一个变量
```
private final byte coder;
```

通过`coder` 判断使用LATIN还是UTF16，当字符串都能用LATIN1表示，值就是0，否则就是1.从以下源码可以看出，在处理字符串长度时，如果是char则长度除以2

```
static final boolean COMPACT_STRINGS;
static {
    COMPACT_STRINGS = true;
}
public int length(){
    return value.length >> coder();
}
byte coder(){
    return COMPACT_STRINGS ? coder : UTF16;
}
@Native static final byte LATIN1 = 0;
@Native static final byte UTF16 = 1;
```

### 序列化和反序列化
何谓序列化?Java的对象随着JVM 的运行而被保存在内存中，随着JVM的停止而丢弃消亡。很多时候，这些对象或是不可重建的，JVM运行时，少量的对象被保持在内存中是可以接受的。然而一旦JVM需要被停止，或在运行过程中建立了许多的对象，对象的数量多到影响操作系统的正常运行乃至多到物理内存都存不下时，这些对象只能想办法保存起来

提到保存对象，或者说是持久化。最熟知的莫过于保存到文件系统或数据库。这种做法一般涉及到自定义存储格式以及繁琐的数据转换。Java序列化就是java提供的简单的对象保存为字节数组的方法。除此以外，使用RMI (远程方法调用)，或用网络传递对时，都会用到对象序列化。

>序列化就是对象到字节码的过程，反序列化就是从字节码到对象的过程。

很多时候用默认机制序列化对象是不合理的。

或者对象的某个属性引用的对象不能支持序列化接口，或者对象中包含了一些敏感的数据如银行卡的账号和密码，或者对象包含的数据并非都是有意义的比如临时变量。这时，我们可以指定那些数据可以序列化，那些都是不需要的。


限定序列化的数据的方法有两种，一种是用瞬态修饰符 `transient`修饰不用序列化的属性。另外一个种是添加一个`serialPersistentFields` 域来声明序列化时要包含的域

在源码中
```
private static final long serialVersionUID = -6849794470754667710L;
private static final ObjectStreamField[] serialPersistentFields =
                                                new ObjectStreamField[0];
```
>serialVersionUID是一个序列化版本号，Java通过这个UID来判定反序列化时的字节流与本地类的一致性，如果相同则可以进行反序列化，不同就会异常。至于为什么用定义参与序列化的域的静态字段serialPersistentFields的数组长度为0





