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
		System.out.println("��:"+setterDI.getClass()+" ��ֵע��: "+this.getClass());
	}

	public void  print() {
		System.out.print("asdas");
	}
}
