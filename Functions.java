package com.Framework.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Functions {
	
	static WebDriver webDriver;

	public Functions() {
		
	}

	public void setWebDriver() {
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
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
