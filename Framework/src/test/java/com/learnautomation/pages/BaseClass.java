package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass 
{
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;	
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{ 
		Reporter.log("Setting up the reports and Test is getting ready", true);   //Custom logs- we can user either Reporter.log or Log4J--Custom logs will appear in test NG Default html report Only if they are added in test case ,we have added in before suite hence wont appear in html report,wont appear in extent report
		
		excel= new ExcelDataProvider();									//Reports can also be generated by placing code in test ng listeners	
		config= new ConfigDataProvider();
		
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+ Helper.getCurrentDateTime() +".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	
		Reporter.log("Settings done and Test can be started", true); //true prints the log in console
	
	
	}
	
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser,String url)
	{
		
		Reporter.log("Trying to start Browser and getting application ready", true);
	//	driver =BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL()); // Basic example of abstraction
		
		driver =BrowserFactory.startApplication(driver, browser, url);   //Passing browser using maven parameters from pom 
		
		Reporter.log("Browser and application is up and running...", true);   // If above statement fails it wont generate this log, which means step failed here
	
	}
	

	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);						// Basic example of abstraction

	}
	
	@AfterMethod   
	public void tearDownMethod(ITestResult result) throws IOException  //@Aftermethod is very useful to take screenshot whether test fails or passes.Inside method we are using ITestResult interface.What this interface will do is as soon as we complete the test, the variable result will have all the info
	{
		
		Reporter.log("Test is about to end", true);
		
		
		if(result.getStatus()==ITestResult.FAILURE)     //condition to get screenshots when test fails
		{	 
		logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if (result.getStatus()==ITestResult.SKIP)  // Not all companies prefer screenshot for skip tests so one can avoid
		{
			logger.skip("Test Skipped ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();   // e.g if 5 tcs, report.flush will keep adding data to the report
		
		
		Reporter.log("Test Complete >>> Reports generated", true);
	}
	
	
}
