## 安装Zabbix 分布式监控

### 基于Docker容器安装Zabbix
`使用Centos7安装docker容器`

#### 关闭本机防火墙
```
systemctl status firewalld.service //查看防火墙状态

systemctl stop firewalld.service //暂时关闭防火墙服务器

systemctl disable firewalld.service //永久禁止防火墙服务器
```


#### 部分命令如下
```
yum install docker //安装docker

systemctl start docker //启动docker

systemctl enable docker //开机启动docker

docker version //查看docker版本

docker ps //查看正在运行的容器

docker ps -a //查看历史容器启动

docker pull nginx //拉取最新镜像
```

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200207120332396-1697851394.png)


#### 修改docker镜像源
```
{
	"registry-mirrors": ["http://f1361db2.m.daocloud.io", "http://hub-mirror.c.163.com", "https://registry.docker-cn.com"]
}

```
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200207120746210-862087839.png)

```
systemctl restart docker  //重启docker容器
```


#### 测试docker
```
docker run hello-world
```


#### 删除所有容器
```
 docker rm $(docker ps -a -q) // remove删除所有容器
```


#### 开始安装Zabbix环境

- 由于zabbix提供集中的web监控管理界面，因此服务在web界面的呈现需要LAMP架构支持。 

```
yum install -y httpd mariadb-server mariadb php php-mysql php-gd libjpeg* php-ldap php-odbc php-pear php-xml php-xmlrpc php-mhash
```


服务端监听端口为10051，而被监控端即Zabbix-agents代理程序监控10050端口。


##### 安装mysql 并启动Mysql命令(启动设置一些参数 通过 -e)
```
docker run --name mysql-server -t -e MYSQL_DATABASE="zabbix" -e MYSQL_USER="zabbix" -e MYSQL_PASSWORD="zabbix@123" -e MYSQL_ROOT_PASSWORD="zabbix@123" -d mysql:5.7.27 --character-set-server=utf8 --collation-server=utf8_bin
```

**如果需要开放外网端口则需要修改配置**

- docker stop <容器id>   //停止运行中的容器

- vim /var/lib/docker/containers/[容器hash]/hostconfig.json，（有人提到，如果config.v2.json里面也记录了端口，也要修改）

修改PortBindings参数配置，宿主机8001端口映射容器80端口示例：

```
"PortBindings":{"80/tcp":[{"HostIp":"","HostPort":"8001"}]},"
```

