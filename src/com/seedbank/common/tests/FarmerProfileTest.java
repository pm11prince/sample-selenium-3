package com.seedbank.common.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seedbank.common.pageobjects.PageFactory;
import com.seedbank.common.reporting.Values;
import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.DataReference;
import com.seedbank.common.utils.Logger;

/**
 * <copyright company="ITC INFOTECH"> Reproduction or
 * transmission in whole or in part, in any form or by any means, electronic,
 * mechanical or otherwise, is prohibited without the prior written permission
 * of the copyright owner. </copyright>
 * 
 * @author Sneha Mitra
 */

public class FarmerProfileTest {

	String actual,expected;
	
	public String firstName= DataReference.references.get("FarmerProfile firstName");
	public String lastName = DataReference.references.get("FarmerProfile lastName");
	public String houseNumber = DataReference.references.get("FarmerProfile houseNumber");
	public String dob = DataReference.references.get("FarmerProfile dob");
	public String pincodeOfLocation = DataReference.references.get("FarmerProfile pincodeOfLocation");
	public String nameOfState = DataReference.references.get("FarmerProfile nameOfState");
	public String nameOfDistrict = DataReference.references.get("FarmerProfile nameOfDistrict");
	public String nameOfSubDistrict = DataReference.references.get("FarmerProfile nameOfSubDistrict");
	public String nameOfVillage = DataReference.references.get("FarmerProfile nameOfVillage");
	public String educationalQualification = DataReference.references.get("FarmerProfile educationalQualification");
	public String fatherName = DataReference.references.get("FarmerProfile fatherName");
	public String spouseName = DataReference.references.get("FarmerProfile spouseName");
	public String aadharNumber = DataReference.references.get("FarmerProfile aadharNumber");
	public String panNumber = DataReference.references.get("FarmerProfile panNumber");
	public String dateOfAnniversary = DataReference.references.get("FarmerProfile dateOfAnniversary");
	public String popupText_Village = DataReference.references.get("FarmerProfile popupText_Village");
	public String popupText_InvalidPanNumber = DataReference.references.get("FarmerProfile popupText_InvalidPanNumber");
	public String invalidPanNumber = DataReference.references.get("FarmerProfile invalidPanNumber");
	public String popupText_InvalidAadharNumber = DataReference.references.get("FarmerProfile popupText_InvalidAadharNumber");
	public String invalidAadharNumber = DataReference.references.get("FarmerProfile invalidAadharNumber");
	
	
	/*--------------------TEST CASE STARTS--------------------------*/
	
		@Test(priority = 13, groups = {"Validations_FarmerProfile"})
		public void navigateToFarmerProfileSection1() {
			/*Values.tcDescription = "Validations in Farmer Profile";
			Values.tcTestData="";
			Action.waitALittle(5000);
			PageFactory.farmer_profile.navigateToFarmerProfile();*/
		}
		
		@Test(priority = 14, groups = { "Validations_FarmerProfile"})
		public void checkMandatoryFieldsWhileCreatingFarmerProfile() {
			/*Action.waitALittle(3000);
			Action.scrollTillElement("SAVE");
			//Action.waitALittle(2000);
			PageFactory.farmer_profile.clickOnSaveButton();
			actual =  PageFactory.genericPageElements.getTextFromPopup();
			expected =  popupText_Village;
			Action.waitALittle(3000);
			PageFactory.genericPageElements.clickOnPopupOKButton();
			Logger.log(actual);
			Assert.assertEquals(actual, expected);	*/
		}		
		
		@Test(priority = 15, groups = { "Validations_FarmerProfile"})
		public void enterMandatoryFieldsAndSaveProfile() {
			/*Values.tcTestData=pincodeOfLocation;	
			Action.waitALittle(4000);
			Action.navigateBack();
			Action.waitForElementVisibility(PageFactory.user_dashboard.sliderIcon,50);
			PageFactory.user_dashboard.clickOnFarmerDashboard();
			Action.waitALittle(6000);
			PageFactory.farmer_profile.enterPinCode(pincodeOfLocation);
			PageFactory.farmer_profile.selectVillage(nameOfVillage);
			Action.waitALittle(4000);
			PageFactory.farmer_profile.clickOnSaveButton();
			PageFactory.genericPageElements.checkIfDashboardIsLoaded();
			Action.waitALittle(2000);*/
		}
		
