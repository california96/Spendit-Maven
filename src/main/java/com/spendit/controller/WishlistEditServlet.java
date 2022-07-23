package com.spendit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.spendit.model.Wishlist;
import com.spendit.model.User;
import com.spendit.utility.DBConnection;

/**
 * Servlet implementation class WishlistCreateServlet
 */
@WebServlet("/updatewish.action")
public class WishlistEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int categoryID = Integer.parseInt(request.getParameter("categoryID"));
		int incomeSourceID = Integer.parseInt(request.getParameter("incomeSourceID"));
		int statusID = Integer.parseInt(request.getParameter("statusID"));
		int wishID = Integer.parseInt(request.getParameter("wishID"));
		double amount = Double.parseDouble(request.getParameter("amount"));	
		String comment = request.getParameter("comment");
		
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		Connection connection = DBConnection.getConnection(getServletContext());
		if(StringUtils.isBlank(comment)) {
			response.sendError(400);
			//response.sendRedirect("400.jsp");
			return;
		}
		try {
		//java.util.Date formatted = new SimpleDateFormat("yyyy-MM-dyyyy").parse(date);  
		java.util.Date date = new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(request.getParameter("date"));
		String formatted = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		Wishlist wish = new Wishlist(user.getUserID(), categoryID, incomeSourceID, 1, amount, formatted, comment);
		WishlistOperations wishOps = new WishlistOperations();
		wishOps.editWishlist(connection, categoryID, incomeSourceID, statusID, amount, formatted, comment, wishID);
		response.sendRedirect("retrievewishlist.action");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
