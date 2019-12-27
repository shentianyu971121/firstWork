package com.shentianyu.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shentianyu.dao.ChannelMapper;
import com.shentianyu.entity.Channel;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class ChannelServiceImplTest {

	//在这里面注入mapper
	@Autowired
	private ChannelMapper channelMapper;
	
	@Test
	public void test() {
		//然后进行测试
		List<Channel> channelList = channelMapper.getChannelList();
		for (Channel channel : channelList) {
			System.out.println(channel);
		}
	}
}
