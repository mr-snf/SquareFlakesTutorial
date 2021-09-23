package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetHerokuUploadPage {

	@FindBy(id = "file-upload")
	WebElement btnFileUpload;

	@FindBy(id = "file-submit")
	WebElement btnSubmit;

	public InternetHerokuUploadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void uploadFile(String filePath) {
		// btnFileUpload.click();
		btnFileUpload.sendKeys(filePath);
		btnSubmit.click();
	}

}
