package Test;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BrowserAutomation.ObjectRepo;
import BrowserAutomation.Util;
import Selenium.SeleniumWebDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class SimpleTest {
	
	@Description("This is a test")
	@Test
	public void runner() {
		try {
			testSomething();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Open Reddit and Search for a word")
	public static void testSomething() throws Exception {
		SeleniumWebDriver.goToUrl("https://www.reddit.com");
		makeScreenShot();
		Util.type(ObjectRepo.reddit_SearchBar, "Trump");
	}

	@Attachment
	@Step("Make screen shot of results page")
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
	}
}