package com.legend.methodDemo;

public class Son extends Father{

    private char sex;
    public Son(int money, String name,char sex) {
        super(money, name);
        this.sex = sex;
        System.out.println("子类构造方法");
    }

    public void tell(){
        System.out.println("子类说");
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
