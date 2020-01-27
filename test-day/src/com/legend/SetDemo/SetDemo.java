package com.legend.SetDemo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args){

        //散列排序
        Set<String> set = new HashSet<>();
        set.add("g");
        set.add("d");
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(set);

        //有序排序
        Set<String> s = new TreeSet<>();
        s.add("s");
        s.add("f");
        s.add("b");
        System.out.println(s);
    }
}
