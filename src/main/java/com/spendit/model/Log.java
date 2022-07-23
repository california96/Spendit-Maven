package com.spendit.model;

public class Log {
	private String email;
	private String activity;
	private String date;
	
	public Log(String email, String activity, String date) {
		this.email = email;
		this.activity = activity;
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
