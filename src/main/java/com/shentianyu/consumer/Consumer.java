package com.shentianyu.consumer;

 import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.shentianyu.dao.Article1707d2ES;
import com.shentianyu.dao.ArticleMapper;
import com.shentianyu.entity.Article;
import com.shentianyu.service.ArticleService;
import com.sty.utils.NumberUtils;

public class Consumer implements MessageListener<String, String> {

	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private Article1707d2ES article1707d2es;
	@Autowired
	private ArticleService articleService;
	//进行数据接收 并且进行添加到mysql数据库
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		// TODO Auto-generated method stub
//		System.err.println("接受到的信息0 : " + data.value());
		String value = data.value();
		//value就是我们接受到的信息
		if(value.startsWith("add")) {
			System.err.println(value + "aaaaaa--------------------");
			//就对redis进行一次删除
			redisTemplate.delete("hotList");
			//然后对add进行分割
			String[] split = value.split("=");
			Article parseObject = JSON.parseObject(split[1],  Article.class);
			System.out.println(parseObject);
			//切割完之后将数据添加在es中
			article1707d2es.save(parseObject);
		} else if(value.startsWith("update")) {
			System.err.println("update");
			redisTemplate.delete("hotList");
			String[] split = value.split("=");
			Article parseObject = JSON.parseObject(split[1],  Article.class);
			System.out.println(parseObject);
			//切割完之后将数据添加在es中
			article1707d2es.save(parseObject);
		} else if(value.startsWith("del")) {
			redisTemplate.delete("del");
			String[] split = value.split("=");
			article1707d2es.deleteById(Integer.parseInt(split[1]));
		}  else {
			System.out.println("添加数据=============");
			//已经接受到了信息   我们需要把字符串转换为对象 然后存出来数据库中
			Article article = JSON.parseObject(data.value(), Article.class);       
			//进行数据添加
			articleMapper.add(article);
		}
	}
	
}








