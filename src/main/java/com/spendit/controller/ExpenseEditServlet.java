package com.spendit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.spendit.model.User;
import com.spendit.model.Expense;
import java.util.ArrayList;
import com.spendit.utility.DBConnection;

/**
 * Servlet implementation class ExpenseEditServlet
 */
@WebServlet("/editexpense.action")
public class ExpenseEditServlet extends HttpServlet {
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
		int expenseID = Integer.parseInt(request.getParameter("expenseID"));
		int categoryID = Integer.parseInt(request.getParameter("categoryID"));
		double cost = Double.parseDouble(request.getParameter("cost"));	
		String date = request.getParameter("date");
		String comment = request.getParameter("comment");
		Connection connection = DBConnection.getConnection(getServletContext());
		if(StringUtils.isBlank(comment)) {
			response.sendError(400);
			//response.sendRedirect("400.jsp");
			return;
		}
		try {
		ExpenseOperations exOps = new ExpenseOperations();
		java.util.Date parsedDate = new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(date);// Month/Day/Year Hour:Minute A/PM
		date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(parsedDate);// Year-Month-Day Hour:Minute:Seconds 24 hour
		exOps.editExpense(connection, expenseID, categoryID, cost, date, comment);
		
		response.sendRedirect("retrieveexpenses.action");
		}catch(ParseException pe) {
			System.err.println(pe.getMessage());
		}
	

		
	}

}
