package com.text;

public class ConstructorDI {
	private Two two;
	public ConstructorDI() {
		super();
		System.out.println("����ʵ��");
	}
	public ConstructorDI(Two two) {
		super();
		this.two = two;
		System.out.println("��:"+two.getClass()+" ����ע��: "+this.getClass());
	}

}
