package TestPackage.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import TestPackage.Pages.BasePage;
import TestPackage.Pages.HomePage;
import Utility.Helper;

public class BaseTest {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	BasePage basePage = new BasePage();
	HomePage homePage;

	@BeforeSuite
	public void setupSuite() {
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				"./TestReport/SampleReport_" + Helper.getCurrentDateAndTime() + ".html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@Test
	public void baseTest() {
		logger = report.createTest("Search Test");
		logger.info("Launching Google Chrome");
		driver = basePage.launchApp("chrome");
		homePage = PageFactory.initElements(driver, HomePage.class);
		logger.info("Getting page title");
		System.out.println(driver.getTitle());
		homePage.waitFor(5);
		homePage.enterSearchKeyword("Husna");
		homePage.waitFor(5);
		logger.pass("Test completed successfully");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.INFO, "Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		basePage.waitFor(5);
		report.flush();
		basePage.quitApp(driver);
	}
}
