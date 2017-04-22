package com.lut.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.lut.bean.Page;
import com.lut.bean.User;
import com.lut.dao.DBhandleImpl;
import com.lut.dao.ResDBimpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.bind.v2.schemagen.episode.Package;

public class LoginAction extends ActionSupport {
	private User u;
	private List<Page>pages;
	public List<Page> getPages() {
		return pages;
	}
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	@Override
	public String execute() throws Exception {
		setPages();
		String username=ServletActionContext.getRequest().getParameter("username");
		String password=ServletActionContext.getRequest().getParameter("password");
		ServletActionContext.getRequest().setAttribute("username", username);
		ServletActionContext.getRequest().setAttribute("password", password);
		DBhandleImpl db=new DBhandleImpl();
		User u=db.getUser(username);
		if(u!=null){
			ServletActionContext.getRequest().setAttribute("u", u);
	//		ActionContext.getContext().getSession().put("u", u);
			switch(u.getRole()){
			case 0:
				System.out.println("role0进入");
				List<User>users=db.getUsers();
				
				ServletActionContext.getRequest().setAttribute("users", users);
				return "role0";
			case 1:
				System.out.println("role1进入");
				ResDBimpl rdb=new ResDBimpl();
				pages=rdb.getPages();
				ServletActionContext.getRequest().setAttribute("pages", pages);
				return "role1";
			case 2:
				System.out.println("role2进入");
				return "role2";
			default:
				break;
			}
		}
		System.out.println("用户不存在");
		return ERROR;
	}
	public void setPages(){
		ResDBimpl rdb=new ResDBimpl();
		pages=rdb.getPassPages();
	}

}
