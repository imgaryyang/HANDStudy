package com.legend.XML;

class P{
    public void count(){
        System.out.println(10%3);
    }
}


class S extends P{
    public void count(){
        System.out.println(10/3);
    }
}

/**
 * @author Create By legend
 * @date 2019/3/21 19:52
 */
public class test {
    static final int j = 10;
    public static void main(String[] args){
        String str = "123456";
        String s = str.substring(0,3);
        System.out.println(""+s);
        int i = 0;
        System.out.println(i++);
        String ss = null;
        System.out.println("s+"+ss);

        System.out.println(Math.round(11.5));
        System.out.println(Math.round(11.2));
        System.out.println(Math.round(-11.5));
        System.out.println(Math.ceil(15.5));
        System.out.println(Math.floor(15.5));
        System.out.println(Math.random()*10);

    }
}
