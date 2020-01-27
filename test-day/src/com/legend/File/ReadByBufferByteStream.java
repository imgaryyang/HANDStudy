package com.legend.File;

import java.io.*;

public class ReadByBufferByteStream {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("new3.txt");

            FileOutputStream fos = new FileOutputStream("new3.txt");

            //缓冲字节流
            BufferedInputStream bis = new BufferedInputStream(fis);

            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] b = new byte[90];
            int count = 0;

            //从1970年到现在的时间的毫秒数
            long before = System.currentTimeMillis();

            while (bis.read(b)!=-1){
                bos.write(b);
                count++;
            }
            bis.close();
            fis.close();
            System.out.println(count+"次");
            System.out.println(System.currentTimeMillis()-before+"ms");

            //String str = new String(b,"UTF-8");
            //System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
