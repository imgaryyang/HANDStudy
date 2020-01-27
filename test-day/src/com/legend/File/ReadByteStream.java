package com.legend.File;

import java.io.*;

public class ReadByteStream {
    public static void main(String[] args) {

        //文件输入流
        //FileInputStream fis = null;
        try {
            FileInputStream fis = new FileInputStream("new2.txt");
            byte[] input = new byte[21];
            fis.read(input);
            String inputString = new String(input,"UTF-8");
            System.out.println(inputString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
