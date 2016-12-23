package com.text;

public class Foo {
	private ConstructorDI constructorDI;
	private SetterDI setterDI;
	public Foo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Foo(ConstructorDI constructorDI) {
		super();
		this.constructorDI = constructorDI;
	}
	
	public void setSetterDI(SetterDI setterDI) {
		this.setterDI = setterDI;
		System.out.println("类:"+setterDI.getClass()+" 设值注入: "+this.getClass());
	}

	public void  print() {
		System.out.print("asdas");
	}
}