		@Test(priority = 16, groups = {"Validations_FarmerProfile"})
		public void validatePANNumber() {
		/*	Values.tcTestData= invalidPanNumber;

			Action.waitForElementVisibility(PageFactory.user_dashboard.sliderIcon,50);
			PageFactory.user_dashboard.clickOnSlider();
			PageFactory.user_dashboard.clickOnMenu("Home");	
			PageFactory.user_dashboard.clickOnFarmerDashboard();
			
			Action.scrollTillElement("SAVE");
			PageFactory.farmer_profile.enterPanNumber(invalidPanNumber);
			actual =  PageFactory.genericPageElements.getTextFromPopup();
			expected = popupText_InvalidPanNumber;
			PageFactory.genericPageElements.clickOnPopupOKButton();
			Logger.log(actual);
			System.out.println(actual);
			PageFactory.farmer_profile.enterPanNumber(panNumber);
			Action.waitALittle(5000);
			PageFactory.farmer_profile.clickOnSaveButton();
			Assert.assertEquals(actual, expected);*/		
		}
		
		@Test(priority = 17, groups = {"Validati6ons_FarmerProfile"})
		public void validateAadharNumber() {
			
		/*	Values.tcTestData= invalidAadharNumber;
			Action.waitForElementVisibility(PageFactory.user_dashboard.sliderIcon,50);
			PageFactory.user_dashboard.clickOnFarmerDashboard();
			Action.scrollTillElement("SAVE");
			PageFactory.farmer_profile.enterAadharNumber(invalidAadharNumber);
			PageFactory.farmer_profile.clickOnSaveButton();
			actual =  PageFactory.genericPageElements.getTextFromPopup();
			expected = popupText_InvalidAadharNumber;
			PageFactory.genericPageElements.clickOnPopupOKButton();
			Logger.log(actual);
			PageFactory.farmer_profile.enterAadharNumber(aadharNumber);
			Action.waitALittle(4000);
			PageFactory.farmer_profile.clickOnSaveButton();
			Action.waitALittle(3000);
			Assert.assertEquals(actual, expected);*/
		}
		
		
	/*--------------------TEST CASE ENDS--------------------------*/
		
		
		
		
		/*
		Application flow for login as new user and  crop monitoring
		 */
	@Test(priority = 1, groups = { "Create Farmer Profile"})// whether user is old or new , this will handle both	
	public void navigateToFarmerProfileSection() {
		Values.tcDescription = "Entering Farmer Profile Details";
		Values.tcTestData="";
		Action.waitALittle(4000);
		if(Action.elementExists(PageFactory.user_dashboard.sliderIcon))
		{ 
			PageFactory.user_dashboard.clickOnSlider();
			PageFactory.user_dashboard.clickOnMenu("Home");	
			PageFactory.user_dashboard.clickOnFarmerDashboard();
		}
		else 
			PageFactory.farmer_profile.clickOnTab_Profile();
	}	
	
	@Test(priority = 2, groups = { "Create Farmer Profile"})
	public void enterFirstName() {
		Action.waitALittle(3000);
		Values.tcTestData=firstName;
		PageFactory.farmer_profile.enterFirstName(firstName);
		actual= Action.getText(PageFactory.farmer_profile.first_name);
		Assert.assertEquals(actual,firstName);
	}

	@Test(priority = 3, groups = { "Create Farmer Profile"})
	public void enterLastName() {
		Values.tcTestData=lastName;
		PageFactory.farmer_profile.enterLastName(lastName);
		actual= Action.getText(PageFactory.farmer_profile.last_name);
		Assert.assertEquals(actual, lastName);
	}

