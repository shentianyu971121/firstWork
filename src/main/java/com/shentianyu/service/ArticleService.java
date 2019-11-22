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
	 * @return: List<Article>List<Article> newArticles
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
	/**
	 * 
	 * @Title: getArticleByUserIs 
	 * @Description:通过userId查询出文章
	 * @param id
	 * @param pageNum
	 * @return
	 * @return: PageInfo<Article>
	 */
	PageInfo<Article> getArticleByUserIs(Integer id, int pageNum);
	/**
	 * 
	 * @Title: getAllArticleByAdmin 
	 * @Description: 查询所有的列表信息  就是管理员可以看到
	 * @return
	 * @return: PageInfo<Article>
	 */
	PageInfo<Article> getAllArticleByAdmin(int pageNum);
	/**
	 * 
	 * @Title: getArticleByStatus 
	 * @Description: 查询未审核的文章
	 * @param id
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getArticleByStatus(Integer id);
	/**
	 * 
	 * @Title: getArticleByDelete 
	 * @Description: 查询已经删除的文章
	 * @param id
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getArticleByDelete(Integer id);
	/**
	 * 
	 * @Title: articleDel 
	 * @Description: 删除信息 也就是修改
	 * @param id
	 * @return
	 * @return: int
	 */
	int articleDel(Integer id);
	/**
	 * 
	 * @Title: showArticleById 
	 * @Description: 通过ID查询出来信息
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article showArticleById(Integer id);
	/**
	 * 
	 * @Title: adminUpdateStatus 
	 * @Description: 审核信息
	 * @param id
	 * @param status
	 * @return
	 * @return: int
	 */
	int adminUpdateStatus(Integer id, Integer status);
	/**
	 * 
	 * @Title: adminUpdateHot 
	 * @Description:修改热门与非热门
	 * @param id
	 * @param hot
	 * @return
	 * @return: int
	 */
	int adminUpdateHot(Integer id, Integer hot);
	/**
	 * 
	 * @Title: add 
	 * @Description: 发布文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int add(Article article);
	/**
	 * 
	 * @Title: getArticleByIdToDeleteByUser 
	 * @Description: 首先查询Id是否存在   然后进行删除
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article getArticleByIdToDeleteByUser(Integer id);
	/**
	 * 
	 * @Title: userUpdateDelete 
	 * @Description: 逻辑删除  也就是i修改deleted的状态
	 * @param id
	 * @return
	 * @return: int
	 */
	int userUpdateDelete(Integer id);
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改我的文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int update(Article article);
	/**
	 * 
	 * @Title: getMaxId 
	 * @Description: 查询Id的最大值
	 * @return
	 * @return: int
	 */
	int getMaxId();

}
