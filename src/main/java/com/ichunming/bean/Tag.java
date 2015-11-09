/**
 * 标签类
 * chunming 2015/10/20
 */
package com.ichunming.bean;

import java.util.List;

public class Tag {
	// id
	private Integer id;
	// 链接内容
	private String content;
	// 文章List
	private List<Post> postList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
}
