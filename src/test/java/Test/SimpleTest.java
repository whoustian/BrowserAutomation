package Test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BrowserAutomation.ObjectRepo;
import BrowserAutomation.Util;
import Selenium.SeleniumWebDriver;

public class SimpleTest {

	@Test
	public void runner() {
		try {
			searchOnReddit("Cats");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchOnReddit(String keyword) throws Exception {
		SeleniumWebDriver.goToUrl("https://www.reddit.com");
		Thread.sleep(2000);
		makeScreenShot();
		Util.type(ObjectRepo.reddit_SearchBox, keyword);
		Thread.sleep(2000);
		Util.sendKeys(ObjectRepo.reddit_SearchBox, Keys.ENTER);
		Thread.sleep(2000);
		makeScreenShot();
	}

	public static byte[] makeScreenShot() {
		return ((TakesScreenshot) SeleniumWebDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
	}

	@Before
	public void init() {
		BasicConfigurator.configure();
		SeleniumWebDriver.setUp();
	}

	@After
	public void finalize() {
		SeleniumWebDriver.closeBroswer();
		openReportDirectory();
	}

	public static void openReportDirectory() {
		try {
			Desktop.getDesktop().open(new File("C://Users//Will//workspace//BrowserAutomation//target"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
