package com.spendit.controller;

import com.spendit.model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class StatusOperations {
	public ArrayList<com.spendit.model.Status> getAllStatus(Connection connection){
		ArrayList<com.spendit.model.Status> status = new ArrayList<com.spendit.model.Status>();
		String sql = "SELECT * FROM status";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				status.add(new Status(rs.getInt("statusID"), rs.getString("status")));
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		return status;
	}
}
