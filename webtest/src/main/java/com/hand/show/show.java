package com.hand.show;

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

public class show extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=UTF-8");
	PrintWriter out=resp.getWriter();
	Statement stmt=null;
	ResultSet rs=null;
	Connection conn=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "1203386823");
		stmt=(Statement) conn.createStatement();
		rs=stmt.executeQuery("select * from film,language where film.language_id=language.language_id");
		 out.println("<html><head><title>读取数据库信息</title><head><body>");
		while(rs.next()){
			 out.println(rs.getInt("film_id")+" ");
			 out.println(rs.getString("title")+" ");
			 out.println(rs.getString("description")+" ");
			 out.println(rs.getString("language_id")+"<br>");
			 out.println("<a href=\"delete.jsp\">删除</a><br/>");
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	

}
