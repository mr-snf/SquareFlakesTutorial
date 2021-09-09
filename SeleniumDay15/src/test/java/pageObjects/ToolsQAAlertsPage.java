package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolsQAAlertsPage {
	WebDriver driver;

	@FindBy(id = "alertButton")
	WebElement btnAlert;

	@FindBy(id = "timerAlertButton")
	WebElement btntimerAlert;

	@FindBy(id = "confirmButton")
	WebElement btnConfirm;

	@FindBy(id = "promtButton")
	WebElement btnPrompt;

	public ToolsQAAlertsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void handleAlert() throws InterruptedException {

//		driver.switchTo().newWindow(WindowType.TAB);
//		Thread.sleep(2000);

//		driver.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(2000);
		btnAlert.click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();

	}

	public void handleTimedAlert() {
		btntimerAlert.click();
	}

	public void handleConfirmAlert() throws InterruptedException {
		Thread.sleep(2000);
		btnConfirm.click();
		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
	}

	public void handlePromptAlert() throws InterruptedException {
		Thread.sleep(2000);
		btnPrompt.click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("this is a prompt alert");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
	}
}
