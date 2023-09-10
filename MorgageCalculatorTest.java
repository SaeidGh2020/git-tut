package besttime;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MorgageCalculatorTest {
	
	private WebDriver driver;
	private String WebsiteURL = "https://www.mortgagecalculator.net/";
	
	
	@Test
	
	public void BuyHouse() throws InterruptedException{
		
	System.setProperty("webdriver.chrome.driver", "src/test/resources/browser-driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(WebsiteURL);
		driver.manage().window().maximize();
		
		String websiteTitle = driver.getTitle();
		assertEquals(websiteTitle, "Mortgage Calculator 2023 - FREE Calculator Tool (ZERO Ads)");
		Thread.sleep(2000);
		driver.close();
		
		
	}
	

}
