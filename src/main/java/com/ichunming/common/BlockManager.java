/**
 * Block 模块管理类
 * 2015/10/20 chunming
 */
package com.ichunming.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ichunming.bean.Download;
import com.ichunming.bean.Post;
import com.ichunming.bean.Status;
import com.ichunming.bean.Tag;
import com.ichunming.consts.AppConst;
import com.ichunming.consts.BizConst;
import com.ichunming.entity.Block;
import com.ichunming.entity.Page;
import com.ichunming.iservice.IDownloadService;
import com.ichunming.iservice.IPostService;
import com.ichunming.iservice.IStatusService;
import com.ichunming.iservice.ITagService;
import com.ichunming.util.SpringContextUtil;
import com.ichunming.util.XMLUtil;

public class BlockManager {
	
	// 模块Map
	private Map<String, Block> blockMap;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// set blockMap
	public void setBlockMap(Map<String, Block> blockMap) {
		this.blockMap = blockMap;
	}
	
	// 取得 最新动态 模块
	public Block getBlockEveryday() {
		return blockMap != null?blockMap.get(AppConst.BLOCK_EVERYDAY):null;
	}
	
	// 取得 标签云库 模块
	public Block getBlockTags() {
		return blockMap != null?blockMap.get(AppConst.BLOCK_TAGS):null;
	}
	
	// 取得 推荐阅读 模块
	public Block getBlockRecommend() {
		return blockMap != null?blockMap.get(AppConst.BLOCK_RECOMMEND):null;
	}
	
	// 取得 下载专区 模块
	public Block getBlockDownload() {
		return blockMap != null?blockMap.get(AppConst.BLOCK_DOWNLOAD):null;
	}
	
	// init
	public void init() {
    	// load block
		XMLUtil xmlUtil = new XMLUtil();
    	List<Block> blockList = xmlUtil.loadXML(this.getClass().getClassLoader().getResource("block.xml").getPath(), Block.class);
    	if (null != blockList) {
    		blockMap = new HashMap<String, Block>();
        	for (Block block : blockList) {
        		// 填充内容
        		fillBlock(block);
        		blockMap.put(block.getType(), block);
        	}
    	}
	}
    
	// update
	public void update() {
		for(Block block : blockMap.values()) {
			fillBlock(block);
		}
	}
	
    /**
     * 填充block内容
     */
    private void fillBlock(Block block) {
    	if(AppConst.BLOCK_EVERYDAY.equals(block.getType())) {
    		// 最新动态模块
    		IStatusService statusService = SpringContextUtil.getBean(IStatusService.class);
    		Status status = statusService.findNewestStatus();
    		if(null != status) {
        		statusService.procContent(status);
        		block.setStatus(status);
        		logger.info("最新动态模块加载完毕！");
    		}
    	}else if(AppConst.BLOCK_TAGS.equals(block.getType())) {
    		// 标签库模块
    		ITagService tagService = SpringContextUtil.getBean(ITagService.class);
    		List<Tag> tagList = tagService.findAllTags();
    		if(null != tagList && tagList.size() > 0) {
    			block.setTagList(tagList);
    			logger.info("标签库模块加载完毕！");
    		}
    	}else if(AppConst.BLOCK_RECOMMEND.equals(block.getType())) {
    		// 推荐阅读模块
    		IPostService postService = SpringContextUtil.getBean(IPostService.class);
    		Page page = new Page();
    		page.setDbIndex(0);
    		page.setDbNumber(BizConst.RECOMMEND_POST_COUNT);
    		// 推荐阅读文章
    		page.setFeatured(BizConst.POST_TYPE_FEATURED);
    		List<Post> postList = postService.findPosts(page);
    		if(null != postList && postList.size() > 0) {
    			block.setPostList(postList);
    			logger.info("推荐阅读模块加载完毕！");
    		}
    	}else if(AppConst.BLOCK_DOWNLOAD.equals(block.getType())) {
    		// 下载专区模块
    		IDownloadService downloadService = SpringContextUtil.getBean(IDownloadService.class);
    		List<Download> downloadList = downloadService.findNewestDownloadList(BizConst.DOWNLOAD_LIST_COUNT);
    		if(null != downloadList && downloadList.size() > 0) {
    			block.setDownloadList(downloadList);
    			logger.info("下载专区模块加载完毕！");
    		}
    	}
    }
 
}
