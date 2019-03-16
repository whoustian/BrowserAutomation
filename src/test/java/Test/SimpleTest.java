package Test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import BrowserAutomation.ObjectRepo;
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
		ObjectRepo.reddit_SearchBox.setValue(keyword);
		ObjectRepo.reddit_SearchBox.sendKeys(Keys.ENTER);
	}

	@Before
	public void init() {
		BasicConfigurator.configure();
		SeleniumWebDriver.setUp();
	}

	@After
	public void finalize() {
		SeleniumWebDriver.closeBrowser();
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
