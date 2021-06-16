package TestPackage.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	WebDriver driver;

	public WebDriver launchApp(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Executables/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://3.134.135.231:4000/");
		waitFor(5);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public void quitApp(WebDriver driver) {
		driver.quit();
	}

	public void waitFor(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
