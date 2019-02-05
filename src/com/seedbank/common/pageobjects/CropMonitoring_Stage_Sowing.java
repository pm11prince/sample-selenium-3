package com.seedbank.common.pageobjects;

import org.openqa.selenium.By;

import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.LocatorReferences;

public class CropMonitoring_Stage_Sowing {
	
	
	public By seed_treatment_switch=LocatorReferences.references.get("Stage_Sowing seed_treatment_switch");
	public By add_fertilizer_information=LocatorReferences.references.get("Stage_SowingPre-Sowing add_fertilizer_information");
	public By select_fertilizer=LocatorReferences.references.get("Stage_Sowing select_fertilizer");
	public By enter_fertilizer_quantity=LocatorReferences.references.get("Stage_Sowing enter_fertilizer_quantity");
	public By save_fertilizer_details=LocatorReferences.references.get("Stage_Sowing save_fertilizer_details");
	public By add_pesticide_information=LocatorReferences.references.get("Stage_Sowing add_pesticide_information");
	public By select_pesticide=LocatorReferences.references.get("Stage_Sowing select_pesticide");
	public By enter_pesticide_quantity=LocatorReferences.references.get("Stage_Sowing enter_pesticide_quantity");
	public By save_pesticide_details=LocatorReferences.references.get("Stage_Sowing save_pesticide_details");
	public By select_crop_variety=LocatorReferences.references.get("Stage_Sowing select_crop_variety");
	public By select_seed_type=LocatorReferences.references.get("Stage_Sowing select_seed_type");
	public By select_seed_source=LocatorReferences.references.get("Stage_Sowing select_seed_source");
	public By date_of_sowing=LocatorReferences.references.get("Stage_Sowing date_of_sowing");
	public By seed_quantity=LocatorReferences.references.get("Stage_Sowing seed_quantity");
	public By select_method_of_sowing=LocatorReferences.references.get("Stage_Sowing select_method_of_sowing");
	public By enter_row_to_row=LocatorReferences.references.get("Stage_Sowing enter_row_to_row");
	public By enter_plant_to_plant=LocatorReferences.references.get("Stage_Sowing enter_plant_to_plant");
	public By cost_sowing=LocatorReferences.references.get("Stage_Sowing cost_sowing");
	
	public static By dropdown_list= LocatorReferences.references.get("FarmerLand dropdown_list");
	
	
	public void clickOnSeedTreatmentSwitch() {
		Action.click(seed_treatment_switch);
	}
	
	public void clickOnAddFertilizerButton()	{
		Action.waitALittle(4000);
		Action.click(add_fertilizer_information);
	}
	
	public void selectFertilizerAndQuantity(String fertilizer,String qty) {
		Action.click(select_fertilizer);
		Action.selectExactValueFromList(dropdown_list, fertilizer);
		Action.waitALittle(4000);
		Action.sendKeys(enter_fertilizer_quantity, qty);
		Action.click(save_fertilizer_details);
	}
	
	public void selectCropVariety(String cropVariety) {
		Action.click(select_crop_variety);
		Action.selectExactValueFromList(dropdown_list, cropVariety);
		Action.waitALittle(4000);
	}
	
	public void selectSeedType(String seedType) {
		Action.click(select_seed_type);
		Action.selectExactValueFromList(dropdown_list, seedType);
		Action.waitALittle(2000);
	}
	
	public void selectSeedSource(String seedSource) {
		Action.click(select_seed_source);
		Action.selectExactValueFromList(dropdown_list, seedSource);
		Action.waitALittle(2000);
	}
	
	public void enterDateOfSowing(String dateOfSowing) {
		Action.sendKeys(date_of_sowing, dateOfSowing);
	}
	
	public void enterSeedQuantity(String seedQuantity) {
		Action.sendKeys(seed_quantity, seedQuantity);
	}
	
	public void selectMethodOfSowing(String methodOfSowing) {
		
		Action.click(select_method_of_sowing);
		Action.selectExactValueFromList(dropdown_list, methodOfSowing);
		Action.waitALittle(2000);
	}
	
	public void enterRowToRow(String rowToRow) {
		Action.sendKeys(enter_row_to_row, rowToRow);
	}
	
	public void enterPlantToPlant(String plantToPlant) {
		Action.waitALittle(4000);
		Action.swipe(enter_row_to_row);
		//Action.scrollTillElement2(enter_plant_to_plant);
		Action.sendKeys(enter_plant_to_plant, plantToPlant);
	}
	
	public void enterCost(String sowingCost)
	{
		Action.sendKeys(cost_sowing, sowingCost);
	}
	
	
	public void clickOnSaveStage(){
		Action.click(PageFactory.cropMonitoring_Stage_PreSowing.save_button);
	}
	
	public void clickOnSubmitStage() {
		Action.click(PageFactory.cropMonitoring_Stage_PreSowing.submit_button);
	}
	
	
	
	

}
