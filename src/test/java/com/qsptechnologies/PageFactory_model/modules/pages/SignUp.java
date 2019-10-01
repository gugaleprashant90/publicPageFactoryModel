package com.qsptechnologies.PageFactory_model.modules.pages;


import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qsptechnologies.PageFactory_model.modules.commonMethods.commonMethods;
import com.qsptechnologies.PageFactory_model.modules.testBase.TestBase;

public class SignUp extends TestBase {
	WebDriver driver;
	
	public SignUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='signup_form_1-UserFirstName']")
	WebElement xFname;
	
	@FindBy(xpath = "//input[@id='signup_form_1-UserLastName']")
	WebElement xLname;
	
	@FindBy(xpath = "//select[@id='signup_form_1-UserTitle']")
	WebElement xjobTitle;
	
	@FindBy(xpath = "//input[@id='signup_form_1-UserEmail']")
	WebElement xEmailid;
	
	@FindBy(xpath = "//input[@id='signup_form_1-UserPhone']")
	WebElement xPhone;
	
	@FindBy(xpath = "//input[@id='signup_form_1-CompanyName']")
	WebElement xCompanyname;
	
	@FindBy(xpath = "//select[@id='signup_form_1-CompanyEmployees']")
	WebElement xEmployee;
	
	@FindBy(xpath = "//select[@id='signup_form_1-CompanyCountry']")
	WebElement xCountry;
	
	@FindBy(xpath = "//*[@id=\"signup_form_1\"]/div[8]/div/div[1]/div[1]")
	WebElement xTurmAndCondition;
	
	@FindBy(xpath = "//button[@name='Start free trial']")
	WebElement xSubmit;
	
	public void createAnAccount(Hashtable<String, String> testData) throws IOException {
		//commonMethods.sendkeys("xFname", testData.get("First_Name"), "First Name");
		xFname.sendKeys(testData.get("First_Name"));
		passLogStatus("First Name Has been Entered");
		
		//commonMethods.sendkeys("xLname", testData.get("Last_Name"), "Last Name");
		xLname.sendKeys(testData.get("Last_Name"));
		passLogStatus("Last Name Has been Entered");
		
		//commonMethods.selectDropDownByValue("xjobTitle", "IT_Manager_AP", "Job Title");
		commonMethods.selectDropDownByValue(xjobTitle, "IT_Manager_AP", "Job Title");
		
		//commonMethods.sendkeys("xEmailid", testData.get("Email_ID"), "Email ID");
		xEmailid.sendKeys(testData.get("Email_ID"));
		passLogStatus("Email ID Has been Entered");
		
		//commonMethods.sendkeys("xPhone", testData.get("Phone_Number"), "Phone Number");
		xPhone.sendKeys(testData.get("Phone_Number"));
		passLogStatus("Phone Number Has been Entered");
		
		//commonMethods.sendkeys("xCompanyname", testData.get("Company_Name"), "Company Name");
		xCompanyname.sendKeys(testData.get("Company_Name"));
		passLogStatus("Company Name Has been Entered");
		
		//commonMethods.selectDropDownByValue("xEmployee", "250", "Employee");
		commonMethods.selectDropDownByValue(xEmployee, "250", "Employee");
		
		//commonMethods.selectDropDownByValue("xCountry", "IN", "Country");
		commonMethods.selectDropDownByValue(xCountry, "IN", "Country");
		
		//commonMethods.selectDropDownByValue("xState", "Maharashtra", "State");
		
		//commonMethods.clickOnWebElementPass("xTurmAndCondition", "Turms And Condition");
		xTurmAndCondition.click();
		passLogStatus("Click on Turms And Condition");
		
		//commonMethods.clickOnWebElementPass("xSubmit", "Submit Button");
		xSubmit.click();
		passLogStatus("Click on Submit Button");
		
	}
	
}
