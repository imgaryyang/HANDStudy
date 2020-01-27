package com.legend.interfce;

//接口类
interface Inter1{
    public static final int AGE1 = 100;
    public abstract void tell();
}

//接口类
interface Inter2{
    public final int AGE2 = 100;
    public abstract void say();
}

//接口多继承
interface Inter3 extends Inter2,Inter1{

}

//实现类
class A implements Inter1, Inter2{

    @Override
    public void tell() {
        System.out.println(AGE2);
    }

    @Override
    public void say() {

    }
}


//抽象类
abstract class B{
    public int v = 10;
    public final int c = 100;

    //抽象方法
    abstract void hello();

    //普通方法
    public void go() {
        System.out.println("Go");
    }
}

abstract class D{

}

//abstract class E extends D,B{ }//报错

//实现类
class C extends B{

    @Override
    void hello() {
        System.out.println("hello");
    }
}

public class Inter1Demo1 {
    public static void main(String[] args){
        A a = new A();
        a.say();
        C c = new C();
        c.hello();
    }
}
