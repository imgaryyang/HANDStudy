package com.legend.File.RandomAccess;

import java.io.File;
import java.io.RandomAccessFile;

public class WriteFile extends Thread {
    int block;
    File file;
    int L = 100;

    public WriteFile(File f,int b){
        this.block = b;
        this.file = f;
    }

    @Override
    public void run() {
        try {
            RandomAccessFile raf = new RandomAccessFile(file,"rw");
            raf.seek((block-1)*L);
            raf.writeBytes("This is block"+block);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
