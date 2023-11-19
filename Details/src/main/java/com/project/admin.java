package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/admin")
public class admin extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text");
		PrintWriter p=resp.getWriter();
		try {
			Connection con=Repositoty.details();
			PreparedStatement ps=con.prepareStatement("select * from Admin where username=? and password=?");
			ps.setString(1, req.getParameter("username"));
			ps.setString(2, req.getParameter("password"));
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				resp.sendRedirect("details.html");
			}
			else
			{
				resp.sendRedirect("admin.html");
				p.print("Invalid username/password");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
