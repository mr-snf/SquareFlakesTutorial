package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MercuryToursLoginPage {

	@FindBy(xpath = "//input[@name=\"userName\"]")
	WebElement inputUsername;

	@FindBy(xpath = "//input[@name=\"password\"]")
	public WebElement inputPassword;

	@FindBy(xpath = "//input[@name=\"submit\"]")
	WebElement btnSubmit;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a")
	public WebElement linkHome;

	private WebDriver driver;

	public MercuryToursLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		btnSubmit.click();
	}

}
