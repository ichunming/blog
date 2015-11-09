/**
 * 画面浮动模块类
 * 2015/10/20 chunming
 */
package com.ichunming.entity;

import java.util.List;

import com.ichunming.bean.Download;
import com.ichunming.bean.Post;
import com.ichunming.bean.Status;
import com.ichunming.bean.Tag;

public class Block {
	
	// 类型
	private String type;
	// 模块名称 
	private String name;
	// 最新动态模块内容
	private Status status;
	// 推荐阅读模块内容
	private List<Post> postList;
	// 标签云库模块内容
	private List<Tag> tagList;
	// 下载专区模块内容
	private List<Download> downloadList;
	
	// default constructor
	public Block() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public List<Download> getDownloadList() {
		return downloadList;
	}

	public void setDownloadList(List<Download> downloadList) {
		this.downloadList = downloadList;
	}
}
