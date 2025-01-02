package skyselect_Maven.skyselect_Maven;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Buyer_Demo  {
	WebDriver driver= null; 
	public WebElementsPage webElementsPage;
	@Test
	public void Buyer_login() throws InterruptedException {
		  WebElement LoginPageTitle= driver.findElement(By.xpath("(//span[normalize-space()='Log in'])[1]"));
		  
		  String title= driver.getTitle();
		  System.out.println(title);
		  	//assertEquals(title,"Login");
//		    //WebElement username= driver.findElement(By.name("username"));
//		  	webElementsPage.getUsernameField().sendKeys("sales@airindia.com");
//		    //username.sendKeys();
//		    driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
//		    //driver.findElement(By.name("password")).sendKeys("Test@123");
//		    webElementsPage.getPasswordField().sendKeys("Test@123");
//		    //driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
//		    Reporter.log("Check login of Buyer",true);
//		    webElementsPage.getLoginButton().click();		    
//		    //driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
		    
		  
		  	webElementsPage.Login("sales@airindia.com", "Test@123");		  
		    String url_expected_buyerDashboard = "https://demo.skyselect.com/db/tender/purchases";
		    Thread.sleep(2000);
		    String url_actual_buyerDashboard = driver.getCurrentUrl(); 
		    String page_Title = driver.getTitle();	    
		    org.testng.Assert.assertEquals(url_actual_buyerDashboard,url_expected_buyerDashboard,"URL don't Match");
		    
		    Reporter.log("Logged in Successfully with: "+ driver.getTitle(),true);
		    
		    

	  }
	
	@Test(enabled = false)	
		public void verify_All_Pages_Buyer() throws InterruptedException {
		
		// Overview Dashboard
		WebElement link_Overview = driver.findElement(By.xpath("//li[@index='overview-dashboard']"));
		String url_expected_overview = "https://demo.skyselect.com/db/overview";
		link_Overview.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_overview = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_overview,url_expected_overview,"URL don't Match");
		System.out.println( driver.getTitle() +" Clicked");
		Reporter.log( url_actual_overview + "Clicked Page ",true);
		Thread.sleep(2000);
		
		// RFQ Dashboard
		WebElement link_rfqDashboard = driver.findElement(By.xpath("//li[@index='requests-sub-menu']"));
		String url_expected_rfqDashboard = "https://demo.skyselect.com/db/tender/purchases";
		link_rfqDashboard.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_rfqDashboard = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_rfqDashboard,url_expected_rfqDashboard,"URL don't Match");
		System.out.println(driver.getTitle()+ " Clicked");
		Reporter.log("Clicked Page /n"+ url_actual_rfqDashboard,true);
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
		System.out.println(driver.getTitle()+" Clicked");
		Reporter.log("Clicked Page /n"+ url_actual_awarding,true);
		//Order Dashboard
		WebElement link_orderDashboard = driver.findElement(By.xpath("//li[@index='orders-dashboard']"));
		String url_expected_orderDashboard = "https://demo.skyselect.com/db/orders/dashboard";
		link_orderDashboard.click();
		driver.getTitle();
		Thread.sleep(2000);
		String url_actual_orderDashboard = driver.getCurrentUrl();
		org.testng.Assert.assertEquals(url_actual_orderDashboard,url_expected_orderDashboard,"URL don't Match");
		Thread.sleep(2000);
		System.out.println(driver.getTitle()+" Clicked");
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
		System.out.println(driver.getTitle()+" Clicked");
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
		System.out.println(driver.getTitle()+" Clicked");
		Reporter.log("Clicked Page /n"+ url_actual_analytics,true);
