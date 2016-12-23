package com.yezhangxin.context;



public abstract class AbsParamComponent implements ParamComponent {
	private String className;
	private String beanId;
	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public String getBeanId() {
		return beanId;
	}

	protected String getNodeDesc() {
		return "bean:" + getBeanId() + " which reference is class "
				+ getClassName();
	}

}
