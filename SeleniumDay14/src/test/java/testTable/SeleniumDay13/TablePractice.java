package testTable.SeleniumDay13;

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

import pageObject.Guru99TablePage;

public class TablePractice {

	WebDriver driver;
	Guru99TablePage gtp;
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
	public void tableTest() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/table.html");
		gtp = new Guru99TablePage(driver);
		test = reports.startTest("Table Test", "Trying table with selenium");
		test.log(LogStatus.INFO, "Printing cell 1");
		gtp.getCell1();

		Thread.sleep(2000);
		test.log(LogStatus.INFO, "getting all cell values");
		gtp.getTableCells();
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
