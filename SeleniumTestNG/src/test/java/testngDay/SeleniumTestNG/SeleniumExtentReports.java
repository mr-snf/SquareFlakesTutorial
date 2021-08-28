package testngDay.SeleniumTestNG;

import java.io.File;
import java.io.IOException;

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
		driver.get("http://demo.guru99.com/test/newtours/index.php");
	}

	@Test
	public void loginTest() throws InterruptedException {
		test = reports.startTest("Login test", "Validating login process");
		mtl = new MercuryToursLoginPage(driver);
		test.log(LogStatus.INFO, "Logging in with test123 user");

		mtl.login("test123", "test123");
		mth = new MercuryToursHomePage(driver);
		Thread.sleep(2000);

		if (mth.verifyLogin().equals("Login Successfullygfdg")) {
			test.log(LogStatus.PASS, "Login successful");
		} else {
			String snapshot = capture("login");
			test.log(LogStatus.FAIL, "Login unsuccessful" + test.addScreenCapture(snapshot));
		}
	}

	@Test
	public void test2() {
		test = reports.startTest("test2");
		test.log(LogStatus.INFO, "did nothing here");
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
