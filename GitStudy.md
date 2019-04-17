#HAP培训----Git学习
## 1.介绍
```
Git是一款免费、开源的分布式版本控制系统，用于敏捷高效地处理任何大小的项目。Git读音为/git/

Git是一个开源的分布式版本控制系统，可以有效、高速的处理从很小到非常大的项目版本管理。  Git 是 Linus Torvalds 为了帮助管理 Linux 内核开发而开发的一个开放源码的版本控制软件。
Torvalds 开始着手开发 Git 是为了作为一种过渡方案来替代 BitKeeper，后者之前一直是 Linux 内核开发人员在全球使用的主要源代码工具。开放源码社区中的有些人觉得BitKeeper 的许可证并不适合开放源码社区的工作，因此 Torvalds 决定着手研究许可证更为灵活的版本控制系统。尽管最初 Git 的开发是为了辅助 Linux 内核开发的过程，但是我们已经发现在很多其他自由软件项目中也使用了 Git。例如 很多 Freedesktop 的项目迁移到了 Git 上。
```

## 2.Git安装
###2.1  下载Git
```
从https://git-scm.com/download/win下载安装包并安装
```
### 2.2 安装验证
 >安装好之后再命令行输入git -version,如下表示安装成功.
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318141823774-365695287.png)

## 3. Git中常用命令
### 3.1 git init
>初始化一个本地Git仓库
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318142133614-1444859594.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318142253806-70964350.png)

>使用git init -h 查看使用帮助
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318142015886-762380403.png)

### 3.2 git status
- 在仓库中新建一个 test.txt
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318142418645-1496481065.png)

- 使用 git status 可以查看到如下结果，红色表示为跟踪的文件
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318142631805-152461533.png)


- 将修改后的文件加入暂存区
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318142725633-1347093878.png)

- 执行上面的git status 绿色表示已经添加到暂存区
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318142801367-378969098.png)

### 3.3 git commit
- 产生一次新的提交.git中的记录都是以commit的形式存在.只要提交记录就会保存在仓库中. git commit -m 'message'
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318143321883-668195863.png)
>每次提交都出产生新的编号，提交的时候需要使用  -m来添加描述信息

----
>注意首次运行会出现下面参数，第一次要先运行红色圈部分参数设置
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318143400708-1999284859.png)---

### 3.4 git remote
- 查看远程仓库 git remote -v
```
git remote -v
```
- 添加远程仓库  git remote add 远程仓库名 远程仓库地址

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318144126466-353505000.png)


### 3.5 git branch

- 查看当前仓库分支 git branch
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318144432582-1329251722.png)

- 创建分支 git branch name
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318144610156-1889126158.png)

- 删除分支
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318144721623-373760922.png)

### 3.6 git checkout 
- 切换分支 git checkout  name
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318145314980-1220326489.png)

- 创建并切换分支 git checkout -b dev
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318145131138-608905859.png)


### 3.7 提交到远程仓库
- 拉取远程仓库的记录   

- 将本地记录推送至远程仓库   git push origin master
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318153638310-1248288862.png)


### 3.8 第一次提交远程报错解决
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318150355480-55332815.png)

-  ssh-keygen -t rsa -C "GitHub账号"
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318150457052-711267156.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190318150526374-1434959843.png)

### 3.9 分支合并
- 合并分支    git meger


### 4.0 恢复
-  将工作空间恢复到最近一次提交,并将暂存区中的修改保存起来. git stash
```
git stash pop
将上一次stash记录弹出

```

### 4.2  克隆
- 克隆下载远程项目 git clone

```

``` 