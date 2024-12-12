package com.Web_app_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web_app_Model.DAOserviceIMPL;

@WebServlet("/Savereg")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegistrationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		RequestDispatcher rd = request.getRequestDispatcher
				("/WEB-INF/views/createRegistration.jsp");
		rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher
					("index.jsp");
					rd.forward(request, response);
		}
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(false);
		if (session.getAttribute("email")!=null){
		
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOserviceIMPL service = new DAOserviceIMPL();
		service.connectDB();
		service.createRegistartion(name, email, mobile);
		
		RequestDispatcher rd = request.getRequestDispatcher
		("/WEB-INF/views/createRegistration.jsp");
		rd.forward(request, response);
		
		}else {
			RequestDispatcher rd= request.
					getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
