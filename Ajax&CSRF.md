## Ajax请求的安全

### AJAX请求真的不安全么
AJAX请求是否安全，由服务端（后台）决定

```
如果某个Web应用具备良好的安全性，那么再怎么用“不安全的AJAX”也削弱不了它的安全性，反之如果应用本身存在漏洞，不管用何种技术请求，它都是不安全的
```
![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191208205047225-996662066.png)

>为何会有这种说法？因为在Web应用中，客户端输入不可信是一个基本原则



### 常见的几种Web前端安全问题
#### 要知道AJAX请求是否安全，那么就得先知道Web前端中到底有那几种安全问题

- XSS（跨站脚本攻击）（cross-site scripting）
	- 伪造会话（基于XSS实现CSRF）
	- 劫持cookie
	- 恶意代码执行


- CSRF（跨站请求伪造）（cross-site request forgery）
	- 伪造用户身份操作

- SQL注入

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191208205634215-1037635491.png)

>如上，Web前端中的安全问题主要就是这几类（列举部分做分析），所以我们首先要分析AJAX与这几大类之前的关系


### CSRF 简介

CSRF，特征简单：冒用用户身份，进行恶意操作

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191208205838247-554997845.png)

所以，我们看到关键条件是：
- 采用cookie 来进行用户校验
- 登陆受信任网站A,并在本地生成cookie
- 在不登出A的情况下，访问危险网站B


>一般在 (4) 处恶意网站 (B) 的攻击手段如下(必须指向A的地址，否则无法带上cookie)

```
// 1.譬如在网站内的图片资源中潜入恶意的转账操作
<img src=http://www.bank.example/transfer?toBankId=hello&amount=1000000 width='0' height='0'>

// 2.构建恶意的隐藏表单，并通过脚本提交恶意请求
<iframe style="display: none;" name="csrf-frame"></iframe>
<form method='POST' action='http://www.bank.example/transfer' target="csrf-frame" id="csrf-form">
  <input type='hidden' name='toBankId' value='hello'>
  <input type='hidden' name='amount' value='1000000'>
  <input type='submit' value='submit'>
</form>
<script>document.getElementById("csrf-form").submit()</script>
```

而且，从头到尾，攻击网站都没有获取到过 cookie，都是通过浏览器间接实现（利用Web的cookie隐式身份验证机制），所以HttpOnly并不会影响这个攻击


最后说下，几种常见的CSRF防御手段：
- 验证HTTP Referer字段（非常简单，但是鉴于客户端并不可信任，所以并不是很安全）
	- 防止CSRF，检查Referer字段简单直接，但是其完全依赖浏览器发送正确的Referer字段。
	- 虽然http协议对此字段的内容有明确的规定，但并无法保证来访的浏览器的具体实现，亦无法保证浏览器没有安全漏洞影响到此字段。并且也存在攻击者攻击某些浏览器，篡改其Referer字段的可能。

- 在请求地址中添加token并验证
譬如post中，以参数的形式加入一个随机产生的token