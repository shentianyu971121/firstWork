package com.shentianyu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shentianyu.entity.Article;
import com.shentianyu.service.ArticleService;

@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("showArticle")
	public String showArticle(int articleId, HttpServletRequest request) {
		//去后台查询
		Article article = articleService.getArticleById(articleId);
		request.setAttribute("article", article);
		return "article/showArticle";
	}
	
	
}
