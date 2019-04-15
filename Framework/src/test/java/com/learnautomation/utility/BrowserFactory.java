package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{

	WebDriver driver;
	
	public static WebDriver startApplication(WebDriver driver,String browserName, String appURL)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		else
		{
			System.out.println("We do not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appURL);
		
		
		return driver;
		
	}
	
	
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	
	
}
