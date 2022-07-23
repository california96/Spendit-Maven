package com.spendit.controller;

import com.google.gson.Gson;
import com.spendit.utility.BCrypt;
import com.spendit.utility.DBConnection;
import com.spendit.utility.Mailer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

/**
 * Servlet implementation class ProcessForgotPasswordServlet
 */
@WebServlet("/processpassword.action")
public class ProcessForgotPasswordServlet extends HttpServlet {
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
		String email = request.getParameter("email");
		UserOperations userOps = new UserOperations();
		ServletContext context = getServletContext();
		Connection connection = DBConnection.getConnection(getServletContext());
		Gson gson = new Gson();
		HashMap<Object, Object> errorMsg = new HashMap<>();
		String json;
		if(userOps.checkEmail(connection, email)) {
			System.out.println("Yes!");
			String newPass = userOps.generatePassword();
			System.out.println(newPass);
			userOps.updatePassword(connection, email, BCrypt.hashpw(newPass, BCrypt.gensalt()));
			Mailer mailer = new Mailer(context);
			String messageBody = SpenditConstants.MESSAGE_BODY + newPass + SpenditConstants.MESSAGE_BODY_THANKS;
			mailer.sendEmail(context.getInitParameter("MailerEmail"), context.getInitParameter("MailerPass"), email, "Change Password Request", messageBody);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			LogController.logActivity(connection, userOps.getUserIDbyEmail(connection, email), LogController.FORGOT_PASSWORD);
			errorMsg.put("msg", "success");
			json =gson.toJson(errorMsg);
			response.getWriter().write(json);
		}
		else {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			errorMsg.put("msg", "failure");
			json =gson.toJson(errorMsg);
			response.getWriter().write(json);
		}
	}

}
