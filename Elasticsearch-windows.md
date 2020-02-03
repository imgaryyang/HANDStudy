## windows环境下安装elasticsearch

### 一、JAVA环境配置
ElasticSearch是基于lucence开发的，也就是运行需要java、jdk支持。所以要先安装JAVA环境。
由于ElasticSearch 5.x 依赖于JDK 1.8的，所以现在我们下载JDK 1.8或者更高版本。
下载JDK1.8,下载完成后安装。

配置Java环境变量，如下图表示成功配置：
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203202930211-186042744.png)
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203202954567-1738364632.png)



### 二、ElasticSearch配置
- 1、下载ElasticSearch
从[官网下载](https://www.elastic.co/downloads/elasticsearch)ElasticSearch 下载zip格式的。

`这里我们下载最新版 ElasticSearch7.5`


- 2、解压到指定的目录，这里我解压到了D盘目录。
- 3、进入到`D:\software\Elasticsearch\bin执行elasticsearch.bat`

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203203650839-1058295716.png)

- 4、本机就启动了一个ElasticSearch节点，启动后会显示如图所示

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203203637635-1083713456.png)


- 打开浏览器里测试一下 : [访问elasticsearch](http://localhost:9200/)
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203203840231-736708061.png)



>到这里表示安装成功了


### ElasticSearch安装为Windows服务

- elasticsearch的bin目录下有一个`elasticsearch-service.bat`
进入bin目录下执行:

```
elasticsearch-service.bat install
```

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203204155527-955038489.png)

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203204342781-1588092630.png)

- 然后在系统服务中可以看到Elasticsearch已成为系统服务
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203204422968-2024980926.png)

- elasticsearch-service.bat后面还可以执行这些命令
	- install: 安装Elasticsearch服务
	- remove: 删除已安装的Elasticsearch服务（如果启动则停止服务）
	- start: 启动Elasticsearch服务（如果已安装）
	- stop: 停止服务（如果启动）
	- manager:启动GUI来管理已安装的服务



### 三、安装ElasticSearch-head插件

网上很多教程都说用plugin命令去装es-head插件，跟开头说的一样都是1.x，2.x版本，我也下载看了，里面是有plugin的文件。可是我们是要用5.x的版本，es包里并没有提供plugin文件。

`elasticsearch5不可以直接通过plugin -install mobz/elasticsearch-head安装，并且head需要在node环境下运行`


- 1、安装node环境

[官方网址](https://nodejs.org/en/download/)：下载Windows版msi的

安装完后打开cmd查看版本node -v
![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203204832222-1620169707.png)

- 2、安装grunt

grunt是一个很方便的构建工具，可以进行打包压缩、测试、执行等等的工作，5.x里的head插件就是通过grunt启动的。因此需要安装grunt.

`注意：路径切到nodejs安装目录下，[我安装在D:\software\node\nodejs]`。

```
npm install -g grunt-cli
```

-g代表全局安装。安装路径为`C:\Users\{yourname}\AppData\Roaming\npm`，并且自动加入PATH变量。
查看版本号grunt -version

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203213130230-285234851.png)


- 3、下载head插件

[下载地址](https://github.com/mobz/elasticsearch-head)

- 4、配置head
如果head的代码还是2.6版本的，直接执行有很多限制，比如无法跨机器访问。因此需要用户修改两个地方：

① D:/software/Elasticsearch/elasticsearch-head/Gruntfile.js,增加hostname属性，设置为*，如图

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203213934457-847071334.png)


②修改连接地址：D:/software/Elasticsearch/elasticsearch-head_site/app.js，将表红线地址改为es服务器地址。

![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200203214501161-999984992.png)
