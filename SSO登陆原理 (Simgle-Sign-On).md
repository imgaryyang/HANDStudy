## SSO登陆原理 (Simgle-Sign-On)
### 什么是SSO ?
在多个系统中,只需要登陆一次，就可以访问其他相互信任的应用系统。

### 为什么要提出SSO ?
这个技术的提出解决了:
- 企业运行多个服务,而账号需要集中统一管理
- 终端用户登陆一次，即可使用一个账户享受所有不同域名下服务。

>SSO与CAS (Centeral Authentication System) 这个概念密切相关，账户集中由某个服务管理，SSO服务只负责登陆认证。

登陆认证与[服务端在浏览器上写入的认证Cookie] 密切相关，Cookie有一系列重要属性：Domain，PathExpiration，HttpOnly决定了该Cookie在客户端的作用域，作用范围、有效时间、有效操作方式
![](https://img2018.cnblogs.com/blog/1231979/201911/1231979-20191126222517360-838619949.png)


#### 用户首次访问website1
- 用户访问website1 系统，website1系统需要认证， 用户当前没有登陆
- website1给客户端返回302重定向响应， 客户端重定向到SSO服务页
	- 交互过程确实是临时跳转，下面传参false， 返回302临时重定向响应
  - context.Response.Redirect(ssoURL, false);
用户并没有登陆SSO系统，所以SSO系统会返回登陆界面

- 用户在SSO登陆界面输出账户/密码
-  登陆成功，SSO会在客户端写入一个 cookie for sso并产生一个301重定向响应，客户端将重定向到原website1地址，该请求附带了SSO给与这次认证成功的 ticket
http://www.website1.com?ticket=XXXX-OOOO-XXXX-OOOO

- website1收到以上重定向请求，解析QueryString中的ticket， 向SSO做一次ticket验证；验证通过向客户端写入本站的 cookie for website

- 上面第5步，浏览器地址会显示：http://www.website1.com?ticket=XXXX-OOOO-XXXX-OOOO， 在本站验证通过之后，最好再做一个重定向，返回业务首页：www.website1.com， 本步骤不是SSO登陆的标准流程。

之后用户访问website2

- 用户访问website2， 用户在website2并没得到认证；跳转回 SSO
- SSO服务检测到该 用户在SSO域下存在Cookie for sso， 认定该用户已经登陆，故跳转回website2， 如上也会携带认证ticket
- 如上，website2 收到website.com?ticket=XXX-OOOO-XXXX-OOOO 请求，会做一次SSO验证;验证成功写入本站cookie for website2 

#### 重难点解读

① SSO认证成功，写入的cookie for sso， 是登陆到其他系统的关键

② website1收到SSO发起的重定向请求，解析出ticket=XXXX-OOOO-XXXX-OOOO， 为什么还要做一次SSO验证？
因为website1收到的带ticket请求，有可能是伪造， 所以在website1中需要去SSO验证一次。

③ 标准的CAS登陆流程有两次302客户端重定向， 分别由原站点website1和SSO启动。

理论上 整个流程由服务端重定向也是可以的 ？？看官若发现有漏洞，可在评论区回复。 

④ 退出SSO登陆， 要做两件事情：

- 向SSO发起api请求，请求SSO删除用户在SSO域下的认证cookie for sso
- 移除本站的cookie for website1

⑤ 每个website，至少需要如下sso配置   
```
"SsoOptions": {
    "BaseAddress": "https://sso-cas.sso.com",   　　　　// 基地址
    "LoginPath": "/login",                             // sso登陆地址
    "LogoutPath": "/api/logout",                       // 退出sso登陆的api地址
    "ValidateTGTPath": "/api/validate",                // 验证ticket的api地址 
    "UserInfoPath": "/api/v2/userinfo"                 // 从sso拿到登陆用户信息的api地址
  },
```