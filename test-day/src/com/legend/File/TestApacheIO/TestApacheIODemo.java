package com.legend.File.TestApacheIO;

import org.apache.commons.io.FileUtils;

import java.io.File;

//使用ApacheIO操作IO
public class TestApacheIODemo {
    public static void main(String[] args){
        File file = new File("new4.txt");
        File newFile = new File("new5.txt");
        try {
            //将文件转为字符串
            String s = FileUtils.readFileToString(file, "UTF-8");
            System.out.println(s);

            //复制文件
            FileUtils.copyFile(file,newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
