package com.legend.methodDemo;

public class StringDemo {
    public static void main(String[] args){
        String str1 = "Hello";
        String str2 = "He"+new String("llo");
        String str3 = str2;
        System.out.println(str1 == str2);
        System.out.println(str2 ==str3);

        Integer i = 128;
        Integer j = 128;
        System.out.print(i == j);//false

        /*int num = 0;
        int count = 0;
        for(int i = 0; i <=100 ; i++){
            num = num+i;
            count = count++;
        }
        System.out.println(num*count);*/
    }
}
