package com.spendit.controller;

import com.spendit.model.Expense;
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
@WebServlet("/downloadexpenses.action")
public class DownloadExpenseReportServlet extends HttpServlet {
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
		ExpenseOperations exOps = new ExpenseOperations();
		response.setHeader("Content-disposition","attachment;filename="+ user.getUserName() + "-expenses" + ".pdf");
		ArrayList<Expense> expenses = exOps.getExpensesInMonth(connection, user.getUserID());
		exOps.downloadExpenses(response, expenses, user);
	/*	try {
			//step 1: Initialize Document
			Document document = new Document();
			//step 2: Get Instance
			PdfWriter.getInstance(document, response.getOutputStream());
			//step 3: Open Document
			document.open();
			//Step 4: Retrieve Expenses Breakdown
			ArrayList<Expense> expenses = new ExpenseOperations().getAllExpenses(connection, user.getUserID());
			//Step 5: Initialize Title 
			document.add(new Paragraph("Expense Report of user: " + user.getUserName()));
			document.add(new Paragraph("As of: " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date().getTime())));
			//Step 6: Initialize Table and Headers
			PdfPTable table = new PdfPTable(4);
			PdfPCell cell1 = new PdfPCell(new Paragraph("Category"));
	        PdfPCell cell2 = new PdfPCell(new Paragraph("Comment"));
	        PdfPCell cell3 = new PdfPCell(new Paragraph("Cost"));
	        PdfPCell cell4 = new PdfPCell(new Paragraph("Date Added"));
	        table.addCell(cell1);
	        table.addCell(cell2);
	        table.addCell(cell3);
	        table.addCell(cell4);
	        //Step 7: Loop through expenses
	        for(Expense e : expenses) {
	        	PdfPCell category = new PdfPCell(new Paragraph(e.getCategory()));
	        	PdfPCell comment = new PdfPCell(new Paragraph(e.getComment()));
	        	PdfPCell cost = new PdfPCell(new Paragraph("Php " + e.getCost()));
	        	PdfPCell date = new PdfPCell(new Paragraph(e.getDate()));
	        	table.addCell(category);
	        	table.addCell(comment);
	        	table.addCell(cost);
	        	table.addCell(date);
	        }
	        document.add(table);
	        document.close();
	       
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
