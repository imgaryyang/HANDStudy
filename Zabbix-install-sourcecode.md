## 安装Zabbix 分布式监控

### Zabbix源码安装  (P7)
- 检查Centos的版本
```
cat /etc/redhat-release
```
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216124534326-69491529.png)


#### Zabbix Server源码包安装

- Zabbix Server安装
```
wget -O zabbix-4.0.17.tar.gz https://sourceforge.net/projects/zabbix/files/ZABBIX%20Latest%20Stable/4.0.17/zabbix-4.0.17.tar.gz/download


//安装依赖
yum install wget telnet net-tools python-paramiko gcc gcc-c++ dejavu-sans-fonts python-setuptools python-devel sendmail mailx net-snmp net-snmp-devel net-snmp-utils freetype-devel libpng-devel perl unbound libtasn1-devel p11-kit-devel OpenIPMI unixODBC  libevent-devel  mysql-devel  libxml2-devel  libssh2-devel  OpenIPMI-devel  java-1.8.0-openjdk-devel  openldap-devel  curl-devel unixODBC-devel

//解压并编译安装
tar -zxvf zabbix-4.0.17.tar.gz
cd  zabbix-4.0.17/


//建立编译安装目录
mkdir -p /data/legend/zabbix

./configure --prefix=/data/legend/zabbix  --enable-server  --enable-agent --enable-java  --with-mysql --with-libxml2 --with-unixodbc  --with-net-snmp --with-ssh2 --with-openipmi --with-ldap --with-libcurl --with-iconv

make

make install

yum intall tree

/data/legend/zabbix/sbin/zabbix_server  -V
显示zabbix版本即成功
```


- 数据库安装 (跟第一种方式一样二进制安装)
```
yum install mariadb-server
systemctl start mariadb.service
systemctl status mariadb.service
mysql_secure_installation

创建数据库
mysql -uroot -p
create database zabbix character set utf8 collate utf8_bin;
grant all privileges on zabbix.* to zabbix@localhost identified by 'zabbix@123';

导入数据结构
mysql -uzabbix -pzabbix@123  zabbix < /root/zabbix-4.0.17/database/mysql/schema.sql 
mysql -uzabbix -pzabbix@123  zabbix < /root/zabbix-4.0.17/database/mysql/images.sql
mysql -uzabbix -pzabbix@123  zabbix < /root/zabbix-4.0.17/database/mysql/data.sql 
```

- 修改zabbix server配置
```
vim /data/legend/zabbix/etc/zabbix_server.conf
/DB--->DBHost=localhost
	   DBName=zabbix
	   DBUser=zabbix
	   DBPassword=zabbix@123

增加用户
groupadd --system zabbix
useradd --system -g zabbix -d /usr/lib/zabbix -s /sbin/nologin -c "Zabbix Monitoring System" zabbix

启动服务
/data/legend/zabbix/sbin/zabbix_server -c /data/legend/zabbix/etc/zabbix_server.conf

tailf /tmp/zabbix_server.log
```

- 安装Zabbix Agent
```
yum install zabbix-agent

systemctl  start zabbix-agent.service
```

- 增加Zabbix镜像源
```
rpm -ivh https://repo.zabbix.com/zabbix/4.0/rhel/7/x86_64/zabbix-release-4.0-1.el7.noarch.rpm
```

- 安装Zabbix Frontend前端
```
yum install zabbix-web-mysql
```

- 配置Zabbix frontend
```
vim /etc/php.ini

修改的配置
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
systemctl start httpd.service
systemctl status httpd.service

http://你的IP/zabbix/

登录Zabbix网站
Admin
zabbix
```