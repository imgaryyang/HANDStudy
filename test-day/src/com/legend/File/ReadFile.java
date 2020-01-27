package com.legend.File;

import java.io.*;

public class ReadFile {
    public static void main(String[] args){
        //读取文件
        File file = new File("new2.txt");

        //判断是否存在
        if (file.exists()){
            try {
                //文件输入流
                FileInputStream fis = new FileInputStream(file);

                //字符流(读取)
                InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

                //缓冲流
                BufferedReader br = new BufferedReader(isr);

                /*String s = br.readLine();
                while (s!=null){
                    System.out.println(s);
                }*/

                String str = null;
                while ((str=br.readLine())!=null){
                    System.out.println(str);
                }

                //释放资源
                br.close();
                isr.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
