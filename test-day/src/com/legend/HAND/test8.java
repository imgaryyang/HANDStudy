package com.legend.HAND;

//转义字符
public class test8 {

    public static void main(String[] args){
        int e = 20013;

        System.out.println("\u4e2d"+":"+e);
        System.out.println(4*Math.pow(16,3)+14*Math.pow(16,2)+2*16+13);//4e2d 转换来的
        System.out.println((char)20013+":"+"20013");
        System.out.print("我和"+"\n");
        System.out.println("\t"+"你不在一行显示");
        System.out.println("System.out.println(\"注意双引号也能显示出来哦\");");
        System.out.println("\"");//转移一个双引号
        System.out.println('\\');//转移一个单斜杆

    }


}
