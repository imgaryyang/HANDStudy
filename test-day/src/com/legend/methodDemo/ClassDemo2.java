package com.legend.methodDemo;

//直接调用
class Person2{
    public int age;
    public String name;
    public void tell(){
        System.out.println("name:"+name+" age:"+age);
    }
}

//封装调用
class Person3{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=0&&age<=100){
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void tell(){
        System.out.println("name:"+getName()+" age:"+getAge());
    }
}

//数据封装性
public class ClassDemo2 {
    public static void main(String[] args){
        //直接调用操作
        Person2 p = new Person2();
        p.age = 10;
        p.name= "legend";
        p.tell();


        //数据封装
        Person3 p2 = new Person3();
        p2.setAge(30);
        p2.setName("legend");
        p2.tell();
    }


}
