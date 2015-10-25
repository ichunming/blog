/**
 * 菜单管理类
 * 2015/10/24 chunming
 */
package com.ichunming.entity;

import java.util.List;

public class MenuManager {
	// 菜单List
	private List<Menu> menuList;
	// 当前活动菜单项
	private String currentNav;
	
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public String getCurrentNav() {
		return currentNav;
	}
	public void setCurrentNav(String currentNav) {
		this.currentNav = currentNav;
	}
}
