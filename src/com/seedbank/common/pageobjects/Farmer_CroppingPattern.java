package com.seedbank.common.pageobjects;

import org.openqa.selenium.By;

import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.LocatorReferences;
import com.seedbank.common.utils.Logger;

public class Farmer_CroppingPattern {
	
	public By tab_croppingPattern = LocatorReferences.references.get("FarmerCroppingPattern tab_croppingPattern");
	public By add_an_area = LocatorReferences.references.get("FarmerCroppingPattern add_an_area");
	public By select_survey_no = LocatorReferences.references.get("FarmerCroppingPattern select_survey_no");
	public By field_name = LocatorReferences.references.get("FarmerCroppingPattern field_name");
	public By select_crop_type = LocatorReferences.references.get("FarmerCroppingPattern select_crop_type");
	public By select_season_crop_year = LocatorReferences.references.get("FarmerCroppingPattern select_season_crop_year");
	public By size_acre = LocatorReferences.references.get("FarmerCroppingPattern size_acre");
	public By size_gps = LocatorReferences.references.get("FarmerCroppingPattern size_gps");
	public By save = LocatorReferences.references.get("FarmerCroppingPattern save");
	public By dropdown_list= LocatorReferences.references.get("FarmerLand dropdown_list");
	
	
	public void navigateToFarmerCroppingPattern() {
		
		if(Action.elementExists(PageFactory.user_dashboard.sliderIcon)) {
			PageFactory.user_dashboard.clickOnFarmerDashboard();
			PageFactory.farmer_CroppingPattern.clickOnTab_CroppingPattern();
			Logger.log("Navigated to Farmer Cropping Pattern successfully.");
		}
		else 
			Logger.log("Navigation to Farmer Cropping Pattern failed.");	
	}
	

	public void clickOnTab_CroppingPattern()
	{
		Action.click(tab_croppingPattern);
		Action.waitALittle(3000);
	}
	
	public void clickOnAddAnAreaButton() {
		Action.click(add_an_area);
		Action.waitALittle(3000);
	}
	
	public boolean selectSurveyNo(String surveyNumber)
	{
		Action.click(select_survey_no);
		Action.selectExactValueFromList(dropdown_list, surveyNumber);
		return Action.checkWhetherItemIsPresentInList(dropdown_list, surveyNumber);
	}
	
	public void enterFieldName(String fieldName)
	{
		Action.sendKeys(field_name, fieldName);
	}
	
	public void selectCropType(String cropType)
	{
		Action.click(select_crop_type);
		Action.selectExactValueFromList(dropdown_list, cropType);
	}
	
	public void selectSeasonCrop(String seasonCropYear){
		Action.click(select_season_crop_year);
		Action.selectExactValueFromList(dropdown_list, seasonCropYear);
	}
	
	public void enterSize(String sizeInAcre){
		Action.sendKeys(size_acre, sizeInAcre);
	}
	
	public void clickOnSaveButton()
	{
		Action.click(save);
	}
}
