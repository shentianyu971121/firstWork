package com.shentianyu.entity;

import java.io.Serializable;

public class Category implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 8707015428794071925L;
	private Integer id;
	private String name;
	//频道的Id
	private Integer channelId;
	//频道对象
	private Channel channel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Category(Integer id, String name, Integer channelId, Channel channel) {
		super();
		this.id = id;
		this.name = name;
		this.channelId = channelId;
		this.channel = channel;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", channelId=" + channelId + ", channel=" + channel + "]";
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
