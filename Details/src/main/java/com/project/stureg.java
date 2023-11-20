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
@WebServlet("/stureg")
public class stureg extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		
		try {
			Connection con=Repositoty.details();
			PreparedStatement pst=con.prepareStatement("insert into studenttable(name,class,section,marks,username,password,Pmobile) values(?,?,?,?,?,?,?)");
			pst.setString(1, name);
			pst.setString(3, req.getParameter("class"));
			pst.setString(2, req.getParameter("section"));
			pst.setString(4, req.getParameter("marks"));
			pst.setString(5, req.getParameter("username"));
			pst.setString(6, req.getParameter("password"));
			pst.setString(7, req.getParameter("Pmobile"));
			int rows=pst.executeUpdate();
			if(rows>0)
			{
				resp.setContentType("text");
				PrintWriter p=resp.getWriter();
				p.print("<h1>"+"Student Data Sucessfully Inserted"+"</h1>");
				p.print(" <a href=studentreg.html>Add another Student +</a>");
			}
			else
			{
				resp.setContentType("text");
				PrintWriter p=resp.getWriter();
				p.print("<h1>"+"Student Data not Inserted"+"</h1>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
