package com.yezhangxin.context;

import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.yezhangxin.beans.factory.BeanFactory;
import com.yezhangxin.proxy.Reflection;
import com.yezhangxin.utils.xml.XmlDocument;
import com.yezhangxin.utils.xml.XmlDom;

public class ClassPathXmlApplicationContext implements BeanFactory {
	protected String xmlFileName;
	protected String className;
	protected Set<ConstructorArg> constructDIParams = new HashSet<ConstructorArg>();
	protected Set<PropertyArg> setterDIParams = new HashSet<PropertyArg>();
	protected static final String CONSTRUCTOR_TAG = "constructor-arg";
	protected static final String PROPERTY_TAG = "property";
	protected ConstructorArg constructorArg;
	protected PropertyArg propertyArg;
	protected XmlDocument xmlDocument;
	protected Class classType;
	public ClassPathXmlApplicationContext(String xmlFileName) {
		super();
		this.xmlFileName = xmlFileName;
		xmlDocument = new XmlDom(xmlFileName);
	}

	public Object getBean(String beanId) {
		try {
			Node node = xmlDocument.getElementById(beanId);
			String className = getClassName(node);
			parseParams(node);
			findParamsClassName();
			Object object;
			if (isNonParams()) {
				object = Reflection.reflect(className);
			} else {
				object = Reflection.reflect(className, constructDIParams,
						setterDIParams);
			}
			return object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected boolean isNonParams() {
		if (setterDIParams.size() == 0 && constructDIParams.size() == 0) {
			return true;
		}
		return false;
	}

	protected String getClassName(Node bean) throws Exception {

		if (bean != null) {
			NamedNodeMap name = bean.getAttributes();

			if (name != null) {
				for (int j = 0; j < name.getLength(); j++) {
					String nodeName = name.item(j).getNodeName();
					String nodeValue = name.item(j).getTextContent();

					if (nodeName == "class" && nodeValue != "") {

						return nodeValue;
					}

				}
			}
		}
		throw new Exception("ClassName is null");
	}

	protected void parseParams(Node bean) {
		if (bean != null) {
			NodeList paramList = bean.getChildNodes();
			parseNodeList(paramList);
		}
	}

	protected void parseNodeList(NodeList paramList) {
		for (int i = 0; i < paramList.getLength(); i++) {
			Node param = paramList.item(i);
			if (param != null) {
				parseNode(param);
			}
		}
	}

	protected void parseNode(Node param) {
		NamedNodeMap namedNodeMap = param.getAttributes();
		if (namedNodeMap != null) {
			String tag = param.getNodeName();
			initParamByTag(tag);
			parseNodeAttributes(tag, namedNodeMap);
			addToList();
		}
	}

	protected void initParamByTag(String tag) {
		constructorArg = null;
		propertyArg = null;
		if (tag == CONSTRUCTOR_TAG) {
			constructorArg = new ConstructorArg();
			classType=ConstructorArg.class;
		} else if (tag == PROPERTY_TAG) {
			propertyArg = new PropertyArg();
			classType=PropertyArg.class;
		}
	}

	protected void parseNodeAttributes(String tag, NamedNodeMap namedNodeMap) {
		for (int j = 0; j < namedNodeMap.getLength(); j++) {
			Node node = namedNodeMap.item(j);

			if (node != null) {
				String nodeName = node.getNodeName();
				String nodeValue = node.getTextContent();
				assignNodeValueToParamByTag(tag, nodeName, nodeValue);
			}
		}
	}

	protected void assignNodeValueToParamByTag(String tag, String nodeName,
			String nodeValue) {
		if (tag == CONSTRUCTOR_TAG) {
			constructorArg = new ConstructorArg();
			constructorArg.ref = nodeValue;
		} else if (tag == PROPERTY_TAG) {

			if (nodeName == "name") {

				propertyArg.setterName = nodeValue;
			} else if (nodeName == "ref") {
				propertyArg.ref = nodeValue;
			}

		}
	}

	protected void addToList() {
		if (constructorArg != null) {
			constructDIParams.add(constructorArg);
		} else if (propertyArg != null) {
			setterDIParams.add(propertyArg);
		}
	}

	protected void findParamsClassName() {
		try {
			for (ConstructorArg c : constructDIParams) {

				Node node = xmlDocument.getElementById(c.ref);
				c.className = getClassName(node);

			}
			for (PropertyArg p : setterDIParams) {
				Node node = xmlDocument.getElementById(p.ref);
				p.className = getClassName(node);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	
}
