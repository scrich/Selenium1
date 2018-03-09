package testPlanningReg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestPlanningAppStatusParams {
	
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
	 
	 
  @Test
  @Parameters({"applicationNumber", "expectedStatus"})
  public void ParameterTest(String applicationNumber, String expectedStatus) {
	  
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
	  
	  String statusActual = statusFieldItem.getText();
	  System.out.println("Actual status is "+statusActual);
	  
	  Assert.assertEquals(statusActual, expectedStatus);
	  
	  // http://planningregister.brighton-hove.gov.uk/application/bh201800771
	  // assert planning app has expected status
	  // //*[@id="node-881851"]/div/div/div/fieldset/div/div[1]/div[2]
	  /** <div 
	   * 	class="
	   * 		field
	   * 		field-name-field-application-status
	   * 		field-type-taxonomy-term-reference 
	   * 		field-label-inline
	   * 		clearfix
	   * 		"
	   * 	>
	   * 	<div 
	   * 		class="
	   * 			field-label
	   * 		"
	   * 	>Application status:&nbsp;</div>
	   * 	<div class="field-items">
	   * 		<div class="field-item even">
	   * 			Received
	   * 		</div>
	   * 	</div>
	   * </div>
	   * 
	   * */
  
	  System.out.println("TEST TestPlanningAppStatus END");
	  
  }
 

  @AfterClass
  public void afterClass() {
		  System.out.println("Closing chrome browser");
		  driver.quit();
  }

}
