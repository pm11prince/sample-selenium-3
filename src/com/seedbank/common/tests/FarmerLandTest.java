package com.seedbank.common.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seedbank.common.pageobjects.PageFactory;
import com.seedbank.common.reporting.Values;
import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.DataReference;
import com.seedbank.common.utils.Logger;

public class FarmerLandTest {

	public String actual, expected;
	public String surveyNo= DataReference.references.get("FarmerLand surveyNo");
	public String landName = DataReference.references.get("FarmerLand landName");
	public String soilType = DataReference.references.get("FarmerLand soilType");
	public String sourceOfIrrigation = DataReference.references.get("FarmerLand sourceOfIrrigation");
	public String totalLandOwn = DataReference.references.get("FarmerLand totalLandOwn");
	public String totalLandLeased = DataReference.references.get("FarmerLand totalLandLeased");
	public String irrigatedLand = DataReference.references.get("FarmerLand irrigatedLand");
	public String popupText_SurveyNo = DataReference.references.get("FarmerLand popupText_SurveyNo");
	public String popupText_TotalLandHoldingArea = DataReference.references.get("FarmerLand popupText_TotalLandHoldingArea");
	public String popupText_IrrigatedLand = DataReference.references.get("FarmerLand popupText_IrrigatedLand");
	
	
	/*--------------------TEST CASE STARTS--------------------------*/
	
	
	@Test(priority = 19, groups = {"Validations_FarmerLand"})
	public void navigateToFarmerLandSection1() {
		Values.tcDescription = "Validations in Farmer Land";
		Values.tcTestData="";
		Action.waitALittle(5000);
		PageFactory.farmer_land.navigateToFarmerLand();
	}
	
	
	@Test(priority = 20, groups = { "Validations_FarmerLand"})
	public void checkWhetherSurveyNoIsMandatory() {
		Action.waitALittle(3000);
		PageFactory.farmer_land.clickOnSaveButton();
		Action.waitALittle(2000);
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected = popupText_SurveyNo;
		Action.waitALittle(2000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		Logger.log("The message:"+actual);
		PageFactory.farmer_land.enterSurveyNumber(surveyNo);
		Assert.assertEquals(actual, expected);		
	}
	
	@Test(priority = 21, groups = {"Validations_FarmerLand"})
    public void checkWhetherTotalLandHoldingAreaIsMandatory() {
		Values.tcTestData="";
		Action.waitALittle(3000);
		PageFactory.farmer_land.clickOnSaveButton();
		Action.waitALittle(2000);
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected = popupText_TotalLandHoldingArea;
		Action.waitALittle(3000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		Logger.log("The message:"+actual);
		PageFactory.farmer_land.enterTotalLandOwn(totalLandOwn);
		PageFactory.farmer_land.enterTotalLandLeased(totalLandLeased);
		PageFactory.farmer_land.clickOnSaveButton();
		Action.waitALittle(4000);
		Assert.assertEquals(actual, expected);
	}
	
	
	@Test(priority = 22, groups = { "Validations_FarmerLand"})
    public void checkWhetherIrrigatedLandIsGreaterThanTotalLandHoldingArea() {	
		PageFactory.farmer_land.clickOnTab_Land();
        PageFactory.farmer_land.selectCreatedSurveyNo("");
        Action.waitALittle(3000);
		int invalidValue =  Integer.parseInt(totalLandOwn)+Integer.parseInt(totalLandLeased)+1;
		PageFactory.farmer_land.enterIrrigatedLand(Integer.toString(invalidValue));
		PageFactory.farmer_land.clickOnSaveButton();
		Action.waitALittle(2000);
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		Action.waitALittle(2000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		
		Logger.log("The message:"+actual);
		expected = popupText_IrrigatedLand;
		int validValue = Integer.parseInt(totalLandOwn)+Integer.parseInt(totalLandLeased)-1;
		PageFactory.farmer_land.enterIrrigatedLand(Integer.toString(validValue));
		PageFactory.farmer_land.clickOnSaveButton();
		Action.waitALittle(3000);
		Assert.assertEquals(actual, expected);
	}
	
	/*--------------------TEST CASE ENDS--------------------------*/
	
	
	@Test(priority = 1, groups = { "Create Farmer Land"})	
	
	public void navigateToFarmerLandSection() {
		Values.tcDescription = "Entering Farmer Land Details";
		Values.tcTestData="";
		Action.waitALittle(8000);
		if(Action.elementExists(PageFactory.user_dashboard.sliderIcon))
		{ 
			PageFactory.user_dashboard.clickOnSlider();
			PageFactory.user_dashboard.clickOnMenu(null);	
			PageFactory.user_dashboard.clickOnFarmerDashboard();
			PageFactory.farmer_land.clickOnTab_Land();;
		}
		else 
			PageFactory.farmer_land.clickOnTab_Land();
		
		PageFactory.farmer_land.clickOnAddALandButton();
	}
	
	@Test(priority = 2, groups = { "Create Farmer Land"})	
	public void enterSurveyNumber()
	{
		Values.tcTestData=surveyNo;
		PageFactory.farmer_land.enterSurveyNumber(surveyNo);
		actual= Action.getText(PageFactory.farmer_land.survey_no);
		Assert.assertEquals(actual, surveyNo);
	}
	
	@Test(priority = 3, groups = { "Create Farmer Land"})	
	public void enterLandName()
	{
		Values.tcTestData=landName;
		PageFactory.farmer_land.enterLandName(landName);
		actual= Action.getText(PageFactory.farmer_land.land_name);
		Assert.assertEquals(actual, landName);
	}
	
	@Test(priority = 4, groups = { "Create Farmer Land"})	
	public void selectSoilType(){
		Values.tcTestData=soilType;
		PageFactory.farmer_land.selectSoilType(soilType);
		//actual= Action.getText(Farmer_Land.soil_type);
		//Assert.assertEquals(actual, soilType);
	}
	
	@Test(priority = 5, groups = { "Create Farmer Land"})
	public void selectSourceOfIrrigation()
	{
		Values.tcTestData=sourceOfIrrigation;
		PageFactory.farmer_land.selectSourceOfIrrigation(sourceOfIrrigation);
		//actual= Action.getText(Farmer_Land.source_of_irrigation);
		//System.out.println(actual);
		//Assert.assertEquals(actual, sourceOfIrrigation);
	}
	
	@Test(priority = 6, groups = { "Create Farmer Land"})
	public void enterTotalLandOwn()
	{
		Values.tcTestData=totalLandOwn;
		PageFactory.farmer_land.enterTotalLandOwn(totalLandOwn);
		actual= Action.getText(PageFactory.farmer_land.total_land_own);
		Assert.assertEquals(actual, totalLandOwn);
	}
	
	@Test(priority = 7, groups = { "Create Farmer Land"})
	public void enterTotalLeased()
	{
		Values.tcTestData=totalLandLeased;
		PageFactory.farmer_land.enterTotalLandLeased(totalLandLeased);
		actual= Action.getText(PageFactory.farmer_land.total_land_leased);
		Assert.assertEquals(actual, totalLandLeased);
	}
	
	@Test(priority = 8, groups = { "Create Farmer Land"})
	public void checkTotalLandHoldingArea()
	{
		//Values.tcTestData=totalLandLeased;
		int value= PageFactory.farmer_land.calculateTotalLandHoldingArea(totalLandOwn, totalLandLeased);
		expected = Integer.toString(value);
		actual= Action.getText(PageFactory.farmer_land.total_land_holding_area);
		System.out.println(actual);
		Values.tcTestData=actual;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 9, groups = { "Create Farmer Land"})
	public void enterIrrigatedLand()
	{
		Values.tcTestData=irrigatedLand;
		PageFactory.farmer_land.enterIrrigatedLand(irrigatedLand);
		actual= Action.getText(PageFactory.farmer_land.irrigated_land);
		Assert.assertEquals(actual, irrigatedLand);
	}
	
	@Test(priority = 10, groups = { "Create Farmer Land"})
	public void saveLandDetails()
	{
		Values.tcTestData="";
		PageFactory.farmer_land.clickOnSaveButton();
		Action.waitALittle(2000);
	}
	
	
}
