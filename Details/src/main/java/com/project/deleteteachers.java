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
@WebServlet("/deleteteachers")
public class deleteteachers extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con;
		resp.setContentType("text/html");
		PrintWriter p=resp.getWriter();
		int i=(Integer.parseInt(req.getParameter("id")));
		try {
			con = Repositoty.details();
			PreparedStatement pst=con.prepareStatement("delete from teachers where id=?");
			pst.setInt(1,i);
			int r=pst.executeUpdate();
			if(r>0)
			{
				p.print("<h2>"+"Teacher Deleted Successfully"+"</h2>");
			}
			else
				p.print("<h2>"+"Id Not Found"+"</h2>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
