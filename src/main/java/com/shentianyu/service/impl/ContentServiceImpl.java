package com.shentianyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shentianyu.dao.ContentMapper;
import com.shentianyu.entity.ArticleSpeak;
import com.shentianyu.service.ContentService;
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentMapper contentMapper;
	//同文章Id查询评论
	@Override
	public PageInfo<ArticleSpeak> getArticleSpeakByArticleId(Integer articleId, int pageNum) {
		// TODO Auto-generated method stub
		//开始分页
		PageHelper.startPage(pageNum, 8);
		return new PageInfo<ArticleSpeak>(contentMapper.getArticleSpeakByArticleId(articleId));
	}
	/**
	 * 上传评论
	 */
	@Override
	public int upSpeak(Integer articleId, String content, Integer userId) {
		// TODO Auto-generated method stub
		return contentMapper.upSpeak(articleId, content, userId);
	}
	/**
	 * 修改评论的数量
	 */
	@Override
	public void updateCommentNum(Integer articleId) {
		// TODO Auto-generated method stub
		contentMapper.updateCommentNum(articleId);
	}
}
