package com.shentianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shentianyu.common.Md5;
import com.shentianyu.dao.LoginOrRegisterMapper;
import com.shentianyu.entity.User;
import com.shentianyu.service.LoginOrRegisterService;
/**
 * 
 * @ClassName: LoginOrRegisterServiceImpl 
 * @Description: 登录或者注册的servic
 * @author:jyj 
 * @date: 2019年11月17日 下午7:03:03
 */
@Service
public class LoginOrRegisterServiceImpl implements LoginOrRegisterService {

	@Autowired
	private LoginOrRegisterMapper LoginOrRegisterMapper;

	@Override
	public User getUserByUsername(String username) {
		
		return LoginOrRegisterMapper.getUserByUsername(username);
	}
	/**
	 * 注册的方法
	 */
	@Override
	public int register(User user) {
		//首先对密码进行加盐的操作
		System.out.println("加盐之前" + user);
		String password = Md5.password(user.getPassword(), user.getUsername().substring(0, 2));
		user.setPassword(password);
		//然后去后台进行注册
		System.out.println(user);
		return LoginOrRegisterMapper.register(user);
	}
	//登录方法 
	@Override
	public User login(User user) {
		//给user对象进行加盐的操作
		String password = Md5.password(user.getPassword(), user.getUsername().substring(0, 2));
		user.setPassword(password);
		return LoginOrRegisterMapper.login(user);
	}
}
