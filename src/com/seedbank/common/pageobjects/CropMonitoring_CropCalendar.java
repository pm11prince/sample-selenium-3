package com.seedbank.common.pageobjects;

import org.openqa.selenium.By;

import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.LocatorReferences;

public class CropMonitoring_CropCalendar {

	public String preSowing="Pre Sowing";
	public String sowing ="Sowing";
	public String germination= "Germination";
	public String irrigation = "Irrigation Management";
	public String nutrient = "Nutrient Management";
	public String weed = "Weed Management";
	public String pest = "Pest Management";
	public String harvesting = "Harvesting";

	public By add_stage=LocatorReferences.references.get("CropMonitoring_CropCalendar add_stage");
	public By stage_name=LocatorReferences.references.get("CropMonitoring_CropCalendar stage_name");
	public By sowing_stage=LocatorReferences.references.get("CropMonitoring_CropCalendar sowing_stage");
	public By select_created_stage =LocatorReferences.references.get("CropMonitoring_CropCalendar select_created_stage");
	public By duplicate_presowing_message =LocatorReferences.references.get("CropMonitoring_CropCalendar duplicate_presowing_message");

	
	public  void selectStage(String stageName) { // Modification required
		Action.click(add_stage);
		System.out.println("Added:"+stageName);
		
		if(stageName.equals(sowing)) 
			Action.click(sowing_stage);
		else
		{    //Action.scrollTillElement("Weed Management");
			Action.swipe(LocatorReferences.references.get("CropMonitoring_CropCalendar swipe"));
			Action.selectExactValueFromList(stage_name, stageName);}
		Action.waitALittle(4000);
	}
	
	public void clickOnCreatedStage(String stageName) {
		Action.selectExactValueFromList(select_created_stage, stageName);
		
		
	}
	/*public static void clickOnAddStageButton()
	{
		Action.click(add_stage);
	}*/

}
