package com.lut.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.lut.bean.User;
import com.lut.dao.DBhandleImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GrantAction extends ActionSupport {
	
	@Override
	public String execute(){
		int flag=-1;
		int maid = 0;
		int id=0;
		User u=null;
		try{
		int grant=Integer.valueOf(ServletActionContext.getRequest().getParameter("grant"));
		DBhandleImpl db=new DBhandleImpl();
		 maid=Integer.valueOf(ServletActionContext.getRequest().getParameter("maid"));
		id=Integer.valueOf(ServletActionContext.getRequest().getParameter("id"));
		 flag=db.grantUser(id, 4);
		List<User>users=db.getUsers();
		System.out.println(grant);
		u=db.getUserById(maid);
		ServletActionContext.getRequest().setAttribute("users", users);
		ServletActionContext.getRequest().setAttribute("u", u);
		}catch(Exception e){
			System.out.println(ServletActionContext.getRequest().getParameter("maid"));
			System.out.println(u);
			System.out.println(flag);
			System.out.println(e);
			return  ERROR;
		}
		if(flag==-1)
			return ERROR;
		return SUCCESS;
	}
 
}
