package com.yezhangxin.utils.xml;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlDom implements XmlDocument {
	private String fileName;
	private Document document;

	public XmlDom(String fileName) {
		super();
		this.fileName = fileName;
		parseXml();
	}

	private void parseXml() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbf.newDocumentBuilder();
			document = dBuilder.parse(fileName);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Node getElementById(String idString) throws Exception {
		NodeList beansList = document.getElementsByTagName("beans");
		NodeList beanList = beansList.item(0).getChildNodes();
		for (int i = 0; i < beanList.getLength(); i++) {
			Node bean = beanList.item(i);
			if (bean != null) {
				NamedNodeMap name = bean.getAttributes();
				if (name != null) {
					for (int j = 0; j < name.getLength(); j++) {
						Node node = name.item(j);
						if (node != null) {
							String nodeName = node.getNodeName();
							String nodeValue = node.getTextContent();
							if (nodeName == "id" && nodeValue.equals(idString)) {
								return bean;
							}
						}

					}
				}
			}

		}
		throw new Exception("Can't find node with id:" + idString);
	}
}
