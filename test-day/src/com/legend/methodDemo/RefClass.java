package com.legend.methodDemo;

//引用传递
class Ref{
   int temp = 10;
   String name = "aaa";
}


public class RefClass {
    public static void main(String[] args){
        Ref r = new Ref();
        System.out.println("最初："+r.temp+r.name);

        r.temp =20;
        r.name ="vvvv";
        System.out.println("修改后："+r.temp+r.name);

        u(r);
        System.out.println("方法调用修改后："+r.temp+r.name);
    }

    public static void u(Ref r2){
        r2.temp = 30;
        r2.name ="bbb";
    }

}
