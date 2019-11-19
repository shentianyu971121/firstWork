package com.shentianyu.service;

import com.shentianyu.entity.User;

/**
 * 
 * @ClassName: LoginOrRegisterService 
 * @Description: 登录或者注册所用到的service
 * @author:jyj 
 * @date: 2019年11月17日 下午7:03:19
 */
public interface LoginOrRegisterService {
	/**
	 * 
	 * @Title: getUserByUsername 
	 * @Description: 通过username查询是已经注册信息
	 * @param username
	 * @return
	 * @return: User
	 */
	User getUserByUsername(String username);
	/**
	 * 
	 * @Title: register 
	 * @Description: 注册方法
	 * @param user
	 * @return
	 * @return: int
	 */
	int register(User user);
	/**
	 * 
	 * @Title: login 
	 * @Description: 登录方法 
	 * @param user
	 * @return
	 * @return: User
	 */
	User login(User user);

}
