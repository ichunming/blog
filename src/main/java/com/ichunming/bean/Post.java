/**
 * 文章类
 * chunming 2015/10/20
 */
package com.ichunming.bean;

import java.util.List;

public class Post {
	// id
	private String id;
	// 推荐标记
	private String featured;
	// 标题
	private String title;
	// 作者
	private String author;
	// 日期时间
	private String dateTime;
	// 内容
	private String content;
	// 链接
	private List<Link> linkList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public List<Link> getLinks() {
		return linkList;
	}
	public void setLinks(List<Link> linkList) {
		this.linkList = linkList;
	}
}
