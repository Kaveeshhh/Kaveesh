package com.Framework.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Functions {
	
	static WebDriver webDriver = null;


	public void setWebDriver() {
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
		
		// System Property for Chrome Driver   
//	    System.setProperty("webdriver.chrome.driver","/home/kaveesh/Downloads/AutomatioFramework/AutomatioFramework/src/main/resources/chromedriver");  
//	    ChromeOptions options = new ChromeOptions();
//	    options.addArguments("start-maximized"); // open Browser in maximized mode
//	    options.addArguments("disable-infobars"); // disabling infobars
//	    options.addArguments("--disable-extensions"); // disabling extensions
//	    options.addArguments("--disable-gpu"); // applicable to windows os only
//	    options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//	    options.addArguments("--no-sandbox"); // Bypass OS security model
//	       // Instantiate a ChromeDriver class.       
//	    webDriver=new ChromeDriver(options);  
		
		
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	public void  quit() {
		webDriver.quit();
	}
	
	
	public void login(String UserName,String Password) {
		LoginPage loginPage = new LoginPage();
		webDriver.get("https://www.facebook.com/");
		loginPage.email.sendKeys(UserName);
		loginPage.password.sendKeys(Password);
		loginPage.login.click();
		
		Assert.assertEquals(loginPage.fbHeader.getText(), "Vegi Lanka");
		
		
	}

}
