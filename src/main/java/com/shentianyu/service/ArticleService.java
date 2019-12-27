package com.shentianyu.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shentianyu.entity.AdminFavorite;
import com.shentianyu.entity.Article;
import com.shentianyu.entity.Favorite;
import com.shentianyu.entity.MyFavorite;

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
	/**
	 * 
	 * @Title: addArticle 
	 * @Description: 添加图片
	 * @param article
	 * @return
	 * @return: int
	 */
	int addArticle(Article article);
	/**
	 * 
	 * @Title: getImgArticles 
	 * @Description: 获取最新的文章和图片
	 * @param i
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getImgArticles(int i);
	/**
	 * 
	 * @Title: addFavorite 
	 * @Description: 添加到数据库
	 * @param articleId
	 * @param userId
	 * @param comment
	 * @return
	 * @return: int
	 */
	void addFavorite(Integer articleId, Integer userId, String comment);
	/**
	 * 
	 * @Title: getFavoriteListByUserId 
	 * @Description: 通过Userid查询对象
	 * @param id
	 * @return
	 * @return: List<Favorite>
	 */
	PageInfo<Favorite> getFavoriteListByUserId(Integer id, int pageNum);
	/**
	 * 
	 * @Title: deleteFavorite 
	 * @Description: 取消收藏   然后去数据库里面进行删除
	 * @param id
	 * @return
	 * @return: int
	 */
	int deleteFavorite(int id);
	/**
	 * 
	 * @Title: getAdminFavorite 
	 * @Description: 通过userid获取文章
	 * @param id
	 * @param pageNum 
	 * @return
	 * @return: List<AdminFavorite>
	 */
	PageInfo<AdminFavorite> getAdminFavorite(Integer id, int pageNum);
	/**
	 * 
	 * @Title: addMyFavorite 
	 * @Description: 添加信息到我的收藏夹
	 * @param articleId
	 * @param title
	 * @param url
	 * @return
	 * @return: int
	 */
	int addMyFavorite(Integer articleId, String title, String url, Integer id);
	/**
	 * 
	 * @Title: getMyFavorite 
	 * @Description: 通过id获取我收藏的值
	 * @param id
	 * @return
	 * @return: PageInfo<MyFavorite>
	 */
	PageInfo<MyFavorite> getMyFavorite(Integer id, int pageNum);
	/**
	 * 
	 * @Title: deleteMyfavorite 
	 * @Description: 删除我的收藏
	 * @param id
	 * @return
	 * @return: int
	 */
	int deleteMyfavorite(Integer id);
	/**
	 * 
	 * @Title: updateHits 
	 * @Description: 修改访问量
	 * @param article
	 * @return: void
	 */
	void updateHits(Article article);


}
