package com.spendit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spendit.model.Category;
import com.spendit.model.Expense;
import com.spendit.model.Income;
import com.spendit.model.User;
import com.spendit.utility.DBConnection;

/**
 * Servlet implementation class CategoryIndexServlet
 */
@WebServlet("/retrieveallincome.action")
public class RetrieveAllIncomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Connection connection = DBConnection.getConnection(getServletContext());
		ArrayList<Income> income = new IncomeOperations().getAllIncome(connection, user.getUserID()) != null ? new IncomeOperations().getAllIncome(connection, user.getUserID()) : null;
		request.setAttribute("income", income);
		request.getRequestDispatcher("incomeindex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
