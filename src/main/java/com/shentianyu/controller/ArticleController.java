package com.shentianyu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.shentianyu.common.ConstantClass;
import com.shentianyu.common.MsgResult;
import com.shentianyu.common.MyAssert;
import com.shentianyu.entity.Article;
import com.shentianyu.entity.ArticleSpeak;
import com.shentianyu.entity.Category;
import com.shentianyu.entity.Channel;
import com.shentianyu.entity.User;
import com.shentianyu.service.ArticleService;
import com.shentianyu.service.CategoryService;
import com.shentianyu.service.ChannelService;
import com.shentianyu.service.ContentService;

@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private ChannelService channelService;
	
	/**
	 * 设置上一篇 下一篇
	 */
	@RequestMapping("nextArticle")
	public String nextArticle(Integer id,  HttpServletRequest request) {
		Article article = null;
		int result = articleService.getMaxId();
		System.out.println("最大值为 ++++++" + result);
		//首先根据id查询比这个id小的值
		for (int i = id + 1 ; i <= result; i++ ) {
			//去后台对象是否有值  如果有值 就将循环停止
			article = articleService.getArticleById(i);
			System.out.println("article相邻的最近的是:" + article);
			if(article != null) {
				i = --result;
				break;
			}
		}
		//那么这个就是相邻的上一篇额id  然后调用方法
		request.setAttribute("article", article);
		return "article/showHotArticle";
	}
	/**
	 * 设置上一篇 下一篇
	 */
	@RequestMapping("preArticle")
	public String preOrNextArticle(Integer id,  HttpServletRequest request) {
		Article article = null;
		//首先根据id查询比这个id小的值
		for (int i = id - 1; i > 0; i--) {
			//去后台对象是否有值  如果有值 就将循环停止
			article = articleService.getArticleById(i);
			System.out.println("article相邻的最近的是:" + article);
			if(article != null) {
				break;
			}
		}
		//那么这个就是相邻的上一篇额id  然后调用方法
		request.setAttribute("article", article);
		return "article/showHotArticle";
	}
	/**
	 * 
	 * @Title: showArticle 
	 * @Description: 点击文章之后的文章展示
	 * @param articleId
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping("showArticle")
	public String showArticle(int articleId, HttpServletRequest request) {
		//去后台查询
		Article article = articleService.getArticleById(articleId);
		
		System.out.println(article);
		request.setAttribute("article", article);
		return "article/showHotArticle";
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
	/**
	 * 
	 * @Title: allArticle 
	 * @Description: 删除  就是修改deleted的值为1
	 * @param request
	 * @param pageNum
	 * @return
	 * @return: String
	 */
	@RequestMapping("articleDel")   //删除操作
	@ResponseBody
	public Object articleDel(HttpServletRequest request, Integer id) {
		//首先判断id的值是否大于0
		MyAssert.AssertTrue(id>0, "输入的id有误");
		//然后查询id是否有值
		Article article = articleService.getArticleById(id);
		//然后进行删除
		int result = articleService.articleDel(id);
		if(result > 0) {
			return new MsgResult(1, "删除成功", null);
		}
		return new MsgResult(2, "删除失败", null);
	}
	
	@RequestMapping("showArticleById")   //删除操作
	@ResponseBody
	public Object showArticleById(HttpServletRequest request, Integer id) {
		//首先判断id的值是否大于0
		MyAssert.AssertTrue(id>0, "输入的id有误");
		//然后查询id是否有值
		Article article = articleService.showArticleById(id);
		System.out.println("article +++++++++++++++++++++++ " + article);
		MyAssert.AssertTrue(article != null, "对不起没有查询出来值");
		//然后进行回显
		return new MsgResult(1, null, article);
	}
	
	@RequestMapping("adminUpdateStatus")   //审核通过和不通过
	@ResponseBody
	public Object adminUpdateStatus(HttpServletRequest request, Integer id, Integer status) {
		//首先判断id的值是否大于0
		MyAssert.AssertTrue(id>0, "输入的id有误");
		//然后查询id是否有值
		Article article = articleService.showArticleById(id);
		//判断输入的id值是否为空
		MyAssert.AssertTrue(article != null, "对不起没有查询出来值");
		//然后进行修改
		int result = articleService.adminUpdateStatus(id,status);
		MyAssert.AssertTrue(result > 0, "修改失败");
		//然后进行回显
		return new MsgResult(1, "修改成功", null);
	}
	
	
	@RequestMapping("adminUpdateHot")   //设置为热门和非热门
	@ResponseBody
	public Object adminUpdateHot(HttpServletRequest request, Integer id, Integer hot) {
		System.out.println(" + ++ ++ ++ ++ + + + +++"+  id);
		//首先判断id的值是否大于0
		MyAssert.AssertTrue(id>0, "输入的id有误");
		//然后查询id是否有值
		Article article = articleService.showArticleById(id);
		//判断输入的id值是否为空
		MyAssert.AssertTrue(article != null, "对不起没有查询出来值");
		//然后进行修改
		int result = articleService.adminUpdateHot(id,hot);
		MyAssert.AssertTrue(result > 0, "修改失败");
		//然后进行回显
		return new MsgResult(1, "修改成功", null);
	}
	
	@RequestMapping("getCategoryByChannel")   //通过频道Id查询出来分类信息
	@ResponseBody
	public Object getCategoryByChannel(Integer chnId) {
		System.out.println("进入了 Article方法  + " + chnId);
		//首先判断id的值是否大于0
		/* MyAssert.AssertTrue(chnId>0, "输入的id有误"); */
		//然后频道Id查询出来值
		List<Category> categories =  categoryService.getCategoryList(chnId);
		System.out.println();
		//然后进行回显
		return new MsgResult(1, null, categories);
	}
	

}













