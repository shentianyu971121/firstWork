package com.shentianyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.shentianyu.entity.AdminFavorite;
import com.shentianyu.entity.Article;
import com.shentianyu.entity.Favorite;
import com.shentianyu.entity.MyFavorite;

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
			+ "now(),now(),#{commentCnt},#{articleType.ordinal})")
	@SelectKey(before = false, keyProperty = "id", resultType = Integer.class, statement = { "select LAST_INSERT_ID()" })
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
	/**
	 * 
	 * @Title: addArticle 
	 * @Description: 添加图片
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
			+ "now(),now(),#{commentCnt},"
			+ "#{articleType.ordinal})")
	int addArticle(Article article);
	/**
	 * 
	 * @Title: getImgArticles 
	 * @Description: 获取图片的文章
	 * @param i
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getImgArticles(int i);
	
	/**
	 * 
	 * @Title: addFavorite 
	 * @Description: 添加信息到数据库中 并且进行替换
	 * @param articleId
	 * @param userId
	 * @param comment
	 * @return
	 * @return: int
	 */
	@Insert("REPLACE cms_favorite (userId, articleId,comment,created) "
			+ "VALUES (#{userId}, #{articleId},#{comment},now())")
	void addFavorite(@Param("articleId")Integer articleId, @Param("userId")Integer userId, @Param("comment")String comment);
	/**
	 * 
	 * @Title: getFavoriteListByUserId 
	 * @Description: 通过UserId查询对象
	 * @param id
	 * @return
	 * @return: List<Favorite>
	 */
	List<Favorite> getFavoriteListByUserId(Integer id);
	/**
	 * 
	 * @Title: deleteFavorite 
	 * @Description: 删除信息
	 * @param id
	 * @return
	 * @return: int
	 */
	@Delete("DELETE  from cms_favorite where id = #{id}")
	int deleteFavorite(int id);
	/**
	 * 
	 * @Title: getAdminFavorite 
	 * @Description: 通过管理员的id获取文章的id
	 * @param id
	 * @return
	 * @return: List<AdminFavorite>
	 */
	@Select("SELECT * from cms_adminfavorite  WHERE  userid = #{id}")
	List<AdminFavorite> getAdminFavorite(Integer id);
	/**
	 * 
	 * @Title: addMyFavorite 
	 * @Description: 添加信息到我的收藏夹
	 * @param articleId
	 * @param title
	 * @param url
	 * @param userid 
	 * @return
	 * @return: int
	 */
	@Insert("INSERT into cms_favorite_month (text,url,user_id,created) "
			+ "VALUES (#{title},#{url}, #{userId}, now() )")
	int addMyFavorite(@Param("articleId")Integer articleId, @Param("title")String title, @Param("url")String url, @Param("userId")Integer userid);
	/**
	 * 
	 * @Title: getMyFavorite 
	 * @Description: 通过userId查询我的收藏夹
	 * @param id
	 * @return
	 * @return: List<MyFavorite>
	 */
	@Select("SELECT * from cms_favorite_month WHERE user_id = #{id}")
	List<MyFavorite> getMyFavorite(Integer id);
	/**
	 * 
	 * @Title: deleteMyfavorite 
	 * @Description: 删除我的收藏
	 * @param id
	 * @return
	 * @return: int
	 */
	@Delete("delete  from cms_favorite_month WHERE id = #{id}")
	int deleteMyfavorite(Integer id);
	/**
	 * 
	 * @Title: getArticle 
	 * @Description: 查询所有的未被删除的和已经审核通过的信息
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getArticle();
	/**
	 * 
	 * @Title: updateHits 
	 * @Description: 修改访问量
	 * @param article
	 * @return: void
	 */
	@Update("update cms_article set hits = #{hits} where id = #{id}")
	void updateHits(Article article);
}






