## Zabbix 4.0 Docker 版本 图表乱码问题解决



`字体文件存放于镜像 zabbix-web-nginx-mysql 的 /usr/share/zabbix/assets/fonts/目录下。`

- 找到window的字体文件
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209173447134-1030812871.png)


- 复制一份新字体到zabbix项目中
```
docker cp /tmp/consolab.ttf b82d5670d35d:/usr/share/zabbix/assets/fonts
```

- 进入容器

```
sudo docker exec -it b82d5670d35d /bin/bash
```

- ping一下宿主IP 看是否可以

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209172503786-31123086.png)


- 开始修改配置文件
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209173109873-428687780.png)

```
 # 编辑文件 /usr/share/zabbix/include/defines.inc.php 大约在69行。将 DejaVuSans  更改为 msyh

vi /usr/share/zabbix/include/defines.inc.php

# 更改前  
define('ZBX_GRAPH_FONT_NAME',           'DejaVuSans'); // font file name

# 更改后
define('ZBX_GRAPH_FONT_NAME',           'msyh'); // font file name
```

然后刷新界面，就可以正常显示了。
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200209173353792-728351667.png)
