package BrowserAutomation;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Selenium.SeleniumWebDriver;

@RunWith(JUnit4.class)
public class TestClass {

	@Test
	public void runner() {
		try {
			testSomething();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testSomething() throws Exception {
		SeleniumWebDriver.goToUrl("https://www.reddit.com");
		makeScreenShot();
		Util.type(ObjectRepo.reddit_SearchBox, "Trump");
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
	}

}
