/**
 * 链接类
 * chunming 2015/10/20
 */
package com.ichunming.bean;

import java.util.List;

public class Link {
	// id
	private Integer id;
	// 类型
	private String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
}
