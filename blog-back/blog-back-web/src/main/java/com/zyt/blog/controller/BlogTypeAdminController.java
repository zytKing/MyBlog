package com.zyt.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyt.blog.pojo.BlogType;
import com.zyt.blog.service.BlogTypeService;
import com.zyt.blog.vo.EasyUIDataGridResult;
import com.zyt.blog.common.vo.Message;

/**
 * 博客分类控制层
 * @author Think
 *
 */
@RestController
@RequestMapping("/blogType")
public class BlogTypeAdminController {
	@Autowired 
	private BlogTypeService blogTypeService;
	
	@Autowired
	private Message message;
	/*
	 * 分类列表
	 */
	@RequestMapping("/list")
	public EasyUIDataGridResult showBlogTypeList(Integer page,Integer rows){
		EasyUIDataGridResult list = blogTypeService.getBlogTypeList(page, rows);
		return list;
	}
	/*
	 * 获取select中的分类
	 */
	@RequestMapping("/sList")
	public Message showBlogTypeSelect(){
		List<BlogType> list = blogTypeService.getBlogTypeSelect();
		message.setDes(list);
		return message;
	}
	/*
	 * 添加分类
	 */
	@RequestMapping(value="/addBlogType",method=RequestMethod.POST)
	public Message addBlogType(String TYPENAME){
		boolean b = blogTypeService.addBlogType(TYPENAME);
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
	/*
	 * 修改分类
	 */
	@RequestMapping(value="/editBlogType",method=RequestMethod.PUT)
	public Message editBlogType(BlogType bt){
		boolean b = blogTypeService.editBlogType(bt);
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
	/*
	 * 删除分类
	 */
	@RequestMapping(value="/deleteBlogType",method=RequestMethod.DELETE)
	public Message deleteBlogType(String ID){
		boolean b = blogTypeService.deleteBlogType(ID);
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
	
	
}
