package com.zyt.blog.service;

import com.zyt.blog.pojo.ContactMessage;
import com.zyt.blog.vo.EasyUIDataGridResult;

public interface LeaveMessageService {

	EasyUIDataGridResult getLeaveMessageList(Integer page,Integer rows);

	boolean deleteContactMessageById(String iD);

	ContactMessage findContactMessageById(String id);

	boolean updateReadById(String id);

	EasyUIDataGridResult getCommentList(Integer page, Integer rows);

	boolean deleteCommentById(String id);

}
