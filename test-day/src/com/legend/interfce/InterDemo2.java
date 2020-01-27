package com.legend.interfce;

//接口类
interface USB{
    public void start();
    public void stop();
}

//电脑类
class Computer {

    public static void work(USB u) {
        u.start();
        System.out.println("工作中");
        u.stop();
    }
}

//U盘
class USBDisk implements USB{

    @Override
    public void start() {
        System.out.println("U盘工作中");
    }

    @Override
    public void stop() {
        System.out.println("U盘停止工作");
    }
}

class Printer implements USB{

    @Override
    public void start() {
        System.out.println("打印机开始工作了");
    }

    @Override
    public void stop() {
        System.out.println("打印机停止工作");
    }
}


public class InterDemo2 {
    public static void main(String[] args){
        Computer.work(new USBDisk());
        Computer.work(new Printer());
    }
}
