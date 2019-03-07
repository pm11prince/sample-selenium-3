package com.seedbank.common.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.seedbank.common.reporting.Values;
import com.seedbank.common.pageobjects.PageFactory;
import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.DataReference;
import com.seedbank.common.utils.LocatorReferences;
import com.seedbank.common.utils.Logger;



public class SeedGrower_ActualProductinDetailsTest {
	
	
	
	public String actual, expected;
	
	public String sgProdDetailsSurveyNo= DataReference.references.get("SG_ActualProductionDetails sgProdDetailsSurveyNo");
	public String sgProdDetailsFeildName= DataReference.references.get("SG_ActualProductionDetails sgProdDetailsFeildName");
	public String sgProdDetailsQuantityForsale= DataReference.references.get("SG_ActualProductionDetails sgProdDetailsQuantityForsale");
	public String nameOfVillage= DataReference.references.get("SGProfile nameOfVillage");
	public String firstName= DataReference.references.get("SGProfile firstName");
	public String lastName= DataReference.references.get("SGProfile lastName");
	public String nameOfState= DataReference.references.get("SGProfile nameOfState");
	public String actualQty= DataReference.references.get("SGTestResult actualQty");
	public String recommendedPrice= DataReference.references.get("SGTestResult recommendedPrice");
	public String screenTitle= DataReference.references.get("SG_ActualProductionDetails screenTitle");
	public String seasonCropMapping= DataReference.references.get("SG_ActualProductionDetails seasonCropMapping");



	@Test(priority = 0, groups = {"Validations_SeedGrowerData"})
	public void navigateToActualProductionScreen() {
		Values.tcDescription="Navigating to actual production details screen";
	    PageFactory.seedGrower_ActualProductionDetails.navigateToActualProductinDetails();
	}
	
	@Test(priority = 1, groups = {"Validations_SeedGrowerData"})
	public void selectSrvyNumber() {
		Values.tcDescription="Selecting Survey No";
		Values.tcTestData=sgProdDetailsSurveyNo;
		Logger.log(sgProdDetailsSurveyNo);
		PageFactory.seedGrower_ActualProductionDetails.selectSurveryNumber(sgProdDetailsSurveyNo);
	}
	
	
	@Test(priority = 2, groups = {"Validations_SeedGrowerData"})
	public void selectFldNumber() {
		Values.tcDescription="Selecting Feild Name";
		Values.tcTestData=sgProdDetailsFeildName;
		Logger.log(sgProdDetailsFeildName);
		PageFactory.seedGrower_ActualProductionDetails.selectFeildName(sgProdDetailsFeildName);
	}
	
	@Test(priority = 3, groups = { "Validations_SeedGrowerData"})
	public void validateSeasonCropMapping() {
		Values.tcDescription="verifying season crop mapping screen";
		Values.tcTestData=seasonCropMapping;
		actual =  PageFactory.seedGrower_ActualProductionDetails.verifySgSeasonCropmapping();
		expected = seasonCropMapping;
		Assert.assertEquals(actual,expected);
	}
	@Test(priority = 4, groups = {"Validations_SeedGrowerData"})
	public void enterQntyOfSale() {
		Values.tcDescription="Entering Quantity for sale";
		Values.tcTestData=sgProdDetailsQuantityForsale;
		Logger.log(sgProdDetailsQuantityForsale);
		PageFactory.seedGrower_ActualProductionDetails.quantityForsale(sgProdDetailsQuantityForsale);
	}
	
	
	@Test(priority = 5, groups = {"Validations_SeedGrowerData"})
	public void createProductionDetails() {
		Values.tcDescription="Clicking  Save";
		PageFactory.seedGrower_ActualProductionDetails.clickOnSaveProductionDetails();		
}
	
	@Test(priority = 5, groups = { "Validations_SeedGrowerData"})
	public void validateSGFarmerName() {
		Values.tcDescription="verifying seed grower's name with respect to expected farmer's name";
		Values.tcTestData=firstName+" "+ lastName;
		actual =  PageFactory.seedGrower_ActualProductionDetails.verifySGName();
		expected = firstName +" "+ lastName;
		Assert.assertEquals(actual,expected);
	}
	

	@Test(priority = 6, groups = { "Validations_SeedGrowerData"})
	public void validateSGFarmerVillage() {
		Values.tcDescription="verifying seed grower's village name with respect to expected farmer's village name";
		Values.tcTestData=nameOfVillage;
		actual =  PageFactory.seedGrower_ActualProductionDetails.verifySGVillage();
		expected = nameOfVillage+","+nameOfState;
		Assert.assertEquals(actual,expected);
	}
	
	@Test(priority = 7, groups = { "Validations_SeedGrowerData"})
	public void validateSGActualQuantity() {
		Values.tcDescription="verifying actual quantity with respect to actual quantity given by MM during test result";
		Values.tcTestData=actualQty;
		actual =  PageFactory.seedGrower_ActualProductionDetails.verifyActualQuantity();
		expected = actualQty;
		Assert.assertEquals(actual,expected);
	}
	
	@Test(priority = 8, groups = { "Validations_SeedGrowerData"})
	public void validateSGRecommendedPrice() {
		Values.tcDescription="verifying Recomended Price with respect to Recomended Price given by MM during test result";
		Values.tcTestData=recommendedPrice;
		actual =  PageFactory.seedGrower_ActualProductionDetails.verifyRecommendedPrice();
		expected = recommendedPrice;
		Assert.assertEquals(actual,expected);
	}
	
	@Test(priority = 9, groups = { "Validations_SeedGrowerData"})
	public void validateSGScreenTitle() {
		Values.tcDescription="verifying Screen Title";
		Values.tcTestData=screenTitle;
		actual =  PageFactory.seedGrower_ActualProductionDetails.verifySGScreenTitle();
		expected = screenTitle;
		Assert.assertEquals(actual,expected);
	}
}
