package com.zyt.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zyt.blog.common.pojo.User;
import com.zyt.blog.common.utils.CookieUtils;
import com.zyt.blog.common.vo.Message;
import com.zyt.blog.sso.service.UserService;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = CookieUtils.getCookieValue(request, "TOKEN_KEY");
		if(StringUtils.isBlank(token)){
			System.out.println("1::"+token);
			String requestURL = request.getRequestURL().toString();
			response.sendRedirect("http://localhost:8062/login.html");
			return false;
		}
		Message message = userService.getUserByToken(token);
		if(message.getCode() != 0){
			System.out.println("2::" + message.getCode());
			String requestURL = request.getRequestURL().toString();
			response.sendRedirect("http://localhost:8062/login.html");
			return false;
		}
		System.out.println("3");
		User user = (User) message.getDes();
		request.setAttribute("user", user);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
