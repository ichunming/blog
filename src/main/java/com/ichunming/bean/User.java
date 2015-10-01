package com.ichunming.bean;

public class User {
	private int id;
	private String name;
	private String code;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void print() {
		System.out.println("id:" + id + " name:" + name + " code:" + code);
	}
}
