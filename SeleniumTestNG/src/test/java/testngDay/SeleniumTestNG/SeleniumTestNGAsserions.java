package testngDay.SeleniumTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.MercuryToursHomePage;
import pageObjects.MercuryToursLoginPage;

public class SeleniumTestNGAsserions {
	WebDriver driver;
	MercuryToursLoginPage mtl;
	MercuryToursHomePage mth;

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
		mtl.login("test123", "test123");
		Thread.sleep(2000);
		mth = new MercuryToursHomePage(driver);
		Assert.assertEquals(mth.verifyLogin(), false);
		System.out.println("login successful");

	}

	@AfterMethod
	public void closeWindow() {
		driver.quit();
	}

}
