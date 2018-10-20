package com.zyt.blog.front.service;

import com.zyt.blog.common.pojo.Comment;
import com.zyt.blog.front.pojo.ContactMessage;

public interface BlogCommentFrontService {

	boolean saveContactMessage(ContactMessage contact);

	boolean saveComment(Comment comment);

}
