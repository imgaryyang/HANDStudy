## centos7安装telnet后/etc/xinetd.d/telnet下没有telnet文件

### 安装telnet

#### 在telnet Server服务器上执行命令
```
yum -y install telnet  telnet-server 
rpm  -ql  telnet
rpm  -ql  telnet-server 

rpm -qa | grep xinetd

yum -y install xinetd
```
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216184646891-903930824.png)

>安装完xinetd服务之后发现xinetd下面多了几个文件但是就是没有telnet


#### 执行下面的telnet 被拒绝无法登陆
```
telenet 127.0.0.1

telenet 192.168.0.111 23 
```
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216174803445-1936617130.png)

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216174902110-612443459.png)


`相应的telnet服务无法连接被拒绝`
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216184100594-2016247999.png)


### 解决方案

#### 启动telnet服务，设置开机自启
```
systemctl start telnet.socket

systemctl enable telnet.socket

systemctl status telnet.socket
```
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216183752020-1232047724.png)


![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216175012780-916479937.png)


- 退出telnet
```
quit
```


- 拿到数据 telnet成功
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200216175219118-293389754.png)


