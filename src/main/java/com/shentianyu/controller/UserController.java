package com.shentianyu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.shentianyu.entity.Article;
import com.shentianyu.entity.Category;
import com.shentianyu.entity.Channel;
import com.shentianyu.service.ArticleService;
import com.shentianyu.service.CategoryService;
import com.shentianyu.service.ChannelService;
import com.shentianyu.service.UserService;

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
	
	
	@RequestMapping(value = "hellow", method = RequestMethod.GET)
	public String userTest(HttpServletRequest request) {
		request.setAttribute("info", "Hellow");
		return "test/interLoad";
	}
	
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
		for (Article article : list2) {
			System.out.println(article + ".........................................................");
		}
		
		//然后将所有信息返回到前台页面
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("info", info);
		
		//查询最新的文章     
		List<Article> newArticles = articleService.getNewArticles(5);
		request.setAttribute("newArticles", newArticles);

		return "channel/ChannelList";
	}
	

	
}












