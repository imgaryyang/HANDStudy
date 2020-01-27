package com.legend.Generic;

interface GenInter<T>{
   public void say();
}

class Gin<T> implements GenInter<String>{
    private String info;

    public Gin(String info){
        this.info = info;
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public void say() {
        System.out.println(this.getInfo());
    }
}

//泛型在接口中的使用
public class GenericDemo5 {
    public static void main(String[] args){
       Gin<String> g = new Gin<String>("gg");

       System.out.println(g.getInfo());
    }
}
