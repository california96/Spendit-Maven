package com.spendit.model;

import java.sql.Date;

public class Expense {
	private int expenseID;//use this only for retrieval
	private int categoryID;
	private String category;//also for retrieval
	private int userID; //pull this from session User
	private double cost;
	private String date;
	private String comment;
	
	//for creation
	public Expense(int categoryID, int userID, double cost, String date, String comment) {
		this.categoryID = categoryID;
		this.userID = userID;
		this.cost = cost;
		this.date = date;
		this.comment = comment;
	}
	//for retrieval
	public Expense(int expenseID, int categoryID, String category, int userID, double cost, String date, String comment) {
		this.expenseID = expenseID;
		this.categoryID = categoryID;
		this.category = category;
		this.userID = userID;
		this.cost = cost;
		this.date = date;
		this.comment = comment;
	}
	public int getExpenseID() {
		return expenseID;
	}
	public void setExpenseID(int expenseID) {
		this.expenseID = expenseID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
}
