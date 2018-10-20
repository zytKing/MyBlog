package com.zyt.blog.front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zyt.blog.common.vo.Message;
import com.zyt.blog.front.pojo.BlogContent;
import com.zyt.blog.front.pojo.BlogType;
import com.zyt.blog.front.service.BlogFrontService;

@RestController
@RequestMapping("/blogFront")
public class BlogFrontController {
	
	@Autowired
	private BlogFrontService blogFrontService;
	
	@Autowired
	private Message message;
	
	@RequestMapping("blogList")
	public Message showBlogList(Integer page, Integer rows){
		PageInfo<BlogContent> pageBean = blogFrontService.findBlogByPage(page,rows);
		message.setDes(pageBean);
		return message;
	}
	
	@RequestMapping("/blogType")
	public Message showBlogTypeList(){
		List<BlogType> list = blogFrontService.findBlogTypeAll(); 
		message.setDes(list);
		return message;
	}
	
	@RequestMapping("/blogTypeList")
	public Message showBlogListByType(Integer page, Integer rows,Integer typeId){
		PageInfo<BlogContent> pageBean = blogFrontService.findBlogByType(page, rows,typeId);
		message.setDes(pageBean);
		return message;
	}
	
	@RequestMapping("/blogById")
	public Message showBlogById(String id){
		System.out.println(id);
		BlogContent blog = blogFrontService.findBlogById(id);
		System.out.println(blog);
		message.setDes(blog);
		return message;
	}
}
