## 综合对比 Kafka、RabbitMQ、RocketMQ、ActiveMQ
### 开发语言
```
Kafka：Scala 
rabbitmq：Erlang
zeromq：c 
rocketmq：java 
activemq：java
```

### 支持的协议
```
Kafka：自己定义的一套…（基于TCP） 
rabbitmq：AMQP 
zeromq：TCP、UDP 
rocketmq：自己定义的一套… 
activemq：OpenWire、STOMP、REST、XMPP、AMQP
```

### 消息存储
Kafka:内存、磁盘、数据库。支持大量堆积

#### Kafka
kafka的最小存储单元是分区，一个topic包含多个分区，Kafka创建主题时，这些分区会被分配在多个服务器上，通常一个broker一台服务器。分区首领会均匀地分布在不同的服务器上，分区副本也会均匀的分布在不同的服务器上，确保负载均衡和高可用性，当新的broker加入集群的时候，部分部分会被移动到新的broker上，根据配置文件中的目录清单，Kafka会把新的分区分配给目录清单里分区数最少的目录。


#### Rabbitmq
内存、磁盘。支持少量堆积
rabbitmq的消息分为持久化的消息和非持久化的消息，不管是持久化的消息还是非持久化的消息都可以写入到磁盘。持久化的消息在到达队列时就写入到磁盘，并且如果可以
