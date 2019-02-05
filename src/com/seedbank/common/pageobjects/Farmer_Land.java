package com.seedbank.common.pageobjects;

import org.openqa.selenium.By;

import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.LocatorReferences;
import com.seedbank.common.utils.Logger;

public class Farmer_Land {
	
	
	public By tab_land=LocatorReferences.references.get("FarmerLand tab_land");
	public By add_a_land=LocatorReferences.references.get("FarmerLand add_a_land");
	public By survey_no=LocatorReferences.references.get("FarmerLand survey_no");
	public By land_name=LocatorReferences.references.get("FarmerLand land_name");
	public By soil_type=LocatorReferences.references.get("FarmerLand soil_type");
	public By source_of_irrigation=LocatorReferences.references.get("FarmerLand source_of_irrigation");
	public By total_land_own=LocatorReferences.references.get("FarmerLand total_land_own");
	public By total_land_leased=LocatorReferences.references.get("FarmerLand total_land_leased");
	public By total_land_holding_area=LocatorReferences.references.get("FarmerLand total_land_holding_area");
	public By irrigated_land=LocatorReferences.references.get("FarmerLand irrigated_land");
	public By save=LocatorReferences.references.get("FarmerLand save");
	public By dropdown_list= LocatorReferences.references.get("FarmerLand dropdown_list");
	public By edit_land= LocatorReferences.references.get("FarmerLand edit_land");
	
	public void navigateToFarmerLand() {

		// Add  webdriver wait conditions for the dashboard if time taken is more for it to load
		if(Action.elementExists(PageFactory.user_dashboard.sliderIcon)) {
			PageFactory.user_dashboard.clickOnFarmerDashboard();
			PageFactory.farmer_land.clickOnTab_Land();
			Logger.log("Navigated to Farmer Land successfully.");
		}
		else 
			Logger.log("Navigation to Farmer Land failed.");	
	}

	public void clickOnTab_Land()
	{
		Action.waitALittle(6000);
		System.out.println(Action.elementExists(tab_land));
		Action.click(tab_land);
		Action.waitALittle(5000);
	}
	
	public void clickOnAddALandButton() {
		System.out.println(Action.elementExists(add_a_land));
		Action.click(add_a_land);
		Action.waitALittle(3000);
	}

	public void enterSurveyNumber(String surveyNo)
	{
		Action.sendKeys(survey_no, surveyNo);
		Action.waitALittle(2000);
	}
	
	public void enterLandName(String landName)
	{
		Action.sendKeys(land_name, landName);
		Action.waitALittle(2000);
	}
	public void selectSoilType(String soilType)
	{
		Action.click(soil_type);
		Action.waitALittle(3000);
		Action.selectExactValueFromList(dropdown_list, soilType);
		Action.waitALittle(2000);
	}
	public void selectSourceOfIrrigation(String sourceOfIrrigation)
	{
		Action.click(source_of_irrigation);
		Action.waitALittle(3000);
		Action.selectExactValueFromList(dropdown_list, sourceOfIrrigation);
		Action.waitALittle(2000);
	}
	
	public void enterTotalLandOwn(String totalLandOwn)
	{
		Action.sendKeys(total_land_own, totalLandOwn);
		Action.waitALittle(2000);
	}
	
	public void enterTotalLandLeased(String totalLandLeased)
	{
		Action.sendKeys(total_land_leased, totalLandLeased);
		Action.waitALittle(2000);
	}
	
	public int calculateTotalLandHoldingArea(String totalLandOwn,String totalLandLeased)
	{
		int total = Integer.parseInt(totalLandOwn)+Integer.parseInt(totalLandLeased);
		return total;
	}
	
	public void enterIrrigatedLand(String irrigatedLand)
	{
		Action.sendKeys(irrigated_land, irrigatedLand);
		Action.waitALittle(2000);
	}
	
	public void clickOnSaveButton()
	{
		Action.click(save);
		Action.waitALittle(2000);
	}
	
	public void selectCreatedSurveyNo(String surveyNumber) {
		Action.click(edit_land);
		
	}
}
