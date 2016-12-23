package com.yezhangxin.context;

import org.w3c.dom.Node;

import com.yezhangxin.proxy.Reflection;



public class XmlContext extends ClassPathXmlApplicationContext{
	protected ParamComponent paramComponent;
	public XmlContext(String xmlFileName) {
		super(xmlFileName);
	}
	
	@Override
	public Object getBean(String beanId) {
		try {
			paramComponent=createParamComponentById(beanId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paramComponent.newInstance();
	}

	private ParamComponent createParamComponentById(String beanId) throws Exception{
		Node bean = xmlDocument.getElementById(beanId);
		parseParams(bean);
		findParamsClassName();
		if (isNonParams()) {
			paramComponent = new NonDILeaf();
			paramComponent.setBeanId(beanId);
			paramComponent.setClassName(getClassName(bean));
		} else {
			paramComponent=new DIComposite();
			paramComponent.setBeanId(beanId);
			paramComponent.setClassName(getClassName(bean));
			paramComponent.setConDIParams(constructDIParams);
			paramComponent.setPropDIParams(setterDIParams);
			paramComponent.setDIType(classType);
			for(ConstructorArg c:constructDIParams){
				XmlContext tContext=new XmlContext(xmlFileName);
				ParamComponent tParamComponent=tContext.createParamComponentById(c.ref);
				tParamComponent.setDIType(ConstructorArg.class);
				paramComponent.addParamNode(tParamComponent);
			}
			for(PropertyArg p:setterDIParams){
				XmlContext tContext=new XmlContext(xmlFileName);
				ParamComponent tParamComponent=tContext.createParamComponentById(p.ref);
				tParamComponent.setDIType(PropertyArg.class);
				paramComponent.addParamNode(tParamComponent);
			}
		}
		return paramComponent;
	}

}
