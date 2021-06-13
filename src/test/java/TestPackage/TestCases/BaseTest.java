package TestPackage.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TestPackage.Pages.BasePage;
import TestPackage.Pages.HomePage;

public class BaseTest {
	WebDriver driver;
	BasePage basePage = new BasePage();
	HomePage homePage;

	@Test
	public void baseTest() {
		driver = basePage.launchApp("chrome");
		homePage = PageFactory.initElements(driver, HomePage.class);
		System.out.println(driver.getTitle());
		homePage.waitFor(5);
		homePage.enterSearchKeyword("Imran Khan");
		homePage.waitFor(5);
		basePage.quitApp(driver);
	}
}
