package com.stc7c7.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.stc7c7.utils.AppConstants;
import com.stc7c7.utils.BrowserFactory;
import com.stc7c7.utils.ConfigDataProvider;
import com.stc7c7.utils.Helper;

public class BaseTest 
{
	public static WebDriver driver;
	
	ConfigDataProvider config = new ConfigDataProvider();
	
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter spark; 
	public static ExtentTest extentLog;
	public static String reportName;
	public static String screenshotPath;
	
	
	@BeforeClass
	public void startApp()
	{		
		System.out.println("Starting Application");
		
		
		String browser = config.readProperty(AppConstants.browser);
		String url = config.readProperty(AppConstants.url);
		
		driver = BrowserFactory.launchBrowser(browser,url);
		
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void quitApp()
	{
		driver.quit();
		System.out.println("Application Quit");
	}
	
	@AfterMethod
	public void captureScreen(ITestResult result)
	{
		screenshotPath = Helper.captureScreenshot(driver, driver.getTitle());
		
		String methodName= result.getMethod().getMethodName();
		String className =  result.getMethod().toString();
		
		System.out.println("Mehtod Name : "+ methodName);
		
		reportName=className.substring(0,className.indexOf('.'));
		
		spark = new ExtentSparkReporter("./reports/"+reportName+"Report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ITSM Automation "+ reportName + " Report");
		spark.config().setReportName(reportName+" Report");
		extent.attachReporter(spark);
		
		extentLog = extent.createTest(reportName); // Create a test node in the report
		extentLog.assignAuthor("Asif").assignCategory("Regression").assignDevice("Chrome");
		extentLog.info(reportName+" Started"); // Create a test step node in the report
		//extentLog.info("Url is loaded");
		//extentLog.info("Values entered");
		//extentLog.pass("Login Test completed successfully"); 
		
		//extentLog.fail("Test Failed");
		//Removed debug,fatal, error to match JUnit or TestNG
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentLog.pass(methodName + " Passed"); 
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			extentLog.fail(methodName + " Failed"); 
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			extentLog.skip(methodName + " Skip"); 
		}
		
		extent.flush();
	}
	


}
