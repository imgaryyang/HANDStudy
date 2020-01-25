## 使用 ThreadLocal 

### 1.ThreadLocal的使用场景
#### 场景1
每个线程需要一个独享对象(通常是工具类，典型需要使用的类有SimpleDateFormat和Random) 

每个Thread内有自己的实例副本，不共享

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


### 解决问题的方案
#### 方案1：加锁
格式化diamagnetic是在最后一句
```
return dateFormat.format(date);
```

所以可以为最后一句代码添加`synchronized`  锁

```
public String date(int seconds) {
    //参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
    Date date = new Date(1000 * seconds);
    String s;
    synchronized (ThreadLocalTest.class) {
        s = DATEFORMAT.format(date);
    }
    return s;
}
```
运行结果中没有发现相同的时间，达到了线程安全的目的
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125213259161-508564810.png)


>缺点：因为添加了  synchronized 所以会保证同一时间只有一条线程可以执行，这在高并发场景下肯定不是一个好的选择。


#### 方案2：使用ThreadLocal

```java
/**
 * 利用 ThreadLocal 给每个线程分配自己的 dateFormat 对象
 * 不但保证了线程安全，还高效的利用了内存
 */
public static void threadLocalMethod() {
    for (int i = 0; i < 1000; i++) {
        int finalI = i;
        //提交任务
        THREADPOOL.submit(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalTest().date4(finalI);
                System.out.println(date);
            }
        });
    }
    THREADPOOL.shutdown();
}

public String date4(int seconds) {

    //参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
    Date date = new Date(1000 * seconds);
    //获取 SimpleDateFormat 对象
    SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
    return dateFormat.format(date);
}

static class ThreadSafeFormatter {
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {

        //创建一份 SimpleDateFormat 对象
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };
}
```

`运行结果:`
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125214852264-1122358706.png)

>使用了ThreadLocal 后不同的线程不会有共享的 SimpleDateFormat 对象，所以也就不会有线程安全问题


#### 实践场景2
当前用户信息需要被线程内的所有方法共享


##### 方案1：传递参数
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125215229845-1278947642.png)

可以将user 作为参数在每个方法中进行传递，

缺点：但是这样做会产生代码冗余问题，并且可维护性差。


##### 方案2：使用Map
对此进行改进的方案是使用一个Map，在第一个方法中存储信息，后续需要使用直接get()   即可，

![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125215519087-185749705.png)


缺点：如果在单线程环境下可以保证安全，但是在多线程环境下不可以的。如果使用加锁和ConcurrentHashMap  都会产生性能问题。


##### 方案3：使用ThreadLocal，实现不同方法间的资源共享

使用ThreadLocal  可以避免加锁产生的性能问题，也可以避免层层传递参数来实现业务需求，就可以不同线程中存储不同信息的要求。

![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125215917657-1199852516.png)


```java
private static void threadLocalDemo(){
    new Service1().process();
}


static class Service1 {
    public static void process() {
        User user = new User("legend鲁毅");
        //将User对象存储到 holder 中
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

static class Service2 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service2拿到用户名: " + user.name);
        new Service3().process();
    }
}

static class Service3 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3拿到用户名: " + user.name);
    }
}


static class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}


static class User {
   String name;
   public User(String name) {
       this.name = name;
   }
}
```

![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125225729221-1181410804.png)




### 对ThreadLocal 的总结
- 让某个需要用到的对象实现线程之间的隔离(每个线程都有自己独立的对象)
- 可以在任何方法中轻松的获取到该对象
- 根据共享对象生成的时机选择使用initialValue方法还是set 方法
- 对象初始化的时机由我们控制的时候使用initialValue 方式
- 如果对象生成的时机不由我们控制的时候使用set方式


### 使用ThreadLocal 的好处
- 达到线程安全的目的
- 不需要加锁，执行效率高
- 更加节省内存，节省开销
- 免去传参的频繁，降低代码耦合度



### ThreadLocal原理
![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125231217785-1655538385.png)

- Thread
- ThreadLocal 
- ThreadLocalMap

在Thread类内部有`ThreadLocal.ThreadLocalMap  threadLocals = null;` 这个变量,它用于存储ThreadLocal ，因为在同一个线程当中可以有多个ThreadLocal 并且多次调用get()  所以需要在内部维护一个ThreadLocalMap用力存储多个ThreadLocal  


#### ThreadLocal 相关方法
- T initialValue()
```
该方法用于设置初始值,并且在调用get()  方法时才会被触发,所以是懒加载.

但是如果在get()  之前进行了set() 操作, 这样做就不会调用initialValue() 

通常每个线程只能调用一次本方法,但是调用了remove() 后就能再次调用
```

- 



### THreadLocal注意点
#### 内存泄漏
内存泄露：某个对象不会再被使用，但是该对象的内存却无法被收回

![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125232041035-1207473719.png)


```
static class ThreadLocalMap {
    static class Entry extends WeakReference<ThreadLocal<?>> {
        /** The value associated with this ThreadLocal. */
        Object value;

        Entry(ThreadLocal<?> k, Object v) {
            //调用父类，父类是一个弱引用
            super(k);
            //强引用
            value = v;
        }
    }
}
```

>强引用：当内存不足时触发GC，宁愿抛出OOM 也不会回收强引用的内存
>弱引用：触发GC 后便回收弱引用的内存

##### 正常情况
当Thread 运行结束后，ThreadLocal 中的Value 会被回收，因为没有任何强引用


##### 非正常情况
当Thread 一直在运行始终不结束，强引用就不会被回收，存在以下调用链  `Thread-->THreadLocalMap-->Entry(key为null)-->value`

因为调用链中的value和Thread存在强引用，所以value 无法被回收，就有可能出现OOM。

JDK的设计已经考虑到这个问题，所以在set()  、remove()  、resize()  方法中扫描到key为null的Entry，并且把对应的value设置为null，这样value对象就可以被回收。


![](https://img2018.cnblogs.com/blog/1231979/202001/1231979-20200125234125770-809643049.png)

>但是只有在调用set()  、remove()、resize() 这些方法时才会进行这些操作，如果没有调用这些方法并且线程不停止，那么调用链就会一直存在，所以可能会发生内存泄露



#### 如何避免内存泄漏(阿里规约)
调用remove()  方法就会删除对应的Entry 对象 可以避免内存泄漏，所以使用完ThreadLocal后,要调用remove()  方法



#### ThreadLocal 的空指针异常问题

```

```



