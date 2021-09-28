package downAndUp.SeleniumDay26;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DataDrivenTest {

	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;

	@Test
	@Parameters({ "searchText" })
	public void testParamXML(String SearchText) throws InterruptedException {
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys(SearchText + Keys.ENTER);
		Thread.sleep(2000);

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}

	@BeforeSuite
	public void beforeSuite() {
		reports = new ExtentReports(System.getProperty("user.dir") + "\\reports\\extentReport.html", true);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\chromedriver.exe");
	}

	@AfterSuite
	public void afterSuite() {
		reports.close();
	}
}
