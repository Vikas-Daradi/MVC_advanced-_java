package com.web_app_Model;

import java.sql.ResultSet;

public interface DAOservice {
	public void connectDB();
	public boolean verifyLogin(String email,String password);
	public void createRegistartion(String name,String email,String password);
	public void deleteRegistartion(String email);
	public void updateRegistartion(String email,String mobile);
	public ResultSet listALLReg();

}
