package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoiframePage {
	WebDriver driver;

	@FindBy(xpath = "/html/body/a")
	WebElement iframeImage;

	@FindBy(id = "a077aa5e")
	WebElement iframe2;

	@FindBy(xpath = "//*[@id=\"rt-header\"]/div/div[1]/div/a/img")
	WebElement linkHome;

	public DemoiframePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void useImage() throws InterruptedException {
//		these are ways to switch to iframe
//		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//		driver.switchTo().frame(1);
//		driver.switchTo().frame("a077aa5e");
//		driver.switchTo().frame(iframes.get(1));
		driver.switchTo().frame(iframe2);
		iframeImage.click();

		// this code is for handling tabs

		String parentTab = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();
		tabs.remove(parentTab);

		if (tabs.iterator().hasNext()) {
			driver.switchTo().window(tabs.iterator().next());
			Thread.sleep(2000);
			driver.close();
		}

		driver.switchTo().window(parentTab);
		// upto here

		Thread.sleep(5000);

		// these line of code switches to parent frame.
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

//		driver.close();
//		Thread.sleep(5000);
		linkHome.click();
	}
}
