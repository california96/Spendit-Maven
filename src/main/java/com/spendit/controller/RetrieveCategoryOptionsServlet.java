package com.spendit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import com.spendit.model.*;

import com.spendit.utility.DBConnection;

/**
 * Servlet implementation class RetrieveCategoryOptionsServlet
 */
@WebServlet("/retrievecategoryoptions.action")
public class RetrieveCategoryOptionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int moduleID = Integer.parseInt(request.getParameter("module"));
		User user = (User)session.getAttribute("user");
		Connection connection = DBConnection.getConnection(getServletContext());
		ArrayList<Category> categories = new CategoryOperations().getCategories(connection, moduleID);
		Gson gson = new Gson();
		String json = gson.toJson(categories);
		//System.out.println(json);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
//		request.setAttribute("expenses", expenses);
//		request.getRequestDispatcher("expenseindex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
