package TestPackage.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LandingPageTests extends BaseTest {
	
	@AfterMethod
	public void reloadLandingPage() {
		basePage.navigateToLandingPage();
		basePage.waitFor(2);
	}
	

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
	
	@Test(priority = 3)
	public void validateSearchingAnyMovie() {
		String searchKeyword = "The gold rush";
		logger = report.createTest("ValidateSearchingAnyMovie");
		logger.info("Starting to validate searching any movie");
		logger.info("Checking whether able to search any movie on landing page or not");
		Assert.assertTrue(landingPage.searchGivenKeyword(searchKeyword).equalsIgnoreCase(searchKeyword), "Failed to search movies on landing page");
		logger.pass("Test completed successfully");
	}
	
	@Test(priority = 4)
	public void validatePagination() {
		logger = report.createTest("ValidatePagination");
		logger.info("Starting to validate pagination on landing page");
		logger.info("Checking whether able to navigate through different pages on landing page or not");
		if(landingPage.isPaginationAvailable()) {
			Assert.assertTrue(landingPage.verifyPagination(), "Failed to navigate through different pages on landing page");
		} else {
			logger.skip("Pagination is not available on landing page");
		}
		logger.pass("Test completed successfully");
	}
	
	@Test(priority = 5)
	public void validateDeletingMovie() {
		logger = report.createTest("ValidateDeletingMovie");
		logger.info("Starting to validate deleting movie from landing page");
		logger.info("Checking whether able to delete movie from landing page or not");
		Assert.assertTrue(landingPage.deleteMovie(), "Failed to delete movie from landing page");
		logger.pass("Test completed successfully");
	}

}
