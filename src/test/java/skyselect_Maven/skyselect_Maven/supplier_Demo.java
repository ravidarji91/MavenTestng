package skyselect_Maven.skyselect_Maven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class supplier_Demo {
  WebDriver driver= null;
  public WebElementsPage webElementsPage;
  @Test
  public void supplire_login() throws InterruptedException {
	  WebElement LoginPageTitle= driver.findElement(By.xpath("(//span[normalize-space()='Log in'])[1]"));
	  
	  String title= driver.getTitle();
	  System.out.println(title);
	  	//assertEquals(title,"Login");
//	    WebElement username= driver.findElement(By.name("username"));
//	    username.sendKeys("sales@bestpart.com");
//	    driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
//	    driver.findElement(By.name("password")).sendKeys("Test@123");
//	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
//	    Reporter.log("Check login of Supplier",true);
//	    driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	  	webElementsPage.Login("sales@bestpart.com", "Test@123");
	    
	    String url_expected_suppDashboard = "https://demo.skyselect.com/db/tender/supplierview";
	    Thread.sleep(2000);
	    String url_actual_suppDashboard = driver.getCurrentUrl(); 
	    String page_Title = driver.getTitle();	    
	    org.testng.Assert.assertEquals(url_actual_suppDashboard,url_expected_suppDashboard,"URL don't Match");
	    

  }
  @Test
  public void verify_All_Pages_Supplier() throws InterruptedException {
	  //Supplier Dashboard Verify https://demo.skyselect.com/db/tender/supplierview
		WebElement link_supplierDashboard = driver.findElement(By.xpath("//li[@index='supplier-quotes']"));
		String url_expected_supplierDashboard = "https://demo.skyselect.com/db/tender/supplierview";
		link_supplierDashboard.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_supplierDashboard = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_supplierDashboard,url_expected_supplierDashboard,"URL don't Match");
		Thread.sleep(2000);
		System.out.println(driver.getTitle()+" Clicked");
		Reporter.log("Clicked Page /n"+ url_actual_supplierDashboard,true);
	  //Order Dashboard Verify https://demo.skyselect.com/db/orders/dashboard
		WebElement link_orderDashboard = driver.findElement(By.xpath("//li[@index='orders-dashboard']"));
		String url_expected_orderDashboard = "https://demo.skyselect.com/db/orders/dashboard";
		link_orderDashboard.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_orderDashboard = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_orderDashboard,url_expected_orderDashboard,"URL don't Match");
		Thread.sleep(2000);
		Reporter.log("Clicked Page /n"+ url_actual_orderDashboard,true);
		System.out.println(driver.getTitle()+" Clicked");
	  
	  //Insight https://demo.skyselect.com/db/insights
		WebElement link_supplierInsight = driver.findElement(By.xpath("//li[@index='market-insights']"));
		String url_expected_supplierInsight = "https://demo.skyselect.com/db/insights";
		link_supplierInsight.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_supplierInsight = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_supplierInsight,url_expected_supplierInsight,"URL don't Match");
		Thread.sleep(2000);
		System.out.println(driver.getTitle()+" Clicked");
		Reporter.log("Clicked Page /n" +url_expected_supplierInsight,true);	  
		
	  //Analytics https://demo.skyselect.com/db/analytics
		WebElement link_analytics = driver.findElement(By.xpath("//li[@index='analytics']"));
		String url_expected_analytics = "https://demo.skyselect.com/db/analytics";
		link_analytics.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_analytics = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_analytics,url_expected_analytics,"URL don't Match");
		Thread.sleep(2000);
		System.out.println(driver.getTitle()+" Clicked");
		Reporter.log("Clicked Page /n" +url_actual_supplierInsight,true);	
	  
	  //Buyer https://demo.skyselect.com/db/buyers  
		WebElement link_supplierBRM = driver.findElement(By.xpath("//li[@index='buyers']"));
		String url_expected_supplierBRM = "https://demo.skyselect.com/db/buyers";
		link_supplierBRM.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_supplierBRM = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_supplierBRM,url_expected_supplierBRM,"URL don't Match");
		Thread.sleep(2000);
		System.out.println(driver.getTitle()+" Clicked");		
	     
		
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  //System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver-win64\\chromedriver.exe");
	  WebDriverManager.chromedriver().setup();
	  
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.manage().deleteAllCookies();
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("https://demo.skyselect.com");
	  webElementsPage = new WebElementsPage(driver);
	  
  }

  @AfterClass
  public void afterClass() {
	//driver.quit();
	  
	  
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
