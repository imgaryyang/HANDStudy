## Java基础(深入了解概念为主)
### 匿名类

#### 定义
Java匿名类很像局部或内联系，只是没有明细。我们可以利用匿名类，同时定义并实例化一个类。只有局部类仅被使用一次时才应该这么做。

匿名类不能有显式定义的构造函数，相反，每一个匿名类都隐含定义了一个匿名构造函数

#### 创建匿名类
`理解代码的最好方法就是先阅读，所以我们首先来看看代码。`
- 扩展已有的类(可以是抽象类，也可以是具体类)

- 创建接口

```
interface Football {
    void kick();
}


class AnnonymousClass {
	public static Football football = new Football() {
        @Override
        public void kick() {
            System.out.println("Nested Anonymous Class.");
        }
    };
    public static void main(String[] args)
    {
        // anomynous class inside the method
      Football footballObject = new Football()
      {
          @Override
         public void kick()
          {
              System.out.println("Anonymous Class");
          }
      };
      footballObject.kick();

        AnnonymousClass.football.kick();
    } 
}
```

匿名类可以在类和函数代码块中中创建。匿名类可以用接口来创建，也可以通过扩展抽象或具体的类来创建。上面的例子中先创建了一个接口Football，然后在类的作用域和main()  方法内实现了匿名类。Football也可以是抽象类，也可以是与interface并列的顶层类。

`Football可以是抽象类，请看下面的代码。`
```
public abstract class Football { 
    abstract void kick();
}
```

`匿名类不仅可以是抽象类,还可以是具体类`

```
// normal or concrete class
public class Football {        
	public void kick(){}
}
// end of class scope.
```

如果Football类没有不带参数的构造方法怎么办？我们可以在匿名类中访问类变量吗？我们需要在匿名类中重载所有方法吗？

```
// normal or concrete class
public class Football {
    protected int score;

    public Football(int score) {
        this.score = score;
    }
    public void score(){
        System.out.println("Score "+score);
    };
    public void kick(){}
    public static void main(String[] args) {
        Football football = new Football(7){
            @Override
            public void score() {
                System.out.println("Anonymous class inside the method "+score);
            }

        };
        football.score();
    }
}
// end of class scope.
```

- 创建匿名类时可以使用任何构造方法。注意这里也使用构造方法的参数
- 匿名类可以扩展顶层类，并实现抽象类或接口。所以，访问控制的规则依然适用。我们可以访问protected变量，而改成private就不能访问了。
- 由于上述代码中扩展了Football类，我们需要重载所有的方法。但是，如果它是个抽象类或者接口，那么必须为所有未实现的方法提供实现。
- 匿名类中不能定义静态初始方法或成员接口。
- 匿名类可以有静态成员变量，但它们必须是常量


#### 匿名类的用途
- `更清晰的项目结构`：通常我们在需要随时改变某个类的某些方法的实现时使用匿名类。这样做就不需要在项目中添加新的 *.java 文件来定义顶层类了。特别是在顶层类之只被使用一次时，这种方法非常好用。
- `UI事件监听器`：在图形界面的应用程序中，匿名类最常见的用途就是创建各种事件处理器。


我们创建了一个匿名类，实现了setOnClickListener接口。当用户点击按钮时会触发它的onClick方法。
```
button.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        // your handler code here
    }
});
```

### 多线程

Java中的多线程能够同时执行多个线程。线程是轻量级的子进程，也是处理的最小单位。使用多线程的主要目的是最大化CPU的使用率。我们使用多线程而不是多进程，因为线程更轻量化，也可以共享一个进程内的内存空间。多线程用来实现多任务。

#### 多线程的生命周期
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191212103403377-1905945268.png)

如上图所示，线程的声明周期主要有5个状态。我们来依次解释每个状态。

