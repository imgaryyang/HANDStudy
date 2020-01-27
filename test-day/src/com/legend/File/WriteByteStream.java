package com.legend.File;

import java.io.FileOutputStream;

public class WriteByteStream {
    public static void main(String[] args) {
        try {
            //文件输出流
            FileOutputStream fos = new FileOutputStream("new2.txt");
            String str = "writer1234你好汉得";

            //转换成字节数组
            byte[] b = str.getBytes("UTF-8");
            fos.write(b);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }
}
