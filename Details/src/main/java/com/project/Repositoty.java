package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Repositoty {
	public static Connection details() throws SQLException, ClassNotFoundException 
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
	}
}
