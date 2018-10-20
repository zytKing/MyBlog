package com.zyt.blog.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyt.blog.common.redis.JedisClient;
import com.zyt.blog.dao.BlogDao;
import com.zyt.blog.pojo.BlogContent;
import com.zyt.blog.service.BlogService;
import com.zyt.blog.utils.IDUtils;
import com.zyt.blog.utils.JsonUtils;
import com.zyt.blog.vo.EasyUIDataGridResult;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;

	@Value("BLOG")
	private String BLOG;

	@Autowired
	private JedisClient jedisClient;

	@Override
	public EasyUIDataGridResult getBlogList(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<BlogContent> list = blogDao.selectBlogList();
		PageInfo<BlogContent> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public boolean saveBlog(BlogContent content) {
		content.setID(IDUtils.genItemId());
		content.setDEL_FLAG(true);
		content.setDATE(new Date());
		System.out.println(content);
		int i = blogDao.saveBlogContent(content);
		if (i != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBlog(BlogContent content) {
		int i = blogDao.updateBlogContent(content);
		if (i != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean publishBlogByID(String id) {
		int i = blogDao.updateBlogPublishById(id);
		if (i != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBlogByID(String id) {
		int i = blogDao.delFlagBlogById(id);
		if (i != 0) {
			return true;
		}
		return false;
	}

	@Override
	public BlogContent findBlogById(String id) {
		try {
			String json = jedisClient.hget(BLOG, "Blog" + id);
			if(StringUtils.isNotBlank(json)){
				BlogContent blogContent = JsonUtils.jsonToPojo(json, BlogContent.class);
				return blogContent;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BlogContent blogContent = blogDao.selectBlogById(id);
		try {
			jedisClient.hset(BLOG, "Blog" + id, JsonUtils.objectToJson(blogContent));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blogContent;
	}

}
