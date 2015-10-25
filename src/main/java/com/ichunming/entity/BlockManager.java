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
		return blockMap.get(AppConst.BLOCK_EVERYDAY);
	}
	
	// 取得 生活一角 模块
	public Block getBlockPartLife() {
		return blockMap.get(AppConst.BLOCK_PART_LIFE);
	}
	
	// 取得 标签云库 模块
	public Block getBlockTags() {
		return blockMap.get(AppConst.BLOCK_TAGS);
	}
}
