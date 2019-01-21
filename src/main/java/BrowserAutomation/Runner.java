package BrowserAutomation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.JUnit4TestAdapter;

@RunWith(JUnit4.class)
public class Runner {

	public static Test suite() {
		return (Test) new JUnit4TestAdapter(TestClass.class);
	}

}
