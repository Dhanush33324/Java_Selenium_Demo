package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendedReporterNG {
	static ExtentReports extent;
	
	public static ExtentReports getReportObjet()
	{
		// ExtentReports and ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Resuts");
		reporter.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);  
		extent.setSystemInfo("Tester", "Dhanush");
		return extent;
	}

}
