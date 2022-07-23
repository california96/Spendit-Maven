package com.spendit.utility;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletContext;
public class Mailer {
	private ServletContext context;
	public Mailer(ServletContext context) {
		this.context = context;
	}
	
	public void sendEmail(String from, String password, String recipient, String subject, String messageBody) {
		Properties props = new Properties();
		props.put(context.getInitParameter("smtpHost"), context.getInitParameter("smtpURL"));
		props.put(context.getInitParameter("smtpsFPort"), context.getInitParameter("smtpPortNo"));
		props.put(context.getInitParameter("smtpClass"), context.getInitParameter("smtpJavaX"));
		props.put(context.getInitParameter("smtpAuth"), context.getInitParameter("smtpAllowAuth"));
		props.put(context.getInitParameter("smtpPort"), context.getInitParameter("smtpPortNo"));
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		
		try {
	    	 MimeMessage message = new MimeMessage(session);
	    	 message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	    	 message.setSubject(subject);
	    	 message.setContent(messageBody, "text/html");
	    	 //Sending
	    	 Transport.send(message);
	    	 
	     }
	     catch(MessagingException me)
	     {
	    	 me.printStackTrace();
	     }
	
	}
	
	
}
