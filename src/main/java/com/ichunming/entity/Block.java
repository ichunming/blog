/**
 * 画面浮动模块类
 * 2015/10/20 chunming
 */
package com.ichunming.entity;

import java.util.List;

import com.ichunming.bean.Status;
import com.ichunming.bean.Link;

public class Block {
	
	// 类型
	private String type;
	// 模块名称 
	private String name;
	// 最新动态模块内容
	private Status status;
	// 标签云库模块内容
	private List<Link> tagList;
	
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

	public List<Link> getTagList() {
		return tagList;
	}

	public void setTagList(List<Link> tagList) {
		this.tagList = tagList;
	}
}
