package testngDay.SeleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.MercuryToursHomePage;
import pageObjects.MercuryToursLoginPage;

public class DiffDriverTest {
	WebDriver driver;
	MercuryToursLoginPage mtl;
	MercuryToursHomePage mth;
	// JavascriptExecutor jse;
	Actions act;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\chromedriver.exe");
	}

	@BeforeMethod
	public void startBrowser() {
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/index.php");
	}

	@Test
	public void loginTest() throws InterruptedException {
		mtl = new MercuryToursLoginPage(driver);
		act = new Actions(driver);
		act.moveToElement(mtl.linkHome).build().perform();
//		act.doubleClick(mtl.linkHome).build().perform();
//		act.clickAndHold(mtl.linkHome);
//		act.moveToElement(mtl.inputPassword);
//		act.release().build().perform();
//		act.click(mtl.linkHome).build().perform();
//		act.moveByOffset(100, 0)
//		act.dragAndDrop(mtl.linkHome, mtl.inputPassword).build().perform();
//		act.sendKeys(mtl.inputPassword, "fdsfdsfsfa");

		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;// typecasting

		jse.executeScript("return document.ready;", driver.findElement(By.tagName("tbody")));

		jse.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[5]/td/div")));

		jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

		Thread.sleep(3000);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
