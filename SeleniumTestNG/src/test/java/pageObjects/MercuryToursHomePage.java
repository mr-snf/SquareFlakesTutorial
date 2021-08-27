package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryToursHomePage {

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[4]/a")
	WebElement linkContact;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td/a/img")
	WebElement btnBackHome;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")
	WebElement labelSuccess;

	public MercuryToursHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickContacts() {
		linkContact.click();
	}

	public void clickBackHome() {
		btnBackHome.click();
	}

	public String verifyLogin() {
		return labelSuccess.getText();
	}
}
