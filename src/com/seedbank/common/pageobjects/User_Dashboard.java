package com.seedbank.common.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.LocatorReferences;

public class User_Dashboard {

	public  By sliderIcon =  LocatorReferences.references.get("Dashboard sliderIcon");
	public  By menu_list= LocatorReferences.references.get("Dashboard menu_list");
	public  By farmer_dashboard = LocatorReferences.references.get("Dashboard farmer_dashboard");
	public  By crop_monitoring_link = LocatorReferences.references.get("Dashboard crop_monitoring_link");
	public  By buy_inputs_link = LocatorReferences.references.get("Dashboard buy_inputs_link");
	public  By order_history_link = LocatorReferences.references.get("Dashboard order_history_link");
	public  By menu_home = LocatorReferences.references.get("Dashboard menu_home");
	public  By menu_swipe = LocatorReferences.references.get("Dashboard menu_swipe");

	
	public void clickOnSlider(){
		Action.waitForElementVisibility(sliderIcon, 40);
		Action.click(sliderIcon);
		Action.waitALittle(3000);
	}

	public  void clickOnMenu(String menuOption){
		if(menuOption.equals("Home")) 
			Action.click(menu_home);
		else {
			Action.swipe(menu_swipe);
			List<WebElement> list = Action.findElements(menu_list);
			System.out.println(list.size());
			for(WebElement item : list)
			{
				String text= item.getAttribute("text");
				if(text.equals(menuOption))
				{
					item.click();
				    break;
				}
			}	
		}
		Action.waitALittle(4000);
	  }
	
	public void clickOnFarmerDashboard(){
		Action.click(farmer_dashboard);
		Action.waitALittle(3000);
	}

	public void clickOnCropMonitoring(){
		Action.click(crop_monitoring_link);
	}

	public void clickOnBuyInputs(){
     
	}

	public void clickOnOrderHistory() {

	}
}
