package com.zyt.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyt.blog.common.vo.Message;
import com.zyt.blog.pojo.ContactMessage;
import com.zyt.blog.service.LeaveMessageService;
import com.zyt.blog.vo.EasyUIDataGridResult;
@RestController
@RequestMapping("/message")
public class MessageAdminController {
	
	@Autowired
	public LeaveMessageService leaveMessageService;
	
	@Autowired
	public Message message;
	
	@RequestMapping("/MessageList")
	public EasyUIDataGridResult showLeaveMessageList(Integer page,Integer rows){
		EasyUIDataGridResult result = leaveMessageService.getLeaveMessageList(page,rows);
		return result;
	}
	
	@RequestMapping("/deleteContactMessage")
	public Message deleteContactMessage(String ID){
		boolean	b = leaveMessageService.deleteContactMessageById(ID);
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
	
	@RequestMapping(value="/ContactMessageById/{ids}",method=RequestMethod.GET)
	public Message getContactMessage(@PathVariable String id){
		ContactMessage contactMessage = leaveMessageService.findContactMessageById(id);
		message.setDes(contactMessage);
		boolean b = leaveMessageService.updateReadById(id);
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
	
	@RequestMapping(value="/showCommentList",method=RequestMethod.GET)
	public EasyUIDataGridResult showCommentList(Integer page,Integer rows){
		EasyUIDataGridResult result = leaveMessageService.getCommentList(page,rows);
		return result;
	}
	
	@RequestMapping(value="/deleteComment",method=RequestMethod.DELETE)
	public Message deleteComment(String id){
		boolean	b = leaveMessageService.deleteCommentById(id);
		if(!b){
			message.setCode(Message.Code.ERROR.ordinal());
		}
		return message;
	}
}
