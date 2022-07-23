package com.spendit.controller;
import com.spendit.utility.DBConnection;
import com.spendit.model.User;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.google.gson.Gson;
public class DBTest {
	public static void main(String args[])throws ParseException {
//		User user = new User("Doe", "John", "johndoe", "johndoe@email.com", "password", null);
	//	String sample = "2020-05-08T11:30";
	//	Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(sample);
	//	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		String date = "05/20/2020 01:05 PM";
		try {
			
			Date date2 = new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(date);
			System.out.println(date2);
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);
			System.out.println(date);
//			HttpSession session = request.getSession(false);
//			User user = (User)session.getAttribute("user");
//			Connection connection = DBConnection.getConnection(getServletContext());
//			ExpenseOperations exOps = new ExpenseOperations();
//			if(exOps.insert(connection, categoryID, user.getUserID(), cost, date, comment)) {
//				ArrayList<Expense> expenses = exOps.getAllExpenses(connection, user.getUserID());
//				request.setAttribute("expenses", expenses);
//				request.getRequestDispatcher("expenseindex.jsp").forward(request, response);
				
//			}
		
			}catch(ParseException pe) {
				System.err.println(pe.getMessage());
			}
	}
}
