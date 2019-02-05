package com.seedbank.common.pageobjects;


import org.openqa.selenium.By;
import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.LocatorReferences;

public class CropMonitoring_AddCrops {


	public By add_crops=LocatorReferences.references.get("CropMonitoring_AddCrops add_crops");
	public By select_survey_no=LocatorReferences.references.get("CropMonitoring_AddCrops select_survey_no");
	public By select_field_name=LocatorReferences.references.get("CropMonitoring_AddCrops select_field_name");
	public By season_crop_mapping=LocatorReferences.references.get("CropMonitoring_AddCrops season_crop_mapping");//auto populated
	public By dropdown_list= LocatorReferences.references.get("FarmerLand dropdown_list");
	public By done=LocatorReferences.references.get("CropMonitoring_AddCrops done");
	public By added_crop_survey_number=LocatorReferences.references.get("CropMonitoring_AddCrops added_crop_survey_number");


	public void navigateToAddCropPage()
	{
		if(Action.elementExists(PageFactory.user_dashboard.crop_monitoring_link))
			Action.click(PageFactory.user_dashboard.crop_monitoring_link);
		else {
			Action.click(PageFactory.genericPageElements.profile_back_arrow);
			Action.waitALittle(3000);
			Action.click(PageFactory.user_dashboard.crop_monitoring_link);
			Action.waitALittle(3000);
		}
	}
	
	public void clickOnAddCrops()
	{
		Action.click(add_crops);
		Action.waitForElementVisibility(select_survey_no, 60);
		Action.waitForElementInVisible(select_survey_no, 60);
	}
	
	public void selectSurveyNumber(String surveyNo){
		Action.click(select_survey_no);
		Action.selectExactValueFromList(dropdown_list, surveyNo);
		System.out.println("Survey Number is present in the list:"+Action.checkWhetherItemIsPresentInList(dropdown_list, surveyNo));

		Action.selectExactValueFromList(dropdown_list, surveyNo);
		System.out.println("Survey Number is present in the list:"+
				Action.checkWhetherItemIsPresentInList(dropdown_list, surveyNo));

		Action.waitALittle(2000);
	}
	
	public void selectFieldName(String fieldName)
	{
		Action.click(select_field_name);
		Action.selectExactValueFromList(dropdown_list, fieldName);
		Action.selectExactValueFromList(dropdown_list, fieldName);
		System.out.println("Field Name is present in the list:"+
				Action.checkWhetherItemIsPresentInList(dropdown_list, fieldName));
		Action.waitALittle(2000);
	}

	public String checkSeasonCropMapping() {
		return (Action.getText(season_crop_mapping));
	}
		
	public void clickOnDoneButton(){
		Action.click(done);
	}

	public void clickOnAddedCrop(){
		Action.click(added_crop_survey_number);
	}



}
