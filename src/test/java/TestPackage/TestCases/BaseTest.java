package TestPackage.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestPackage.Pages.BasePage;

public class BaseTest {
	WebDriver driver;
	BasePage basePage = new BasePage();

	@Test
	public void baseTest() {
		driver = basePage.launchApp("chrome");
		System.out.println(driver.getTitle());
		basePage.quitApp(driver);
	}
}
