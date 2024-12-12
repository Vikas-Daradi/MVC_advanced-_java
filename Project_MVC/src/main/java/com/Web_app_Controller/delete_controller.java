package com.Web_app_Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_app_Model.DAOserviceIMPL;


@WebServlet("/deletereg")
public class delete_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public delete_controller() {
        super();   
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		
		DAOserviceIMPL service =new DAOserviceIMPL();
		service.connectDB();
		
		service.deleteRegistartion(email);
		
		ResultSet result = service.listALLReg();
		request.setAttribute("result", result);
		 RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
		 rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
