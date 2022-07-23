package com.spendit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spendit.model.User;
import com.spendit.utility.DBConnection;

/**
 * Servlet implementation class SignOutServlet
 */
@WebServlet("/signout.action")
public class SignOutServlet extends HttpServlet {
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
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		LogController.logActivity(DBConnection.getConnection(getServletContext()), user.getUserID(), LogController.LOGGED_OUT);
		session.invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
