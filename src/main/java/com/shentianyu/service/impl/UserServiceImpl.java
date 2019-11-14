package com.shentianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shentianyu.dao.UserMapper;
import com.shentianyu.entity.User;
import com.shentianyu.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public PageInfo getUserList(int pageNum, String mohu) {
		//首先进行分页
		PageHelper.startPage(pageNum, 3);
		//然后进行查询
		
		return new PageInfo(mapper.getUserList(mohu));
	}
	
	//根据id查询信息
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return mapper.getUserById(userId);
	}
	//根据id修改状态
	@Override
	public int updateStatus(int userId, int status) {
		// TODO Auto-generated method stub
		return mapper.updateStatus(userId, status);
	}

}
