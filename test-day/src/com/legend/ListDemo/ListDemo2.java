package com.legend.ListDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListDemo2 {
    public static void main(String[] args){
        List<String> list = null;
        list = new Vector<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+"\t");
        }
        System.out.println("\n删除后:");
        list.remove(4);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+"\t");
        }

        //是否为空
        System.out.println("\n"+list.isEmpty());

        //B是否存在
        System.out.println(list.indexOf("b"));
        System.out.println(list.indexOf("a"));
        System.out.println(list.indexOf("e"));
    }
}
