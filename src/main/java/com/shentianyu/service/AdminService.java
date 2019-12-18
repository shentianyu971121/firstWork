package com.shentianyu.service;


import com.shentianyu.entity.AdminFavorite;

public interface AdminService {
	
	/**
	 * 
	 * @Title: addAdminFavorite 
	 * @Description: 添加管理员收藏
	 * @param adminFavorite
	 * @param integer 
	 * @return
	 * @return: int
	 */
	int addAdminFavorite(AdminFavorite adminFavorite, Integer userid);

	/**
	 * 
	 * @Title: findAdminFavoriteById 
	 * @Description: 通过id查询是否
	 * @param i
	 * @return
	 * @return: AdminFavorite
	 */
	AdminFavorite findAdminFavoriteById(Integer id);
	/**
	 * 
	 * @Title: deleteAdminFavorite 
	 * @Description: 删除我的 收藏
	 * @param id
	 * @return
	 * @return: int
	 */
	int deleteAdminFavorite(Integer id);

}
