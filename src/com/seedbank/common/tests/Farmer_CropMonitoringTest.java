package com.seedbank.common.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seedbank.common.pageobjects.PageFactory;
import com.seedbank.common.reporting.Values;
import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.DataReference;
import com.seedbank.common.utils.Logger;


public class Farmer_CropMonitoringTest {

	public String actual, expected;
	public String surveyNo= DataReference.references.get("FarmerLand surveyNo");
	public String fieldName = DataReference.references.get("FarmerCroppingPattern fieldName");
	public String seasonCropYear = DataReference.references.get("FarmerCroppingPattern seasonCropYear");
	public String dateOfPloughing = DataReference.references.get("PreSowing dateOfPloughing");
	public String cultivator = DataReference.references.get("PreSowing cultivator");
	public String dateOfCultivation = DataReference.references.get("PreSowing dateOfCultivation");
	public String dateOfLevelling = DataReference.references.get("PreSowing dateOfLevelling");
	public String preSowing_cost = DataReference.references.get("PreSowing preSowing_cost");
	
	public String fertilizer = DataReference.references.get("Sowing fertilizer");
	public String qty = DataReference.references.get("Sowing qty");
	public String cropVariety = DataReference.references.get("Sowing cropVariety");
	public String seedType = DataReference.references.get("Sowing seedType");
	public String seedSource = DataReference.references.get("Sowing seedSource");
	public String dateOfSowing = DataReference.references.get("Sowing dateOfSowing");
	public String seedQuantity = DataReference.references.get("Sowing seedQuantity");
	public String methodOfSowing = DataReference.references.get("Sowing methodOfSowing");
	public String rowToRow = DataReference.references.get("Sowing rowToRow");
	public String plantToPlant = DataReference.references.get("Sowing plantToPlant");
	public String sowingCost = DataReference.references.get("Sowing sowingCost");
	
	public String dateOfHarvesting = DataReference.references.get("Harvesting dateOfHarvesting");
	public String yieldQuantity = DataReference.references.get("Harvesting yieldQuantity");
	public String dateOfThreshing = DataReference.references.get("Harvesting dateOfThreshing");
	public String costOfHarvesting = DataReference.references.get("Harvesting costOfHarvesting");
	
	//PRESOWING
	public String popupText_Presowing_Cost  = DataReference.references.get("PreSowing popupText_Presowing_Cost");
	public String popupText_Presowing_DeepPloughing  = DataReference.references.get("PreSowing popupText_Presowing_DeepPloughing");
	public String popupText_Presowing_CultivationDate  = DataReference.references.get("PreSowing popupText_Presowing_CultivationDate");
	public String popupText_Presowing_LevellingDate  = DataReference.references.get("PreSowing popupText_Presowing_LevellingDate");
	public String invalid_CultivationDate  = DataReference.references.get("PreSowing invalid_CultivationDate");
	public String invalid_LevellingDate  = DataReference.references.get("PreSowing invalid_LevellingDate");
	
	//SOWING
	public String popupText_DateOfSowing  = DataReference.references.get("Sowing popupText_DateOfSowing");
	public String popupText_SeedQuantity  = DataReference.references.get("Sowing popupText_SeedQuantity");
	public String popupText_MethodOfSowing  = DataReference.references.get("Sowing popupText_MethodOfSowing");
	public String popupText_SeedVariety  = DataReference.references.get("Sowing popupText_SeedVariety");
	public String popupText_Sowing_Cost  = DataReference.references.get("Sowing popupText_Sowing_Cost");
	public String invalid_DateOfSowing  = DataReference.references.get("Sowing invalid_DateOfSowing");

	
	
	/** Validations for Pre-Sowing stage*/
	@Test(priority = 0, groups = { "Validations_CropMonitoring"})//new
	public void navigateToCropMonitoringPageFromDashboard1() {
		Action.waitALittle(20000);
		Values.tcTestData="";
		PageFactory.cropMonitoring_AddCrops.navigateToAddCropPage();
		Action.waitALittle(9000);
		PageFactory.cropMonitoring_AddCrops.clickOnAddedCrop();// if the crop is already added
	}
	
