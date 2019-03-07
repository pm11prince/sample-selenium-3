package com.seedbank.common.pageobjects;


import org.openqa.selenium.By;
import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.DataReference;
import com.seedbank.common.utils.LocatorReferences;
import com.seedbank.common.utils.Logger;

public class Register {

	public By registerMobileNumber=LocatorReferences.references.get("Register mobile_Number");
	public By popUpMessage = LocatorReferences.references.get("Register popup_InvalidMobileNumberMessage");
	public By popupOkButton = LocatorReferences.references.get("Register popup_OkButton");
	public By OTPField = LocatorReferences.references.get("Register enterOTP");
	public By signUpButton =LocatorReferences.references.get("Register signUp_Button");
	public By nextButton = LocatorReferences.references.get("Register nextButton");
	public By mobileNumber = LocatorReferences.references.get("Register mobile_Number");
	public By verify_phone_number_link=LocatorReferences.references.get("Register verify_phone_number_link");
	public By verify_phone_no_field=LocatorReferences.references.get("Register enter_phone_number");
	public By invalid_otp_message=LocatorReferences.references.get("Register invalid_otp_message");

	
	/*Data*/
	public String OTPValue =  DataReference.references.get("Register OTP");
	
	
	public void enterMobileNumberAndSignup(String mobile_number){
		Action.sendKeys(registerMobileNumber,mobile_number);
		Logger.log("Entered value in Phone Number field:"+ mobile_number);
		Action.waitForElementVisibility(signUpButton, 50);
		Action.click(signUpButton);
		
	}
	
	public void enterOTP(String otpValue) {
		Action.waitForElementVisibility(OTPField,50);
		Action.sendKeys(OTPField, otpValue);
		Action.waitALittle(4000);
		Logger.log("Entered value in OTP field:"+ otpValue);
	}
	
	public void clickOnNextButton(){  
		Action.waitForElementVisibility(nextButton, 90);
		Action.click(nextButton);
	}
	
	public String getPhoneNumber(){
		return Action.getText(mobileNumber);
	}
	
	public String getPopupMessage()	{
		return Action.getText(popUpMessage);
	}
	
	public void dismissPopupMessageBox(){
		Action.click(popupOkButton);
	}
	
	public String getPopuMessage_InvalidOTP() {
		return Action.getText(invalid_otp_message);
	}
	
	public String getPopupMessage_AlreadyRegisteredNumber() {
		return Action.getText(invalid_otp_message);
	}
	
	public void loginAsExistingUser(String mobile_number){
		Action.click(verify_phone_number_link);
		Action.waitForElementVisibility(verify_phone_no_field, 20);
		Action.sendKeys(verify_phone_no_field,mobile_number);
		Action.waitALittle(5000);
		Logger.log("Entered registered value in Phone Number field:"+ mobile_number);
	}
	
	
	
	

	
}
