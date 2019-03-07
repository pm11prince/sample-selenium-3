package com.seedbank.common.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.seedbank.common.utils.DataReference;

public class sample{
	
	public String dateOfHarvesting = DataReference.references.get("Harvesting dateOfHarvesting");
	
	

	public static void main() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String date1 ="11/10/2019";
		String date2 = "11/10/2020";
		 Date d1= format.parse(date1);
		 Date d2= format.parse(date2);

		 //changes frpm, sneha
		 
///sdjfkdjfdsjk

		 //added comments
		 //sneha

		 
		 //from deep
//deepa ee
//conflicts
if (d1.compareTo(d2) <= 0) 
    System.out.println(date1);
    else 
    	System.out.println(date2);
}
	}

