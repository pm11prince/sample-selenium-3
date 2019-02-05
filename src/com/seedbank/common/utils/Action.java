package com.seedbank.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import com.seedbank.base.TestCaseBase;
import com.seedbank.common.reporting.Values;


/**
 * @author Pratyush Choudhary
 */
public class Action {

	public static final double waitFactor = 1;

	/**
	 * @param loc
	 *            Identifier of the web element.
	 */
	public static void click(By loc) {
		TestCaseBase.getAndroidDriver().findElement(loc).click();
	}

	/**
	 * @param loc
	 *            Identifier of the web element.
	 * @param val
	 *            The value to be sent to the web element.
	 */
	public static void sendKeys(By loc, String val) {
		clear(loc);
		TestCaseBase.getAndroidDriver().findElement(loc).sendKeys(val);
	}

	/**
	 * @param loc
	 *            Identifier of the web element.
	 * @return The value being displayed on the web element as defined by the
	 *         value attribute of its HTML tag.
	 */
	public static String getTextValue(By loc) {
		return TestCaseBase.getAndroidDriver().findElement(loc)
				.getAttribute("value");


	}

	
	public static boolean checkWhetherItemIsPresentInList(By loc, String value)
	{
		List<WebElement> list = Action.findElements(loc);
		for(WebElement item : list)
		{
			String text= item.getAttribute("text");
			if(text.indexOf(value)!=-1){
				System.out.println(value +"is present in the list");
				return true;
			}
		}
		return false;
	}

	/**
	 * @param loc
	 *            Identifier of the web element.
	 * @param text
	 *            The text to be selected in the list.
	 */

	
	public static void selectValueFromListByIndex(By loc, int index) {
		List<WebElement> list = Action.findElements(loc);
		Logger.log("Clicked on item:="+list.get(index).getText());
		list.get(index).click();
	}
	
	
	/**
	 * @param loc
	 *            Identifier of the web element.
	 * @return The the text value in the web element.
	 */
	public static String getText(By loc) {
		return TestCaseBase.getAndroidDriver().findElement(loc).getText();

	}

	/**
	 * @param loc
	 *            Identifier of the web element.
	 * @return Returns true if an element with the given identifier exists on
	 *         the web page.
	 */
	public static boolean elementExists(By loc) {
		return (TestCaseBase.getAndroidDriver().findElements(loc).size()) > 0;
	}


	/**
	 * @param loc
	 *            Identifier of the web element.
	 * @return Returns the list of web elements with the identifier same as the
	 *         identifier provided.
	 */

	@SuppressWarnings("unchecked")
	public static List<WebElement> findElements(By loc) {
		return TestCaseBase.getAndroidDriver().findElements(loc);
	}

