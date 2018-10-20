package com.zyt.blog.sso.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyt.blog.common.utils.CookieUtils;
import com.zyt.blog.common.utils.JsonUtils;
import com.zyt.blog.common.vo.Message;
import com.zyt.blog.sso.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Message login(String username,String password,HttpServletRequest request,HttpServletResponse response){
		Message message = userService.login(username, password);
		System.out.println("con:"+message.getCode());
		if(message.getCode() == 0){
			CookieUtils.setCookie(request, response, "TOKEN_KEY", message.getDes().toString());
		}
		return message;
	}
	
	@RequestMapping(value="/token/{token}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String get(@PathVariable String token,String callback){
		Message message = userService.getUserByToken(token);
		if(StringUtils.isNotBlank(callback)){
			return callback + "("+JsonUtils.objectToJson(message)+");";
		}
		return JsonUtils.objectToJson(message);
	}
	
	@RequestMapping("/pagelogin")
	public String page(){
		return "login.html";
	}
}
               