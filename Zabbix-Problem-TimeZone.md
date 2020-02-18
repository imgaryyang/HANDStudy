## docker中运行zabbix/zabbix-web-nginx-mysql镜象，前端页面显示时间不准确的问题 (差5个小时) --右边的时钟是正确的数据收集的时间是错误的


### 修改时区
```
date.timezone =Asia/Shanghai
```


#### 进入容器
```
docker exec -it b82d5670d35d /bin/bash
```


#### 进入/etc/php7/conf.d/目录，修改此目录下的 99-zabbix.ini 配置文件vi /etc/php7/conf.d/99-zabbix.ini


```
max_execution_time=600
memory_limit=128M
post_max_size=16M
upload_max_filesize=2M
max_input_time=300
; always_populate_raw_post_data=-1
max_input_vars=10000
; date.timezone=Europe/Riga
date.timezone=Asia/Shanghai //修改这里为Asia/Shanghai
; session.save_path=/var/lib/php7
```
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200218161023681-1382097964.png)


#### 退出容器，重启容器
发现修改会被覆盖，因此只能重新进入容器，再次修改上述文件，然后kill掉所有php-fpm7的进程后，再进入 /usr/sbin/目录下运行./php-fpm7



#### 刷新页面后时区生效，时间显示正确
