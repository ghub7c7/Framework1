package com.stc7c7.pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage 
{
	protected WebDriver driver;
//	private By txt_username = By.cssSelector("input[name='email']");	//By.id("name");
//	private By txt_password = By.cssSelector("input[name='password']"); //By.id("password");
//	private By btn_login =  By.xpath("//div[text()='Login']"); //By.id("login");
	
	@FindBy(css="input[name='email']")
	@CacheLookup
	WebElement txt_username;
	
	@FindBy(css="input[name='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement btn_login;
	
	public LoginPage(WebDriver mydriver)
	{
		this.driver = mydriver;
		AjaxElementLocatorFactory  aELFactory = new AjaxElementLocatorFactory(driver,30);
		PageFactory.initElements(aELFactory,this);
	}
	
//	public void enterUsername(String username)
//	{
//		//driver.findElement(txt_username).sendKeys(username);
//		
//	}
//	
//	public void enterPassword(String password)
//	{
//		//driver.findElement(txt_password).sendKeys(password);
//		
//	}
	
	public void loginToApp(String username,String password)
	{
		/*driver.findElement(btn_login).click();		
		Actions actions = new Actions(driver);
		System.out.println("click_on_submitt_button");
		actions.moveToElement(driver.findElement(btn_login));
		actions.click();		
		actions.build().perform(); */
		
		txt_username.sendKeys(username);
		txt_password.sendKeys(password);
		btn_login.click();
	}
	

}
