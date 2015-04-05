package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class HelloWorld {

    public static void main(String[] args) throws Exception{
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("helloWorld.xml"));

        // ルート要素を取得
        Node node = document.getDocumentElement();

        // ルート要素の内容を取得
        Node childNode = node.getFirstChild();

        System.out.println(node);
        System.out.println(childNode);
    }
}
