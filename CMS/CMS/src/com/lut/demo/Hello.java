package com.lut.demo;

import java.text.DateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class Hello extends ActionSupport{
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute()throws Exception {
//		msg=" Hello world,now is"+DateFormat.getInstance().format(new Date());
		System.out.println("hello");
		return SUCCESS;
	}
}
