package com.shentianyu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.shentianyu.entity.Article;
import com.shentianyu.service.ArticleService;

@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	/**
	 * 
	 * @Title: showArticle 
	 * @Description: 测试
	 * @param articleId
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping("showArticle")
	public String showArticle(int articleId, HttpServletRequest request) {
		//去后台查询
		Article article = articleService.getArticleById(articleId);
		request.setAttribute("article", article);
		return "article/showArticle";
	}
	
	/**
	 * 
	 * @Title: allArticle 
	 * @Description: 管理员查询所有的文章
	 * @param request
	 * @param pageNum
	 * @return
	 * @return: String
	 */
	@RequestMapping("allArticle")   //查询所有的文章
	public String allArticle(HttpServletRequest request, @RequestParam(defaultValue = "1")int pageNum) {
		System.out.println("进入了查询所有的信息.............................");
		//去后台查询所有的文章列表
		PageInfo<Article> info  = articleService.getAllArticleByAdmin(pageNum);
		System.out.println("info  0........ + " + info);
		request.setAttribute("info", info);
		return "article/showArticle";
	}
	
	
}
