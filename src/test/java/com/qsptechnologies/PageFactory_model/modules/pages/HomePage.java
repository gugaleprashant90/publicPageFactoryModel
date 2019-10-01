package com.qsptechnologies.PageFactory_model.modules.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qsptechnologies.PageFactory_model.modules.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends TestBase {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@id='signup_link']")
	WebElement xTryItFree;
	
	public void ClickOnFreeButton() throws IOException {
		
		String actual_title = driver.getTitle();
		Assert.assertEquals(actual_title, "Login | Salesforce");
		test.log(LogStatus.PASS, "User has been redirected to the " + actual_title + " Application.");
		passLogStatus("User has been redirected to the " + actual_title + " Application.");
		
		//commonMethods.clickOnWebElementPass("xTryItFree", "Try It Free Button");
		xTryItFree.click();
		passLogStatus("Click on Try It Free Button");
	}

}
