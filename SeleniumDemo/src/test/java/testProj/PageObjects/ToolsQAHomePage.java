package testProj.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolsQAHomePage {

	WebDriver driver;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]")
	WebElement elements;

	@FindBy(id = "item-0")
	WebElement optionTextbox;

	@FindBy(id = "item-1")
	WebElement optionCheckbox;

	@FindBy(id = "item-2")
	WebElement optionRadioButtons;

	@FindBy(id = "item-3")
	WebElement optionWebTables;

	@FindBy(id = "item-4")
	WebElement optionButtons;

	@FindBy(id = "item-5")
	WebElement optionLinks;

	@FindBy(xpath = "//*[@id=\"userName\"]")
	WebElement txtFullname;

	@FindBy(xpath = "//input[@class=\"mr-sm-2 form-control\"]")
	WebElement txtEmail;

	@FindBy(css = "#currentAddress")
	WebElement txtCurrentAddress;

	@FindBy(id = "permanentAddress")
	WebElement txtPermanentAddress;

	@FindBy(id = "submit")
	WebElement btnSubmit;

	@FindBy(css = "#output > div")
	WebElement divOutput;

	@FindBy(css = "#permanentAddress")
	WebElement labelPermanentAdd;

	// driver initialization
	public ToolsQAHomePage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public void ClickElement() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		elements.click();
	}

	public void ClickTextboxOption() {
		optionTextbox.click();
	}

	public void SubmitForm() {
		txtFullname.sendKeys("Sanish");
		txtEmail.sendKeys("this@email.com");
		txtCurrentAddress.sendKeys("NEPAL");
		txtPermanentAddress.sendKeys("NEPAL");
		btnSubmit.click();

	}

	public String getOutput() {
		return divOutput.getText();
	}

	public String getPermanentAddress() {
		return labelPermanentAdd.getText();
	}

	public void doubleClickFullname() {
		Actions action = new Actions(driver);
		action.doubleClick(txtFullname).perform();
	}

	public void rightClickEmail() {
		Actions action = new Actions(driver);
		action.contextClick(txtEmail).perform();
	}

}
