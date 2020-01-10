## Redis基础
### Redis的数据结构
Redis支持多种不同的数据结构，包括5种基础数据结构和几种比较复杂的数据，这些数据结构可以满足不同的应用场景


### 五种基础数据结构
- String：字符串，是构建其他数据结构的基础
- Hash：哈希列表
- List：列表
- Set：集合，在哈希列表的基础上实现
- Sort Set：有序集合


### 复杂的数据结构
- Bitmaps：位图，在String的基础上进行位操作，可以实现节省空间的数据结构
- Hyperloglog：用于估计一个set中元素数量的概率性的数据结构
- Geo：geospatial，地理空间索引半径查询
- BloomFilter：布隆过滤器


### 不用数据结构的相同之处
从上面的介绍我们看到支持的数据结构的不同，但其实，Redis的每一种数据结构都由一个key和value组成，而所有的数据结构的key的值都是任意合法的字符串，不同的数据结构的区别就在于value存储的值不同而不同。
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200109153610822-1766696436.png)


比如：最简单的String数据结构，其value为String，所以String可以表示为
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200109153549938-1212525023.png)

而Hash数据结构，其value为一个哈希列表，所以Hash可以表示为
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200109153732300-1052714531.png)



### Redis对的通用命令
#### keys
keys命令的作用是列出Redis 所有的key，该命令的时间复杂度为O(N),N随着Redistribution中key的数量增加而增加，因此Redis有大量的key，keys命令会执行很长时间，而由于Redis是单线程某个命令耗费过长时间，则会导致后面的所有请求无法得到响应，因此，千万不要再生产服务器上使用keys命令

```
# key命令,时间复杂度为O(n)
keys pattern #pattern可为一个包含匹配模式的字符串,可以包含*,+,?,[a-z]等模式
```

示例
```
> mset hello_test1 one hello_test2 two helloa a hellob b
> keys hello*
1) "hello_test1"
2) "hello_test2"
3) "helloa"
4) "hellob"
> keys heelo?
1) "helloa"
2) "hellob"
> keys hello[a-z]
1) "helloa"
2) "hellob"
```


#### exists
exists命令用于判断一个或多个key是否存在，判断多个key时，key之间用空格分隔，exists的返回值为整数，表示当前判断有多少个key是存在的。

```
# exists命令，时间复杂度O(1)
exists key [key ...]
```

实例
```
> set test1 t1
> exists test1 test2 
(integer) 1 #只有一个key存在
> exists test3 test3
(integer) 0 #key都不存在
```


#### del
del命令用于删除一个或多个key，多个key之间用空格分隔，其返回值为整数，表示成功删除了多少个存在的key，因此，如果值删除一个key，则可以从返回值中判断是否成功，如果删除多个key，则只能得到删除成功的数量。


```
# del命令,时间复杂度O(n)
del key [key ...]
```

实例
```
> set test t
> del test
(integer) 1
> mset test1 2 test2 1
> del test1 test2 test3
(integer) 2 # 返回2，表示成功删除两个
#再次删除，返回0，因为删除成功个数为0
> del test1 test2 test3
(integer) 0
```


#### expire,pexpire
expire设置key在多少秒之后过期，pexpire 设置key在多少毫秒之后过期，成功返回2，失败返回0

```
# expire命令，时间复杂度为O(1)
expire key seconds

# pexpire命令，时间复杂度为O(1)
pexpire key milliseconds
```

示例
```
> mset test test_value test1 test1_value
> expire test 10 #设置10秒后过期
(integer) 1
> pexpire test1_value 10000 #设置10000毫秒(10s)后过期
(integer) 1
> expire ttt 100
(integer) 0 # 不存在的key，设置失败，返回0 
```


#### ttl pttl
ttl和pttl命令用于获取key的过期时间，其返回值为整型，代表的一一分为几种情况：
- 当key不存在或过期时间，返回-2
- 当key存在且永久有效时，返回-1
- 当key有设置过期时间时，返回为剩下的描述(pttl毫秒数)


```
# ttl命令，时间复杂度O(1)
ttl key

# pttl命令，时间复杂度O(1)
pttl key
```

示例(ttl的演示，pttl类似)
```
> set test test
> expire test 100
> ttl test
(integer) 98#返回剩下的秒数
> set test1 #永久有效
> ttl test1
(integer) -1
> ttl test2
(integer) -2#不存在或过期
#100秒后
> ttl test # test已过期
(integer) -2
```


#### expireat,pexpireat
设置key在某个时间戳过期,expreat参数时间戳用秒表示，而pexpireat则用毫秒表示，与expire和pexpire功能类似，返回1表示成功，0表示失败。
```
#expireat命令，时间复杂度为O(1)
expireat key timestamp

#pexpireat命令，时间复杂度为O(1)
pexpireat key milliseconds-timestamp
```

示例
```
> set test test
> expireat test 1560873600 # 2019-06-19 00:00:00
(integer) 1
> set test1 test1
> pexpireat test1 156087360000 # 2019-06-19 00:00:00的毫秒表示
(integer) 1
```