package com.spendit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import com.spendit.model.User;
import com.spendit.utility.DBConnection;

//@WebServlet("/login.action")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ServletContext context = getServletContext();
		
		Connection connection = DBConnection.getConnection(context);
//		System.out.println(context.getInitParameter("JDBCUrl"));
//		System.out.println(context.getInitParameter("JDBCUser"));
//		System.out.println(context.getInitParameter("JDBCPass"));
		UserOperations auth = new UserOperations();
		
		
		Gson gson = new Gson();
		HashMap<Object, Object> errorMsg = new HashMap<>();
		String json;
		HttpSession session = request.getSession();
		
		if(auth.authenticate(connection, username, password)) {
			int userID = auth.getUser(connection, username).getUserID();
			LogController.logActivity(connection, userID, LogController.LOGGED_IN);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			errorMsg.put("msg", "success");
			json = gson.toJson(errorMsg);
			System.out.println(json);
			session.setAttribute("user", auth.getUser(connection, username));
//			User user = (User) session.getAttribute("user");
//			System.out.println(session.getId());
			response.getWriter().write(json);
		
			
		//	request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			//request.getRequestDispatcher("error.jsp").forward(request, response);
			
	
			   //out.println("alert('User or password incorrect');");
			
			
			   response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				errorMsg.put("msg", "error");
				json = gson.toJson(errorMsg);
				System.out.println(json);
				response.getWriter().write(json);
			//request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
	}

}
