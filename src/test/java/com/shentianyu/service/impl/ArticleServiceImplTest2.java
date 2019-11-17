package com.shentianyu.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.shentianyu.dao.ArticleMapper;
import com.shentianyu.entity.Article;
import com.shentianyu.service.ArticleService;
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class ArticleServiceImplTest2 {

	//注入mapper
	@Autowired
	private ArticleService mapper;
	@Test
	public void test() {
		 PageInfo<Article> listByCat = mapper.getListByCat(1, 0, 3);
		 List<Article> list = listByCat.getList();
		for (Article article : list) {
			System.out.println(article);
		}
	}

}
