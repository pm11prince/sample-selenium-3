package com.seedbank.common.pageobjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class xcvdvd {
	public static void main(String args[]) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String date1 ="11/10/2029";
		String date2 = "11/10/2020";
		 Date d1= format.parse(date1);
		 Date d2= format.parse(date2);
		 

if (d1.compareTo(d2) <= 0) 
    System.out.println(date1);
    else 
    	System.out.println(date2);
}
}
