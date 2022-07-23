package com.spendit.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;

import com.spendit.model.User;
import com.spendit.utility.DBConnection;

/**
 * Servlet implementation class UpdateAccountDetailsServlet
 */
@MultipartConfig
@WebServlet("/updateaccount.action")
public class UpdateAccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String image = "";
		
		
		Part filePart = request.getPart("file");
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		UserOperations uOps = new UserOperations();
		
		String uploadPath = getServletContext().getInitParameter("profilePicStorage");
		Connection connection = DBConnection.getConnection(getServletContext());
		if(StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName) || StringUtils.isBlank(username) ) { //assume that XSSFilter is blocked
			System.out.println("First Name is: " + firstName);
			System.out.println("Last Name is: " + lastName);
			
			System.out.println("User Name is: " + username);
			System.out.println("Email  is: " + email);
			//response.sendRedirect("400.jsp");
			response.sendError(400);
			return;
		}
		if(filePart.getSize() > 0) {
			image = uOps.uploadImage(uploadPath, filePart);
			}else {
				image = user.getImage();
			}
		AccountEditOperations aEOps = new AccountEditOperations();
		aEOps.editAccount(connection, firstName, lastName, username, email, image, user.getUserID());
		user.setUserName(username);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setImage(image);
		response.sendRedirect("accountsettings.jsp");
	}

}
