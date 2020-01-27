package com.legend.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyByByteStream {
    public static void main(String[] args){
        //读取文件
        try {
            FileInputStream fis = new FileInputStream("new2.txt");
            FileOutputStream fos = new FileOutputStream("new3.txt");

            byte[] b = new byte[1024];
            while(fis.read(b)!=-1){
                fos.write(b);
            }
            String str = new String(b,"UTF-8");
            System.out.println(str);
            fis.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
