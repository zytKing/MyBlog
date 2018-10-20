package com.zyt.blog.common.pojo;

import java.io.Serializable;

public class User implements Serializable{

	private long ID;
	private String LOGIN_NAME;
	private String PASSWORD;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getLOGIN_NAME() {
		return LOGIN_NAME;
	}
	public void setLOGIN_NAME(String lOGIN_NAME) {
		LOGIN_NAME = lOGIN_NAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", LOGIN_NAME=" + LOGIN_NAME + ", PASSWORD=" + PASSWORD + "]";
	}
}
