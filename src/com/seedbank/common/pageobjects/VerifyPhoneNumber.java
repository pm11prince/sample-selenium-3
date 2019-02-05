package com.seedbank.common.pageobjects;

import org.openqa.selenium.By;
import com.seedbank.common.utils.Action;

public class VerifyPhoneNumber {
	
	public void enterPhoneNumber(String ph, By loc)
	{
		Action.sendKeys(loc, ph);
	}
	
	public void clickOnNext(By loc)
	{
		Action.click(loc);
	}
	
	public void enterOTP(String otp, By loc)
	{
		Action.sendKeys(loc, otp);
	}
}
