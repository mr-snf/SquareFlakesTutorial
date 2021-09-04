package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

	@FindBy(name = "q")
	WebElement txtSearch;

	@FindBy(className = "UUbT9")
	WebElement divSearchSuggestions;

	public GoogleSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickSearchBox() {
		txtSearch.click();
	}

	public void setSearchText(String keyword) {
		txtSearch.sendKeys(keyword);
	}

	public void clearSearchText() {
		txtSearch.clear();
	}

	public void validateSuggestion() {
		System.out.println("Attribute value: " + divSearchSuggestions.getAttribute("style"));
	}
}
