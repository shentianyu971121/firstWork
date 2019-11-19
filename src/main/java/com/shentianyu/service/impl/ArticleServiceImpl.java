package com.shentianyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shentianyu.common.ConstantClass;
import com.shentianyu.dao.ArticleMapper;
import com.shentianyu.entity.Article;
import com.shentianyu.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {

	//注入文章类的mapper接口
	@Autowired
	private ArticleMapper articleMapper;
	//获取所有的热门集合
	@Override
	public PageInfo getHotGetList(int pageNum) {
		//首先给热门进行分页
		PageHelper.startPage(pageNum, 3);
		
		return new PageInfo(articleMapper.getHotList());
	}
	//获取新的文章
	@Override
	public List<Article> getNewArticles(int i) {
		// TODO Auto-generated method stub
		return articleMapper.getNewArticles(i);
	}
	@Override
	public PageInfo<Article> getListByCat(int chnId, int categoryId, int pageNum) {
		// TODO Auto-generated method stub
		//首先进行分页
		PageHelper.startPage(pageNum, 3);
		
		return new PageInfo<Article>(articleMapper.getListByCat(chnId,categoryId));
	}
	//通过ID查询出来对象
	@Override
	public Article getArticleById(int articleId) {
		// TODO Auto-generated method stub
		return articleMapper.getArticliById(articleId);
	}
	/**
	 * 通过userid查询出来文章列表
	 */
	@Override
	public PageInfo<Article> getArticleByUserIs(Integer id, int pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 5);
		//然后去mapper层进行查询
		List<Article> list = articleMapper.getArticleByUserId(id);
		return new PageInfo<Article>(list);
	}
	//查询所有的文章
	@Override
	public PageInfo<Article> getAllArticleByAdmin(int pageNum) {
		//首先进行分页
		PageHelper.startPage(pageNum, 5);
		//然后进行查询所有的信息
		List<Article> list = articleMapper.getAllArticleByAdmin();
		return new PageInfo<Article>(list);
	}

}
