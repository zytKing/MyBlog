package com.zyt.blog.front.pojo;

import java.io.Serializable;

public class BlogType implements Serializable{
	private Integer ID;
	private String TYPENAME;
	private boolean DEL_FLAG;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getTYPENAME() {
		return TYPENAME;
	}
	public void setTYPENAME(String tYPENAME) {
		TYPENAME = tYPENAME;
	}
	public boolean isDEL_FLAG() {
		return DEL_FLAG;
	}
	public void setDEL_FLAG(boolean dEL_FLAG) {
		DEL_FLAG = dEL_FLAG;
	}
	@Override
	public String toString() {
		return "BlogType [ID=" + ID + ", TYPENAME=" + TYPENAME + ", DEL_FLAG=" + DEL_FLAG + "]";
	}
}
