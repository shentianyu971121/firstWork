package com.shentianyu.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shentianyu.dao.AdminMapper;
import com.shentianyu.entity.AdminFavorite;
import com.shentianyu.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	/**
	 * 添加管理员收藏
	 */
	@Override
	public int addAdminFavorite(AdminFavorite adminFavorite, Integer userid) {
		adminFavorite.setUserid(userid);
		// TODO Auto-generated method stub
		return adminMapper.addAdminFavorite(adminFavorite);
	}
	/**
	 * 查询是否有值
	 */
	@Override
	public AdminFavorite findAdminFavoriteById(Integer id) {
		// TODO Auto-generated method stub
		return adminMapper.findAdminFavoriteById(id);
	}
	/**
	 * 删除管理员收藏
	 */
	@Override
	public int deleteAdminFavorite(Integer id) {
		// TODO Auto-generated method stub
		return adminMapper.deleteAdminFavorite(id);
	}
}
