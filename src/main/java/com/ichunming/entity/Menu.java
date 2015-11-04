/**
 * 菜单类
 * 2015/10/24 chunming
 */
package com.ichunming.entity;

public class Menu {
	// 名称
	private String name;
	// 链接
	private String href;
	
	// default constructor
	public Menu() {}
	
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
