# Java语言进阶
## 1 Java集合类详解
### 1.1 Collection
- Collection 接口
```
集合可以理解为一个动态的对象数组，不同的是集合中的对象内容可以任意扩充
```
- 集合特点
```
性能高

容易扩展和修改
```

- Collection的常用子类
```
List

Set

Queue
```


### 1.2 List
```
List接口可以存放任意的数据，而且在List接口中内容是可以重复的
```

- List 接口常用子类
```
ArrayList

Vector
```

- 常用操作
```
判断集合是否为空:boolean isEmpty()

查找指定的对象是否存在：int indexOf(Object o)
```

- 实际操作
```
List<String> list = new ArrayList<>();//创建方式
        list.add("a");//添加操作

遍历打印数据
for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+"\t");
        }

list.remove(4);//删除操作

//是否为空
System.out.println("\n"+list.isEmpty());

//查找位置   存在返回具体的索引，不存在返回-1
System.out.println(list.indexOf("b"));
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320143404787-1133426301.png)


### 1.3 Set
- 定义
```
Set接口不能加入重复元素，但是可以排序
```
- 常用子类
```
散列存放：HashSet

有序存放：TreeSet
```

### 1.4 Iterator 迭代器
- 集合输出的标准操作：
```
标准做法，使用Iterator接口
```

- 操作原理
```
Iterator是专门的迭代输出接口，迭代输出就是将元素一个个进行判断,判断其是否有内容，如果有内容则把内容输出
```
### 1.5 Map
- 保存形式
```
key--->value 的方式保存
```

- 常用子类
```
HashMap：无序存放，key不允许重复

Hashtable：无序存放，key不允许重复
```

- 实际操作
```
package com.legend.MapDemo;

import java.util.*;

public class MapDemo {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("name","HAND");
        map.put("time","2019");
        map.put("date","03");
        System.out.print(map.get("name")+"\t");//通过键获取值

        //判断键是否存在
        if(map.containsKey("time")){
            System.out.print(map.get("time")+"\n");
        }

        //判断值是否存在
        if(map.containsValue("time")){
            System.out.println("不存在值");
        }

        //获取所有的键
        System.out.println("\n获取所有的键");
        Set<String> s = map.keySet();
        Iterator<String> it = s.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+"\t");
        }

        //获取所有的值
        System.out.println("\n获取所有的值");
        Collection<String> values = map.values();
        Iterator<String> v = values.iterator();
        while (v.hasNext()){
            System.out.print(v.next()+"\t");
        }
    }
}

```

## 2. Java本地文件操作
### 2.1 File类简介
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320153228441-682885773.png)


### 2.2 文件的创建、删除、重命名
```
File file = new File("pathname");//创建文件

file.delete();//删除



//文件夹结构必须处于同一个分区
File f = new File("new Name");//文件新的名字
file.renameTo(f);//重命名
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320153746671-1472268786.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320153944869-356032689.png)


### 2.3 文件夹的创建、重命名、删除
```
package com.legend.File;

import java.io.File;

public class FileFloderDemo {
    public static void main(String[] args){
        //在相对路径下面创建也就是当前工程 跟src同级
        File floder = new File("HelloFloder");

        //文件夹的多级目录创建
        //floder.mkdirs();

        if (floder.mkdir()){
            System.out.println("文件夹创建成功");
        }else{
            if(floder.exists()){
                System.out.println("文件夹已存在");
            }else {
                System.out.println("文件夹创建失败");
            }
        }

        //文件夹重命名
        //File f = new File("TestFloder");
        //floder.renameTo(f);

        //文件夹删除
        floder.delete();//一定是空文件夹
    }
}

```

### 2.4 文件属性的读取
```
package com.legend.File;

import java.io.File;
import java.io.IOException;

public class ReadFileProp {
    public static void main(String[] args){
        //在相对路径下面创建也就是当前工程 跟src同级
        File file = new File("new2.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取文件是否存在
        System.out.println(""+file.exists());

        //读取文件名
        System.out.println(""+file.getName());

        //读取文件路径
        System.out.println(""+file.getPath());

        //读取文件父级路径
        System.out.println(""+new File(file.getAbsolutePath()).getParent());

        //读取文件绝对路径
        System.out.println(""+file.getAbsolutePath());

        //判断文件是否被隐藏
        System.out.println(""+file.isHidden());

        //判断文件是否可读
        System.out.println(""+file.canRead());

        //判断文件是否可写
        System.out.println(""+file.canWrite());

        //读取文件大小(获取的是字节)
        System.out.println(""+(float)file.length()/1000+"KB");

        //判断是否为文件夹
        System.out.println(""+file.isDirectory());
    }
}

```


### 2.5 文件属性的设置
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320161532167-1390300344.png)


