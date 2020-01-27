package com.legend.File.RandomAccess;

import java.io.*;

//文件随机读写
public class RandomAccessFileDemo {
    static File file = new File("hh.txt");

    public static void main(String[] args){
        if (file.exists()){
            file.delete();
        }
        new WriteFile(file,1).start();
        new WriteFile(file,2).start();
        new WriteFile(file,3).start();
        new WriteFile(file,4).start();
        new WriteFile(file,5).start();


        try {
            //只读
            RandomAccessFile raf = new RandomAccessFile(file,"r");
            raf.seek(400);//读取时，将指针重置到文件的开始位置
            byte[] str = new byte[20];
            raf.read(str);
            String in = new String(str,"UTF-8");
            System.out.println(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
