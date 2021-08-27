package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryToursLoginPage {

	@FindBy(xpath = "//input[@name=\"userName\"]")
	WebElement inputUsername;

	@FindBy(xpath = "//input[@name=\"password\"]")
	public WebElement inputPassword;

	@FindBy(xpath = "//input[@name=\"submit\"]")
	WebElement btnSubmit;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a")
	public WebElement linkHome;

	public MercuryToursLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		btnSubmit.click();
	}

}
