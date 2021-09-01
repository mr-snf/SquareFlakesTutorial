package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioAndCheckboxesPage {
	WebDriver driver;

	@FindBy(id = "vfb-7-1")
	WebElement radioButton1;

	@FindBy(id = "vfb-7-2")
	WebElement radioButton2;

	@FindBy(id = "vfb-7-3")
	WebElement radioButton3;

	@FindBy(id = "vfb-6-0")
	WebElement chkbox1;

	@FindBy(id = "vfb-6-1")
	WebElement chkbox2;

	@FindBy(id = "vfb-6-2")
	WebElement chkbox3;

	public RadioAndCheckboxesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickRadio1() {
		radioButton1.click();
	}

	public void clickRadio2() {
		radioButton2.click();
	}

	public void clickRadio3() {
		radioButton3.click();
	}

	public void checkRadioSelection() {
		System.out.println(radioButton1.isSelected());
		System.out.println(radioButton2.isSelected());
		System.out.println(radioButton3.isSelected());
	}

	public void clickCheckbox1() {
		chkbox1.click();
	}

	public void clickCheckbox2() {
		chkbox2.click();
	}

	public void clickCheckbox3() {
		chkbox3.click();
	}

	public void checkCheckboxSelection() {
		System.out.println(chkbox1.isSelected());
		System.out.println(chkbox2.isSelected());
		System.out.println(chkbox3.isSelected());
	}

}
