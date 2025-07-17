package skyselect_Maven.skyselect_Maven;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.test.TestRailManager.TestrailManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.ReporterLogger;
import utility.utilities;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

//skyselect_Maven.skyselect_Maven.NewTest;

public class BaseTest_Buyer {
	WebDriver driver;
	utilities ul=new utilities();
	public WebElementsPage webElementsPage; 
	protected String testcaseId;
	ExtentTest test;
	
	
	
	
 @DataProvider(name = "loginData")
 public static Iterator<Object[]> loginData() throws Exception {
     return data_read.readCSVData("test_data/data.csv","username","password");
 }
 
 @DataProvider(name = "partData")
 public static Iterator<Object[]> partsData() throws Exception {
     return data_read.readCSVData("test_data/data.csv","partno","description","qty");
 }
	
	
   
  @Test (enabled = true, dataProvider ="loginData")
  public void login(String username,String password) throws InterruptedException {
	  testcaseId= "9899";
	  
//	webElementsPage.getUsernameField().sendKeys(username);
//	webElementsPage.getPasswordField().sendKeys(password);
//	webElementsPage.getLoginButton().click();
	  WebElement uname= driver.findElement(By.xpath("//input[@placeholder='Email']"));
	  WebElement pwd= driver.findElement(By.xpath("//input[@placeholder='Password']"));
	  WebElement btn_submit= driver.findElement(By.xpath("//div[@class='main-button large login-form-button rounded']//button[@type='button']"));
	  
	  uname.sendKeys(username);
	  pwd.sendKeys(password);
	  btn_submit.click();
	  Thread.sleep(1000);
	  WebElement pagetitle=driver.findElement(By.xpath("//div[@class='sub-menu-title']"));
	  Thread.sleep(500);
	  assert pagetitle.isDisplayed(); 
	  test.fail("Step failed", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
  }


  @Test (enabled = false)
  public void secondtest() {
	  System.out.println("Check Second Program");
  }

  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  ReporterLogger.startLogging();
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  test = ExtentReportManager.createTest("Skyselect DEMO Check");
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("https://demo.skyselect.com");
	  //login("sales@airindia.com", "Test@123");
	  
	 

  }

  @AfterClass
  public void afterClass() { 	
	  System.out.println("Check After Class");
	  ReporterLogger.stopLogging();
	  ExtentReportManager.flushReport();

	  //driver.quit();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Check before Method in Run");
	  
	  
  }
  @AfterMethod
 public void addResultToTestRail(ITestResult result) {
	  if (result.getStatus() == ITestResult.SUCCESS) {
		  TestrailManager.addResultForTestCase(testcaseId,TestrailManager.TEST_CASE_PASS_STATUS, "Test got Passed");
	  }
	  else if (result.getStatus() == ITestResult.FAILURE) {
		  TestrailManager.addResultForTestCase(testcaseId,TestrailManager.TEST_CASE_FAIL_STATUS, 
				  "Test got Failed" + result.getName()+": FAILED");
		  
	}
	  
  } 	

}
