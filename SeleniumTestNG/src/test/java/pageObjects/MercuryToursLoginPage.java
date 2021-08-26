package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryToursLoginPage {

	@FindBy(xpath = "//input[@name=\"userName\"]")
	WebElement inputUsername;

	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement inputPassword;

	@FindBy(xpath = "//input[@name=\"submit\"]")
	WebElement btnSubmit;

	public MercuryToursLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		btnSubmit.click();
	}

}
