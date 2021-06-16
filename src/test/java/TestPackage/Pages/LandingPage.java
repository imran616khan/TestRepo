package TestPackage.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
	WebDriver driver;
	@FindBy(css = "[class='col mt-4']") WebElement landingPageMoviesContainer;
	@FindBy(css = "[alt=\"Gulliver's Travels\"]") WebElement movie;
	@FindBy(css = "[class='ng-untouched ng-pristine ng-valid']") WebElement moviesDetailsContainer;
	@FindBy(css = "[class='form-control form-control-sm mb-2 mr-2 ng-untouched ng-pristine ng-valid']") WebElement searchTextBox;
	@FindBy(css = "[class='img-fluid shadow-lg rounded']") WebElement searchResult;
	@FindBy(css = "[class='btn btn-outline-primary btn-sm mb-2']") WebElement searchIcon;
	@FindBy(css = "[aria-label='pagination']") WebElement moviePages;
	@FindBy(css = "[class='page-item']") WebElement inactivePage;

	public LandingPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	public boolean verifyLandingPage() {
		return landingPageMoviesContainer.isDisplayed();
	}
	
	public boolean selectMovie() {
		movie.click();
		waitFor(2);
		return moviesDetailsContainer.isDisplayed();
	}
	
	public String searchGivenKeyword(String keyword) {
		searchTextBox.click();
		searchTextBox.sendKeys(keyword);
		waitFor(2);
		searchIcon.click();
		waitFor(5);
		return searchResult.getAttribute("alt");
	}
	
	public boolean isPaginationAvailable() {
		return moviePages.isDisplayed();
	}
	
	public boolean verifyPagination() {
		boolean isPaginationWorking = false;
		String existingPageFirstAsset = searchResult.getAttribute("alt");
		inactivePage.click();
		waitFor(2);
		String newPageFirstAsset = searchResult.getAttribute("alt");
		if(existingPageFirstAsset != null && newPageFirstAsset != null) {
			if(!existingPageFirstAsset.equalsIgnoreCase(newPageFirstAsset)) {
				isPaginationWorking = true;
			}
		}
		return isPaginationWorking;
	}

}
