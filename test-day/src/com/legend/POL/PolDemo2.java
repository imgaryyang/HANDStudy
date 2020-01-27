package com.legend.POL;


class A1{
    public void tell1(){
        System.out.println("A----tell1");
    }

}


class B1 extends A1{
    public void tell2(){
        System.out.println("B----tell1");//重写后的方法
    }

}

class C1 extends A1{
    public void tell3(){
        System.out.println("C----tell1");//重写后的方法
    }

}

public class PolDemo2 {
    public static void main(String[] args){
       say(new B1());
       say(new C1());
    }

    public static void say(A1 a){
        a.tell1();
    }
}
