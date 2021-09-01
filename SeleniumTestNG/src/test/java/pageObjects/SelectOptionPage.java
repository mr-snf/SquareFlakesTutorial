package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectOptionPage {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[9]/a")
	WebElement linkSEO;

	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[9]/ul")
	WebElement menuPages;

	public SelectOptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSEOMenu() {
		linkSEO.click();
	}

	public void usePageMenus() {
		Select pageOptions = new Select(menuPages);
		System.out.println(pageOptions.getOptions());
	}

}
