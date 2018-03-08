package choirTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class checkEventsTable {
	
	static String driverPath = "/Applications/Selenium/";
	public WebDriver driver;
	
  @Test
  public void f() {
	  System.out.println("TEST START");
	  
	  // Find the events table
	  driver.navigate().to("http://localhost:8888/choir-prod/events.html");
	  String strPageTitle = driver.getTitle();
	  System.out.println("Page title: - "+strPageTitle);
	  
	  WebElement element;
	  element = driver.findElement(By.xpath("/html/body/main/table/tbody"));
	  String strEventsHeader = element.getText();
	  
	 // Integer rowCount = driver.findElements(By.xpath("/html/body/main/table/tbody/tr")).size();
	  Integer rowCount = driver.findElements(By.xpath("//table/tbody/tr")).size()-1;
	  Assert.assertEquals(rowCount>0, true);
	  
	  String strEventCount = rowCount.toString();

	  System.out.println(strEventsHeader);
	  System.out.println("There are "+strEventCount+" events");
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


// /html/body/main/table