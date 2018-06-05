package com.niit.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtility {
	private static Properties properties;
	private static InputStream inputStream;
	private static Connection connect;

	static
	{
		try{
			inputStream= ConnectionUtility.class.getResourceAsStream("/config.properties");
			properties=new Properties();
			properties.load(inputStream);
			System.out.println("load");
			
		 }
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	
	public static Connection connection()
	{
		try{
			
		Class.forName(properties.getProperty("driver"));
		connect=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
		
		DatabaseMetaData mdb=connect.getMetaData();
		System.out.println(mdb.getURL()+"   "+mdb.getUserName());
		return connect;
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		
	}
		

}
