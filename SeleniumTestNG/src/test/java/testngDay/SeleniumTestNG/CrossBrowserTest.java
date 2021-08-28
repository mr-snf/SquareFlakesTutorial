package testngDay.SeleniumTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.MercuryToursHomePage;
import pageObjects.MercuryToursLoginPage;

public class CrossBrowserTest {

	WebDriver driver;
	MercuryToursLoginPage mtl;
	int browserSelect = 1;
	private MercuryToursHomePage mth;
	ExtentReports extentReport;
	ExtentTest extentTest;

	@BeforeSuite
	public void setUp() {

		extentReport = new ExtentReports(
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\reports.html", true);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\IEDriverServer.exe");
	}

	@BeforeMethod
	public void startDiffBrowser() {
		switch (browserSelect) {
		case 1:
			driver = new ChromeDriver();
			break;

		case 2:
			driver = new FirefoxDriver();
			break;

		case 3:
			driver = new InternetExplorerDriver();
			break;

		default:
			driver = new ChromeDriver();
			break;
		}

		driver.get("http://demo.guru99.com/test/newtours/index.php");
	}

	@Test
	public void loginTest() throws InterruptedException {
		extentTest = extentReport.startTest("Login Test", "This is a sample login");
		mtl = new MercuryToursLoginPage(driver);
		mtl.login("test123", "test123");
		extentTest.log(LogStatus.INFO, "logged in with test123");
		Thread.sleep(2000);
		mth = new MercuryToursHomePage(driver);
		Assert.assertEquals(mth.verifyLogin(), "Login Successfullgy");
		extentTest.log(LogStatus.FAIL, "Login failed!!");
	}

	@AfterMethod
	public void tearDown() {
		extentReport.endTest(extentTest);
		extentReport.flush();

		driver.quit();
	}

	@AfterSuite
	public void createReport() {
		extentReport.close();
	}
}