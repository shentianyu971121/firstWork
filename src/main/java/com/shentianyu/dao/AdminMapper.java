package com.shentianyu.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.shentianyu.entity.AdminFavorite;

public interface AdminMapper {

	/**
	 * 
	 * @Title: addAdminFavorite 
	 * @Description: 添加管理员收藏
	 * @param adminFavorite
	 * @param userid 
	 * @return
	 * @return: int
	 */
	@Insert("INSERT INTO cms_adminfavorite (name,url,userid,created) "
			+ "values (#{name},#{url},#{userid},now())")	
	int addAdminFavorite(AdminFavorite adminFavorite);

	/**
	 * 
	 * @Title: findAdminFavoriteById 
	 * @Description: 查询传进来的id是否有对应的值
	 * @param id
	 * @return
	 * @return: AdminFavorite
	 */
	@Select("select * from cms_adminfavorite where id = #{id}")
	AdminFavorite findAdminFavoriteById(Integer id);
	/**
	 * 
	 * @Title: deleteAdminFavorite 
	 * @Description: 删除管理员的收藏
	 * @param id
	 * @return
	 * @return: int
	 */
	@Delete("delete from cms_adminfavorite where id = #{id}")
	int deleteAdminFavorite(Integer id);

}
