## 数据库连接池原理
### 一、早期我们怎么进行数据库操作
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191203144232410-1775671333.png)


#### 原理
一般来说，Java应用程序访问数据库的过程是:
- 装载数据驱动程序
- 通过jdbc建立连接
- 访问数据库，执行sql语句
- 断开数据库的连接

#### 代码
```java
//查询所有用户
public void findAllUsers() {
    try {
        //1.使用连接池建立数据库连接
        TestDataSource dataSource = new TestDataSource();
        Connection conn = dataSource.getConnection();
        //2.创建状态
        Statement state = conn.createStatement();
        //3.查询数据库并返回结果
        ResultSet result = state.executeQuery("select * from users");
        //4.输出查询结果
        while (result.next()) {
            System.out.println(result.getString("email"));
        }
        //5.断开数据库连接
        result.close();
        state.close();
        //6.归还数据库连接给连接池
        dataSource.releaseConnection(conn);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```


#### 分析
程序开发过程中，存在很多问题：首先，每一次web请求都要建立一次数据库连接。建立连接是一个费时的活动，每次都得花费0..05s~1s 的时间，而且系统还要分配内存资源。这个时间对于一次或几次数据库操作，获取感觉不出系统有多大的开销。可是对于现在的web应用，尤其是大型电子商务网站，同时有几百人甚至几千人在线是很正常的事。在这种情况下，频繁的进行数据库连接操作势必占用很多的系统资源，网站的响应速度必定下降，严重的甚至会造成服务器的崩溃。其次，对于每一次数据库连接，使用完后都得断开。否则，如果程序出现异常而未能关闭，将会导致数据库系统中的内存泄漏，最终将不得不重启数据库。还有，这种开发不能控制被创建的连接对象数，系统资源会被毫无顾及的分配出去，如连接过多，也可能导致内存泄漏，服务器崩溃。



上述的用户查询案例，如果同时有1000人访问，就会不断的有数据库连接、断开操作：
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191203145134799-822890560.png)

通过上面的分析，我们可以看出来，“数据库连接”是一种稀缺的资源，为了保障网站的正常使用，应该对其进行妥善管理。其实我们查询完数据库后，如果不关闭连接，而是暂时存放起来，当别人使用时，把这个连接给他们使用。就避免了一次建立数据库连接和断开的操作时间消耗。原理如下：
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191203145229345-1713917490.png)


### 二、技术演进出来的数据库连接池
由上面的分析可以看出，问题的根源就在于对数据库连接资源的低效管理。我么知道，对于共享资源，有一个很著名的设计模式：资源池(resource pool) 该模式正式为了解决资源的频繁调配、释放所造成的问题。为了解决这个问题，可以采用数据库连接池技术。数据库连接池的基本思想就是为数据库连接建立一个“缓冲池”。预先在缓冲池中放入一定数量的连接，当需要建立连接数据库时，只需从“缓冲池”中取出一个，使用完毕之后在放回去。我们可以通过设定连接池最大连接数来防止系统无尽的与数据库连接。更为重要的是我们可以通过连接池的管理机制监控数据库的连接的数量、使用情况，为系统开发、测试及性能调整提供依据。

**开发一个连接池，来为上面的查询业务提供数据库连接服务：**

- 编写class 实现DataSource 接口
- 在class 构造器一次性创建10个连接，将连接保存LinkedList中
- 实现getConnection从LinkedList中返回一个连接
- 提供将连接放回连接池中的方法


`连接池代码`
```java
package com.legend.springcache.datasource;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * 数据库连接池原理分析
 * @author legend
 */
public class TestDataSource implements DataSource {
    /**
     * 链表--实现栈结构
     */
    private LinkedList<Connection> dataSources = new LinkedList<>();

    /**
     * 初始化连接数量
     */
    public TestDataSource() {
        for (int i = 0; i < 10; i++) {
            try {
                //1、装载sqlserver驱动对象
                DriverManager.registerDriver(new SQLServerDriver());
                //2、通过JDBC建立数据库连接
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=customer", "sa", "123");
                //3、将连接加入连接池中
                dataSources.add(con);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public Connection getConnection() throws SQLException {
        // 删除第一个连接返回
        final Connection conn = dataSources.removeFirst();
        return conn;
    }


    /**
     * 将连接放回连接池
     *
     * @param conn
     */
    public void releaseConnection(Connection conn) {
        dataSources.add(conn);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }
}

```


`使用连接池重构用户查询函数`
```
/**
 * 使用连接池重构用户查询函数
 */
public void findAllUsers() {
    try {
        //1.使用连接池建立数据库连接
        TestDataSource dataSource = new TestDataSource();
        Connection conn = dataSource.getConnection();
        //2.创建状态
        Statement state = conn.createStatement();
        //3.查询数据库并返回结果
        ResultSet result = state.executeQuery("select * from users");
        //4.输出查询结果
        while (result.next()) {
            System.out.println(result.getString("email"));
        }
        //5.断开数据库连接
        result.close();
        state.close();
        //6.归还数据库连接给连接池
        dataSource.releaseConnection(conn);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```

>这就是数据库连接池的原理，他大大提供了数据库连接的利用率，减少了内存吞吐的开销。我们在开发中，就不需要关心数据库连接的问题，自然有数据库连接池帮我们处理。



### 连接池还要考虑更多的问题
#### 并发问题
为了使连接管理服务具有更大的通用性，必须考虑多线程环境,即并发问题。这个问题相对比较好解决，因为Java语言自身提供了对并发管理的支持，使用synchronized关键字即可确保线程是同步的。使用方法为直接在类方法前面加上synchronized 关键字，
```
public synchronized connection getConnection()
```


#### 多数据库服务器和多用户
设计一个符合单例模式的连接池管理类，在连接池管理类的唯一实例被创建时读取一个资源文件，其中资源文件中存放着多个数据库的url地址等信息。根据资源文件提供的信息，创建多个连接池类的实例

