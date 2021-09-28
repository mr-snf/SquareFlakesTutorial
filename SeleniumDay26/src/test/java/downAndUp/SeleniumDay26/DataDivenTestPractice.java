package downAndUp.SeleniumDay26;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.xpath.XPath;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DataDivenTestPractice {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;

	@Test
	@Parameters({ "url", "searchText" })
	public void googleSearch(String url, String searchText) throws InterruptedException {
		driver.get(url);

		driver.findElement(By.name("q")).sendKeys(searchText + Keys.ENTER);

		Thread.sleep(3000);
	}

	@Test(dataProvider = "data")
	public void googleSearch2(String url, String searchText) throws InterruptedException {
		driver.get(url);

		driver.findElement(By.name("q")).sendKeys(searchText + Keys.ENTER);

		Thread.sleep(3000);
	}

	@DataProvider(name = "data")
	public String[][] returnData() {
		return new String[][] { { "https://google.com", "apple" }, { "https://google.com", "orange" },
				{ "https://google.com", "blackberry" }, { "https://google.com", "motorola" } };
	}

	@Test
	public void testFromExcel() throws InterruptedException, IOException {

		File excelFile = new File(
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\resources\\data1.xlsx");

		FileInputStream inStream = null;
		String cellValue = "";

		try {
			inStream = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			System.err.println("File not found:\n" + e.getLocalizedMessage());
		}

		Workbook excelWorkFile = new XSSFWorkbook(inStream);

		// if sheet has a name and it's known
		Sheet sheet = excelWorkFile.getSheet("Sheet1");

		// if you don't know the name
		// Sheet sheet = excelWorkFile.getSheetAt(0);

		// if data is store in a row pattern
//		Row row = sheet.getRow(0);
//		for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
//			Cell cell = row.getCell(i);
//			cellValue = cell.getStringCellValue();
//			System.out.println(cellValue);
//
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.get("https://google.com");
//			driver.findElement(By.name("q")).sendKeys(cellValue + Keys.ENTER);
//			Thread.sleep(2000);
//			driver.quit();
//
//		}

		// if data is stored in a column pattern
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Cell cell = sheet.getRow(i).getCell(0);
			cellValue = cell.getStringCellValue();

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://google.com");
			driver.findElement(By.name("q")).sendKeys(cellValue + Keys.ENTER);
			Thread.sleep(2000);
			driver.quit();

		}
		excelWorkFile.close();
		inStream.close();
	}

	@Test
	public void excelWriteTest() throws IOException {
		{
			// workbook object
			XSSFWorkbook workbook = new XSSFWorkbook();

			// spreadsheet object
			XSSFSheet spreadsheet = workbook.createSheet("Student Data");

			// creating a row object
			XSSFRow row;

			// This data needs to be written (Object[])
			Map<String, Object[]> studentData = new TreeMap<String, Object[]>();

			studentData.put("1", new Object[] { "Roll No", "NAME", "Year" });

			studentData.put("2", new Object[] { "128", "Aditya", "2nd year" });

			studentData.put("3", new Object[] { "129", "Narayana", "2nd year" });

			studentData.put("4", new Object[] { "130", "Mohan", "2nd year" });

			studentData.put("5", new Object[] { "131", "Radha", "2nd year" });

			studentData.put("6", new Object[] { "132", "Gopal", "2nd year" });

			Set<String> keyid = studentData.keySet();

			int rowid = 0;

			// writing the data into the sheets...

			for (String key : keyid) {

				row = spreadsheet.createRow(rowid++);
				Object[] objectArr = studentData.get(key);
				int cellid = 0;

				for (Object obj : objectArr) {
					Cell cell = row.createCell(cellid++);
					cell.setCellValue((String) obj);
				}
			}

			// .xlsx is the format for Excel Sheets...
			// writing the workbook into the file...
			FileOutputStream out = new FileOutputStream(new File(
					"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\resources\\GFGsheet.xlsx"));

			workbook.write(out);
			out.close();
			workbook.close();
		}
	}

	@Test
	public void excelWriteTest2() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Java Books");

		Object[][] bookData = { { "Head First Java", "Kathy Serria", 79 }, { "Effective Java", "Joshua Bloch", 36 },
				{ "Clean Code", "Robert martin", 42 }, { "Thinking in Java", "Bruce Eckel", 35 } };

		int rowCount = 0;

		for (Object[] aBook : bookData) {
			Row row = sheet.createRow(rowCount++);

			int columnCount = 0;

			for (Object field : aBook) {
				Cell cell = row.createCell(columnCount++);
				if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				} else {
					cell.setCellValue((String) field);
				}
			}
		}

		FileOutputStream outputStream = new FileOutputStream(new File(
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\resources\\JavaBooks.xlsx"));
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();
	}

	@Test
	public void writeToExcel() throws InterruptedException, IOException {
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		Thread.sleep(2000);

		XSSFWorkbook excelWorkbook = new XSSFWorkbook();
		XSSFSheet excelSheet = excelWorkbook.createSheet("Test Data Here");

		WebElement webTable = driver.findElement(By.className("tsc_table_s13"));
//		List<WebElement> webTableSections = webTable.findElements(By.xpath("./*"));
		WebElement webTableSection = webTable.findElement(By.tagName("tbody"));

		int excelRowCount = 0;
//		for (WebElement webTableSection : webTableSections) {

			System.out.println(webTableSection.getTagName());
			List<WebElement> webTableRows = webTableSection.findElements(By.tagName("tr"));

			for (WebElement webtableRow : webTableRows) {

				Row excelRow = excelSheet.createRow(excelRowCount++);
				List<WebElement> webTableCells = webtableRow.findElements(By.xpath("./*"));

				int excelColumnCount = 0;

				for (WebElement webTableCell : webTableCells) {

					Cell excelCell = excelRow.createCell(excelColumnCount++);
					excelCell.setCellValue(webTableCell.getText());
				}
			}
//		}
		FileOutputStream outputStream = new FileOutputStream(new File(
				"C:\\Users\\i31335\\OneDrive - Verisk Analytics\\Documents\\selenium\\resources\\WritingIntoExcel.xlsx"));
		excelWorkbook.write(outputStream);
		outputStream.close();
		excelWorkbook.close();

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
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
