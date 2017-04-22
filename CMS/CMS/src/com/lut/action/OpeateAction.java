package com.lut.action;

import org.apache.struts2.ServletActionContext;

import com.lut.bean.User;
import com.lut.dao.DBhandleImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OpeateAction extends ActionSupport {
	private User u;
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	@Override
	public String execute() throws Exception {
		int ch=Integer.valueOf((String) ServletActionContext.getRequest().getParameter("ch"));
		
		int maid=Integer.valueOf((String) ServletActionContext.getRequest().getParameter("maid"));
		ServletActionContext.getRequest().setAttribute("id", ch);
		DBhandleImpl db=new DBhandleImpl();
		User usr=db.getUserById(ch);
		User u=db.getUserById(maid);
		System.out.println(u+"in oa"); 
		ServletActionContext.getRequest().setAttribute("u", u);
		ServletActionContext.getRequest().setAttribute("modify", usr);
		return "grant";
	}
	
	
}
