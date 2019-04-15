package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider 
{
	
	Properties pro;
	
	public ConfigDataProvider()   							//Constructor helps us to initialize variables and objects --
	{
	File src = new File("./Config/Config.properties");
	
	try {
		FileInputStream fis = new FileInputStream(src);
		pro= new Properties();
		pro.load(fis);
	} catch (Exception e) {
		System.out.println("Not able to load config file "+e.getMessage() );
	}
 }

	public String getDataFromConfig(String keyToSearch)   //method generic to take the key to search and returns same
	{
		return pro.getProperty(keyToSearch);
	}
	
	public String getBrowser()   				//two key value pairs browser and url in config file hence 2 methods
	{
		return pro.getProperty("Browser");
	}
	
	public String getStagingURL()
	{
		return pro.getProperty("qaURL");
		
	}
	
	
	
	
	

}
