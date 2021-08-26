package testngDay.SeleniumTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.MercuryToursHomePage;
import pageObjects.MercuryToursLoginPage;

public class SeleniumTestNGPractice {

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

	@Test(groups = { "TestMethods" })
	public void loginTest() throws InterruptedException {

		mtl = new MercuryToursLoginPage(driver);
		mtl.login("test123", "test123");
		Thread.sleep(2000);
	}

	@Test(groups = { "TestMethods" })
	public void contactsTest() throws InterruptedException {
		mth = new MercuryToursHomePage(driver);
		mth.clickContacts();
		Thread.sleep(2000);
		mth.clickBackHome();
	}

	@Test(dependsOnGroups = "TestMethods")
	public void testTest() {
		System.out.println("this is a test");
	}

	@Test(priority = 1)
	public void test1() {
		System.out.println("this should run first");
	}

	@Test(dependsOnMethods = "test1")
	public void test2() {
		System.out.println("this second");
	}

	@AfterMethod
	public void closeWindow() {
		driver.quit();
	}
}
