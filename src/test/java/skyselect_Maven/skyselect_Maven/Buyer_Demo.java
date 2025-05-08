package skyselect_Maven.skyselect_Maven;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Buyer_Demo extends BaseTest_Buyer  {
	//WebDriver driver;
	//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
	public WebElementsPage webElementsPage; 
	public static String tender_link;
	
  
  @Test(enabled = false)
  public void buyerlogin() throws InterruptedException {  
	  
	  //webElementsPage.Login("sales@airindia.com", "Test@123");
	  String actual_url ="https://demo.skyselect.com/db/account" ;
	  System.out.println("This is New Login Derived from Logins");
	  Thread.sleep(1000);
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sub-menu-title']")));
	  WebElement pagetitle=driver.findElement(By.xpath("//div[@class='sub-menu-title']"));
	  assert pagetitle.isDisplayed(); 
	  
	   	  
  } 
  
  
  @Test(enabled = true,dataProvider = "partData",dataProviderClass = BaseTest_Buyer.class) //dependsOnMethods = {"buyerlogin"}
  public void create_rfq(String partno,String description,String qty) throws InterruptedException {
	  		testcaseId= "9992";
	  		webElementsPage = new WebElementsPage(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//Check User Login
			//Boolean flag = driver.findElement(By.xpath("//a[@class='router-link-active router-link-exact-active menu-item-link']//div[@class='menu-title']//*[name()='svg']//*[name()='use' and contains(@width,'14')]")).isDisplayed();
		    //assertEquals(flag, true);
			Thread.sleep(1000);
			 WebElement pagetitle=driver.findElement(By.xpath("//li[@class='el-sub-menu sub-menu']"));
			 assert pagetitle.isDisplayed(); 
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
		    	
		    	driver.findElement(By.xpath("//body/div[@id='app']/div[@id='app']/div[@class='create-rfq-page']/div[@class='rfq-details-section']/div[@class='section-row']/div[2]/div[2]/div[1]/div[2]/input[1]")).sendKeys("REF_123");
		    	driver.findElement(By.xpath("//body/div[@id='app']/div[@id='app']/div[@class='create-rfq-page']/div[@class='rfq-details-section']/div[@class='section-row']/div[3]/div[2]/div[1]/div[2]/input[1]")).sendKeys("TL123");
		    	
		    	
		    	//Enter Part No
		    	String exp_Part_no = "DK120";
		    	driver.findElement(By.xpath("//input[@id='part_no-input']")).sendKeys(partno);
		    	
		    	//Enter Qty
		    	String get_qty= driver.findElement(By.xpath("//input[@id='qty']")).getText();
		    	Reporter.log("Default Set Qty : "+ get_qty,true);
		    	driver.findElement(By.xpath("//input[@id='qty']")).clear();
		    	driver.findElement(By.xpath("//input[@id='qty']")).sendKeys(qty);
		    	
		    	
//		    	//Condition Selection
//		        
//		    	Thread.sleep(1000);
//		    
//		    	if(driver.findElement(By.xpath("(//div[@class='select-container'])[7]")).isDisplayed())
//		    	{
//		    		driver.findElement(By.xpath("(//div[@class='select-container'])[7]")).sendKeys("NEW");
//		    		driver.findElement(By.cssSelector("#el-id-2740-215")).click();
//		    		Reporter.log("Condition Selected :New",true);
//		    			    		
//		    	}
		    	// Scroll down
		    	js.executeScript("window.scrollTo(0,250)");
		    	Thread.sleep(1000);
		    	
		    	//Description
		    	driver.findElement(By.id("description-input")).sendKeys(description);
		    	Reporter.log("Description added :Test Part",true);
		    	Thread.sleep(1000);
		    	js.executeScript("window.scrollTo(0,250)");
		    	//Part line Save
		    	if(driver.findElement(By.xpath("//div[@class='main-button medium']//button[@type='button']")).isDisplayed())
		    	{
		    		
		    		driver.findElement(By.xpath("//div[@class='main-button medium']//button[@type='button']")).click();
		    		Thread.sleep(1000);
		    		String Print_part = driver.findElement(By.xpath("(//div)[203]")).getText(); 
		    		String Result_part = Print_part.substring(14);		   		
		    		System.out.println(Result_part + " This is valid");
		    		//org.testng.Assert.assertEquals(Result_part,exp_Part_no,"Part No not matched");
		    		Reporter.log("Part Added Successfully :"+ Result_part,true);
		    		
		    	}   	
		    	Thread.sleep(1000);  	
		    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		    	//Enter Supplier email
		    	driver.findElement(By.className("el-textarea__inner")).sendKeys("sales@bestpart.com");
		    	
		    	//Add Supplier Button
		    	if(driver.findElement(By.xpath("//div[@class='main-button large']//button[@type='button']")).isEnabled())
		    	{
		    		driver.findElement(By.xpath("//div[@class='main-button large']//button[@type='button']")).click();
		    		Thread.sleep(1000);
		    		
		    	}
		    	else {
		    		Reporter.log("Supplier is not added",true);
		    			    		
		    	}
		    	
		    	//Submit Button
		    	Thread.sleep(2000);
		    	if(driver.findElement(By.xpath("(//button[@class='button-element blue-dark uppercase'])[1]")).isEnabled()) 
		    	{
		    		Thread.sleep(200);
		    		driver.findElement(By.xpath("(//button[@class='button-element blue-dark uppercase'])[1]")).click();
		    		if(driver.findElement(By.className("notifications-list")).isDisplayed()) {
		    			Reporter.log(" RFQ Published Successfully",true);
		    		}
		    		else {
		    			Reporter.log(" RFQ not published",true);
		    		}
		    				
		    	}
		    	else {
		    		Reporter.log(" Submit Button not enabled",true);
		    	}
		    	
		    	Thread.sleep(2000);
		    	String url_qc= driver.getCurrentUrl();
		    	//System.out.println("RFQ created Successfully" + url_qc);
		    	Reporter.log( "RFQ created Successfully" +url_qc,true);
		    	tender_link = url_qc;
		    	
		    	// Split the string by "id_"
		        String[] parts = url_qc.split("id_");
		        if (parts.length > 1) {
		            String extractedId = parts[1];
		            System.out.println("Extracted ID: " + extractedId);
		        } else {
		            System.out.println("No ID found in the string.");
		        }


		    }		    
	  
  }
  @Test(enabled = true,dependsOnMethods = {"create_rfq"})
  public void rfq_check() {
	  testcaseId= "9993";
	  // Define explicit wait
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));  // Wait for 10 seconds
   // Wait until the element is visible
      WebElement rfq_header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='request-title request-header-block']")));
      // Perform actions after the element is visible
      assert rfq_header.isDisplayed();
      String rfq_title=driver.findElement(By.xpath("//div[@class='request-title request-header-block']")).getText();
      Reporter.log(rfq_title,true);  
	 
  }
  
  @Test(enabled = true,dependsOnMethods = {"rfq_check"}) 
	  public void qc_check() { 
	  driver.get(tender_link);  
	  driver.navigate().refresh();	
	  System.out.println("QC page is Opened");
	  Reporter.log(tender_link +" Opened",true );
	  
	  }
  @Test (enabled = true,dependsOnMethods = {"rfq_check"})
  public void qc_action_1() {
	  
	  WebElement qc_part= driver.findElement(By.xpath("//div[@class='label-text']"));
	  assert qc_part.isDisplayed();
	  System.out.println(qc_part.getText());	  
	  
	  
  }
  }

  
	


