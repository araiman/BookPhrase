package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by RyomaArai on 15/04/05.
 */
public class Employees {
    public static void main(String[] args) throws Exception{
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("employees.xml"));

        // ルート要素を取得
        Node node = document.getDocumentElement();

        //　1階層下の、要素を、順番に探る。
        Node childNode = node.getFirstChild();
        Node nextChildNode = childNode.getNextSibling();
        Node thirdChildNode = nextChildNode.getNextSibling();
        Node fourthChildNode = thirdChildNode.getNextSibling();
        Node fifthChildNode = fourthChildNode.getNextSibling();
        Node sixthChildNode = fifthChildNode.getNextSibling();

        System.out.println(nextChildNode.getNodeName());
        System.out.println(thirdChildNode.getNodeName());
        System.out.println(fourthChildNode.getNodeName());
        System.out.println(fifthChildNode.getNodeName());
        System.out.println(sixthChildNode.getNodeName());
    }
}
