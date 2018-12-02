package BrowserAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Util {

	public static void type(By object, String input) {
		WebElement element = InitializeWebDriver.driver.findElement(object);
		element.sendKeys(input);
	}

	public static void click(By object) {
		WebElement element = InitializeWebDriver.driver.findElement(object);
		element.click();
	}

}
