package com.shentianyu.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	private SimpleDateFormat dateFormat;
	
	
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
	
	
	/**
	 * myArticleListBystatus   查询未审核的文章
	 */

	@RequestMapping("myArticleListBystatus")
	public String myArticleListBystatus(HttpServletRequest request) {
		//首先去session对象里面取出user对象
		HttpSession ss = request.getSession();
		User user = (User) ss.getAttribute(ConstantClass.USER_SESSION_KEY);
		List<Article> list = articleService.getArticleByStatus(user.getId());
		request.setAttribute("list", list);
		return "article/myArticleListBystatus";
	}
	/**
	 * 
	 * @Title: myArticleListDelete 
	 * @Description: 查询删除的文章
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping("myArticleListDelete")
	public String myArticleListDelete(HttpServletRequest request) {
		//首先去session对象里面取出user对象
		HttpSession ss = request.getSession();
		User user = (User) ss.getAttribute(ConstantClass.USER_SESSION_KEY);
		List<Article> list = articleService.getArticleByDelete(user.getId());
		request.setAttribute("list", list);
		return "article/myArticleListByDelete";
	}
	
	/**
	 * 
	 * @Title: uploadArticle 
	 * @Description: 上传文章
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping("postArticle")
	public String uploadArticle(HttpServletRequest request) {
		//首先去查询所有的频道信息  为了让前台页面进行回显
		List<Channel> channels = channelService.getChannelList();
		request.setAttribute("channels", channels);
		return "article/uploadArticle";
	}
	
	@ResponseBody
	@RequestMapping(value = "postArticle", method = RequestMethod.POST)
	public Object uploadArticle(HttpServletRequest request, MultipartFile file,Article article) throws IllegalStateException, IOException{
		if(!file.isEmpty()) {
			String fileUrl = processFile(file);
			article.setPicture(fileUrl);
		}
		User loginUser  = (User)request.getSession().getAttribute(ConstantClass.USER_SESSION_KEY);
		article.setUserId(loginUser.getId());
		System.out.println("article ++++++++++++++++++++++++++++ " +article);
		int result = articleService.add(article);
		if(result>0) {
			return new MsgResult(1, "处理成功",null);
		}else {
			return new MsgResult(2, "添加失败，请稍后再试试！",null);
		}
	}
		/**
		 * 
		 * @param file
		 * @return  保存文件的相对路径
		 * @throws IllegalStateException
		 * @throws IOException
		 */
	    private String processFile(MultipartFile file) throws IllegalStateException, IOException {
	    	
	    	//1 求扩展名  "xxx.jpg"
	    	String suffixName =  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
	    	String fileNamePre = UUID.randomUUID().toString();
	    	// 计算出新的文件名称
	    	String fileName = fileNamePre + suffixName;
	    	
	    	dateFormat = new SimpleDateFormat("yyyyMMdd");
	    	String path = dateFormat.format(new Date());
	    	File pathFile  = new File("d:/pic" + "/" + path);
	    	if(!pathFile.exists()) {
	    		pathFile.mkdirs();
	    	}
	    	// 最终的新的文件名称
	    	String newFileName = "d:/pic" + "/"+ path + "/" + fileName;
	    	System.out.println("最新的文件名为:" + newFileName);
	    	file.transferTo(new File(newFileName));
	    	return path + "/" + fileName ;
	    }
		
	    
	    @RequestMapping("delArticleByUser")
	    @ResponseBody
	    public Object delArticleByUser(HttpServletRequest request, Integer articleId, Integer userId) {
	    	//首先判断值时候xiaoyu0
	    	MyAssert.AssertTrue(articleId > 0, "异常");
	    	//然后通过id查询值
	    	Article articli = articleService.getArticleByIdToDeleteByUser(articleId);
	    	MyAssert.AssertTrue(articli != null, "用户已经注销或删除账号");
	    	//然后进行修改
	    	int result = articleService.userUpdateDelete(articleId);
	    	MyAssert.AssertTrue(result > 0, "修改失败");
	    	//然后获取作用域中的id 
	    	User user = (User) request.getSession().getAttribute(ConstantClass.USER_SESSION_KEY);
	    	MyAssert.AssertTrue(articli.getUser().getId() == user.getId(), "只能删除自己的文章");
	    	//然后进行返回json数据
	    	return new MsgResult(1, "成功", null);
	    }
	    
	    /**
		 * 
		 * @param request
		 * @param id  文章id
		 * @return
		 */
		@GetMapping("updateArticle")
		public String updateArticle(HttpServletRequest request,int id) {
			// 获取文章的详情 用于回显
			Article article = articleService.getArticleByIdToDeleteByUser(id);
			request.setAttribute("article", article);
			request.setAttribute("content1", htmlspecialchars(article.getContent()));
			System.out.println(" 将要修改文章 " + article);
			// 获取所有的频道
			List<Channel> channels =  channelService.getChannelList();
			System.out.println("获取所有的频道: " + channels);
			
			request.setAttribute("channels", channels);
			
			return "article/update";
		}
		
		private String htmlspecialchars(String str) {
			str = str.replaceAll("&", "&amp;");
			str = str.replaceAll("<", "&lt;");
			str = str.replaceAll(">", "&gt;");
			str = str.replaceAll("\"", "&quot;");
			return str;
		}
		
		
		/**
		 * 
		 * @param request
		 * @param article
		 * @return
		 * @throws IOException 
		 * @throws IllegalStateException 
		 */
		@PostMapping("updateArticle")
		@ResponseBody
		public MsgResult updateArticle(HttpServletRequest request,
				MultipartFile file, Article article) throws IllegalStateException, IOException {
			//文章id 是否存在
			//用户是否有权限修改
			if(!file.isEmpty()) {
				String picUrl = processFile(file);
				article.setPicture(picUrl);
			}
			int result = articleService.update(article);
			if(result>0) {
				// 成功
				return new MsgResult(1,"",null);
			}else {
				return new MsgResult(2,"失败",null);
			}
		}
}
