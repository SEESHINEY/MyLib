package com.yezhangxin.context;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class DIComposite extends AbsParamComponent {
	private Set<ConstructorArg> constructDIParams = new HashSet<ConstructorArg>();
	private Set<PropertyArg> setterDIParams = new HashSet<PropertyArg>();
	private List<ParamComponent> paramComponents = new ArrayList<ParamComponent>();
	private Class classDIType;

	public void addParamNode(ParamComponent node) {
		paramComponents.add(node);
	}

	public void setConDIParams(Set arg) {
		constructDIParams= arg;
	}

	public void setPropDIParams(Set arg) {
		setterDIParams=arg;
	}

	public Object newInstance() {
		try {
			Object[] con = new Object[constructDIParams.size()];
			Object[] pro = new Object[setterDIParams.size()];
			int c=0,p=0;
	
			for (int i = 0; i < paramComponents.size(); i++) {
				if (paramComponents.get(i).getDIType().equals(ConstructorArg.class)) {
					con[c++]=paramComponents.get(i).newInstance();
				}else if (paramComponents.get(i).getDIType().equals(PropertyArg.class)) {
					pro[p++]=paramComponents.get(i).newInstance();
				}
			}
			
			Class class1=Class.forName(getClassName());
			Class[] conParamType=new Class[con.length];
			for (int i = 0; i < con.length; i++) {
				conParamType[i]=con[i].getClass();
			}
			Object object=class1.getConstructor(conParamType).newInstance(con);

			
			Iterator<PropertyArg> iterator=setterDIParams.iterator();
			int i=0;
			while (iterator.hasNext()) {
				PropertyArg type = iterator.next();
				char[] arr=type.setterName.toCharArray();
				arr[0]-=32;
				String mN=String.valueOf(arr);
				Method method=class1.getMethod("set"+mN, pro[i].getClass());
				method.invoke(object, pro[i]);
				i++;
			}
			return object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	

	public List<ParamComponent> getParamComponents() throws Exception {
		return paramComponents;
	}

	public void setDIType(Class classType) throws Exception {
		this.classDIType = classType;
	}

	public Class getDIType(){
		return classDIType;
	}

}
