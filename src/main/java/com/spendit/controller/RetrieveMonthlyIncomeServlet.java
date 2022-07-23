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

import com.google.gson.Gson;
import java.util.HashMap;
import com.spendit.model.Income;
import com.spendit.model.User;
import com.spendit.utility.DBConnection;

/**
 * Servlet implementation class RetrieveExpenseTodayServlet
 */
@WebServlet("/monthlyincome.action")
public class RetrieveMonthlyIncomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Connection connection = DBConnection.getConnection(getServletContext());
		HashMap<String, String> income = new HashMap<String, String>();
		IncomeOperations inOps = new IncomeOperations();
		income.put("monthlyincome", String.valueOf (inOps.getMonthlyIncome(connection, user.getUserID())));
		Gson gson = new Gson();
		String json = gson.toJson(income);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		System.out.println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
