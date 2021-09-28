package downAndUp.SeleniumDay26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HtmlUnitTest {

	public WebDriver setBrowser() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability("takesScreenshot", true);
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"C:\\Users\\i31335\\eclipse-workspace\\VM-LT Automation\\drivers\\phantomjs.exe");
		return new PhantomJSDriver(caps);

	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new HtmlUnitTest().setBrowser();
		driver.get("https:\\google.com");
		System.out.println(driver.findElement(By.id("SIvCob")).getText());
		Thread.sleep(2000);
		driver.quit();
	}

}
