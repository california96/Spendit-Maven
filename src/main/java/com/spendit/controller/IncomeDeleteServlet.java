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
 * Servlet implementation class ExpenseEditServlet
 */
@WebServlet("/deleteincome.action")
public class IncomeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int incomeID = Integer.parseInt(request.getParameter("id"));
		
		ServletContext context = getServletContext();
		
		Connection connection = DBConnection.getConnection(context);
		IncomeOperations inOp = new IncomeOperations();
		
		inOp.deleteIncome(connection, incomeID);
		//System.out.println("What happened to income: " + incomeID);
		request.getRequestDispatcher("retrieveallincome.action").forward(request, response);
		
		

		
	}

}
