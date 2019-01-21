package BrowserAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import Selenium.SeleniumWebDriver;

@RunWith(JUnit4.class)
public class Hooks {

	private List<String> list;

	@Before
	public void init() {
		BasicConfigurator.configure();
		SeleniumWebDriver.setUp();
		list = new ArrayList<>(Arrays.asList("test1", "test2"));
	}

	@After
	public void finalize() {
		list.clear();
	}
}
