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
@WebServlet("/studentlogin")
public class studentlogin extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		resp.setContentType("text");
		PrintWriter p=resp.getWriter();
		
		try 
		{
			Connection con=Repositoty.details();
			PreparedStatement pst=con.prepareStatement("select * from studenttable where username=? and password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet b=pst.executeQuery();
			int a=0;
			while(b.next())
			{	a++;
				p.print("Name"+"\t"+"Class"+"\t"+"Section"+"\t"+"Marks"+"\t"+"Parent Mobile"+"\n"+"\n");
				p.print(b.getString(1)+"\t"+b.getString(3)+"\t"+b.getString(2)+"\t"+b.getString(4)+"\t"+b.getString(7));
			}
			if(a==0)
			{	
				resp.setContentType("text");
				PrintWriter out=resp.getWriter();
				out.print("Wrong user/password try again...");
				resp.sendRedirect("student.html");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
