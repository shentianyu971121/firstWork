package com.shentianyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shentianyu.entity.Article;

/**
 * 
 * @ClassName: ArticleMapper 
 * @Description: 文章mapper接口
 * @author:jyj 
 * @date: 2019年11月14日 下午7:37:52
 */
public interface ArticleMapper {
	/**
	 * 
	 * @Title: getHotList 
	 * @Description: 文章类的所有热门 信息
	 * @return
	 * @return: List
	 */
	List getHotList();
	/**
	 * 
	 * @Title: getNewArticles 
	 * @Description: 展示最新的文章
	 * @param i
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getNewArticles(int i);
	/**
	 * 
	 * @Title: getListByCat 
	 * @Description: 根据频道获取文章内容
	 * @param chnId
	 * @param categoryId
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getListByCat(@Param("chnId")int chnId, @Param("categoryId")int categoryId);
	/**
	 * 
	 * @Title: getArticliById 
	 * @Description: 通过id查询出来对象
	 * @param articleId
	 * @return
	 * @return: Article
	 */
	Article getArticliById(@Param("articleId")int articleId);

}
