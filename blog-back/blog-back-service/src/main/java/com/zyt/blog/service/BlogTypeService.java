package com.zyt.blog.service;

import java.util.List;

import com.zyt.blog.pojo.BlogType;
import com.zyt.blog.vo.EasyUIDataGridResult;

public interface BlogTypeService {
	//获取博客类型类表
	EasyUIDataGridResult getBlogTypeList(int page,int rows);

	List<BlogType> getBlogTypeSelect();

	boolean addBlogType(String TYPENAME);

	boolean editBlogType(BlogType bt);

	boolean deleteBlogType(String iD);

}
