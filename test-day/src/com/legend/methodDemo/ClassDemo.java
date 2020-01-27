package com.legend.methodDemo;


class Person{
    String name;
    int age;
    public void tell(){
        System.out.println("姓名:"+name+" 年龄:"+age);
    }
}

//类的创建
public class ClassDemo {
    public static void main(String[] args){

        //创建对象
        Person per = null;//声明
        per = new Person();//实例化操作

        per.age = 30;
        per.name = "张三";
        per.tell();

        //Person p2 = new Person();//声明并实例化
        /**
         * Exception in thread "main" java.lang.NullPointerException
         * 因为p2只是在栈内存中开辟了空间地址,没有通过new 关键字在堆内存中开辟对应的内存地址
         */
        Person p2 = null;
        p2.name = "李四";
        p2.tell();
    }


}
