package com.legend.test;

import com.legend.entity.Dish;
import com.legend.entity.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * 筛选出卡路里小于400的菜肴
 * 对筛选出的菜肴进行一个排序
 * 获取排序后菜肴的名字
 */
public class TestDemo {

    private static Logger log = LoggerFactory.getLogger(TestDemo.class);


    /**
     * 创建菜肴对象
     */
    private static List<Dish> DISHLISTES = new ArrayList<>();

    /**
     * 创建菜肴集合对象
     * @return
     */
    private static List<Dish> createDishes(){
        for (int i = 0; i < 5; i++) {
            Dish d = new Dish();
            d.setCalories(398+i);
            d.setName("菜肴"+i);
            d.setVegetarian(true);
            DISHLISTES.add(d);
        }
        return DISHLISTES;

    }


    /**
     * Java7之前的比较
     * @param dishList
     * @return
     */
    private static List<String> beforeJava7(List<Dish> dishList){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        //1.筛选出卡路里小于400的菜肴
        for (Dish dish: dishList) {
            if (dish.getCalories() < 400){
                lowCaloricDishes.add(dish);
            }
        }
        //2.筛选出的菜肴进行排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(),o2.getCalories());
            }
        });
        //3.获取排序后菜肴的名字
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d: lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }


    /**
     * Java8之后的比较方式
     * @param dishList
     * @return
     */
    private static List<String> afterJava8(List<Dish> dishList){
        return dishList.stream()
                //筛选出卡路里小于400的菜肴
                .filter(d->d.getCalories()<400)
                //根据卡路里排序
                .sorted(Comparator.comparing(Dish::getCalories))
                //提取菜肴的名字
                .map(Dish::getName)
                .collect(Collectors.toList());
    }


    /**
     * 对数据库查询到的菜肴根据菜肴种类进行分类
     * @param dishList
     * @return
     */
    private static Map<Type,List<Dish>> beforeJdk8(List<Dish> dishList){
        Map<Type,List<Dish>> result = new HashMap<>();

        for (Dish dish:dishList){
            //不存在则初始化
            if (result.get(dish.getType()) == null){
                List<Dish> dishes = new ArrayList<>();
                dishes.add(dish);
                result.put(dish.getType(),dishes);
            } else {
                //存在则追加
                result.get(dish.getType()).add(dish);
            }
        }
        return result;
    }


    /**
     * jdk8之后的
     * @param dishList
     * @return
     */
    private static Map<Type, List<Dish>> afterJdk8(List<Dish> dishList) {
        return dishList.stream().collect(groupingBy(Dish::getType));
    }


    public static void filterAndDistinctTests(){
        List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4,5, 5,6,8,9,9);
        Stream<Integer> streamFilter = integerList.stream().distinct().filter(i -> i > 3);
        log.info("StreamFilterDistinct.....{}",streamFilter.collect(Collectors.toList()));

        Stream<Integer> streamDistinct = integerList.stream().distinct();

        log.info("Stream...streamDistinct{}",streamDistinct.collect(Collectors.toList()));
    }


    public static void limitTest(){
        List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5);
        Stream<Integer> stream = integerList.stream().limit(3);
        System.out.println(stream.collect(Collectors.toList()));
    }


    public static void skipTest(){
        List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5);
        Stream<Integer> stream = integerList.stream().skip(5);
        System.out.println(stream.collect(Collectors.toList()));
    }


    public static void mapTest(){
        List<String> stringList = Arrays.asList("Java 8", "Lambdas",  "In", "Action");
        Stream<Integer> stream = stringList.stream().map(String::length);
        System.out.println(stream.collect(Collectors.toList()));
    }

    public static void flatMapTest(){
        List<String> wordList = Arrays.asList("Hello", "World");
        List<String> stringList = wordList.stream()
                .map(w -> w.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(stringList);

    }

    public static void allMatchTest(){
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        if (integerList.stream().allMatch(i -> i > 3)) {
            System.out.println("值都大于3");
        }
    }


    public static void method(){
        Date date = new Date("2014/1/10 18:20");
        Date date2 = new Date("2014/1/11 3:5");
        long temp = date2.getTime() - date.getTime();    //相差毫秒数
        long hours = temp / 1000 / 3600;                //相差小时数
        long temp2 = temp % (1000 * 3600);
        long mins = temp2 / 1000 / 60;                    //相差分钟数
        System.out.println("date2 与 date 相差" + hours + "小时"+ mins + "分钟");
    }

    private static void method2() {
        //固定的比较集合数据
        List<List<String>> toCompareStatusList = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("APPROVED");
        list1.add("APPROVED");

        List<String> list2 = new ArrayList<>();
        list2.add("INPRG");
        list2.add("INPRG");

        List<String> list3 = new ArrayList<>();
        list3.add("COMPLETED");
        list3.add("INPRG");

        List<String> list4 = new ArrayList<>();
        list4.add("PRECLOSED");
        list4.add("INPRG");

        List<String> list5 = new ArrayList<>();
        list5.add("CLOSED");
        list5.add("CLOSED");

        List<String> list6 = new ArrayList<>();
        list6.add("DRAFT");
        list6.add("APPROVED");

        List<String> list7 = new ArrayList<>();
        list7.add("WRD");
        list7.add("APPROVED");

        List<String> list8 = new ArrayList<>();
        list8.add("WPCOND");
        list8.add("APPROVED");

        List<String> list9 = new ArrayList<>();
        list9.add("WSCH");
        list9.add("APPROVED");

        List<String> list10 = new ArrayList<>();
        list10.add("PAUSE");
        list10.add("APPROVED");

        List<String> list11 = new ArrayList<>();
        list11.add("RETURNED");
        list11.add("APPROVED");

        List<String> list12 = new ArrayList<>();
        list12.add("REWORK");
        list12.add("APPROVED");

        List<String> list13 = new ArrayList<>();
        list13.add("CANCELED");
        list13.add("APPROVED");

        List<String> list14 = new ArrayList<>();
        list14.add("UNABLE");
        list14.add("APPROVED");

        toCompareStatusList.add(list1);
        toCompareStatusList.add(list2);
        toCompareStatusList.add(list3);
        toCompareStatusList.add(list4);
        toCompareStatusList.add(list5);
        toCompareStatusList.add(list6);
        toCompareStatusList.add(list7);
        toCompareStatusList.add(list8);
        toCompareStatusList.add(list9);
        toCompareStatusList.add(list10);
        toCompareStatusList.add(list11);
        toCompareStatusList.add(list12);
        toCompareStatusList.add(list13);
        toCompareStatusList.add(list14);

        List<String> dbStatus = new ArrayList<>();
        dbStatus.add("APPROVED");
        dbStatus.add("APPROVED");
        boolean contains = toCompareStatusList.contains(dbStatus);
        System.out.println(contains);
    }


    private static void method3() {
        //固定的比较集合数据
        List<List<String>> toCompareStatusList = new ArrayList<>();
        List<String> list1 = Arrays.asList("APPROVED","APPROVED");
        List<String> list2 = Arrays.asList("INPRG","INPRG");
        List<String> list3 = Arrays.asList("COMPLETED","INPRG");
        List<String> list4 = Arrays.asList("PRECLOSED","INPRG");
        List<String> list5 = Arrays.asList("CLOSED","CLOSED");
        List<String> list6 = Arrays.asList("DRAFT","APPROVED");
        List<String> list7 = Arrays.asList("WRD","APPROVED");
        List<String> list8 = Arrays.asList("WPCOND","APPROVED");
        List<String> list9 = Arrays.asList("WSCH","APPROVED");
        List<String> list10 = Arrays.asList("PAUSE","APPROVED");
        List<String> list11 = Arrays.asList("RETURNED","APPROVED");
        List<String> list12 = Arrays.asList("REWORK","APPROVED");
        List<String> list13 = Arrays.asList("CANCELED","APPROVED");
        List<String> list14 = Arrays.asList("UNABLE","APPROVED");

        toCompareStatusList.add(list1);
        toCompareStatusList.add(list2);
        toCompareStatusList.add(list3);
        toCompareStatusList.add(list4);
        toCompareStatusList.add(list5);
        toCompareStatusList.add(list6);
        toCompareStatusList.add(list7);
        toCompareStatusList.add(list8);
        toCompareStatusList.add(list9);
        toCompareStatusList.add(list10);
        toCompareStatusList.add(list11);
        toCompareStatusList.add(list12);
        toCompareStatusList.add(list13);
        toCompareStatusList.add(list14);

        List<String> dbStatus = new ArrayList<>();
        dbStatus.add("WSCH");
        dbStatus.add("APPROVED");
        boolean contains = toCompareStatusList.contains(dbStatus);
        System.out.println(contains);
        System.out.println("..."+dbStatus.get(0));
    }


    public static void main(String[] args){
        List<Dish> dishList = createDishes();
        List<String> beforeJava7 = beforeJava7(dishList);
        List<String> afterJava8 = afterJava8(dishList);
        log.info("beforeJava7.....{}",beforeJava7);
        log.info("beforeJava8.....{}",afterJava8);
        //filterAndDistinctTests();
        //limitTest();
        //skipTest();
        //mapTest();
        //flatMapTest();
        //allMatchTest();
        //method();
        //method2();
        //method3();
    }
}
