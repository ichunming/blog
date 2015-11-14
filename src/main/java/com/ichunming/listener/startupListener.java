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

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ichunming.bean.Download;
import com.ichunming.bean.Post;
import com.ichunming.bean.Status;
import com.ichunming.bean.Tag;
import com.ichunming.common.BlockManager;
import com.ichunming.common.MenuManager;
import com.ichunming.common.MessageManager;
import com.ichunming.consts.AppConst;
import com.ichunming.consts.BizConst;
import com.ichunming.entity.Block;
import com.ichunming.entity.Menu;
import com.ichunming.entity.Page;
import com.ichunming.iservice.IDownloadService;
import com.ichunming.iservice.IPostService;
import com.ichunming.iservice.IStatusService;
import com.ichunming.iservice.ITagService;
import com.ichunming.util.XMLUtil;

/**
 * Application Lifecycle Listener implementation class startupListener
 *
 */
@WebListener
public class startupListener implements ServletContextListener {

	 WebApplicationContext  webApplicationContext = null;
    /**
     * Default constructor. 
     */
    public startupListener() {}

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletcontextevent) {
    	System.out.println("应用程序启动...");
    	// 获取应用程序上下文
    	webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletcontextevent.getServletContext());
    	String appPath = webApplicationContext.getServletContext().getContextPath();
    	XMLUtil xmlUtil = new XMLUtil();
    	// load menu
    	List<Menu> menuList = xmlUtil.loadXML(this.getClass().getClassLoader().getResource("menu.xml").getPath(), Menu.class);
    	MenuManager menuManager = new MenuManager();
    	menuManager.setMenuList(menuList);
    	menuManager.setCurrentNav(AppConst.MENU_INDEX);
    	    	
    	// load block
    	List<Block> blockList = xmlUtil.loadXML(this.getClass().getClassLoader().getResource("block.xml").getPath(), Block.class);
    	Map<String, Block> blockMap = null;
    	if (null != blockList) {
    		blockMap = new HashMap<String, Block>();
        	for (Block block : blockList) {
        		// 填充内容
        		fillBlock(block);
        		blockMap.put(block.getType(), block);
        	}
    	}
    	BlockManager blockManager = new BlockManager();
    	blockManager.setBlockMap(blockMap);
    	// 保存appPath,block,menu
    	servletcontextevent.getServletContext().setAttribute("appPath", appPath);
    	servletcontextevent.getServletContext().setAttribute("menuManager", menuManager);
    	servletcontextevent.getServletContext().setAttribute("blockManager", blockManager);
    	
    	// load message
    	MessageManager.loadMessage(this.getClass().getClassLoader().getResource("message.properties").getPath());
    }
    
    /**
     * 填充block内容
     */
    private void fillBlock(Block block) {
    	if(AppConst.BLOCK_EVERYDAY.equals(block.getType())) {
    		// 最新动态模块
    		IStatusService statusService = webApplicationContext.getBean(IStatusService.class);
    		Status status = statusService.findNewestStatus();
    		statusService.procContent(status);
    		block.setStatus(status);
    		
    	}else if(AppConst.BLOCK_TAGS.equals(block.getType())) {
    		// 标签库模块
    		ITagService tagService = webApplicationContext.getBean(ITagService.class);
    		List<Tag> tagList = tagService.findAllTags();
    		block.setTagList(tagList);
    		
    	}else if(AppConst.BLOCK_RECOMMEND.equals(block.getType())) {
    		// 推荐阅读模块
    		IPostService postService = webApplicationContext.getBean(IPostService.class);
    		Page page = new Page();
    		page.setDbIndex(0);
    		page.setDbNumber(BizConst.RECOMMEND_POST_COUNT);
    		// 推荐阅读文章
    		page.setFeatured(BizConst.POST_TYPE_FEATURED);
    		List<Post> postList = postService.findPosts(page);
    		block.setPostList(postList);
    		
    	}else if(AppConst.BLOCK_DOWNLOAD.equals(block.getType())) {
    		// 下载专区模块
    		IDownloadService downloadService = webApplicationContext.getBean(IDownloadService.class);
    		List<Download> downloadList = downloadService.findNewestDownloadList(BizConst.DOWNLOAD_LIST_COUNT);
    		block.setDownloadList(downloadList);
    	}
    }
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent servletcontextevent) {
    	System.out.println("应用程序关闭...");
    }
	
}
