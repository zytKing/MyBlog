package com.zyt.blog.common.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message {
	private int code = Code.SUCCESS.ordinal();
	private List<Object> body = new ArrayList<>();
	private Map<String, Object> mgs = new HashMap<>();
	private Object des;
	
	 public void add(Object o){
	        body.add(o);
	    }

	    public void put(String key,Object o){
	        mgs.put(key,o);
	    }

	    public int getCode() {
	        return code;
	    }

	    public void setCode(int code) {
	        this.code = code;
	    }

	    public List<Object> getBody() {
	        return body;
	    }

	    public void setBody(List<Object> body) {
	        this.body = body;
	    }

	    public Map<String, Object> getMgs() {
	        return mgs;
	    }

	    public void setMgs(Map<String, Object> mgs) {
	        this.mgs = mgs;
	    }

	    public Object getDes() {
			return des;
		}

		public void setDes(Object des) {
			this.des = des;
		}

		public static enum Code{
	        SUCCESS,ERROR
	    }
}
