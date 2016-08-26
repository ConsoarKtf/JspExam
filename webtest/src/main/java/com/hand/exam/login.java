package com.hand.exam;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class login extends HttpServlet {

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
		String username=req.getParameter("uname");
		String forword=null;
		int flag=0;
		resp.setContentType("text/html;charset=UTF-8");
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "1203386823");
		    stmt=(Statement) conn.createStatement();
		    rs=stmt.executeQuery("select * from customer");
		    while(rs.next()){
		    	if(rs.getString("first_name").equals(username))
					flag++;
		    }
		 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		 if(flag>0){
			  forword="/main.jsp";
			  RequestDispatcher rd=req.getRequestDispatcher(forword);
			  rd.forward(req, resp);
		  }else{
			  forword="/index.jsp";
			  RequestDispatcher rd=req.getRequestDispatcher(forword);
			  rd.forward(req, resp);
		  }
	}

}
