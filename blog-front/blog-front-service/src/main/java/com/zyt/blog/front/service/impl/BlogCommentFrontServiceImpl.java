package com.zyt.blog.front.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyt.blog.common.pojo.Comment;
import com.zyt.blog.front.dao.BlogCommentFrontDao;
import com.zyt.blog.front.pojo.ContactMessage;
import com.zyt.blog.front.service.BlogCommentFrontService;
import com.zyt.blog.utils.IDUtils;

@Service
public class BlogCommentFrontServiceImpl implements BlogCommentFrontService {
	
	@Autowired
	private BlogCommentFrontDao blogCommentFrontDao;
	
	@Override
	public boolean saveContactMessage(ContactMessage contact) {
		contact.setID(IDUtils.genItemId());
		int i = blogCommentFrontDao.insertContactMessage(contact);
		if(i != 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean saveComment(Comment comment) {
		comment.setDATE(new Date());
		int i = blogCommentFrontDao.insertCommentMessage(comment);
		if(i != 0){
			return true;
		}
		return false;
	}
	
}
