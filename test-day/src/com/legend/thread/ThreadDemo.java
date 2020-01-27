package com.legend.thread;

//创建线程
public class ThreadDemo extends Thread{

    private String name;
    public ThreadDemo(String name){
        this.name = name;
    }
    //重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + i);
        }
    }
}
