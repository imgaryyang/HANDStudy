package com.legend.HAND;

//基本数据类型的包装类
public class test5 {

    public static void main(String[] args){
        System.out.println(Byte.MIN_VALUE+"~"+Byte.MAX_VALUE);
        System.out.println(Byte.parseByte("100")+10);

        System.out.println(Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
        System.out.println(Integer.parseInt("1000")+100);
        System.out.println("十进制的16转为二进制数是"+Integer.toBinaryString(16));
        System.out.println("十进制的16转为十六进制数是"+Integer.toHexString(16));
    }


}
