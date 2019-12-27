## 怎么快速插入 100 条数据，用时最短

### 多线程插入(单表)

问：为何对同一个表的插入多线程会比单线程快？同一时间对一个表的写操作不应该是独占的吗？

答：在数据里做插入操作的时候，整体时间的分配是这样的：
- 链接耗时 (30%)
- 发送query到服务器 (20%)
- 解析query(20%)
- 插入操作(10% * 词条数目)
- 插入index (10% * index的数目)
- 关闭链接(10%)

>从这里可以看出，真正耗时的 不是操作而是链接，解析的过程。

MySQL 插入数据在写阶段是独占的，但是插入一条数据仍然需要解析、计算、最后才进行写处理，比如要给每一条记录分配自增id，校验主键唯一键属性，或者其他一些逻辑处理，都是需要计算的，所以多线程能过够提高效率。



### 多线程插入(多表)
分区分表后使用多线程插入

### 预处理SQL
- 普通SQL，即使用Statement 接口执行SQL
- 预处理SQL，即使用PreparedStatement 接口执行SQL

使用PreparedStatement 接口允许数据库预编译SQL语句，以后只需传入参数，避免了数据库每次都编译SQL语句，因此性能更好。

```
String sql = "insert into testdb.tuser (name, remark, createtime, updatetime) values (?, ?, ?, ?)";
for (int i = 0; i < m; i++) {
    //从池中获取连接
    Connection conn = myBroker.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(sql);
    for (int k = 0; k < n; k++) {
            pstmt.setString(1, RandomToolkit.generateString(12));
            pstmt.setString(2, RandomToolkit.generateString(24));
            pstmt.setDate(3, new Date(System.currentTimeMillis()));
            pstmt.setDate(4, new Date(System.currentTimeMillis()));
            //加入批处理
            pstmt.addBatch();
    }
    pstmt.executeBatch();    //执行批处理
    pstmt.close();
    myBroker.freeConnection(conn); //连接归池
}
```


### 多值插入SQL
- 普通插入SQL：INSERT INTO TBL_TEST(id) VALUES (1)
- 多值插入SQL：INSERT INTO TBL_TEST(id) VALUES (1), (2),(3)

>使用多值插入SQL，SQL语句的总长度减少了，既减少了网络IO，同事也降低了连接次数，数据库一次SQL解析，能够插入多条数据。

### 事务(N条提交一次)
在一个事务中提交大量INSERT 语句可以提高性能。

- 将表的存储引擎修改为InnoDB
- 将SQL拼接成字符串，每1000 条左右提交事务

```
public void ExecuteSqlTran(List<string> SQLStringList) {
    using (MySqlConnection conn = new MySqlConnection(connectionString))
    {
        if (DBVariable.flag)
        {
            conn.Open();
            MySqlCommand cmd = new MySqlCommand();
            cmd.Connection = conn;
            MySqlTransaction tx = conn.BeginTransaction();
            cmd.Transaction = tx;
            try
            {
                for (int n = 0; n < SQLStringList.Count; n++)
                {
                    string strsql = SQLStringList[n].ToString();
                    if (strsql.Trim().Length > 1)
                    {
                        cmd.CommandText = strsql;
                        cmd.ExecuteNonQuery();
                    }
                    //后来加上的
                    if (n > 0 && (n % 1000 == 0 || n == SQLStringList.Count - 1))
                    {
                        tx.Commit();
                        tx = conn.BeginTransaction();
                    }
                }
                //tx.Commit();//原来一次性提交
            }
            catch (System.Data.SqlClient.SqlException E)
            {
                tx.Rollback();
                throw new Exception(E.Message);
            }
        }
    }
}
```

>10w条数据大概用时10s！