	@Test(priority = 1, groups = { "Validations_CropMonitoring"})
	public void addCropToMonitor() {
		Action.waitALittle(5000);
		Values.tcTestData= surveyNo+","+fieldName;
		PageFactory.cropMonitoring_AddCrops.clickOnAddCrops();
		PageFactory.cropMonitoring_AddCrops.selectSurveyNumber(surveyNo);
		PageFactory.cropMonitoring_AddCrops.selectFieldName(fieldName);
		expected = seasonCropYear;
		actual = PageFactory.cropMonitoring_AddCrops.checkSeasonCropMapping();
		PageFactory.cropMonitoring_AddCrops.clickOnDoneButton();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 2, groups = { "Validations_CropMonitoring"})
	public void addStage_Presowing() {
		Values.tcTestData=PageFactory.cropMonitoring_CropCalendar.preSowing;
		PageFactory.cropMonitoring_CropCalendar.selectStage(PageFactory.cropMonitoring_CropCalendar.preSowing);	
	}
	
	@Test(priority = 3, groups = { "Validations_CropMonitoring"})
	public void checkWhetherCostIsMandatory() {
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnSubmitStage();
		Values.tcTestData=preSowing_cost;
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected =  popupText_Presowing_Cost;
		Action.waitALittle(3000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		Logger.log("The message is ::"+actual);
		PageFactory.cropMonitoring_Stage_PreSowing.enterCost(preSowing_cost);
		Action.waitALittle(2000);
		Assert.assertEquals(actual, expected);		
	}
	
	@Test(priority = 4, groups = { "Validations_CropMonitoring"})
	public void checkWhetherDeepPloughingDetailsAreMandatory() {
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnSubmitStage();
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected =  popupText_Presowing_DeepPloughing;
		Action.waitALittle(3000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		Logger.log("The message is ::"+actual);
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnDeepPloughingSwitch();
		Action.waitALittle(3000);
		PageFactory.cropMonitoring_Stage_PreSowing.enterDateOfPloughing(dateOfPloughing);
		Values.tcTestData=dateOfPloughing;
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnSaveStage();			
	}
	
	@Test(priority = 5, groups = { "Validations_CropMonitoring"}) // include validation of the dates as log.
	public void checkDates_CultivationDateAndPloughingDate() {
		PageFactory.cropMonitoring_CropCalendar.clickOnCreatedStage(PageFactory.cropMonitoring_CropCalendar.preSowing);
		PageFactory.cropMonitoring_Stage_PreSowing.selectCultivator(cultivator);
		Action.waitALittle(3000);
		Values.tcTestData=invalid_CultivationDate;
		PageFactory.cropMonitoring_Stage_PreSowing.enterDateOfCultivation(invalid_CultivationDate);
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnSaveStage();	
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected =  popupText_Presowing_CultivationDate;
		Logger.log("The message for cultivation date is:"+actual);
		Action.waitALittle(3000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		PageFactory.cropMonitoring_Stage_PreSowing.enterDateOfCultivation(dateOfCultivation);
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnSaveStage();	
		Action.waitALittle(7000);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 6, groups = { "Validations_CropMonitoring"})
	public void checkDates_LevellingDateAndCultivationDate() {
		PageFactory.cropMonitoring_CropCalendar.clickOnCreatedStage(PageFactory.cropMonitoring_CropCalendar.preSowing);
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnLevellingSwitch();
		Values.tcTestData = invalid_LevellingDate;
		PageFactory.cropMonitoring_Stage_PreSowing.enterDateOfLevelling(invalid_LevellingDate);
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnSaveStage();
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected =  popupText_Presowing_LevellingDate;
		Logger.log("The message for levelling date is:"+actual);
		Action.waitALittle(3000);
		PageFactory.genericPageElements.clickOnPopupOKButton();
		PageFactory.cropMonitoring_Stage_PreSowing.enterDateOfLevelling(dateOfLevelling);
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnSaveStage();
		Assert.assertEquals(actual, expected);	
	}
	
	@Test(priority = 7, groups = { "Validations_CropMonitoring"})
	public void checkIfDuplicatePresowingStageIsCreated() {
		Values.tcTestData=PageFactory.cropMonitoring_CropCalendar.preSowing;
		PageFactory.cropMonitoring_CropCalendar.selectStage(PageFactory.cropMonitoring_CropCalendar.preSowing);
		actual= Action.getText(PageFactory.cropMonitoring_CropCalendar.duplicate_presowing_message);
		expected =  DataReference.references.get("CropCalender duplicate_presowing_message");
		Logger.log(actual);
		Action.waitALittle(4000);
		Assert.assertEquals(actual, expected);	
	}
	
	
	/** Validations for Sowing stage*
	 * ------------------------------------------------------------------------------------*/
	
	/*@Test(priority = 2, groups = { "Validations_CropMonitoring"})
	public void addStage_Sowing() {
		Values.tcTestData=PageFactory.cropMonitoring_CropCalendar.sowing;
		PageFactory.cropMonitoring_CropCalendar.selectStage(PageFactory.cropMonitoring_CropCalendar.sowing);	
	}
	
	@Test(priority = 2, groups = { "Validations_CropMonitoring"})
	public void checkIfDateOfSowingIsMandatory() {
		PageFactory.cropMonitoring_Stage_Sowing.clickOnSubmitStage();
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected =  popupText_DateOfSowing;
		PageFactory.genericPageElements.clickOnPopupOKButton();
		PageFactory.cropMonitoring_Stage_Sowing.enterDateOfSowing(dateOfSowing);
		Logger.log("The message is :"+actual);
		Assert.assertEquals(actual, expected);	
	}
	
	
	@Test(priority = 3, groups = { "Validations_CropMonitoring"})
	public void checkIfSeedQuantityIsMandatory() {
		PageFactory.cropMonitoring_Stage_Sowing.clickOnSubmitStage();
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected =  popupText_SeedQuantity;
		PageFactory.genericPageElements.clickOnPopupOKButton();
		PageFactory.cropMonitoring_Stage_Sowing.enterSeedQuantity(seedQuantity);
		Logger.log("The message is :"+actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 3, groups = { "Validations_CropMonitoring"})
	public void checkIfMethodOfSowingIsMandatory() {
		PageFactory.cropMonitoring_Stage_Sowing.clickOnSubmitStage();
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected =  popupText_MethodOfSowing;
		PageFactory.genericPageElements.clickOnPopupOKButton();
		PageFactory.cropMonitoring_Stage_Sowing.selectMethodOfSowing(methodOfSowing);
		Logger.log("The message is :"+actual);
		Assert.assertEquals(actual, expected);	
	}
	
	@Test(priority = 3, groups = { "Validations_CropMonitoring"})
	public void checkIfSeedVarietyIsMandatory() {
		PageFactory.cropMonitoring_Stage_Sowing.clickOnSubmitStage();
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected =  popupText_SeedVariety;
		PageFactory.genericPageElements.clickOnPopupOKButton();
		PageFactory.cropMonitoring_Stage_Sowing.selectCropVariety(cropVariety);
		Logger.log("The message is :"+actual);
		Assert.assertEquals(actual, expected);	
	}
	
	@Test(priority = 3, groups = { "Validations_CropMonitoring"})
	public void checkIfSowingCostIsMandatory() {
		PageFactory.cropMonitoring_Stage_Sowing.clickOnSubmitStage();
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected =  popupText_Sowing_Cost;
		PageFactory.genericPageElements.clickOnPopupOKButton();
		PageFactory.cropMonitoring_Stage_Sowing.enterCost(sowingCost);
		Logger.log("The message is :"+actual);
		PageFactory.cropMonitoring_Stage_Sowing.clickOnSaveStage();
	}
	
	@Test(priority = 3, groups = { "Validations_CropMonitoring"})
	public void checkDateOfSowingAndDateOfPresowing() {
		PageFactory.cropMonitoring_CropCalendar.clickOnCreatedStage(PageFactory.cropMonitoring_CropCalendar.sowing);
		PageFactory.cropMonitoring_Stage_Sowing.enterDateOfSowing(invalid_DateOfSowing);
		actual =  PageFactory.genericPageElements.getTextFromPopup();
		expected =  invalid_DateOfSowing;
		PageFactory.genericPageElements.clickOnPopupOKButton();
		Action.waitALittle(5000);
		PageFactory.cropMonitoring_Stage_Sowing.enterDateOfSowing(dateOfSowing);
		PageFactory.cropMonitoring_Stage_Sowing.clickOnSaveStage();
		Logger.log("The nmessage is:"+actual);
		Assert.assertEquals(actual, expected);	
	}
	
	@Test(priority = 3, groups = { "Validations_CropMonitoring"})
	public void checkIfDuplicateSowingStageIsCreated() {
		Action.waitALittle(5000);
		PageFactory.cropMonitoring_CropCalendar.selectStage(PageFactory.cropMonitoring_CropCalendar.sowing);
		actual= Action.getText(PageFactory.cropMonitoring_CropCalendar.duplicate_presowing_message);
		expected =  DataReference.references.get("CropCalender duplicate_sowing_message");
		Logger.log(actual);
		Action.waitALittle(4000);
	}*/
	

	/** Validations for Sowing stage*
	 * ------------------------------------------------------------------------------------*/
	
	
	
	
	
	@Test(priority = 0, groups = { "Monitor a crop"})
	public void navigateToCropMonitoringPageFromDashboard() {
		Action.waitALittle(5000);
		Values.tcTestData="";
		PageFactory.cropMonitoring_AddCrops.navigateToAddCropPage();
	}

	@Test(priority = 1, groups = { "Monitor a crop"})
	public void addACropToMonitor() {
		Values.tcTestData= surveyNo+","+fieldName;
		//CropMonitoring_AddCrops.clickOnAddedCrop();
		PageFactory.cropMonitoring_AddCrops.clickOnAddCrops();
		PageFactory.cropMonitoring_AddCrops.selectSurveyNumber(surveyNo);
		PageFactory.cropMonitoring_AddCrops.selectFieldName(fieldName);
		expected = seasonCropYear;
		actual = PageFactory.cropMonitoring_AddCrops.checkSeasonCropMapping();
		PageFactory.cropMonitoring_AddCrops.clickOnDoneButton();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2, groups = { "Monitor a crop"})
	public void addStagePreSowing() {
		Values.tcTestData=PageFactory.cropMonitoring_CropCalendar.preSowing;
		//CropMonitoring_CropCalendar.clickOnAddStageButton();
		PageFactory.cropMonitoring_CropCalendar.selectStage(PageFactory.cropMonitoring_CropCalendar.preSowing);
	}


	@Test(priority = 3, groups = { "Monitor a crop"})
	public void enterDeepPloughingDetails() {
		Values.tcTestData= dateOfPloughing;
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnDeepPloughingSwitch();
		Action.waitALittle(3000);
		PageFactory.cropMonitoring_Stage_PreSowing.enterDateOfPloughing(dateOfPloughing);
	}

	@Test(priority = 4, groups = { "Monitor a crop"})
	public void enterCultivatorDetails() {
		Values.tcTestData = dateOfCultivation;
		PageFactory.cropMonitoring_Stage_PreSowing.selectCultivator(cultivator);
		Action.waitALittle(3000);
		PageFactory.cropMonitoring_Stage_PreSowing.enterDateOfCultivation(dateOfCultivation);
	}
	
	@Test(priority = 5, groups = { "Monitor a crop"})
	public void enterLevellingDetails() {
		Values.tcTestData = dateOfLevelling;
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnLevellingSwitch();
		Action.waitALittle(3000);
		PageFactory.cropMonitoring_Stage_PreSowing.enterDateOfLevelling(dateOfLevelling);
	}
	
	@Test(priority = 6, groups = { "Monitor a crop"})
	public void enterPreSowingCost() {
		Values.tcTestData = preSowing_cost;
		PageFactory.cropMonitoring_Stage_PreSowing.enterCost(preSowing_cost);
     	}
	
	@Test(priority = 7, groups = { "Monitor a crop"})
	public void submitPreSowingStage() {
		Values.tcTestData = "";
		PageFactory.cropMonitoring_Stage_PreSowing.clickOnSubmitStage();
		Action.waitALittle(5000);
     	}
	
	//Stage Sowing
	@Test(priority = 8, groups = { "Monitor a crop"})
	public void addStageSowing() {
		Values.tcTestData=PageFactory.cropMonitoring_CropCalendar.sowing;
		//CropMonitoring_CropCalendar.clickOnAddStageButton();
		PageFactory.cropMonitoring_CropCalendar.selectStage(PageFactory.cropMonitoring_CropCalendar.sowing);
	
	}
	
	@Test(priority = 9, groups = { "Monitor a crop"})
	public void addSeedTreatmentDetails() {
		Values.tcTestData=fertilizer+","+qty;
		//CropMonitoring_Stage_Sowing.clickOnSeedTreatmentSwitch();
		//CropMonitoring_Stage_Sowing.clickOnAddFertilizerButton();
		//CropMonitoring_Stage_Sowing.selectFertilizerAndQuantity(fertilizer,qty);
	}
	
	@Test(priority = 10, groups = { "Monitor a crop"})
	public void selectCropVariety() {
		Values.tcTestData=cropVariety;
		PageFactory.cropMonitoring_Stage_Sowing.selectCropVariety(cropVariety);
	}
	
	@Test(priority = 11, groups = { "Monitor a crop"})
	public void selectSeedType() {
		Values.tcTestData=seedType;
		PageFactory.cropMonitoring_Stage_Sowing.selectSeedType(seedType);
	}
	
	/*@Test(priority = 12, groups = { "Monitor a crop"})
	public void selectSeedSource() {
		Values.tcTestData=seedSource;
		CropMonitoring_Stage_Sowing.selectSeedSource(seedSource);
	}*/
	
	@Test(priority = 13, groups = { "Monitor a crop"})
	public void enterDateOfSowing() {
		Values.tcTestData=dateOfSowing;
		PageFactory.cropMonitoring_Stage_Sowing.enterDateOfSowing(dateOfSowing);
	}

	@Test(priority = 14, groups = { "Monitor a crop"})
	public void enterSeedQuantity() {
		Values.tcTestData=seedQuantity;
		PageFactory.cropMonitoring_Stage_Sowing.enterSeedQuantity(seedQuantity);
	}
	
	@Test(priority = 15, groups = { "Monitor a crop"})
	public void selectMethodOfSowing() {
		Values.tcTestData=methodOfSowing;
		PageFactory.cropMonitoring_Stage_Sowing.selectMethodOfSowing(methodOfSowing);
	}
	
	@Test(priority = 16, groups = { "Monitor a crop"})
	public void enterRowToRow() {
		Values.tcTestData=rowToRow;
		PageFactory.cropMonitoring_Stage_Sowing.enterRowToRow(rowToRow);
	}
	
	@Test(priority = 17, groups = { "Monitor a crop"})
	public void enterPlantToPlant() {
		Values.tcTestData=plantToPlant;
		PageFactory.cropMonitoring_Stage_Sowing.enterPlantToPlant(plantToPlant);
	}
	
	@Test(priority = 18, groups = { "Monitor a crop"})
	public void enterCost() {
		Values.tcTestData=sowingCost;
		PageFactory.cropMonitoring_Stage_Sowing.enterCost(sowingCost);
	}
	
	@Test(priority = 19, groups = { "Monitor a crop"})
	public void submitSowingStage() {
		Values.tcTestData="";
		//CropMonitoring_Stage_Sowing.clickOnSubmitButton();
	}
		
	//HARVESTING
	@Test(priority = 20, groups = { "Monitor a crop"})
	public void addStageHarvesting() {
		Values.tcTestData=PageFactory.cropMonitoring_CropCalendar.harvesting;
		//CropMonitoring_CropCalendar.clickOnAddStageButton();
		PageFactory.cropMonitoring_CropCalendar.selectStage(PageFactory.cropMonitoring_CropCalendar.harvesting);
	}
	
	@Test(priority = 21, groups = { "Monitor a crop"})
	public void enterDateOfHarvesting() {
		Values.tcTestData = dateOfHarvesting;
		PageFactory.cropMonitoring_Stage_Harvesting.enterDateOfHarvesting(dateOfHarvesting);
	}
	
	@Test(priority = 22, groups = { "Monitor a crop"})
	public void enterYieldQuantity() {
		Values.tcTestData = yieldQuantity;
		PageFactory.cropMonitoring_Stage_Harvesting.enterYieldQuatity(yieldQuantity);
	}
	
	@Test(priority = 23, groups = { "Monitor a crop"})
	public void enterDateOfThreshing() {
		Values.tcTestData = dateOfThreshing;
		PageFactory.cropMonitoring_Stage_Harvesting.enterDateOfThreshing(dateOfThreshing);
	}
	
	@Test(priority = 24, groups = { "Monitor a crop"})
	public void enterCostOfHarvesting() {
		Values.tcTestData = costOfHarvesting;
		PageFactory.cropMonitoring_Stage_Harvesting.enterHarvestingCost(costOfHarvesting);
	}
	
	@Test(priority = 25, groups = { "Monitor a crop"})
	public void submitHarvestingStage() {
		Values.tcTestData = "";
		PageFactory.cropMonitoring_Stage_Harvesting.clickOnSubmitStage();
		Action.waitALittle(6000);
	}
	






}

//	CropMonitoring_AddCrops.clickOnAddCrops();
//CropMonitoring_AddCrops.selectSurveyNumber(surveyNo);	
/*CropMonitoring_AddCrops.clickOnAddedCrop();
CropMonitoring_CropCalendar.clickOnAddStageButton();
CropMonitoring_CropCalendar.selectStage(CropMonitoring_CropCalendar.preSowing);
CropMonitoring_Stage_PreSowing.clickOnDeepPloughingSwitch();
CropMonitoring_Stage_PreSowing.enterDateOfPloughing(DataReference.references.get("PreSowing dateOfPloughing"));
CropMonitoring_Stage_PreSowing.selectCultivator(DataReference.references.get("PreSowing cultivator"));
CropMonitoring_Stage_PreSowing.clickOnLevellingSwitch();
CropMonitoring_Stage_PreSowing.enterDateOfLevelling(DataReference.references.get("PreSowing levellingDate"));
CropMonitoring_Stage_PreSowing.enterCost(DataReference.references.get("PreSowing preSowing_cost"));
CropMonitoring_Stage_PreSowing.clickOnSave();	*/