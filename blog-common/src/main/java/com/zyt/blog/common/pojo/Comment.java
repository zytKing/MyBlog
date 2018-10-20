package com.zyt.blog.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{
	private long ID;
	private long P_ID;
	private boolean DEL_FALG;
	private long BLOG_CONTENT_ID;
	private String NAME;
	private String CONTENT;
	private Date DATE;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public long getP_ID() {
		return P_ID;
	}
	public void setP_ID(long p_ID) {
		P_ID = p_ID;
	}
	public boolean isDEL_FALG() {
		return DEL_FALG;
	}
	public void setDEL_FALG(boolean dEL_FALG) {
		DEL_FALG = dEL_FALG;
	}
	public long getBLOG_CONTENT_ID() {
		return BLOG_CONTENT_ID;
	}
	public void setBLOG_CONTENT_ID(long bLOG_CONTENT_ID) {
		BLOG_CONTENT_ID = bLOG_CONTENT_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date dATE) {
		DATE = dATE;
	}
	@Override
	public String toString() {
		return "Comment [ID=" + ID + ", P_ID=" + P_ID + ", DEL_FALG=" + DEL_FALG + ", BLOG_CONTENT_ID="
				+ BLOG_CONTENT_ID + ", NAME=" + NAME + ", CONTENT=" + CONTENT + ", DATE=" + DATE + "]";
	}
	
}
