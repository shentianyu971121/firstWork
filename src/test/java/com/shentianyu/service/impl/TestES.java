package com.shentianyu.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shentianyu.dao.Article1707d2ES;
import com.shentianyu.dao.ArticleMapper;
import com.shentianyu.entity.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class TestES {

	//去后台查询信息并且进行添加到索引库中
	@Autowired
	private ArticleMapper ArticleMapper;
	@Autowired
	private Article1707d2ES article1707d2es;
	@Test
	public void addArticle() {
		//去后台进行查询
		List<Article> list = ArticleMapper.getArticle();
		System.err.println(list);
		//然后将获取到的信息添加在es中
		article1707d2es.saveAll(list);
	}
	
}
