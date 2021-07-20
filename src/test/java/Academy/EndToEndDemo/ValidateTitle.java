package Academy.EndToEndDemo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPaage;
import PageObjects.LoginPage;
import resource.BaseClass;

public class ValidateTitle extends BaseClass {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void navigationbarValidation() throws IOException 
	{
		
		LandingPaage lp = new LandingPaage(driver);
		log.info("Landing opage Opened");
		//Compare the text from the browser with actual value, fail the script with error if there is  mismatch
		
		Assert.assertTrue(lp.getNavigationbar().isDisplayed());
}
	@AfterTest
	public void tesrDown()
	{
		driver.close();
	}

}
