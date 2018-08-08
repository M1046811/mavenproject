package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility 
{
	private static Connection con;
	public static Connection createConnection()
	{
		String url="jdbc:mysql://localhost:3306/football_match_db";
		String username="root";
		String password="Welcome123";
		try
		{
			con=DriverManager.getConnection(url,username,password);
			System.out.println("Connection Establised");
		}
		catch(SQLException e)
		{
			System.out.println("Can't Create Connection"+e);
		}
		return con;
	}
	public static void closeConnection(Connection con)
	{
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				System.out.println("can't close connnection"+e);
			}
		}
	}
}
