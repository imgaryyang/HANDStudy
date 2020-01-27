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
