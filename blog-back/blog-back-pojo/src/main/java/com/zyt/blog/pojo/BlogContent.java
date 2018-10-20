package com.zyt.blog.pojo;

import java.io.Serializable;
import java.util.Date;




public class BlogContent implements Serializable{
	private long ID;
	private boolean DEL_FLAG;
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date DATE;
	private String DIGEST;
	private String TITLE;
	private String CONTENT;
	private Integer TYPE_ID;
	private boolean PUBLISH;
	private String KEY_WORD;
	private BlogType blogType;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public boolean isDEL_FLAG() {
		return DEL_FLAG;
	}
	public void setDEL_FLAG(boolean dEL_FLAG) {
		DEL_FLAG = dEL_FLAG;
	}
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date dATE) {
		DATE = dATE;
	}
	public String getDIGEST() {
		return DIGEST;
	}
	public void setDIGEST(String dIGEST) {
		DIGEST = dIGEST;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public Integer getTYPE_ID() {
		return TYPE_ID;
	}
	public void setTYPE_ID(Integer tYPE_ID) {
		TYPE_ID = tYPE_ID;
	}
	public boolean isPUBLISH() {
		return PUBLISH;
	}
	public void setPUBLISH(boolean pUBLISH) {
		PUBLISH = pUBLISH;
	}
	public String getKEY_WORD() {
		return KEY_WORD;
	}
	public void setKEY_WORD(String kEY_WORD) {
		KEY_WORD = kEY_WORD;
	}
	public BlogType getBlogType() {
		return blogType;
	}
	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}
	@Override
	public String toString() {
		return "BlogContent [ID=" + ID + ", DEL_FLAG=" + DEL_FLAG + ", DATE=" + DATE + ", DIGEST=" + DIGEST + ", TITLE="
				+ TITLE + ", CONTENT=" + CONTENT + ", TYPE_ID=" + TYPE_ID + ", PUBLISH=" + PUBLISH + ", KEY_WORD="
				+ KEY_WORD + ", blogType=" + blogType + "]";
	}
	
}