	@Test(priority = 4, groups = { "Create Farmer Profile"})
	public void enterHouseNumber() {
		Values.tcTestData=houseNumber;
		PageFactory.farmer_profile.enterHouseNumber(houseNumber);
		actual= Action.getText(PageFactory.farmer_profile.house_number);
		Assert.assertEquals(actual, houseNumber);
	}	

	@Test(priority = 5, groups = { "Create Farmer Profile"})
	public void enterDateOfBirth() {
		Values.tcTestData=dob;
		PageFactory.farmer_profile.enterDateOfBirth(dob);
		actual= Action.getText(PageFactory.farmer_profile.DOB);
		Assert.assertEquals(actual, dob);
	}
	
	@Test(priority = 6, groups = { "Create Farmer Profile"})
	public void enterPincode() {
		Values.tcTestData=pincodeOfLocation;
		PageFactory.farmer_profile.enterPinCode(pincodeOfLocation);
		actual= Action.getText(PageFactory.farmer_profile.pincode);
		Assert.assertEquals(actual, pincodeOfLocation);
	}

	@Test(priority = 7, groups = { "Create Farmer Profile"})
	public void enterVillage() {
		Values.tcTestData= nameOfVillage;
		PageFactory.farmer_profile.selectVillage(nameOfVillage);
		Action.waitALittle(4000);
		actual= Action.getText(PageFactory.farmer_profile.village);
		Assert.assertEquals(actual, nameOfVillage);
	}

	@Test(priority = 8, groups = { "Create Farmer Profile"})
	public void selectEducation() {
		Values.tcTestData= educationalQualification;
		PageFactory.farmer_profile.selectEducation(educationalQualification);
		actual= PageFactory.farmer_profile.getFieldValue(PageFactory.farmer_profile.education);
		Assert.assertEquals(actual, educationalQualification);
	}
	
	@Test(priority = 9, groups = { "Create Farmer Profile"})
	public void enterFatherName() {
		Values.tcTestData= fatherName;
		PageFactory.farmer_profile.enterFatherName(fatherName);
		actual= PageFactory.farmer_profile.getFieldValue(PageFactory.farmer_profile.father_name);
		Assert.assertEquals(actual, fatherName);
	}
	
	@Test(priority = 10, groups = { "Create Farmer Profile"})
	public void enterSpouseName() {
		Values.tcTestData= spouseName;
		PageFactory.farmer_profile.enterSpouseName(spouseName);
		actual= PageFactory.farmer_profile.getFieldValue(PageFactory.farmer_profile.spouse_name);
		Assert.assertEquals(actual, spouseName);
	}
	
	/*@Test(priority = 11, groups = { "Create Farmer Profile"})
	public void enterAadharNumber() {
		Values.tcTestData= aadharNumber;
		Farmer_Profile.enterAadharNumber(aadharNumber);
		actual= Farmer_Profile.getFieldValue(Farmer_Profile.aadhar_number);
		Assert.assertEquals(actual, aadharNumber);
	}*/
	
	@Test(priority = 12, groups = { "Create Farmer Profile"})
	public void enterPanNumber() {
		Values.tcTestData= panNumber;
		PageFactory.farmer_profile.enterPanNumber(panNumber);
		actual= PageFactory.farmer_profile.getFieldValue(PageFactory.farmer_profile.pan_number);
		Assert.assertEquals(actual, panNumber);
	}
	
	@Test(priority = 13, groups = { "Create Farmer Profile"})
	public void enterDateOfAnniversary() {
		Values.tcTestData= dateOfAnniversary;
		PageFactory.farmer_profile.enterAnniversaryDate(dateOfAnniversary);
		actual= PageFactory.farmer_profile.getFieldValue(PageFactory.farmer_profile.anniversary);
		Assert.assertEquals(actual, dateOfAnniversary);
	}

	@Test(priority = 14, groups = { "Create Farmer Profile"})
	public void clickSaveButton() {
		Values.tcTestData="";
		PageFactory.farmer_profile.clickOnSaveButton();
		PageFactory.genericPageElements.checkIfDashboardIsLoaded();
		Action.waitALittle(6000);
	}
	

	



}
