## 使用Stream API优化你的代码

Java8的新特性主要是Lambda表达式和流,当流和Lambda表达式结合起来一起使用时,因为申明式处理数据集合的特点,可以让代码变得简洁易读


### 有一个需求,需要对数据库查询到的菜肴进行一个处理

- 筛选出卡路里小于400 的菜肴
- 对筛选出的菜肴进行一个排序
- 获取排序后的菜肴名字


#### Java8以前的实现方式
```
private static List<String> beforeJava7(List<Dish> dishList) {
    List<Dish> lowCaloricDishes = new ArrayList<>();
    //1.筛选出卡路里小于400的菜肴
    for (Dish dish : dishList) {
        if (dish.getCalories() < 400) {
            lowCaloricDishes.add(dish);
        }
    }
    //2.对筛选出的菜肴进行排序
    Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
        @Override
        public int compare(Dish o1, Dish o2) {
            return Integer.compare(o1.getCalories(), o2.getCalories());
        }
    });
    //3.获取排序后菜肴的名字
    List<String> lowCaloricDishesName = new ArrayList<>();
    for (Dish d : lowCaloricDishes) {
        lowCaloricDishesName.add(d.getName());
    }
    return lowCaloricDishesName;
}
```

![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190926100047912-1370591466.png)


#### Java8 之后的实现方式
```
private static List<String> afterJava8(List<Dish> dishList) {
	return dishList.stream()
	    .filter(d -> d.getCalories() < 400)  //筛选出卡路里小于400的菜肴
	    .sorted(comparing(Dish::getCalories))  //根据卡路里进行排序
	    .map(Dish::getName)  //提取菜肴名称
	    .collect(Collectors.toList()); //转换为List
}

```

![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190926100125480-1836980286.png)

>结果：一样的，只是写法不同比较精简

