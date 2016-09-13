package com.airhacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author airhacks.com
 */
public class DOMHacksTest {

    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private Document indexHTML;

    @Before
    public void init() throws ParserConfigurationException, SAXException, IOException {
        this.documentBuilderFactory = DocumentBuilderFactory.newInstance();
        this.documentBuilder = this.documentBuilderFactory.newDocumentBuilder();
        this.indexHTML = this.documentBuilder.parse(new File("index.html"));
        indexHTML.getDocumentElement().normalize();
    }

    @Test
    public void parse() throws ParserConfigurationException, SAXException, IOException {
        System.out.println("Root element :" + indexHTML.getDocumentElement().getNodeName());
        NodeList nodeList = indexHTML.getElementsByTagName("body");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Element :" + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Id : " + element.getAttribute("id"));
                System.out.println("Div content : " + element.getElementsByTagName("div").item(0).getTextContent());
            }
        }
    }

    @Test
    public void javascript() throws ScriptException, FileNotFoundException {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");
        engine.put("document", this.indexHTML);
        engine.eval(new FileReader("ajax.js"));

    }

}
