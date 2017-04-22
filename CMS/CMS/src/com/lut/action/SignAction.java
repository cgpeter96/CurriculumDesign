package com.lut.action;

import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.lut.bean.User;
import com.lut.dao.DBhandleImpl;
import com.opensymphony.xwork2.ActionSupport;

public class SignAction extends ActionSupport {
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String username=ServletActionContext.getRequest().getParameter("username");
		String password=ServletActionContext.getRequest().getParameter("password");
		int role=Integer.valueOf(ServletActionContext.getRequest().getParameter("role"));
		User u=new User(username,password,role);
		DBhandleImpl db=new DBhandleImpl();
		int flag=db.addUser(u);
		if(flag>0){
			return SUCCESS;
		}
		return ERROR;
	}
	
}
