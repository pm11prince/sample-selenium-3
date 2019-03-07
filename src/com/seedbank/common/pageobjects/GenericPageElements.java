package com.seedbank.common.pageobjects;


import org.openqa.selenium.By;
import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.LocatorReferences;


public class GenericPageElements {


	public By profile_photo=LocatorReferences.references.get("GenericPageElements profile_photo");
	public By profile_back_arrow=LocatorReferences.references.get("GenericPageElements profile_back_arrow");
	public By save_button=LocatorReferences.references.get("GenericPageElements save_button");
	public By submit_button=LocatorReferences.references.get("GenericPageElements submit_button");
	public By popup_dialog=LocatorReferences.references.get("GenericPageElements popup_dialog");
	public By popup_OkButton=LocatorReferences.references.get("GenericPageElements popup_OkButton");
	public By progress_bar=LocatorReferences.references.get("Dashboard progress_bar");




	public static void waitForProgressBarInVisible(By loc, long time) {

		Action.waitForElementInVisible(loc, time);
	}


	public void checkIfProfileIsLoaded() { // for new registration
		Action.waitForElementVisibility(profile_photo,90);
	}

	public void checkIfDashboardIsLoaded() {
		Action.waitForElementInVisible(progress_bar,600);
		Action.waitForElementVisibility(PageFactory.user_dashboard.sliderIcon, 200);
	}

	public String getTextFromPopup() {
		return Action.getText(popup_dialog);
	}

	public void clickOnPopupOKButton() {
		Action.click(popup_OkButton);
	}



}



