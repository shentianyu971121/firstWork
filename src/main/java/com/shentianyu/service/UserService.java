package com.shentianyu.service;

import com.github.pagehelper.PageInfo;
import com.shentianyu.entity.User;

public interface UserService {

	/**
	 * 
	 * @Title: getUserList 
	 * @Description:点击之后展示的页面    查询所有的user对象   来进行展示
	 * @param pageNum
	 * @param mohu
	 * @return
	 * @return: PageInfo
	 */
	PageInfo getUserList(int pageNum, String mohu);

	/**
	 * 
	 * @Title: getUserById 
	 * @Description: 根据Id查询出来用户
	 * @param userId
	 * @return
	 * @return: User
	 */
	User getUserById(int userId);
	/**
	 * 
	 * @Title: updateStatus 
	 * @Description: 根据id修改状态
	 * @param userId
	 * @param status
	 * @return
	 * @return: int
	 */
	int updateStatus(int userId, int status);

}
