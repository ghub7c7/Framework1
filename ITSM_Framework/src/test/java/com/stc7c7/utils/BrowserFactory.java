package com.stc7c7.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory 
{
	static WebDriver driver;	
	public static WebDriver launchBrowser(String browser,String url)
	{
		if(browser.equals("Chrome"))
			driver = new ChromeDriver();
		else if(browser.equals("Firefox"))
			driver = new FirefoxDriver();
		else if(browser.equals("Edge"))
			driver = new EdgeDriver();
		else
			System.out.println("Framework doesn't support this browser");
		
		driver.get(url);
		driver.manage().window().maximize();		
		
		return driver;	
		
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
