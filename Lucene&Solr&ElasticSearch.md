## Lucene、Solr、ElasticSearch
### 1、Lucene和Solr和Elasticsearch的区别
#### Lucene
Lucene是apache下的一个子项目，是一个开放源代码的全文检索引擎工具包，但它不是一个完整的全文检索引擎，而是一个全文检索引擎的架构，提供了完整的查询引擎和索引引擎，部分文本分析引擎。[官网地址](https://lucene.apache.org/)


#### Solr

Solr是一个高性能，采用Java5开发，基于Lucene的全文搜索服务器。同时对其进行了扩展，提供了比Lucene更为丰富的查询语言，同时实现了可配置、可扩展并对查询性能进行了优化，并且提供了一个完善的功能管理界面，是一款非常优秀的全文搜索引擎。[官网地址](http://lucene.apache.org/solr/)


#### Elasticsearch
Elasticsearch跟Solr一样，也是一个基于Lucene的搜索服务器，它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。[官网地址](https://www.elastic.co/products/elasticsearch)




### 各自的优缺点
#### 1、Elasticsearch的优缺点：
##### 优点
- Elasticsearch是分布式的。不需要其他组件，分发是实时的，被叫做"Push replication"。
- Elasticsearch 完全支持 Apache Lucene 的接近实时的搜索。
- 处理多租户（multitenancy）不需要特殊配置，而Solr则需要更多的高级设置。
- Elasticsearch 采用 Gateway 的概念，使得完备份更加简单。
- 各节点组成对等的网络结构，某些节点出现故障时会自动分配其他节点代替其进行工作。


##### 缺点
- 只有一名开发者（当前Elasticsearch GitHub组织已经不只如此，已经有了相当活跃的维护者）
- 还不够自动（不适合当前新的Index Warmup API）


#### 2、Solr的优缺点
##### 优点
- Solr有一个更大、更成熟的用户、开发和贡献者社区。
- 支持添加多种格式的索引，如：HTML、PDF、微软 Office 系列软件格式以及 JSON、XML、CSV 等纯文本格式。
- Solr比较成熟、稳定。
- 不考虑建索引的同时进行搜索，速度更快。


##### 缺点
- 建立索引时，搜索效率下降，实时索引搜索效率不高。



#### 3、Elasticsearch 与 Solr 的比较
- 二者安装都很简单；
- Solr 利用 Zookeeper 进行分布式管理，而 Elasticsearch 自身带有分布式协调管理功能;
- Solr 支持更多格式的数据，而 Elasticsearch 仅支持json文件格式；
- Solr 官方提供的功能更多，而 Elasticsearch 本身更注重于核心功能，高级功能多有第三方插件提供；
- Solr 在传统的搜索应用中表现好于 Elasticsearch，但在处理实时搜索应用时效率明显低于 Elasticsearch。
- Solr 是传统搜索应用的有力解决方案，但 Elasticsearch 更适用于新兴的实时搜索应用。


### 使用案例
- 1.维基百科使用Elasticsearch来进行全文搜做并高亮显示关键词，以及提供search-as-you-type、did-you-mean等搜索建议功能。
- 2.英国卫报使用Elasticsearch来处理访客日志，以便能将公众对不同文章的反应实时地反馈给各位编辑。
- 3.StackOverflow将全文搜索与地理位置和相关信息进行结合，以提供more-like-this相关问题的展现。
- 4.GitHub使用Elasticsearch来检索超过1300亿行代码。
- 5.每天，Goldman Sachs使用它来处理5TB数据的索引，还有很多投行使用它来分析股票市场的变动。



### 实现
#### solr如何实现搜索的？
倒排索引，先抽取文档中词，并建立词与文档id的映射关系，然后查询的时候会根据词去查询文档id，并查询出文档


Solr过滤器
Solr的过滤器对接收到的标记流（TokenStream ）做额外的处理
过滤查询，在查询时设置