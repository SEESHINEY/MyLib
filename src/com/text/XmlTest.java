package com.text;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yezhangxin.beans.factory.BeanFactory;
import com.yezhangxin.context.ClassPathXmlApplicationContext;
import com.yezhangxin.context.XmlContext;


public class XmlTest {
	BeanFactory context=new XmlContext("src/config.xml");
	@Test
	public void testParseXml() {
		Foo foo=(Foo) context.getBean("foo");
		foo.print();
	}

}
