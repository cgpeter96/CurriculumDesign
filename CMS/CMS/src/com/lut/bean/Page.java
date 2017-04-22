package com.lut.bean;

import java.io.Serializable;

public class Page implements Serializable {
	private String title;
	private String content;
	private int kind;
	private int role;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public Page() {
		super();
	}
	public Page(String title, String content, int kind, int role) {
		super();
		this.title = title;
		this.content = content;
		this.kind = kind;
		this.role = role;
	}
	
}
