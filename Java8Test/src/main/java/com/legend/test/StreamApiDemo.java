package com.legend.test;

import com.legend.entity.Dish;
import com.legend.entity.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * StreamAPI的汇总
 */
public class StreamApiDemo {

    private static Logger log = LoggerFactory.getLogger(StreamApiDemo.class);

    public static void main(String[] args) {
        List<Dish> dishList = createDishes();
        List<String> beforeJava7 = beforeJava7(dishList);
        List<String> afterJava8 = afterJava8(dishList);
        log.info("Java7.....{}",beforeJava7);
        log.info("Java8.....{}",afterJava8);

        Map<Type, List<Dish>> typeListMap1 = afterJdk8(dishList);
        //System.out.println("typeListMap1..."+typeListMap1);
        Map<Type, List<Dish>> typeListMap2 = beforeJdk8(dishList);
        //System.out.println("typeListMap2..."+typeListMap2);

        //filterAndDistinctTests();
        //limitTest();
        //skipTest();
        //mapTest();
        //flatMapTest();
        //allMatchTest();
        //anyMatchTest();
        //noneMatchTest();
        //countTest();
        //countingTest();
        findFirstTest();
        findAnyTest();
    }


    /**
     * 创建菜肴对象
     */
    private static List<Dish> DISHESLIST = new ArrayList<>();

    /**
     * 创建菜肴集合对象
     *
     * @return
     */
    private static List<Dish> createDishes() {
        Type type = new Type(1L, "类型1");
        Type type2 = new Type(2L, "类型2");
        for (int i = 0; i < 5; i++) {
            Dish d = new Dish();
            d.setCalories(398 + i);
            d.setName("菜肴" + i);
            d.setVegetarian(true);
            if (i % 2 == 0) {
                d.setType(type);
            } else {
                d.setType(type2);
            }
            DISHESLIST.add(d);
        }
        return DISHESLIST;

    }


    /**
     * Java7之前的比较
     *
     * @param dishList
     * @return
     */
    private static List<String> beforeJava7(List<Dish> dishList) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        //1.筛选出卡路里小于400的菜肴
        for (Dish dish : dishList) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        //2.筛选出的菜肴进行排序
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


    /**
     * Java8之后的比较方式
     *
     * @param dishList
     * @return
     */
    private static List<String> afterJava8(List<Dish> dishList) {
        return dishList.stream()
                //筛选出卡路里小于400的菜肴
                .filter(d -> d.getCalories() < 400)
                //根据卡路里排序
                .sorted(Comparator.comparing(Dish::getCalories))
                //提取菜肴的名字
                .map(Dish::getName)
                .collect(Collectors.toList());
    }


    /**
     * 对数据库查询到的菜肴根据菜肴种类进行分类
     *
     * @param dishList
     * @return
     */
    private static Map<Type, List<Dish>> beforeJdk8(List<Dish> dishList) {
        Map<Type, List<Dish>> result = new HashMap<>();

        for (Dish dish : dishList) {
            //不存在则初始化
            if (result.get(dish.getType()) == null) {
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


    /**
     * jdk8之后的
     *
     * @param dishList
     * @return
     */
    private static Map<Type, List<Dish>> afterJdk8(List<Dish> dishList) {
        return dishList.stream().collect(groupingBy(Dish::getType));
    }


    public static void filterAndDistinctTests() {
        List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5, 5, 6, 8, 9, 9);
        Stream<Integer> streamFilter = integerList.stream().distinct().filter(i -> i > 3);
        log.info("StreamFilterDistinct.....{}", streamFilter.collect(Collectors.toList()));

        Stream<Integer> streamDistinct = integerList.stream().distinct();

        log.info("Stream...streamDistinct{}", streamDistinct.collect(Collectors.toList()));
    }


    public static void limitTest() {
        List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5);
        Stream<Integer> stream = integerList.stream().limit(3);
        System.out.println(stream.collect(Collectors.toList()));
    }


    public static void skipTest() {
        List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5);
        Stream<Integer> stream = integerList.stream().skip(2);
        System.out.println(stream.collect(Collectors.toList()));
    }


    public static void mapTest() {
        List<String> stringList = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        Stream<Integer> stream = stringList.stream().map(String::length);
        System.out.println(stream.collect(Collectors.toList()));
    }

    public static void flatMapTest() {
        List<String> wordList = Arrays.asList("Hello", "World");
        List<String> stringList = wordList.stream()
                .map(w -> w.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(stringList);

    }


    public static void allMatchTest() {
        List<Integer> integerList = Arrays.asList(10, 9, 7, 4, 5);
        List<Integer> integerList2 = Arrays.asList(1, 1, 3, 4, 5);
        if (integerList.stream().allMatch(i -> i > 3)) {
            System.out.println("integerList值都大于3");
        }

        if (integerList2.stream().allMatch(i -> i > 3)) {
            System.out.println("值都大于3");
        }
    }

    public static void anyMatchTest() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        if (integerList.stream().anyMatch(i -> i > 3)) {
            System.out.println("存在大于3的值");
        }
    }

    public static void noneMatchTest() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        if (integerList.stream().noneMatch(i -> i > 3)) {
            System.out.println("值都小于3");
        }
    }

    public static void countTest() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Long result = integerList.stream().count();
        System.out.println("长度为:" + result);
    }

    public static void countingTest() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Long result = integerList.stream().collect(counting());
        System.out.println("长度为:" + result);
    }

    public static void findFirstTest() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = integerList.stream().filter(i -> i > 3).findFirst();
        System.out.println("第一个大于三的元素为:" + first.get());
    }

    public static void findAnyTest() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = integerList.stream().filter(i -> i > 3).findAny();
        System.out.println("随机一个大于三的元素为:" + first.get());
    }
}
