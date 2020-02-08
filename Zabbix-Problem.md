### 解决 error creating overlay mount to /var/lib/docker/overlay2

```
/usr/bin/docker-current: Error response from daemon: error creating overlay mount to /var/lib/docker/overlay2/65f3c109fb903539820f84856d2725af784f2f03f95b1f0214e34184e4d61ff7-init/merged: invalid argument.
See '/usr/bin/docker-current run --help'.
```

#### 停止docker服务
```
systemctl stop docker
```


#### 清理镜像
```
rm -rf /var/lib/docker
```


#### 修改存储类型
```
vi /etc/sysconfig/docker-storage
```

>把空的DOCKER_STORAGE_OPTIONS参数改为overlay:

```
DOCKER_STORAGE_OPTIONS="--storage-driver overlay"
```


#### 禁用selinux
```
vi /etc/sysconfig/docker
```

>去掉option的–selinux-enabled


#### 启动docker
```
systemctl start docker
```