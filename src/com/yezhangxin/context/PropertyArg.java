package com.yezhangxin.context;

public class PropertyArg {
	String className;
	String setterName;
	String ref;
	@Override
	public String toString() {
		return "PropertyArg [className=" + className + ", setterName=" + setterName
				+ ", ref=" + ref + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		result = prime * result
				+ ((setterName == null) ? 0 : setterName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyArg other = (PropertyArg) obj;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (ref == null) {
			if (other.ref != null)
				return false;
		} else if (!ref.equals(other.ref))
			return false;
		if (setterName == null) {
			if (other.setterName != null)
				return false;
		} else if (!setterName.equals(other.setterName))
			return false;
		return true;
	}
	
}
