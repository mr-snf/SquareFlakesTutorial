package testProj.SeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testProj.PageObjects.ToolsQAHomePage;

public class ToolsQATest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com");

		driver.manage().window().maximize();

		ToolsQAHomePage qaHome = new ToolsQAHomePage(driver);

		Thread.sleep(2000);

		qaHome.ClickElement();

		Thread.sleep(2000);

		qaHome.ClickTextboxOption();

		Thread.sleep(2000);

		qaHome.SubmitForm();

		Thread.sleep(2000);

		// System.out.println(qaHome.getOutput());
		System.out.println(qaHome.getPermanentAddress());

		Thread.sleep(2000);

		qaHome.doubleClickFullname();

		Thread.sleep(2000);

		qaHome.rightClickEmail();
		Thread.sleep(2000);

		driver.close();

	}

}
