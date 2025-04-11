package skyselect_Maven.skyselect_Maven;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
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
	public WebElementsPage webElementsPage; 
	
 @DataProvider(name = "loginData")
 public static Iterator<Object[]> loginDataProvider() throws Exception {
     return data_read.readCSVData("test_data/data.csv");
 }
	
   
  @Test (enabled = true, dataProvider ="loginData")
  public void login(String username,String password) {
	  
//	webElementsPage.getUsernameField().sendKeys(username);
//	webElementsPage.getPasswordField().sendKeys(password);
//	webElementsPage.getLoginButton().click();
	  WebElement uname= driver.findElement(By.xpath("//input[@placeholder='Email']"));
	  WebElement pwd= driver.findElement(By.xpath("//input[@placeholder='Password']"));
	  WebElement btn_submit= driver.findElement(By.xpath("//div[@class='main-button large login-form-button rounded']//button[@type='button']"));
	  
	  uname.sendKeys(username);
	  pwd.sendKeys(password);
	  btn_submit.click();
	
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
