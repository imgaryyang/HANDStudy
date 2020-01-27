package com.legend.File;

import java.io.File;

//遍历文件夹
public class FileScanner {
    public static void main(String[] args){
        printFile(new File("../test"),1);
    }

    //打印文件夹
    public static void printFile(File dir,int tab){
        if (dir.isDirectory()){
            //当前路径的所有文件和文件夹
            File[] next = dir.listFiles();

            for(int i = 0; i < next.length; i++){
                for (int j = 0; j < tab; j++) {
                    System.out.print("|---");
                }
                System.out.println(next[i].getName());
                //如果是文件
                if (next[i].isDirectory()){
                    //文件夹继续循环
                    printFile(next[i],tab+1);
                }
            }
           /* for(int i = 0; i < next.length; i++){
                //如果是文件
                if (next[i].isFile()){
                    System.out.println(next[i].getName());
                }else{
                    //文件夹继续循环
                    printFile(next[i]);
                }
            }*/

        }
    }
}
