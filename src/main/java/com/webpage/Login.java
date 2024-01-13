package com.webpage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext stx=getServletContext();
		System.out.println(stx.getInitParameter("name"));
		
		String u=request.getParameter("uname");
		String p=request.getParameter("password");
		
		if( u.trim().equals("malathi") && p.trim().equals("banshi")) {
			RequestDispatcher rd=request.getRequestDispatcher("/HomePage");
			rd.forward(request, response);
		}
		else
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("/Login.html");
			rd.forward(request, response);
		}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
