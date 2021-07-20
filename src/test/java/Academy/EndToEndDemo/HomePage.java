package Academy.EndToEndDemo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPaage;
import PageObjects.LoginPage;
import resource.BaseClass;

public class HomePage extends BaseClass {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		
	}
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password)
	{
		
		driver.get(prop.getProperty("url"));
		LandingPaage lp = new LandingPaage(driver);
		log.info("Navigatge to home page");
		lp.getLogin().click();
		LoginPage lop = new LoginPage(driver);
		lop.getEmail().sendKeys(username);
		lop.getPassword().sendKeys(password);
		log.info("");
}
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many data is given
		// Column no of values for each test
		Object[][] data = new Object[2][2];
		data[0][0]= "aa@mm.com";
		data[0][1]="password1";
		
		data[1][0] = "bb@mm.com";
		data[1][1]= "password2";
		
		return data;
		
	}
	
	@AfterTest
	public void tesrDown()
	{
		driver.close();
	}
}
