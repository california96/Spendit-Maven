package com.spendit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetrieveProfilePictureServlet
 */
@WebServlet("/retrieveimage.action")
public class RetrieveImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static int BUFFER_SIZE = 1024 * 100;
   
    public void init(ServletConfig config)throws ServletException{
    	super.init(config);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName = request.getParameter("fileName");
		String module = request.getParameter("module");
		String application = "";
		switch(module.toLowerCase()) {
		case "profile":
			application = getServletContext().getInitParameter("profilePicStorage");
			break;
		case "category":
			application = getServletContext().getInitParameter("categoryStorage");
			break;
		
			
		}
		
		String filePath = application + File.separator + fileName;
		if(fileName == null || fileName.equals(""))
		{
			System.err.println("File not found");
		}
		else{
			File file = new File(filePath);
			OutputStream outStream= null;
			FileInputStream inputStream = null;
			
			if(file.exists()) {
				try {
					outStream = response.getOutputStream();
					
					inputStream = new FileInputStream(file);
					byte [] buffer = new byte[BUFFER_SIZE];
					int bytesRead = -1;
					
					while((bytesRead = inputStream.read(buffer))!= -1) {
						outStream.write(buffer, 0, bytesRead);
					}
				}catch(IOException ioe) {
					System.err.println(ioe.getMessage());
				}finally {
					if(inputStream != null) {
						inputStream.close();
					}
					outStream.flush();
					if(outStream != null) {
						outStream.close();
					}
				}
			}else {
				//response.sendRedirect("404error.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

