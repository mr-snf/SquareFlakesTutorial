package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

		btnAlert.click();
		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
//		driver.switchTo().defaultContent();
		Thread.sleep(2000);
//		
	}

	public void handleTimedAlert() throws InterruptedException {
		btntimerAlert.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.alertIsPresent());
//		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		// driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}

	public void handleConfirmAlert() throws InterruptedException {

		btnConfirm.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
//		driver.switchTo().defaultContent();
		Thread.sleep(2000);

//		driver.switchTo().alert().dismiss();
	}

	public void handlePromptAlert() throws InterruptedException {

		btnPrompt.click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("this is a prompt alert");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
//		driver.switchTo().defaultContent();
		Thread.sleep(2000);
//		driver.switchTo().alert().dismiss();
	}
}
