package pack_Basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


	public class VerifyText {
		WebDriver driver;
	
		@BeforeTest
		public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);*/
		
	}
		@Test
		public void verifyText() {
			driver.get("https://www.google.com");
			WebElement Text=driver.findElement(By.linkText("About"));
			String actualtext=Text.getText();
			System.out.println("Text is :"+actualtext);
			String expectedtext="About";
			Assert.assertEquals(actualtext, expectedtext);
			/*if(actualtext==expectedtext) {
				System.out.println("print Text :"+actualtext);
			}
			else {
				System.out.println("wrong text");
			}
			*/
			
			
			
			
		}
	

}
