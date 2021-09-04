package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99TablePage {

	@FindBy(xpath = "/html/body/table/tbody/tr[1]/td[1]")
	WebElement cell1;

	@FindBy(xpath = "/html/body/table")
	WebElement table;

	public Guru99TablePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getCell1() {
		System.out.println(cell1.getText());
	}

	public void getTableCells() throws InterruptedException {
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> brows = tbody.findElements(By.tagName("tr"));

		for (WebElement row : brows) {
			List<WebElement> cells = row.findElements(By.xpath("./*"));
//			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getTagName());
				Thread.sleep(2000);
			}
		}

//		WebElement thead = table.findElement(By.tagName("thead"));
//		List<WebElement> hrows = thead.findElements(By.tagName("tr"));
//
//		for (WebElement row : hrows) {
//			List<WebElement> cells = row.findElements(By.tagName("td"));
//
//			for (WebElement cell : cells) {
//				System.out.println(cell.getText());
//				Thread.sleep(2000);
//			}
//		}
//
//		WebElement tfoot = table.findElement(By.tagName("tfoot"));
//		List<WebElement> frows = tfoot.findElements(By.tagName("tr"));
//
//		for (WebElement row : frows) {
//			List<WebElement> cells = row.findElements(By.tagName("td"));
//
//			for (WebElement cell : cells) {
//				System.out.println(cell.getText());
//				Thread.sleep(2000);
//			}
//		}
	}

}
