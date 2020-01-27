package com.legend.File;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args){
        File file = new File("D:/newhello.txt");
        //是否存在
        if(file.exists()){
            //文件
            System.out.println(file.isFile());
            //路径(文件夹)
            System.out.println(file.isDirectory());

            //文件重命名
            //File f = new File("D:/newHello.txt");
            //file.renameTo(f);

            //删除文件
            file.delete();
        }else {
            System.out.println("文件不存在");
            try {
                //创建
                //file.createNewFile();
                System.out.println("文件已经成功被创建");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("文件创建失败");
            }
        }
    }
}
