package com.shentianyu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.shentianyu.common.ConstantClass;
import com.shentianyu.entity.Article;
import com.shentianyu.entity.Category;
import com.shentianyu.entity.Channel;
import com.shentianyu.entity.User;
import com.shentianyu.service.ArticleService;
import com.shentianyu.service.CategoryService;
import com.shentianyu.service.ChannelService;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private ChannelService channelService;
	
	
	//注入另外一个Service
	@Autowired
	private CategoryService categoryService;
	
	//注入Articleservice   这个就是文章的servie
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("userMain")
	public String userMain(HttpServletRequest request,
			@RequestParam(defaultValue = "1")int pageNum) {
		//在这里面查询所有的频道 并且进行展示
		List<Channel> list = channelService.getChannelList();
		//共享所有的频道
		request.setAttribute("list", list);
		//查询热门的所有信息  
		PageInfo hotList = articleService.getHotGetList(pageNum);
		//查询最新的文章     
		List<Article> newArticles = articleService.getNewArticles(5);
		request.setAttribute("hotList", hotList);
		request.setAttribute("newArticles", newArticles);
		return "user/userList";
	}
	
	@RequestMapping("channel")//这里面有频道的ID  和分类的ID  和分页的信息
	public String channelList( HttpServletRequest request,  
								@RequestParam(defaultValue = "1")int pageNum, 
								@RequestParam(defaultValue = "1")int chnId, 
								@RequestParam(defaultValue = "0")int categoryId) {
		request.setAttribute("chnId", chnId);
		request.setAttribute("categoryId", categoryId);
		
		//在这里面查询所有的频道 并且进行展示
		List<Channel> list = channelService.getChannelList();
		//共享所有的频道
		request.setAttribute("list", list);
		//获取指定频道ID下的所有分类
		List<Category> categoryList = categoryService.getCategoryList(chnId);
		
		//然后获取article 的所有列表信
		PageInfo<Article> info = articleService.getListByCat(chnId, categoryId, pageNum);
		List<Article> list2 = info.getList();
		
		//然后将所有信息返回到前台页面
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("info", info);
		
		//查询最新的文章     
		List<Article> newArticles = articleService.getNewArticles(5);
		request.setAttribute("newArticles", newArticles);

		return "channel/ChannelList";
	}

	//getArticleByUserId  通过session里面的对象  直接去数据库里面查询article里面的userId
	@RequestMapping("getArticleByUserId")
	public String getArticleByUserId(HttpServletRequest request) {
		//然后返回指定的页面
		return "user/myList";
	}
	
	
	
	//myArticle查询我的文章
	@RequestMapping("myArticle")
	public String getMyArticle(HttpServletRequest request, @RequestParam(defaultValue = "1")int pageNum) {
		//首先去session对象里面取出user对象
		HttpSession ss = request.getSession();
		User user = (User) ss.getAttribute(ConstantClass.USER_SESSION_KEY);
		System.out.println(user.getId() +  " +++++++++++++++++++++++++++0" + user);
		//然后通过userid查询article 里面的文章
		PageInfo<Article> info = articleService.getArticleByUserIs(user.getId(), pageNum);
		request.setAttribute("info", info);
		List<Article> list = info.getList();
		for (Article article : list) {
			System.out.println(article);
		}
		return "article/myArticle";
	}
	
	
}












