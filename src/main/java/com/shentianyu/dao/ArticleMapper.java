package com.shentianyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	/**
	 * 
	 * @Title: getArticleByUserId 
	 * @Description: 通过UserID查询出来文章列表
	 * @param id
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getArticleByUserId(@Param("userId")Integer id);
	/**
	 * 
	 * @Title: getAllArticleByAdmin 
	 * @Description: 查询所有的信息
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getAllArticleByAdmin();
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
	 * @Title: getArticleByDelete 
	 * @Description: 查询已经删除的
	 * @param id
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getArticleByDelete(Integer id);
	/**
	 * 
	 * @Title: articleDel 
	 * @Description: 删除   不过就是逻辑删除   只是一个修改
	 * @param id
	 * @return
	 * @return: int
	 */
	@Update("update cms_article set deleted = 1 where id = ${value}")
	int articleDel(Integer id);
	/**
	 * 
	 * @Title: showArticleById 
	 * @Description: 点击审核出现模态框 并且进行信息回显
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article showArticleById(Integer id);
	/**
	 * 
	 * @Title: adminUpdateStatus 
	 * @Description: 修改是否进行审核
	 * @param id
	 * @param status
	 * @return
	 * @return: int
	 */
	@Update("UPDATE cms_article set status = ${status} WHERE id = ${id}")
	int adminUpdateStatus(@Param("id")Integer id, @Param("status")Integer status);
	/**
	 * 
	 * @Title: adminUpdateHot 
	 * @Description: 修改为热门非热门 就是热门 的话就是 一定审核通过
	 * @param id
	 * @param hot
	 * @return
	 * @return: int
	 */
	@Update("UPDATE cms_article set hot = ${hot}, status = 1 WHERE id = ${id}")
	int adminUpdateHot(@Param("id")Integer id, @Param("hot")Integer hot);
	/**
	 * 
	 * @Title: add 
	 * @Description: 发布文章
	 * @param article
	 * @return
	 * @return: int
	 */
	@Insert("INSERT INTO cms_article("
			+ " title,content,picture,channel_id,category_id,"
			+ " user_id,hits,hot,status,deleted,"
			+ " created,updated,commentCnt,articleType) "
			+ " values("
			+ " #{title},#{content},#{picture},#{channelId},#{categoryId},"
			+ "#{userId},#{hits},#{hot},#{status},#{deleted},"
			+ "now(),now(),#{commentCnt},#{articleType})")
	int add(Article article);
	/**
	 * 
	 * @Title: getArticleByIdToDeleteByUser 
	 * @Description: 查询信息 是否存在  
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article getArticleByIdToDeleteByUser(Integer id);
	/**
	 * 
	 * @Title: userUpdateDelete 
	 * @Description: 逻辑删除  也就是i修改信息
	 * @param id
	 * @return
	 * @return: int
	 */
	@Update("UPDATE cms_article set deleted = 1 WHERE id = ${value}")
	int userUpdateDelete(Integer id);
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改文章
	 * @param article
	 * @return
	 * @return: int
	 */
	@Update("UPDATE cms_article SET title=#{title},content=#{content},"
			+ "picture=#{picture},channel_id=#{channelId},"
			+ "category_id=#{categoryId},status=0,updated=now() WHERE id=#{id}")
	int update(Article article);
	/**
	 * 
	 * @Title: getMaxId 
	 * @Description: 查询ID的最大值
	 * @return
	 * @return: int
	 */
	@Select("SELECT MAX(id) from cms_article")
	int getMaxId();
}




