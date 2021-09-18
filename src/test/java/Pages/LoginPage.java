package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Framework.libraries.Functions;

public class LoginPage extends Functions{
	
	WebDriver webDriver; 

	public LoginPage() {
		
		webDriver = getWebDriver();
		PageFactory.initElements(webDriver, this);
		
	}
	
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(xpath = "//*[@id='pass']")
	public WebElement password; 
	
	@FindBy(xpath = "//*[@type='submit']")
	public WebElement login;
	
	
	@FindBy(xpath = "//span[text()='Vegi Lanka']")
	public WebElement fbHeader;
	

}
