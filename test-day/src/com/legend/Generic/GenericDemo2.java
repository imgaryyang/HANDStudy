package com.legend.Generic;

class Con<T>{
    private T value;
    public Con(T value){
        this.value = value;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

//构造方法中使用泛型
public class GenericDemo2 {
    public static void main(String[] args){
        Con<String> c = new Con<String>("aa");
        System.out.println(c.getValue());
    }
}
