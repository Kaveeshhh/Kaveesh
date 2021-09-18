package com.scanwell.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Commands2 {

	public static WebDriver driver;
	public Properties prop;

	// set URL
	public WebDriver initializeDriver() throws IOException {

		try {
			FileInputStream propertyfFile = new FileInputStream("src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "config.properties");
			prop = new Properties();
			prop.load(propertyfFile);
			switch (prop.getProperty("BROWSER")) {
			case "CHROME":
				String os = System.getProperty("os.name").toLowerCase();
				File file = null;
				if (os.indexOf("windows") >= 0) {
					file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator
							+ "chromedriver.exe");
					System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				} else if (os.indexOf("mac") >= 0) {
					file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator
							+ "chromedriver_mac");
					Runtime.getRuntime().exec("chmod 777 " + file.getAbsolutePath());
					System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				} else {
					//throw new Exception("undefined os type detected");
					file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator
							+ "chromedriver");
					System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				}
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(prop.getProperty("url"));
				break;
			case "FIREFOX":
				System.out.println("Driver is not yet set");
				break;

			case "IE":
				System.out.println("Driver is not yet set");
				break;

			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return driver;

	}

	// click method(we can use xpath or text)
	public void click(String key, String value) {
		switch (key) {
		case "text":
			driver.findElement(By.xpath("//*[text()='" + value + "']")).click();
			break;
		case "xpath":
			driver.findElement(By.xpath("" + value + "")).click();
			break;
		}
	}

	// insert data method
	public void type(String xpath, String value) {

		driver.findElement(By.xpath("" + xpath + "")).sendKeys("" + value + "");

	}

	// scroll a page
	public void Scroll(int pixel) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");

	}

	// wait method
	public void pause(long time) {

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);

	}

	// we can close our browser
	public void quit() {

		driver.quit();

	}

	// check element not present method (we can use xpath or text)
	public void checkElementNotPresent(String key, String value) {

		switch (key) {
		case "xpath":
			if (driver.findElements(By.xpath("" + value + "")).size() > 0) {
				Assert.fail(key + "is present");
			} else {

				System.out.println(key + " is not present");
			}
			break;
		case "text":

			if (driver.findElements(By.xpath("//*[text()='" + value + "']")).size() > 0) {
				Assert.fail(key + "is present");
			} else {

				System.out.println(key + " is not present");
			}
			break;
		}

	}

	// select drop down value
	public void select(String xpath, String option) {

		Select s2 = new Select(driver.findElement(By.xpath("" + xpath + "")));
		s2.selectByVisibleText("" + option + "");

	}

	// check element not present method
	public void checkElementPresent(String key, String value) {

		switch (key) {

		case "xpath":
			if (driver.findElements(By.xpath("" + value + "")).size() > 0) {
				System.out.println(key + " is present");
			} else {
				Assert.fail(key + "is not present");
			}
			break;
		case "text":

			if (driver.findElements(By.xpath("//*[text()='" + value + "']")).size() > 0) {
				System.out.println(key + " is present");
			} else {
				Assert.fail(key + " is not present");
			}
			break;
		}

	}

	// Get Element text value

	public String GetElementText(String xapthvalue) {

		return driver.findElement(By.xpath("" + xapthvalue + "")).getText();
	}

	public void KeyboardEnter() {

		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ENTER);

	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("src" + File.separator + "main" + File.separator + "resources" + File.separator
				+ "screenshots" + File.separator + result + "_screenshot.png"));

	}

}
