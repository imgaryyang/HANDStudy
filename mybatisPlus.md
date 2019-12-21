## MyBatis-plus的使用

我们的项目都是基于SSM，虽然mybatis可以直接在xml中通过SQL语句操作数据库操作都要通过SQL语句进行，就必须写大量的xml文件，mybatis-plus就很好的解决了这个问题。


### 一、mybatis-plus简介：
Mybatis-Plus（简称MP）是一个Mybaits 的基础上只做增强不做改变，为简化开发，提高效率而生。那么它是怎么增强的呢？其实就是它已经封装好了一些crud方法，我们不需要再写xml了，直接调用这些方法就行，就类似于JPA。



### spring整合mybatis-plus:
mybatis-plus框架只是在mybatis框架的基础上只做增强没有做改变，因此其与spring的整合也是非常简单。只需把mybatis的依赖换成mybatis-plus的依赖，再把sqlSessionFactory换成mybatis-plus的即可。看具体操作：

#### pom.xml 文件配置
```xml
<!-- mybatisplus 依赖 -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus</artifactId>
    <version>2.3</version>
</dependency>
```


#### log4j.xml
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
    <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
        <param name="Encoding" value="UTF-8" />
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%-5p %d{MM-dd
HH:mm:ss,SSS} %m (%F:%L) \n" />
        </layout>
    </appender>
    <logger name="java.sql">
        <level value="debug" />
    </logger>
    <logger name="org.apache.ibatis">
        <level value="info" />
    </logger>
    <root>
        <level value="debug" />
        <appender-ref ref="STDOUT" />
    </root>
</log4j:configuration>
```

#### entity实体

```
@Data
@TableName(value = "tb_employee")//指定表名
public class Employee {
    //value与数据库主键列名一致，若实体类属性名与表主键列名一致可省略value
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Integer id;
    //若没有开启驼峰命名，或者表中列名不符合驼峰规则，可通过该注解指定数据库表中的列名，exist标明数据表中有没有对应列
    @TableField(value = "last_name",exist = true)
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;
}
```

#### jdbc.properties:
```
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql:///数据库名?useUnicode=true&characterEncoding=utf8
jdbc.username=#
jdbc.password=#
```

#### mybatis-config.xml:
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
</configuration>
```

>注：因为是与spring整合，所有mybatis-plus的大部分都写在spring的配置文件中，这里定义一个空的mybatis-config.xml即可。


#### spring-dao.xml
```
<?xml version="1.0" encoding="UTF-8"?>    
<beans xmlns="http://www.springframework.org/schema/beans"    
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"   
    xmlns:p="http://www.springframework.org/schema/p"  
    xmlns:aop="http://www.springframework.org/schema/aop"   
    xmlns:context="http://www.springframework.org/schema/context"  
    xmlns:jee="http://www.springframework.org/schema/jee"  
    xmlns:tx="http://www.springframework.org/schema/tx"  
    xsi:schemaLocation="    
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.0.xsd  
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd  
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd  
        http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee-4.0.xsd  
        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.0.xsd">    
        
    <!-- 配置整合mybatis-plus过程 -->
    <!-- 1、配置数据库相关参数properties的属性：${url} -->
    <context:property-placeholder location="classpath:jdbc.properties" />
    <!-- 2、配置数据库连接池 -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}"/>
        <property name="jdbcUrl" value="${jdbc.url}"/>
        <property name="user" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
    <!-- mybatis的sqlsessionFactorybean：org.mybatis.spring.SqlSessionFactoryBean-->
    <!-- 3、配置mybatis-plus的sqlSessionFactory -->
    <bean id="sqlSessionFactory" class="com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <property name="typeAliasesPackage" value="com.zhu.mybatisplus.entity"/>
    </bean>
    <!-- 4、DAO接口所在包名，Spring会自动查找其下的类 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.zhu.mybatisplus.dao" />
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    </bean> 
</beans>
```


#### mapper

```
public interface EmplopyeeDao extends BaseMapper<Employee> {
}
```

>这样到这里就完成了mybatis-plus与spring框架的整合。总结来说:首先是把mybatis和mybatis-spring依赖换成mybatis-plus的依赖，然后把sqlsessionfactory换成mybatis-plus的，然后实体类中添加@TableName、@TableId等注解，最后mapper继承BaseMapper即可。



