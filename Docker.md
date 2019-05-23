# Dockerѧϰ
## Docker��װ
### 1.��װlinux�����
```
(1)VirtualBox(��װ);

?(2)����������ļ�centos7.ova;

(3)˫������linux�����;ʹ��  root/ 123456��½

(4)ʹ�ÿͻ�������linux�����������������;

(5)������������磻
	�Ž�����===ѡ������====��������;
	
?(6)���ú������Ժ�ʹ���������������������
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523104350816-1068396581.png)

`һ��Ҫ��ס`
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523104429489-1836106480.png)


```shell
���������������  ��������
	service network restart
```

```
(7)�鿴linux��ip��ַ
```
```shell
ip addr
```
```
(8)ʹ�ÿͻ�������linux;(SmartTTY)
```

### 2.��linux������ϰ�װdocker
####���裺
```shell
1������ں˰汾��������3.10������
uname -r

2����װdocker
yum install docker

3������yȷ�ϰ�װ

4������docker
[root@localhost ~]# systemctl start docker
[root@localhost ~]# docker -v
Docker version 1.12.6, build 3e8e77d/1.12.6

5����������docker
[root@localhost ~]# systemctl enable docker
Created symlink from /etc/systemd/system/multi-user.target.wants/docker.service to /usr/lib/systemd/system/docker.service.

6��ֹͣdocker
systemctl stop docker

```

![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523105010489-1219638194.png)


### 3.Docker��������&����
#### 3.1�������

| ���� | ����                                            | ˵��                                                     |
| ---- | ----------------------------------------------- | -------------------------------------------------------- |
| ���� | docker  search �ؼ���  eg��docker  search redis | ���Ǿ���ȥdocker  hub�ϼ����������ϸ��Ϣ���羵���TAG�� |
| ��ȡ | docker pull ������:tag                          | :tag�ǿ�ѡ�ģ�tag��ʾ��ǩ����Ϊ����İ汾��Ĭ����latest  |
| �б� | docker images                                   | �鿴���б��ؾ���                                         |
| ɾ�� | docker rmi image-id                             | ɾ��ָ���ı��ؾ���                                       |

�ٷ���ַ: https://hub.docker.com/

#### 3.2 ��������޷�ɾ���������Ĵ���
```
Error response from daemon: conflict: unable to delete 7faa3c53e6d6 (must be forced) - image is referenced in multip
le repositories
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523111153515-1377335624.png)


```powershell
ʹ�òֿ�������Ӿ������Ͱ汾��
	docker rmi daocloud.io/library/mysql:5.7
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523111521219-1682640956.png)



#### 3.3 ��� docker pull ������   timeout����
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523105532527-26730381.png)

- �޸������ļ�
```
vi /etc/docker/daemon.json

���һ��,�޸Ĺ��ھ���Դ
	"registry-mirrors": ["https://registry.docker-cn.com"]
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523105715699-1336419892.png)

- ����docker����
```
#����docker
systemctl daemon-reload 
systemctl restart docker
```

- ����һ������
```
yum install bind-utils
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523110157958-642286777.png)

```
����
	dig @114.114.114.114 registry-1.docker.io
	
��ȡdocker�����ַ	
```
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523110602188-1470752469.png)

- �޸�host�ļ�
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523110933424-1459599138.png)

- ���س�����
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523111053100-403999833.png)


#### 3.4 ��������

�������QQ��װ����----���о���----����һ���������������е���������е�QQ����

���裺

```shell
1����������
[root@localhost ~]# docker search tomcat

2����ȡ����
[root@localhost ~]# docker pull tomcat

3�����ݾ�����������
docker run --name mytomcat -d tomcat:latest

4��docker ps  
�鿴�����е�����

5�� ֹͣ�����е�����
docker stop  ������id

6���鿴���е�����
docker ps -a

7����������
docker start ����id

8��ɾ��һ������
 docker rm ����id
 
9������һ�����˶˿�ӳ���tomcat
[root@localhost ~]# docker run -d -p 8888:8080 tomcat
-d����̨����
-p: �������Ķ˿�ӳ�䵽������һ���˿�    �����˿�:�����ڲ��Ķ˿�

10��Ϊ����ʾ�򵥹ر���linux�ķ���ǽ
service firewalld status ���鿴����ǽ״̬
service firewalld stop���رշ���ǽ

11���鿴��������־
docker logs container-name/container-id

��������ο�
https://docs.docker.com/engine/reference/commandline/docker/
���Բο�ÿһ��������ĵ�

```

- �鿴�����е�����
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523111808301-1627231075.png)

- ֹͣ����(����id)
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523112017822-409486421.png)

- �鿴��������
```
docker ps -a
```


- ��������id
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523112222903-381833387.png)

- �����˿�ӳ��
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523112616774-1319441207.png)

![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523112913335-1673027465.png)


#### 3.5 ɾ��docker����
![](https://img2018.cnblogs.com/blog/1231979/201905/1231979-20190523104902455-562303640.png)


### 4.��װMySQLʾ��

```shell
docker pull mysql
```

���������

```shell
[root@localhost ~]# docker run --name mysql01 -d mysql:5.7
8b1f452f0b130b02bbf5b12d5f8d191465573a50faa8b74f3d4f81d394b82134

mysql�˳���
[root@localhost ~]# docker ps -a
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS                         
  PORTS                    NAMES
8b1f452f0b13        mysql:5.7           "docker-entrypoint..."   25 seconds ago      Exited (1) 24 seconds ago      
                           mysql01
e908725242a3        tomcat:8.5          "catalina.sh run"        57 minutes ago      Up 57 minutes                  
  0.0.0.0:8888->8080/tcp   distracted_jang
5afeda03fcf4        tomcat:8.5          "catalina.sh run"        About an hour ago   Exited (143) About an hour ago 
                           mytomcat


//������־
[root@localhost ~]# docker logs 8b1f452f0b13
error: database is uninitialized and password option is not specified 
  You need to specify one of MYSQL_ROOT_PASSWORD, MYSQL_ALLOW_EMPTY_PASSWORD and MYSQL_RANDOM_ROOT_PASSWORD;  
  #���������������ָ��һ��
```


��ȷ������
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



���˶˿�ӳ��

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
