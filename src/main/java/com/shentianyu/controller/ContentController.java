package com.shentianyu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shentianyu.common.MsgResult;
import com.shentianyu.common.MyAssert;
import com.shentianyu.entity.ArticleSpeak;
import com.shentianyu.service.ContentService;

@Controller
@RequestMapping("articleContent")
public class ContentController {

	@Autowired
	private ContentService contentService;
	@RequestMapping("hotSpeak")
	public Object hotSpeak(HttpServletRequest request, Integer articleId, @RequestParam(defaultValue = "1")int pageNum) {
		//查询所有的评论
		PageInfo<ArticleSpeak> info = contentService.getArticleSpeakByArticleId(articleId, pageNum);
		request.setAttribute("info", info);
		request.setAttribute("articleId", articleId);
		List<ArticleSpeak> list = info.getList();
		for (ArticleSpeak articleSpeak : list) {
			System.out.println("articleSpeak + + + ++ +  + + ++ +  ++++" + articleSpeak);
		}
		//通过这个查询所有的信息
		return "article/conment";
	}
	@RequestMapping("upSpeak")
	@ResponseBody
	public Object upSpeak(HttpServletRequest request, Integer articleId,String content, Integer userId) {
		System.out.println();
		MyAssert.AssertTrue(userId > 0, "id有误");
		MyAssert.AssertTrue(articleId > 0, "id有误");
		MyAssert.AssertTrue(content.trim().length() > 0, "请评论后提交");
		//上传评论
		int result = contentService.upSpeak(articleId, content, userId);
		//评论 之后需要修改指定文章的评论数
		contentService.updateCommentNum(articleId);
		if(result >  0) {
			return new MsgResult(1, "评论成功", null);
		}
		return new MsgResult(2, "评论失败", null);
	}
}
