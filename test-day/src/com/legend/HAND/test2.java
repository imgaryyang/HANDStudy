package com.legend.HAND;

public class test2 {
    //计算(sqrt(20)+sqrt(10))/(sqrt(20)-sqrt(10))
    public static void main(String[] args){
        System.out.println("(sqrt(20)+sqrt(10))/(sqrt(20)-sqrt(10))="
                +Math.round(10*(Math.sqrt(20)+Math.sqrt(10))/(Math.sqrt(20)-Math.sqrt(10)))/10.0);

        double sqrt10 = Math.sqrt(10);//将10的平方根保存到sqrt10的变量中
        double sqrt20 = Math.sqrt(20);//将20的平方根保存到sqrt20的变量中
        double result = (sqrt20+sqrt10)/(sqrt20-sqrt10);//将20的平方根保存到sqrt20的变量中

        result = Math.round(result*10)/10.0;
        System.out.println("(sqrt(20)+sqrt(10))/(sqrt(20)-sqrt(10))="+result);
    }
}