![](https://img2018.cnblogs.com/blog/1231979/201909/1231979-20190926100351608-187476741.png)


---

---


### 对数据库查询的菜肴种类进行分类,返回一个Map<Type,List<'Dish>> 的结果

#### Java8 以前的实现方式
```
private static Map<Type, List<Dish>> beforeJdk8(List<Dish> dishList) {
    Map<Type, List<Dish>> result = new HashMap<>();

    for (Dish dish : dishList) {
        //不存在则初始化
        if (result.get(dish.getType())==null) {
            List<Dish> dishes = new ArrayList<>();
            dishes.add(dish);
            result.put(dish.getType(), dishes);
        } else {
            //存在则追加
            result.get(dish.getType()).add(dish);
        }
    }
    return result;
}
```


#### Java8以后的实现方式
```
private static Map<Type, List<Dish>> afterJdk8(List<Dish> dishList) {
    return dishList.stream().collect(groupingBy(Dish::getType));
}
```

---

### 什么是流
**流是从支持数据处理操作的源生成的元素序列,源可以是数组、文件、集合、函数。流不是集合元素，他不是数据结构并不保存数据，他的主要目的在于计算**


---


### 如何生成流

#### 生成流的方式主要有五种

- 通过集合生成，应用中最常用的一种
```
List<Integer> integerList = Arrays.asList(1,2,3,4,5);
Stream<Integer> stream = integerList.stream();

//通过集合的stream 方法生成流
```


- 通过数组生成
```
int[] intArr = new int[]{1, 2, 3, 4, 5};
IntStream stream = Arrays.stream(intArr);
```
`通过集Arrays.stream 方法生成流,并且该方法生成的流是数值流[即 IntStream]而不是 Stream<Integer>`

>使用数值流可以避免计算过程中拆箱装箱，提高性能。


StreamAPI提供了 **mapToInt**、**mapToDouble**、**mapToLong** 三种方式将对象流[即Stream] 转化成对应的数值流，同时提供了boxed方法将数值流转换为对象流


- 通过值生成
```
Stream<Integer> stream = Stream.of(1,2,3,4,5);
```
>通过Stream的of 方法生成流，通过Stream的empty方法生成一个空流


- 通过文件生成
```
Stream<String> lines = Files.lines(Paths.get("data.txt"),Charset.defaultCharset());
```

>通过Files.lines 方法得到一个流，并且得到的每个流是给定义文件中的一行


- 通过函数生成，提供了iterate 和 generate 两个静态方法从函数中生成流iterator
```
Stream<Integer> stream = Stream.iterator(0,n->n + 2).limit(5);
```

**iterator 方法接受两个参数，第一个为初始化值，第二个为进行的函数操作，因为iterator生成的流为无限流，通过limit 方法对流进行了截断，只生成 5 个偶数 generator**


```
Stream<Double> stream = Stream.generate(Math::random).limit(5);
```

**generator方法接受一个参数，方法参数类型为Supplier，由它为流提供值。generate 生成的流也是无限流，因此通过limit 对流进行了截断**


---

### 流的操作类型

**流的操作类型主要分类两种**


#### 1.中间操作
一个流可以后面跟随零个或多个中间操作。其目的主要是打开流,做出某种程度的数据映射/过滤,然后返回一个新的流，交给下一个操作使用。这类操作都是惰性化的,仅仅调用到这类方法,并没有真正开始流的遍历,真正的遍历需要等到终端操作时,常见的中间操作有filter、map等


#### 2.终端操作
一个流有且只能有一个终端操作,当这个操作执行后,流就被关闭了,无法在被操作,因此`一个流只能被遍历一次`,若想在遍历需要通过源数据在生成流。终端操作的执行,才会真正开始流的遍历.如count、collect等


---

### 流使用

流的使用将分为`终端操作`和`中间操作`


#### 中间操作

- filter筛选
```
List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5);
Stream<Integer> streamFilter = integerList.stream().filter(i -> i > 3);
log.info("StreamFilter{}", streamFilter.collect(Collectors.toList()));
```
>通过filter方法进行条件筛选，filter的方法参数为一个过滤条件


- distinct 去除重复元素
```
List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5);
Stream<Integer> streamDistinct = integerList.stream().distinct();
log.info("Stream...streamDistinct{}", streamDistinct.collect(Collectors.toList()));
```

>通过distinct方法快速去除重复的元素


- limit返回指定流个数
```
List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5);
Stream<Integer> stream = integerList.stream().limit(3);
System.out.println(stream.collect(Collectors.toList()));
```
`结果:[1, 1, 2]`

>通过limit 方法指定返回流的个数,limit 的参数值必须 >= 0 ,否则将会抛出异常 


- skip跳过流中的元素
```
List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5);
Stream<Integer> stream = integerList.stream().skip(2);
System.out.println(stream.collect(Collectors.toList()));
```
`结果:[2, 3, 4, 5]`

>通过skip方法跳过流中的元素,skip的参数值必须>=0，否则将会抛出异常


- Map流映射
`所谓流映射就是将接受的元素映射成另外一个元素`
```
List<String> stringList = Arrays.asList("Java 8", "Lambdas",  "In", "Action");
Stream<Integer> stream = stringList.stream().map(String::length);
System.out.println(stream.collect(Collectors.toList()));
```
`结果:[6, 7, 2, 6]`

主要是将集合中的数据转化为字符串长度的数值

>通过 map 方法可以完成映射，该例子完成 String -> Integer的映射，之前上面的例子通过map方法完成了 Dish -> String 的映射



- flatMap 流转换
`将一个流中的每个值都转换为另一个流`

```
List<String> wordList = Arrays.asList("Hello", "World");
List<String> stringList = wordList.stream()
        .map(w -> w.split(" "))
        .flatMap(Arrays::stream)
        .distinct()     
        .collect(Collectors.toList());
System.out.println(stringList);
```
`结果:[Hello, World]`

分析：
```
map(w -> w.split(" ")的返回值为Stream<String[]>
我们想获取Stream<String>,可以通过flatMap方法完成Stream ->Stream的转换
```


---

**元素匹配(提供三种匹配方式)**

- allMatch 匹配所有

```
public static void allMatchTest(){
    List<Integer> integerList = Arrays.asList(10, 9, 7, 4, 5);
    List<Integer> integerList2 = Arrays.asList(1, 1, 3, 4, 5);
    if (integerList.stream().allMatch(i -> i > 3)) {
        System.out.println("值都大于3");
    }
    if (integerList2.stream().allMatch(i -> i > 3)) {
        System.out.println("值都小于3");
    }
}
```
`结果: 值都大于3`

>只有集合中所有的元素都满足要求的时候才会输出，如果有一个不符合都不会输出结果


- anyMatch 匹配其中一个
```
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
if (integerList.stream().anyMatch(i -> i > 3)) {
    System.out.println("存在大于3的值");
}
```
`结果: 存在大于3的值`

>集合中的元素只要有其中一个满足就输出

等同于
```
for (Integer i : integerList) {
    if (i > 3) {
        System.out.println("存在大于3的值");
        break;
    }
}
```
>存在大于3的值则打印，java8中通过anyMatch方法实现这个功能


- noneMatch 全部不匹配
```
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
if (integerList.stream().noneMatch(i -> i > 3)) {
    System.out.println("值都小于3");
}
```

`结果: 无`


#### 终端操作
`统计流中元素个数`

- 1.通过count
通过count方法统计出流中元素个数

```
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
Long result = integerList.stream().count();
System.out.println("长度为:"+ result);
```
`结果:长度为:5 `


- 通过counting
最后一种统计元素个数的方法在与collect联合使用的时候特别有用
```
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
Long result = integerList.stream().collect(counting());
System.out.println("长度为:"+ result);
```
`结果:长度为:5 `


`查找`
提供了两种查找方式
- findFirst查找第一个

```
public static void findFirstTest(){
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    Optional<Integer> first = integerList.stream().filter(i -> i > 3).findFirst();
    System.out.println("第一个大于三的元素为:"+ first.get());
}
```
`结果: 第一个大于三的元素为:4`

>通过findFirst方法查找到第一个大于三的元素并打印


- findAny随机查找一个
```
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = integerList.stream().filter(i -> i > 3).findAny();
        System.out.println("随机一个大于三的元素为:" + first.get());
```
`结果: 随机一个大于三的元素为:4`

>通过findAny方法查找到其中一个大于3的元素并打印，因为内部进行优化的原因，当找到第一个满足大于3的元素时就结束，该方法结果和findFirst 方法结果一样。提供findAny方法是为了更好的利用并行流，findFirst 方法在并行上限制更多。


- reduce 将流中的元素组合起来
`假设我们对一个集合中的值进行求和`

jdk8之前
```
int sum = 0;
for (int i : integerList) {
	sum += i;
}
```

jdk8之后通过reduce进行处理
```
Integer sum = integerList.stream().reduce(0, (a, b) -> (a + b));
System.out.println("集合求和:" + sum);
```

`一行就可以完成，还可以使用方法引用简写成：`
```
Integer sum = integerList.stream().reduce(0, Integer::sum);
System.out.println("集合求和:" + sum);
```

>reduce接受两个参数,一个初始值这里是0，一个BinaryOperator<''T> accumulator 来将两个元素结合起来产生一个新值，
>另外reduce方法还有一个没有初始化值得重载方法



- 获取流中最小最大值
`通过max/min来获取最小最大值`
```
Optional<Integer> min = dishes.stream().map(Dish::getCalories).min(Integer::compareTo);
Optional<Integer> max = dishes.stream().map(Dish::getCalories).max(Integer::compareTo);
System.out.println("min:" + min.get());
System.out.println("max:" + max.get());
```

也可以写成
```
OptionalInt min1 = dishes.stream().mapToInt(Dish::getCalories).min();
OptionalInt max1 = dishes.stream().mapToInt(Dish::getCalories).max();
System.out.println("min1:" + min1);
System.out.println("max1:" + max1);
```

>min获取流中最小值，max获取流中最大值，方法参数为Comparator<? super T> compator 



- 通过minBy/maxBy 获取最小最大值
```
Optional<Integer> minBy = dishes.stream().map(Dish::getCalories).collect(minBy(Integer::compareTo));
Optional<Integer> maxBy = dishes.stream().map(Dish::getCalories).collect(maxBy(Integer::compareTo));
System.out.println("minBy:" + minBy.get());
System.out.println("maxBy:" + maxBy.get());
```

>minBy获取流中最小值，maxBy获取流中最大值，方法参数为 Comparator<? super T> 


- comparator
`通过reduce获取最小最大值`

```
Optional<Integer> min = dishes.stream().map(Dish::getCalories).reduce(Integer::min);
Optional<Integer> max = dishes.stream().map(Dish::getCalories).reduce(Integer::max);
System.out.println("min:" + min);
System.out.println("max:" + max);
```

- 求和
`通过summingInt`
```
int sum = dishes.stream().collect(summingInt(Dish::getCalories));
System.out.println("summingIntSum:" + sum);
```

>如果数据类型为double、long，则通过summingDouble、summingLong方法进行求和通过reduce


`通过reduce`
```
int sum = dishes.stream().map(Dish::getCalories).reduce(0, Integer::sum);
System.out.println("reduceSum:" + sum);
```


`通过sum`
```
int sum = dishes.stream().mapToInt(Dish::getCalories).sum();
System.out.println("Sum:" + sum);
```

>在上面求和、求最大值、最小值的时候，对于相同操作有不同的方法可以选择执行。可以选择collect、reduce、min/max/sum 方法，推荐使用min、max、sum方法
>因为它最简洁易读，同时通过mapToInt将对象流转换为数值流，避免了装箱和拆箱操作


- 通过averagingInt 求平均值
```
double average = dishes.stream().collect(averagingInt(Dish::getCalories));
System.out.println(average);
```

>如果数据类型是double、long则通过averagingDouble、averagingLong方法进行求平均


- 通过summarizingInt 同时求总和、平均值、最大值、最小值

```
IntSummaryStatistics intSummaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
double average = intSummaryStatistics.getAverage();  //获取平均值
int min = intSummaryStatistics.getMin();  //获取最小值
int max = intSummaryStatistics.getMax();  //获取最大值
long sum = intSummaryStatistics.getSum();  //获取总和

log.info("intSummaryStatistics:{}....平均值:{}...最大值:{}...最小值:{}....总和:{}....", intSummaryStatistics, average, max, min, sum);
```
>如果数据类型为double、long，则通过summarizingDouble、summarizingLong方法


- 通过foreach进行元素遍历

```
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
integerList.stream().forEach(System.out::println);
```


而在jdk8之前实现遍历
```
for (int i : integerList) {
    System.out.println(i);
}
```

jdk8之后遍历元素来的更为方便，原来的for-each直接通过foreach方法就能实现了

返回集合
```
List<String> strings = dishes.stream().map(Dish::getName).collect(toList());
Set<String> sets = dishes.stream().map(Dish::getName).collect(toSet());
```

>通过便利和返回集合的使用发现流只是把原来的外部迭代放到了内部进行，这也是流的主要特点之一


- 通过joining拼接流中的元素
```
String result = dishes.stream().map(Dish::getName).collect(joining(","));
System.out.println("拼接后的结果是:" + result);
```

>默认如果不通过map方法进行映射处理拼接的toString方法返回的字符串，joining的方法参数为元素的分界符，如果不指定生成的字符串将是一串的，可读性不强。


- 进阶通过groupingBy 进行分组

```
Map<Type, List<Dish>> groupBy = dishes.stream().collect(groupingBy(Dish::getType));
System.out.println(groupBy);
```

>在collect方法中传入groupingBy 进行分组，其中groupingBy 的方法参数为分类函数。还可以通过嵌套使用groupingBy 进行多级分类

```
Map<Type, List<Dish>> result = dishes.stream().collect(groupingBy(Dish::getType,
        groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                else return CaloricLevel.FAT;
        })));
```


- 进阶通过partitioningBy进行分区
`分区是特殊的分组，它分类是依据true 和 false，所以返回的结果最多可以分为两组`

```
Map<Boolean, List<Dish>> partitioningByMap = dishes.stream().collect(partitioningBy(Dish::isVegetarian));
System.out.println(partitioningByMap);
```

等同于
```
//等价于
Map<Boolean, List<Dish>> groupingByMap = dishes.stream().collect(groupingBy(Dish::isVegetarian));
System.out.println(groupingByMap);
```

这个例子可能并不能看出分区和分类的区别，甚至觉得分区根本没有必要，换个明显一点的例子：
```
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
Map<Boolean, List<Integer>> result = integerList.stream().collect(partitioningBy(i -> i < 3));
System.out.println(result);
```

>返回值的键仍然是布尔类型，但是它的分类是根据范围进行分类的，分区比较适合处理根据范围进行分类

### 总结
通过使用Stream API可简化代码，同时提高了代码可读性