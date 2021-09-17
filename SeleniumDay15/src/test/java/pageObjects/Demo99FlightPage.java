package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Demo99FlightPage {

	@FindBy(name = "toMonth")
	WebElement dropdownToMonth;

	public Demo99FlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void selectToMonth(String month) {
		Select toMonthOption = new Select(dropdownToMonth);
		toMonthOption.selectByValue(month);
	}

}
