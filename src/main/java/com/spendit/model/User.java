package com.spendit.model;

public class User {
	
	private int userID; //use this for URL parameters only!
	private String lastName;
	private String firstName;
	private String userName;
	private String email;
	private String password;
	private String image;
	
	public User(String lastName, String firstName, String userName, String email, String password, String image) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.image = image;
	}
	//use this for session tracking
	public User(int userID, String lastName, String firstName, String userName, String email, String image) {
		this.userID = userID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.email = email;
		this.image = image;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {

		this.password = password;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
		
}
