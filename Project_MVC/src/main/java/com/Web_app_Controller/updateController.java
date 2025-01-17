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

@WebServlet("/updatereg")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updateController() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		
		RequestDispatcher rd= request.getRequestDispatcher
				("/WEB-INF/views/updateRegistration.jsp");
		    rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		DAOserviceIMPL service = new DAOserviceIMPL ();
		service.connectDB();
		service.updateRegistartion(email, mobile);
		
		ResultSet result = service.listALLReg();
		request.setAttribute("result", result);
		 RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
		 rd.forward(request, response);
	}

}
