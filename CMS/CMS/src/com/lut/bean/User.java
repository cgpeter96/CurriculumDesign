package com.lut.bean;

import java.io.Serializable;

public class User implements Serializable{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+"-"+username;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String username;
	private String password;
	private int role=2; //Ä¬ÈÏÎª2
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public User() {
		super();
	}
	public void setRole(int role) {
		this.role = role;
	}
	public User(String username, String password, int role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
}
