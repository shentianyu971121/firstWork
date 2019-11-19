package com.shentianyu.dao;

import org.apache.ibatis.annotations.Select;

import com.shentianyu.entity.User;

/**
 * 
 * @ClassName: LoginOrRegisterMapper 
 * @Description:登录或者注册的接口
 * @author:jyj 
 * @date: 2019年11月17日 下午7:02:44
 */
public interface LoginOrRegisterMapper {
	/**
	 * 
	 * @Title: getUserByUsername 
	 * @Description: 通过username判断该用户名是否已经注册
	 * @param username
	 * @return
	 * @return: User
	 */
	User getUserByUsername(String username);
	/**
	 * 
	 * @Title: register 
	 * @Description: 注册信息
	 * @param user
	 * @return
	 * @return: int
	 */
	int register(User user);
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 登陆方法
	 * @param user
	 * @return
	 * @return: User
	 */
	User login(User user);

}
