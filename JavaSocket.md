# Java网络通信
## 1.Java中的XML操作
### 1.1XML数据格式
```
XML,即可扩展标记语言(Extensible Markup Language)，标准通用标记语言的子集，一种用于标记电子文件使其具有结构性的标记语言。他可以用来标记数据、定义数据类型，是一种允许用户对自己的标记语言进行定义的源语言。它非常适合万维网传输，提供统一的方法来描述和交换独立于应用程序或供应商的结构化数据。
```

-介绍
```
- XML是一种标记语言，很类似HTML
- XML的设计总之是传输数据，而非显示数据
- XML标签没有被预定义，需要自行定义标签
- XML被设计位具有自我描述性
- XML是W3C的标准推荐
```

- XML的语法规则
```
XML标签对大小写敏感

XML必须正确嵌套

XML文档必须有根元素

XML的属性值须加引号

XML中空格会被保留
```

### 1.2 使用Java读取XML数据
```
package com.legend.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadXMLDemo {
    public static void main(String[] args){
        try {
            //DOM操作
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/com/legend/XML/Language.xml");

            //获取文档根元素
            Element root = document.getDocumentElement();
            //获取子节点下面的根节点
            NodeList list = root.getElementsByTagName("lan");
            System.out.println("cat="+root.getAttribute("cat"));
            for (int i = 0; i < list.getLength(); i++) {

                //父级类型转化为子级类型需要强转
                Element lan = (Element) list.item(i);
                System.out.println("============");
                System.out.println("id="+lan.getAttribute("id"));

                //子节点
                NodeList cList = lan.getChildNodes();
                for (int j = 0; j < cList.getLength(); j++) {
                    Node c = cList.item(j);
                    //过滤掉空格、换行
                    if (c instanceof Element){
                        System.out.println(c.getNodeName()+"="+c.getTextContent());
                    }
                }


                //处理方式慢
                //Element name = (Element) lan.getElementsByTagName("name").item(0);
                //System.out.println("name="+name.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321110625540-178382787.png)




### 1.3 使用Java创建XML数据
```
package com.legend.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

/**
 * 使用Java语言实现创建XML数据和输出XML数据
 */
public class CreateXMLDemo {
    public static void main(String[] args){
        try {
            //DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("Languages");
            root.setAttribute("cat","it");

            //父节点
            Element lan1 = document.createElement("lan");
            lan1.setAttribute("id","1");

            //子节点
            Element name1 = document.createElement("name");
            name1.setTextContent("Java");
            Element ide1 = document.createElement("ide");
            ide1.setTextContent("Eclipse");

            //父节点2
            Element lan2 = document.createElement("lan");
            lan2.setAttribute("id","2");

            //子节点
            Element name2 = document.createElement("name");
            name2.setTextContent("Swift");
            Element ide2 = document.createElement("ide");
            ide2.setTextContent("Xcode");

            //添加到父节点
            lan1.appendChild(name1);
            lan1.appendChild(ide1);
            lan2.appendChild(name2);
            lan2.appendChild(ide2);

            //添加到根节点
            root.appendChild(lan1);
            root.appendChild(lan2);


            //添加到document对象中
            document.appendChild(root);

            //--------------------------------------
            /**
             * 通过网络以字符串形式传递
             * 如何将XML数据转换成字符串
             */
            //创建一个转换工厂类
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            //可以将XML文档转化成其他格式
            Transformer transformer = transformerFactory.newTransformer();

            //StringWriter 转换为字符串
            StringWriter writer = new StringWriter();

            //第一个参数是Source,第二个参数是Result类型
            transformer.transform(new DOMSource(document),new StreamResult(writer));
            transformer.transform(new DOMSource(document),new StreamResult(new File("newXML.xml")));
            System.out.println(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

### 1.4 使用Dom4j操作XML数据
```
package com.legend.XML.DOM4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

public class TestDom4j {
    public static void main(String[] args){
        String str = "<root><one>wwww</one><two>two</two></root>";
        try {
            Document document = DocumentHelper.parseText(str);
            System.out.println(document.asXML());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}

```

## 2.Java中的JSON操作
### 2.1 JSON数据格式详解
- 定义
```
JavaScript对象表示法(JavaScript Object Notation)
```

- JSON是存储和交换文本信息的语法
```
JSON是轻量级的文本数据交换格式

JSON独立于语言和平台

JSON具有自我描述性,更易理解
```

- JSON与XML
```
类似于XML，比XML更小、更快、更容易解析。
```

- JSON特点
```
没有结束标签

更短

读写速度更快

使用数组

不使用保留字
```

- JSON语法
```
JSON语法是JavaScript对象表示法语法的子集。
	数据在名称/值对 中
	数据由逗号分隔
	花括号保存对象
	方括号保存数组


JSON值可以是
	数字(整数或浮点数)
	字符串(在双引号中)
	逻辑值(true或false)
	数组(在方括号中)
	对象(在花括号中)
	null
```

- 例子
```
{
	"firstName":"John",
	"lastName":"Doe"
}


//数组可包含多个对象
{
	"employees":[
		{"firstName":"John","lastName":"Doe"},
		{"firstName":"John2","lastName":"Doe2"},
		{"firstName":"John3","lastName":"Doe3"}
	]
}
```

### 2.2 使用Java读取去JSON数据
```
package com.legend.JSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

/**
 * @author Create By legend
 * @date 2019/3/21 11:29
 */
public class GsonTest {
    public static void main(String[] args){
        JsonParser parser = new JsonParser();
        try {
            JsonObject object = (JsonObject) parser.parse(new FileReader("src/com/legend/JSON/test.json"));
            System.out.println("="+object.get("cat"));//获取的是值所有的内容包括双引号

            System.out.println("cat="+object.get("cat").getAsString());
            System.out.println("pop="+object.get("pop").getAsBoolean());

            JsonArray array = object.getAsJsonArray("languages");
            for (int i = 0; i < array.size(); i++) {
                System.out.println("-----------");
                //System.out.println(array.get(i));
                System.out.println("id="+array.get(i).getAsJsonObject().get("id"));
                System.out.println("ide="+array.get(i).getAsJsonObject().get("ide"));
                System.out.println("name="+array.get(i).getAsJsonObject().get("name "));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321123930182-127972482.png)

### 2.3 使用Java创建JSON数据
 ![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321130222160-664455656.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321130327775-1732956273.png)



## 3.Java中的HTTP通信
### 3.1 使用Http的Get方式读取网络数据



### 3.2 使用Http的Post方式与网络交互通信

###3.3 使用HttpClient进行Get方式通信


### 3.4 使用HttpClient进行Post方式通信


## 4. Java中的Socket通信
### 4.1 Socket介绍
```
Socket 又称为"套接字",应用程序通常通过“套接字”向网络发出请求或者应答网络请求
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321144446138-50601746.png)

- Socket连接的建立过程
```
1.服务器监听

2.客户端发出请求

3.建立连接

4.通信
```

- Socket的特点
```
Socket基于TCP连接,数据传输有保障

Socket适用于建立长时间连接

Socket编成通常应用于即时通讯
```

### 4.2 ServerSocket的建立与使用
```
ServerSocket serverSocket = new ServerSocket(12348);
            //监听端口--->阻塞block
            Socket socket = serverSocket.accept();
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321155519117-1269544939.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321155451477-338981417.png)

### 4.3 使用ServerSocket建立聊天服务器1

- ServerLinster
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321155719146-1093793802.png)

- ChatSocket
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321155817278-1885047483.png)

- MyServerSockerNew
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321155904717-1375815604.png)

### 4.3 使用ServerSocket建立聊天服务器2