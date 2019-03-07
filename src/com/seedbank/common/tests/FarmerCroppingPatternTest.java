package com.seedbank.common.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seedbank.common.pageobjects.PageFactory;
import com.seedbank.common.reporting.Values;
import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.DataReference;
import com.seedbank.common.utils.Logger;


public class FarmerCroppingPatternTest {

	public String actual, expected;
	public String surveyNo= DataReference.references.get("FarmerLand surveyNo");
	public String fieldName = DataReference.references.get("FarmerCroppingPattern fieldName");
	public String cropType = DataReference.references.get("FarmerCroppingPattern cropType");
	public String seasonCropYear = DataReference.references.get("FarmerCroppingPattern seasonCropYear");
	public String sizeInAcre = DataReference.references.get("FarmerCroppingPattern sizeInAcre");
	public String popupText_SurveyNo = DataReference.references.get("FarmerCroppingPattern popupText_SurveyNo");
	public String popupText_FieldName = DataReference.references.get("FarmerCroppingPattern popupText_FieldName");
	public String popupText_CropType = DataReference.references.get("FarmerCroppingPattern popupText_CropType");
	public String popupText_SeasonCrop = DataReference.references.get("FarmerCroppingPattern popupText_SeasonCrop");
	public String popupText_Size = DataReference.references.get("FarmerCroppingPattern popupText_Size");

	
	
	/*--------------------TEST CASE STARTS--------------------------*/
	
