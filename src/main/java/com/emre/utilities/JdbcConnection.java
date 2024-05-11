package com.emre.utilities;

import java.sql.*;
import java.util.Objects;

public class JdbcConnection {
	
	  private static JdbcConnection jdbcConnection;
	  private static Connection connection;
	  private static Statement statement;
	  private static ResultSet resultSet;

	private JdbcConnection() throws SQLException, ClassNotFoundException {
		    try {
				Class.forName("org.postgresql.Driver");

				String connectionUrl = ConfigurationReader.get("connectionURL");
				String connectionUsername = ConfigurationReader.get("connectionUsername");
				String connectionPassword = ConfigurationReader.get("connectionPassword");

				connection = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword);
		        statement = connection.createStatement();
		    } catch (SQLException ex) {
		    	System.out.println("sistemsel bir hata oluştu "+ ex.getMessage().toString());
		    }   
		  }
	  
	  
	  private static void getInstance() {
		    try {
		      if (Objects.isNull(jdbcConnection))
		        jdbcConnection = new JdbcConnection();
		    } catch (SQLException ex) {
		    	System.out.println("sistemsel bir hata oluştu "+ ex.getMessage());
		    } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	  }
	
	  
	  public static ResultSet executeQuery(String query) {
		    getInstance();
		 try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		 return resultSet;
	  }

	  

	  public static void closeConnection()  {
	       
		  try {
			if (resultSet != null ) {
				  	resultSet.close(); 
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  try {
			if (statement != null ) {
					  statement.close(); 
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	      try {
			if (connection != null ) {
				  connection.close(); 
			  }
		} catch (SQLException e) {

			e.printStackTrace();
		}	  
	      jdbcConnection=null; 
	  }



}
