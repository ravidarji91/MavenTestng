package skyselect_Maven.skyselect_Maven;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.ReporterLogger;
import utility.utilities;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.awt.Desktop.Action;
import java.awt.Scrollbar;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Buyer_RFQ_check extends BaseTest_Buyer {
	
	Buyer_RFQ_create brc= new Buyer_RFQ_create();
	String tender_lnk= "https://demo.skyselect.com/db/tender/buyerview/id_2140#bids";//brc.tender_link;
	//WebDriver driver; 
	public WebElementsPage webElementsPage; 
	utilities ul = new utilities();
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	 @Test(enabled = true, priority = 1 )
	  public void tab_req_detail() throws InterruptedException {
		 ExtentTest test = ExtentReportManager.createTest("RFQ Details Verify");
		 try {
		  System.out.println("RFQ Dashboard opened");
		  Thread.sleep(1000);

		  Reporter.log("RFQ Dashboard opened",true);
		  ReporterLogger.log("RFQ Dashboard Opened");
		
		  Thread.sleep(1000);
		  driver.get("https://demo.skyselect.com/db/tender/buyerview/id_2092#bids");
		  //driver.get(tender_lnk);			  
		  Reporter.log("Tender Opened",true);
		  ReporterLogger.log("Tender Opened");
		  
		  driver.findElement(By.xpath("//span[normalize-space()='Request details']")).click();
		  assert driver.findElement(By.xpath("//div[normalize-space()='RFQ type']")).isDisplayed();
		  
		  Reporter.log("Request Details Open",true);
		  ReporterLogger.log("Request Details Open");
		  //System.out.println("Request Details Open");
		  
		  List<WebElement> rfq_detail_list = driver.findElements(By.xpath("//*[contains(@class,'request-details-row')]"));
		  
		  for(WebElement each_detail : rfq_detail_list)
		  {
			  String rfq_line_detail = each_detail.getText();
			  Thread.sleep(500);
			  assert each_detail.isDisplayed();		 
			  Reporter.log(rfq_line_detail,true);
			  ReporterLogger.log(rfq_line_detail);
			  
		  }
		}
		 catch (Exception e) {
		        // Capture screenshot and log failure
			 test.fail("Step failed", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		    }

	  }	
	
  @Test(enabled= false, priority = 2)
  public void quote_verify()  throws Throwable {
	  		 webElementsPage = new WebElementsPage(driver);
	  		  JavascriptExecutor js = (JavascriptExecutor) driver;
		
//			  Reporter.log("RFQ Dashboard opened",true);
//			  Thread.sleep(1000);
//			  driver.get("https://demo.skyselect.com/db/tender/buyerview/id_2092#bids");
//			  //driver.get(tender_lnk);
			 Thread.sleep(500); 
			 //driver.findElement(By.xpath("//div[@class='quote-item-header']")).click();
			 if(!driver.findElement(By.xpath("//div[@class='quote-item-header']")).isDisplayed()) {
				 
				 driver.findElement(By.xpath("//span[normalize-space()='Quotes']")).click();
				 assert driver.findElement(By.xpath("//div[@class='quote-item-header']")).isDisplayed();
				 Reporter.log("PNs Are  Visible");
				 
				 if(!driver.findElement(By.xpath("//*[contains(@class,'quote-item-row')]")).isDisplayed())
				 {
					 driver.findElement(By.xpath("//div[@class='quote-item-header']")).click();
					 Reporter.log("Quote row Clicked");
					 
				 }
				 else {
					 Reporter.log("Quote Row visible");
				 }
				 
			 }
			 
			 
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			  List<WebElement> quote_list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'quote-item-row')]")));//driver.findElements(By.xpath("//*[contains(@class,'quote-item-row')]"));
			  int count = quote_list.size();
			  System.out.println("Total Quote Received: "+ count);
			  if (quote_list.size() !=  0) {
				
				  for (WebElement radio : quote_list) {
				            //radio.click();
				            Thread.sleep(500); // Optional: just to see the clicks in action //*[contains(@class,'part-no-container with-supplier-name')]
				            Reporter.log("Quote is Clicked",true);
				            js.executeScript("arguments[0].scrollIntoView(true);", radio); 
				            String quote_supplier = radio.findElement(By.xpath(".//*[contains(@class,'part-no-container with-supplier-name')]")).getText();
				            Thread.sleep(500);
				            WebElement hover_quotetype= radio.findElement(By.xpath(".//*[contains(@class,'icon-container source')]"));
				            Actions actions= new Actions(driver);
				            actions.moveToElement(hover_quotetype).perform();
					        String quote_type1= driver.findElement(By.xpath("/html/body/div[2]/div[12]")).getText();
				            Reporter.log("Quote is from: " +quote_supplier + "| Quote Type :" + quote_type1 ,true);
    
			    }
			  }
			 assert driver.findElement(By.xpath("//div[@class='auto-propsed']")).isDisplayed();
			 if (driver.findElement(By.xpath("//div[@class='auto-propsed']")).isDisplayed()) {
				 System.out.println("Skyselect  Prefered Quote is Available");
				 Reporter.log("Skyselect  Prefered Quote is Available",true);
				 System.out.println( "Quote value : "+ driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div[2]/div[1]/div/div/div[2]/div[4]/div/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[19]/div/div[1]/div[2]/div")).getText());

			 }
			 else {System.out.println("No Skyselect Prefered Quote found.");}
   
  }
  

 
 
}
