package com.lut.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection conn=null;
	public DBConnection(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://localhost:1433;databaseName=CMS";
			conn=DriverManager.getConnection(url,"sa","chen0326");
		}catch(Exception e){
			System.out.println("数据库连接出错");
			e.printStackTrace();
		}
	}
}
