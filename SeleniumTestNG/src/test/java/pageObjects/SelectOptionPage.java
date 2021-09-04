package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		System.out.println(menuPages.findElements(By.xpath("./li")).size()); // immediate children with li tag only
		System.out.println(menuPages.findElements(By.xpath("./*")).size()); // all immediate child
		menuPages.findElements(By.cssSelector("*")); // all children
		System.out.println(menuPages.findElements(By.tagName("li")).size()); // all children with li tag only
		System.out.println(menuPages.findElement(By.xpath(".."))); // gets parent element
	}

	public void usePageMenus() {
		List<WebElement> menuOptions = menuPages.findElements(By.tagName("li"));
		menuOptions.get(0).click();
	}

}
