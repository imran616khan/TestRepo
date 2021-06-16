package TestPackage.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
	WebDriver driver;
	@FindBy(css = "[class='col mt-4']") WebElement landingPageMoviesContainer;
	@FindBy(css = "[alt=\"Gulliver's Travels\"]") WebElement movie;
	@FindBy(css = "[class='ng-untouched ng-pristine ng-valid']") WebElement moviesDetailsContainer;

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

}
