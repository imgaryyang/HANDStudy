package com.legend.methodDemo;

public class IntDemo {

    public static void main(String[] args){

        //int a = null;
        //Integer b = null;


        Integer i = new Integer(99);
        Integer j = new Integer(99);
        System.out.println(i == j);//false

        int t1 = 10;
        Integer t2 = 10;
        System.out.println(t1 == t2);//true

        Integer t3 = new Integer(10);
        System.out.println(t1 == t3);//true

        int a = Integer.parseInt("100");
        System.out.println(a);
    }

}
