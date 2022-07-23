package com.spendit.controller;

import com.spendit.model.User;
import com.spendit.utility.DBConnection;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class ExpenseCreateServlet
 */
@WebServlet("/createincome.action")
public class IncomeCreateServlet extends HttpServlet {
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
		int categoryID = Integer.parseInt(request.getParameter("categoryID"));
		double amount = Double.parseDouble(request.getParameter("amount"));	
		String date = request.getParameter("date");
		String comment = request.getParameter("comment");
		
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		Connection connection = DBConnection.getConnection(getServletContext());
		if(StringUtils.isBlank(comment)) {
			response.sendError(400);
			//response.sendRedirect("400.jsp");
			return;
		}
		try {
		java.util.Date parsedDate = new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(date);// Month/Day/Year Hour:Minute A/PM
		date = new SimpleDateFormat("yyyy-MM-dd").format(parsedDate);// Year-Month-Day Hour:Minute:Seconds 24 hour
		IncomeOperations inOps = new IncomeOperations();
		if(inOps.insert(connection, user.getUserID(), categoryID, amount, date, comment)) {
			response.sendRedirect("retrieveallincome.action");
		}
		}catch(java.text.ParseException pe) {
			System.err.println(pe.getMessage());
		}
	}

}
