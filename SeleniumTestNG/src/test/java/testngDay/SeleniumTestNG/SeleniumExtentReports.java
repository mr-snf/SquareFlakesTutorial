package testngDay.SeleniumTestNG;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

import pageObjects.MercuryToursHomePage;
import pageObjects.MercuryToursLoginPage;
import pageObjects.RadioAndCheckboxesPage;
import pageObjects.SelectOptionPage;

public class SeleniumExtentReports {

	WebDriver driver;
	private MercuryToursLoginPage mtl;
	MercuryToursHomePage mth;
	ExtentReports reports;
	ExtentTest test;

	@BeforeSuite
	public void setUp() {

		reports = new ExtentReports(System.getProperty("user.dir") + "\\reports\\extentReport.html", true);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\chromedriver.exe");

	}

	@BeforeMethod
	public void startBrowser() {
		driver = new ChromeDriver();
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// driver.get("http://demo.guru99.com/test/radio.html");
		driver.manage().window().maximize();
	}

	@Test
	public void loginTest() {
		test = reports.startTest("Login test", "Validating login process");
		mtl = new MercuryToursLoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Logging in with test123 user");

		mtl.login("test123", "test123");
		mth = new MercuryToursHomePage(driver);

		if (mth.verifyLogin().equals("Login Successfully")) {
			test.log(LogStatus.PASS, "Login successful");
		} else {
			String snapshot = capture("login");
			test.log(LogStatus.FAIL, "Login unsuccessful" + test.addScreenCapture(snapshot));
		}
	}

	@Test
	public void test2() throws InterruptedException {
		test = reports.startTest("test2");
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		mth = new MercuryToursHomePage(driver);
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "did nothing here");
		mth.clickBackHome2();
		Thread.sleep(2000);
	}

	@Test
	public void test3() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/radio.html");

		RadioAndCheckboxesPage rnc = new RadioAndCheckboxesPage(driver);
//		Thread.sleep(1000);
//		rnc.clickRadio1();
//		Thread.sleep(1000);
//		rnc.checkRadioSelection();
//		Thread.sleep(1000);
//		rnc.clickRadio2();
//		Thread.sleep(1000);
//		rnc.checkRadioSelection();
//		Thread.sleep(1000);
//		rnc.clickRadio3();
//		Thread.sleep(1000);
//		rnc.checkRadioSelection();
//		Thread.sleep(1000);

		System.out.println("----------------------------");

		rnc.clickCheckbox1();
		Thread.sleep(1000);
		rnc.checkCheckboxSelection();
		Thread.sleep(1000);
		rnc.clickCheckbox2();
		Thread.sleep(1000);
		rnc.checkCheckboxSelection();
		Thread.sleep(1000);
		rnc.clickCheckbox3();
		Thread.sleep(1000);
		rnc.checkCheckboxSelection();
		Thread.sleep(1000);
		rnc.clickCheckbox1();
		Thread.sleep(1000);
		rnc.checkCheckboxSelection();
		Thread.sleep(1000);
		rnc.clickCheckbox2();
		Thread.sleep(1000);
		rnc.checkCheckboxSelection();
		Thread.sleep(1000);
		rnc.clickCheckbox3();
		Thread.sleep(1000);
		rnc.checkCheckboxSelection();
		Thread.sleep(1000);
	}

	@Test
	public void testParentChildre() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/radio.html");

		SelectOptionPage sop = new SelectOptionPage(driver);
		Thread.sleep(2000);
		sop.clickSEOMenu();
		Thread.sleep(2000);
		sop.usePageMenus();
		Thread.sleep(2000);
	}

	@Test
	public void testSelectOption() {
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
	}

	@AfterMethod
	public void tearDown() {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}

	@AfterSuite
	public void createReport() {
		reports.close();
	}

	protected String capture(String snapShotName) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String snapShotPath = System.getProperty("user.dir") + "\\reports\\" + snapShotName + System.currentTimeMillis()
				+ ".png";

		try {
			FileUtils.copyFile(scrFile, new File(snapShotPath));
		} catch (IOException e) {
			System.err.println("Error occurred saving snap shot!!");
		}
		return snapShotPath;
		/* Put comment on return screenshotPath if you are not using email report */
		// return new File (screenshotPath).getAbsolutePath();
	}
}
