/**
 * 应用启动监听器
 * 2015/10/20 chunming
 */
package com.ichunming.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ichunming.entity.Block;
import com.ichunming.entity.BlockManager;
import com.ichunming.entity.Menu;
import com.ichunming.entity.MenuManager;
import com.ichunming.util.XMLUtil;

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
    	XMLUtil xmlUtil = new XMLUtil();
    	// load menu
    	List<Menu> menuList = xmlUtil.loadXML(this.getClass().getClassLoader().getResource("menu.xml").getPath(), Menu.class);
    	MenuManager menuManager = new MenuManager();
    	menuManager.setMenuList(menuList);
    	menuManager.setCurrentNav("0");
    	
    	// load block
    	List<Block> blockList = xmlUtil.loadXML(this.getClass().getClassLoader().getResource("block.xml").getPath(), Block.class);
    	Map<String, Block> blockMap = null;
    	if (null != blockList) {
    		blockMap = new HashMap<String, Block>();
        	for (Block block : blockList) {
        		
        		blockMap.put(block.getType(), block);
        	}
    	}
    	BlockManager blockManager = new BlockManager();
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
