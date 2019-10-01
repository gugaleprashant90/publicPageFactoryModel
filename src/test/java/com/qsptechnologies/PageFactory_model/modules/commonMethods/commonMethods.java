package com.qsptechnologies.PageFactory_model.modules.commonMethods;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.qsptechnologies.PageFactory_model.modules.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class commonMethods extends TestBase {

	public static void selectDropDownByValue(WebElement xpath, String value,String webelementName) throws IOException {
		try {
			Select sel = new Select(xpath);
			sel.selectByValue(value);
			test.log(LogStatus.PASS, webelementName + " has been Selected");
			takeScreenshot();
			Reporter.log(webelementName + " has been Selected");
			
		} catch (Throwable t) {
			test.log(LogStatus.FAIL, webelementName +" not been select because of "+t.getMessage());
			takeScreenshot();
			Reporter.log(webelementName +" not been select because of "+t.getMessage());
		}
		

	}

	public static void selectDropDownByIndex(WebElement xpath, int index,String webelementName) throws IOException {
		try {
			Select sel = new Select(xpath);
			sel.selectByIndex(index);
			test.log(LogStatus.PASS, webelementName + " has been Selected");
			takeScreenshot();
			Reporter.log(webelementName + " has been Selected");
			
		} catch (Throwable t) {
			test.log(LogStatus.FAIL, webelementName +" not been select because of "+t.getMessage());
			takeScreenshot();
			Reporter.log(webelementName +" not been select because of "+t.getMessage());
		}
		

	}

	public static void selectDropDownByVisibleText(WebElement xpath, String text,String webelementName) throws IOException {
		try {
			Select sel = new Select(xpath);
			sel.selectByVisibleText(text);
			test.log(LogStatus.PASS, webelementName + " has been Selected");
			takeScreenshot();
			Reporter.log(webelementName + " has been Selected");
			
		} catch (Throwable t) {
			test.log(LogStatus.FAIL, webelementName +" not been select because of "+t.getMessage());
			takeScreenshot();
			Reporter.log(webelementName +" not been select because of "+t.getMessage());
		}
		
	}
	
	//Handle Multiple Window
	public static void getWindowHanles(int num){
		String winID = null;
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		for(int i=0;i<=num;i++){
			winID = itr.next();
		}
		driver.switchTo().window(winID);	
		test.log(LogStatus.PASS, "Focus Switch To New Window");
		Reporter.log("Focus Switch To New Window");
	}

	
}
