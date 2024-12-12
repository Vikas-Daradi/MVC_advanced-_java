package com.web_app_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOserviceIMPL implements DAOservice {

	private Connection con;
	private Statement stmt;
	
	@Override
	public void connectDB() {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection
					 ("jdbc:mysql://localhost:3306/junedb","root","root");
			 stmt = con.createStatement();
			 System.out.println("Connection Established...");
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

	@Override
	public boolean verifyLogin(String email, String password) {

		try {

				
				ResultSet result=stmt.executeQuery
			("select * from  regdb where email='"+email+"' and password='"+password+"'");
				return result.next();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			return false;
		}
	@Override
	public void createRegistartion(String name, String email, String mobile) {
		try {
			stmt.executeUpdate
			("insert into regdb2 values('"+name+"','"+email+"','"+mobile+"')");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}


	@Override
	public void deleteRegistartion(String email) {
		try {
			stmt.executeUpdate
			("Delete from regdb2 where email='"+email+"'");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public ResultSet listALLReg() {
		try {
			return stmt.executeQuery("Select * from regdb2");
			}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateRegistartion(String email, String mobile) {
		try {
			stmt.executeUpdate
			("update regdb2 set email='"+email+"' where mobile='"+mobile+"'");
			
			}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
