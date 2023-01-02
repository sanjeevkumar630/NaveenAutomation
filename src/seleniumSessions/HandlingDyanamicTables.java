package seleniumSessions;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDyanamicTables {
	static WebDriver driver;
	static double m=0;
	static double r=0;
	static String max;

	public static void handleTable() {

		initialization();

		driver.get("http://demo.guru99.com/test/web-table-element.php");
		List<WebElement> tableHeaders = driver.findElements(By.xpath("//table[@class='dataTable']//th"));

		/*
		 * for(int i=0;i<tableHeaders.size();i++) {
		 * 
		 * System.out.println(tableHeaders.get(i).getText());
		 * 
		 * 
		 * }
		 */
		List<WebElement> noofRows = driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
		System.out.println(noofRows.size());

		for (int j = 0; j < noofRows.size(); j++) {
			List<WebElement> noofcols = driver.findElements(By.xpath("//table[@class='dataTable']//tr[" + j + "]//td"));
			for (int k = 0; k < noofcols.size(); k++) {
				System.out.println(noofcols.get(k).getText());
			}
			System.out.println();
		}
	}

	public static void tablehandling() {
		initialization();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> noofRows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println(noofRows.size());
		
		
		for(int i=2;i<=noofRows.size();i++) {
			List<WebElement> noofCols=driver.findElements(By.xpath("//table[@id='customers']//tr["+i+"]//td"));
			for(int j=1;j<noofCols.size();j++) {
				driver.findElements(By.xpath("//table[@id='customers']//tr["+i+"]//td["+j+"]"));
				System.out.println(noofCols.get(j).getText());
			}
		}System.out.println();

	}
	
	public static void maxValueInParticularColumn() throws ParseException {
		
		initialization();

		driver.get("http://demo.guru99.com/test/web-table-element.php");
		
		List<WebElement> noOfRows=driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
		System.out.println(noOfRows.size());
		List<WebElement> noOfColmns=driver.findElements(By.xpath("//table[@class='dataTable']//tr/th"));
		System.out.println(noOfRows.size());
		for(int i=0;i<noOfRows.size();i++) {
			
			max=driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+(i+1)+"]//td")).getText();
			
			
			  NumberFormat f =NumberFormat.getNumberInstance(); 
			  Number  num = f.parse(max);
			  //max = num.toString();
			 
            m = Double.parseDouble(max);
            if(m>r)
            {    
               r=m;
            }
       }
       System.out.println("Maximum current price is : "+ r);
			
		}
	

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	public static void main(String[] args) throws ParseException {
		// handleTable();
		//tablehandling();
		maxValueInParticularColumn();
	}

}
