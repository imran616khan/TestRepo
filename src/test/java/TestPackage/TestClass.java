package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {

	@Test
	public void testClass() {
		System.out.println("Hi world");
		System.setProperty("webdriver.chrome.driver", "./Executables/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

}
