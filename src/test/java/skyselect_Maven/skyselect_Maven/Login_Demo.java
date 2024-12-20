package skyselect_Maven.skyselect_Maven;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

@Test
public class Login_Demo  {
	public WebDriver driver; 
	
  
	public void logintrialBuyer(WebDriver driver) throws InterruptedException {
	  WebElement LoginPageTitle= driver.findElement(By.xpath("(//span[normalize-space()='Log in'])[1]"));
	  String title= driver.getTitle();
	  System.out.println(title);
	  	//assertEquals(title,"Login");
	    WebElement username= driver.findElement(By.name("username"));
	    username.sendKeys("sales@airindia.com");
	    driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
	    driver.findElement(By.name("password")).sendKeys("Test@123");
	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	    
	    String url_expected_Dashboard = "https://demo.skyselect.com/db/tender/purchases";
	    Thread.sleep(2000);
	    String url_actual_Dashboard = driver.getCurrentUrl(); 
	    String page_Title = driver.getTitle();	    
	    Reporter.log("Clicked Page /n"+ url_actual_Dashboard,true);
	    org.testng.Assert.assertEquals(url_actual_Dashboard,url_expected_Dashboard,"URL don't Match");
	    

  }
//	public void verify_All_Pages_Buyer() throws InterruptedException {
//		
//		// Overview Dashboard
//		WebElement link_Overview = driver.findElement(By.xpath("//li[@index='overview-dashboard']"));
//		String url_expected_overview = "https://demo.skyselect.com/db/overview";
//		link_Overview.click();
//		driver.getTitle();
//		Thread.sleep(2000);
//		String url_actual_overview = driver.getCurrentUrl();
//		org.testng.Assert.assertEquals(url_actual_overview,url_expected_overview,"URL don't Match");
//		System.out.println( driver.getTitle() +" Clicked");
//		Reporter.log( url_actual_overview + "Clicked Page ",true);
//		Thread.sleep(2000);
//		
//		// RFQ Dashboard
//		WebElement link_rfqDashboard = driver.findElement(By.xpath("//li[@index='requests-sub-menu']"));
//		String url_expected_rfqDashboard = "https://demo.skyselect.com/db/tender/purchases";
//		link_rfqDashboard.click();
//		driver.getTitle();
//		Thread.sleep(2000);
//		String url_actual_rfqDashboard = driver.getCurrentUrl();
//		org.testng.Assert.assertEquals(url_actual_rfqDashboard,url_expected_rfqDashboard,"URL don't Match");
//		System.out.println(driver.getTitle()+ " Clicked");
//		Reporter.log("Clicked Page /n"+ url_actual_rfqDashboard,true);
//		Thread.sleep(2000);
//		
//		//Awarding Dashboard
//		WebElement link_awrding = driver.findElement(By.xpath("//li[@index='awarding']"));
//		String url_expected_awarding = "https://demo.skyselect.com/db/awarding";
//		link_awrding.click();
//		driver.getTitle();
//		Thread.sleep(2000);
//		String url_actual_awarding = driver.getCurrentUrl();
//		org.testng.Assert.assertEquals(url_actual_awarding,url_expected_awarding,"URL don't Match");
//		Thread.sleep(2000);
//		System.out.println(driver.getTitle()+" Clicked");
//		Reporter.log("Clicked Page /n"+ url_actual_awarding,true);
//		//Order Dashboard
//		WebElement link_orderDashboard = driver.findElement(By.xpath("//li[@index='orders-dashboard']"));
//		String url_expected_orderDashboard = "https://demo.skyselect.com/db/orders/dashboard";
//		link_orderDashboard.click();
//		driver.getTitle();
//		Thread.sleep(2000);
//		String url_actual_orderDashboard = driver.getCurrentUrl();
//		org.testng.Assert.assertEquals(url_actual_orderDashboard,url_expected_orderDashboard,"URL don't Match");
//		Thread.sleep(2000);
//		System.out.println(driver.getTitle()+" Clicked");
//		Reporter.log("Clicked Page /n"+ url_actual_orderDashboard,true);
//		// SRM List
//		WebElement link_srmList = driver.findElement(By.xpath("//li[@index='suppliers']"));
//		String url_expected_srmList = "https://demo.skyselect.com/db/suppliers";
//		link_srmList.click();
//		driver.getTitle();
//		Thread.sleep(2000);
//		String url_actual_srmList = driver.getCurrentUrl();
//		org.testng.Assert.assertEquals(url_actual_srmList,url_expected_srmList,"URL don't Match");
//		Thread.sleep(2000);
//		System.out.println(driver.getTitle()+" Clicked");
//		Reporter.log("Clicked Page /n"+ url_actual_srmList,true);
//		// Analytics Page
//		WebElement link_analytics = driver.findElement(By.xpath("//li[@index='analytics']"));
//		String url_expected_analytics = "https://demo.skyselect.com/db/analytics";
//		link_analytics.click();
//		driver.getTitle();
//		Thread.sleep(2000);
//		String url_actual_analytics = driver.getCurrentUrl();
//		org.testng.Assert.assertEquals(url_actual_analytics,url_expected_analytics,"URL don't Match");
//		Thread.sleep(2000);
//		System.out.println(driver.getTitle()+" Clicked");
//		Reporter.log("Clicked Page /n"+ url_actual_analytics,true);
////
////		// Setting Page
////		driver.findElement(By.xpath("//li[@class='el-sub-menu sub-menu main-sub-menu']"));
////		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
////		WebElement link_settingBuyer=driver.findElement(By.xpath("//li[@index='sub-menu-settings']"));
////		String url_expected_settingBuyer = "https://demo.skyselect.com/db/account";
////		link_settingBuyer.click();
////		driver.getTitle();
////		Thread.sleep(2000);
////		String url_actual_settingBuyer = driver.getCurrentUrl();
////		org.testng.Assert.assertEquals(url_actual_settingBuyer,url_expected_settingBuyer,"URL don't Match");
////		System.out.println(driver.getTitle()+" Clicked");
//
//	}
//  
	@BeforeClass
	public void beforeClass() {
	  //System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver-win64\\chromedriver.exe");
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("https://demo.skyselect.com");
	  
  }

  @AfterClass
  public void afterClass() {
	 //driver.quit();
  }

}