**config.v2.json 文件查看关键字即可Ports**
```
{
	"StreamConfig": {},
	"State": {
		"Running": false,
		"Paused": false,
		"Restarting": false,
		"OOMKilled": false,
		"RemovalInProgress": false,
		"Dead": false,
		"Pid": 0,
		"ExitCode": 0,
		"Error": "",
		"StartedAt": "2020-02-06T13:30:31.716416709Z",
		"FinishedAt": "2020-02-06T14:06:54.895345551Z",
		"Health": null
	},
	"ID": "e735c5c6e404c3673cce6b0c136f1f2cc6609aeaef92f375677577b9cf47df6e",
	"Created": "2020-02-06T13:30:31.407681613Z",
	"Managed": false,
	"Path": "docker-entrypoint.sh",
	"Args": ["--character-set-server=utf8", "--collation-server=utf8_bin"],
	"Config": {
		"Hostname": "e735c5c6e404",
		"Domainname": "",
		"User": "",
		"AttachStdin": false,
		"AttachStdout": false,
		"AttachStderr": false,
		"ExposedPorts": {
			"3306/tcp": {},
			"33060/tcp": {}
		},
		"Tty": true,
		"OpenStdin": false,
		"StdinOnce": false,
		"Env": ["MYSQL_DATABASE=zabbix", "MYSQL_USER=zabbix", "MYSQL_PASSWORD=zabbix@123", "MYSQL_ROOT_PASSWORD=zabbix@123", "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin", "GOSU_VERSION=1.7", "MYSQL_MAJOR=5.7", "MYSQL_VERSION=5.7.27-1debian9"],
		"Cmd": ["--character-set-server=utf8", "--collation-server=utf8_bin"],
		"Image": "mysql:5.7.27",
		"Volumes": {
			"/var/lib/mysql": {}
		},
		"WorkingDir": "",
		"Entrypoint": ["docker-entrypoint.sh"],
		"OnBuild": null,
		"Labels": {}
	},
	"Image": "sha256:383867b75fd22e6c8ca3ef2a1042339ec2d5b655365107547eac94e918309b91",
	"NetworkSettings": {
		"Bridge": "",
		"SandboxID": "b5900d6a1c3fabcb220ba2c675531fac06dabfd05f550a6868d078ccf5f62749",
		"HairpinMode": false,
		"LinkLocalIPv6Address": "",
		"LinkLocalIPv6PrefixLen": 0,
		"Networks": {
			"bridge": {
				"IPAMConfig": null,
				"Links": null,
				"Aliases": null,
				"NetworkID": "310145b3fba2ffa67bb390b64154a3b55737a7d39341f6bc8a77a0a9ff0a75cd",
				"EndpointID": "",
				"Gateway": "",
				"IPAddress": "",
				"IPPrefixLen": 0,
				"IPv6Gateway": "",
				"GlobalIPv6Address": "",
				"GlobalIPv6PrefixLen": 0,
				"MacAddress": "",
				"IPAMOperational": false
			}
		},
		"Service": null,
		"Ports": {
			"3306/tcp": [{
				"HostIp": "0.0.0.0",
				"HostPort": "3306"
			}],
			"33060/tcp": [{
				"HostIp": "0.0.0.0",
				"HostPort": "33060"
			}]
		},
		"SandboxKey": "/var/run/docker/netns/b5900d6a1c3f",
		"SecondaryIPAddresses": null,
		"SecondaryIPv6Addresses": null,
		"IsAnonymousEndpoint": false,
		"HasSwarmEndpoint": false
	},
	"LogPath": "",
	"Name": "/mysql-server",
	"Driver": "overlay2",
	"MountLabel": "system_u:object_r:svirt_sandbox_file_t:s0:c476,c696",
	"ProcessLabel": "system_u:system_r:svirt_lxc_net_t:s0:c476,c696",
	"RestartCount": 0,
	"HasBeenStartedBefore": true,
	"HasBeenManuallyStopped": false,
	"MountPoints": {
		"/var/lib/mysql": {
			"Source": "",
			"Destination": "/var/lib/mysql",
			"RW": true,
			"Name": "ed3dec3ee5659535447cfb58cd744b53dd90d4d31a90e72e4dfa61dc9ddc0c13",
			"Driver": "local",
			"Type": "volume",
			"Spec": {
				"Type": "volume",
				"Target": "/var/lib/mysql"
			}
		}
	},
	"SecretReferences": null,
	"AppArmorProfile": "",
	"HostnamePath": "/var/lib/docker/containers/e735c5c6e404c3673cce6b0c136f1f2cc6609aeaef92f375677577b9cf47df6e/hostname",
	"HostsPath": "/var/lib/docker/containers/e735c5c6e404c3673cce6b0c136f1f2cc6609aeaef92f375677577b9cf47df6e/hosts",
	"ShmPath": "/var/lib/docker/containers/e735c5c6e404c3673cce6b0c136f1f2cc6609aeaef92f375677577b9cf47df6e/shm",
	"ResolvConfPath": "/var/lib/docker/containers/e735c5c6e404c3673cce6b0c136f1f2cc6609aeaef92f375677577b9cf47df6e/resolv.conf",
	"SeccompProfile": "",
	"NoNewPrivileges": false
}
```

