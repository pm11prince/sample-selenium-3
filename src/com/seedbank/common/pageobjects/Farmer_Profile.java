package com.seedbank.common.pageobjects;


import org.openqa.selenium.By;
import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.LocatorReferences;
import com.seedbank.common.utils.Logger;

/**
 * @author Sneha Mitra
 */

public class Farmer_Profile {

	public By tab_profile=LocatorReferences.references.get("FarmerProfile tab_profile");
	public By first_name = LocatorReferences.references.get("FarmerProfile first_name");
	public By last_name = LocatorReferences.references.get("FarmerProfile last_name");
	public By house_number = LocatorReferences.references.get("FarmerProfile house_number");
	public By DOB = LocatorReferences.references.get("FarmerProfile DOB");
	public By pincode = LocatorReferences.references.get("FarmerProfile pincode");
	public By search_pincode = LocatorReferences.references.get("FarmerProfile search_pincode");
	public By state = LocatorReferences.references.get("FarmerProfile pincode");
	public By district = LocatorReferences.references.get("FarmerProfile district");
	public By sub_district = LocatorReferences.references.get("FarmerProfile sub_district");
	public By village = LocatorReferences.references.get("FarmerProfile village");
	public By education = LocatorReferences.references.get("FarmerProfile education");
	public By father_name = LocatorReferences.references.get("FarmerProfile father_name");
	public By spouse_name = LocatorReferences.references.get("FarmerProfile spouse_name");
	public By aadhar_number = LocatorReferences.references.get("FarmerProfile aadhar_number");
	public By pan_number = LocatorReferences.references.get("FarmerProfile pan_number");
	public By anniversary = LocatorReferences.references.get("FarmerProfile anniversary");
	public By save_button = LocatorReferences.references.get("FarmerProfile save_button");
	public By checkbox_list = LocatorReferences.references.get("FarmerProfile checkbox_list");
	
	
	public void navigateToFarmerProfile() {
		
		// Add  webdriver wait conditions for the dashboard if time taken is more for it to load
		if(Action.elementExists(PageFactory.user_dashboard.sliderIcon)) {
			PageFactory.user_dashboard.clickOnFarmerDashboard();
			PageFactory.farmer_profile.clickOnTab_Profile();
			Logger.log("Navigated to Farmer Profile successfully.");
		}
		else 
			Logger.log("Navigation to Farmer Profile failed.");	
	}
	
	public  void clickOnTab_Profile()
	{
		Action.waitForElementVisibility(tab_profile,50);
		Action.click(tab_profile);
	}

	public  void enterFirstName(String firstName)
	{

		Action.sendKeys(first_name, firstName);
	}

	public  void enterLastName(String lastName)
	{
		Action.sendKeys(last_name, lastName);
	}

	public  void enterHouseNumber(String houseNumber){
		Action.sendKeys(house_number, houseNumber);
	}

	public  void enterDateOfBirth(String dob){
		Action.sendKeys(DOB, dob);
	}

	public  void enterPinCode(String pincodeOfLocation){
		Action.sendKeys(pincode, pincodeOfLocation);
		Action.click(search_pincode);
	}

	public  void selectState(String nameOfState)
	{  
		Action.sendKeys(state, nameOfState);
	}

	public  void selectDistrict(String nameOfDistrict)
	{
		Action.sendKeys(district, nameOfDistrict);	
	}

	public  void selectSubDistrict(String nameOfSubDistrict)
	{
		Action.sendKeys(sub_district, nameOfSubDistrict);
	}

	public void selectVillage(String nameOfVillage){
		Action.scrollTillElement("Select Village*");
		Action.click(village);
		Action.selectValueFromListByIndex(checkbox_list,Integer.parseInt(nameOfVillage));
		Action.waitALittle(5000);
	}

	public  void selectEducation(String educationalQualification){
		Action.click(education);
		Action.selectExactValueFromList(checkbox_list, educationalQualification);
		Action.waitALittle(5000);
	}

	public void enterFatherName(String fatherName){
		Action.sendKeys(father_name, fatherName);
	}

	public void enterSpouseName(String spouseName)
	{
		Action.sendKeys(spouse_name, spouseName);
	}

	public void enterAadharNumber(String aadharNumber)
	{
		Action.sendKeys(aadhar_number, aadharNumber);
	}

	public void enterPanNumber(String panNumber)
	{
		Action.sendKeys(pan_number, panNumber);
	}
	
	public void enterAnniversaryDate(String dateOfAnniversary){
	
		Action.sendKeys(anniversary, dateOfAnniversary);
	}

	public void clickOnSaveButton() {
		Action.click(save_button);
	}

	public String getFieldValue(By loc) {

		return Action.getText(loc);
	}

	public void clickOnTab_Land() {
		
	}

	

}

