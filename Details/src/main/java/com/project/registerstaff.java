package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerstaff")
public class registerstaff extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String subject=req.getParameter("subject");
		String mobile=req.getParameter("mobile");
		
		try {
			Connection con=Repositoty.details();
			PreparedStatement pst=con.prepareStatement("insert into teachers(username,password,name,subject,mobile) values(?,?,?,?,?)");
			pst.setString(1, username);  pst.setString(2, password);
			pst.setString(3, name);  pst.setString(4, subject);  pst.setString(5, mobile);
			
			int rows=pst.executeUpdate();
			if(rows>0)
			{
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.print("<h1>"+"Sucessfully Registered"+"</h1>");
				out.print(" <a href=register.html>Add another Teacher +</a>");
			}
			else
			{
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.print("<h1>"+"0 inserted"+"</h1>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
