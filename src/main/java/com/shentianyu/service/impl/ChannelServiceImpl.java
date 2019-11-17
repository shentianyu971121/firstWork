package com.shentianyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shentianyu.dao.ChannelMapper;
import com.shentianyu.entity.Channel;
import com.shentianyu.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {

	//在这里面注入mapper
	@Autowired
	private ChannelMapper channelMapper;
	/**
	 * 查询所有的频道
	 */
	@Override
	public List<Channel> getChannelList() {
		//然后进行查询
		return channelMapper.getChannelList();
	}

	
	
	
	
	
}
