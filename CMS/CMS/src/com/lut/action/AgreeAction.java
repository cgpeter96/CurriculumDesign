package com.lut.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.lut.bean.Page;
import com.lut.dao.ResDBimpl;
import com.opensymphony.xwork2.ActionSupport;

public class AgreeAction extends ActionSupport {

	@Override
	public String execute() throws Exception {

		String id=ServletActionContext.getRequest().getParameter("id");
		String username=ServletActionContext.getRequest().getParameter("username");
		
		ResDBimpl rdb=new ResDBimpl();
		int i=rdb.setPass(Integer.valueOf(id));
		List<Page> pages=rdb.getPages();
		ServletActionContext.getRequest().setAttribute("username", username);
		ServletActionContext.getRequest().setAttribute("pages", pages);
		return SUCCESS;
	}

}
