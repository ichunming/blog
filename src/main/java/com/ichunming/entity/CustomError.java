/**
 * 自定义Error
 * 2015/11/14 chunming
 */
package com.ichunming.entity;

public class CustomError {
	// error code
	private String code;
	// error message
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
