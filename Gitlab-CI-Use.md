## gitlab-ci 持续集成
### CI 架构图
![](https://img2018.cnblogs.com/blog/1231979/201911/1231979-20191114163240049-594002231.png)


### 执行过程
- 开发提交代码后，自动触发gitlab-runner拉取executor镜像执行单元测试，单元测试代码中包含上传测试结果到x-utest测试平台;
- 单元测试通过后，gitlab-runner拉取sonar-scanner镜像执行静态代码分析，分析结果评论在commit中或保存于sonarqube;
- 静态代码分析结束，执行分发操作，将代码分发至灰度测试服务器，并运行;
- 执行接口测试，执行完成后上传测试结果到x-utest测试平台。


>四个任务相互依赖，只在前一个任务状态为成功情况下才会执行。



### Gitlab CI 基本配置
**针对某个需要做CI/CD的项目，需要将代码库的该设置打开，并为其配置 gitlab-runner。** <br />



#### gitlab runner
>gitlab-runner不仅可以运行在物理机，还可以运行在容器中。考虑到gitlab-runner消耗的资源少，使用容器更合适。


##### 拉取gitlab-runner Docker 镜像：
```
sudo docker pull gitlab/gitlab-runner
```

##### 启动容器
```
sudo docker run -d --name gitlab-runner --restart always \
    -v /srv/gitlab-runner/config:/etc/gitlab-runner \
    -v /var/run/docker.sock:/var/run/docker.sock \
    gitlab/gitlab-runner:latest
```

##### 在容器中执行register操作,将gitlab上的项目注册到gitlab-runner中:
```
sudo docker exec -it gitlab-runner gitlab-ci-multi-runner register
```
>输入上述命令后会有一系列的配置需要输入，当然也可以设置完后进行更改
>按照提示输入即可，前两项可以在指定项目设置中CI/CD选项里的Runners settings选项中的Specific Runners里看到，tags是gitlab-ci.yml文件中所要用到的，executor选择docker
>配置成功后，我们可以在设置中CI/CD选项里的Runners settings选项中的Specific Runners里看到runner信息


##### 本地executor镜像
为了部署与测试，需要一个镜像用于执行。当选用本地镜像时，会发现如下报错

**拉取镜像失败**
![](https://img2018.cnblogs.com/blog/1231979/201911/1231979-20191114164420306-1032614737.png)

>报错的原因在于，gitlab-runner尝试去官方的docker hub仓库拉取镜像。通过修改gitlab-runner中的配置，设置只拉取本地镜像：

修改 /etc/gitlab-runner/config.toml ，在 [runners.docker] 下，添加：
```
pull_policy = never  # 该配置默认always，即只在线上拉取镜像
```


如果有需要添加一些hosts映射，仍然在 [runners.docker] 下，添加：
```
extra_hosts = ["hostname:ip"]
```


另外为了加快单元测试执行速度，将服务端代码的依赖提前安装至executor镜像中：
```
COPY requirement.txt .
RUN pip install -r requirement.txt
```

### 编写 .gitlab-ci.yaml
```
image: pro1_executor

stages:
  - unittest
  - analyze
  - deploy
  - apitest

variables:
  SONAR_HOST: "http://192.168.0.29:9000"
  SONAR_PROJ: "pro_1"
  SONAR_LOGIN: "b3135dd602b61ce7ff5f4202a3ec2ec0865fa7f5"

services:
  - redis:3
  - mongo:3.2

UnitTest:
  stage: unittest
  script:
  - pip install nose
  - python -m runtest xtest

Sonar_Preview:
  image: sonar-scanner
  stage: analyze
  script:
    - sonar-scanner
      -Dsonar.analysis.mode=preview
      -Dsonar.gitlab.commit_sha=$CI_BUILD_REF
      -Dsonar.gitlab.ref_name=$CI_BUILD_REF_NAME
      -Dsonar.gitlab.project_id=$CI_PROJECT_ID
      -Dsonar.projectKey=$SONAR_PROJ
      -Dsonar.sources=.
      -Dsonar.host.url=$SONAR_HOST
      -Dsonar.login=$SONAR_LOGIN
  except:
    - master

Sonar_Analyze:
  image: sonar-scanner
  stage: analyze
  script:
    - sonar-scanner
      -Dsonar.projectKey=$SONAR_PROJ
      -Dsonar.sources=.
      -Dsonar.host.url=$SONAR_HOST
      -Dsonar.login=$SONAR_LOGIN
  only:
    - master

Deploy_TestServer:
  stage: deploy
  script: echo "deploy"

API_Test:
  stage: apitest
  script:
    - cd /
    - git clone https://gitlab-ci-token:${CI_JOB_TOKEN}@gitlab.xxx.com/yx/apitest.git
    - cd apitest
    - pip install -r requirements.txt
    - python runtest.py
```

### 单元测试部分
#### 用nose执行测试
对于Python，nosetest工具可以嗅探与执行你写的所有测试用例，并输出结果。在执行测试前，使用nose需要使用pip安装