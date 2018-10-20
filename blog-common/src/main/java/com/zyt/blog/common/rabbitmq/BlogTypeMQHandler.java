package com.zyt.blog.common.rabbitmq;

import com.zyt.blog.common.redis.JedisClient;

public class BlogTypeMQHandler {
	
	private JedisClient jedisClient;
	public JedisClient getJedisClient() {
		return jedisClient;
	}
	public void setJedisClient(JedisClient jedisClient) {
		this.jedisClient = jedisClient;
	}
	
	public void execute1(String msg){
		System.out.println("save_msg:" + msg);
		int index = msg.lastIndexOf(":");
		String key = msg.substring(index + 1);
		jedisClient.hdel("BLOGTYPE", key);
	}
	public void execute2(String msg){ 
		System.out.println("update_msg:" + msg);
		int index = msg.lastIndexOf(":");
		String key = msg.substring(index + 1);
		jedisClient.hdel("BLOGTYPE", key);
	}
	public void execute3(String msg){
		System.out.println("delete_msg:" + msg);
		int index = msg.lastIndexOf(":");
		String key = msg.substring(index + 1);
		jedisClient.hdel("BLOGTYPE", key);
	}
	
}
