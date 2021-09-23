package downAndUp.SeleniumDay26;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageObjects.InternetHerokuDownloadPage;
import pageObjects.InternetHerokuUploadPage;

public class UploadAndDownload {

	WebDriver driver;
	private ExtentReports reports;
	ExtentTest test;
	InternetHerokuUploadPage up;
	InternetHerokuDownloadPage down;

	@Test
	public void fileUploadTest() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/upload");
		test = reports.startTest("file upload");
		up = new InternetHerokuUploadPage(driver);
		
		Thread.sleep(3000);
		up.uploadFile("C:\\Users\\i31335\\Downloads\\loremipsum.txt");

		Thread.sleep(3000);

	}

	@Test
	public void fileDownloadTest() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/download");
		test = reports.startTest("file download");
		down = new InternetHerokuDownloadPage(driver);
		down.downloadFile();
		Thread.sleep(2000);

		// file download verification code -->
		File downloadFolder = new File("//desired file download location");
		File[] downloadFiles = downloadFolder.listFiles();

		for (File file : downloadFiles) {
			file.delete();
		}

		Thread.sleep(100);
		// download action here
		// downloadlink.click();

		int defaultWaitTimeCount = 40, count = 0;

		try {
			outerLoop: while (count < defaultWaitTimeCount) {
				Thread.sleep(500);
				File[] files = downloadFolder.listFiles();

				for (File downloadedFile : files) {
					if (downloadedFile.getName().equals("//expected file name")) {
						break outerLoop;
					}
				}
				count++;
			}

			if (count == defaultWaitTimeCount)
				System.out.println("// download failed msg here");
		} catch (Exception e) {
			// in case of file read exception
		}
		// upto here

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
