package com.lut.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
   private final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
   private String URL="jdbc:sqlserver://localhost:1433;databaseName=TeacherManage";
   private String USER="sa";
   private String PWD="chen0326";
   
   Connection con=null;
   ResultSet rs=null;
   Statement st=null;
   
   public DataBase(){
	   try {
		Class.forName(DRIVER);
	} catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		System.out.println("Wrong in construction DB :"+e);
	}
	   
   }
   public ResultSet executeQuery(String SQL){
	   try {
		con=DriverManager.getConnection(URL, USER, PWD);
		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs=st.executeQuery(SQL);
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	   return rs;
   }
   public void executeQuery2(String SQL){
	   try {
			con=DriverManager.getConnection(URL, USER, PWD);
			st=con.createStatement();
			//st.executeQuery(SQL);
			st.executeUpdate(SQL);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("in query2"+e);
		}
   }
   public void closeAll(){
	   try {
		if(con!=null)
			con.close();
		if(st!=null)
			st.close();
		if(rs!=null)
			rs.close();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	   
   }
}
