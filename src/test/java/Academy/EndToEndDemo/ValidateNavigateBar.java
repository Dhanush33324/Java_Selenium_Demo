package Academy.EndToEndDemo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPaage;
import PageObjects.LoginPage;
import resource.BaseClass;

public class ValidateNavigateBar extends BaseClass {
	
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws IOException 
	{
	
		LandingPaage lp = new LandingPaage(driver);
		//Compare the text from the browser with actual value, fail the script with error if there is  mismatch
		Assert.assertEquals(lp.getTitle().getText(), "Wellllcome to our store");
}
	@AfterTest
	public void tesrDown()
	{
		driver.close();
	}

}
