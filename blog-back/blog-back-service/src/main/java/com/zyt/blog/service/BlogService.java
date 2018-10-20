package com.zyt.blog.service;

import com.zyt.blog.pojo.BlogContent;
import com.zyt.blog.vo.EasyUIDataGridResult;

public interface BlogService {

	EasyUIDataGridResult getBlogList(int page,int rows);

	boolean saveBlog(BlogContent content);

	boolean updateBlog(BlogContent content);

	boolean publishBlogByID(String id);

	boolean deleteBlogByID(String id);

	BlogContent findBlogById(String id);
	
}
