package com.zyt.blog.front.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zyt.blog.front.pojo.BlogContent;
import com.zyt.blog.front.pojo.BlogType;

public interface BlogFrontService {
	PageInfo<BlogContent> findBlogByPage(Integer page, Integer rows);

	List<BlogType> findBlogTypeAll();

	PageInfo<BlogContent> findBlogByType(Integer page, Integer rows, Integer typeId);

	BlogContent findBlogById(String id);
}
