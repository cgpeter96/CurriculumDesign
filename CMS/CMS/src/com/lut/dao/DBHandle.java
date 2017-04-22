package com.lut.dao;

import java.util.List;

import com.lut.bean.User;

public interface DBHandle {
	public int addUser(User u);
	public int isExist(User u);
	public int delUser(User u);
	public User getUser(String s);
	public List<User> getUsers();
	public User getUserById(int id);
	public int grantUser(int id,int role);
}
