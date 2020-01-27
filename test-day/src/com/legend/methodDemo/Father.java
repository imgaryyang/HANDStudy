package com.legend.methodDemo;

public class Father {
    private int money;
    private String name;

    public Father(int money,String name){
        this.name = name;
        this.money = money;
        System.out.println("父类构造方法");
    }

    public void tell(){
        System.out.println("父亲说的");
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
