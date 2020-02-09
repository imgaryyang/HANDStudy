## 解决Zabbix agent is not available


- 1.浏览器登录http://192.168.0.110 如果无法登录，先关闭主机防火墙
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209141329755-1955880763.png)


- 2、接口IP不能是127.0.0.1，127.0.0.1是宿主机的。
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209141658896-642483638.png)


- 3、查看 zabbix-agent 容器的IP地址

```
iptables -nL --line-number  //查看端口规则

docker inspect zabbix-agent |grep IPAddress  //查看容器IP地址
```

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209141514984-186171192.png)

- 4.点击进入Zabbix server修改IP地址，等会绿色就是正常
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209141743228-1243010248.png)

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209142053501-1762187843.png)




### windows下安装zabbix-agent 

#### 首先去到官网下载 zabbix agent 4.0

[下载链接地址](https://www.zabbix.com/download_agents)

#### 下载好，找到这两个文件，复制到新目录zabbix_agent，目前我们只需要用到这两个

```
zabbix_agentd.exe

zabbix_agentd.win.conf
```

#### 配置zabbix的配置文件，主要配置的有如下几点，有其他需求的可自行研究

```
1. LogFile=D:\WorkCode\logs\zabbix_agentd.log

2. Server= 指定服务端地址，填入你zabbix-server的地址

3. ServerActive= 主动提交的服务器端地址，也是你zabbix-server的地址

3. Hostname= 指定服务段显示的名称，默认不填写为客户端的主机名

4. EnableRemoteCommands= 是否允许远程命令配置，1 为允许，0为不允许，默认是为0
```


#### 安装
-  以`管理员运行`命令行CMD，进入到zabbix-agent的目录，输入如下命令运行

```
cd D:\software\zabbix_agents\bin\win64

D:

zabbix_agentd.exe -c D:\software\zabbix_agents\conf\zabbix_agentd.win.conf -i
```


-  安装成功后，执行运行命令：
```
zabbix_agentd.exe -c D:\software\zabbix_agents\conf\zabbix_agentd.win.conf -s
```
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209155243654-1193315448.png)

 >这里要注意一下，如果执行CMD不是用管理员权限打开，会报告错误。
现在首先用管理员打开CMD，进入到zabbix-agent程序目录，要进行卸载，执行`zabbix_agentd.exe -d`,然后重新执行安装、运行命令，这样就可以正常启动。


#### 命令说明：

- -c --Path to the configuration file.

- -i --install Install Zabbix Windows agent as service

- -d --uninstall Uninstall Zabbix Windows agent service

- -s --start Start Zabbix Windows agent service

- -x --stop Stop Zabbix Windows agent service


#### Zabbix的web界面进行配置
`问题---系统连接被中断`

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209153823100-921059053.png)

#### 直接全部关闭windows防火墙
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209154433761-265505209.png)

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209154458946-432595468.png)


#### 设定防火墙允许，zabbix默认要用到的端口是10050，所以设定允许10050端口的访问。

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209154351676-1703296921.png)


![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209153953969-400333111.png)
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209154004777-617847710.png)
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209154018451-1411865018.png)
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209154026393-512103108.png)
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209154031660-1214000366.png)
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209154053422-1749774056.png)
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209154101668-501815259.png)


`成功`
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209154202909-910551577.png)
