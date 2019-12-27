package com.shentianyu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.shentianyu.entity.Article;
import com.sty.utils.DateUtils;
import com.sty.utils.NumberUtils;
import com.sty.utils.StringUtils;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class MonthIO {
	
	//注入kafka模板 进行kafka发送信息
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Test
	public void readMonth() throws Exception {
		List<String> readTitleAndConments = StringUtils.readTitleAndConments("D:/week");
		List<Article> list = new ArrayList<Article>();
		for (String string : readTitleAndConments) {
			Article article = new Article();
			//然后对Article进行切割
			String[] split = string.split("=");
			//(1)将文件名作为Article对象的title属性值。
			//文本内容作为Article对象的content属性值。（2分）
			article.setTitle(split[0]);
			//判断文章内容是否有140个字
			if(split[1].length()>=140) {
				//(2)在文本内容中截取前140个字作为摘要。（2分）
				String content = split[1].substring(0, 139);
				article.setContent(content);
			} else {
				article.setContent(split[1]);
			}
			//(3)“点击量”和“、段要使用随机值。（2分）
			int hits = NumberUtils.getRandomInt(0, 100);
			article.setHits(hits);
			//“频道”字
			int channelId = NumberUtils.getRandomInt(1, 8);
			article.setChannelId(channelId);
			//是否热门”
			int hot = NumberUtils.getRandomInt(0, 1);
			article.setHot(hot);
			//文章发布日期从2019年1月1日模拟到今天
			Date created = DateUtils.randomDate("2019-01-01", "2019-12-24");
			article.setCreated(created);
			int userId = NumberUtils.getRandomInt(30, 51);
			article.setUserId(userId);
			list.add(article);
		}
		for (Article article : list) {
			//将对象转换为json对象
			String jsonString = JSON.toJSONString(article);
			//将消息发送给kafka
			kafkaTemplate.send("articles", jsonString);
		}
	}
}
