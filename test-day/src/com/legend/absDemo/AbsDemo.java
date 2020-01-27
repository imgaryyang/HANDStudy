package com.legend.absDemo;

class Person{
    private int age;
    private String name;

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

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}


class Student extends Person{
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public Student(int age,String name,int score){
        super(age,name);
        this.score = score;

    }
    public void want(){
        System.out.println("name:"+this.getName()+" age:"+this.getAge()+" Score:"+this.getScore());
    }
}



class Worker extends Person{
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Worker(int age,String name,int money){
        super(age,name);
        this.money = money;
    }

    public void want(){
        System.out.println("name:"+this.getName()+" age:"+this.getAge()+" money:"+this.getMoney());
    }
}

public class AbsDemo {
    public static void main(String[] args){
        Student s = new Student(13,"hh",90);
        s.want();
        Worker w = new Worker(33,"a",1000);

        w.want();
    }
}
