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
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import ru.yandex.qatools.allure.annotations.Title;

@Title("Search for Something on Reddit")
public class SimpleTest {

	@Title("Search for Something on Reddit")
	@Description("This is a test about reddit searches")
	@Test
	public void runner() {
		try {
			searchOnReddit("Cats");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Open Reddit and Search for a word")
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

	@Attachment
	@Step("Make screen shot of the current page")
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
		generateReport();
		openReportDirectory();
	}

	public static void openReportDirectory() {
		try {
			Desktop.getDesktop().open(new File("C://Users//Will//workspace//BrowserAutomation//target"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void generateReport() {
		try {
			Process p = Runtime.getRuntime().exec(
					"cmd /c start C://Users//Will//workspace//BrowserAutomation//src//main//resources//report.bat",
					null, new File("C://Users//Will//workspace//BrowserAutomation"));
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
