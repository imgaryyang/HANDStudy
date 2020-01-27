package com.legend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 比较两个集合的数据不同
 */
public class ListCompareUtil {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            list1.add("test"+i);
            list2.add("test"+i * 3);
        }
        Map<String, Integer> stringIntegerMap = mapCompare(list1, list2);
        System.out.println("xxxx"+stringIntegerMap);
    }


    /**
     * 对比两个list，返回list并集
     * @param oldList
     * @param newList
     * @return value为1,旧数据;2,重复的数据;3,新增的数据
     */
    private static Map<String,Integer> mapCompare(List<String> oldList, List<String> newList) {
        long st = System.nanoTime();
        //若知道两个list大小区别较大，以大的list优先处理
        Map<String,Integer> map = new HashMap<>(oldList.size());
        //lambda for循环数据量越大，效率越高，小数据建议用普通for循环
        oldList.forEach(s -> map.put(s, 1) );
        newList.forEach(s ->{
            if (map.get(s)!= null){
                //相同数据
                map.put(s,2);
            } else {
                //若只是比较不同数据，不需要此步骤，浪费资源
                map.put(s,3);
            }
        });
        System.out.println("mapCompare total times "+(System.nanoTime()-st));
        return map;
    }
}
