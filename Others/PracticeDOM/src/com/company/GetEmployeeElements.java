package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by RyomaArai on 15/04/05.
 */
public class GetEmployeeElements {
    public static void main(String[] args) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("employees.xml"));

        // ルート要素を取得
        Element rootElement = document.getDocumentElement();

        // employeesのリストを取得
        NodeList empNodes = rootElement.getElementsByTagName("employee");

        for (int i = 0; i < empNodes.getLength(); i++) {
            Element emp = (Element) empNodes.item(i);
            NodeList nameElements = emp.getElementsByTagName("name");
            System.out.println(nameElements.item(0).getFirstChild().getNodeValue());
        }
    }
}