	/**
	 * @param time
	 *            The amount of time to wait.
	 */
	public static void waitALittle(long time) {
		try {
			Thread.sleep((long) (time * waitFactor));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Clear a text field
	 */
	public static void clear(By loc) {
		TestCaseBase.getAndroidDriver().findElement(loc).clear();
	}

	/**
	 * List the size of child elements to this element
	 */
	public static int listSize(By loc) {
		return Action.findElements(loc).size();
	}

	/**
	 * @param loc
	 *            Identifier of the web element.
	 * @return The value being displayed on the web element as defined by the
	 *         value attribute of its HTML tag.
	 */

	public static String getAttribute(By loc, String value) {
		return TestCaseBase.getAndroidDriver().findElement(loc)
				.getAttribute(value);

	}

	/**
	 * @param frameName
	 *            The name of the frame to which the control will switch to
	 */
	public static void switchFrameTo(String frameName) {
		TestCaseBase.getAndroidDriver().switchTo().frame(frameName);
	}

	
	/**
	 * @param frameID
	 *            The index of frame
	 */
	public static void switchFrameTo(int frameIndex) {
		TestCaseBase.getAndroidDriver().switchTo().frame(frameIndex);
	}

	/**
	 * Switch frame to default content
	 */
	public static void switchToDefaultFrame() {
		TestCaseBase.getAndroidDriver().switchTo().defaultContent();
	}

	/**
	 * @param log
	 *            The log number after completion of order
	 */
	public static void writeOrderHistoryLog(String num, String name) {
		try {
			FileWriter fileWriter = new FileWriter("log//order history.txt",
					true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("\n\n" + "Test Case: " + name + " -> Order Number: " + num + " -> " + Values.startTime);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void waitForElementInVisible(By loc, long time) {
		try {
			WebDriverWait wait = new WebDriverWait(TestCaseBase.getAndroidDriver(), time);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loc));
		
		} catch (Exception e) {
			Logger.log("Element Not Found:"+loc);
			e.printStackTrace();
		}
	}
	
   
   
	
public static void writeMobileNumberToFile(String mobileNumber) throws IOException {
	String filePath = "resources\\Registered_Mobile_Numbers.xlsx";
	File file =    new File(filePath);
	System.out.println("gjhfjh");
	 try {
		FileInputStream inputStream = new FileInputStream(file);  
		XSSFWorkbook wb =  new XSSFWorkbook(inputStream);
		XSSFSheet sheet =  wb.getSheet("Registered");
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println(rowCount);
	/*	XSSFRow row = sheet.getRow(0);
		XSSFRow newRow = sheet.createRow(rowCount+1);*/
        sheet.getRow(0).getCell(0).setCellValue(mobileNumber);
        System.out.println("settt");
        
		/* for(int j = 0; j < row.getLastCellNum(); j++) {
		        XSSFCell cell = newRow.createCell(j);

		        cell.setCellValue(mobileNumber);

		    }*/
		 inputStream.close();
		 FileOutputStream outputStream = new FileOutputStream(file);
		 wb.write(outputStream);
		    outputStream.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	 
}
	
	public static void swipe(By loc) {
		WebElement ele= TestCaseBase.getAndroidDriver().findElement(loc);
		TestCaseBase.getAndroidDriver().swipe(ele.getLocation().getX(), 
				ele.getLocation().getY(), ele.getSize().getHeight(), ele.getSize().getWidth(), 8000);
		
	}
	
   public static void scrollTillElement2(By loc)
   {
	   WebElement ele= TestCaseBase.getAndroidDriver().findElement(loc);
	   TouchActions action = new TouchActions(TestCaseBase.getAndroidDriver());
	   action.scroll(ele, 10, 100);
	   action.perform();
   }
   
	public static void scrollTillElement(String text) {
		TestCaseBase.getAndroidDriver().findElementByAndroidUIAutomator
		(("new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\""+text+"\"));"));
		
		//TestCaseBase.getAndroidDriver().findElementByAndroidUIAutomator
		//(("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Select Village*\"));"));
	}

	public static void relaunch() {
		TestCaseBase.getAndroidDriver().resetApp();
	}


	public static void navigateBack() {
		TestCaseBase.getAndroidDriver().navigate().back();
	}

	public static void submit(By loc) {
		TestCaseBase.getAndroidDriver().findElement(loc).submit();
	}

	public static void waitForElementVisibility(By loc, long time) {
		try {
			WebDriverWait wait = new WebDriverWait(TestCaseBase.getAndroidDriver(), time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
		} catch (Exception e) {
			Logger.log("Element Not Found:"+loc);
			e.printStackTrace();
		}
	}
	

	public static void selectExactValueFromList(By loc, String value) {
		List<WebElement> list = Action.findElements(loc);
		for(WebElement item : list)
		{
			String text= item.getAttribute("text");
			if(text.equals(value))
			{
				item.click();
				System.out.println("Clicked on item:"+ text);
				break;
			}
	}
	}
	
	public static void refresh() {
		TestCaseBase.getAndroidDriver().navigate().refresh();
	}

	/*	public static void dragMap(By loc, int xOffset, int yOffset, int dragLength)
	{   
		Point coordinates = Action.findElements(loc).get(0).getLocation();
		Robot robot;
		try {
			robot = new Robot();
			//System.out.println("("+coordinates.getX() + " " + coordinates.getY()+")");
			robot.mouseMove(coordinates.getX()+xOffset,coordinates.getY() +yOffset);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			for(int i = 0; i < dragLength; i++) {
				robot.mouseMove(coordinates.getX() + xOffset + i,coordinates.getY() + yOffset);
				Action.waitALittle(20);
			}
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			Action.waitALittle(20000);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}*/

}

/*public static void selectValueFromList(By loc, int index) {
	List<WebElement> list = Action.findElements(loc);
	list.get(index).click();
}
*//**
 * @param loc
 *            Identifier of the web element.
 * @return The text that has been selected in the list.
 *//*
public static String getSelectedText(By loc) {
	Select select = new Select(TestCaseBase.getAndroidDriver().findElement(
			loc));
	return select.getFirstSelectedOption().getText();
}*/


/*public static void ScrollUp(By loc) {
	JavascriptExecutor jse = (JavascriptExecutor) TestCaseBase
			.getAndroidDriver();
	jse.executeScript("window.scrollBy(0,-750)", "");
}

public static void ScrollDown(By loc) {
	JavascriptExecutor jse = (JavascriptExecutor) TestCaseBase
			.getAndroidDriver();
	jse.executeScript("window.scrollBy(0,750)", "");
}
*/