## HashMap源码解析
### 红黑树
红黑树本质种自二叉查找树，是在计算机科学中用到的一种数据结构。但他在而查找树的基础上增加了着色和相关的性质使得红黑树相对平衡，从而保证了红黑树的查找、插入、删除的时间复杂度最坏为O(logn)


### 红黑树5大特性
- 性质一：节点是红色或黑色
- 性质二：根节点是黑色
- 性质三：每个节点（NIL节点，空节点）是黑色的
- 性质四：每个红色节点的两个子节点都是黑色。从每个叶子到根的所有路径上不能有两个连续的红色节点
- 性质五：从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。

>有红必有黑，红红不想连

### 在Java8中HashMap底层存储数据时采用的是数组+链表+红黑树的数据结构，大致如下图所示：
 ![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191220210154099-1266279426.png)


叶子节点下面挂着两个虚节点(NIL) HashMap实现和继承的类与接口:
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191220210338697-918395283.png)


### 下面我们通过源码具体看看：
#### 默认的常量值：
```java
//初始容量 必须是2的幂
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

//最大容量
static final int MAXIMUM_CAPACITY = 1 << 30;

//构造函数中未指定时使用的加载因子。
static final float DEFAULT_LOAD_FACTOR = 0.75f;

//阈值(当链表的数量超过该值时，转换为红黑树)
static final int TREEIFY_THRESHOLD = 8;

//阈值（红黑树中节点的数量小于该值时转为链表）
static final int UNTREEIFY_THRESHOLD = 6;

//最小树化的容量
static final int MIN_TREEIFY_CAPACITY = 64;
```

#### 其他的一些属性：

```java
//第一次初始化时使用和需要扩容时
transient Node<K,V>[] table;

//map集合数据转换为set，主要用于hashMap迭代时
transient Set<Map.Entry<K,V>> entrySet;

//集合的大小
transient int size;

//hashMap修改的次数
transient int modCount;

//临界值 集合的大小大于该值时会进行扩容
int threshold;

//负载因子
final float loadFactor;
```
>注：transient关键字标记的成员变量不参与序列化过程

#### 四种构造方法：
- 1.传入了自定义的容量和加载因子

```java
public HashMap(int initialCapacity, float loadFactor) {
    //自定义的容量不合法
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal initial capacity: " +
                                           initialCapacity);
    //自定义的容量大于最大的容量，吧最大的容量值赋给自定义的容量
    if (initialCapacity > MAXIMUM_CAPACITY)
        initialCapacity = MAXIMUM_CAPACITY;
    //加载因子的合法性
    if (loadFactor <= 0 || Float.isNaN(loadFactor))
        throw new IllegalArgumentException("Illegal load factor: " +
                                           loadFactor);
    //吧自定义的值赋给成员变量，覆盖默认值
    this.loadFactor = loadFactor;
    //需要把自定义的容量调整为 大于该数而且是最小的2次方数(如传入12返回16)
    this.threshold = tableSizeFor(initialCapacity);
}
```

- 2.传入自定义的容量 使用默认的加载因子
```java
//自定义容量 使用默认的加载因子 
public HashMap(int initialCapacity) {
   this(initialCapacity, DEFAULT_LOAD_FACTOR);
}
```


- 3.使用默认的初始容量和加载因子
```java
//空参构造 使用默认的容量和加载因子
public HashMap() {
    this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
}
```


- 4.使用默认的初始容量和加载因子
```java
//传入一个map集合
public HashMap(Map<? extends K, ? extends V> m) {
    this.loadFactor = DEFAULT_LOAD_FACTOR;
    //把传入的map放入hashMap
    putMapEntries(m, false);
}
```

`把map放入hashMap`

```java
final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
    //集合的大小
    int s = m.size();
    if (s > 0) {
        //table是否为空，也就是是否初始化
        if (table == null) { // pre-size
            //计算容量
            float ft = ((float)s / loadFactor) + 1.0F;
            //容量是否超过最大值
            int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                     (int)ft : MAXIMUM_CAPACITY);
            if (t > threshold)
                //大于临界值 重新赋值
                threshold = tableSizeFor(t);
        }
        else if (s > threshold)
            //扩容
            resize();
        //遍历传入的map，重新放到新定义的hashMap中
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            K key = e.getKey();
            V value = e.getValue();
            putVal(hash(key), key, value, false, evict);
        }
    }
}
```

`返回给定目标容量的接近2的次方的数`
```java
static final int tableSizeFor(int cap) {
    //传入的数值减一操作 在进行无符号右移运算最后按位或
    int n = cap - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    //跟最大值进行比较 返回结果
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
}
```

`put操作`

```java
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}
```

`获取key的hash值`
```java
static final int hash(Object key) {
    int h;
    //key的hashCode值 异或 （key的hashCode值右移16位，也就是该值的高16位）与1.7相比这样提高了hash值的随机性
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```