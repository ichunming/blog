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
		//Block blockEveryday = null;
		return blockMap != null?blockMap.get(AppConst.BLOCK_EVERYDAY):null;
	}
	
	// 取得 标签云库 模块
	public Block getBlockTags() {
		return blockMap != null?blockMap.get(AppConst.BLOCK_TAGS):null;
	}
}
