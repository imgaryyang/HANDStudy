package com.legend.Socket;

import java.util.Vector;

/**
 * @author Create By legend
 * @date 2019/3/21 16:00
 *
 * 管理线程类    单例模式
 */
public class ChatManager {
    private ChatManager(){

    }

    private static final ChatManager cm = new ChatManager();
    public static ChatManager getChatManager(){
        return cm;
    }
    Vector<ChatSocket> vector = new Vector<ChatSocket>();
    public void add(ChatSocket cs){
        vector.add(cs);
    }

    public void publish(ChatSocket cs,String out){
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket csChatSocket = vector.get(i);
            if (!cs.equals(csChatSocket)){
                csChatSocket.out(out);
            }
        }
    }





}
