package seleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class GetWebTableDataToExcel {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// *[@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[1]

		// *[@id="customers"]/tbody/tr[2]/td[2]
		// *[@id="customers"]/tbody/tr[3]/td[2]

		// *[@id="customers"]/tbody/tr[1]/th[3]
		// *[@id="customers"]/tbody/tr[2]/td[3]

		String beforeXpath_company = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_company = "]/td[1]";

		String beforeXpath_contact = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_contact = "]/td[2]";

		String beforeXpath_country = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_country = "]/td[3]";

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));

		System.out.println("no of rows========;" + rows.size());
		int rowcount = rows.size();

		Xls_Reader reader = new Xls_Reader("D:\\Selenium Related Files\\Selenium Naveen\\NaveenAutomation\\src\\com\\testdata\\Data.xlsx");

		if (!reader.isSheetExist("TableData1")) {

			reader.addSheet("TableData1");

			reader.addColumn("TableData1", "company");
			reader.addColumn("TableData1", "contact");
			reader.addColumn("TableData1", "country");

		}

		for (int i = 2; i <= rowcount; i++) {
			String actualXpath_company = beforeXpath_company + i + afterXpath_company;
			String company = driver.findElement(By.xpath(actualXpath_company)).getText();
			System.out.println(company);
			reader.setCellData("TableData1", "company", i, company);

			String actualXpath_contact = beforeXpath_contact + i + afterXpath_contact;
			String contact = driver.findElement(By.xpath(actualXpath_contact)).getText();
			System.out.println(contact);
			reader.setCellData("TableData1", "contact", i, contact);

			String actualXpath_country = beforeXpath_country + i + afterXpath_country;
			String country = driver.findElement(By.xpath(actualXpath_country)).getText();
			System.out.println(country);
			reader.setCellData("TableData1", "country", i, country);

		}

	}

}
