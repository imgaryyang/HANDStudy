## Centos7安装Zabbix 分布式监控

### Zabbix二进制安装  (P6)

#### 资源要求
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216113620595-555183088.png)

#### 依赖关系-Frontend
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216113706841-1403288527.png)

#### 依赖关系-Server
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216113746201-1579336265.png)


#### 环境准备
```
Virtualbox

CentosOS7.7
```


#### 开始安装配置Zabbix
- centos 7 添加阿里云镜像

```
wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo
```

- 安装epel基础包
```
yum install epel-release
```

- 安装常用的开发组件
```
yum groups install "Development Tools"

yum groups info  "Development Tools"
```

- 安装Zabbix镜像源

```
(4.0)
rpm -ivh https://repo.zabbix.com/zabbix/4.0/rhel/7/x86_64/zabbix-release-4.0-1.el7.noarch.rpm

or

(4.5)
rpm -ivh
https://repo.zabbix.com/zabbix/4.5/rhel/8/x86_64/zabbix-release-4.5-1.el8.noarch.rpm
```


- 关闭防火墙SElinux

```
systemctl stop firewalld.service
systemctl disable  firewalld.service

vim /etc/selinux/config
	将改为SELINUX=disabled

reboot
```


- 安装Zabbix Server和Web相关Frontend

```
yum install zabbix-server-mysql

yum install zabbix-web-mysql
```

`报错`
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200208113534777-1310985681.png)

`执行`
```
yum install curl
```

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200208114425302-451999723.png)


- 安装MySQL
```
yum install mariadb-server

systemctl  start mariadb.service

systemctl  status mariadb.service

ps aux|grep mysql

mysql_secure_installation --初始化
	n
	Y
	n
	Y
	Y
```


- 创建数据库
```
mysql -u root -p

create database zabbix character set utf8 collate  utf8_bin;

show databases;

grant all privileges on zabbix.* to zabbix@localhost identified by 'zabbix@123';

flush privilieges;
```

- 导入Zabbix数据结构

```
zcat /usr/share/doc/zabbix-server-mysql*/create.sql.gz | mysql -uzabbix -pzabbix@123  zabbix
```

- 配置Zabbix Serve
```
vim /etc/zabbix/zabbix_server.conf
/DB--->DBHost=localhost
	   DBName=zabbix
	   DBUser=zabbix
	   DBPassword=zabbix@123
```

- 启动Zabbix Server

```
systemctl start zabbix-server.service

systemctl status zabbix-server.service

more /var/log/zabbix/zabbix_server.log
```


- 配置Zabbix frontend 前端
```
vim /etc/php.ini

参数修改如下:
	max_execution_time = 300
	memory_limit = 128M
	post_max_size = 16M
	upload_max_filesize = 2M
	max_input_time = 300
	max_input_vars = 10000
	always_populate_raw_post_data = -1
	date.timezone = Asia/Shanghai
```

- 启动httpd服务
```
systemctl start httpd.service
systemctl status httpd.service
```

`http://你的IP/zabbix/`

```
需要在页面初始化配置zabbix

账户:Admin
密码:zabbix
```
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216120146264-462675511.png)

>需要和Zabbix Agent里面的hostname一致

- 安装Zabbix Agent
```
yum install zabbix-agent

vim /etc/zabbix/zabbix-agentd.conf
	Hostname=Zabbix server

systemctl start zabbix-agent

systemctl status zabbix-agent
```

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216123839940-826749758.png)


- 最新监控数据
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216124040107-183102026.png)