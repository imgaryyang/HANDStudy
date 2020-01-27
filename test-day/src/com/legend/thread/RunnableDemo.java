package com.legend.thread;

//实现runnable接口
public class RunnableDemo implements Runnable {

    private String name;
    public RunnableDemo(String name){
        this.name = name;
    }

    //重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(name+i);
        }

    }
}
