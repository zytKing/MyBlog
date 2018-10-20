package com.zyt.blog.front.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.zyt.blog.front.pojo.BlogContent;

@Repository
public interface BlogFrontDao {
	
	@Select("SELECT * FROM blog_content WHERE DEL_FLAG = TRUE AND PUBLISH = TRUE")
	List<BlogContent> selectBlogByPage();
	
	@Select("SELECT * FROM blog_content WHERE DEL_FLAG = TRUE AND PUBLISH = TRUE AND TYPE_ID = #{typeId}")
	List<BlogContent> selectBlogByTypeId(Integer typeId);
	
	@Select("SELECT * FROM blog_content WHERE DEL_FLAG = TRUE AND PUBLISH = TRUE AND ID = #{id}")
	BlogContent selectBlogById(String id);
}
