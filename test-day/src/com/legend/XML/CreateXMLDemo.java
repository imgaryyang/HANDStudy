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
