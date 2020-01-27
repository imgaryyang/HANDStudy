package com.legend.POL;


class A{
    public void tell1(){
        System.out.println("A----tell1");
    }

    public void tell2(){
        System.out.println("A----tell2");
    }
}


class B extends A{
    public void tell1(){
        //super.tell1();
        System.out.println("B----tell1");//重写后的方法
    }

    public void tell3(){
        System.out.println("B----tell3");
    }
}

public class PolDemo {
    public static void main(String[] args){
        //向上转向
       /* A a = new B();
        a.tell1();
        a.tell2();*/

        //向下转型
        A a = new B();
        B b = (B) a;
        b.tell1();
        b.tell2();
        b.tell3();

        A a2 = new A();
        System.out.println(a2 instanceof A);//true
        System.out.println(a2 instanceof B);//false

        A a3 = new B();//向上转型
        System.out.println(a3 instanceof A);//true
        System.out.println(a3 instanceof B);//true
    }
}
