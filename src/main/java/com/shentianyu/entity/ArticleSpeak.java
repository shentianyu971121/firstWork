package com.shentianyu.entity;

import java.util.List;

/**
 * 
 * @ClassName: ArticleSpeak 
 * @Description: 评论的类
 * @author:jyj 
 * @date: 2019年11月22日 下午1:36:43
 */
public class ArticleSpeak {
	
	//评论的Id
	private String id;
	//文章的ID
	private String articleId;
	//用户的Id
	private User user;
	//评论
	private String content;
	//评论时间
	private String created;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public ArticleSpeak(String id, String articleId, User user, String content, String created) {
		super();
		this.id = id;
		this.articleId = articleId;
		this.user = user;
		this.content = content;
		this.created = created;
	}
	@Override
	public String toString() {
		return "ArticleSpeak [id=" + id + ", articleId=" + articleId + ", user=" + user + ", content=" + content
				+ ", created=" + created + "]";
	}
	public ArticleSpeak() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
