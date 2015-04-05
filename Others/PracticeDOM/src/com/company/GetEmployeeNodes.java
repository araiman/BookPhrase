package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by RyomaArai on 15/04/05.
 */
public class GetEmployeeNodes {
    public static void main(String[] args) throws Exception{
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("employees.xml"));

        // ルート要素を取得
        Node node = document.getDocumentElement();

        NodeList childNodes = node.getChildNodes();
        System.out.println(childNodes.getLength());

        for(int i=0; i < childNodes.getLength(); i++) {
            Node childChildNode = childNodes.item(i);
            System.out.println(childChildNode.getNodeName());
        }
    }
}
