package BrowserAutomation;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Runner {

	@Test
	public void run() {
		try {
			Process p = Runtime.getRuntime().exec(
					"cmd /c start C://Users//Will//workspace//BrowserAutomation//src//main//resources//init.bat", null,
					new File("C://Users//Will//workspace//BrowserAutomation"));
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
