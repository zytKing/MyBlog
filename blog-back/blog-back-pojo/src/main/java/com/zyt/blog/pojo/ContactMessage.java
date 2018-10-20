package com.zyt.blog.pojo;

import java.io.Serializable;

public class ContactMessage implements Serializable{
	private long ID;
	private String NAME;
	private String TITLE;
	private String EMAIL;
	private String CONTENT;
	private boolean DEL_FLAG;
	private boolean READ;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public boolean isDEL_FLAG() {
		return DEL_FLAG;
	}
	public void setDEL_FLAG(boolean dEL_FLAG) {
		DEL_FLAG = dEL_FLAG;
	}
	public boolean isREAD() {
		return READ;
	}
	public void setREAD(boolean rEAD) {
		READ = rEAD;
	}
	@Override
	public String toString() {
		return "ContentMessage [ID=" + ID + ", NAME=" + NAME + ", TITLE=" + TITLE + ", EMAIL=" + EMAIL + ", CONTENT="
				+ CONTENT + ", DEL_FLAG=" + DEL_FLAG + ", READ=" + READ + "]";
	}
}
