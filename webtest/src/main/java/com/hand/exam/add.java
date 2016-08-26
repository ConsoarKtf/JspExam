package com.hand.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		Statement stmt=null;
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "1203386823");
			stmt=(Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery("select language_id from language where name="+"'"+req.getParameter("ulanguage")+"'");
		    int num=rs.getInt("language_id");
		    String n1=req.getParameter("utitle");
		    String n2=req.getParameter("udescription");
		    String sql="INSERT INTO film(title,description,language_id)"+"VALUES('"+n1+"','"+n2+"','"+num+"')";
		    stmt.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

}
