package com.shentianyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.shentianyu.entity.User;

public interface UserMapper {

	/**
	 * 
	 * @Title: getUserList 
	 * @Description: 展示所有的user信息
	 * @param mohu
	 * @return
	 * @return: List
	 */
	List getUserList(@Param("mohu")String mohu);

	/**
	 * 
	 * @Title: getUserById 
	 * @Description: 根据Id查询user对象
	 * @param userId
	 * @return
	 * @return: User
	 */
	User getUserById(@Param("userId")int userId);
	/**
	 * 
	 * @Title: updateStatus 
	 * @Description: 修改状态
	 * @param userId
	 * @param status
	 * @return
	 * @return: int
	 */
	@Update("update cms_user set locked = ${status} where id = ${userId} ")
	int updateStatus(@Param("userId")int userId, @Param("status")int status);

}
