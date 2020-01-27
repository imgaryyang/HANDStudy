package com.legend.extendDemo;

//人类
class A{
    public void tell(){
        System.out.println("我是tell方法");
    }
}

//学生类
class B extends A{
    @Override
    public void tell(){
        super.tell();//调用父类方法,默认是不调用父类方法
        System.out.println("我重写了tell方法");
    }
}

public class ExtendsTest3 {
    public static void main(String[] args){
        B b = new B();
        b.tell();
    }
}
