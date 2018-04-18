package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FristTest {
	WebDriver driver; 
	
  @Test
  public void openBaidu() {
	  driver.get("https://www.baidu.com");
	  driver.findElement(By.id("kw")).sendKeys("Selenium");  
      driver.findElement(By.id("su")).click();  
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "D://test//chromedriver.exe");  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
  }

}
