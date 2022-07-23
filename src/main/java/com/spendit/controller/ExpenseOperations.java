package com.spendit.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spendit.model.Expense;
import com.spendit.model.User;

import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class ExpenseOperations {
	public boolean insert(Connection connection, int categoryID, int userID, double cost, String date, String comment) {
		String sql = "INSERT INTO expenses(categoryID, userID, cost, date, comment) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setInt(1, categoryID);
			prep.setInt(2, userID);
			prep.setDouble(3, cost);
			prep.setString(4, date);
			prep.setString(5, comment);
			prep.executeUpdate();
			return true;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	public ArrayList<Expense> getAllExpenses(Connection connection, int userID){
		ArrayList<Expense> expenses = new ArrayList<Expense>();
		//public Expense(int expenseID, int categoryID, String category, int userID, double cost, Date date, String comment)
		String sql = "SELECT expenseID, categoryID, categories.name, users.userID, cost, date, comment\n" + 
				"FROM expenses\n" + 
				"INNER JOIN users on users.userID = expenses.userID\n" + 
				"INNER JOIN categories on categories.id = expenses.categoryID\n" + 
				"WHERE users.userID = ? ORDER BY date";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setInt(1, userID);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				expenses.add(new Expense(rs.getInt("expenseID"), rs.getInt("categoryID"), rs.getString("name"), rs.getInt("userID"), rs.getDouble("cost"), rs.getString("date"), rs.getString("comment")));
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return expenses;
	}
	public Expense getExpense(Connection connection, int expenseID) {
		Expense expense = null;
		String sql = "SELECT expenseID, categoryID, categories.name, userID, cost, expenses.date, expenses.comment\n" + 
				"FROM expenses\n" + 
				"INNER JOIN categories on categories.id = expenses.categoryID\n" + 
				"WHERE expenses.expenseID = ?";
		ResultSet rs = null;
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setInt(1, expenseID);
			rs = prep.executeQuery();
			while(rs.next()) {
				expense = new Expense(rs.getInt("expenseID"), rs.getInt("categoryID"), rs.getString("name"), rs.getInt("userID"), rs.getDouble("cost"), rs.getString("date"), rs.getString("comment"));
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return expense;
	}
	public void deleteExpense(Connection connection, int expenseID) {
		String sql = "DELETE FROM expenses WHERE expenses.expenseID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, expenseID);
			ps.executeUpdate();
			
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}

	}
	
	public void editExpense(Connection connection, int expenseID, int categoryID, double cost, String date, String comment) {
		String sql = "UPDATE expenses SET categoryID = ? , cost = ?, date = ?, comment = ? WHERE expenses.expenseID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, categoryID);
			ps.setDouble(2, cost);
			ps.setString(3, date);
			ps.setString(4, comment);
			ps.setInt(5, expenseID);
			ps.executeUpdate();
			
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}

	}
	public double getTodaysExpenses(Connection connection, int userID) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		double todayExpense = 0.00;
		try {
		String sql = "SELECT sum(cost) as 'expensetoday' FROM expenses WHERE userID = ? AND DATE(date) = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, userID);
		ps.setString(2, formatter.format(new java.util.Date()));
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			todayExpense = rs.getDouble("expensetoday");
		}
		return todayExpense;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		return todayExpense;
	}
	public double getMonthsExpenses(Connection connection, int userID) {
		double todayExpense = 0.00;
		try {
		String sql = "SELECT SUM(cost) as 'monthexpenses' FROM expenses WHERE expenses.userID = ? AND (MONTH(date) = MONTH(CURRENT_TIMESTAMP) AND YEAR(date) = YEAR(CURRENT_TIMESTAMP))";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			todayExpense = rs.getDouble("monthexpenses");
		}
		return todayExpense;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		return todayExpense;
	}
	public ArrayList<Map<String, String>>getTopExpenseCategories(Connection connection, int userID){
		ArrayList<Map<String, String>> categoryExpense = new ArrayList<Map<String, String>>();
		String sql = "SELECT categories.image, categories.name, expenses.categoryID, sum(cost) as 'categoryexpense'\n" + 
				"FROM expenses\n" + 
				"INNER JOIN categories on categories.id = expenses.categoryID\n" + 
				"WHERE userID = ? GROUP by categoryID LIMIT 5";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, String> ceMap = new HashMap<String, String>();
				ceMap.put("image", rs.getString("image"));
				ceMap.put("name", rs.getString("name"));
				ceMap.put("categoryexpense", String.valueOf(rs.getDouble("categoryexpense")));
				categoryExpense.add(ceMap);

			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		return categoryExpense;
	}
	public ArrayList<Expense> getExpensesInMonth(Connection connection, int userID){
		ArrayList<Expense> expenses = new ArrayList<Expense>();
		//public Expense(int expenseID, int categoryID, String category, int userID, double cost, Date date, String comment)
		String sql = "SELECT expenseID, categoryID, categories.name, users.userID, cost, date, comment\n" + 
				"FROM expenses\n" + 
				"INNER JOIN users on users.userID = expenses.userID\n" + 
				"INNER JOIN categories on categories.id = expenses.categoryID\n" + 
				"WHERE users.userID = ? AND (MONTH(date) = MONTH(CURRENT_TIMESTAMP) AND YEAR(date) = YEAR(CURRENT_TIMESTAMP))";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setInt(1, userID);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				expenses.add(new Expense(rs.getInt("expenseID"), rs.getInt("categoryID"), rs.getString("name"), rs.getInt("userID"), rs.getDouble("cost"), rs.getString("date"), rs.getString("comment")));
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return expenses;
	}
	public void downloadExpenses(HttpServletResponse response, ArrayList<Expense> expenses, User user) {
		try {
		//step 1: Initialize Document
		Document document = new Document();
		//step 2: Get Instance
		PdfWriter.getInstance(document, response.getOutputStream());
		//step 3: Open Document
		document.open();
		//Step 4: Retrieve Expenses Breakdown
		
		//Step 5: Initialize Title 
		document.add(new Paragraph("Expense Report of user: " + user.getUserName()));
		document.add(new Paragraph("As of: " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new java.util.Date().getTime())));
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
		}
	}
	public ArrayList<Map<String, String>> getRecentExpenses(Connection connection, int userID){
		ArrayList<Map<String, String>> expenses = new ArrayList<Map<String, String>>();
		//public Expense(int expenseID, int categoryID, String category, int userID, double cost, Date date, String comment)
		String sql = "SELECT expenseID, categoryID, categories.name, categories.image, users.firstName, users.lastName, users.userID, cost, date, comment\n" + 
				"FROM expenses\n" + 
				"INNER JOIN users on users.userID = expenses.userID\n" + 
				"INNER JOIN categories on categories.id = expenses.categoryID\n" + 
				"WHERE users.userID = ? AND (DATE(date) =  DATE(CURRENT_TIMESTAMP))\n" + 
				"LIMIT 6";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setInt(1, userID);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				//expenses.add(new Expense(rs.getInt("expenseID"), rs.getInt("categoryID"), rs.getString("name"), rs.getInt("userID"), rs.getDouble("cost"), rs.getString("date"), rs.getString("comment")));
				//expense.add();
				Map<String, String> reMap = new HashMap<String, String>();
				reMap.put("image", rs.getString("image"));
				reMap.put("name", rs.getString("name"));
				reMap.put("firstname", rs.getString("firstName"));
				reMap.put("lastname", rs.getString("lastName"));
				reMap.put("cost", String.valueOf(rs.getString("cost")));
				reMap.put("date", rs.getString("date"));
				reMap.put("comment", rs.getString("comment"));
				expenses.add(reMap);

			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return expenses;
	}
}
