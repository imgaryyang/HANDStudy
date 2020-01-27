package com.legend.HAND;

//作用域
public class test4 {

    public static void main(String[] args){
        int age = 14;
        System.out.println(age);
        {
            //变量名重复定义
            int age2 = 15;
           System.out.println(age);
        }


        {
            String name = "QQ";
            System.out.println(name);
        }
        String name2 = "legend";
        System.out.println(name2);
    }



}
