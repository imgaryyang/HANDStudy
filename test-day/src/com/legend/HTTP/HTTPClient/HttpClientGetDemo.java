package com.legend.HTTP.HTTPClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

//多线程
class Get extends Thread{

    //创建HttpClient对象
    HttpClient client = HttpClients.createDefault();

    @Override
    public void run() {
        HttpGet get = new HttpGet("http://www.baidu.com");
        try {
            //执行
            HttpResponse response = client.execute(get);

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
public class HttpClientGetDemo {
    public static void main(String[] args){
        //启动
        new Get().start();
    }
}
