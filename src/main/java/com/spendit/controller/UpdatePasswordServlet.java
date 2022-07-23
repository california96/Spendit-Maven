package com.spendit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

import com.spendit.model.User;
import com.spendit.utility.DBConnection;

/**
 * Servlet implementation class UpdateAccountDetailsServlet
 */
@MultipartConfig
@WebServlet("/updatepassword.action")
public class UpdatePasswordServlet extends HttpServlet {
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
		String currentPass = request.getParameter("currentpass");
		String newPass = request.getParameter("newpass");
		
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		//UserOperations uOps = new UserOperations();
		AccountEditOperations aeOps = new AccountEditOperations();
		Connection connection = DBConnection.getConnection(getServletContext());
		Gson gson = new Gson();
		HashMap<Object, Object> message = new HashMap<Object, Object>();
		String json;


		if(aeOps.authenticate(connection, user.getUserName(), currentPass)) {
			aeOps.updatePassword(connection, user.getUserName(), newPass, currentPass);
			//message.put("msg", "successful");
			//response.setContentType("application/json");
			//response.setCharacterEncoding("UTF-8");
			//json = gson.toJson(message);
		//	response.getWriter().write(json);
		//	response.sendRedirect("accountsettings.jsp");
			LogController.logActivity(connection, user.getUserID(), LogController.UPDATED_PASSWORD);
			PrintWriter out = response.getWriter();
			out.print("<script>alert('Password updated!');"
					+ "window.location = 'accountsettings.jsp';</script>");
		}
		else {
			message.put("msg", "incorrect");
	
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			json = gson.toJson(message);
			response.getWriter().write(json);
		//	response.sendRedirect("accountsettings.jsp");
		}
	
	}

}
