package com.Register;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        String un = request.getParameter("uname");
        String up = request.getParameter("password");
        HttpSession session=request.getSession();
        session.setAttribute("uname", un);
        session.setAttribute("password", up);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "malathi");
             PreparedStatement ps = con.prepareStatement("select * from details where uname=? and upass=?")) {

            ps.setString(1, un);
            ps.setString(2, up);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	
                    session.setAttribute("PhNo", rs.getString("upn"));
                    session.setAttribute("Email", rs.getString("uemail"));
                    response.sendRedirect("Home.jsp");
                } else {
                    pw.println("not valid");
                }
            }

        } catch (SQLException se) {
            pw.println(se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }
}
