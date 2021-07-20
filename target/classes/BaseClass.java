package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import org.apache.commons.io.FileUtils; 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
public WebDriver driver;
public Properties prop;	
	public WebDriver initializeDriver() throws IOException 
	{
		//Chrome
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Java\\EndToEndDemo\\src\\main\\java\\resource\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		//Chrome
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		//Firefox
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Desktop\\geckodriver.exe");
			 driver = new FirefoxDriver();
			
		}
		
		else if(browserName.equals("IE"))
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public  String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}
