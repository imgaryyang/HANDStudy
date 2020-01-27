package com.legend.Socket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Create By legend
 * @date 2019/3/21 14:55
 */
public class MyServerSocket {
    public static void main(String[] args){
        try {
            //创建服务器端Socket
            ServerSocket serverSocket = new ServerSocket(12348);
            //监听端口--->阻塞block
            Socket socket = serverSocket.accept();
            System.out.println(socket);
            //JOptionPane.showMessageDialog(null,"有客户端连接到本机12345端口");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
