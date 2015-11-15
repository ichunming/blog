/**
 * MessageManager
 * 2015/11/14 chunming
 */
package com.ichunming.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.ichunming.consts.AppConst;
import com.ichunming.entity.CustomInfo;

public class MessageManager {
	// message map
	private static Map<String, String> messageMap = new HashMap<String, String>();
	
	// load message
	public static void loadMessage(String messagePath) {
		
		Properties prop = new Properties();
		InputStream is = null;
		String loadSuccess = "message load success!";
		String loadError = "run into an error when load message!";
		
		try {
			is = new FileInputStream(messagePath);
			prop.load(is);
			// key set
			Set<Object> keySet = prop.keySet();
			Iterator<Object> it = keySet.iterator();
			String key = "";
			messageMap.clear();
			// add message to map
			while(it.hasNext()) {
				key = (String)it.next(); 
				messageMap.put(key, prop.getProperty(key));
			}
			// print status
			System.out.println(loadSuccess);
		} catch (FileNotFoundException e) {
			// print status
			System.out.println(loadError);
			e.printStackTrace();
		} catch (IOException e) {
			// print status
			System.out.println(loadError);
			e.printStackTrace();
		} finally {
			if(null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// print status
					System.out.println(loadError);
					e.printStackTrace();
				}
			}
		}
	}
	
	// get info message
	public static CustomInfo findInfoMsg(String code) {
		return findMsg(code, AppConst.CODE_INFO);
	}
	
	// get warning message
	public static CustomInfo findWarnMsg(String code) {
		return findMsg(code, AppConst.CODE_WARING);
	}
	
	// get error message
	public static CustomInfo findErrorMsg(String code) {
		return findMsg(code, AppConst.CODE_EXCEPTION);
	}
	
	// get info message with parameters
	public static CustomInfo findInfoMsg(String code, String[] params) {
		return findMsg(code, AppConst.CODE_INFO, params);
	}
	
	// get warning message with parameters
	public static CustomInfo findWarnMsg(String code, String[] params) {
		return findMsg(code, AppConst.CODE_WARING, params);
	}
	
	// get error message with parameters
	public static CustomInfo findErrorMsg(String code, String[] params) {
		return findMsg(code, AppConst.CODE_EXCEPTION, params);
	}
	
	// get message
	private static CustomInfo findMsg(String code, String type) {
		CustomInfo info = new CustomInfo();
		info.setCode(type);
		info.setMessage(messageMap.get(code));
		return info;
	}
	
	// get message with parameters
	private static CustomInfo findMsg(String code, String type, String[] params) {
		String msg = messageMap.get(code);
		if(null != msg) {
			for(int i = 0; i < params.length; i++) {
				msg = msg.replace("{" + i + "}", params[i]);
			}
		}
		CustomInfo info = new CustomInfo();
		info.setCode(type);
		info.setMessage(msg);
		return info;
	}
}
