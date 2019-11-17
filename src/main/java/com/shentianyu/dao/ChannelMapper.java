package com.shentianyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.shentianyu.entity.Channel;

public interface ChannelMapper {

	/**
	 * 
	 * @Title: getChannelList 
	 * @Description: 查询所有的频道
	 * @return
	 * @return: List<Channel>
	 */
	@Select("select * from cms_channel")
	List<Channel> getChannelList();

}
