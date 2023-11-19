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

@WebServlet("/login")
public class login extends HttpServlet
{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		resp.setContentType("text");
		PrintWriter p=resp.getWriter();
		try 
		{
			Connection con=Repositoty.details();
			PreparedStatement pst=con.prepareStatement("select * from teachers where username=? and password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet b=pst.executeQuery();
			if(b.next())
			{
				resp.sendRedirect("classes.html");
			}
			else
			{
				resp.sendRedirect("loginpage.html");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
