package testProject.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDay1 {
	public static void main(String areg[]) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.testandquiz.com/selenium/testing.html");

		driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys("Selenium");

		driver.findElement(By.xpath("//*[@id=\"idOfButton\"]")).click();
	

		Thread.sleep(5000);

		driver.close();

	}
}
