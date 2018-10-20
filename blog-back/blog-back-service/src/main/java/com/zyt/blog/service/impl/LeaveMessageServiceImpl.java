package com.zyt.blog.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyt.blog.common.pojo.Comment;
import com.zyt.blog.common.redis.JedisClient;
import com.zyt.blog.dao.LeaveMessageDao;
import com.zyt.blog.pojo.BlogContent;
import com.zyt.blog.pojo.ContactMessage;
import com.zyt.blog.service.LeaveMessageService;
import com.zyt.blog.utils.JsonUtils;
import com.zyt.blog.vo.EasyUIDataGridResult;

@Service
public class LeaveMessageServiceImpl implements LeaveMessageService {
	
	@Autowired
	private LeaveMessageDao leaveMessageDao;
	
	@Value("${LEAVEMESSAGE}")
	private String LEAVEMESSAGE;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Override
	public EasyUIDataGridResult getLeaveMessageList(Integer page,Integer rows) {
		PageHelper.startPage(page, rows);
		List<ContactMessage> list = leaveMessageDao.selectLeaveMessage();
		PageInfo<ContactMessage> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public boolean deleteContactMessageById(String iD) {
		int i = leaveMessageDao.UpdateContactMessageDelFlag(iD);
		if(i != 0){
			return true;
		}
		return false;
	}

	@Override
	public ContactMessage findContactMessageById(String id) {
		try {
			String json = jedisClient.hget(LEAVEMESSAGE, "CM"+id);
			if(StringUtils.isNotBlank(json)){
				ContactMessage contactMessage = JsonUtils.jsonToPojo(json, ContactMessage.class);
				return contactMessage;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ContactMessage contactMessage = leaveMessageDao.getContactMessageById(id);
		try {
			jedisClient.hset(LEAVEMESSAGE, "CM"+id, JsonUtils.objectToJson(contactMessage));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contactMessage;
	}

	@Override
	public boolean updateReadById(String id) {
		int i = leaveMessageDao.updateMessageReadById(id);
		if(i!=0){
			return true;
		}
		return false;
	}

	@Override
	public EasyUIDataGridResult getCommentList(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Comment> list = leaveMessageDao.selectCommentList();
		PageInfo<Comment> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public boolean deleteCommentById(String id) {
		int i = leaveMessageDao.deleteCommentById(id);
		if(i!=0){
			return true;
		}
		return false;
	}
	
	
		
}
