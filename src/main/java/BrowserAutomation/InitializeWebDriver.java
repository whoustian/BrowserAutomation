package BrowserAutomation;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializeWebDriver {

	static WebDriver driver;

	@Before
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserAutomation\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void goToUrl(String url) {
		driver.get(url);
	}

	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@After
	public static void closeBroswer() {
		driver.quit();
	}

}
