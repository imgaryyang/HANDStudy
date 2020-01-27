package com.legend.ListDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo3 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();

            if(s.equals("a")){
                iterator.remove();//不能直接用集合做删除操作
            }else{
                System.out.println(s);

            }
        }
    }
}
