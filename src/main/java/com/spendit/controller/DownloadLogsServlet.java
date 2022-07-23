package com.spendit.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.opencsv.CSVWriter;

import com.spendit.model.User;
import com.spendit.utility.DBConnection;

/**
 * Servlet implementation class DownloadLogsServlet
 */
@WebServlet("/downloadlogs.action")
public class DownloadLogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] headers = {"email", "activity", "date"};
		String fileName = "Spendit-"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		Connection connection = DBConnection.getConnection(getServletContext());
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".csv");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write("email, activity, date\n".getBytes());
			ResultSet rs = LogController.getAllLogs(connection);
			while(rs.next()) {
				String input = rs.getString("email") + ", " + rs.getString("activityName") + ", " + (rs.getString("date") + "\n");
				outputStream.write(input.getBytes());
				
			}
			outputStream.flush();
			outputStream.close();
			
		}catch(Exception e) {
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
