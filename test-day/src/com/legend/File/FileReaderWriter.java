package com.legend.File;

import java.io.*;

public class FileReaderWriter {
    public static void main(String[] args){
        try {
            FileReader fr = new FileReader("new3.txt");
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter("new4.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            String line ;
            while ((line=br.readLine())!=null){
                bw.write(line+"\n");
            }
            bw.flush();
            fw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
