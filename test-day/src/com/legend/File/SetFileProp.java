package com.legend.File;

import java.io.File;
import java.io.IOException;

public class SetFileProp {
    public static void main(String[] args){
        File file = new File("abc.txt");

        if(file.exists()){
            //将文件设置为可写
            file.setWritable(false);

            //将文件设置为可读
            file.setReadable(true);

            //将文件设置为只读
            file.setReadOnly();
        }
    }
}
