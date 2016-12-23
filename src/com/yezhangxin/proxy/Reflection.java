package com.yezhangxin.proxy;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.yezhangxin.context.ConstructorArg;
import com.yezhangxin.context.PropertyArg;

public class Reflection {
	private static Set<ConstructorArg> constructDIParams = new HashSet<ConstructorArg>();
	private static Set<PropertyArg> setterDIParams = new HashSet<PropertyArg>();

	public static Object reflect(String className) {
		try {
			Object realObj = Class.forName(className).newInstance();
			return realObj;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	
	public static Object reflectByConstructor(String className, Object... objects) {
		try {
			Class class1=Class.forName(className);
			Class[] paramType=new Class[objects.length];
			for (int i = 0; i < objects.length; i++) {
				paramType[i]=objects[i].getClass();
			}
			return class1.getConstructor(paramType).newInstance(objects);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Object reflect(String className, Object... objects) {
		System.out.println(className);
		for (int i = 0; i < objects.length; i++) {
			Set set = (Set) objects[i];
			Iterator iterator = set.iterator();
			Object object = iterator.next();
			if (object.getClass().equals(ConstructorArg.class)) {
				constructDIParams = (Set<ConstructorArg>) objects[i];
			} else if (object.getClass().equals(PropertyArg.class)) {
				setterDIParams = (Set<PropertyArg>) objects[i];
			}
		}

		System.out.println(constructDIParams);
		System.out.println(setterDIParams);
		return construct(className);
//		return objects;

	}
	
	private static Object construct(String className) {
		try {
			Class class1 = Class.forName(className);
			Class[] constructParams = new Class[constructDIParams.size()];
			Object[] conObjects = new Object[constructDIParams.size()];
			Iterator<ConstructorArg> iterator=constructDIParams.iterator();
			int i=0;
			while (iterator.hasNext()) {
				ConstructorArg type = iterator.next();
				conObjects[i]=reflect(type.className);
				constructParams[i]=conObjects[i].getClass();
				i++;
			}
			return class1.getConstructor(constructParams).newInstance(conObjects);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
