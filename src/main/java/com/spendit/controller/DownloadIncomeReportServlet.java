package com.spendit.controller;

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
 * Servlet implementation class DownloadExpenseReportServlet
 */
@WebServlet("/downloadincome.action")
public class DownloadIncomeReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/pdf");
		Connection connection = DBConnection.getConnection(getServletContext());
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		IncomeOperations inOps = new IncomeOperations();
		
		response.setHeader("Content-disposition","attachment;filename="+ user.getUserName() + "-income" + ".pdf");

		ArrayList<Income> income = inOps.getAllMonthsIncome(connection, user.getUserID());
		inOps.downloadIncome(response, income, user);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
