package com.zyt.blog.front.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.zyt.blog.front.pojo.BlogType;

@Repository
public interface BlogTypeFrontDao {
	
	@Select("SELECT * FROM blog_type WHERE DEL_FLAG = TRUE AND ID = #{type_ID}")
	BlogType selectBlogTypeById(Integer type_ID);
	
	@Select("SELECT * FROM blog_type WHERE DEL_FLAG = TRUE")
	List<BlogType> selectBlogTypeAll();

}
