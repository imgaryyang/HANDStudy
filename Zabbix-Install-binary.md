## 安装Zabbix 分布式监控

### 基于二进制安装Zabbix
- centos 7 添加阿里云镜像

```
wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo
```

- yum install epel-release

- 安装常用的开发组件
```
yum  groups install "Development Tools"
yum groups info  "Development Tools"
```

- 增加Zabbix镜像源

```
rpm -ivh https://repo.zabbix.com/zabbix/4.0/rhel/7/x86_64/zabbix-release-4.0-1.el7.noarch.rpm
```


- 关闭SElinux

```
systemctl stop firewalld.service
systemctl disable  firewalld.service

vim /etc/selinux/config

yum install iptables-services
```


- 安装Zabbix Server和Frontend

```
yum install zabbix-server-mysql
yum install zabbix-web-mysql
```

- 安装MySQL
```
yum install mariadb-server
systemctl  start mariadb.service
systemctl  status mariadb.service
mysql_secure_installation
```

- 创建数据库
```
mysql -u root -p
create database zabbix character set utf8 collate utf8_bin;
grant all privileges on zabbix.* to zabbix@localhost identified by 'zabbix@123';
```

- 导入数据结构

```
zcat /usr/share/doc/zabbix-server-mysql*/create.sql.gz | mysql -uzabbix -pzabbix@123  zabbix
```

- 配置Zabbix Serve
```
vim /etc/zabbix/zabbix_server.conf
```

- 启动Zabbix Server

```
systemctl  start zabbix-server.service
systemctl  status zabbix-server.service

more /var/log/zabbix/zabbix_server.log
```


- 配置Zabbix frontend
```
vim /etc/php.ini

max_execution_time = 300
memory_limit = 128M
post_max_size = 16M
upload_max_filesize = 2M
max_input_time = 300
max_input_vars = 10000
always_populate_raw_post_data = -1
date.timezone = Asia/Shanghai
```

- 启动httpd
```
systemctl  start  httpd.service
systemctl  status  httpd.service
```

`http://你的IP/zabbix/setup.php`

```
Admin
zabbix
```


- 安装Zabbix Agent
```
yum install zabbix-agent

systemctl  start zabbix-agent.service
```

