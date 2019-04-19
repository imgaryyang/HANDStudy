# 线程
## 创建线程的方式及实现
- 继承Thread类创建线程类
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320085219332-1430546785.png)

- 通过Runable接口创建线程类
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320085927361-114864872.png)

- 通过Callable和FutureTask创建线程
```
a.创建Callable接口的实现类，并实现call() 方法

b.创建Callable实现类的实例,使用FutureTask类来包装Callable对象，该FutureTask对象封装了该Callable对象的call() 方法的返回值；

c.使用FutureTask对象作为Thread对象的target传概念并启动新线程；

d.调用FutureTask对象的get() 方法来获得子线程执行结束后的返回值。
```

- 通过线程池创建线程
```
package com.legend.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池创建线程
 * @author legend
 *
 */
public class ThreadPoolDemo
{
    /* POOL_NUM */
    private static int POOL_NUM = 10;

    /**
     * Main function
     */
    public static void main(String[] args)
    {
        //System.out.println("\u4e2d");
        //System.out.println(4*Math.pow(16,3)+14*Math.pow(16,2)+2*Math.pow(16,1)+13);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i<POOL_NUM; i++)
        {
            RunnableThread thread = new RunnableThread();
            executorService.execute(thread);
        }
    }
}

class RunnableThread implements Runnable {
    private int THREAD_NUM = 10;

    @Override
    public void run()
    {
        for(int i = 0; i<THREAD_NUM; i++)
        {
            System.out.println("线程" + Thread.currentThread() + " " + i);
        }
    }
}

```

## sleep() 、join（）、yield（）有什么区别
- sleep() 方法
```
	使当前线程(即调用该方法的线程)暂停执行一段时间，让其他线程邮寄或继续执行，但他并不释放对象锁。也就是说如果由synchronize同步块，其他线程仍然不能访问共享数据。

sleep()可以使低优先级的线程得到执行的机会，当然也可以让同优先级、高优先级的线程有执行的机会。
```

- join() 方法
```
join方法使调用该方法的线程在此之间执行完毕，也就是等待该方法的线程执行完毕后再往下继续执行，注意该方法也需要捕捉异常。
```

- yield() 
```
该方法与sleep() 类似，值是不能由用户指定暂停多长时间，并且yield()  方法只能让同优先级的线程有执行的机会。
```

## 说说 CountDownLatch 原理
```

```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320093639841-1030289478.png)


## ThreadLocal 原理分析
```
ThreadLocal很多地方叫做线程本地变量，也有些地方叫线程本地存储。Thread Local为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己本地的副本变量。
```
- Threadlocal提供的方法
```
public T get() { }
public void set(T value) { }
public void remove() { }
protected T initialValue() { }



get方法是用来获取ThreadLocal在当前线程中保存的变量副本，set() 用来设置当前线程中变量的副本,remove() 用来移除当前线程中变量的副本，initialValue() 是一个protected方法,一般是用来在使用时进行重写的,它是一个延迟加载方法,
```

-get方法

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321202956091-908263086.png)
```
第一句是取得当前线程，然后通过getMap(t)方法获取到一个map，map的类型为ThreadLocalMap。然后接着下面获取到<key,value>键值对，注意这里获取键值对传进去的是  this，而不是当前线程t。如果获取成功，则返回value值。
　　如果map为空，则调用setInitialValue方法返回value。
```
`getMap`
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321203148921-1532352167.png)




## 讲讲线程池的实现原理
### Java线程池的工厂类：Executors类,
### 初始化4种类型的线程池：
- newFixedThreadPool() 
```
说明：初始化一个指定线程数的线程池，其中corePoolSize == maxiPoolSize,使用LinkedBlockingQuene作为阻塞队列

特点：即使当线程池没有可执行任务时，也不会释放线程
```

- newCachedThreadPool()
```
初始化一个可以缓存线程的线程池,默认缓存60s，线程池的线程数可达到Integer.MAX_VALUE，即2147483647，内部使用SynchronousQueue作为阻塞队列；

特点：在没有任务执行时，当线程的空闲时间超过KeepAliveTime会自动释放线程资源；当提交新任务时，如果没有空闲线程，则创建新线程执行任务，会导致一定的系统开销；因此，使用时要注意控制兵法的任务书，防止因创建大量的线程导致而降低性能。
```


* 线程池的几种方式与使用场景
### 线程的生命周期
```
New(新生)，
Runnable(可运行)：为了方便分析，还可将其分为：Runnable与Running。
blocked(被阻塞)，
Dead(死亡)。
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321085100329-861723380.png)
