package com.spendit.model;
import java.sql.Date;
public class Income {
	private int incomeID;
	private int userID;
	private int categoryID;
	private String category;
	private double amount;
	private String date;
	private String comment;
	
	public Income() {
		
	}
	//Insertion constructor
	public Income(int userID, int categoryID, double amount, String date, String comment) {
		this.userID = userID;
		this.categoryID = categoryID;
		this.amount = amount;
		this.date = date;
		this.comment = comment;
	}
	//retrieval constructor
	public Income(int incomeID, int userID, int categoryID, String category, double amount, String date, String comment) {
		this.incomeID = incomeID;
		this.userID = userID;
		this.categoryID = categoryID;
		this.category = category;
		this.amount = amount;
		this.date = date;
		this.comment = comment;
	}
	public int getIncomeID() {
		return incomeID;
	}
	public void setIncomeID(int incomeID) {
		this.incomeID = incomeID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
}
