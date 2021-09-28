package testAttribute.SeleniumDay15;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
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
import pageObjects.ToolsQAAlertsPage;

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
//		Dimension dim = new Dimension(800, 600);
//		System.out.println(driver.manage().window().getSize());

//		driver.manage().window().setSize(dim);
//		driver.manage().window().fullscreen();
//		System.out.println(driver.manage().window().getSize());
		gsp.validateSuggestion();
//		Thread.sleep(5000);
//		gsp.clickSearchBox();
//		Thread.sleep(1000);
//		gsp.validateSuggestion();
//		Thread.sleep(5000);
//		gsp.setSearchText("Apple");
//		gsp.validateSuggestion();
//		Thread.sleep(5000);
//		gsp.clearSearchText();
//		Thread.sleep(1000);
//		gsp.validateSuggestion();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("http://google.com");

		gsp.searchText("apple");

//		driver.navigate().to("https://facebook.com");

		driver.switchTo().newWindow(WindowType.TAB); // available from selenium 4

//		Set<String> tabs = driver.getWindowHandles();
//		System.out.println(tabs);
//		String parentTab = driver.getWindowHandle();
//
//		tabs.remove(parentTab);
//		if (tabs.iterator().hasNext()) {
//			String newTab = tabs.iterator().next();
//			driver.switchTo().window(newTab); 
//			Thread.sleep(2000);
//			driver.close();
//		}
//
//		driver.switchTo().window(parentTab);

//		System.out.println(tabs);
		Thread.sleep(3000);

//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//		Thread.sleep(3000);
	}

	@Test
	public void handlingAlertsTest() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		test = reports.startTest("Alerts Test", "Handling different alerts");
		ToolsQAAlertsPage tqp = new ToolsQAAlertsPage(driver);
//		tqp.handleAlert();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			tqp.handleTimedAlert();
		} catch (TimeoutException e) {
			test.log(LogStatus.FAIL, "Alert didn't show!!");
		}
//		wait.until(ExpectedConditions.alertIsPresent());
//		driver.switchTo().alert().accept();

//		tqp.handleConfirmAlert();
//		tqp.handlePromptAlert();
		Thread.sleep(2000);

	}

	@Test
	public void windowsAuthTest() throws InterruptedException, IOException, AWTException {
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		// https://admin:admin@the-internet.herokuapp.com/basic_auth
		test = reports.startTest("Windows auth test", "Handling windows authentication");

		Thread.sleep(2000);

		Robot robo = new Robot();
		robo.mouseMove(950, 160);
		robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robo.keyPress(KeyEvent.VK_A);
		robo.mouseMove(950, 200);
		robo.keyPress(KeyEvent.VK_4);
		robo.mouseMove(1050, 250);
		
		
//		Runtime.getRuntime()
//				.exec("C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\autoIT\\autoIT.exe");
//		driver.switchTo().alert().sendKeys("admin" + Keys.TAB + "admin");
//		driver.switchTo().alert().accept();
		Thread.sleep(5000);
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
