package com.spendit.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spendit.utility.DBConnection;

/**
 * Servlet implementation class ExpenseDeleteServlet
 */
@WebServlet("/deletecategory.action")
public class CategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryID = Integer.parseInt(request.getParameter("id"));
		
		ServletContext context = getServletContext();
		
		Connection connection = DBConnection.getConnection(context);
		CategoryOperations cOps = new CategoryOperations();
		
		cOps.delete(connection, categoryID);
		
		request.getRequestDispatcher("categoryindex.action").forward(request, response);
		
	
	}

}
