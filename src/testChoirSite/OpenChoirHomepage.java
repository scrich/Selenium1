package testChoirSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChoirHomepage {
	
 public static String driverPath = "/Applications/Selenium/";
 public static WebDriver driver;
 
	public static void main(String []args) throws InterruptedException {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver");
		driver = new ChromeDriver();
		driver.navigate().to("http://embassysingers.de");
		
		Thread.sleep(2000);
		
		System.out.println("Closing chrome browser");
		driver.quit();
	}
}