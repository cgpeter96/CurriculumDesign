package com.lut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lut.bean.Page;

public class ResDBimpl implements ResDB {

	private Connection conn=new DBConnection().conn;

	@Override
	public int addPage(Page p) {
		String sql="insert into Res(Res_Title,Res_Text,Res_kind,Role)values(?,?,?,2)";
		int flag=-1;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, p.getTitle());
			ps.setString(2, p.getContent());
			ps.setInt(3, p.getKind());
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int modifyPage(Page p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page getPage(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Page> getPages() {
		// TODO Auto-generated method stub
		List<Page>pages=new ArrayList<Page>();
		String sql="select Res_Title,Res_Text,Res_kind,Role,Res_ID from Res where Role=2";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Page p=new Page(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				p.setId(rs.getInt(5));
				pages.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			pages=null;
		}
		return pages;
	}

	@Override
	public int delPage(String s) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Page> getPassPages() {
		List<Page>pages=new ArrayList<Page>();
		String sql="select Res_Title,Res_Text,Res_kind,Role,Res_ID from Res where Role=1";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Page p=new Page(rs.getString(1).trim(),rs.getString(2),rs.getInt(3),rs.getInt(4));
				p.setId(rs.getInt(5));
				pages.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			pages=null;
		}
		return pages;
	}

	@Override
	public int setPass(int id) {
		String sql="update Res set Role=1 where Res_ID="+id;
		int i=-1;
		try {
			Statement st=conn.createStatement();
			i=st.executeUpdate(sql);
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int setReject(int id) {
		// TODO Auto-generated method stub
		String sql="update Res set Role=4 where Res_ID="+id;
		int i=-1;
		try {
			Statement st=conn.createStatement();
			i=st.executeUpdate(sql);
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
}
