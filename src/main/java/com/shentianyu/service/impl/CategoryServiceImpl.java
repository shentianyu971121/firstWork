package com.shentianyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shentianyu.dao.CategoryMapper;
import com.shentianyu.entity.Category;
import com.shentianyu.service.CategoryService;
/**
 * 
 * @ClassName: CategoryServiceImpl 
 * @Description: 这个类是频道分类的Sevice
 * @author:jyj 
 * @date: 2019年11月14日 下午7:06:09
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	//注入mapper   就是分类的mapper
	@Autowired
	private CategoryMapper categoryMapper;
	//查询指定频道的分类
	@Override
	public List<Category> getCategoryList(int channelId) {
		// TODO Auto-generated method stub
		return categoryMapper.getCategoryList(channelId);
	}
}
