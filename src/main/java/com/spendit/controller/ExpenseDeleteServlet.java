package com.spendit.controller;

import com.spendit.utility.DBConnection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet implementation class ExpenseDeleteServlet
 */
@WebServlet("/deleteexpense.action")
public class ExpenseDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int expenseID = Integer.parseInt(request.getParameter("id"));
		
		ServletContext context = getServletContext();
		
		Connection connection = DBConnection.getConnection(context);
		ExpenseOperations exOp = new ExpenseOperations();
		
		exOp.deleteExpense(connection, expenseID);
		
		request.getRequestDispatcher("retrieveexpenses.action").forward(request, response);
		
	
	}

}
