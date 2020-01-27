package com.legend.methodDemo;

class P{
    private int age;
    private String name;

    //构造
    public P(){
        System.out.println("无参构造方法执行了");
    }

    public P(int age,String name){
        this();//只能放在第一行

        this.age = age;//将方法中的age参数 赋值给当前类中的age属性
        this.name = name;
    }
    public void tell(){
        System.out.println("name:"+this.getName()+" age:"+this.getAge());
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//this关键字
public class ThisDemo {
    public static void main(String[] args){
        P p = new P(20,"aa");
        p.tell();
    }

}
