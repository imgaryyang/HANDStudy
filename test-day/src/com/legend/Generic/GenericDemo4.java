package com.legend.Generic;

class Info<K>{
    private K key;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Info{" +
                "key=" + key +
                '}';
    }
}

//使用通配符
public class GenericDemo4 {
    public static void main(String[] args){
        Info<String> i = new Info<String>();
        i.setKey("aaa");
        tell(i);
        System.out.println(i);
    }

    //通配符 ?  <Object>
    public static void tell(Info<?> o){
        System.out.println("Hello Hand");

    }
}
