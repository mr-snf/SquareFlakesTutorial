package testngDay.SeleniumTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

		// this assertion compares two values whether or not they are equal, this is a
		// hard assertion
		Assert.assertEquals(mth.verifyLogin(), "Login Successfully");

		// this assertion checks if the value we gave is true or not, this is also a
		// hard assertion
		Assert.assertTrue(mth.verifyLogin().equals("Login Successfully"));
		System.out.println("login successful");

		SoftAssert sa = new SoftAssert();

		// soft assertion executes next line regardless of the failure
		// if failed, the failure case is stored in the soft assertion object
		sa.assertTrue(mth.verifyLogin().equals("Login Successful"), "Soft assertion failed!!");
		System.out.println("login successful 2");
		
		sa.assertEquals(true, false);
		

		// this line check whether all of the soft assertions are passed or not
		// this is mandatory check for soft assertion
		sa.assertAll();
	}

	@AfterMethod
	public void closeWindow() {
		driver.quit();
	}

}
