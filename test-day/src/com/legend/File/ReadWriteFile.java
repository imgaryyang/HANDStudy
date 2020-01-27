package com.legend.File;

import java.io.*;

//读写文件
public class ReadWriteFile {
    public static void main(String[] args){
        File file = new File("new2.txt");

        //读取文件
        if(file.exists()){
            try {
                //文件输入流
                FileInputStream fis = new FileInputStream(file);

                //文件输出流
                InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

                //缓冲流
                BufferedReader br = new BufferedReader(isr);

                String line;
                while ((line=br.readLine())!= null){
                    System.out.println(line);
                }

                //后打开的先关闭
                br.close();
                isr.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //写入文件(覆盖性)
    public static void writeFile(){
        File file = new File("wri.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("你好,汉得\n");
            bw.write("我在上海\n");
            bw.write("很大\n");

            bw.close();
            osw.close();
            fos.close();
            System.out.println("写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
