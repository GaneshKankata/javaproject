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
@WebServlet("/remove")
public class remove extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text");
		PrintWriter p=resp.getWriter();
		try {
			Connection con=Repositoty.details();
			PreparedStatement pst=con.prepareStatement("delete from studenttable where name=? and class=? and section=?");
			pst.setString(1, req.getParameter("name"));
			pst.setString(2, req.getParameter("class"));
			pst.setString(3, req.getParameter("section"));
			int rows=pst.executeUpdate();
			if(rows>0)
			{
				p.print("Student Deleted Sucessfully");
			}
			else
			{
				p.print("Student not Deleted");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
