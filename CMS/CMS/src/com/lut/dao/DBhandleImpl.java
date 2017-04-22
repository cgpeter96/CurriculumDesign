package com.lut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lut.bean.User;

public class DBhandleImpl implements DBHandle {

	private Connection conn=new DBConnection().conn;
	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		String sql="insert into Usr(Username,Password,Role_id)values(?,?,?)";
		int flag=-1;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getRole());
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int isExist(User u) {
		String sql="select * from Usr where username=?";
		int flag=-1;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int delUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUser(String s) {
		User u=null;
		String sql="select * from Usr where username=?";
		ResultSet rs=null;
		try {
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, s);
			rs=ps.executeQuery();
			if(rs.next()){
				u=new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setRole(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<User> getUsers() {
		List<User>users=new ArrayList<User>();
		User u=null;
		String sql="select * from Usr where Role_ID !=0 ";
		ResultSet rs=null;
		try {
			
			PreparedStatement ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setRole(rs.getInt(4));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		User u=null;
		String sql="select * from Usr where ID=?";
		ResultSet rs=null;
		try {
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				u=new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setRole(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int grantUser(int id, int role) {
		int flag=-1;
		String sql="update Usr set Role_id=? where ID=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, role);
			ps.setInt(2, id);
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
