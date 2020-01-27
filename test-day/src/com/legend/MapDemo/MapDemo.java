package com.legend.MapDemo;

import java.util.*;

public class MapDemo {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("name","HAND");
        map.put("time","2019");
        map.put("date","03");
        System.out.print(map.get("name")+"\t");//通过键获取值

        //判断键是否存在
        if(map.containsKey("time")){
            System.out.print(map.get("time")+"\n");
        }

        //判断值是否存在
        if(map.containsValue("time")){
            System.out.println("不存在值");
        }

        //获取所有的键
        System.out.println("\n获取所有的键");
        Set<String> s = map.keySet();
        Iterator<String> it = s.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+"\t");
        }

        //获取所有的值
        System.out.println("\n获取所有的值");
        Collection<String> values = map.values();
        Iterator<String> v = values.iterator();
        while (v.hasNext()){
            System.out.print(v.next()+"\t");
        }
    }
}
