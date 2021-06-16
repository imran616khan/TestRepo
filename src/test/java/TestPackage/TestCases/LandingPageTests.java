package TestPackage.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPageTests extends BaseTest {
	

	@Test(priority = 1)
	public void validateLandingPage() {
		logger = report.createTest("ValidateLandingPage");
		logger.info("Starting to validate landing page");	
		logger.info("Checking whether movies are displayed on landing page or not");
		Assert.assertTrue(landingPage.verifyLandingPage(), "Failed to display movies on landing page");
		logger.pass("Test completed successfully");
	}
	
	@Test(priority = 2)
	public void validateSelectingAnyMovie() {
		logger = report.createTest("ValidateSelectingAnyMovie");
		logger.info("Starting to validate selecting any movie");
		logger.info("Checking whether able to select any movie on landing page or not");
		Assert.assertTrue(landingPage.selectMovie(), "Failed to select movies on landing page");
		logger.pass("Test completed successfully");
	}

}
