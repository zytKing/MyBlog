package com.zyt.blog.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyt.blog.common.redis.JedisClient;
import com.zyt.blog.dao.BlogTypeDao;
import com.zyt.blog.pojo.BlogType;
import com.zyt.blog.service.BlogTypeService;
import com.zyt.blog.utils.JsonUtils;
import com.zyt.blog.vo.EasyUIDataGridResult;

@Service
public class BlogTypeServiceImpl implements BlogTypeService {
	
	@Autowired
	private BlogTypeDao blogTypeDao;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${BLOGTYPE}")
	private String BLOGTYPE; 
	
	@Override
	public EasyUIDataGridResult getBlogTypeList(int page, int rows) {
		PageHelper.startPage(page, rows);
		try{
			String json = jedisClient.hget(BLOGTYPE, "BlogTypeList");
			if(StringUtils.isNotBlank(json)){
				List<BlogType> list = JsonUtils.jsonToList(json, BlogType.class);
				PageInfo<BlogType> pageInfo = new PageInfo<>(list);
				EasyUIDataGridResult result = new EasyUIDataGridResult();
				result.setRows(list);
				result.setTotal(pageInfo.getTotal());
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		List<BlogType> list = blogTypeDao.selectBlogTypeList();
		
		try {
			jedisClient.hset(BLOGTYPE, "BlogTypeList", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageInfo<BlogType> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public List<BlogType> getBlogTypeSelect() {
		//先查询缓存
		try{
			String json = jedisClient.hget(BLOGTYPE, "BlogTypeList");
			if(StringUtils.isNotBlank(json)){
				List<BlogType> list = JsonUtils.jsonToList(json, BlogType.class);
				return list;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		List<BlogType> list = blogTypeDao.selectBlogTypeList();
		//存入缓存
		try{
			jedisClient.hset(BLOGTYPE, "BlogTypeList", JsonUtils.objectToJson(list));
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addBlogType(String TYPENAME) {
		BlogType bt = blogTypeDao.selectBlogTypeByName(TYPENAME);
		if(bt == null){
			int i = blogTypeDao.saveBlogType(TYPENAME);
			if(i != 0){
				String  message = "保存博客类型:BlogTypeList";
				rabbitTemplate.convertAndSend("BlogType.save", message);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean editBlogType(BlogType bt) {
		int i = blogTypeDao.updateBlogType(bt);
		if(i != 0){
			String  message = "修改博客类型:BlogTypeList";
			rabbitTemplate.convertAndSend("BlogType.update", message);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBlogType(String iD) {
		int i = blogTypeDao.updateBlogTypeByID(iD);
		if(i != 0){
			String  message = "删除博客类型:BlogTypeList";
			rabbitTemplate.convertAndSend("BlogType.delete", message);
			return true;
		}
		return false;
	}

}
