package com.seedbank.common.pageobjects;

import org.openqa.selenium.By;

import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.LocatorReferences;

public class CropMonitoring_Stage_PreSowing {

	public By deep_ploughing_switch=LocatorReferences.references.get("Pre-Sowing deep_ploughing_switch");
	public By date_of_ploughing=LocatorReferences.references.get("Pre-Sowing date_of_ploughing");
	public By select_cultivator=LocatorReferences.references.get("Pre-Sowing select_cultivator");
	public By levelling_switch=LocatorReferences.references.get("Pre-Sowing levelling_switch");
	public By date_of_levelling=LocatorReferences.references.get("Pre-Sowing date_of_levelling");
	public By date_of_cultivation=LocatorReferences.references.get("Pre-Sowing date_of_cultivation");
	public By cost_presowing=LocatorReferences.references.get("Pre-Sowing cost_presowing");
	public By save_button=LocatorReferences.references.get("Pre-Sowing save_button");
	public By submit_button=LocatorReferences.references.get("Pre-Sowing submit_button");
	public By dropdown_list= LocatorReferences.references.get("FarmerLand dropdown_list");


	public void clickOnDeepPloughingSwitch()
	{
		Action.click(deep_ploughing_switch);
	}
	
	public void enterDateOfPloughing(String dateOfPloughing) {
		Action.sendKeys(date_of_ploughing, dateOfPloughing);
	}

	public void selectCultivator(String cultivator) {
		Action.click(select_cultivator);
		Action.selectExactValueFromList(dropdown_list, cultivator);
	}
     
	public void enterDateOfCultivation(String dateOfCultivation)
	{
		Action.sendKeys(date_of_cultivation, dateOfCultivation);
	}
	
	public void clickOnLevellingSwitch()
	{
		Action.click(levelling_switch);
	}
	
	public void enterDateOfLevelling(String levellingDate)
	{
		Action.sendKeys(date_of_levelling, levellingDate);
	}
	
	public void enterCost(String cost)
	{
		Action.sendKeys(cost_presowing, cost);
	}

	public void clickOnSaveStage()
	{
		Action.click(save_button);
	}
	
	public void clickOnSubmitStage() {
		Action.click(submit_button);
	}
}
