package com.shentianyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shentianyu.common.ConstantClass;
import com.shentianyu.dao.ArticleMapper;
import com.shentianyu.entity.Article;
import com.shentianyu.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {

	//注入文章类的mapper接口
	@Autowired
	private ArticleMapper articleMapper;
	//获取所有的热门集合
	@Override
	public PageInfo getHotGetList(int pageNum) {
		//首先给热门进行分页
		PageHelper.startPage(pageNum, 3);
		
		return new PageInfo(articleMapper.getHotList());
	}
	//获取新的文章
	@Override
	public List<Article> getNewArticles(int i) {
		// TODO Auto-generated method stub
		return articleMapper.getNewArticles(i);
	}
	@Override
	public PageInfo<Article> getListByCat(int chnId, int categoryId, int pageNum) {
		// TODO Auto-generated method stub
		//首先进行分页
		PageHelper.startPage(pageNum, 3);
		
		return new PageInfo<Article>(articleMapper.getListByCat(chnId,categoryId));
	}
	//通过ID查询出来对象
	@Override
	public Article getArticleById(int articleId) {
		// TODO Auto-generated method stub
		return articleMapper.getArticliById(articleId);
	}
	/**
	 * 通过userid查询出来文章列表
	 */
	@Override
	public PageInfo<Article> getArticleByUserIs(Integer id, int pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 5);
		//然后去mapper层进行查询
		List<Article> list = articleMapper.getArticleByUserId(id);
		return new PageInfo<Article>(list);
	}
	//查询所有的文章
	@Override
	public PageInfo<Article> getAllArticleByAdmin(int pageNum) {
		//首先进行分页
		PageHelper.startPage(pageNum, 5);
		//然后进行查询所有的信息
		List<Article> list = articleMapper.getAllArticleByAdmin();
		return new PageInfo<Article>(list);
	}
	//查询未审核的文章
	@Override
	public List<Article> getArticleByStatus(Integer id) {
		
		return articleMapper.getArticleByStatus(id);
	}
	//查询已经删除的文章
	@Override
	public List<Article> getArticleByDelete(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.getArticleByDelete(id);
	}
	/**
	 * 删除信息  也就是修改  信息
	 */
	@Override
	public int articleDel(Integer id) {
		//
		return articleMapper.articleDel(id);
	}
	/**
	 * 通过ID查询出来信息并且回显
	 */
	@Override
	public Article showArticleById(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.showArticleById(id);
	}
	//通过Id修改审核通过或不通过
	@Override
	public int adminUpdateStatus(Integer id, Integer status) {
		// TODO Auto-generated method stub
		return articleMapper.adminUpdateStatus(id, status);
	}
	//通过ID修改是否 为热门
	@Override
	public int adminUpdateHot(Integer id, Integer hot) {
		// TODO Auto-generated method stub
		return articleMapper.adminUpdateHot(id,hot);
	}
	//发布文章
	@Override
	public int add(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.add(article);
	}
	//查询ID是否 存在 然后进行删除
	@Override
	public Article getArticleByIdToDeleteByUser(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.getArticleByIdToDeleteByUser(id);
	}
	//逻辑删除 也就是修改deleted的信息
	@Override
	public int userUpdateDelete(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.userUpdateDelete(id);
	}
	//修改文章
	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.update(article);
	}
	//查询Id的最大值
	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		return articleMapper.getMaxId();
	}
	//添加图片
	@Override
	public int addArticle(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.addArticle(article);
	}
	/**
	 * 获取最新的文章图片
	 */
	@Override
	public List<Article> getImgArticles(int i) {
		// TODO Auto-generated method stub
		return articleMapper.getImgArticles(i);
	}

}
