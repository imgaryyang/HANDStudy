package com.legend.thread;

/*class MyThread extends Thread{
        private int ticket =10;

        @Override
        public void run() {
        for (int i = 0; i < 10; i++) {
            //同步代码块
            synchronized (this){
                if (ticket>0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("车票"+ticket--);
                }
            }
        }
    }
}*/



//创建线程
class MyRun implements Runnable{
    private int ticket =10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //同步代码块
           synchronized (this){
               if (ticket>0){
                   try {
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("车票"+ticket--);
               }
           }
        }
    }
}

//车站买票
public class ThreadDemo2{
    public static void main(String[] args){
        MyRun r = new MyRun();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.run();
        t2.run();
        t3.run();

       //用这个方法没有实现资源共享
   /*    MyThread m1 = new MyThread();
       MyThread m2 = new MyThread();
       m1.start();
       m2.start();*/

    }
}
