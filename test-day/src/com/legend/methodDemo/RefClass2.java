package com.legend.methodDemo;

//String 类型的引用传递分析
public class RefClass2 {
    public static void main(String[] args){
        int i = 10;
        System.out.println(i);
        I(i);
        System.out.println(i);

        String str1 = "Hello";
        System.out.println(str1);

        u(str1);
        System.out.println(str1);//Hello  因为String类是不可改变的类final
    }

    public static void u(String str2){
        str2 ="jike";
    }

    public static void I(int i2){
        i2 =90;
    }

}
