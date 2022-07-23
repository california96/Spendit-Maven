package com.spendit.controller;

import com.spendit.utility.DBConnection;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet implementation class ExpenseEditServlet
 */
@WebServlet("/updatecategory.action")
public class CategoryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = DBConnection.getConnection(getServletContext());
		String name = request.getParameter("name");
		int moduleID = Integer.parseInt(request.getParameter("moduleID"));
		String description = request.getParameter("description");
		String image = request.getParameter("image");
		int categoryID = Integer.parseInt(request.getParameter("categoryID"));
		if(StringUtils.isBlank(name) || StringUtils.isBlank(description)) {
			//response.sendRedirect("400.jsp");
			response.sendError(400);
			return;
		}
		CategoryOperations cOps = new CategoryOperations();
	
		cOps.updateCategory(connection, name, moduleID, description, image, categoryID);
		
	
		response.sendRedirect("categoryindex.action");
	

		
	}

}
