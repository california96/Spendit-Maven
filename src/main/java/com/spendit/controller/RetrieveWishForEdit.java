package com.spendit.controller;

import com.spendit.model.Category;
import com.spendit.model.Status;
import com.spendit.model.Wishlist;
import com.spendit.utility.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
/**
 * Servlet implementation class RetrieveExpenseServlet
 */
@WebServlet("/retrievewish.action")
public class RetrieveWishForEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection(getServletContext());
		int wishID = Integer.parseInt(request.getParameter("id"));
		WishlistOperations wOps = new WishlistOperations();
		Wishlist wish = wOps.retrieveWish(connection, wishID);
	
			ArrayList<com.spendit.model.Module> modules = new ModuleOperations().getModules(connection);
			ArrayList<Category> incomesources = new CategoryOperations().getCategories(connection, 2);
			ArrayList<Category> wishcategories = new CategoryOperations().getCategories(connection, 3); 
			ArrayList<Status> status = new StatusOperations().getAllStatus(connection);
			request.setAttribute("wish", wish);
			request.setAttribute("modules", modules);
			request.setAttribute("incomesources", incomesources);
			request.setAttribute("wishcategories", wishcategories);
			request.setAttribute("status", status);
			request.getRequestDispatcher("editwish.jsp").forward(request, response);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
