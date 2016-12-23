package com.yezhangxin.context;

import java.util.List;
import java.util.Set;


public interface ParamComponent {
	public void addParamNode(ParamComponent node) throws Exception;
	public void setClassName(String className);
	public void setBeanId(String beanId);
	public String getClassName();
	public String getBeanId();
	public List<ParamComponent> getParamComponents() throws Exception;
	public void setConDIParams(Set arg) throws Exception;
	public void setPropDIParams(Set arg) throws Exception;
	public Object newInstance();
	public void setDIType(Class classType) throws Exception;
	public Class getDIType();
}
