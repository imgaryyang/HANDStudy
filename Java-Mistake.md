## Java开发犯的十大错误 

### 将Array转换成ArrayList
若要将数组转换成ArrayList 开发人员经常这样做
```
List list = Arrays.asList(arr);
```

#### 原因分析
`Arrays.asList()将返回一个ArrayList对象`，但是这个类是Arrays中的`私有静态内部类`。`Arrays，这不是java.util.ArrayList类`。这个`java.util.Arrays.ArrayList类有set(), get(), contains()方法`，但没有任何添加元素的方法，因此其大小是固定的。

#### 解决办法
创造一个真实的ArrayList，你应该做：
```
ArrayList arrayList = new ArrayList(Arrays.asList(arr));
```

>ArraysList 的构造可以接受一个集合类型，这也是java.util.Arrays.ArrayList.


---
### 检查Array 是否包含一个特定的值
开发人员经常这样做：

```
Set set = new HashSet(Arrays.asList(arr)); 
return set.contains(targetValue);
```

#### 原因分析
代码可以工作，但不需要将数组先转为list再转换set，这样需要额外的时间。

#### 解决办法
它可以简单到：
```
Arrays.asList(arr).contains(targetValue);
```

或

```
for(String s: arr){ 
	if(s.equals(targetValue)) 
		return true; 
	} 
	return false;
```

>第一个比第二个更易读。

---

### 迭代时移除一个list集合中的元素
先看一下在迭代过程中移除list中元素的代码：

```
ArrayList list = new ArrayList(Arrays.asList("a", "b", "c", "d"));

for (int i = 0; i < list.size(); i++) {
   list.remove(i);
 } 
 System.out.println(list);
```

输出如下：
```
[b, d] 
```

#### 原因分析
这种方法存在一个严重的问题。当一个元素被移除时，list的大小会缩小，索引也会发生变化。因此，如果要通过使用索引删除循环中的多个元素，这将无法正常运行。

你可能知道使用迭代器是删除循环中于元素的正确方法，而且你知道在Java中foreach 循环的工作方式类似于迭代器，但实际上并非如此。


#### 解决办法

```
ArrayList list = new ArrayList(Arrays.asList("a", "b", "c", "d"));

for (String s : list) { 
   if (s.equals("a")) 
      list.remove(s); 
 }
```

>它会被扔出去ConcurrentModificationException.

相反，以下内容是可以的：

```
ArrayList list = new ArrayList(Arrays.asList("a", "b", "c", "d")); 
Iteratoriter = list.iterator(); 
while (iter.hasNext()) { 
  String s = iter.next();
  if (s.equals("a")) {
    iter.remove();
  }
}
```

>next()  必须在remove()  之前被调用，在foreach 循环中，编译器将使next()  在移除元素操作后被调用，这将导致 ConcurrentModificationException 你可以看看ArrayList.iterator()的源码.


### Hashtable与HashMap

根据算法中的约定，Hashtable是数据结构的名称。但是在Java中，数据结构的名称是HashMap，其中一个关键的区别是：Hashtable是同步的，而HashMap不是同步的。所以很多时候你不需要Hashtable，相反HashMap应该用。


### 使用原生的collection
在JAVA中，原始类型和无界通配符类型很容易混合在一起。举个例子，Set是原始类型，而Set<?>是无界通配符类型。


考虑使用原始类型的下列代码List作为参数：

```
public static void add(List list, Object o){ 
  list.add(o); 
}
public static void main(String[] args){
   Listlist = new ArrayList(); 
   add(list, 10); 
   String s = list.get(0);
  } 
```

`此代码将引发异常：`
```
Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String at ...
```

>使用原始类型集合是危险的，因为原始类型集合跳过泛型类型检查，并且不安全。实际上Set, Set<?>，和Set之间有很大的区别。


### 访问权限
开发人员经常在类字段中使用public。通过直接引用可以很容易地获得字段值，但这是一个非常糟糕的设计。`正确的设计应该是为成员提供尽可能低的访问权限。`


### ArrayList和LinkedList

当开发人员不知道ArrayList和LinkedList的区别时，他们经常使用ArrayList因为它看起来很熟悉。然而，它们之间存在着巨大的性能差异。总之，LinkedList如果有大量的添加/删除操作，并且没有很多随机访问操作，则应优先考虑。访问操作频繁时使用ArrayList。



### 可变与不可变
不可变对象具有许多优点，如简单性、安全性等。但是他需要为每个不同的值单独设置一个对象，过多的对象可能会导致垃圾收集的成本过高。在可变和不可变之间应该有一个平衡。


通常，可变对象用于避免过多的中间对象。一个典型的例子是连接大量的字符串。如果使用不可变字符串，则会立即生成许多符合垃圾回收条件的对象。这浪费了CPU的时间和精力，使用了一个不可变的对象


#### 解决方案
StringBuffer和StringBuilder

```
String result = "";
for(String s : str){
	result = result + s;
}
```

其他情况下，可变对象是可取的。例如，将可变对象传递到方法中，可以收集多个结果，而不需要跳过太多的语法圈。另一个例子是排序和过滤：当然你可以创建一个获取原始集合并返回排序的集合方法，但是对于较大的集合来说，这将变得非常浪费。


### SuperAndSub 的构造函数
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191224135953369-1367663926.png)


发生此编译错误是因为默认父构造函数未定义。在Java中，如果类没有定义构造函数，编译器将在默认情况下为类插入默认的无参构造函数。如果在SuperClass中定义了构造函数，在本例中是Super(String S), 编译器将不会插入默认的无参构造函数。以上是父类的情况。

子类的构造函数，无论是参数还是非参数，都将调用无参数父构造函数。由于编译器试图将Super()   插入到Sub类的2个构造函数，但是没有定义Super默认构造函数，所以编译器会报告错误消息。

要解决这个问题，只需向Superclass添加一个Super()构造函数，如下所示：

```
public Super(){ 
	System.out.println("Super");
}
```

 或者删除自定义的父构造函数，或添加super(value)到子类的构造方法中


### " " 或者构造?

字符串可以通过两种方式创建：
```
//1.use douvle quotes
String x = "abc";

//2.use constructor
String y = new String("abc");
```

有什么关系? 下面的例子可以提供一个快速的答案：

```
String a = "abcd";
String b = "abcd";

System.out.println(a == b);//true
System.out.println(a.equals(b));//true

String c = new String("abcd");
String d = new String("abcd");
System.out.println(c == d);//false
System.out.println(c.equals(d));//true
```