//
//		// Setting Page
//		driver.findElement(By.xpath("//li[@class='el-sub-menu sub-menu main-sub-menu']"));
//		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
//		WebElement link_settingBuyer=driver.findElement(By.xpath("//li[@index='sub-menu-settings']"));
//		String url_expected_settingBuyer = "https://demo.skyselect.com/db/account";
//		link_settingBuyer.click();
//		driver.getTitle();
//		Thread.sleep(2000);
//		String url_actual_settingBuyer = driver.getCurrentUrl();
//		org.testng.Assert.assertEquals(url_actual_settingBuyer,url_expected_settingBuyer,"URL don't Match");
//		System.out.println(driver.getTitle()+" Clicked");

	}
	@Test(enabled = true)
	public void create_rfq() throws InterruptedException {
		
		//Check User Login
		Boolean flag = driver.findElement(By.xpath("//a[@class='router-link-active router-link-exact-active menu-item-link']//div[@class='menu-title']//*[name()='svg']//*[name()='use' and contains(@width,'14')]")).isDisplayed();
	    assertEquals(flag, true);
	    
	    if(webElementsPage.getbutton_new().isDisplayed())
	    {
	    	webElementsPage.getbutton_new().click();
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//span[normalize-space()='Request']")).click();;
	    	Thread.sleep(1000);
	    	WebElement popup_Text = driver.findElement(By.xpath("//div[@class='hText']"));
	    	String New_request_modal= popup_Text.getText();
	    	Reporter.log( New_request_modal + "Modal open Up",true);
	    	driver.findElement(By.xpath("//span[normalize-space()='Next']")).isDisplayed();
	    	if(driver.findElement(By.xpath("//div[contains(text(),'Outright Purchases')]")).isSelected())
	    	{
	    		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	    		
	    		
	    	}
	    	else {
	    		driver.findElement(By.xpath("//div[contains(text(),'Outright Purchases')]")).click();
	    		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	    		
	    	}	    	
	    	Reporter.log(driver.getTitle(),true);
	    	
	    	webElementsPage.txt_location().sendKeys("TLL");
	    	if(driver.findElement(By.xpath("//span[normalize-space()='Lennart Meri Tallinn Airport']")).isDisplayed())
	    	{
	    		driver.findElement(By.xpath("//span[normalize-space()='Lennart Meri Tallinn Airport']")).click();
	    	}
	    	else {
				Reporter.log("Location not found",true);
			}
	    	
	    	driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("REF_123");
	    	driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("TL123");
	    	
	    	
	    	//Enter Part No
	    	driver.findElement(By.xpath("//input[@id='part_no-input']")).sendKeys("DK120");
	    	
	    	//Enter Qty
	    	String get_qty= driver.findElement(By.xpath("//input[@id='qty']")).getText();
	    	Reporter.log("Default Set Qty : "+ get_qty,true);
	    	driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("11");
	    	
	    	
	    	//Condition Selection
	    	driver.findElement(By.xpath("(//div[@class='el-select__wrapper is-filterable el-tooltip__trigger el-tooltip__trigger'])[7]")).click();
	    	Thread.sleep(1000);
	    	if(driver.findElement(By.xpath("(//div[contains(text(),'New')])[1]")).isDisplayed())
	    	{
	    		driver.findElement(By.xpath("(//div[contains(text(),'New')])[1]")).click();
	    		Reporter.log("Condition Selected New",true);
	    			    		
	    	}
	    	
	    	//Description
	    	driver.findElement(By.id("description-input")).sendKeys("TEST PART");
	    	Reporter.log("Description added :Test Part",true);
	    	//Part line Save
	    	driver.findElement(By.xpath("//div[@class='main-button medium']//button[@type='button']")).click();
	    	
	    	//Enter Supplier email
	    	driver.findElement(By.xpath("//textarea[@id='el-id-8954-233']")).sendKeys("sales@bestpart.com");
	    	
	    	
	    	//Submit Button
	    	if(driver.findElement(By.xpath("//button[@class='button-element blue-dark uppercase']")).isEnabled())
	    	{
	    		driver.findElement(By.xpath("//button[@class='button-element blue-dark uppercase']")).click();
	    	}
	    	else {
	    		Reporter.log(" Submit Button not enabled",true);
	    			    		
	    	}
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
		
		
	}
	
	
	

	@BeforeClass
	public void setup() {
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

}
