package com.shentianyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shentianyu.entity.Category;

public interface CategoryMapper {
	/**
	 * 
	 * @Title: getCategoryList 
	 * @Description: 根据频道Id 查询出指定的分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	List<Category> getCategoryList(@Param("channelId")int channelId);

}
