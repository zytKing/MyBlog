package com.zyt.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.zyt.blog.common.pojo.User;


@Repository
public interface UserDao {
	
	@Select("SELECT * FROM USER WHERE LOGIN_NAME = #{loginname}")
	List<User> selectUserByName(String loginname);

}
