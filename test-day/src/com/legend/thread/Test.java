package com.legend.thread;

public class Test {
    public static void main(String[] args){
        //测试Thread类
       /* ThreadDemo t1 = new ThreadDemo("线程一");
        ThreadDemo t2 = new ThreadDemo("线程二");
        t1.start();
        t2.start();*/


        //测试Runnable类
        /*RunnableDemo r1 = new RunnableDemo("线程三");
        RunnableDemo r2 = new RunnableDemo("线程四");
        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r2);
        t3.start();
        t4.start();*/


        //测试join方法
        ThreadDemo t4 = new ThreadDemo("线程4");
        t4.start();
        for(int i = 0; i < 20; i++){
            if(i == 5){
                try {
                    t4.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            System.out.println("主线程"+i);
        }
    }
}
