package com.shentianyu.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shentianyu.entity.Article;

public interface ArticleService {


	/**
	 * 
	 * @Title: getHotGetList 
	 * @Description: 获取所以的热门 并且进行分页
	 * @param pageNum
	 * @return
	 * @return: List<Article>
	 */
	PageInfo getHotGetList(int pageNum);
	/**
	 * 
	 * @Title: getNewArticles 
	 * @Description: 查询新的文章
	 * @param i
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getNewArticles(int i);
	
	/**
	 * 
	 * @Title: getListByCat 
	 * @Description: 根据频道或者分类获取文章内容
	 * @param chnId
	 * @param categoryId
	 * @param pageNum
	 * @return
	 * @return: PageInfo<Article>
	 */
	PageInfo<Article> getListByCat(int chnId, int categoryId, int pageNum);
	/**
	 * 
	 * @Title: getArticleById 
	 * @Description: 通过ArticleId查询出对象
	 * @param articleId
	 * @return
	 * @return: Article
	 */
	Article getArticleById(int articleId);

}
