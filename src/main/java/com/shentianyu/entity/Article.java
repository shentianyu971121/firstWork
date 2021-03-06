package com.shentianyu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(indexName = "cms_article", type = "article")
public class Article implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 4360745322968649468L;
	
	@Id
	private Integer id;
	//这个是文章的标题
	@Field(index = true, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart", type = FieldType.text)
	private String title;
	//文章的内容
	@Field(index = true, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart", type = FieldType.text)
	private String content;
//	文章的地址
	private String picture;
//	这个就是频道ID
	private Integer channelId;
//	创建频道对象  因为需要在数据库中查询频道
	/* @JsonIgnore */
	private Channel channel;
	//cateGory是文章的ID
	private Integer categoryId;
	//创建文章的对象 因为也需要查询文章的信息
	//jsonIgnore就是为了让高量忽略对象  现在直接在工具类中忽略  不用这个注解的原因是因为其他用到对象的json字符串会报错
	/* @JsonIgnore */
	private Category category;
	//user对象的id  因为article里面也有user查询
	private Integer userId;
	/* @JsonIgnore */
	private User user;
	//是点击数量
	private int hits;
	//是否是热门文章 1是 0不是
	private int hot;
	//状态   0待审核1审核通过2审核未通过
	private int status;
	//是否被删除 
	private int deleted;
	//发表的时间
	private Date created;
	//最后修改 时间
	private Date updated;
	//评论的数量
	private int commentCnt;
	//文章类型  并且赋初值 为html类型  数据库里面也就是0
	/* @JsonIgnore */
	private TypeEnum  articleType = TypeEnum.HTML;
	//图片的集合
	/* @JsonIgnore */
	private List<Image> images;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public TypeEnum getArticleType() {
		return articleType;
	}
	public void setArticleType(TypeEnum articleType) {
		this.articleType = articleType;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Article(Integer id, String title, String content, String picture, Integer channelId, Channel channel,
			Integer categoryId, Category category, Integer userId, User user, int hits, int hot, int status,
			int deleted, Date created, Date updated, int commentCnt, TypeEnum articleType, List<Image> images) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.channelId = channelId;
		this.channel = channel;
		this.categoryId = categoryId;
		this.category = category;
		this.userId = userId;
		this.user = user;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
		this.commentCnt = commentCnt;
		this.articleType = articleType;
		this.images = images;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", picture=" + picture
				+ ", channelId=" + channelId + ", channel=" + channel + ", categoryId=" + categoryId + ", category="
				+ category + ", userId=" + userId + ", user=" + user + ", hits=" + hits + ", hot=" + hot + ", status="
				+ status + ", deleted=" + deleted + ", created=" + created + ", updated=" + updated + ", commentCnt="
				+ commentCnt + ", articleType=" + articleType + ", images=" + images + "]";
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
