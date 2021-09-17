package testAttribute.SeleniumDay15;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageObjects.Demo99FlightPage;
import pageObjects.DemoiframePage;
import pageObjects.GoogleSearchPage;

public class SeleniumDay21 {

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
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
	}

	@Test
	public void iframeTest() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/guru99home/");
		DemoiframePage dip = new DemoiframePage(driver);
		Thread.sleep(2000);
		dip.useImage();

		Thread.sleep(2000);

	}

	@Test
	public void flightTest() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/newtours/reservation.php");
		Demo99FlightPage dp = new Demo99FlightPage(driver);

		Thread.sleep(4000);

		try {
			dp.selectToMonth("13");
		} catch (NoSuchElementException e) {
			System.out.println("Month doesn't exist!!");
		}

		Thread.sleep(2000);

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
