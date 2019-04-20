# Java����ͨ��
## 1.Java�е�XML����
### 1.1XML���ݸ�ʽ
```
XML,������չ�������(Extensible Markup Language)����׼ͨ�ñ�����Ե��Ӽ���һ�����ڱ�ǵ����ļ�ʹ����нṹ�Եı�����ԡ�����������������ݡ������������ͣ���һ�������û����Լ��ı�����Խ��ж����Դ���ԡ����ǳ��ʺ���ά�����䣬�ṩͳһ�ķ����������ͽ���������Ӧ�ó����Ӧ�̵Ľṹ�����ݡ�
```

-����
```
- XML��һ�ֱ�����ԣ�������HTML
- XML�������֮�Ǵ������ݣ�������ʾ����
- XML��ǩû�б�Ԥ���壬��Ҫ���ж����ǩ
- XML�����λ��������������
- XML��W3C�ı�׼�Ƽ�
```

- XML���﷨����
```
XML��ǩ�Դ�Сд����

XML������ȷǶ��

XML�ĵ������и�Ԫ��

XML������ֵ�������

XML�пո�ᱻ����
```

### 1.2 ʹ��Java��ȡXML����
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
            //DOM����
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/com/legend/XML/Language.xml");

            //��ȡ�ĵ���Ԫ��
            Element root = document.getDocumentElement();
            //��ȡ�ӽڵ�����ĸ��ڵ�
            NodeList list = root.getElementsByTagName("lan");
            System.out.println("cat="+root.getAttribute("cat"));
            for (int i = 0; i < list.getLength(); i++) {

                //��������ת��Ϊ�Ӽ�������Ҫǿת
                Element lan = (Element) list.item(i);
                System.out.println("============");
                System.out.println("id="+lan.getAttribute("id"));

                //�ӽڵ�
                NodeList cList = lan.getChildNodes();
                for (int j = 0; j < cList.getLength(); j++) {
                    Node c = cList.item(j);
                    //���˵��ո񡢻���
                    if (c instanceof Element){
                        System.out.println(c.getNodeName()+"="+c.getTextContent());
                    }
                }


                //����ʽ��
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




### 1.3 ʹ��Java����XML����
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
 * ʹ��Java����ʵ�ִ���XML���ݺ����XML����
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

            //���ڵ�
            Element lan1 = document.createElement("lan");
            lan1.setAttribute("id","1");

            //�ӽڵ�
            Element name1 = document.createElement("name");
            name1.setTextContent("Java");
            Element ide1 = document.createElement("ide");
            ide1.setTextContent("Eclipse");

            //���ڵ�2
            Element lan2 = document.createElement("lan");
            lan2.setAttribute("id","2");

            //�ӽڵ�
            Element name2 = document.createElement("name");
            name2.setTextContent("Swift");
            Element ide2 = document.createElement("ide");
            ide2.setTextContent("Xcode");

            //��ӵ����ڵ�
            lan1.appendChild(name1);
            lan1.appendChild(ide1);
            lan2.appendChild(name2);
            lan2.appendChild(ide2);

            //��ӵ����ڵ�
            root.appendChild(lan1);
            root.appendChild(lan2);


            //��ӵ�document������
            document.appendChild(root);

            //--------------------------------------
            /**
             * ͨ���������ַ�����ʽ����
             * ��ν�XML����ת�����ַ���
             */
            //����һ��ת��������
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            //���Խ�XML�ĵ�ת����������ʽ
            Transformer transformer = transformerFactory.newTransformer();

            //StringWriter ת��Ϊ�ַ���
            StringWriter writer = new StringWriter();

            //��һ��������Source,�ڶ���������Result����
            transformer.transform(new DOMSource(document),new StreamResult(writer));
            transformer.transform(new DOMSource(document),new StreamResult(new File("newXML.xml")));
            System.out.println(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

### 1.4 ʹ��Dom4j����XML����
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

## 2.Java�е�JSON����
### 2.1 JSON���ݸ�ʽ���
- ����
```
JavaScript�����ʾ��(JavaScript Object Notation)
```

- JSON�Ǵ洢�ͽ����ı���Ϣ���﷨
```
JSON�����������ı����ݽ�����ʽ

JSON���������Ժ�ƽ̨

JSON��������������,�������
```

- JSON��XML
```
������XML����XML��С�����졢�����׽�����
```

- JSON�ص�
```
û�н�����ǩ

����

��д�ٶȸ���

ʹ������

��ʹ�ñ�����
```

- JSON�﷨
```
JSON�﷨��JavaScript�����ʾ���﷨���Ӽ���
	����������/ֵ�� ��
	�����ɶ��ŷָ�
	�����ű������
	�����ű�������


JSONֵ������
	����(�����򸡵���)
	�ַ���(��˫������)
	�߼�ֵ(true��false)
	����(�ڷ�������)
	����(�ڻ�������)
	null
```

- ����
```
{
	"firstName":"John",
	"lastName":"Doe"
}


//����ɰ����������
{
	"employees":[
		{"firstName":"John","lastName":"Doe"},
		{"firstName":"John2","lastName":"Doe2"},
		{"firstName":"John3","lastName":"Doe3"}
	]
}
```

### 2.2 ʹ��Java��ȡȥJSON����
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
            System.out.println("="+object.get("cat"));//��ȡ����ֵ���е����ݰ���˫����

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

### 2.3 ʹ��Java����JSON����
 ![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321130222160-664455656.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321130327775-1732956273.png)



## 3.Java�е�HTTPͨ��
### 3.1 ʹ��Http��Get��ʽ��ȡ��������



### 3.2 ʹ��Http��Post��ʽ�����罻��ͨ��

###3.3 ʹ��HttpClient����Get��ʽͨ��


### 3.4 ʹ��HttpClient����Post��ʽͨ��


## 4. Java�е�Socketͨ��
### 4.1 Socket����
```
Socket �ֳ�Ϊ"�׽���",Ӧ�ó���ͨ��ͨ�����׽��֡������緢���������Ӧ����������
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321144446138-50601746.png)

- Socket���ӵĽ�������
```
1.����������

2.�ͻ��˷�������

3.��������

4.ͨ��
```

- Socket���ص�
```
Socket����TCP����,���ݴ����б���

Socket�����ڽ�����ʱ������

Socket���ͨ��Ӧ���ڼ�ʱͨѶ
```

### 4.2 ServerSocket�Ľ�����ʹ��
```
ServerSocket serverSocket = new ServerSocket(12348);
            //�����˿�--->����block
            Socket socket = serverSocket.accept();
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321155519117-1269544939.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321155451477-338981417.png)

### 4.3 ʹ��ServerSocket�������������1

- ServerLinster
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321155719146-1093793802.png)

- ChatSocket
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321155817278-1885047483.png)

- MyServerSockerNew
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321155904717-1375815604.png)

### 4.3 ʹ��ServerSocket�������������2