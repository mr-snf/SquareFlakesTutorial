package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class IncomeTaxPage {

	@FindBy(name = "cfilestatus")
	WebElement selectFileStatus;

	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table[5]/tbody/tr[12]/td/input[2]")
	WebElement btnCalculate;

	@FindBy(id = "callowance")
	WebElement txtYoungDepID;

	// how to create relative xpath //{tagname or *}[@attributename="value"]
	// (example: //input[@name='callowance'])
	// example : //div[@class="panel"]/table[1]/tbody/tr[3]/td[2]/input
	@FindBy(xpath = "//*[@id=\"callowance\"]")
	WebElement txtYoungDepRel;

	@FindBy(xpath = "/html/body/div[3]/div[1]/form/div/table[1]/tbody/tr[2]/td[2]/input")
	WebElement txtYoungDepFull;

	public IncomeTaxPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void selectFileStatusDropdown(int value) throws InterruptedException {
		Select optionMenu = new Select(selectFileStatus);
//		System.out.println(optionMenu.getOptions());
		optionMenu.selectByIndex(value);

//		for (WebElement el : optionMenu.getOptions()) {
//			System.out.println(el.getText());
//			selectFileStatus.click();
//			Thread.sleep(2000);
//			el.click();
//			Thread.sleep(2000);
//		}
//		Thread.sleep(2000);
//		optionMenu.selectByValue("Single");
//		Thread.sleep(2000);
//		optionMenu.selectByVisibleText("Qualified Widow");
//		Thread.sleep(2000);
	}

	public void clickCalculate() {
		btnCalculate.click();
	}

	public void enterValue(String value) throws InterruptedException {
		txtYoungDepID.clear();
		txtYoungDepID.sendKeys(value);
		Thread.sleep(2000);
		txtYoungDepFull.clear();
		txtYoungDepFull.sendKeys(value + "10");
		Thread.sleep(2000);
		txtYoungDepRel.clear();
		txtYoungDepRel.sendKeys(value + "20");
		Thread.sleep(2000);
	}

}
