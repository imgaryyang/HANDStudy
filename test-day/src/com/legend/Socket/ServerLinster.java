package com.legend.Socket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Create By legend
 * @date 2019/3/21 15:10
 */
public class ServerLinster extends Thread{
    @Override
    public void run() {
        try {
            //创建服务器端Socket
            ServerSocket serverSocket = new ServerSocket(12347);
            while (true){
                //监听端口--->阻塞block
                Socket socket = serverSocket.accept();

                //将socket传递给新的线程
                ChatSocket cs = new ChatSocket(socket);
                cs.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
