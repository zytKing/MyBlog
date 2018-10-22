package com.zyt.blog.sso.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.zyt.blog.common.pojo.User;
import com.zyt.blog.common.redis.JedisClient;
import com.zyt.blog.common.utils.JsonUtils;
import com.zyt.blog.common.vo.Message;
import com.zyt.blog.dao.UserDao;
import com.zyt.blog.sso.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private JedisClient jedisClient;
	
	@Override
	public Message login(String loginname, String password) {
		Message message = new Message();
		System.out.println("ss:"+message.getCode());
		List<User> list = userDao.selectUserByName(loginname);
		if(list == null || list.size() == 0){
			message.setCode(Message.Code.ERROR.ordinal());;
			return message;
		}
		User user = list.get(0);
		if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPASSWORD())){
			message.setCode(Message.Code.ERROR.ordinal());;
			return message;
		}
		
		String token = UUID.randomUUID().toString();
		System.out.println(token);
		user.setPASSWORD(null);
		jedisClient.set("USER_SESSION:"+token, JsonUtils.objectToJson(user));
		jedisClient.expire("USER_SESSION:"+token, 1800);
		message.put("name", loginname);
		message.setDes(token);
		System.out.println(message.getCode());
		return message;
	}

	@Override
	public Message getUserByToken(String token) {
		Message message = new Message();
		String json = jedisClient.get("USER_SESSION:"+token);	
		if(StringUtils.isBlank(json)){
			message.setCode(Message.Code.ERROR.ordinal());
			return message;
		}
		jedisClient.expire("USER_SESSION:"+token, 1800);
		User user = JsonUtils.jsonToPojo(json, User.class);
		message.setDes(user);
		return message;
	}
	

}
