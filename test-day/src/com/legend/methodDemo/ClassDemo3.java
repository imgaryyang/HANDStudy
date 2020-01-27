package com.legend.methodDemo;

//封装调用
class People{
    private int age;
    private String name;

    //构造方法
    public People(int a,String n){
        age = a;
        name = n;
        System.out.println("构造方法："+"name:"+name+"  age:"+age);
    }

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
        System.out.println("普通方法："+"name:"+getName()+" age:"+getAge());
    }
}

//匿名对象&&构造方法
public class ClassDemo3 {
    public static void main(String[] args){

        //匿名对象--->一般使用一次
       new People(30,"legend").tell();
    }


}
