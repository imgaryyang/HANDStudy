package com.legend.HTTP;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class ReadByGet extends Thread{
    @Override
    public void run() {
        try {
            //请求地址
            URL url = new URL("http://fanyi.youdao.com/openapi.do?keyfrom=JKXY-test&key=343166845&type=data&doctype=xml&version=1.1&q=welcome");

            //打开连接
            URLConnection connection = url.openConnection();

            //获取输入流
            InputStream is = connection.getInputStream();
            //包装输入流
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");

            //缓冲流
            BufferedReader br = new BufferedReader(isr);
            String line;
            //拼接字符串变量
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine())!=null){
                builder.append(line);
            }

            //关闭资源
            br.close();
            isr.close();
            is.close();
            System.out.println(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


/**
 * @author Create By legend
 * @date 2019/3/21 13:26
 *
 * 使用Http的Get方式与网络进行交互
 */
public class HTTPGetDemo {
    public static void main(String[] args){
        new ReadByGet().start();
    }
}
