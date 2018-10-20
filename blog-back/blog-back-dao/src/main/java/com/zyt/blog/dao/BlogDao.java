package com.zyt.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.zyt.blog.pojo.BlogContent;

@Repository
public interface BlogDao {
	
	@Select("SELECT * FROM blog_content WHERE DEL_FLAG = TRUE")
	List<BlogContent> selectBlogList();
	
	@Insert("INSERT INTO blog_content VALUES(#{ID},#{DEL_FLAG},#{DATE},#{DIGEST},#{TITLE},#{CONTENT},"
			+ "#{TYPE_ID},#{PUBLISH},#{KEY_WORD})")
	int saveBlogContent(BlogContent content);
	
	@Update("UPDATE blog_content SET DIGEST = #{DIGEST},"
			+ "TITLE = #{TITLE},CONTENT = #{CONTENT},TYPE_ID = #{TYPE_ID},"
			+ "KEY_WORD = #{KEY_WORD} WHERE ID = #{ID}")
	int updateBlogContent(BlogContent content);
	
	@Update("UPDATE blog_content SET PUBLISH = TRUE WHERE ID = #{id}")
	int updateBlogPublishById(String id);
	
	@Update("UPDATE blog_content SET DEL_FLAG = FALSE WHERE ID = #{id}")
	int delFlagBlogById(String id);
	
	@Select("SELECT * FROM blog_content WHERE ID = #{id}")
	BlogContent selectBlogById(String id);
	
}
