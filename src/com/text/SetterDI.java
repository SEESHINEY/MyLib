package com.text;

public class SetterDI {
	private One one;

	public SetterDI(One one) {
		super();
		this.one = one;
		System.out.println("��:"+one.getClass()+" ����ע��: "+this.getClass());
	}
	
}
