package com.zyt.blog.front.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.zyt.blog.common.pojo.Comment;
import com.zyt.blog.front.pojo.ContactMessage;

@Repository
public interface BlogCommentFrontDao {

	@Insert("INSERT INTO CONTACT_MESSAGE VALUE(#{ID},TRUE,FALSE,#{TITLE},#{EMAIL},#{NAME},#{CONTENT})")
	int insertContactMessage(ContactMessage contact);
	
	@Insert("INSERT INTO COMMENT VALUES(NULL,0,TRUE,#{BLOG_CONTENT_ID},#{NAME},#{CONTENT},#{DATE})")
	int insertCommentMessage(Comment comment);
	
	
}
