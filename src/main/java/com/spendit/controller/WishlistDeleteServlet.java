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
@WebServlet("/deletewish.action")
public class WishlistDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int wishID = Integer.parseInt(request.getParameter("id"));
	
		
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		Connection connection = DBConnection.getConnection(getServletContext());

		
		WishlistOperations wishOps = new WishlistOperations();
		wishOps.deleteWishlist(connection, wishID);
		
//			ArrayList<Wishlist> wishlist = wishOps.getFullWishlist(connection, user.getUserID());
//			request.setAttribute("wishlist", wishlist);
//			request.getRequestDispatcher("retrievewishlist.action").forward(request, response);
		response.sendRedirect("retrievewishlist.action");
		
	}

}
