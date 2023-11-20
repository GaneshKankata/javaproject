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
@WebServlet("/studentdetals")
public class studentdetals extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter p=resp.getWriter();
		try {
			Connection con=Repositoty.details();
			PreparedStatement pst=con.prepareStatement("select * from studenttable");
			ResultSet rs=pst.executeQuery();
			p.print("<table align=center cellspacing=10 cellpadding=10><tr>"+"<th>Roll No</th>"+"<th>Name</th>"+"<th>Section</th>"+"<th>Class</th>"+"<th>Marks</th>"+"<th>Password</th>"+"<th>UserName</th>"+"<th>Parent Mobile</th>");
			int a=0;
			while(rs.next())
			{
				a++;
				p.print("<tr>"+"<td>"+rs.getString(8)+"</td>"+"<td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getInt(4)+"</td>"+"<td>"+rs.getString(5)+"</td>"+"<td>"+rs.getString(6)+"</td>"+"<td>"+rs.getString(7)+"</td>"+"</tr>");
			}
			p.print("</table>");
			if(a==0)
			{
				p.print("No Student in the School");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