#### 测试
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class test {
    @Autowired
    private DataSource dataSource;
    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
```


### 三、mp的通用crud:
#### 需求：
存在一张 tb_employee 表，且已有对应的实体类 Employee，实现tb_employee 表的 CRUD 操作我们需要做什么呢？

#### 基于 Mybatis：
需要编写 EmployeeMapper 接口，并在 EmployeeMapper.xml 映射文件中手动编写 CRUD 方法对应的sql语句。


#### 基于 MP：
只需要创建 EmployeeMapper 接口, 并继承 BaseMapper 接口。
我们已经有了Employee、tb_employee了，并且EmployeeDao也继承了BaseMapper了，接下来就使用crud方法。


`1、insert操作：`
执行添加操作，直接调用insert方法传入实体即可。
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class test {
    @Autowired
    private EmplopyeeDao emplopyeeDao;
    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setLastName("东方不败");
        employee.setEmail("dfbb@163.com");
        employee.setGender(1);
        employee.setAge(20);
        emplopyeeDao.insert(employee);
        //mybatisplus会自动把当前插入对象在数据库中的id写回到该实体中
        System.out.println(employee.getId());
    }
}
```


`2、update操作：`
```
@Test
public void testUpdate(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("更新测试");
        //emplopyeeDao.updateById(employee);//根据id进行更新，没有传值的属性就不会更新
        emplopyeeDao.updateAllColumnById(employee);//根据id进行更新，没传值的属性就更新为null
}
```

>注意：这两个update操作的区别，updateById 方法，没有传值的字段不会进行更新，比如只传入lastName那么age、gender 等属性就会保留原来的值；updateAllColumnById 方法会更新所有的列，没有传值的列会更新为null


`3、select操作：`

(1)、根据id查询：
```
Employee employee = emplopyeeDao.selectById(1);
```

(2)、根据条件查询一条数据：
```
Employee employeeCondition = new Employee();
employeeCondition.setId(1);
employeeCondition.setLastName("更新测试");
//若是数据库中符合传入的条件的记录有多条，那就不能用这个方法，会报错
Employee employee = emplopyeeDao.selectOne(employeeCondition);
```

>注：这个方法的sql语句就是 where id = 1 and last_name = 更新测试   若是符合这个条件的记录不止一条。那么就会报错

(3)、根据查询条件返回多条数据：
当符合指定条件的记录数有多条时，上面那个方法就会报错，就应该用这个方法。

```
Map<String,Object> columnMap = new HashMap<>();
columnMap.put("last_name","东方不败");//写表中的列名
columnMap.put("gender","1");
List<Employee> employees = emplopyeeDao.selectByMap(columnMap);
System.out.println(employees.size());
```

>注：查询条件用map集合封装 columnMap，写的是数据表中的列名，而非实体类的属性名。比如属性名为lastName，数据表中字段为last_name，这里应该写的是last_name。selectByMap方法返回值用list集合接收。


(4)、通过id批量查询：
```
List<Integer> idList = new ArrayList<>();
idList.add(1);
idList.add(2);
idList.add(3);
List<Employee> employees = emplopyeeDao.selectBatchIds(idList);
System.out.println(employees);
```

>注：把需要查询的id都add到list集合中，然后调用selectBatchIds方法，传入该list集合即可，该方法返回的是对应id的所有记录，所有返回值也是用list接收。

(5)、分页查询：
```
List<Employee> employees = emplopyeeDao.selectPage(new Page<>(1,2),null);
System.out.println(employees);
```

>注：selectPage方法就是分页查询，在page中传入分页信息，后者为null的分页条件，这里先让其为null，讲了条件构造器再说其用法。这个分页其实并不是物理分页，而是内存分页。也就是说，查询的时候并没有limit语句。等配置了分页插件后才可以实现真正的分页。


4、delete操作：

- (1)、根据id删除：
```
emplopyeeDao.deleteById(1);
```


- (2)、根据条件删除：
```
Map<String,Object> columnMap = new HashMap<>();
columnMap.put("gender",0);
columnMap.put("age",18);
emplopyeeDao.deleteByMap(columnMap);
```

>注：该方法与selectByMap类似，将条件封装在columnMap中，然后调用deleteByMap方法，传入columnMap即可，返回值是Integer类型，表示影响的行数。