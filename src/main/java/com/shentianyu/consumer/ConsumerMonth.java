package com.shentianyu.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.shentianyu.entity.Article;
import com.shentianyu.service.ArticleService;

/**
 * 
 * @ClassName: ConsumerMonth 
 * @Description: kafka消费者接受kafka发送来的信息
 * @author:jyj 
 * @date: 2019年12月24日 下午1:57:15
 */
public class ConsumerMonth implements MessageListener<String, String> {

	@Autowired
	private ArticleService articleService;
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		String value = data.value();
		if(value.startsWith("hits")) {
			//然后对数据进行切割
			String[] split = value.split("=");
			//(3)编写Kafka消费者，接收文章ID。[核心]（8分） 
			int id = Integer.parseInt(split[1]);
			//然后去数据库中查询id为这个对象
			Article article = articleService.getArticleById(id);
			//(4)Kafka消费端执行数据库加1操作。[核心]（4分）
			article.setHits(article.getHits() + 1);
			//然后调用方法向数据库中进行修改
			articleService.updateHits(article);
		} else {
			//(6)编写Kafka消费者，将接到的数据保存到CMS项目数据库。[核心]（6分）
			
			Article article = JSON.parseObject(value, Article.class);
			//将接到的数据保存到CMS项目数据库。[核心]（6分）
			articleService.add(article);
		}
		
	}

}
