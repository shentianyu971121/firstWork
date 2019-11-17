package com.shentianyu.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shentianyu.dao.ArticleMapper;
import com.shentianyu.entity.Article;
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class ArticleServiceImplTest {

	//注入mapper
	@Autowired
	ArticleMapper mapper;
	@Test
	public void test() {
		List hotList = mapper.getHotList();
		for (Object object : hotList) {
			System.out.println(object);
		}
	}
	@Test
	public void test2() {
		List<Article> newArticles = mapper.getNewArticles(5);
		for (Article article : newArticles) {
			System.out.println(article);
		}
	}
	
	@Test
	public void test3() {
		Article articliById = mapper.getArticliById(10);
	}
	
}
