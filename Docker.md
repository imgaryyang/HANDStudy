# Docker学习
## Docker安装
### 1.安装linux虚拟机
```
(1)VirtualBox(安装);

?(2)导入虚拟机文件centos7.ova;

(3)双击启动linux虚拟机;使用  root/ 123456登陆

(4)使用客户端连接linux服务器进行命令操作;

(5)设置虚拟机网络；
	桥接网络===选好网卡====接入网线;
	
?(6)设置好网络以后使用命令重启虚拟机的网络
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523104350816-1068396581.png)

`一定要记住`
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523104429489-1836106480.png)


```shell
在虚拟机里面输入  重启网络
	service network restart
```

```
(7)查看linux的ip地址
```
```shell
ip addr
```
```
(8)使用客户端连接linux;(SmartTTY)
```

### 2.在linux虚拟机上安装docker
####步骤：
```shell
1、检查内核版本，必须是3.10及以上
uname -r

2、安装docker
yum install docker

3、输入y确认安装

4、启动docker
[root@localhost ~]# systemctl start docker
[root@localhost ~]# docker -v
Docker version 1.12.6, build 3e8e77d/1.12.6

5、开机启动docker
[root@localhost ~]# systemctl enable docker
Created symlink from /etc/systemd/system/multi-user.target.wants/docker.service to /usr/lib/systemd/system/docker.service.

6、停止docker
systemctl stop docker

```

![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523105010489-1219638194.png)


### 3.Docker常用命令&操作
#### 3.1镜像操作

| 操作 | 命令                                            | 说明                                                     |
| ---- | ----------------------------------------------- | -------------------------------------------------------- |
| 检索 | docker  search 关键字  eg：docker  search redis | 我们经常去docker  hub上检索镜像的详细信息，如镜像的TAG。 |
| 拉取 | docker pull 镜像名:tag                          | :tag是可选的，tag表示标签，多为软件的版本，默认是latest  |
| 列表 | docker images                                   | 查看所有本地镜像                                         |
| 删除 | docker rmi image-id                             | 删除指定的本地镜像                                       |

官方地址: https://hub.docker.com/

#### 3.2 解决出现无法删除镜像名的错误
```
Error response from daemon: conflict: unable to delete 7faa3c53e6d6 (must be forced) - image is referenced in multip
le repositories
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523111153515-1377335624.png)


```powershell
使用仓库名后面接镜像名和版本号
	docker rmi daocloud.io/library/mysql:5.7
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523111521219-1682640956.png)



#### 3.3 解决 docker pull 镜像名   timeout问题
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523105532527-26730381.png)

- 修改配置文件
```
vi /etc/docker/daemon.json

添加一句,修改国内镜像源
	"registry-mirrors": ["https://registry.docker-cn.com"]
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523105715699-1336419892.png)

- 重启docker容器
```
#重启docker
systemctl daemon-reload 
systemctl restart docker
```

- 下载一个工具
```
yum install bind-utils
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523110157958-642286777.png)

```
输入
	dig @114.114.114.114 registry-1.docker.io
	
获取docker景象地址	
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523110602188-1470752469.png)

- 修改host文件
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523110933424-1459599138.png)

- 下载超级快
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523111053100-403999833.png)


#### 3.4 容器操作

软件镜像（QQ安装程序）----运行镜像----产生一个容器（正在运行的软件，运行的QQ）；

步骤：

```shell
1、搜索镜像
[root@localhost ~]# docker search tomcat

2、拉取镜像
[root@localhost ~]# docker pull tomcat

3、根据镜像启动容器
docker run --name mytomcat -d tomcat:latest

4、docker ps  
查看运行中的容器

5、 停止运行中的容器
docker stop  容器的id

6、查看所有的容器
docker ps -a

7、启动容器
docker start 容器id

8、删除一个容器
 docker rm 容器id
 
9、启动一个做了端口映射的tomcat
[root@localhost ~]# docker run -d -p 8888:8080 tomcat
-d：后台运行
-p: 将主机的端口映射到容器的一个端口    主机端口:容器内部的端口

10、为了演示简单关闭了linux的防火墙
service firewalld status ；查看防火墙状态
service firewalld stop：关闭防火墙

11、查看容器的日志
docker logs container-name/container-id

更多命令参看
https://docs.docker.com/engine/reference/commandline/docker/
可以参考每一个镜像的文档

```

- 查看运行中的容器
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523111808301-1627231075.png)

- 停止容器(根据id)
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523112017822-409486421.png)

- 查看所有容器
```
docker ps -a
```


- 启动容器id
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523112222903-381833387.png)

- 启动端口映射
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523112616774-1319441207.png)

![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523112913335-1673027465.png)


#### 3.5 删除docker容器
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523104902455-562303640.png)


### 4.安装MySQL示例

```shell
docker pull mysql
```

错误的启动

```shell
[root@localhost ~]# docker run --name mysql01 -d mysql:5.7
8b1f452f0b130b02bbf5b12d5f8d191465573a50faa8b74f3d4f81d394b82134

mysql退出了
[root@localhost ~]# docker ps -a
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS                         
  PORTS                    NAMES
8b1f452f0b13        mysql:5.7           "docker-entrypoint..."   25 seconds ago      Exited (1) 24 seconds ago      
                           mysql01
e908725242a3        tomcat:8.5          "catalina.sh run"        57 minutes ago      Up 57 minutes                  
  0.0.0.0:8888->8080/tcp   distracted_jang
5afeda03fcf4        tomcat:8.5          "catalina.sh run"        About an hour ago   Exited (143) About an hour ago 
                           mytomcat


//错误日志
[root@localhost ~]# docker logs 8b1f452f0b13
error: database is uninitialized and password option is not specified 
  You need to specify one of MYSQL_ROOT_PASSWORD, MYSQL_ALLOW_EMPTY_PASSWORD and MYSQL_RANDOM_ROOT_PASSWORD;  
  #这个三个参数必须指定一个
```


正确的启动
```shell
[root@localhost ~]# docker run --name mysql01 -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7
f65346f521200651c058c54cce0d322ec972ff31651c1e2330aee89229187362
[root@localhost ~]# docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS      
              NAMES
f65346f52120        mysql:5.7           "docker-entrypoint..."   9 seconds ago       Up 9 seconds        3306/tcp, 3
3060/tcp      mysql01
e908725242a3        tomcat:8.5          "catalina.sh run"        About an hour ago   Up About an hour    0.0.0.0:888
8->8080/tcp   distracted_jang
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523123846448-1806503499.png)



做了端口映射

```shell
[root@localhost ~]# docker run -p 3306:3306 --name mysql02 -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7
8d214bfb45bc4358e5a5e981860f60091861d0b44142697c9f336d3fbac74c6a
[root@localhost ~]# docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS      
                         NAMES
8d214bfb45bc        mysql:5.7           "docker-entrypoint..."   9 seconds ago       Up 8 seconds        0.0.0.0:330
6->3306/tcp, 33060/tcp   mysql02
e908725242a3        tomcat:8.5          "catalina.sh run"        About an hour ago   Up About an hour    0.0.0.0:888
8->8080/tcp              distracted_jang
```

![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523124058334-488767044.png)

![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523124539629-1212865567.png)
