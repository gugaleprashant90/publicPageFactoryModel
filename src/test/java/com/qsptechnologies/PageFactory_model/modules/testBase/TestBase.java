package com.qsptechnologies.PageFactory_model.modules.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.AutomationWorldByRahul.SeleniumTraining.DataCollection;
import com.AutomationWorldByRahul.SeleniumTraining.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	public static WebDriver driver;
	public static Properties config;
	
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Hashtable<String , String> testCaseRunMode = new Hashtable<String , String>();
    public static String testCaseName,skip;
	
	@BeforeSuite
	public static void loadingFiles() throws IOException {
		config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\propertiesFile\\config.properties");
		config.load(fis);
			
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());	
		extent = new ExtentReports(System.getProperty("user.dir")+ "\\src\\test\\resources\\execution_Report\\" +"ExecutionReport_"+timeStamp+".html");
	
		loadHashTable(testCaseRunMode, "Test_Cases", "TestCaseName", "Run_Mode");
	}
	
	
	//@BeforeMethod
	public static void LaunchBrowsers() {
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\LatestEclipseData\\FrameWorkTest27_sep\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (config.getProperty("Browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		System.out.println("Browser Launched Successfully ...");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		test = extent.startTest(testCaseName);
		driver.get(config.getProperty("Application_URL"));
	}
	
	
	public static void takeScreenshot() throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String timeStamp = new SimpleDateFormat("YYYY.MM.DD.HH.mm.ss").format(new Date());
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\src\\test\\resources\\screenshot\\Screenshot_"+timeStamp+".png";
		File desFile = new File(reportDirectory);
		
		FileHandler.copy(srcFile, desFile);
		
		test.log(LogStatus.PASS, test.addScreenCapture(reportDirectory));
		Reporter.log("<a href='" + desFile + "'> <img src='" + desFile
				+ "' height='100' width='100'/> </a>");
	}
	
	//Method For Loading Run Mode into HashTable as Key And value 
	public static void loadHashTable(Hashtable<String, String> testCaseRunMode ,String SheetName, String KeyColName, String valueColName) {
		int row = excel.getRowCount(SheetName);
		for (int i=2;i<=row;i++) {
			String key = excel.getCellData(SheetName, KeyColName, i);
			String value = excel.getCellData(SheetName, valueColName, i);
			testCaseRunMode.put(key, value);
		}	
		System.out.println(testCaseRunMode);
	}
	
	//To Check Run Mode Y/N
	public static boolean isExecutable(String TC_name) {
		testCaseName = TC_name;
		if(testCaseRunMode.get(testCaseName).equalsIgnoreCase("Y")) {
			skip = "No";
			return true;	
		}
		else {
			skip = "Yes";
			 return false;
		}	
	} 
	
	@DataProvider 	
	public static Object[][] Data_Collections() {
		DataCollection dc = new DataCollection(excel, "Test_Data",testCaseName );
		return dc.dataArray();	
	}
	
	//@AfterMethod
	public static void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public static void writeIntoExtentReport() throws InterruptedException {		
		extent.endTest(test);
		extent.flush();
		
	}
	
	public static void passLogStatus(String logStatusDetails) throws IOException {
		test.log(LogStatus.PASS, logStatusDetails);
		takeScreenshot();
		Reporter.log(logStatusDetails);		
	}

}
