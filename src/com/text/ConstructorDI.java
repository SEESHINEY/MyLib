package com.text;

public class ConstructorDI {
	private Two two;
	public ConstructorDI() {
		super();
		System.out.println("构造实例");
	}
	public ConstructorDI(Two two) {
		super();
		this.two = two;
		System.out.println("类:"+two.getClass()+" 构造注入: "+this.getClass());
	}

}
