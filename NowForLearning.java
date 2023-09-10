package besttime;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.print.PrintOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NowForLearning {
	
	//class variable or intense variable
	private WebDriver driver; 
	private String baseUrl;
	

	@BeforeClass(alwaysRun = true)  //annotation 
	  public void setUp() throws Exception {  //method header
		//method body
		
		//third liabrary to check browser versian and download the maching 
		//chrom driver file
		 WebDriverManager.chromedriver().setup();
		 
	   // System.setProperty("webdriver.chrome.driver", "src/test/resources/browser-driver/chromedriver.exe");  //key and value
	    driver = new ChromeDriver();  //lunch the browser
	    Thread.sleep(3000);
	    baseUrl = "https://www.google.com/";
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//help page to load 

	  }

	@Test
	  public void testUntitledTestCase() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.name("q")).clear();
	    driver.findElement(By.name("q")).sendKeys("Rose");
	    Thread.sleep(3000);
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    
	    assertEquals(driver.getTitle(),"Rose - Google Search");
	}
	
	
	@Test
	public void findlinks() {
		driver.get("https://www.costco.com/");

		List<WebElement> AllLinks = driver.findElements(By.tagName("a"));
		int Totallsize = AllLinks.size();
		

		int counter = 1;
		for (WebElement link : AllLinks) {
			String linkText = link.getText();

			if (!linkText.isEmpty()) {
				System.out.println("(" + counter + ") linktext is : " + linkText);
				counter++;
			}
		}
		System.out.println("Totall link is :" + Totallsize);
	}

	
	
	// check box 
	
	@Test
	public void checkBox() throws InterruptedException {
		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_checkbox";
		
		driver.get(url);
		driver = driver.switchTo().frame("iframeResult");
		Thread.sleep(1000);
		WebElement veh1 = driver.findElement(By.id("vehicle1"));
		veh1.click();
		Thread.sleep(3000);
		driver.findElement(By.id("vehicle2")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("vehicle3")).click();
		Thread.sleep(2000);
		driver = driver.switchTo().defaultContent();
		driver.quit();
	}
	
	
	//usps site 
	
	@Test
	public void usps() {
		try {
			String url = "https://www.usps.com/";
			driver.get(url);
			
			WebElement QuickElm = driver.findElement(By.partialLinkText("Quick Tool"));
			Actions action = new Actions(driver);
			action.moveToElement(QuickElm).build().perform();
			QuickElm.click();
			WebElement Tracking = driver.findElement(By.cssSelector("#g-navigation > div > nav > ul > li.qt-nav.menuheader > div > ul > li:nth-child(1) > a > img"));
			Thread.sleep(2000);
			Tracking.click();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

}
		
		
		
	
	
	
	
	
	





