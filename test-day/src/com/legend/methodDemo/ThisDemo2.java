package com.legend.methodDemo;

class P2{
   public void tell(){
       System.out.println(this);
   }
}

//this关键字表示当前对象
public class ThisDemo2 {
    public static void main(String[] args){
        P2 p = new P2();
        System.out.println(p);
        p.tell();
    }

}
