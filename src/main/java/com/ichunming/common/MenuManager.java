/**
 * 菜单管理类
 * 2015/10/24 chunming
 */
package com.ichunming.common;

import java.util.List;

import com.ichunming.entity.Menu;

public class MenuManager {
	// 菜单List
	private List<Menu> menuList;
	
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
}
