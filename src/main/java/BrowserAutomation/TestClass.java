package BrowserAutomation;

import WebCrawlerPackage.Spider;

public class TestClass {

	public static void main(String[] Args) {

		Spider spider = new Spider();

		InitializeWebDriver.setUp();
		InitializeWebDriver.goToUrl("https://www.amazon.com");
		Util.type(ObjectRepo.amazonSearchBox, "VR");
		Util.click(ObjectRepo.amazonSearchButton);
		String currentUrl = InitializeWebDriver.getCurrentUrl();
		
		spider.search(currentUrl, "Oculus");

	}

}
