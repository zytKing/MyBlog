package com.zyt.blog.front.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyt.blog.common.redis.JedisClient;
import com.zyt.blog.front.dao.BlogFrontDao;
import com.zyt.blog.front.dao.BlogTypeFrontDao;
import com.zyt.blog.front.pojo.BlogContent;
import com.zyt.blog.front.pojo.BlogType;
import com.zyt.blog.front.service.BlogFrontService;
import com.zyt.blog.utils.JsonUtils;

@Service
public class BlogFrontServiceImpl implements BlogFrontService {
	
	@Autowired
	private BlogFrontDao blogFrontDao;
	
	@Autowired
	private BlogTypeFrontDao blogTypeFrontDao;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${BLOG}")
	private String BLOG;
	
	@Value("${BLOGTYPE}")
	private String BLOGTYPE; 
	
	@Override
	public PageInfo<BlogContent> findBlogByPage(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<BlogContent> list = blogFrontDao.selectBlogByPage();
		for (BlogContent blogContent : list) {
			Date date = blogContent.getDATE();
			BlogType blogType = blogTypeFrontDao.selectBlogTypeById(blogContent.getTYPE_ID());
			blogContent.setBlogType(blogType);
		}
		PageInfo<BlogContent> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<BlogType> findBlogTypeAll() {
		try {
			String json = jedisClient.hget(BLOGTYPE, "BlogTypeList");
			if(StringUtils.isNotBlank(json)){
				List<BlogType> list = JsonUtils.jsonToList(json, BlogType.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<BlogType> list = blogTypeFrontDao.selectBlogTypeAll();
		try {
			jedisClient.hset(BLOGTYPE, "BlogTypeList", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public PageInfo<BlogContent> findBlogByType(Integer page, Integer rows, Integer typeId) {
		PageHelper.startPage(page, rows);
		List<BlogContent> list = blogFrontDao.selectBlogByTypeId(typeId);
		for (BlogContent blogContent : list) {
			Date date = blogContent.getDATE();
			BlogType blogType = blogTypeFrontDao.selectBlogTypeById(blogContent.getTYPE_ID());
			blogContent.setBlogType(blogType);
		}
		PageInfo<BlogContent> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public BlogContent findBlogById(String id) {
		try {
			String json = jedisClient.hget(BLOG, "Blog"+id);
			if(StringUtils.isNotBlank(json)){
				BlogContent blog = JsonUtils.jsonToPojo(json, BlogContent.class);
				return blog;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BlogContent blog = blogFrontDao.selectBlogById(id);
		try {
			jedisClient.hset(BLOG, "Blog"+id, JsonUtils.objectToJson(blog));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blog;
	}

}
