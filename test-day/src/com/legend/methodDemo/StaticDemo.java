package com.legend.methodDemo;

public class StaticDemo {
    static int p = 10;
    static String n = "aa";

    int w = 40;

    public static void t(){
        System.out.println(p);
        main(new String[]{"aa"});
        //System.out.println(w);//错误
        //qt();//错误
    }

    public void qt(){
        System.out.println(p);
        System.out.println(w);
        t();
    }

    public static void main(String[] args){
        int q = 99;
    }
}