	@Test(priority = 23, groups = {"Validations_FarmerCroppingPattern"})
	public void navigateToFarmerCroppingPatternSection2() {
		Values.tcDescription = "Validations in Farmer Cropping Pattern";
		Values.tcTestData="";
		Action.waitALittle(5000);
		PageFactory.farmer_CroppingPattern.navigateToFarmerCroppingPattern();
	}
	
	
	@Test(priority = 24, groups = { "Validations_FarmerCroppingPattern"})
	public void checkIfSurveyNoIsMandatory() {
		Action.waitALittle(3000);
		PageFactory.farmer_CroppingPattern.clickOnSaveButton();
		Action.waitALittle(2000);
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected = popupText_SurveyNo;
		Action.waitALittle(2000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		Logger.log("The message:"+actual);
		PageFactory.farmer_CroppingPattern.selectSurveyNo(surveyNo);
		Assert.assertEquals(actual, expected);		
	}

	
	@Test(priority = 25, groups = {"Validations_FarmerCroppingPattern"})
	public void checkIfFieldNameIsMandatory() { 
		Values.tcTestData="";
		PageFactory.farmer_CroppingPattern.clickOnSaveButton();
		Action.waitALittle(2000);
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected = popupText_FieldName;
		Action.waitALittle(2000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		Logger.log("The message:"+actual);
		PageFactory.farmer_CroppingPattern.enterFieldName(fieldName);
		Action.waitALittle(3000);
		Assert.assertEquals(actual, expected);

	}
	
	@Test(priority = 26, groups = { "Validations_FarmerCroppingPattern"})
	public void checkIfCropTypeIsMandatory() {
		Values.tcTestData="";
		PageFactory.farmer_CroppingPattern.clickOnSaveButton();
		Action.waitALittle(2000);
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected = popupText_CropType;
		Action.waitALittle(2000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		Logger.log("The message:"+actual);
		PageFactory.farmer_CroppingPattern.selectCropType(cropType);
		Action.waitALittle(3000);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 27, groups = { "Validations_FarmerCroppingPattern"})
    public void checkIfSeasonCropMappingIsMandatory() {
		PageFactory.farmer_CroppingPattern.clickOnSaveButton();
		Action.waitALittle(2000);
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected = popupText_SeasonCrop;
		Action.waitALittle(2000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		Logger.log("The message:"+actual);
		PageFactory.farmer_CroppingPattern.selectSeasonCrop(seasonCropYear);
		Action.waitALittle(3000);
    	Assert.assertEquals(actual, expected);	
	}
	
	@Test(priority = 28, groups = { "Validations_FarmerCroppingPattern"})
    public void checkIfSizeIsMandatory() {
		PageFactory.farmer_CroppingPattern.clickOnSaveButton();
		Action.waitALittle(2000);
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected = popupText_Size;
		Action.waitALittle(2000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		Logger.log("The message:"+actual);
		PageFactory.farmer_CroppingPattern.enterSize(sizeInAcre);
		Action.waitALittle(3000);
		PageFactory.farmer_CroppingPattern.clickOnSaveButton();
		Action.waitALittle(5000);
		Action.navigateBack();
		PageFactory.genericPageElements.checkIfDashboardIsLoaded();
    	Assert.assertEquals(actual, expected);	
	} 
	
	/*--------------------TEST CASE ENDS--------------------------*/
	
	
	
	
	@Test(priority = 1, groups = { "Create Crop Pattern"})	
	public void navigateToFarmerCroppingPatternSection() {
		Values.tcDescription = "Entering Cropping Pattern details";
		Values.tcTestData="";
		Action.waitALittle(5000);
		if(Action.elementExists(PageFactory.user_dashboard.sliderIcon))
		{ 
			PageFactory.user_dashboard.clickOnMenu(null);	
			PageFactory.user_dashboard.clickOnFarmerDashboard();
			PageFactory.farmer_CroppingPattern.clickOnTab_CroppingPattern();
		}
		else 
			PageFactory.farmer_CroppingPattern.clickOnTab_CroppingPattern();

		PageFactory.farmer_CroppingPattern.clickOnAddAnAreaButton();
	}


	@Test(priority = 2, groups = { "Create Crop Pattern"})	
	public void selectSurveyNo()
	{
		Values.tcTestData=surveyNo;
	   boolean result = PageFactory.farmer_CroppingPattern.selectSurveyNo(surveyNo);
	   Assert.assertEquals(true, result);
	/*actual= Action.getText(Farmer_CroppingPattern.select_survey_no);
		Assert.assertEquals(actual, surveyNo);*/
	}

	@Test(priority = 3, groups = { "Create Crop Pattern"})	
	public void enterFieldName()
	{
		Values.tcTestData=fieldName;
		PageFactory.farmer_CroppingPattern.enterFieldName(fieldName);
		actual= Action.getText(PageFactory.farmer_CroppingPattern.field_name);
		Assert.assertEquals(actual, fieldName);
	}
	
	@Test(priority = 4, groups = { "Create Crop Pattern"})	
	public void selectCropType()
	{
		Values.tcTestData=cropType;
		PageFactory.farmer_CroppingPattern.selectCropType(cropType);
		//actual= Action.getText(Farmer_CroppingPattern.select_crop_type);
		//Assert.assertEquals(actual, cropType);
	}
	
	@Test(priority = 5, groups = { "Create Crop Pattern"})	
	public void selectSeasonCropYear()
	{
		Values.tcTestData=seasonCropYear;
		PageFactory.farmer_CroppingPattern.selectSeasonCrop(seasonCropYear);
		//actual= Action.getText(Farmer_CroppingPattern.select_season_crop_year);
		//Assert.assertEquals(actual, seasonCropYear);
	}
	
	@Test(priority = 6, groups = { "Create Crop Pattern"})	
	public void enterSizeInAcres()
	{
		Values.tcTestData=sizeInAcre;
		PageFactory.farmer_CroppingPattern.enterSize(sizeInAcre);
		actual= Action.getText(PageFactory.farmer_CroppingPattern.size_acre);
		Assert.assertEquals(actual, sizeInAcre);
	}
	
	@Test(priority = 7, groups = { "Create Crop Pattern"})
	public void saveCropDetails()
	{   Values.tcTestData="";
	PageFactory.farmer_CroppingPattern.clickOnSaveButton();
	}
}
