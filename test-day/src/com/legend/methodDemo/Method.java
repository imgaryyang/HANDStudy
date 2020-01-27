package com.legend.methodDemo;

public class Method {
    public static void main(String[] args){
        new Method().say();
    }

    public void tell(){
        System.out.println("Hello");
    }

    public int say(){
        return 1;
    }


    //方法重载

    /**
     * 方法名称相同,根据传入的参数和类型的不同来判断
     * @param i
     * @param j
     */
    public void hello(int i,String j){
        System.out.println("方法一");
    }

    public void hello(String j,int i){
        System.out.println("方法二");
    }

    //方法三和方法四无法称为重载，只是返回值类型不同在无参的情况下
    public String hello(int q,short i){
        System.out.println("方法三");
        return "";
    }

    public int hello(short i){
        System.out.println("方法四");
        return 0;
    }
}
