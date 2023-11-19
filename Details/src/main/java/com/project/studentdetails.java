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

@WebServlet("/studentdetails")
public class studentdetails extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Connection con=Repositoty.details();
			PreparedStatement pst=con.prepareStatement("select * from studenttable where class=? and section=?");
			pst.setString(1,req.getParameter("class"));
			pst.setString(2, req.getParameter("section"));
			ResultSet rs=pst.executeQuery();
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.print("<table style=width:60%; border:5px solid black; border-collapse:collapse><tr><th>Name</th><th>Class</th><th>Section</th><th>Marks</th></tr>");
			while(rs.next())
			{
				out.print("<tr><td>"+rs.getString(1)+"</td>"+ "<td>"+rs.getString(3)+"</td>"+ "<td>"+rs.getString(2)+"</td>"+ "<td>"+rs.getString(4)+"</td>"+"</tr>");
			}
			out.print("</table>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}