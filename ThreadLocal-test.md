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
 * ThreadLocal的使用
 *
 * @author legend
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        //三十个线程打印日期
        printThirtyThread();
        
        //两个线程打印日期
        //printTwoThread();
    }


    /**
     * 三十个线程打印日期
     */
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
`运行结果:两个线程打印日期`
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200118072440833-1132869839.png)

>因为中国位于东八区，所以时间从1970年1月1日的8点开始计算的

`运行结果:三十个线程打印日期`
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200118072703183-100442570.png)

>多个线程打印自己的时间(如果线程超级多就会产生性能问题),所以要使用线程池


```
 public static void printOneThousandThread() {
        ExecutorService threadPool = Executors.newFixedThreadPool(10); 
    for (int i = 0; i < 1000; i++) {
        int finalI = i;
        //提交任务
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalTest().date(finalI);
                System.out.println(date);
            }
        });
    }
    threadPool.shutdown();
}
```
`运行结果:一千个线程打印日期`
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200118075519158-188989352.png)

>但是使用线程池时就会发现每个线程都有一个自己的SimpleDateFormat对象，没有必要，所以将SimpleDateFormat声明为静态，保证只有一个



**如果使用executor 去创建线程会有提示**
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200118073808561-726606861.png)

```
public static void printOneThousandThread() {
        //ExecutorService threadPool = Executors.newFixedThreadPool(10);

        //使用第二种方法创建线程池
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new NameTreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);
        // 预启动所有核心线程
        threadPool.prestartAllCoreThreads();
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            //提交任务
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalTest().date(finalI);
                    System.out.println(date);
                }
            });
        }
        //threadPool.shutdown();

    }

    static class NameTreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    public static class MyIgnorePolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            System.err.println(r.toString() + " rejected");
//          System.out.println("completedTaskCount: " + e.getCompletedTaskCount());
        }
    }
```



```
static SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static ExecutorService THREADPOOL = Executors.newFixedThreadPool(10);


public static void printOneThousandThreadForPool() {
    for (int i = 0; i < 1000; i++) {
        int finalI = i;
        //提交任务
        THREADPOOL.submit(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalTest().date2(finalI);
                System.out.println(date);
            }
        });
    }
    THREADPOOL.shutdown();
}


public String date2(int seconds) {
    //参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
    Date date = new Date(1000 * seconds);
    return DATEFORMAT.format(date);
}
```

`运行结果:出现了秒数相同的打印结果,这显然是不正确的.`
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200118080728456-514338384.png)


#### 出现问题的原因
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200118080823322-398004996.png)

>多个线程的task指向了同一个SimpleDateFormat对象，SimpleDateFormat是非线程安全的。