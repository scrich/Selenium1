package testPlanningReg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

public class TestPlanningAppStatusDataProv {
	
	static String driverPath = "/Applications/Selenium/";
	public WebDriver driver;
	
	
  @BeforeClass
  public void beforeClass() {
	  System.out.println("*******************");
	  System.out.println("launching chrome browser");
	  System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
	 
  @DataProvider(name="testdata")
  public Object[][] createData1() {
	  // here we will need a list generated from the db in the format:
	  // {"applicationNumber","expectedStatus"}
	  return new Object[][] {
		  {"bh201800771","Received"},
		  {"bh201800772","Received"},
		  {"bh201800768","Invalid"},
		  {"bh201800723","Under Consideration"}
	  };
  }
  
	 
  @Test(dataProvider = "testdata")
  public void PlanningRegStatusTest(String applicationNumber, String expectedStatus) {
	  
	  // get expected status of planning app from csv
	  //planning app ref
	  //status
	  System.out.println("TEST TestPlanningAppStatus START");
	  System.out.println("applicationNumber is "+applicationNumber);
	  System.out.println("expectedStatus is "+expectedStatus);
	  
	  driver.navigate().to("https://planningregister.brighton-hove.gov.uk/application/"+applicationNumber);
	  
	  WebElement statusElement;
	  statusElement = driver.findElement(By.className("field-name-field-application-status"));
	  System.out.println(statusElement.getText());
	  
	  WebElement statusFieldItem;
	  statusFieldItem = statusElement.findElement(By.className("field-item"));
	  
	  String actualStatus = statusFieldItem.getText();
	  System.out.println("Actual status is "+actualStatus);
	 
	  String betterActualStatus = ((driver.findElement(By.className("field-name-field-application-status")))
			  .findElement(By.className("field-item")))
			  .getText();
	  
	  System.out.println("better actual status is " +betterActualStatus);
	  
	  Assert.assertEquals(actualStatus, expectedStatus);
	 
	  System.out.println("TEST TestPlanningAppStatus END");
	  
  }
 

  @AfterClass
  public void afterClass() {
		  System.out.println("Closing chrome browser");
		 driver.quit();
  }

}
