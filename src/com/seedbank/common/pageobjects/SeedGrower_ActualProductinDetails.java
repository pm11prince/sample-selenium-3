package com.seedbank.common.pageobjects;

import org.openqa.selenium.By;

import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.LocatorReferences;

public class SeedGrower_ActualProductinDetails {

	
	public By tab_Actual_Production_Details=LocatorReferences.references.get("Actual_Production_Details tab_Actual_production_details");
	public By select_Survey_No=LocatorReferences.references.get("Actual_Production_Details select_Survey_No");
	public By select_Feild_Name=LocatorReferences.references.get("Actual_Production_Details select_Feild_Name");
	public By quantity_For_sale=LocatorReferences.references.get("Actual_Production_Details quantity_For_sale");
	public By save_Button=LocatorReferences.references.get("Actual_Production_Details save_Button");
	public By add_Farmer_Bag=LocatorReferences.references.get("Actual_Production_Details add_Farmer_Bag");
	public By text_FarmerName=LocatorReferences.references.get("Actual_Production_Details text_farmerName");
	public By text_villageName=LocatorReferences.references.get("Actual_Production_Details text_villageName");
	public By dropdown_list=LocatorReferences.references.get("GenericPageElements dropdown_list");
	public By progress_bar=LocatorReferences.references.get("GenericPageElements progress_bar");
	public By verify_sg_Farmer_Name=LocatorReferences.references.get("Actual_Production_Details verify_Sg_Farmer_Name");
	public By verify_Sg_VillageName=LocatorReferences.references.get("Actual_Production_Details verify_Sg_VillageName");
	public By verify_Sg_availableQty=LocatorReferences.references.get("Actual_Production_Details verify_Sg_availableQty");
	public By verify_Sg_recommendedPrice=LocatorReferences.references.get("Actual_Production_Details verify_Sg_recommendedPrice");
	public By verify_ScreenTitle=LocatorReferences.references.get("Actual_Production_Details verify_ScreenTitle");
	public By verify_SeasonCropMapping=LocatorReferences.references.get("Actual_Production_Details verify_SeasonCropMapping");
	
	
	public  void navigateToActualProductinDetails ()
	{  
		Action.waitForElementVisibility(tab_Actual_Production_Details, 200);
		PageFactory.genericPageElements.waitForProgressBarInVisible(progress_bar, 120);
		Action.click(tab_Actual_Production_Details);
	}

	public  void selectSurveryNumber(String sGProdDetailsSurveyNo)
	{  
		Action.waitForElementVisibility(select_Survey_No, 200);
		Action.click(select_Survey_No);
		Action.selectExactValueFromList(dropdown_list, sGProdDetailsSurveyNo);
		Action.waitALittle(2000);
	
	}
	
	public  void selectFeildName(String sGProdDetailsFeildName)
	{  
		Action.waitForElementVisibility(select_Feild_Name, 10);
		Action.click(select_Feild_Name);
		Action.selectExactValueFromList(dropdown_list, sGProdDetailsFeildName);
		Action.waitALittle(4000);
	}
	
	
	public  void quantityForsale(String sGProdDetailsQuantityForsale)
	{  
		Action.sendKeys(quantity_For_sale, sGProdDetailsQuantityForsale);
	}
	
	
	public void clickOnSaveProductionDetails()
	{
		Action.click(save_Button);
	}
	
	public String verifySGName(){
	
			return Action.getText(verify_sg_Farmer_Name);
		}
	
	public String verifySGVillage(){
		
		return Action.getText(verify_Sg_VillageName);
	}
	
    public String verifyActualQuantity(){
		
		return Action.getText(verify_Sg_availableQty);
	}
    
    public String verifyRecommendedPrice(){
		
		return Action.getText(verify_Sg_recommendedPrice);
	}
    
    public String verifySGScreenTitle(){
		
		return Action.getText(verify_ScreenTitle);
	}
 
   public String verifySgSeasonCropmapping(){
		
		return Action.getText(verify_SeasonCropMapping);
	}
    
}
	

