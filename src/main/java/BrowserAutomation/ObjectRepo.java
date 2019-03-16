package BrowserAutomation;

import org.openqa.selenium.By;

import Selenium.PageObject;

public class ObjectRepo {

	public static final By amazon_SearchBox = By.id("twotabsearchtextbox");
	public static final By amazon_SearchButton = By.xpath("(//*[@type='submit'])[1]");
	public static final By reddit_SearchButton = By.xpath("//*[@class='zhmseh-2 hlMkrE']");
	public static final PageObject reddit_SearchBox = new PageObject(By.id("header-search-bar"), "Text Input Box");
	

}
