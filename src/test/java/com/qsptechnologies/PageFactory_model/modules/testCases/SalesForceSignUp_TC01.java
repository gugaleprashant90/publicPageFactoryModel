package com.qsptechnologies.PageFactory_model.modules.testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qsptechnologies.PageFactory_model.modules.pages.HomePage;
import com.qsptechnologies.PageFactory_model.modules.pages.SignUp;
import com.qsptechnologies.PageFactory_model.modules.testBase.TestBase;

public class SalesForceSignUp_TC01 extends TestBase {
	
	@BeforeClass
	public static void isSkip() {
		if (!isExecutable("tc01_SalesForceSignUp")) {
			throw new SkipException("Skipping Test case as it's Run Mode is set to N");
		}
	}
	
	@Test(dataProvider="Data_Collections")
	public static void tc01_SalesForceSignUp(Hashtable <String, String> testData) throws IOException, InterruptedException {
	
		//LaunchBrowsers();
		//HomePage.ClickOnFreeButton();
		//SignUp.createAnAccount(testData);
		
		HomePage home = new HomePage(driver);
		home.ClickOnFreeButton();
		
		SignUp signup = new SignUp(driver);
		signup.createAnAccount(testData);
		//closeBrowser();
		
	}

}
