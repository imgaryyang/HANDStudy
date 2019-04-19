# �߳�
## �����̵߳ķ�ʽ��ʵ��
- �̳�Thread�ഴ���߳���
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320085219332-1430546785.png)

- ͨ��Runable�ӿڴ����߳���
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320085927361-114864872.png)

- ͨ��Callable��FutureTask�����߳�
```
a.����Callable�ӿڵ�ʵ���࣬��ʵ��call() ����

b.����Callableʵ�����ʵ��,ʹ��FutureTask������װCallable���󣬸�FutureTask�����װ�˸�Callable�����call() �����ķ���ֵ��

c.ʹ��FutureTask������ΪThread�����target������������̣߳�

d.����FutureTask�����get() ������������߳�ִ�н�����ķ���ֵ��
```

- ͨ���̳߳ش����߳�
```
package com.legend.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳ش����߳�
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
            System.out.println("�߳�" + Thread.currentThread() + " " + i);
        }
    }
}

```

## sleep() ��join������yield������ʲô����
- sleep() ����
```
	ʹ��ǰ�߳�(�����ø÷������߳�)��ִͣ��һ��ʱ�䣬�������߳��ʼĻ����ִ�У����������ͷŶ�������Ҳ����˵�����synchronizeͬ���飬�����߳���Ȼ���ܷ��ʹ������ݡ�

sleep()����ʹ�����ȼ����̵߳õ�ִ�еĻ��ᣬ��ȻҲ������ͬ���ȼ��������ȼ����߳���ִ�еĻ��ᡣ
```

- join() ����
```
join����ʹ���ø÷������߳��ڴ�֮��ִ����ϣ�Ҳ���ǵȴ��÷������߳�ִ����Ϻ������¼���ִ�У�ע��÷���Ҳ��Ҫ��׽�쳣��
```

- yield() 
```
�÷�����sleep() ���ƣ�ֵ�ǲ������û�ָ����ͣ�೤ʱ�䣬����yield()  ����ֻ����ͬ���ȼ����߳���ִ�еĻ��ᡣ
```

## ˵˵ CountDownLatch ԭ��
```

```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320093639841-1030289478.png)


## ThreadLocal ԭ�����
```
ThreadLocal�ܶ�ط������̱߳��ر�����Ҳ��Щ�ط����̱߳��ش洢��Thread LocalΪ������ÿ���߳��ж�������һ����������ôÿ���߳̿��Է����Լ����صĸ���������
```
- Threadlocal�ṩ�ķ���
```
public T get() { }
public void set(T value) { }
public void remove() { }
protected T initialValue() { }



get������������ȡThreadLocal�ڵ�ǰ�߳��б���ı���������set() �������õ�ǰ�߳��б����ĸ���,remove() �����Ƴ���ǰ�߳��б����ĸ�����initialValue() ��һ��protected����,һ����������ʹ��ʱ������д��,����һ���ӳټ��ط���,
```

-get����

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321202956091-908263086.png)
```
��һ����ȡ�õ�ǰ�̣߳�Ȼ��ͨ��getMap(t)������ȡ��һ��map��map������ΪThreadLocalMap��Ȼ����������ȡ��<key,value>��ֵ�ԣ�ע�������ȡ��ֵ�Դ���ȥ����  this�������ǵ�ǰ�߳�t�������ȡ�ɹ����򷵻�valueֵ��
�������mapΪ�գ������setInitialValue��������value��
```
`getMap`
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321203148921-1532352167.png)




## �����̳߳ص�ʵ��ԭ��
### Java�̳߳صĹ����ࣺExecutors��,
### ��ʼ��4�����͵��̳߳أ�
- newFixedThreadPool() 
```
˵������ʼ��һ��ָ���߳������̳߳أ�����corePoolSize == maxiPoolSize,ʹ��LinkedBlockingQuene��Ϊ��������

�ص㣺��ʹ���̳߳�û�п�ִ������ʱ��Ҳ�����ͷ��߳�
```

- newCachedThreadPool()
```
��ʼ��һ�����Ի����̵߳��̳߳�,Ĭ�ϻ���60s���̳߳ص��߳����ɴﵽInteger.MAX_VALUE����2147483647���ڲ�ʹ��SynchronousQueue��Ϊ�������У�

�ص㣺��û������ִ��ʱ�����̵߳Ŀ���ʱ�䳬��KeepAliveTime���Զ��ͷ��߳���Դ�����ύ������ʱ�����û�п����̣߳��򴴽����߳�ִ�����񣬻ᵼ��һ����ϵͳ��������ˣ�ʹ��ʱҪע����Ʊ����������飬��ֹ�򴴽��������̵߳��¶��������ܡ�
```


* �̳߳صļ��ַ�ʽ��ʹ�ó���
### �̵߳���������
```
New(����)��
Runnable(������)��Ϊ�˷�����������ɽ����Ϊ��Runnable��Running��
blocked(������)��
Dead(����)��
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321085100329-861723380.png)
