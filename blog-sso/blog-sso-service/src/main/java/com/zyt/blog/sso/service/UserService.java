package com.zyt.blog.sso.service;

import com.zyt.blog.common.vo.Message;

public interface UserService {
	Message login(String loginname,String password);
	Message getUserByToken(String token);
}
