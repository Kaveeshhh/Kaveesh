package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scanwell.commands.Commands;

public class HomePage extends Commands{
	
	WebDriver driver;

	public HomePage()  {
			driver = getDriver();
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Chapter1']")
	public WebElement chapter1;
	
	@FindBy(xpath = "//a[text()='Chapter2']")
	public WebElement chapter2;
	
	
	

}
