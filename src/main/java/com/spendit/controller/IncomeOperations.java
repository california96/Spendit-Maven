package com.spendit.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.spendit.model.Expense;
import com.spendit.model.Income;
import com.spendit.model.User;
public class IncomeOperations {
	public boolean insert(Connection connection, int userID, int categoryID, double amount, String date, String comment) {
		String sql = "INSERT INTO incomes(userID, categoryID, amount, date, comment) VALUES (?, ?,?, ?, ?)";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setInt(1, userID);
			prep.setInt(2, categoryID);
			prep.setDouble(3, amount);
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
	public ArrayList<Income> getAllIncome(Connection connection, int userID){
		ArrayList<Income> incomes = new ArrayList<Income>();
		String sql = "SELECT incomeID, userID, incomes.categoryID, categories.name, amount, date, comment\n" + 
				"				FROM incomes\n" + 
				"				INNER JOIN categories on categories.id = incomes.categoryID\n" + 
				"				WHERE incomes.userID = ?";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setInt(1, userID);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				incomes.add(new Income(rs.getInt("incomeID"), rs.getInt("userID"), rs.getInt("categoryID"), rs.getString("name"), rs.getDouble("amount"), rs.getString("date"), rs.getString("comment")));
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return incomes;
	}
	public Income getIncome(Connection connection, int incomeID) {
		Income income = null;
		String sql = "SELECT incomeID, userID, incomes.categoryID, categories.name, amount, date, comment\n" + 
				"				FROM incomes\n" + 
				"				INNER JOIN categories on categories.id = incomes.categoryID\n" + 
				"				WHERE incomes.incomeID = ?";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setInt(1, incomeID);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				income = new Income(rs.getInt("incomeID"), rs.getInt("userID"), rs.getInt("categoryID"), rs.getString("name"), rs.getDouble("amount"), rs.getString("date"), rs.getString("comment"));
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return income;
	}
	public void editIncome(Connection connection, int incomeID, int categoryID, double amount, String date, String comment) {
		String sql = "UPDATE incomes SET categoryID = ? , amount = ?, date = ?, comment = ? WHERE incomes.incomeID = ?";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setInt(1, categoryID);
			prep.setDouble(2, amount);
			prep.setString(3, date);
			prep.setString(4, comment);
			prep.setInt(5, incomeID);
			prep.executeUpdate();
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public void deleteIncome(Connection connection, int incomeID) {
		String sql = "DELETE FROM incomes WHERE incomes.incomeID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, incomeID);
			ps.executeUpdate();
			
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}

	}
	public double getMonthlyIncome(Connection connection, int userID) {
		double monthlyIncome = 0.0;
		String sql = "SELECT SUM(amount) as 'monthlyincome' FROM incomes WHERE incomes.userID = ? AND (MONTH(date) = MONTH(CURRENT_TIMESTAMP) AND YEAR(date) = YEAR(CURRENT_TIMESTAMP))";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				monthlyIncome = rs.getDouble("monthlyincome");
			}
			return monthlyIncome;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		return monthlyIncome;
	}
	public ArrayList<Income> getAllMonthsIncome(Connection connection, int userID){
		ArrayList<Income> income = new ArrayList<Income>();
	
	
		String sql = "SELECT incomeID, userID, incomes.categoryID, categories.name, amount, date, comment\n" + 
				"				FROM incomes\n" + 
				"				INNER JOIN categories on categories.id = incomes.categoryID\n" + 
				"				WHERE incomes.userID = ? AND (MONTH(date) = MONTH(CURRENT_TIMESTAMP) AND YEAR(date) = YEAR(CURRENT_TIMESTAMP))";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setInt(1, userID);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				//expenses.add(new Expense(rs.getInt("expenseID"), rs.getInt("categoryID"), rs.getString("name"), rs.getInt("userID"), rs.getDouble("cost"), rs.getString("date"), rs.getString("comment")));
				income.add(new Income(rs.getInt("incomeID"), rs.getInt("userID"), rs.getInt("categoryID"), rs.getString("name"), rs.getDouble("amount"), rs.getString("date"), rs.getString("comment")));
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return income;
	}
	public void downloadIncome(HttpServletResponse response, ArrayList<Income> income, User user) {
		try {
		//step 1: Initialize Document
		Document document = new Document();
		//step 2: Get Instance
		PdfWriter.getInstance(document, response.getOutputStream());
		//step 3: Open Document
		document.open();
		//Step 4: Retrieve Expenses Breakdown
		
		//Step 5: Initialize Title 
		document.add(new Paragraph("Income Report of user: " + user.getUserName()));
		document.add(new Paragraph("As of: " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new java.util.Date().getTime())));
		//Step 6: Initialize Table and Headers
		PdfPTable table = new PdfPTable(4);
		PdfPCell cell1 = new PdfPCell(new Paragraph("Category"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("Comment"));
        PdfPCell cell3 = new PdfPCell(new Paragraph("Amount"));
        PdfPCell cell4 = new PdfPCell(new Paragraph("Date Added"));
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        //Step 7: Loop through expenses
        for(Income i : income) {
        	PdfPCell category = new PdfPCell(new Paragraph(i.getCategory()));
        	PdfPCell comment = new PdfPCell(new Paragraph(i.getComment()));
        	PdfPCell cost = new PdfPCell(new Paragraph("Php " + i.getAmount()));
        	PdfPCell date = new PdfPCell(new Paragraph(i.getDate()));
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
}
