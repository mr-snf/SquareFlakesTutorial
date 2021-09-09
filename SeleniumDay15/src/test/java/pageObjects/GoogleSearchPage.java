package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

	WebDriver driver;

	@FindBy(name = "q")
	WebElement txtSearch;

	@FindBy(className = "UUbT9")
	WebElement divSearchSuggestions;

	@FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a")
	WebElement linkFirstResult;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSearchBox() {
		txtSearch.click();
	}

	public void setSearchText(String keyword) {
		txtSearch.sendKeys(keyword);
	}

	public void searchText(String keyword) throws InterruptedException {
		txtSearch.sendKeys(keyword + Keys.ENTER);
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "T");

//		txtSearch.sendKeys(Keys.CONTROL + "A");
//		txtSearch.sendKeys(Keys.CONTROL + "X");
//		txtSearch.sendKeys(Keys.CONTROL + "V");
//		txtSearch.sendKeys(Keys.CONTROL + "V");
//		Actions actions = new Actions(driver);
//		actions.sendKeys(txtSearch, Keys.SEMICOLON);
//		actions.keyDown(Keys.CONTROL);
//		actions.sendKeys("A");
//		actions.keyUp(Keys.CONTROL);
//		Thread.sleep(2000);
//		actions.keyDown(Keys.SHIFT);
//		actions.sendKeys(keyword);
//		actions.keyUp(Keys.SHIFT);
//		actions.keyDown(Keys.CONTROL);
//		actions.sendKeys("T");
//		actions.keyUp(Keys.CONTROL);
//		actions.build().perform();
//		Thread.sleep(2000);
//		actions.keyDown(Keys.CONTROL).build().perform();
//		linkFirstResult.click();
//		actions.keyUp(Keys.CONTROL).build().perform();
//		 actions.build().perform();
//		driver.switchTo().newWindow(WindowType.WINDOW);
	}

	public void clearSearchText() {
		txtSearch.clear();
	}

	public void validateSuggestion() {
		System.out.println("Attribute value: " + divSearchSuggestions.getAttribute("style"));
	}
}
