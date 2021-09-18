package com.Framework.testsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Framework.libraries.Functions;

public class TC_001 extends Functions{

	//Functions functions = new Functions();

	@BeforeTest
	public void setup() {
		setWebDriver();
	}

	@Test
	public void setCap() {
		login("vegilanka@gmail.com", "Vegi@123");
	}

	@AfterTest
	public void quitDriver() {
		quit();
	}

}
