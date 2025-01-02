package skyselect_Maven.skyselect_Maven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

//skyselect_Maven.skyselect_Maven.NewTest;

public class NewTest {
	WebDriver driver = null;
	@Test@DataProvider(name= "testData")
	public void checkData(String Username,String Password) {
//		WebElement username= driver.findElement(By.name("username"));
//		username.sendKeys(Username);
		System.out.println("Testing login with username: " + Username + " and password: " + Password);
		
		
		
	}
	

	
  @Test(dataProvider = "testData", dataProviderClass = data_read.class)
  public void firsttest(String values) {
	  System.out.println("Check First Program");
	  System.out.println("This is Dataprovider string" +values);
	  
	  //driver.get("demo.skyselect.com");
//	  String current_title =driver.getTitle();
//	  boolean flag = false;
//	  if (current_title.contains("Gma")) {
//		  flag = true;
//	  }
	  
	  
	  
	  
  }
  @Test (enabled = false)
  public void secondtest() {
	  System.out.println("Check Second Program");
  }

  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("https://demo.skyselect.com");
  }

  @AfterClass
  public void afterClass() { 	
	  System.out.println("Check After Class");
	  //driver.quit();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Check before Method in Run");
	  
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("Check Post Method in Run");
  }

}
