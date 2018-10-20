package com.zyt.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.zyt.blog.common.pojo.Comment;
import com.zyt.blog.pojo.ContactMessage;

@Repository
public interface LeaveMessageDao {
	
	@Select("SELECT * FROM CONTACT_MESSAGE WHERE DEL_FLAG=TRUE")
	List<ContactMessage> selectLeaveMessage();

	@Update("UPDATE CONTACT_MESSAGE SET DEL_FLAG = FALSE WHERE ID = #{iD}")
	int UpdateContactMessageDelFlag(String iD);
	
	@Select("SELECT * FROM CONTACT_MESSAGE WHERE DEL_FLAG=TRUE AND ID=#{id}")
	ContactMessage getContactMessageById(String id);
	
	@Update("UPDATE CONTACT_MESSAGE SET `READ` = TRUE WHERE ID=#{id}")
	int updateMessageReadById(String id);
	
	@Select("SELECT * FROM COMMENT WHERE DEL_FLAG=TRUE")
	List<Comment> selectCommentList();
	
	@Update("UPDATE COMMENT SET DEL_FLAG = FALSE WHERE ID = #{id}")
	int deleteCommentById(String id);

}
