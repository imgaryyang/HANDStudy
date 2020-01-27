package com.legend.methodDemo;


import java.util.*;

public class ReflectDemo {
    public static void main(String[] args){
        //Comparable lang
        // Comparator utils
       String str = "aaa";

       y(str);
       System.out.println(str);

       str = "b";
       System.out.println(str );

       com();
    }

    public static void y(String str){
        str = "vvvv";
    }

    public static void com(){
        List<Integer> l = new ArrayList<Integer>();
        l.add(11);
        l.add(1);
        l.add(9);
        l.add(2);
        l.add(11);
        l.add(11);
        l.add(null);
        for (int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }

        Set s = new HashSet(10);

        System.out.println("集合"+l.size());
    }
}
