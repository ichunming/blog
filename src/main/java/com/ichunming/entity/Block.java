/**
 * 画面浮动模块类
 * 2015/10/20 chunming
 */
package com.ichunming.entity;

import java.util.List;
import com.ichunming.bean.Link;

public class Block {
	
	// id
	private String id;
	// 类型
	private String type;
	// 模块名称 
	private String name;
	// 模块名称链接
	private String href;
	// 模块链接
	private List<Link> linkList;
	
	// default constructor
	public Block() {}
	
	// constructor with pars
	public Block(String id, String type, String name, String href) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.href = href;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<Link> getLinkList() {
		return linkList;
	}
	public void setLinkList(List<Link> linkList) {
		this.linkList = linkList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
