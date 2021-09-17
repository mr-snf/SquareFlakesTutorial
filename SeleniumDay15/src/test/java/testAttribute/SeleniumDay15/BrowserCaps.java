package testAttribute.SeleniumDay15;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BrowserCaps {

	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;

	@Test
	public void f() throws InterruptedException {
		driver.get("https://google.com");
		Thread.sleep(2000);
	}

	@BeforeMethod
	public void beforeMethod() {
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "C://downloads//");
		options.setExperimentalOption("prefs", prefs);

		Map<String, String> mps = new HashMap<String, String>();
		mps.put("deviceName", "iPhone 8");
		options.setExperimentalOption("mobileEmulation", mps);

		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		Proxy px = new Proxy();
		px.setHttpProxy("sthsth:6545");
		options.setCapability("proxy", px);

		options.addExtensions(new File("c://sth.crx"));

		driver = new ChromeDriver(options);

		DesiredCapabilities de = new DesiredCapabilities();
		de.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		de.setCapability("fdsfaf", "dfsdfas");

		options.setCapability(ChromeOptions.CAPABILITY, de);

//		FirefoxOptions opt = new FirefoxOptions();
//		opt.addArguments("fdsfdsa");
//
//		InternetExplorerOptions ieOpt = new InternetExplorerOptions();
//
//		driver = new InternetExplorerDriver(ieOpt);
//
//		driver = new FirefoxDriver(opt);

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
