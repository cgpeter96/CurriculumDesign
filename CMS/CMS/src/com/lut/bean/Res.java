package com.lut.bean;

public class Res {
	private int id;
	public Res() {
		super();
	}
	public Res(int id, String title, String content, int kind, int role) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.kind = kind;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	private String title;
	private String content;
	private int kind;
	private int role;
	
}
