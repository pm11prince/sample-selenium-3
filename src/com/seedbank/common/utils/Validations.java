package com.seedbank.common.utils;

import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;

public class Validations {
	public static String randomValue=null;

	public static String generateRandomNumber(String type, int length) {

		type.equalsIgnoreCase(type);
		switch(type)
		{
		case "Numeric":
			randomValue = RandomStringUtils.randomNumeric(length);
			while(randomValue.charAt(0)=='0')
			{
				randomValue = RandomStringUtils.randomNumeric(length);
			}
			break;

		case "AlphaNumeric":
			randomValue =  RandomStringUtils.randomAlphanumeric(length);
			break;

		case "Alphabetic": 
			randomValue =RandomStringUtils.randomAlphabetic(length);
			break;

		case "SpecialChar":
			char[] ch = "#!@#$%^&*()[]{}/\\|:'?-_+=".toCharArray();
			char[] c = new char[length];
			SecureRandom random = new SecureRandom();
			for (int i = 0; i < length; i++) {
				c[i] = ch[random.nextInt(ch.length)];
			}
			randomValue = new String(c);
			break;
		default:
			Logger.log("Invalid conversion type:"+ type);
		}
		return randomValue;
	}

	/* To check whether the length of the argument string matches the given length */
	public static boolean checkLength(String s,int length){
		if(s.length()==length)
			return true;
		else 
			return false;
	}


}



