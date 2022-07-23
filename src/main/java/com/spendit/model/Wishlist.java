package com.spendit.model;
import java.sql.Date;
public class Wishlist {
	private int id;
	private int userID;
	private int categoryID;
	private String category;
	private int incomeSourceID;
	private String incomeSource;
	private int statusID;
	private String status;
	private double amount;
	private String date;
	private String comment;
	//Create
	public Wishlist(int userID, int categoryID, int incomeSourceID, int statusID, double amount, String date, String comment) {
		this.userID = userID;
		this.categoryID = categoryID;
		this.incomeSourceID = incomeSourceID;
		this.statusID = statusID;
		this.amount = amount;
		this.date = date;
		this.comment = comment;
	}
	//Retrieve
	public Wishlist(int id, int userID, int categoryID, String category, int incomeSourceID, String incomeSource, int statusID, String status, double amount, String date, String comment) {
		this.id = id;
		this.userID = userID;
		this.categoryID = categoryID;
		this.category = category;
		this.incomeSourceID = incomeSourceID;
		this.incomeSource = incomeSource;
		this.statusID = statusID;
		this.status = status;
		this.amount = amount;
		this.date = date;
		this.comment = comment;
	}
	//Without income source
	public Wishlist(int id, int userID, int categoryID, String category, int statusID, String status, double amount, String date, String comment) {
		this.id = id;
		this.userID = userID;
		this.categoryID = categoryID;
		this.category = category;
		this.statusID = statusID;
		this.status = status;
		this.amount = amount;
		this.date = date;
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIncomeSourceID() {
		return incomeSourceID;
	}
	public void setIncomeSourceID(int incomeSourceID) {
		this.incomeSourceID = incomeSourceID;
	}
	public String getIncomeSource() {
		return incomeSource;
	}
	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}
	
	
	
}
