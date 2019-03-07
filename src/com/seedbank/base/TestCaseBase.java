package com.seedbank.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.seedbank.common.reporting.Values;
import com.seedbank.common.utils.Logger;

public class TestCaseBase{
	
	protected static AndroidDriver androiddriver;
	
	/**
	 * @return The AppiumDriver object that is currently handling the actions in
	 *         the opened browser on mobile.
	 */

	public static AndroidDriver getAndroidDriver() {
		return androiddriver;
	}
	/**
	 * @param OS
	 *            The OS in which the test cases will be performed.
	 * @param deviceID
	 * 			  Device mac ID/UDID is passed. 
	 * 
	 *    
	 */
	
	public void setDriver(String OS,String deviceID) {
		switch (OS) {
		case "Android":
			androiddriver = initAndroidDriver(deviceID);
			Values.platform = OS;
			break;

		default:
			System.out.println("OS Selected: " + OS+ " is invalid..");
		}
	}
	/**
	 * @return The initialized Android driver.
	 * @param deviceID
	 */
	
	private static AndroidDriver initAndroidDriver(String deviceID) {
		
		
		Logger.log("Launching Appium Android...");
		
		
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "//apk_files");
		File app = new File(appDir, "SeedBank_UAT_01.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "e516e0b0");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.itc.seedbankuat"); //  com.itc.seedbankqa
		capabilities.setCapability("appActivity","md570a67b0d01c415d5dec6503f08b2f877.SplashScreen");
		capabilities.setCapability("newCommandTimeout", 400);
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("noReset", "false");
		capabilities.setCapability("autoGrantPermissions", "true");	
		capabilities.setCapability("autoAcceptAlerts", "true");


		try {
			androiddriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		androiddriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Values.initializeStartTime();
		//Values.originalHandle=androiddriver.getWindowHandle();
        System.out.println("Initialized androiddriver");
		return androiddriver;
	}


	/**
	 * @param OS
	 *            The OS in which the test cases will be performed.
	 * @param deviceID
	 * 			  Device mac ID/UDID is passed.        
	 */
	
	
	@BeforeTest(groups= { "setup" })
	@Parameters({ "OS","deviceID" })
	
	public void initializeTestBaseSetup(
			 String OS,String deviceID) {
		System.out.println(OS);
		try {
			if(androiddriver == null)
			{
				
				Values.os=OS;
				setDriver(OS,deviceID);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Androiddriver not initilaized");
			System.out.println("Error... " + e.getStackTrace());
		}
		
		System.out.println("In Test base setup end");
	}
}