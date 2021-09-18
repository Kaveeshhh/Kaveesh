package com.Framework.libraries;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.scanwell.commands.Commands;


// TC_001 to TC_004 // login validation and menus 

public class LIB_BasicActivities extends Commands {

	//login details and validation 
	public void login(String Username, String Password, String status) throws IOException {
		
		type("//input[@id = 'username']", Username);
		type("//input[@id = 'password']", Password);
		click("text", "Login");
		pause(5000);
		
		switch (status) {
		case "true":
			checkElementPresent("xpath", "//div[@class = 'box-header']");
			break;
		case "false":
			checkElementNotPresent("xpath", "//div[@class = 'box-header']");
		}
		//getScreenshot("xxx");

	}
	
	public void bc_SelectModuleMenu(String MenuItem) {
		click("text", MenuItem);

	}
	
	public void bc_SelectFeatureMenu(String MenuItem) {
		click("text", MenuItem);

	}
	
	
	
	
	
	
	}
