package com.shentianyu.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

public class AdminFavorite {
	
	private Integer id;
	@Size(min = 2, max = 8, message = "名称最少两个字,最多八个字")
	private String name;
	@URL(message = "请填写正确的url地址")
	private String url;
	private Integer userid;
	private User user;
	private Date created;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public AdminFavorite(Integer id, String name, String url, Integer userid, User user, Date created) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.userid = userid;
		this.user = user;
		this.created = created;
	}
	@Override
	public String toString() {
		return "AdminFavorite [id=" + id + ", name=" + name + ", url=" + url + ", userid=" + userid + ", user=" + user
				+ ", created=" + created + "]";
	}
	public AdminFavorite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}




