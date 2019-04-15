package com.learnautomation.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class LoginTestCRM extends BaseClass 
{
	
	
	@Test
	public void loginApp() 
	{ 		 
		logger=report.createTest("Login to CRM");
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);    //RHS returns object of same class
		
		logger.info("Starting Application");
		
		loginpage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));   // Basic example of abstraction as std defn says " Showing the essential features and hiding the bg details"
			 
		logger.pass("Login Success");
		
	}
	

	

}
