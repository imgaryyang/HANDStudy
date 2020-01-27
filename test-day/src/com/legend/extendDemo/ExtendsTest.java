package com.legend.extendDemo;

//人类
class People{
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


}

//学生类
class Student extends People{
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void say(){
        System.out.println("name:"+this.getName()+" Age:"+this.getAge()+" Score:"+this.getScore());
    }
}

public class ExtendsTest {
    public static void main(String[] args){
        Student s = new Student();
        s.setScore(99);
        s.setAge(20);
        s.setName("legend");
        s.say();
    }
}
