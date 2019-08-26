package pack_Basic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowser {
	
	WebDriver driver;
	@BeforeTest
	public void setUp() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","C:\\ITTraining\\Chrome\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get("https://www.rediff.com/");
		
	}
	//@Test
	public void getCurrentURL() {
		//driver.get("https://www.rediff.com/");
		String CURL=driver.getCurrentUrl();
		System.out.println("URL is  :"+CURL);
		
		String Title=driver.getTitle();
		System.out.println("Title is  :"+Title);
		 WebElement wb=driver.findElement(By.xpath("//*[@id=\"red_container_main\"]/div[1]/div[1]/h3"));
		 String wb1=wb.getText();
		 System.out.println("Text is  :"+wb1);
		 
	}
	@Test
	public void subMenuHandle() throws  IOException{
		WebElement menu=driver.findElement(By.linkText("NEWS"));
		 Actions act=new Actions(driver);
		 act.moveToElement(menu).build().perform();
		menu.click();
		
		
		
	}
	@Test
	public void getScreenShot() throws IOException {
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File ("C:\\ITTraining\\reddiff.jpg"));
		
	}
	
	
	//@AfterTest
	public void tearDown() {
		
		driver.close();
	}

}
