package testAttribute.SeleniumDay15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.GoogleSearchPage;

public class SeleniumDay15 {
	WebDriver driver;
	GoogleSearchPage gsp;
	ExtentReports reports;
	ExtentTest test;

	@BeforeSuite
	public void setUp() {
		reports = new ExtentReports(System.getProperty("user.dir") + "\\reports\\extentReport.html", true);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\chromedriver.exe");
	}

	@BeforeMethod
	public void setupBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void attributeTest() throws InterruptedException {
		driver.get("https://www.google.com");
		test = reports.startTest("Attibute Test", "Checking suggestions");
		gsp = new GoogleSearchPage(driver);
		test.log(LogStatus.INFO, "Clicking input box");
		gsp.validateSuggestion();
		Thread.sleep(5000);
		gsp.clickSearchBox();
		Thread.sleep(1000);
		gsp.validateSuggestion();
		Thread.sleep(5000);
		gsp.setSearchText("Apple");
		gsp.validateSuggestion();
		Thread.sleep(5000);
		gsp.clearSearchText();
		Thread.sleep(1000);
		gsp.validateSuggestion();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void clearSession() {
		reports.endTest(test);
		reports.flush();
		driver.quit();

	}

	@AfterSuite
	public void tearDown() {
		reports.close();
	}
}
