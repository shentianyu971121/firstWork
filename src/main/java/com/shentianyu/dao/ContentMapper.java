package com.shentianyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shentianyu.entity.ArticleSpeak;

public interface ContentMapper {
	/**
	 * 
	 * @Title: getArticleSpeakByArticleId 
	 * @Description: 展示前三条 评论信息
	 * @param articleId
	 * @return
	 * @return: List<ArticleSpeak>
	 */
	List<ArticleSpeak> getArticleSpeakByArticleId(@Param("articleId")Integer articleId);

	/**
	 * 
	 * @Title: upSpeak 
	 * @Description: 上传评论
	 * @param articleId
	 * @param content
	 * @param userId
	 * @return
	 * @return: int
	 */
	@Insert("INSERT INTO cms_comment (articleId,userId,content,created ) VALUES (#{articleId},#{userId},#{content},NOW())")
	int upSpeak(@Param("articleId")Integer articleId, @Param("content")String content, @Param("userId")Integer userId);
	/**
	 * 
	 * @Title: updateCommentNum 
	 * @Description: 上传评论之后需要修改评论的数量
	 * @param articleId
	 * @return: void
	 */
	@Update("UPDATE cms_article set commentCnt = commentCnt +  1 WHERE id = #{articleId}")
	void updateCommentNum(Integer articleId);
}
