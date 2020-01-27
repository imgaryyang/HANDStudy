package com.legend.HTTP;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

class ReadByPost extends Thread{
    @Override
    public void run() {
        try {
            //URL网络连接地址
            URL url = new URL("http://fanyi.youdao.com/openapi.do");
            //打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //连接参数配置
            connection.addRequestProperty("encoding","UTF-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");


            //输出流对象
            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            //拼接参数
            bw.write("keyfrom=JKXY-test&key=343166845&type=data&doctype=xml&version=1.1&q=welcome");
            bw.flush();

            //输入流
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");

            //包装isr
            BufferedReader br = new BufferedReader(isr);

            //读取行
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine())!=null){
                builder.append(line);
            }

            //释放资源
            bw.close();
            osw.close();
            os.close();
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
 * 使用Http的post方式与网络交互
 */
public class HTTPPostDemo {
    public static void main(String[] args){
        new ReadByPost().start();
    }
}
