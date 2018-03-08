package choirTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class checkTablesViewAbsence {
	
	static String driverPath = "/Applications/Selenium/";
	public WebDriver driver;
	
  @Test
  public void f() {
	  System.out.println("TEST START");
	  
	  driver.navigate().to("http://localhost:8888/choir-prod/members/absence/view_absence.php");
	  
	  
	  Integer countTables = driver.findElements(By.xpath("//table")).size();
	  System.out.println("Tables found: "+countTables);
	  
	  WebElement detailTable = driver.findElements(By.xpath("//table")).get(0);
	  System.out.println(detailTable.getText());
	  
	  
	  System.out.println("TEST END");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Closing chrome browser");
	  driver.quit();
  }

}
