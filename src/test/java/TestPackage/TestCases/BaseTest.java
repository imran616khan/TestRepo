package TestPackage.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import TestPackage.Pages.BasePage;
import TestPackage.Pages.LandingPage;
import Utility.Helper;

public class BaseTest {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	BasePage basePage = new BasePage();
	LandingPage landingPage;

	@BeforeSuite
	public void setupExtentReport() {
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				"./TestReport/SampleReport_" + Helper.getCurrentDateAndTime() + ".html");
		report = new ExtentReports();
		report.attachReporter(extent);
		driver = basePage.launchApp("chrome");
		landingPage = PageFactory.initElements(driver, LandingPage.class);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Test Failed");
			logger.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		basePage.waitFor(2);
		report.flush();
	}

	@AfterSuite
	public void quitDriver() {
		basePage.quitApp(driver);
	}
}
