package com.shentianyu.service;

import java.util.List;

import com.shentianyu.entity.Category;

public interface CategoryService {

	/**
	 * 
	 * @Title: getCategoryList 
	 * @Description: 查询指定的频道的分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	List<Category> getCategoryList(int channelId);

}
