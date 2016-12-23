package com.text;

public class SetterDI {
	private One one;

	public SetterDI(One one) {
		super();
		this.one = one;
		System.out.println("类:"+one.getClass()+" 构造注入: "+this.getClass());
	}
	
}
