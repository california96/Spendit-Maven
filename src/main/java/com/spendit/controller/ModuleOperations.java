package com.spendit.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ModuleOperations {
	public ArrayList<com.spendit.model.Module> getModules(Connection connection){
	ArrayList<com.spendit.model.Module> modules = new ArrayList<com.spendit.model.Module>();
	try {
		String sql = "SELECT moduleID, moduleName FROM modules";
		PreparedStatement prep = connection.prepareStatement(sql);
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			modules.add(new com.spendit.model.Module(rs.getInt("moduleID"), rs.getString("moduleName")));
		}
		
	}catch(Exception e) {
		System.err.println(e.getMessage());
	}
	return modules;
	}
}
