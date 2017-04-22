package com.lut.action;

import org.apache.struts2.ServletActionContext;

import com.lut.bean.Page;
import com.lut.dao.ResDBimpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SendPageAction extends ActionSupport {
	private Page p;
	
	public Page getP() {
		return p;
	}

	public void setP(Page p) {
		this.p = p;
	}
	
//	public void sendPage(){
//		// TODO Auto-generated method stub
//				String title=ServletActionContext.getRequest().getParameter("title");
//				String kind=ServletActionContext.getRequest().getParameter("options");
//				String content=ServletActionContext.getRequest().getParameter("content");
//				Page p=new Page(title, content, Integer.valueOf(kind),2);
//				ResDBimpl rdb=new ResDBimpl();
//				int flag=rdb.addPage(p);
//	}
	@Override
	public String execute() throws Exception {
		String username=ServletActionContext.getRequest().getParameter("username");
		String title=ServletActionContext.getRequest().getParameter("title");
		String kind=ServletActionContext.getRequest().getParameter("options");
		String content=ServletActionContext.getRequest().getParameter("content");
		Page p=new Page(title, content, Integer.valueOf(kind),2);
		ResDBimpl rdb=new ResDBimpl();
		int flag=rdb.addPage(p);
		ServletActionContext.getRequest().setAttribute("username", username);
		ServletActionContext.getRequest().setAttribute("pages", rdb.getPassPages());
		if(flag>0){
			return SUCCESS;
		}
		return ERROR;
	}

}
