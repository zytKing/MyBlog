package com.zyt.blog.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyt.blog.common.pojo.Comment;
import com.zyt.blog.common.vo.Message;
import com.zyt.blog.front.pojo.ContactMessage;
import com.zyt.blog.front.service.BlogCommentFrontService;

@RestController
@RequestMapping("/blogComment")
public class BlogCommentFrontController {
	
	@Autowired
	private Message message;
	
	@Autowired
	private BlogCommentFrontService blogCommentFrontService;
	
	@RequestMapping("/leaveMessage")
	public Message saveContactMessage(ContactMessage contact){
		boolean b = blogCommentFrontService.saveContactMessage(contact);
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
	
	@RequestMapping(value="/commentMessage",method=RequestMethod.POST)
	public Message saveCommentMessage(Comment comment){
		boolean b = blogCommentFrontService.saveComment(comment);
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
	
}
