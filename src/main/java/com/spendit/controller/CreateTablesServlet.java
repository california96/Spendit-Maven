package com.spendit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.spendit.utility.DBConnection;
import com.spendit.controller.DatabaseController;
/**
 * Servlet implementation class CreateTablesServlet
 */
@WebServlet("/createtables.action")
public class CreateTablesServlet extends HttpServlet {
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
		ServletContext context = request.getServletContext();
		Connection connection = DBConnection.getConnection(context);
		DatabaseController dbController = new DatabaseController(connection);
		dbController.initializeTables();
		PrintWriter out = response.getWriter();
		out.print("<script>alert('Database initialized!');"
				+ "window.location.replace('index.jsp');</script>");
	}

}
