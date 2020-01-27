package com.legend.File;

import java.io.File;
import java.io.IOException;

public class ReadFileProp {
    public static void main(String[] args){
        //在相对路径下面创建也就是当前工程 跟src同级
        File file = new File("new2.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取文件是否存在
        System.out.println(""+file.exists());

        //读取文件名
        System.out.println(""+file.getName());

        //读取文件路径
        System.out.println(""+file.getPath());

        //读取文件父级路径
        System.out.println(""+new File(file.getAbsolutePath()).getParent());

        //读取文件绝对路径
        System.out.println(""+file.getAbsolutePath());

        //判断文件是否被隐藏
        System.out.println(""+file.isHidden());

        //判断文件是否可读
        System.out.println(""+file.canRead());

        //判断文件是否可写
        System.out.println(""+file.canWrite());

        //读取文件大小(获取的是字节)
        System.out.println(""+(float)file.length()/1000+"KB");

        //判断是否为文件夹
        System.out.println(""+file.isDirectory());
    }
}
