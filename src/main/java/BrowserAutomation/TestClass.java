package BrowserAutomation;

import WebCrawlerPackage.Spider;

public class TestClass {

	public static void main(String[] Args) {

		Spider spider = new Spider();

		InitializeWebDriver.setUp();
		InitializeWebDriver.goToUrl("https://www.reddit.com");
		String currentUrl = InitializeWebDriver.getCurrentUrl();

		spider.search(currentUrl, "Trump");

	}

}
