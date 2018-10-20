package com.zyt.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyt.blog.common.vo.Message;
import com.zyt.blog.pojo.BlogContent;
import com.zyt.blog.service.BlogService;
import com.zyt.blog.vo.EasyUIDataGridResult;

/**
 * 后台博客控制层
 * @author Think
 *
 */
@RestController
@RequestMapping("/blog")
public class BlogAdminController {
	
	@Autowired 
	private BlogService blogService;
	
	@Autowired
	private Message message;
	/*
	 * 博客列表
	 */
	@RequestMapping("/list")
	public EasyUIDataGridResult showBlogList(Integer page, Integer rows){
		EasyUIDataGridResult list = blogService.getBlogList(page, rows); 
		return list;
	}
	/*
	 * 根据id查询博客
	 */
	@RequestMapping(value="/findBlog/{id}",method=RequestMethod.GET)
	public Message showBlogById(@PathVariable("id") String id){
		System.out.println(id);
		BlogContent content = blogService.findBlogById(id);
		message.setDes(content);
		System.out.println(message.getCode());
		return message;
	}
	
	/*
	 * 添加博客
	 */
	@RequestMapping("/saveBlog")
	public Message saveBlog(BlogContent content){
		boolean	b = blogService.saveBlog(content);
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
	
	/*
	 * 修改博客
	 */ 
	@RequestMapping(value="/updateBlog",method=RequestMethod.PUT)
	public Message updateBlog(BlogContent content){
		System.out.println(content);
		boolean b = blogService.updateBlog(content); 
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
	/*
	 * 发布博客
	 */
	@RequestMapping("/publishBlog")
	public Message publishBlog(String id){
		boolean b = blogService.publishBlogByID(id);
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
	/*
	 * 删除博客 
	 */
	@RequestMapping(value="/deleteBlog",method=RequestMethod.DELETE)
	public Message deleteBlog(String id){
		boolean b = blogService.deleteBlogByID(id);
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
	
	
	
}
