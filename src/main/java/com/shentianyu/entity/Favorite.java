package com.shentianyu.entity;

import java.util.Date;

public class Favorite {

	private Integer id;
	private Integer userId;
	private Integer articleId;
	private String comment;
	private Date created;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Favorite(Integer id, Integer userId, Integer articleId, String comment, Date created) {
		super();
		this.id = id;
		this.userId = userId;
		this.articleId = articleId;
		this.comment = comment;
		this.created = created;
	}
	@Override
	public String toString() {
		return "Favorite [id=" + id + ", userId=" + userId + ", articleId=" + articleId + ", comment=" + comment
				+ ", created=" + created + "]";
	}
	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

}
