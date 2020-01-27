package com.legend.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Create By legend
 * @date 2019/3/21 15:10
 */
public class ChatSocket extends Thread{
    private Socket socket;

    public ChatSocket(Socket socket){
        this.socket = socket;
    }


    public void out(String out){
        try {
            socket.getOutputStream().write(out.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            while ((line=br.readLine())!=null){
                ChatManager.getChatManager().publish(this,line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



       /* int count = 0;
        while (true){
            count++;
            out("loop="+count);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/



        /*try {
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            int count = 0;
            while (true){
                count++;
                bw.write("loop"+count);
                sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
