package com.spendit.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.opencsv.CSVWriter;

import com.spendit.model.Log;

public class LogController {
	public static final int ACCOUNT_CREATED = 1;
	public static final int LOGGED_IN = 2;
	public static final int LOGGED_OUT = 3;
	public static final int FORGOT_PASSWORD = 4;
	public static final int UPDATED_PASSWORD = 5;
	
	public static void logActivity(Connection connection, int userID, int activityID) {
		String sql = "INSERT INTO `spenditdb`.`logs` (`userID`, `activityID`, `date`) VALUES (?, ?, ?);";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userID);
			ps.setInt(2, activityID);
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			ps.executeUpdate();
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
	}
	public static ResultSet getAllLogs(Connection connection){
		ResultSet rs = null;
		String sql = "SELECT users.email, activities.activityName, date FROM logs\n" + 
				"INNER JOIN users on logs.userID = users.userID\n" + 
				"INNER JOIN activities on logs.activityID = activities.activityID";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		return rs;
	}
	
	
	
}
