package com.spendit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBTest {
	public static void main(String args[])throws ParseException {

		String date = "05/20/2020 01:05 PM";
		try {
			
			Date date2 = new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(date);
			System.out.println(date2);
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);
			System.out.println(date);

		
			}catch(ParseException pe) {
				System.err.println(pe.getMessage());
			}
	}
}
