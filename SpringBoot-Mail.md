## SpringBoot-Mail 邮箱发送
### 什么是SMTP?
SMTP全称为Simple Mail Transfer Protocol(简单邮件传输协议)，它是一组用于从源地址到目的地址传输邮件的规范，通过他来控制邮件的中转方式。SMTP认证要求必须提供账号和密码才能登陆服务器，其设计目的在于避免用户收到垃圾邮件的侵扰。



### 什么是IMAP?
IMAP全称为Internet Message Access Protocol (互联网邮件访问协议) ，IMAP允许从邮件服务器上获取邮件的信息，下载邮件等。IMAP与POP类似，都是一种邮件获取协议。


### 什么是POP3？
POP3全称为Post Office Protocol 3 (邮局协议)，POP3支持客户端远程管理服务器端的邮件 POP3常用于“离线”邮件处理，即允许客户端下载服务器邮件，然后服务器上的邮件将会被删除。目前很多POP3的邮件服务器只提供下载邮件功能，服务器本身并不删除邮件，这种属于改进版的POP3协议。


### IMAP和POP3协议有什么不同呢？