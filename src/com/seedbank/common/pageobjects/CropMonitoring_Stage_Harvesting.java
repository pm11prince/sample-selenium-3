package com.seedbank.common.pageobjects;

import org.openqa.selenium.By;

import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.LocatorReferences;

public class CropMonitoring_Stage_Harvesting {

	public By date_of_harvesting=LocatorReferences.references.get("Stage_Harvesting date_of_harvesting");
	public By yield_quantity=LocatorReferences.references.get("Stage_Harvesting yield_quantity");
	public By date_of_threshing=LocatorReferences.references.get("Stage_Harvesting date_of_threshing");
	public By cost_harvesting=LocatorReferences.references.get("Stage_Harvesting cost_harvesting");
	
	
	public void enterDateOfHarvesting(String dateOfHarvesting) {
		Action.sendKeys(date_of_harvesting, dateOfHarvesting);
	}
	
	public void enterYieldQuatity(String yieldQuantity) {
		Action.sendKeys(yield_quantity, yieldQuantity);
		Action.waitALittle(2000);
	}
	
	public void enterDateOfThreshing(String dateOfThreshing) {
		Action.sendKeys(date_of_threshing, dateOfThreshing);
		Action.waitALittle(2000);
	}
	
	public void enterHarvestingCost(String costOfHarvesting) {
		Action.sendKeys(cost_harvesting, costOfHarvesting);
		Action.waitALittle(2000);
	}
	
	public void clickOnSubmitStage() {
		Action.click(PageFactory.cropMonitoring_Stage_PreSowing.save_button);
		Action.waitALittle(2000);

	}
	
	
	
}
