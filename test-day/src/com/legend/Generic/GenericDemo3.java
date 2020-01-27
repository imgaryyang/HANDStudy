package com.legend.Generic;

class Gen<K,T>{
    private T take;
    private K key;

    public T getTake() {
        return take;
    }

    public void setTake(T take) {
        this.take = take;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }
}

//使用多种泛型
public class GenericDemo3 {
    public static void main(String[] args){
        Gen<String,Integer> g = new Gen<String,Integer>();
        g.setTake(10);
        g.setKey("aaa");
        System.out.println(g.getKey()+" "+g.getTake());
    }
}
