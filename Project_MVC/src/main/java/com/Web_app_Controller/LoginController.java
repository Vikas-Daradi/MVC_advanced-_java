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


@WebServlet("/verifylogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOserviceIMPL service=new DAOserviceIMPL();
		service.connectDB();
		
		boolean status = service.verifyLogin(email, password);
		
		if(status) {
			
			HttpSession session=request.getSession(true);
			session.setAttribute("email", email);

			RequestDispatcher rd= request.getRequestDispatcher
					("/WEB-INF/views/createRegistration.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("error", "invalid username/password");
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
	}

}