- New：创建线程实例后，他会进入new 状态，这是第一个状态，但线程还没有准备好运行。
- Runnable：调用线程类的start()  方法，状态就会从new 变成 Runnable，意味着线程可以运行了，但实际上什么时候开始运行，取决于Java线程调度器，因为调度器可能在忙着执行其他线程。线程调度器会以FIFO  (先进先出) 的方式从线程池中挑选一个线程。
- Blocked：有很多情况会导致线程变成blocked状态，如等待I/O  操作、等待网络连接等。此外，优先级较高的线程可以将当前运行的线程变成blocked状态
- Waiting：线程可以调用wait()  进入waiting状态。当其他线程调用notify()  时，它将回到runnable状态。
- Terminated：start()  方法退出时，线程进入terminated状态。



### 为什么使用多线程?
使用多线程可以让Java 应用程序同时做多件事情，从而加快运行速度。用技术术语来说，线程可以帮你在Java程序中实现并行操作。由于现代CPU非常快，还可能包含多喝核心，因此仅有一个线程就没法使用所有的核心。


#### 需要记住的要点
- 多线程可以更好地利用CPU
- 提高响应，提高用户体验
- 减少响应时间
- 同时为多个客户端提供服务


#### 创建线程的方法主要有两种：
- 扩展Thread类
- 实现Runnable接口

##### 通过扩展Thread类来创建线程

通过一个类扩展Thread类。该类应当重载Thread类中的run()  方法。线程在run()  方法中开始生命周期。我们创建新类的对象，然后调用start() 方法开始执行线程。在Thread对象中，start()  会调用run()  

```
public class MultithreadingTest extends Thread
{
    public void run()
    {
        try{
            System.out.println("Thread "+Thread.currentThread().getName()+" is now running");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        for(int i=0;i<10;i++)
        {
            MultithreadingTest multithreadingTest = new MultithreadingTest();
            multithreadingTest.start();
        }
    }
}
```

也可以通过接口创建类。

下面的代码创建了一个类，实现java.lang.Runnable接口并重载了run()方法。然后我们实例化一个Thread对象，调用该对象的start()方法。


```
public class MultithreadingTest implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread "+Thread.currentThread().getName()+" is now running"); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            Thread thread = new Thread(new MultithreadingTest());
            thread.start();
        }
    }
}
```


#### Thread类与Runnable接口
- 扩展Thread类，就无法扩展更多的类，因为Java不允许多重继承。多重继承可以通过接口实现。所以最好是试用接口而不是THread类
- 如果扩展Thread类，那么它还包含了一些方法，如yield()   interrupt()  等，我们得程序可能用不到。而在Runnable接口中就没有这些派不上用场得方法。



### 同步
同步是指线程的同步。synchronize的代码块在同一时刻只能被一个线程执行。Java中的同步是个很重要的概念，因为Java是多线程语言，多个线程可以并行执行。在多线程环境中，Java对象的同步，或者说Java类的同步非常重要。


#### 为什么需要同步?
如果代码在多线程环境下执行，那么在多个线程中共享的对象之间需要同步，以避免破坏状态，或者造成任何不可预料的行为。

运行这段代码就会注意到，输出结果非常不稳定，因为没有同步。我们来看看程序的输出。
```
class Table {

   void printTable(int n) {//method not synchronized  
       for (int i = 1; i <= 5; i++) {
           System.out.print(n * i+" ");
           try {
               Thread.sleep(400);
           } catch (Exception e) {
               System.out.println(e);
           }
       }
    }
}


class MyThread1 extends Thread {
    Table t;
    MyThread1(Table t) {
        this.t = t;
    }
    public void run() {
        t.printTable(5);
    }

}


class MyThread2 extends Thread {
    Table t;
    MyThread2(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}


class TestSynchronization1 {
    public static void main(String args[]) {
        Table obj = new Table();//only one object  
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}
```

`输出：`
```
100 5 200 10 300 15 20 400 500 25
```


给printTable()方法加上synchronized，那么synchronized的方法在执行结束之前不会让其他线程进入。下面的输出结果就非常稳定了。 
```
class Table {
	//synchronized method 
    synchronized void printTable(int n) { 
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i+" ");
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}


class TestSynchronization3 {
   public static void main(String args[]) {
	   //only one object  
       final Table obj = new Table();
       Thread t1 = new Thread() {
           public void run() {
               obj.printTable(5);
           }
       };
       Thread t2 = new Thread() {
           public void run() {
               obj.printTable(100);
           }
       };

       t1.start();
       t2.start();
   }
}
```

