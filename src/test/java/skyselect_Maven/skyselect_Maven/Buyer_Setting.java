package skyselect_Maven.skyselect_Maven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Buyer_Setting {
	WebDriver driver= null; 
	public WebElementsPage webElementsPage; 
  
  @Test(enabled = false)
  public void buyerSetting() throws InterruptedException {	  
	  
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
	  String currenturl= driver.getCurrentUrl();
	  org.testng.Assert.assertEquals(currenturl,actual_url,"URL don't Match");
	  
	  
  } 
  
  
	

  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.manage().deleteAllCookies();
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("https://demo.skyselect.com");
	  webElementsPage = new WebElementsPage(driver);
	  webElementsPage.Login("sales@airindia.com", "Test@123");
  
	  

  }

  @AfterClass
  public void afterClass() {
  }

}
