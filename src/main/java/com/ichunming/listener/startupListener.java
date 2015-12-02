/**
 * 应用启动监听器
 * 2015/10/20 chunming
 */
package com.ichunming.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import com.ichunming.common.BlockManager;
import com.ichunming.common.MenuManager;
import com.ichunming.common.MessageManager;
import com.ichunming.entity.Menu;
import com.ichunming.util.XMLUtil;

/**
 * Application Lifecycle Listener implementation class startupListener
 *
 */
@WebListener
public class startupListener implements ServletContextListener {

	 WebApplicationContext  webApplicationContext = null;
	 Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * Default constructor. 
     */
    public startupListener() {}

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletcontextevent) {
    	logger.info("应用程序启动...");
    	
    	XMLUtil xmlUtil = new XMLUtil();
    	// load menu
    	List<Menu> menuList = xmlUtil.loadXML(this.getClass().getClassLoader().getResource("menu.xml").getPath(), Menu.class);
    	MenuManager menuManager = new MenuManager();
    	menuManager.setMenuList(menuList);
    	// load block
    	BlockManager blockManager = new BlockManager();
    	blockManager.init();
    	// 保存block,menu
    	servletcontextevent.getServletContext().setAttribute("menuManager", menuManager);
    	servletcontextevent.getServletContext().setAttribute("blockManager", blockManager);
    	
    	// load message
    	MessageManager.loadMessage(this.getClass().getClassLoader().getResource("message.properties").getPath());
		
		// success
		logger.info("应用程序启动成功!");
    }
   
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent servletcontextevent) {
    	logger.info("应用程序关闭...");
    }
	
}
