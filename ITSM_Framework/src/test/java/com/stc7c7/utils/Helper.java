package com.stc7c7.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Helper 
{
	public static String captureScreenshot(WebDriver driver,String screenshotName)
	{
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"./screenshots/"+screenshotName+".png";
		
		try {
			FileHandler.copy(screenshot, new File(screenshotPath));
			//FileHandler.copy(screenshot, new File("./screenshots/"+screenshotName+"_"+getCurrentDateTime()+".png"));
			System.out.println("Screenshot Captured");
		} catch (IOException e) {
			System.out.println("Unable to take Screenshot" + e.getMessage());
		}
		
		return screenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss");
		
		return dateFormat.format( new Date());
		
	}
}

