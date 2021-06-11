package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

	public static void main(String[] args) {
		System.out.println("Hi world");
		System.setProperty("webdriver.chrome.driver", "./Executables/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

}
