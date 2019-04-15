package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage 
{
	WebDriver driver;
	
	//This is new commit from Atul
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	@FindBy(how = How.NAME, using = "username1") 
	WebElement uname;
	
	@FindBy(how = How.NAME, using = "password") 
	WebElement pass;
	 
	@FindBy(how = How.XPATH, using = "//input[@value='Login']") 
	WebElement loginButton;
	
	
	public void loginToCRM(String usernameApplication, String passwordApplication) 
	{
		uname.sendKeys(usernameApplication);
		
		pass.sendKeys(passwordApplication);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
		}
				
		
		loginButton.click();
		
		
	}
	

}
