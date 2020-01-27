package com.legend.HTTP.HTTPClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

//多线程
class Post extends Thread{

    //创建HttpClient对象
    HttpClient client = HttpClients.createDefault();

    @Override
    public void run() {
        HttpPost post = new HttpPost("http://fanyi.youdao.com/openapi.do");
        try {
            //keyfrom=JKXY-test&key=343166845&type=data&doctype=xml&version=1.1&q=welcome
            //拼接参数
            List<BasicNameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair("keyfrom","JKXY-test"));
            parameters.add(new BasicNameValuePair("key","343166845"));
            parameters.add(new BasicNameValuePair("type","data"));
            parameters.add(new BasicNameValuePair("doctype","xml"));
            parameters.add(new BasicNameValuePair("version","1.1"));
            parameters.add(new BasicNameValuePair("q","welcome"));

            //
            post.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));

            //执行
            HttpResponse response = client.execute(post);

            //响应之后获取对象
            HttpEntity entity= response.getEntity();
            String result = EntityUtils.toString(entity,"UTF-8");
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * @author Create By legend
 * @date 2019/3/21 14:11
 * 使用HttpClient进行Get通信
 */
public class HttpClientPostDemo {
    public static void main(String[] args){
        //启动
        new Post().start();
    }
}
