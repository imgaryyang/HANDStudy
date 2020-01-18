package com.legend.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadLocal的使用
 *
 * @author legend
 */
public class ThreadLocalTest {

    /**
     * 只创建一次 SimpleDateFormat 对象，避免不必要的资源消耗
     */
    static SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static ExecutorService THREADPOOL = Executors.newFixedThreadPool(10);


    public static void main(String[] args) {

        //一千个线程打印日期,用线程池来执行,出现线程安全问题
        printOneThousandThreadForPool();
        //一千个线程打印日期 用线程池来执行
        //printOneThousandThread();
        //三十个线程打印日期
        //printThirtyThread();
        //两个线程打印日期
        //printTwoThread();
    }

    /**
     * 1000个线程打印日期,用线程池来执行,出现线程安全问题
     */
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


    /**
     * 一千个线程打印日期 用线程池来执行
     */
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
