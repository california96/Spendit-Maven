package com.spendit.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.Part;
import com.spendit.model.User;
import com.spendit.utility.BCrypt;
import org.apache.commons.lang3.RandomStringUtils;

public class UserOperations {
	public boolean insert(Connection connection, String userName, String email, String password, String firstName, String lastName, String image) {
		String sql = "INSERT INTO users(username, email, password, firstname, lastname, image) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setString(1, userName.toLowerCase());
			prep.setString(2, email);
			prep.setString(3, BCrypt.hashpw(password, BCrypt.gensalt()));
			prep.setString(4, firstName);
			prep.setString(5, lastName);
			prep.setString(6, image);
			prep.executeUpdate();
			return true;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	/*Step 1: Retrieve user row from DB based on username */
	/*Step 2: Using the value of parameter password, we'll check hash matches using BCrypt.checkpw(String plaintextentry, String hashedpasswordindb)*/
	/*Step 3: Return true if checkpw is successful*/
	public boolean authenticate(Connection connection, String username, String password) {
		String sql = "SELECT username, password FROM users WHERE username = ?";
		ResultSet rs = null;
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setString(1, username.toLowerCase());
			rs = prep.executeQuery();
			while(rs.next()) {
				if(BCrypt.checkpw(password, rs.getString("password"))) {
					return true;
				}
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	public User getUser(Connection connection, String username) {
		User user = null;
		String sql = "SELECT userid, firstname, lastname, username, email, image FROM users where username = ?";
		ResultSet rs = null;
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.setString(1, username.toLowerCase());
			rs = prep.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt("userID"), rs.getString("lastname"), rs.getString("firstname"), rs.getString("username"), rs.getString("email"), rs.getString("image"));
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return user;
	}
	/**
	 * Uploading an image if applicable
	 * 
	 * @param uploadPath String of uploadPath extracted from web.xml. Do not use a folder within the project.
	 * @param filePart	Part coming from the request via request.getPart();
	 */
	public String uploadImage(String uploadPath, Part filePart) {
		String fileName;
		try {
			fileName = getFileName(filePart);
			//String path = "fileStorage" + File.separator + fileName;
			InputStream is = filePart.getInputStream();
			Files.copy(is, Paths.get(uploadPath  + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Filename: " + fileName);
			return fileName;
//		}catch(DirectoryNotEmptyException dnee) {
//			return dnee.getMessage();
//		}catch(IOException ioe) {
//			return ioe.getMessage();
		}catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	public String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
	public boolean checkEmail(Connection connection, String email) {
		try {
			String sql = "SELECT email FROM users where email = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			return (rs.next());
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		return false;
	}
	public void updatePassword(Connection connection, String email, String password) {
		try {
			String sql = "UPDATE users set password = ? WHERE email = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			ps.executeUpdate();
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			
		}
	}
	public String generatePassword() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		return RandomStringUtils.random(10, chars);
	}
	
	public boolean checkUser(Connection connection, String username) {
		try {
			String sql = "SELECT username from users where username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			return(rs.next());
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		return false;
	}
	/*Note that this is mainly for use by audit logging*/
	public int getUserIDbyEmail(Connection connection, String email) {
		int userID = 0;
		try {
			String sql = "SELECT userID from users where email = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				userID = rs.getInt("userID");
				System.out.println("User ID: " + userID);
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		return userID;
	}
}
