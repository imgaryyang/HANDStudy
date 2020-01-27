package com.legend.Generic;

class Pointer<T>{
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}


public class GenericDemo {
    public static void main(String[] args){
        Pointer<String> p = new Pointer<String>();
        p.setX("100");
        p.setY("200");
        System.out.println("X:"+p.getX()+" Y:"+p.getY());
    }
}
