package BrowserAutomation;

import Selenium.SeleniumWebDriver;
import WebCrawlerPackage.Spider;

public class TestClass {

	public static void main(String[] Args) {

		Spider spider = new Spider();

		SeleniumWebDriver.setUp();
		SeleniumWebDriver.goToUrl("https://www.reddit.com");
		String currentUrl = SeleniumWebDriver.getCurrentUrl();

		spider.search(currentUrl, "Trump");

	}

}
