package com.spendit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.spendit.model.Expense;
import com.spendit.model.User;
import com.spendit.utility.DBConnection;

/**
 * Servlet implementation class ExpenseCreateServlet
 */
@WebServlet("/createcategory.action")
public class CategoryCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("name"));
		
		int moduleID = Integer.parseInt(request.getParameter("module"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String image = request.getParameter("image");
		CategoryOperations cOps = new CategoryOperations();

		Connection connection = DBConnection.getConnection(getServletContext());
		if(cOps.insert(connection, name, moduleID, description, image)) {
			response.sendRedirect("categoryindex.action");
		}
		
	
		Enumeration<String> params = request.getParameterNames(); 
		while(params.hasMoreElements()){
		 String paramName = params.nextElement();
		 System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
		}

	}

}
