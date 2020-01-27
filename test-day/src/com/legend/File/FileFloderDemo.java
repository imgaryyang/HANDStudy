package com.legend.File;

import java.io.File;

public class FileFloderDemo {
    public static void main(String[] args){
        //在相对路径下面创建也就是当前工程 跟src同级
        File floder = new File("HelloFloder");

        //文件夹的多级目录创建
        //floder.mkdirs();

        if (floder.mkdir()){
            System.out.println("文件夹创建成功");
        }else{
            if(floder.exists()){
                System.out.println("文件夹已存在");
            }else {
                System.out.println("文件夹创建失败");
            }
        }

        //文件夹重命名
        //File f = new File("TestFloder");
        //floder.renameTo(f);

        //文件夹删除
        floder.delete();//文件夹目录下面不能有文件,一定要是空文件夹
    }
}
