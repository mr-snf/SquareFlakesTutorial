package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetHerokuDownloadPage {

	@FindBy(xpath = "/html/body/div[2]/div/div/a[1]")
	WebElement downloadLink1;

	@FindBy(xpath = "/html/body/div[2]/div/div/a[2]")
	WebElement downloadLink2;

	public InternetHerokuDownloadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void downloadFile() throws InterruptedException {
		downloadLink1.click();
		Thread.sleep(2000);
		downloadLink2.click();
	}

}
