## 使用 ThreadLocal 

### 1.ThreadLocal的使用场景
#### 场景1
每个线程需要一个独享对象(通常是工具类，典型需要使用的类有SimpleDateFormat和Random) 每个Thread内有自己的实例副本，不共享

比喻：教材只有一本，一起做笔记有线程安全问题。复印后没有问题，使用ThradLocal相当于复印了教材。


#### 场景2
每个线程内需要保存全局变量(例如在拦截器中获取用户信息)，可以让不同方法直接使用，避免参数传递的麻烦


### 2.对以上场景的实践
#### 实践场景1
```
package com.legend.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ThreaLocal的使用
 *
 * @author legend
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        //两个线程打印日期
        printTwoThread();
        printThirtyThread();
    }


    public static void printThirtyThread() {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalTest().date(finalI);
                    System.out.println(date);
                }
            }).start();

            //线程启动后，休眠100ms
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 两个线程打印日期
     */
    public static void printTwoThread() {
        //线程一
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalTest().date(10);
                System.out.println(date);
            }
        }).start();

        //线程二
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalTest().date(104707);
                System.out.println(date);
            }
        }).start();
    }


    /**
     * 格式化日期
     *
     * @param seconds
     * @return
     */
    public String date(int seconds) {
        //参数的单位是毫秒,从1970.1.1 00:00:00 GMT 开始计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}

```

![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200117082111848-1691462589.png)


>因为中国位于东八区，所以时间从1970年1月1日的8点开始计算的