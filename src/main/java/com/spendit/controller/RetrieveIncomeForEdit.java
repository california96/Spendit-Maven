package com.spendit.controller;

import com.spendit.model.Category;
import com.spendit.model.Income;
import com.spendit.model.User;
import com.spendit.utility.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
/**
 * Servlet implementation class RetrieveExpenseServlet
 */
@WebServlet("/retrieveincome.action")
public class RetrieveIncomeForEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int incomeID = Integer.parseInt(request.getParameter("id"));
		Connection connection = DBConnection.getConnection(getServletContext());
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		IncomeOperations inOp = new IncomeOperations();
		Income income = inOp.getIncome(connection, incomeID);
		if(income.getUserID() == user.getUserID()) {
			ArrayList<Category> categories = new CategoryOperations().getCategories(connection, 2);
			request.setAttribute("income", income);
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("editincome.jsp").forward(request, response);
		}
		else {
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
