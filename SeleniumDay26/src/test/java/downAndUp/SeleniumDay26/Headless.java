package downAndUp.SeleniumDay26;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Headless {

	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;

	@Test
	public void headlessTest() throws InterruptedException, AWTException {
		driver.get("https://google.com");

		System.out.println(driver.findElement(By.id("SIvCob")).getText());

		Robot robot = new Robot();

		robot.mouseMove(400, 400);
		robot.keyPress(KeyEvent.ALT_MASK);
		robot.keyPress(KeyEvent.VK_F4);

		Thread.sleep(2000);
	}

	@Test(dataProvider = "searchValues")
	public void testParamDataProvider(String SearchText) throws InterruptedException {
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys(SearchText + Keys.ENTER);
		Thread.sleep(2000);

	}

	@Test
	public void headlessBrowser() throws InterruptedException {
		driver.get("https:\\google.com");
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.id("SIvCob")).getText());
		Thread.sleep(2000);
	}

	@DataProvider(name = "searchValues")
	public String[] returnValues() {
		return new String[] { "apple", "orange", "blackberry" };
	}

	@BeforeMethod
	public void beforeMethod() {
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(true);
		//opt.addArguments("--headless");
		driver = new ChromeDriver(opt);

//		driver = new ChromeDriver();

//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setJavascriptEnabled(true);
//		caps.setCapability("takesScreenshot", true);
//		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
//				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\phantomjs.exe");
//		driver = new PhantomJSDriver(caps);
//		driver.manage().window().setSize(new Dimension(1024, 768));

//		FirefoxOptions fOpt = new FirefoxOptions();
//		fOpt.addArguments("--headless");
//		fOpt.setHeadless(true);
//		driver = new FirefoxDriver(fOpt);

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
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\geckodriver.exe");
	}

	@AfterSuite
	public void afterSuite() {
		reports.close();
	}

}
