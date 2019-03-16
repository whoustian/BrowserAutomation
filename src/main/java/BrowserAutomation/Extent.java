package BrowserAutomation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent {

	public ExtentTest currentTest;

	public void createTest(String testName, String description) {
		ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		currentTest = extent.createTest(testName, description);
	}

}
