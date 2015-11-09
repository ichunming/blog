/**
 * Block 模块管理类
 * 2015/10/20 chunming
 */
package com.ichunming.entity;

import java.util.Map;

import com.ichunming.consts.AppConst;

public class BlockManager {
	
	// 模块Map
	private Map<String, Block> blockMap;
	
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
}
