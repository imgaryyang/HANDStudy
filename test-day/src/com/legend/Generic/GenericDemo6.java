package com.legend.Generic;

class Gener{
   public <T>T tell(T t){
       return t;
   }
}


//泛型方法
public class GenericDemo6 {
    public static void main(String[] args){
       Gener g = new Gener();
       System.out.println(g.tell("hhhh"));
       System.out.println(g.tell(10));
    }
}
