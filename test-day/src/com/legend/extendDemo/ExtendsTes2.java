package com.legend.extendDemo;

//父类
class Father{
   public Father(){
       System.out.println("父类构造方法");
   }

}

//子类
class Son extends Father{
    public Son(){
        System.out.println("子类构造方法");
    }

}

public class ExtendsTes2 {
    public static void main(String[] args){
        Son s = new Son();
    }
}
