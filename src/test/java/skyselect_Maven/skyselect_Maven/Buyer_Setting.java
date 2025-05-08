package skyselect_Maven.skyselect_Maven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Buyer_Setting extends BaseTest_Buyer {
	//WebDriver driver= null; 
	
	public WebElementsPage webElementsPage;
	@Test (enabled = false)
	public void verify_All_Pages_Buyer() throws InterruptedException {
		
		// Overview Dashboard
		WebElement link_Overview = driver.findElement(By.xpath("//li[@index='overview-dashboard']"));
		String url_expected_overview = "https://demo.skyselect.com/db/overview";
		link_Overview.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_overview = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_overview,url_expected_overview,"URL don't Match");
		System.out.println( driver.getTitle() +"Clicked");
		Reporter.log( url_actual_overview + "Clicked Page",true);
		Thread.sleep(2000);
		
		// RFQ Dashboard
		WebElement link_rfqDashboard = driver.findElement(By.xpath("//li[@class='el-sub-menu sub-menu']"));
		
		
		String url_expected_rfqDashboard = "https://demo.skyselect.com/db/tender/purchases";
		//driver.get(url_expected_rfqDashboard);
		link_rfqDashboard.click();
		
		if (driver.findElement(By.xpath("//span[normalize-space()='RFQs']")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[normalize-space()='RFQs']")).click();
		}
		
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_rfqDashboard = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_rfqDashboard,url_expected_rfqDashboard,"URL don't Match");
		System.out.println(driver.getTitle()+ "Clicked");
		Reporter.log("Clicked Page "+ url_actual_rfqDashboard,true);
		Thread.sleep(2000);
		
		//Awarding Dashboard
		WebElement link_awrding = driver.findElement(By.xpath("//li[@index='awarding']"));
		String url_expected_awarding = "https://demo.skyselect.com/db/awarding";
		link_awrding.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_awarding = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_awarding,url_expected_awarding,"URL don't Match");
		Thread.sleep(2000);
		System.out.println(driver.getTitle()+"Clicked");
		Reporter.log("Clicked Page "+ url_actual_awarding,true);
		//Order Dashboard
		WebElement link_orderDashboard = driver.findElement(By.xpath("//li[@index='orders-dashboard']"));
		String url_expected_orderDashboard = "https://demo.skyselect.com/db/orders/dashboard";
		link_orderDashboard.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_orderDashboard = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_orderDashboard,url_expected_orderDashboard,"URL don't Match");
		Thread.sleep(2000);
		System.out.println(driver.getTitle()+"Clicked");
		Reporter.log("Clicked Page /n"+ url_actual_orderDashboard,true);
		// SRM List
		WebElement link_srmList = driver.findElement(By.xpath("//li[@index='suppliers']"));
		String url_expected_srmList = "https://demo.skyselect.com/db/suppliers";
		link_srmList.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_srmList = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_srmList,url_expected_srmList,"URL don't Match");
		Thread.sleep(2000);
		System.out.println(driver.getTitle()+"Clicked");
		Reporter.log("Clicked Page /n"+ url_actual_srmList,true);
		// Analytics Page
		WebElement link_analytics = driver.findElement(By.xpath("//li[@index='analytics']"));
		String url_expected_analytics = "https://demo.skyselect.com/db/analytics";
		link_analytics.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_analytics = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_analytics,url_expected_analytics,"URL don't Match");
		Thread.sleep(2000);
		System.out.println(driver.getTitle()+"Clicked");
		Reporter.log("Clicked Page /n"+ url_actual_analytics,true);

	}
  
  @Test(enabled = false)
  public void buyerSetting() throws InterruptedException {
	  TakesScreenshot screenshot = (TakesScreenshot) driver;
	  File source = screenshot.getScreenshotAs(OutputType.FILE);

	  //webElementsPage.Login("sales@airindia.com", "Test@123");
	  String actual_url ="https://demo.skyselect.com/db/account" ;
	  System.out.println("This is New Login Derived from Logins");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='sub-menu-title']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//span[normalize-space()='Settings']")).click();
	  Thread.sleep(1000);
	  String currenturl= driver.getCurrentUrl();
	  org.testng.Assert.assertEquals(currenturl,actual_url,"URL don't Match");
	  
	  //Check All Setting Tab
	  driver.get("https://demo.skyselect.com/db/company/settings/view_general");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/view_usersincompany");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/view_folders");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/view_teams");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/view_rfqs");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/apisettings");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/view_awarding");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/view_spec2k");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/view_locations");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/view_orders");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/view_partcatalogs");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/view_report_groups");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/view_slas");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/account");
	  
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	  driver.get("https://demo.skyselect.com/db/company/settings/page_notice"); 
	  Reporter.log("Clicked Page  "+ driver.getTitle(),true);
	 	  
  }
  //General tab	
  @Test(enabled = true)
  public void general_setting() throws InterruptedException{
	  
	  Thread.sleep(1000);
	  String actual_url ="https://demo.skyselect.com/db/company/settings/view_general" ;
	  driver.get("https://demo.skyselect.com/db/company/settings/view_general");
	  String Currenturl= driver.getCurrentUrl();
	  org.testng.Assert.assertEquals(Currenturl,actual_url,"URL don't Match");
	  
	  
  } 
  @DataProvider(name = "partData")
  public static Iterator<Object[]> loginDataProvider() throws Exception {
      return data_read.readCSVData("test_data/data.csv","partno","description");
  }
 	
  
  @Test(enabled = true,dataProvider = "partData") //,dataProviderClass = BaseTest_Buyer.class
  public void data_check(String partno,String description)
  {
	  //System.out.println(username);
	  //System.out.println(password);
	  System.out.println(partno);
	  //System.out.println(qty);
	  System.out.println(description);
	  
  }

}
