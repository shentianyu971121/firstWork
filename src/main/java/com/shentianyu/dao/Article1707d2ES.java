package com.shentianyu.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.shentianyu.entity.Article;

public interface Article1707d2ES extends ElasticsearchRepository<Article, Integer> {

	public List<Article> findByTitle(String key);
	
}
