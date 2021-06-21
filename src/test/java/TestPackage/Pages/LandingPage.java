package TestPackage.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
	WebDriver driver;
	@FindBy(css = "[class='col mt-4']") WebElement landingPageMoviesContainer;
	@FindBy(css = "[alt='A Farewell to Arms']") WebElement movie;
	@FindBy(css = "[class='ng-untouched ng-pristine ng-valid']") WebElement moviesDetailsContainer;
	@FindBy(css = "[class='form-control form-control-sm mb-2 mr-2 ng-untouched ng-pristine ng-valid']") WebElement searchTextBox;
	@FindBy(css = "[class='img-fluid shadow-lg rounded']") WebElement searchResult;
	@FindBy(css = "[class='btn btn-outline-primary btn-sm mb-2']") WebElement searchIcon;
	@FindBy(css = "[aria-label='pagination']") WebElement moviePages;
	@FindBy(css = "[class='page-item']") WebElement inactivePage;
	@FindBy(css = "[for='name']+input") WebElement name;
	@FindBy(css = "[for='fileName']+input") WebElement fileName;
	@FindBy(css = "[for='releaseDate']+input") WebElement releaseDate;
	@FindBy(css = "[id='wikipediaLink']") WebElement wikipediaLink;
	@FindBy(css = "[id='movie']") WebElement movieCheckbox;
	@FindBy(css = "[class='fas fa-trash-alt fa-lg']") WebElement deleteIcon;
	@FindBy(css = "[class='fas fa-save fa-lg']") WebElement saveIcon;
	@FindBy(css = "[class='fas fa-plus fa-lg']") WebElement addIcon;
	@FindBy(css = "[class='text-secondary']") WebElement totalMovies;
	@FindBy(css = "[class='fas fa-plus fa-lg mr-2']") WebElement createNewMovie;
	
	String movieName = "A Farewell to Arms";
	String movieFileName = "A_Farewell_to_Arms_(1932_film).jpg";
	String movieReleaseDate = "12/08/1932";
	String movieWikipediaLink = "A_Farewell_to_Arms_(1932_film)";
	
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
	
	public boolean deleteMovie() {
		String totalMoviesInStringBeforeDeleting = totalMovies.getText().split(" ")[0];
		int totalMoviesInIntegerBeforeDeleting = Integer.parseInt(totalMoviesInStringBeforeDeleting);
		selectMovie();
		deleteIcon.click();
		waitFor(2);
		driver.get("http://3.134.135.231:4000/");
		waitFor(2);
		String totalMoviesInStringAfterDeleting = totalMovies.getText().split(" ")[0];
		int totalMoviesInIntegerAfterDeleting = Integer.parseInt(totalMoviesInStringAfterDeleting);
		return (totalMoviesInIntegerBeforeDeleting - totalMoviesInIntegerAfterDeleting) == 1;
	}

}
