/**
 * 应用启动监听器
 * 2015/10/20 chunming
 */
package com.ichunming.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ichunming.consts.AppConst;
import com.ichunming.entity.Block;
import com.ichunming.entity.BlockManager;
import com.ichunming.entity.Menu;
import com.ichunming.entity.MenuManager;

/**
 * Application Lifecycle Listener implementation class startupListener
 *
 */
@WebListener
public class startupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public startupListener() {}

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletcontextevent) {
    	System.out.println("应用程序启动...");
    	Menu menu = null;
    	List<Menu> menuList = new ArrayList<Menu>();
    	MenuManager menuManager = new MenuManager();
    	menu = new Menu("0", "首页" ,"shouye");
    	menuList.add(menu);
    	menu = new Menu("1", "学无止境" ,"learn");
    	menuList.add(menu);
    	menu = new Menu("2", "自定义" ,"anything");
    	menuList.add(menu);
    	menu = new Menu("3", "关于我" ,"aboutme");
    	menuList.add(menu);
    	menuManager.setMenuList(menuList);
    	menuManager.setCurrentNav("0");
    	
    	Block block = null;
    	Map<String, Block> blockMap = new HashMap<String, Block>();
    	BlockManager blockManager = new BlockManager();
    	block = new Block("0", AppConst.BLOCK_EVERYDAY, "最新动态", "dongtai");
    	blockMap.put(block.getType(), block);
    	block = new Block("0", AppConst.BLOCK_PART_LIFE, "生活一角", "dongtai");
    	blockMap.put(block.getType(), block);
    	block = new Block("0", AppConst.BLOCK_TAGS, "标签云库", "dongtai");
    	blockMap.put(block.getType(), block);
    	blockManager.setBlockMap(blockMap);
    	
    	servletcontextevent.getServletContext().setAttribute("menuManager", menuManager);
    	servletcontextevent.getServletContext().setAttribute("blockManager", blockManager);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent servletcontextevent) {
    	System.out.println("应用程序关闭...");
    }
	
}
