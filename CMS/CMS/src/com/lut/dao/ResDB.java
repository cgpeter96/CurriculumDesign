package com.lut.dao;

import java.util.List;

import com.lut.bean.Page;

public interface ResDB {
	public int addPage(Page p );
	public int modifyPage(Page p);
	public Page getPage(String s);
	public List<Page> getPages();
	public int delPage(String s);
	public List<Page> getPassPages();
	public int setReject(int id);
	public int setPass(int id);
}
