package com.shentianyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.shentianyu.dao.ChannelMapper;
import com.shentianyu.entity.Channel;
import com.shentianyu.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {

	//在这里面注入mapper
	@Autowired
	private ChannelMapper channelMapper;
	//注入redisTemplate
	@Autowired
	private RedisTemplate redisTemplate;
	/**
	 * 查询所有的频道
	 */
	@Override
	public List<Channel> getChannelList() {
		//想redis中查询看是否为空
		List<Channel> range = redisTemplate.opsForList().range("channelList", 0, -1);
		if(range == null || range.size() == 0) {
			System.err.println("去mysql进行第一次查询");
			//然后进行mysql查询
			List<Channel> channelList = channelMapper.getChannelList();
			//查询完成之后添加到redis数据库中
			redisTemplate.opsForList().rightPushAll("channelList", channelList);
			return channelList;
		}
		
		System.err.println("redis直接返回");
		return range;
	}
}
