package com.zyt.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.zyt.blog.pojo.BlogType;

@Repository
public interface BlogTypeDao {
	
	@Select("SELECT * FROM BLOG_TYPE WHERE DEL_FLAG = TRUE")
	List<BlogType> selectBlogTypeList();
	
	/*@Select("SELECT * FROM BLOG_TYPE WHERE DEL_FLAG = TRUE")
	List<BlogType> selectBlogTypeOption();*/
	
	@Select("SELECT * FROM BLOG_TYPE WHERE TYPENAME = #{tYPENAME} AND DEL_FLAG = TRUE")
	BlogType selectBlogTypeByName(String tYPENAME);
	
	@Insert("INSERT INTO BLOG_TYPE VALUES(NULL,#{tYPENAME},TRUE)")
	int saveBlogType(String tYPENAME);

	@Update("UPDATE blog_type SET TYPENAME = #{TYPENAME} WHERE ID = #{ID}")
	int updateBlogType(BlogType bt);
	
	@Update("UPDATE blog_type SET DEL_FLAG = false WHERE ID = #{iD}")
	int updateBlogTypeByID(String iD);
	
	@Select("SELECT * FROM blog_type WHERE DEL_FLAG = TRUE AND ID = #{type_ID}")
	BlogType selectBlogTypeById(Integer type_ID);

	
}
