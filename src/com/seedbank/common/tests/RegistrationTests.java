package com.seedbank.common.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.seedbank.base.TestCaseBase;
import com.seedbank.common.pageobjects.PageFactory;
import com.seedbank.common.reporting.Values;
import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.DataReference;
import com.seedbank.common.utils.Logger;
import com.seedbank.common.utils.Validations;

/**
 * <copyright company="ITC INFOTECH"> Reproduction or
 * transmission in whole or in part, in any form or by any means, electronic,
 * mechanical or otherwise, is prohibited without the prior written permission
 * of the copyright owner. </copyright>
 * 
 * @author Sneha Mitra
 */

public class RegistrationTests {
	public static String validValue, invalidValue;
	public static boolean result; 
	public static String actual,expected;

	public static String popupMessageText = DataReference.references.get("Register invalid input_message");
	public static String OTPValue =  DataReference.references.get("Register OTPValue");
	public String invalidOtpMessage =  DataReference.references.get("Register invalidOtpMessage");
	public String registeredMobileNumberMessage =  DataReference.references.get("Register registeredMobileNumberMessage");
	public String registeredMobileNumber_farmer =  DataReference.references.get("Register registeredMobileNumber_farmer");


	/* Description : To check whether invalid mobile numbers get accepted 
	 * (AlphaNumeric, Special Character, Alphabetic) */	

	@Test(priority = 1, groups = { "Registration_Invalid Mobile Number"})
	public void checkForInvalidMobileNumber_SpecialChar() throws InterruptedException
	{	
	/*	Values.tcDescription ="Registration validation for invalid mobile number";
		invalidValue = Validations.generateRandomNumber("SpecialChar", 10);
		Values.tcTestData=invalidValue;
		PageFactory.register.enterMobileNumberAndSignup(invalidValue);
		expected = popupMessageText;
		Action.waitALittle(4000);
		actual= PageFactory.register.getPopupMessage();
		Action.waitALittle(4000);
		PageFactory.register.dismissPopupMessageBox();
		Logger.log("Invalid Mobile number:"+invalidValue);
		Assert.assertEquals(actual, expected);*/
		Action.waitALittle(5000);
		Assert.fail("TEst Method failed");
		}


	@Test(priority = 2, groups = { "Registration_Invalid Mobile Number"},dependsOnMethods = { "checkForInvalidMobileNumber_SpecialChar" })
	public void checkForInvalidMobileNumber_AlphaNumeric()
	{
		/*invalidValue = Validations.generateRandomNumber("AlphaNumeric", 10);
		Values.tcTestData=invalidValue;
		PageFactory.register.enterMobileNumberAndSignup(invalidValue);
		expected = popupMessageText;
		Action.waitALittle(4000);
		actual= PageFactory.register.getPopupMessage();
		Action.waitALittle(4000);
		PageFactory.register.dismissPopupMessageBox();
		Logger.log("Invalid Mobile number:"+invalidValue);
		Assert.assertEquals(actual, expected);*/
	}

	@Test(priority = 3, groups = { "Registration_Invalid Mobile Number"},dependsOnMethods = { "checkForInvalidMobileNumber_AlphaNumeric" })
	public void checkForInvalidMobileNumber_Alphabetic() 
	{
	/*	invalidValue = Validations.generateRandomNumber("Alphabetic", 10);
		Values.tcTestData=invalidValue;
		PageFactory.register.enterMobileNumberAndSignup(invalidValue);
		expected = popupMessageText;
		Action.waitALittle(4000);
		actual= PageFactory.register.getPopupMessage();
		Action.waitALittle(4000);
		PageFactory.register.dismissPopupMessageBox();
		Assert.assertEquals(actual, expected); */
	}


	@Test(priority = 4, groups = { "Registration_Invalid Mobile Number"},dependsOnMethods = { "checkForInvalidMobileNumber_Alphabetic" })
	public void checkForInvalidMobileNumber_checkMobileNumberLength()
	{
	/*	invalidValue = Validations.generateRandomNumber("Numeric", 5);
		Values.tcTestData=invalidValue;
		PageFactory.register.enterMobileNumberAndSignup(invalidValue);
		expected = popupMessageText;
		Action.waitALittle(4000);
		actual= PageFactory.register.getPopupMessage();
		Action.waitALittle(4000);
		PageFactory.register.dismissPopupMessageBox();
		Assert.assertEquals(actual, expected);*/
	}


	/* Description : To check whether invalid OTPs get accepted 
	 * (AlphaNumeric, Special Character, Alphabetic) 
	 * Following three groups are dependant on each other*/	


	@Test(priority = 5, groups = { "Registration_Invalid OTP"})
	public void checkForInvalidOTP_SpecialChar()
	{
		//Action.relaunch();
		/*Values.tcDescription ="Registration validation for invalid otp";
		validValue = Validations.generateRandomNumber("Numeric", 10);
		invalidValue = Validations.generateRandomNumber("SpecialChar", 6);
		Values.tcTestData=invalidValue;
		PageFactory.register.enterMobileNumberAndSignup(validValue);
		Action.waitALittle(4000);
		expected = invalidOtpMessage;
		PageFactory.register.clickOnNextButton();
		PageFactory.register.enterOTP(invalidValue);
		actual = PageFactory.register.getPopuMessage_InvalidOTP();
		PageFactory.register.dismissPopupMessageBox();
		Action.waitALittle(2000);
		System.out.println(actual);
		Assert.assertEquals(actual, expected);	*/
	}

