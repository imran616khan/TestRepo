package TestPackage.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;
	@FindBy(name = "q") WebElement inputTextBox;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	public void enterSearchKeyword(String keyword) {
		inputTextBox.click();
		inputTextBox.sendKeys(keyword);
		inputTextBox.sendKeys(Keys.ENTER);
	}

}
