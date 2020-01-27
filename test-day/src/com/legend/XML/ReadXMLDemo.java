package com.legend.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Java读取XML文件
 */
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
