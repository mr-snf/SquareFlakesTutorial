package testDropDown.SeleniumDay12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageObject.IncomeTaxPage;

public class TaxCalculator {

	WebDriver driver;
	private ExtentReports reports;
	ExtentTest test;

	IncomeTaxPage itp;

	@BeforeSuite
	public void setUp() {
		reports = new ExtentReports(System.getProperty("user.dir") + "\\reports\\extentReport.html", true);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\chromedriver.exe");

	}

	@BeforeMethod
	public void startSession() {
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/tax-calculator.html");
	}

	@Test
	public void calculateTax() throws InterruptedException {
		test = reports.startTest("Calculate Tax", "This is a sample tax calculator test");
		itp = new IncomeTaxPage(driver);
//		test.log(LogStatus.INFO, "using select options");
		itp.selectFileStatusDropdown(3);
//		test.log(LogStatus.INFO, "calculating tax");
//		itp.clickCalculate();
//		Thread.sleep(3000);
		itp.enterValue("100");
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
