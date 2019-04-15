package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper 
{
	//Suggestion -- keep all methods in this class as Static so we can directly use, or need to create object of helper class in base class n then use
	//Screenshots,Alerts,Frames,Windows,Sync issues, javascript executor 
	
	
public static String captureScreenshot(WebDriver driver)    //We are using webdriver reference coz this is exactly what helps us capture screenshot 
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //TakesScreenshot is a separate interface,which has one method as getScreenshotAs,and we have captured screenshot as a file
	String screenshotPath=System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+ getCurrentDateTime() +".png";
	
	
		try {
			FileHandler.copy(src, new File(screenshotPath));

			System.out.println("Screenshot Captured");

		} catch (IOException e) {
			System.out
					.println("Unable to capture screenshot " + e.getMessage());
		}
		
		return screenshotPath;
		
	}
	
public static String getCurrentDateTime()
{
	DateFormat customFormat =new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");  //Slash,space and : are sometimes not supported so replaced with underscore (pt to note MM and HH caps)
	
	Date currentDate = new Date();
	
	return customFormat.format(currentDate);
	
}




}
