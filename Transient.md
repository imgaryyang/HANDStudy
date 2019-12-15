## Transient关键字

### 先解释下什么是序列化
我们的对象并不只是存在内存中，还需要传输网络，或者保存起来下次再加载出来用，所以需要Java序列化技术

Java序列化技术正是将对象转变成一串二进制字节组成的数组，可以通过将二进制数据保存到磁盘或者传输网络，磁盘或者网络接收者可以在对象的属性类的模板上来反序列化的对象，达到对象持久化的目的。

[关于Java序列化你应该知道的一切](https://mp.weixin.qq.com/s/wHmK1kKyne6gCkIxt0NERQ)这篇文章


### 什么是Traintent
简单来说就是，被Traintent 修饰的变量不能被反序列化。

`示例1：`
```
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 测试
 * 
 * @author legend
 */
public class TransientTest {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setUsername("Java");
        user.setId("javastack");

        System.out.println("\n序列化之前");
        System.out.println("username: " + user.getUsername());
        System.out.println("id: " + user.getId());

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:/test1.txt"));
        os.writeObject(user);
        os.flush();
        os.close();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/test2.txt"));
        user = (User) is.readObject();
        is.close();

        System.out.println("\n序列化之后");
        System.out.println("username: " + user.getUsername());
        System.out.println("id: " + user.getId());
    }
}



/**
 * 用户实体类
 * 
 * @author legend
 */
class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private transient String id;
	//getter/setter方法
}
```

`输出结果：`

```
序列化之前
username: Java
id: javastack

序列化之后
username: Java
id: null
```

>示例1在 id 字段上加了 transient 关键字修饰，反序列化出来之后值为 null，说明了被 transient 修饰的变量不能被序列化。



### 静态变量能被序列化吗？

`示例2：`
```
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author legend
 */
public class TransientStaticTest {

    public static void main(String[] args) throws Exception {

        User2 user = new User2();
        User2.username = "Java1";
        user.setId("javastack");

        System.out.println("\n序列化之前");
        System.out.println("username: " + user.getUsername());
        System.out.println("id: " + user.getId());

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:/test1.txt"));
        os.writeObject(user);
        os.flush();
        os.close();

        // 在反序列化出来之前，改变静态变量的值
        User2.username = "Java2";

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/test2.txt"));
        user = (User2) is.readObject();
        is.close();

        System.out.println("\n序列化之后");
        System.out.println("username: " + user.getUsername());
        System.out.println("id: " + user.getId());

    }
}

/**
 * 用户实体类
 * 
 * @author legend
 */
class User2 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static String username;
    private transient String id;
    //getter/setter方法
}
```

`输出结果：`

```
序列化之前
username: Java1
id: javastack

序列化之后
username: Java2
id: null
```

>示例2把 username 改为了 public static, 并在反序列化出来之前改变了静态变量的值，结果可以看出序列化之后的值并非序列化进去时的值。



>由以上结果分析可知，静态变量不能被序列化，示例2读取出来的是 username 在 JVM 内存中存储的值。



### transient 真不能被序列化吗？
`示例3：`
```
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author legend
 */
public class ExternalizableTest {
    public static void main(String[] args) throws Exception {

        User3 user = new User3();
        user.setUsername("Java");
        user.setId("javastack");
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(new File("javastack")));
        objectOutput.writeObject(user);

        ObjectInput objectInput = new ObjectInputStream(new FileInputStream(new File("javastack")));
        user = (User3) objectInput.readObject();

        System.out.println(user.getUsername());
        System.out.println(user.getId());

        objectOutput.close();
        objectInput.close();
    }

}

/**
 * @author legend
 */
class User3 implements Externalizable {
    private static final long serialVersionUID = 1L;
    public User3() {}

    private String username;
    private transient String id;
	//getter/setter方法
    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(id);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        id = (String) objectInput.readObject();
    }

}
```

`输出结果：`
```
null
javastack
```

>示例3的 id 被 transient 修改了，为什么还能序列化出来？那是因为 User3 实现了接口 Externalizable，而不是 Serializable。


>在Java中有两种实现序列化的方式，Serializable和Externalizable，可能大部分人只知道Serializable而不知道Externalizable。


#### 两种序列化方式的区别

```
实现了 Serializable 接口是自动序列化的，实现 Externalizable 则需要手动序列化，通过 writeExternal 和 readExternal 方法手动进行，这也是为什么上面的 username 为 null 的原因了。
```


### transient 关键字总结
- 1）transient修饰的变量不能被序列化
- 2）transient只作用于实现 Serializable 接口
- 3）transient只能用来修饰普通成员变量字段
- 4）不管有没有 transient 修饰，静态变量都不能被序列化；