### 2.6 遍历文件夹
```
public static void scannerFile
{
        if (dir.isDirectory()){
            //当前路径的所有文件和文件夹
            File[] next = dir.listFiles();

            for(int i = 0; i < next.length; i++){
                for (int j = 0; j < tab; j++) {
                    System.out.print("|---");
                }
                System.out.println(next[i].getName());
                //如果是文件
                if (next[i].isDirectory()){
                    //文件夹继续循环
                    printFile(next[i],tab+1);
                }
            }
           /* for(int i = 0; i < next.length; i++){
                //如果是文件
                if (next[i].isFile()){
                    System.out.println(next[i].getName());
                }else{
                    //文件夹继续循环
                    printFile(next[i]);
                }
            }*/

        }
    }
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320164753767-138594024.png)

### 2.7 文件的简单读写
- 读取文件
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320165611808-211041949.png)

>创建一个File对象,在创建一个FileInputStream 对象，传入File对象，在创建一个FileInputReader 设置文件编码，最后设置一个字符流BufferReader

 
- 写入文件
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320165632673-917719961.png)

>创建一个文件输出流FileOutputStream，然后创建一个输出流，在创建一个缓冲流


## 3 Java中的IO操作
### 3.1 IO简介
```
IO也称作“I/O”，可理解为In和Out，即输入与输出。所以，IO体系的基本功能就是：读和写
```

- IO流
```
作用：
	读写设备上的数据，硬盘文件、内存、键盘、网络....

根据数据的走向：
	输入流、输出流

根据处理数据的类型：
	字节流、字符流
```

- 字符流与字节流
```
字节流
	可以处理所有类型的数据，如MP3、图片、文字。在读取时，读到一个字节就返回一个字节。
	在Java中对应的类都以"Stream"结尾 

字符流
	进能够处理纯文本数据，如txt文本等。在读取时，读到一个或多个字节，先查找指定的编码表，然后将查到的字符返回。
	在Java中对应的类都以“Reader”或“Writer”结尾
```

### 3.2 字符、字节与编码
- 字节
```
一个字节等于8位二进制，即一个8位二进制数，是一个很具体的存储空间。
```

- 字符
```
字符是人们使用的记号，抽象意义上的一个符号
```

- 编码
```
字符集也称作编码
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320172953298-578431783.png)


### 3.3 使用字节流读取数据
```
  FileInputStream fis = new FileInputStream("new2.txt");
            byte[] input = new byte[21];
            fis.read(input);
            String inputString = new String(input,"UTF-8");
            System.out.println(inputString);
```

### 3.4 使用带缓冲的字节流读写数据
```
{
        try {
            FileInputStream fis = new FileInputStream("new3.txt");

            FileOutputStream fos = new FileOutputStream("new3.txt");

            //缓冲字节流
            BufferedInputStream bis = new BufferedInputStream(fis);

            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] b = new byte[90];
            int count = 0;

            //从1970年到现在的时间的毫秒数
            long before = System.currentTimeMillis();

            while (bis.read(b)!=-1){
                bos.write(b);
                count++;
            }
            bis.close();
            fis.close();
            System.out.println(count+"次");
            System.out.println(System.currentTimeMillis()-before+"ms");

            //String str = new String(b,"UTF-8");
            //System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
```

### 3.5 使用字符流读写数据


### 3.6 使用ApacheIO操作IO与文件
```
package com.legend.File.TestApacheIO;

import org.apache.commons.io.FileUtils;

import java.io.File;

//使用ApacheIO操作IO
public class TestApacheIODemo {
    public static void main(String[] args){
        File file = new File("new4.txt");
        File newFile = new File("new5.txt");
        try {
            //将文件转为字符串
            String s = FileUtils.readFileToString(file, "UTF-8");
            System.out.println(s);

            //复制文件
            FileUtils.copyFile(file,newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

## 4.Java多线程编程
### 4.1 线程与进程
- 线程
```
程序中单独顺序的控制流
	线程本身依靠程序进行运行
	线程是程序中的顺序控制流,只能使用分配给程序的资源和环境
```

- 进程
```
执行中的程序；一个进程可以包含一个或多个线程；一个进程至少要包含一个线程
```

- 单线程
```
程序中只存在一个线程，实际上主方法就是一个主线程
```

- 多线程
```
多线程是在一个程序中运行多个任务

多线程的目的是更好的使用CPU和资源
```

### 4.2 线程的实现
- 在Java中，线程的是现有2种
```
继承Thread类

实现Runnable接口
```

- 继承Thread类
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320212800514-209399271.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320212823334-1916911539.png)


- 实现Runnable类
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320212848658-1835640414.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320213030878-1800173104.png)


![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320213121063-1893100328.png)


### 4.3 线程的状态
```
创建状态：准备好了一个多线程的对象

就绪状态：调用了start() 方法，等待CPU进行调度

运行状态：执行run方法

阻塞状态：暂时停止执行，可能将资源交给其他线程使用

终止状态：死亡状态：线程销毁
```

### 4.4 线程的常用方法
- 取得线程名称   getName()

- 取得当前线程对象  currentThread()
- 判断线程是否启动  isAlive()
- 线程的强行运行  join()
- 线程的休眠  sleep()
- 线程的礼让 yield()

### 4.5 线程的优先级
- 优先级顺序设置
```
1-MIN_PRIORITY

10-MAX_PRIORITY

5-NORM_PRIORITY


如果什么都不设置默认值是5
```

### 4.6 线程同步
- 同步代码块
```
在代码块上加上synchronize关键字，则此代码块称为同步代码块
```
- 格式
```
synchronize(同步对象){
	需要同步的代码块;
}

```
- 同步方法
```
除了代码块可以同步，方法也是可以同步的
```
- 方法同步格式

```
synchronize void 方法名称(){
}
```

### 4.7 线程生命周期
```
New(新生)，
Runnable(可运行)：为了方便分析，还可将其分为：Runnable与Running。
blocked(被阻塞)，
Dead(死亡)。
``` 
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321085100329-861723380.png)

