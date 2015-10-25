/**
 * 菜单类
 * 2015/10/24 chunming
 */
package com.ichunming.entity;

public class Menu {
	// id
	private String id;
	// 名称
	private String name;
	// 链接
	private String href;
	
	// default constructor
	public Menu() {}
	// constructor with pars
	public Menu(String id, String name, String href) {
		this.id = id;
		this.name = name;
		this.href = href;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
}
