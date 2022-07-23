package com.spendit.controller;

import com.spendit.model.Category;
import com.spendit.utility.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
/**
 * Servlet implementation class RetrieveExpenseServlet
 */
@WebServlet("/retrievecategory.action")
public class RetrieveCategoryForEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection(getServletContext());
		int categoryID = Integer.parseInt(request.getParameter("id"));
		CategoryOperations cOps = new CategoryOperations();
		Category category = cOps.getCategory(connection, categoryID);
	
			ArrayList<com.spendit.model.Module> modules = new ModuleOperations().getModules(connection);
			request.setAttribute("category", category);
			request.setAttribute("modules", modules);
			request.getRequestDispatcher("editcategory.jsp").forward(request, response);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