**hostconfig.json 关键字PortBindings**
```
{
	"Binds": null,
	"ContainerIDFile": "",
	"LogConfig": {
		"Type": "journald",
		"Config": {}
	},
	"NetworkMode": "default",
	"PortBindings": {
		"3306/tcp": [{
			"HostIp": "",
			"HostPort": "33060"
		}]
	},
	"RestartPolicy": {
		"Name": "no",
		"MaximumRetryCount": 0
	},
	"AutoRemove": false,
	"VolumeDriver": "",
	"VolumesFrom": null,
	"CapAdd": null,
	"CapDrop": null,
	"Dns": [],
	"DnsOptions": [],
	"DnsSearch": [],
	"ExtraHosts": null,
	"GroupAdd": null,
	"IpcMode": "",
	"Cgroup": "",
	"Links": [],
	"OomScoreAdj": 0,
	"PidMode": "",
	"Privileged": false,
	"PublishAllPorts": false,
	"ReadonlyRootfs": false,
	"SecurityOpt": null,
	"UTSMode": "",
	"UsernsMode": "",
	"ShmSize": 67108864,
	"Runtime": "docker-runc",
	"ConsoleSize": [0, 0],
	"Isolation": "",
	"CpuShares": 0,
	"Memory": 0,
	"NanoCpus": 0,
	"CgroupParent": "",
	"BlkioWeight": 0,
	"BlkioWeightDevice": null,
	"BlkioDeviceReadBps": null,
	"BlkioDeviceWriteBps": null,
	"BlkioDeviceReadIOps": null,
	"BlkioDeviceWriteIOps": null,
	"CpuPeriod": 0,
	"CpuQuota": 0,
	"CpuRealtimePeriod": 0,
	"CpuRealtimeRuntime": 0,
	"CpusetCpus": "",
	"CpusetMems": "",
	"Devices": [],
	"DiskQuota": 0,
	"KernelMemory": 0,
	"MemoryReservation": 0,
	"MemorySwap": 0,
	"MemorySwappiness": -1,
	"OomKillDisable": false,
	"PidsLimit": 0,
	"Ulimits": null,
	"CpuCount": 0,
	"CpuPercent": 0,
	"IOMaximumIOps": 0,
	"IOMaximumBandwidth": 0
}
```


![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200207130452991-590403160.png)



- systemctl restart docker  //重新启动docker引擎

- docker start <容器id>  //重新启动docker容器


##### 安装 zabbix-java-gateway 并启动

```
docker run --name zabbix-java-gateway -t -d zabbix/zabbix-java-gateway:latest
```



##### 安装 zabbix-server-mysql

```
docker run --name zabbix-server-mysql -t -e DB_SERVER_HOST="mysql-server" -e MYSQL_DATABASE="zabbix" -e MYSQL_USER="zabbix" -e MYSQL_PASSWORD="zabbix@123" -e MYSQL_ROOT_PASSWORD="zabbix@123" -e ZBX_JAVAGATEWAY="zabbix_java_gateway" --link mysql-server:mysql --link zabbix-java-gateway:zabbix-java-gateway -p 10051:10051 -d zabbix/zabbix-server-mysql:latest
```


**查看日志查看是否启动成功**
```
docker logs 容器ID
```


##### 安装 Zabbix-web-nginx-mysql
```
docker run --name zabbix-web-nginx-mysql -t -e DB_SERVER_HOST="mysql-server" -e MYSQL_DATABASE="zabbix" -e MYSQL_USER="zabbix" -e MYSQL_PASSWORD="zabbix@123" -e MYSQL_ROOT_PASSWORD="zabbix@123" --link mysql-server:mysql --link zabbix-server-mysql:zabbix-server -p 80:80 -d zabbix/zabbix-web-nginx-mysql:latest
```


##### 安装 Zabbix-agent
```
docker run --name zabbix-agent -e ZBX_HOSTNAME="Zabbix server" -e ZBX_SERVER_HOST="zabbix-server-mysql" --link zabbix-server-mysql:zabbix-server -d zabbix/zabbix-agent:latest
```


`docker ps 查看几个进程`
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200207131452128-1086089026.png)

```
ps -ef | grep php-fpm
```


### 浏览器访问
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200207131955571-1578362739.png)

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200207115738834-450213347.png)



### zabbix修改界面语言为中文
- 登录zabbix的主界面，点击右上角的小头像图标，就可以进入到设置界面。

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200207132626259-536155723.png)

- 在设置界面可以看到，默认的界面语言就是english，点击旁边的下拉按钮，可以看到默认有中文语言，选择

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200207132744536-2130191334.png)
