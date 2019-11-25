## SpringBoot-Mail 邮箱发送
### 什么是SMTP?
SMTP全称为Simple Mail Transfer Protocol(简单邮件传输协议)，它是一组用于从源地址到目的地址传输邮件的规范，通过他来控制邮件的中转方式。SMTP认证要求必须提供账号和密码才能登陆服务器，其设计目的在于避免用户收到垃圾邮件的侵扰。



### 什么是IMAP?
IMAP全称为Internet Message Access Protocol (互联网邮件访问协议) ，IMAP允许从邮件服务器上获取邮件的信息，下载邮件等。IMAP与POP类似，都是一种邮件获取协议。


### 什么是POP3?
POP3全称为Post Office Protocol 3 (邮局协议)，POP3支持客户端远程管理服务器端的邮件 POP3常用于“离线”邮件处理，即允许客户端下载服务器邮件，然后服务器上的邮件将会被删除。目前很多POP3的邮件服务器只提供下载邮件功能，服务器本身并不删除邮件，这种属于改进版的POP3协议。


### IMAP和POP3协议有什么不同呢?
两者最大的区别在于，IMAP允许双向通信，即在客户端的操作会反馈到服务器上，例如在客户端收取邮件时，标记已读等操作，服务器会跟着同步这些操作。而对于POP协议虽然也允许客户端下载服务器邮件，但是在客户端的操作并不会同步到服务器上面的，例如客户端收取或标记已读邮件，服务器不会同步这些操作


### 什么是JavaMailSender和JavaMailSenderImpl？

JavaMailSender和JavaMailSenderImpl 是Spring官方提供的集成邮件服务的接口和实现类，以简单高效的设计著称，目前是Java后端发送邮件和集成邮件服务的主流工具。


### 如何通过JavaMailSenderImpl发送邮件？
非常简单，直接在业务类注入JavaMailSenderImpl并调用send方法发送邮件。其中简单邮件可以通过SimpleMailMessage来发送邮件，而复杂的邮件（例如添加附件）可以借助MimeMessageHelper来构建MimeMessage发送邮件。例如：

```
@Autowired
private JavaMailSenderImpl mailSender;



public void sendMail() throws MessagingException {
   //简单邮件
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setFrom("admin@163.com");
    simpleMailMessage.setTo("socks@qq.com");
    simpleMailMessage.setSubject("Happy New Year");
    simpleMailMessage.setText("新年快乐！");
    mailSender.send(simpleMailMessage);

    //复杂邮件
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
    messageHelper.setFrom("admin@163.com");
    messageHelper.setTo("socks@qq.com");
    messageHelper.setSubject("Happy New Year");
    messageHelper.setText("新年快乐！");
    messageHelper.addInline("doge.gif", new File("xx/xx/doge.gif"));
    messageHelper.addAttachment("work.docx", new File("xx/xx/work.docx"));
    mailSender.send(mimeMessage);
}
```


### 为什么JavaMailSenderImpl 能够开箱即用 ？
所谓开箱即用其实就是基于官方内置的自动配置，翻看源码可知晓邮件自动配置类(MailSenderPropertiesConfiguration) 为上下文提供了邮件服务实例(JavaMailSenderImpl)。具体源码如下：

```
@Configuration
@ConditionalOnProperty(prefix = "spring.mail", name = "host")
class MailSenderPropertiesConfiguration {
	private final MailProperties properties;
	MailSenderPropertiesConfiguration(MailProperties properties) {
	    this.properties = properties;
	}
	@Bean
	@ConditionalOnMissingBean
	public JavaMailSenderImpl mailSender() {
	    JavaMailSenderImpl sender = new JavaMailSenderImpl();
	    applyProperties(sender);
	    return sender;
	}
```

其中MailProperties是关于邮件服务器的配置信息，具体源码如下：

```
@ConfigurationProperties(prefix = "spring.mail")
public class MailProperties {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private String host;
    private Integer port;
    private String username;
    private String password;
    private String protocol = "smtp";
    private Charset defaultEncoding = DEFAULT_CHARSET;
    private Map<String, String> properties = new HashMap<>();
}
```