package com.Register;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String query="insert into details(uname,upn,uemail,upass,ugender,uaddress) values(?,?,?,?,?,?) ";
    public Register() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");

		
		String uname=request.getParameter("name");
		String upn=request.getParameter("PhNo");
		String uemail=request.getParameter("Email");
		String upass=request.getParameter("password");
		String ugender=request.getParameter("Gender");
		String uaddress=request.getParameter("Address");
	
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		   try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails","root","malathi");
			PreparedStatement ps=con.prepareStatement(query);){
			    ps.setString(1, uname);
				ps.setString(2, upn);
				ps.setString(3, uemail);
				ps.setString(4, upass);
				ps.setString(5, ugender);
				ps.setString(6, uaddress);
				int c=ps.executeUpdate();
				if(c>0) {
					pw.println("data is stored");
					response.sendRedirect("Login.html");
				}
				else {
					pw.println("not stored");
				}
		  
		   }
		   catch(SQLException se) {
			   pw.println(se.getMessage());
			   se.printStackTrace();
			   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   pw.close();
		   }
		   
			
			
			
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	}


