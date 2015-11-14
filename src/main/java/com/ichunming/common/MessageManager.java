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
	
	// find message by code
	public static String findMessage(String code) {
		return messageMap.get(code);
	}
}
