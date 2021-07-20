package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
public WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	By email_Field = By.cssSelector("input[class = 'email']");
	By password = By.cssSelector("input[class = 'password']");
	By login = By.cssSelector("input[type = 'submit']");
	
	public WebElement getEmail()
	{
		return driver.findElement(email_Field);
		
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
		
	}
	
	public WebElement loginClick()
	{
		return driver.findElement(login);
		
	}

}
