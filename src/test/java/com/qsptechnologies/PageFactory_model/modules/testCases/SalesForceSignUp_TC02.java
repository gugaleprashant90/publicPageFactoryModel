package com.qsptechnologies.PageFactory_model.modules.testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qsptechnologies.PageFactory_model.modules.pages.HomePage;
import com.qsptechnologies.PageFactory_model.modules.pages.SignUp2;
import com.qsptechnologies.PageFactory_model.modules.testBase.TestBase;


public class SalesForceSignUp_TC02 extends TestBase {
	
	@BeforeClass
	public static void isSkip() {
		if (!isExecutable("tc02_SalesForceSignUp")) {
			throw new SkipException("Skipping Test case as it's Run Mode is set to N");
		}
	}
	
	@Test(dataProvider="Data_Collections")
	public static void tc02_SalesForceSignUp(Hashtable <String, String> testData) throws IOException, InterruptedException {
	
		//LaunchBrowsers();
		//HomePage.ClickOnFreeButton();
		//SignUp2.createAnAccount(testData);
		
		HomePage home = new HomePage(driver);
		home.ClickOnFreeButton();
		
		SignUp2 signup2 = new SignUp2(driver);
		signup2.createAnAccount(testData);
		//closeBrowser();
		
	}

}
