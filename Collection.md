# 集合
## List 和 Set 区别
- List集合
```
1.可以允许重复的对象。
2.可以插入多个null元素。
3.是一个有序容器，保持了每个元素的插入顺序，输出的顺序就是插入的顺序。
4.常用的实现类有 ArrayList、LinkedList 和 Vector。ArrayList 最为流行，它提供了使用索引的随意访问，而
LinkedList 则对于经常需要从 List 中添加或删除元素的场合更为合适。

ArrayList 底层数组形式
LinkedList 底层双向链表
Vector	底层数组，线程安全
```

- Set集合
```
1.不允许重复对象

2.无序容器，你无法保证每个元素的存储顺序，TreeSet通过Comparator或者Comparable维护了一个排序顺序。

3.只允许一个null元素
4.Set 接口最流行的几个实现类是 HashSet、LinkedHashSet 以及 TreeSet。最流行的是基于 HashMap
实现的 HashSet；TreeSet 还实现了 SortedSet 接口，因此 TreeSet 是一个根据其 compare() 和
compareTo() 的定义进行排序的有序容器。

```


- 区别
```
1.List和Set都是接口继承于Collection接口。

2.最大的不同就是List是可以重复的，而set是不能重复的,(注意：元素虽然无放入顺序，但是元素在set中的位置是由该元素的HashCode决定的，其位置是固定的)

3.List接口有三个实现类：LinkedList，ArrayList，Vector；Set接口有两个实现类：HashSet（底层由HashMap实现），LinkedHashSet

4.List适合经常追加数据，插入，删除数据，但是随机取数效率比较低

5.Set适合经常随机储存，插入，删除。但是在遍历时效率比较低
```

## List 和 Map 区别
```
一个是存储单列数据的集合，另一个是存储键和值这样的双列数据的集合，

List中存储的数据时有顺序，并且允许重复；

Map中存储的数据是没有顺序的，其键是不能重复的，它的值是可以有重复的。
```


## Arraylist 与 LinkedList 区别
```
1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。（LinkedList是双向链表，有next也有previous）

2.对于随机访问get和set，ArrayList优于LinkedList，因为LinkedList要移动指针

3.对于新增和删除操作add和remove，LinkedList比较占优势，因为ArrayList要移动数据

4.ArrayList和LinkedList是两个集合类，用于存储一系列的对象引用。例如我们可以用ArrayList来存储一系列的String或者Integer。
```
## ArrayList 与 Vector 区别
```
1.Vector的方法都是同步的(Synchronized),是线程安全的，而ArrayList的方法不是，由于线程的同步必然要影响性能，因此,ArrayList的性能比Vector好。 

2.当Vector或ArrayList中的元素超过它的初始大小时,Vector会将它的容量翻倍,而ArrayList只增加50%的大小，这样,ArrayList就有利于节约内存空间。
```

## HashMap 和 Hashtable 的区别
>HashMap和Hashtable都实现了Map接口，但决定用哪一个之前先要弄清楚它们之间的分别。主要的区别有：线程安全性，同步(synchronization)，以及速度。


- 继承的父类不同
```
Hashtable继承自Dictionary类，而HashMap继承自AbstractMap类。但二者都实现了Map接口。
```

- 线程安全性不同
```
HashMap是非synchronized，而Hashtable是synchronized，这意味着Hashtable是线程安全的，多个线程可以共享一个Hashtable；而如果没有正确的同步的话，多个线程是不能共享HashMap的。Java 5提供了ConcurrentHashMap，它是HashTable的替代，比HashTable的扩展性更好。

由于Hashtable是线程安全的也是synchronized，所以在单线程环境下它比HashMap要慢。如果你不需要同步，只需要单一线程，那么使用HashMap性能要好过Hashtable。
```

- 是否提供Contains方法
```
HashMap把Hashtable的contains方法去掉了，改成containsValue和containsKey


Hashtable则保留了contains，containsValue和containsKey三个方法，其中contains和containsValue功能相同。
```

- key和value是否允许null值
```
HashMap可以接受为null的键值(key)和值(value)，而HashTable则不行
```

- 两个遍历方式的内部实现上不同
```
HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的enumerator迭代器不是fail-fast的。所以当有其它线程改变了HashMap的结构（增加或者移除元素），将会抛出ConcurrentModificationException，但迭代器本身的remove()方法移除元素则不会抛出ConcurrentModificationException异常
```

- Hash值不同
```
哈希值的使用不同，HashTable直接使用对象的hashCode。而HashMap重新计算hash值。

 hashCode是jdk根据对象的地址或者字符串或者数字算出来的int类型的数值。
```

- 内部实现使用的数组初始化和扩容方式不同
```
  HashTable在不指定容量的情况下的默认容量为11，而HashMap为16，Hashtable不要求底层数组的容量一定要为2的整数次幂，而HashMap则要求一定为2的整数次幂。
      Hashtable扩容时，将容量变为原来的2倍加1，而HashMap扩容时，将容量变为原来的2倍。
      Hashtable和HashMap它们两个内部实现方式的数组的初始大小和扩容的方式。HashTable中hash数组默认大小是11，增加的方式是 old*2+1。
```



## HashSet 和 HashMap 区别



* HashMap 和 ConcurrentHashMap 的区别


## HashMap 的工作原理及代码实现
```
HashMap的主干是一个Entry数组。Entry是HashMap的基本组成单元，每一个Entry包含一个key-value键值对
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319200414388-1155385160.jpg)

```
HashMap由数组+链表组成的，数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的，如果定位到的数组位置不含链表（当前的entry的next指向null），那么对于查找，添加等操作很快，仅需一次寻址即可；如果定位到的数组包含链表，对于添加操作，其时间复杂度依然为O(1),以为最新的Entry会插入链表的头部，继续要简单改变
```


```
哈希表（hash table）也叫散列表，是一种非常重要的数据结构，应用场景及其丰富，许多缓存技术（比如memcached）的核心其实就是在内存中维护一张大的哈希表，而HashMap的实现原理也常常出现在各类的面试题中，重要性可见一斑。本文会对java集合框架中的对应实现HashMap的实现原理进行讲解，然后会对JDK7的HashMap源码进行分析。
```


## ConcurrentHashMap 的工作原理及代码实现
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319195410347-2050784933.jpg)

```
　HashTable性能差主要是由于所有操作需要竞争同一把锁，而如果容器中有多把锁，每一把锁锁一段数据，这样在多线程访问时不同段的数据时，就不会存在锁竞争了，这样便可以有效地提高并发效率。这就是ConcurrentHashMap所采用的"分段锁"思想。
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319195702339-1622839842.jpg)

- ConcurrentHashMap源码分析
>ConcurrentHashMap采用了非常精妙的"分段锁"策略，ConcurrentHashMap的主干是个Segment数组。

```
final Segment<K,V>[] segments;
```