package com.lut.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO 自动生成的方法存根
            DataBase db=new DataBase();
            
            String s="INSERT INTO Manager values('1416270153','Peter');";
            String s1="SELECT *FROM Manager";
            System.out.println("ok");
            ResultSet rs=null;
            rs=db.executeQuery(s);
            db.show(db.executeQuery(s1));
            
            
	}

}
