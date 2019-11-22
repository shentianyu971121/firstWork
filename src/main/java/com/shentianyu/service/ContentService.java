package com.shentianyu.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shentianyu.entity.ArticleSpeak;

public interface ContentService {

	/**
	 * 
	 * @Title: getArticleSpeakByArticleId 
	 * @Description: 通过文章Id查询评论 只展示前三条
	 * @param articleId
	 * @param pageNum 
	 * @return
	 * @return: PageInfo<ArticleSpeak>
	 */
	PageInfo<ArticleSpeak> getArticleSpeakByArticleId(Integer articleId, int pageNum);

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
	int upSpeak(Integer articleId, String content, Integer userId);
	/**
	 * 
	 * @Title: updateCommentNum 
	 * @Description: 修改评论的数量
	 * @param articleId
	 * @return: void
	 */
	void updateCommentNum(Integer articleId);

}
