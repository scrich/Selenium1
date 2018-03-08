package choirTestNG;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class TestChromeBrowser {
		
		static String driverPath = "/Applications/Selenium/";
		public WebDriver driver;
		
		@BeforeClass
		public void setUp() {
			System.out.println("*******************");
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		@Test
		public void testChoirPageTitleInChrome() {
			driver.navigate().to("http://localhost:8888/choir-prod");
			String strPageTitle = driver.getTitle();
			System.out.println("Page title: - "+strPageTitle);
			Assert.assertTrue(strPageTitle.equalsIgnoreCase("The Embassy Singers"), "Page title doesn't match");
		}

		@AfterClass
		public void tearDown() throws InterruptedException {
			
			Thread.sleep(2000);
			
			if(driver!=null) {
				System.out.println("Closing chrome browser");
				driver.quit();
			}
		}
		
	}