`输出`
```
5 10 15 20 25 100 200 300 400 500 
```

>类似地，Java的类和对象也可以同步。 注意：我们并不一定需要同步整个方法。有时候最好是仅同步方法的一小部分。Java的synchronized代码段可以实现这一点。



### 序列化
Java中的序列化是一种机制，可以将对象的状态写入到字节流中。相反的操作叫做反序列化，将字节流转换成对象。


序列化和反序列化的过程是平台无关的，也就是说，在一个平台序列化对象，然后可以在另一个平台上反序列化。

序列化调用`ObjectOutputStream`的`writeObject()`方法，反序列化调用`ObjectInputStream`类的`readObject()`方法。


下图中，Java对象被转换成字节流，然后存储在各种形式的存储中，这个过程叫做反序列化。图右侧，内存中的字节流转换成Java对象，这个过程叫做反序列化。

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191212153821030-213317154.png)


#### 为什么要反序列化
显然，创建的Java类在程序执行结束或终止后，对象就销毁了。为了避免这个问题，Java系统了序列化功能，通过它可以将对象存储起来，或者将状态进行持久化，以便稍后使用，或者其他平台上使用。

```
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String serializeValueName;
    private transient int nonSerializeValueSalary;

    public String getSerializeValueName() {
        return serializeValueName;
    }
    public void setSerializeValueName(String serializeValueName) {
        this.serializeValueName = serializeValueName;
    }
    public int getNonSerializeValueSalary() {
        return nonSerializeValueSalary;
    }
    public void setNonSerializeValueSalary(int nonSerializeValueSalary) {
        this.nonSerializeValueSalary = nonSerializeValueSalary;
    }

    @Override
    public String toString() {
        return "Employee [serializeValueName=" + serializeValueName + "]";
    }
}
```


```
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializingObject {

    public static void main(String[] args) {

        Employee employeeOutput = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        employeeOutput = new Employee();
        employeeOutput.setSerializeValueName("Aman");
        employeeOutput.setNonSerializeValueSalary(50000);

        try {
            fos = new FileOutputStream("Employee.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(employeeOutput);

        System.out.println("Serialized data is saved in Employee.ser file");

        oos.close();
        fos.close();

        } catch (IOException e) {

            e.printStackTrace();
        } 
    }
}
```

`输出：`

```
Serialized data is saved in Employee.ser file.
```



```
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializingObject {

    public static void main(String[] args) {

        Employee employeeInput = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("Employee.ser");
            ois = new ObjectInputStream(fis);
            employeeInput = (Employee)ois.readObject();

            System.out.println("Serialized data is restored from Employee.ser file");

            ois.close();
            fis.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } 

        System.out.println("Name of employee is : " + employeeInput.getSerializeValueName());
        System.out.println("Salary of employee is : " + employeeInput.getNonSerializeValueSalary());
    }
}
```

`输出`
```
Serialized data is restored from Employee.ser file
Name of employee is : Aman
Salary of employee is : 0
```


#### 要记住的重点
- 如果父类实现了Serializable接口，那么子类就不需要实现了，但反过来不一定成立。
- 只有非静态数据成员可以在序列化过程中保存下来。
- 静态数据成员和临时数据成员不会再序列化过程中保存下来。所以，如果不想保存某个非静态数据成员，则可以将其设置为transient
- 反序列化过程中不会调用对象的构造函数
- 关联对象必须实现Serializable接口



### 总结
- 首先解释了匿名类，以及用途和使用方法
- 其次我们讨论了Java中对的多线程，线程的生命周期，以及用途。
- 同步只允许一个线程进入同步的方法或代码块去访问资源，其他线程必须在队列中等待
- 序列化就是存储对象状态供以后使用的过程