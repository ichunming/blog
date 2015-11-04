/**
 * 文章类
 * chunming 2015/10/20
 */
package com.ichunming.bean;

import java.util.List;

public class Post {
	// id
	private Integer id;
	// 推荐标记
	private String featured;
	// 标题
	private String title;
	// 作者
	private String author;
	// 日期时间
	private String dateTime;
	// 简介
	private String introduce;
	// 内容
	private String content;
	// 链接
	private List<Link> tagList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFeatured() {
		return featured;
	}
	public void setFeatured(String featured) {
		this.featured = featured;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Link> getTagList() {
		return tagList;
	}
	public void setTagList(List<Link> tagList) {
		this.tagList = tagList;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
