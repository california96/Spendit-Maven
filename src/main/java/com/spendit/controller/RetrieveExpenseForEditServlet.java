package com.spendit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spendit.model.*;
import com.spendit.utility.*;
import com.spendit.controller.*;
import java.sql.Connection;
import java.util.ArrayList;
/**
 * Servlet implementation class RetrieveExpenseServlet
 */
@WebServlet("/retrieveexpenseforupdate.action")
public class RetrieveExpenseForEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int expenseID = Integer.parseInt(request.getParameter("id"));
		Connection connection = DBConnection.getConnection(getServletContext());
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		ExpenseOperations exOp = new ExpenseOperations();
		Expense expense = exOp.getExpense(connection, expenseID);
		if(expense.getUserID() == user.getUserID()) {
			ArrayList<Category> categories = new CategoryOperations().getCategories(connection, 1);
			request.setAttribute("expense", expense);
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("editexpense.jsp").forward(request, response);
		}
		else {
			//response.sendRedirect("index.jsp"); //this should be a 403.jsp
			response.sendError(403);

		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
