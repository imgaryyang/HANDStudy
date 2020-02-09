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
