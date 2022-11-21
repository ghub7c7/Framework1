package com.stc7c7.testcases;


import com.stc7c7.pages.LoginPage;
import com.stc7c7.utils.AppConstants;
import com.stc7c7.utils.EnDecryptor7c7;
import com.stc7c7.utils.ReadExcelFile;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest
{	
	//LoginPage login = new LoginPage(driver); 
	
		
	@Test	
	public void validateLogin() throws InterruptedException
	//public void validateLogin(String username,String password)
	{	
		String exlPath = System.getProperty("user.dir")+ config.readProperty(AppConstants.exlPath);
		String title;
		//reportName = "LoginTestReport";
		ReadExcelFile  readExcelFile = new ReadExcelFile(exlPath);
		
//		int rows = readExcelFile.getRowCount(0);
//		System.out.println(rows);
//		
//		String username = readExcelFile.getData(0, 1, 0);
//		String password = EnDecryptor7c7.decrypt(readExcelFile.getData(0, 1, 1));
//		System.out.println(username);
//		System.out.println(password);
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		//login.enterUsername(username);
		//login.enterPassword(password);
		//login.loginToCRM(username, password);
		
		
		
		login.loginToApp(readExcelFile.getData(0, 1, 0), EnDecryptor7c7.decrypt(readExcelFile.getData(0, 1, 1)));
		Thread.sleep(3000);
		title=driver.getTitle();
		System.out.println(title);	
		
		
	
	}
	
	
	
}
