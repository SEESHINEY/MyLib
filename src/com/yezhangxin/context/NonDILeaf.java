package com.yezhangxin.context;

import java.util.List;
import java.util.Set;

import com.yezhangxin.proxy.Reflection;

public class NonDILeaf extends AbsParamComponent {
	private Class classDIType;
	public void addParamNode(ParamComponent node) throws Exception {
		throw new Exception(getNodeDesc() + "is a leaf-node");
	}

	public void setConDIParams(Set arg) throws Exception {
		throw new Exception(getNodeDesc()
				+ "have not a Construct Dependence Injection parameter");
	}

	public void setPropDIParams(Set arg) throws Exception {
		throw new Exception(getNodeDesc()
				+ "have not a Setter Dependence Injection parameter");
	}

	public Object newInstance() {
		return Reflection.reflect(getClassName());
	}

	public List<ParamComponent> getParamComponents() throws Exception {
		throw new Exception(getNodeDesc() + "have only a non-parameter constructor");
	}

	public void setDIType(Class classType) throws Exception {
		this.classDIType = classType;
	}

	public Class getDIType(){
		return classDIType;
	}

}
