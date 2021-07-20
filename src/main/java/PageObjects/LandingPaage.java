package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPaage {
	
	public WebDriver driver;
	
	
	public LandingPaage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	By signin = By.cssSelector("a[class = 'ico-login']");
	By title = By.xpath("//h2[@class= 'topic-html-content-header']");
	By navbar = By.xpath("//div[@class= 'header-menu']");
	
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationbar()
	{
		return driver.findElement(navbar);
	}


}
