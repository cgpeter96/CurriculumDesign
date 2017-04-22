package com.lut.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String URL = "jdbc:sqlserver://localhost:1433;databaseName=SchoolCard";
	private String USER="sa";
	private String  PWD="chen0326";
	private boolean flag=false;
	
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		public DataBase()
		{
			
			try {
				Class.forName(DRIVER);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
	
	public ResultSet executeQuery(String SQL){
		//rs=null;
		
		try {
			con=DriverManager.getConnection(URL,USER,PWD);
			stmt=con.createStatement();
			/*PreparedStatement pstmt=con.prepareStatement(SQLUse.INS1);
			pstmt.setString(1, "x");
			pstmt.executeUpdate();*/
			rs=stmt.executeQuery(SQL);		
			if(rs.next()){
				System.out.println("YES");
			}else
			{
				flag=true;
			}
		} catch (Exception e) {
			flag=true;
			System.out.println("in db class"+e);
		}finally{
			close();
		}
		return rs;
	}
	public void executeQuery2(String SQL){	
		boolean t;
		try {
			con=DriverManager.getConnection(URL,USER,PWD);
			stmt=con.createStatement();
			t=stmt.execute(SQL);
			 
		} catch (Exception e) {
			flag=true;
			System.out.println("in db 2"+e);
		}finally{
			close();
		}
	}
	public ResultSet executeQuery3(String SQL){	
		
		try {
			con=DriverManager.getConnection(URL,USER,PWD);
			stmt=con.createStatement();
			rs=stmt.executeQuery(SQL);
			 
		} catch (Exception e) {
			
			System.out.println("in db 3"+e);
		}finally{
			
		}
		return rs;
	}
	public void close()
	{
		
			try {
				if(con!=null)
					con.close();
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	public void show(ResultSet rss ) throws SQLException
	{
		while(rss.next())
			System.out.println(rss.getString(2));
	}
	public boolean getFlag()
	{
		return flag;
	}

	
		/*final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Demo";
		String USER="sa";
		String PWD="chen0326";
		
			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;
			try {
				Class.forName(DRIVER);
				con=DriverManager.getConnection(URL,USER,PWD);
				String SQL ="SELECT *FROM dbo.Student";
				stmt=con.createStatement();
				rs=stmt.executeQuery(SQL);
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"  ");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			
		}*/
	

}
