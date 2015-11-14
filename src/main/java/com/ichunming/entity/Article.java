/**
 * Article类
 * 2015/11/11 chunming
 */
package com.ichunming.entity;

import com.ichunming.bean.Post;

public class Article {
	// Post
	private Post post;
	// 前一篇Id
	private Integer preId;
	// 前一篇Title
	private String preTitle;
	// 后一篇Id
	private Integer nextId;
	// 后一篇Title
	private String nextTitle;
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Integer getPreId() {
		return preId;
	}
	public void setPreId(Integer preId) {
		this.preId = preId;
	}
	public String getPreTitle() {
		return preTitle;
	}
	public void setPreTitle(String preTitle) {
		this.preTitle = preTitle;
	}
	public Integer getNextId() {
		return nextId;
	}
	public void setNextId(Integer nextId) {
		this.nextId = nextId;
	}
	public String getNextTitle() {
		return nextTitle;
	}
	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}
}
