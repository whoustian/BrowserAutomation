package BrowserAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Selenium.SeleniumWebDriver;

@RunWith(JUnit4.class)
public class TestClass {

	@Test
	public void runner() {
		try {
			ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File("C://AllResultsRepository//index.html"));
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			ExtentTest test = extent.createTest("MyFirstTest", "Test Description").pass("details");
			SeleniumWebDriver.goToUrl("https://www.reddit.com");
			test.pass("Went to URL")
					.addScreenCaptureFromPath("C://Users//Will//Pictures//UnderstandingTheBlueWhale_whale.png");
			Util.type(ObjectRepo.reddit_SearchBox, "Trump");
			test.pass("Search typed");
			extent.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ExtentTest createNewTest() {
		ExtentHtmlReporter avent = new ExtentHtmlReporter("C://ResultsRepository");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(avent);

		return extent.createTest("MyFirstTest", "Test Description").pass("details");

	}

	public static void testSomething() throws Exception {
		ExtentTest test = createNewTest();
		SeleniumWebDriver.goToUrl("https://www.reddit.com");
		test.pass("Went to URL");
		test.addScreenCaptureFromPath("reddit.png");
		Util.type(ObjectRepo.reddit_SearchBox, "Trump");
		test.pass("Search typed");
	}

	public static void takeScreenShot() {
		try {
			File scrFile = ((TakesScreenshot) SeleniumWebDriver.getDriver()).getScreenshotAs(OutputType.FILE);
			((TakesScreenshot) SeleniumWebDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void init() {
		BasicConfigurator.configure();
		SeleniumWebDriver.setUp();
	}

	@After
	public void finalize() {
		SeleniumWebDriver.closeBroswer();
	}

}