	@Test(priority = 6, groups = { "Registration_Invalid OTP"},dependsOnMethods = { "checkForInvalidOTP_SpecialChar" })
	public void checkForInvalidOTP_AlphaNumeric()
	{
		/*Action.waitALittle(5000);
		Action.navigateBack();
		invalidValue = Validations.generateRandomNumber("AlphaNumeric", 6);
		Values.tcTestData=invalidValue;
		//PageFactory.register.enterMobileNumberAndSignup(mobile);
		Action.waitALittle(4000);
		expected = invalidOtpMessage;
		PageFactory.register.clickOnNextButton();
		PageFactory.register.enterOTP(invalidValue);
		actual = PageFactory.register.getPopuMessage_InvalidOTP();
		Action.waitALittle(2000);
		PageFactory.register.dismissPopupMessageBox();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);*/
		Assert.fail("TEst Method failed");
	}

	@Test(priority = 7, groups = { "Registration_Invalid OTP"},dependsOnMethods = { "checkForInvalidOTP_AlphaNumeric" })
	public void checkForInvalidOTP_Alphabetic()
	{
	/*	Action.waitALittle(5000);
		Action.navigateBack();
		invalidValue = Validations.generateRandomNumber("Alphabetic", 6);
		Values.tcTestData=invalidValue;
		//PageFactory.register.enterMobileNumberAndSignup(mobile);
		Action.waitALittle(4000);
		expected = invalidOtpMessage;
		PageFactory.register.clickOnNextButton();
		PageFactory.register.enterOTP(invalidValue);
		actual = PageFactory.register.getPopuMessage_InvalidOTP();
		PageFactory.register.dismissPopupMessageBox();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);*/
	}


	@Test(priority = 8, groups = { "Register with already registered number"})
	public void registerWithAlreadyRegisteredNumber(){
		Action.relaunch();
		Action.waitALittle(6000);
		Values.tcDescription = "Registration validation for valid inputs";
		validValue = Validations.generateRandomNumber("Numeric", 10);
		Values.tcTestData=validValue;
		PageFactory.register.enterMobileNumberAndSignup(validValue);
		PageFactory.register.clickOnNextButton();
		PageFactory.register.enterOTP(OTPValue);
		PageFactory.genericPageElements.checkIfProfileIsLoaded();
		Action.waitALittle(5000);
		Action.navigateBack();
		Action.waitALittle(3000);
		PageFactory.user_dashboard.clickOnSlider();
		PageFactory.user_dashboard.clickOnMenu("Log Out");		
		Action.waitALittle(6000);
		PageFactory.register.enterMobileNumberAndSignup(validValue);
		actual = PageFactory.register.getPopupMessage_AlreadyRegisteredNumber();
		System.out.println(actual);
		expected=registeredMobileNumberMessage;
		Action.waitALittle(3000);
		PageFactory.register.dismissPopupMessageBox();
		Assert.assertEquals(actual, expected);		
	}


	//METHOD WHICH CAN BE CALLED BEFORE EACH TEST TO LOGIN TO THE APPLICATION
	@Test(priority = 9, groups = { "Register as New User"})
	public void registerAsNewUser()
	{   
		//Action.relaunch();
		Action.waitALittle(5000);
		Values.tcDescription = "Register as New User";
		validValue = Validations.generateRandomNumber("Numeric", 10);
		Values.tcTestData=validValue;
		PageFactory.register.enterMobileNumberAndSignup(validValue);
		PageFactory.register.clickOnNextButton();
		PageFactory.register.enterOTP(OTPValue);
		PageFactory.genericPageElements.checkIfProfileIsLoaded();
		Action.waitALittle(6000);
		Action.navigateBack();
		if( Action.elementExists(PageFactory.user_dashboard.crop_monitoring_link) & 
				Action.elementExists(PageFactory.user_dashboard.buy_inputs_link) & 
				Action.elementExists(PageFactory.user_dashboard.order_history_link))
		{ 
			Logger.log("Dashboard and its elements are present for the farmer");
			Assert.assertEquals(true, true);
		}
		else
		{ 
			Logger.log("Dashboard and its elements are not present for the farmer");
			Assert.assertEquals(true, false);
		}
	}	


	@Test(priority = 1, groups = { "Login As Existing User"})
	public void loginAsExistingUser() {
		Values.tcDescription = "Login as existing user";
		validValue = registeredMobileNumber_farmer;
		Values.tcTestData=validValue;
		PageFactory.register.loginAsExistingUser(validValue);
		PageFactory.register.clickOnNextButton();
		
		PageFactory.register.enterOTP(OTPValue);
		PageFactory.genericPageElements.checkIfDashboardIsLoaded();
	}






}

