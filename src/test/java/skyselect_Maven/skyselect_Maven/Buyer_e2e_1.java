package skyselect_Maven.skyselect_Maven;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;
import com.test.TestRailManager.TestrailManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReporterLogger;
import utility.utilities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

//skyselect_Maven.skyselect_Maven.NewTest;

public class Buyer_e2e_1 extends BaseTest_Buyer {
	//WebDriver driver;
	public WebElementsPage webElementsPage; 
	public static String tender_link;
	public static String order_draft_link;
	utilities ul= new utilities();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	//Create RFQ Case
	@Test(enabled = true,dataProvider = "partData",dataProviderClass = BaseTest_Buyer.class,priority = 1) //dependsOnMethods = {"buyerlogin"}
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
	    	ReporterLogger.log( New_request_modal + "Modal open Up");
	    	driver.findElement(By.xpath("//span[normalize-space()='Next']")).isDisplayed();
	    	if(driver.findElement(By.xpath("//div[contains(text(),'Outright Purchases')]")).isSelected())
	    	{
	    		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	    	}
	    	else {
	    		driver.findElement(By.xpath("//div[contains(text(),'Outright Purchases')]")).click();
	    		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	    		
	    	}	    	
	    	ReporterLogger.log(driver.getTitle());
	    	
	    	webElementsPage.txt_location().sendKeys("TLL");
	    	if(driver.findElement(By.xpath("//span[normalize-space()='Lennart Meri Tallinn Airport']")).isDisplayed())
	    	{
	    		driver.findElement(By.xpath("//span[normalize-space()='Lennart Meri Tallinn Airport']")).click();

	    	}
	    	else {
				ReporterLogger.log("Location not found");
			}
	    	
	    	driver.findElement(By.xpath("//body/div[@id='app']/div[@id='app']/div[@class='create-rfq-page']/div[@class='rfq-details-section']/div[@class='section-row']/div[2]/div[2]/div[1]/div[2]/input[1]")).sendKeys("REF_123");
	    	driver.findElement(By.xpath("//body/div[@id='app']/div[@id='app']/div[@class='create-rfq-page']/div[@class='rfq-details-section']/div[@class='section-row']/div[3]/div[2]/div[1]/div[2]/input[1]")).sendKeys("TL123");
	    	//Enter Part No
	    	String exp_Part_no = "DK120";
	    	driver.findElement(By.xpath("//input[@id='part_no-input']")).sendKeys(partno);
	    	
	    	//Enter Qty
	    	String get_qty= driver.findElement(By.xpath("//input[@id='qty']")).getText();
	    	ReporterLogger.log("Default Set Qty : "+ get_qty);
	    	driver.findElement(By.xpath("//input[@id='qty']")).clear();
	    	driver.findElement(By.xpath("//input[@id='qty']")).sendKeys(qty);
	    	// Scroll down
	    	js.executeScript("window.scrollTo(0,250)");
	    	Thread.sleep(1000);
	    	
	    	//Description
	    	driver.findElement(By.id("description-input")).sendKeys(description);
	    	ReporterLogger.log("Description added :Test Part");
	    	Thread.sleep(1000);
	    	js.executeScript("window.scrollTo(0,250)");
	    	
	    	//Part line Save
	    	if(driver.findElement(By.xpath("//div[@class='main-button medium']//button[@type='button']")).isDisplayed())
	    	{
  		
	    		driver.findElement(By.xpath("//div[@class='main-button medium']//button[@type='button']")).click();
	    		Thread.sleep(1000);
	    		String Print_part = driver.findElement(By.xpath("(//div)[203]")).getText(); 
	    		String Result_part = Print_part.substring(14);		   		
	    		ReporterLogger.log(Result_part + " This is valid");
	    		//org.testng.Assert.assertEquals(Result_part,exp_Part_no,"Part No not matched");
	    		ReporterLogger.log("Part Added Successfully :"+ Result_part);
	    		
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
	    		ReporterLogger.log("Supplier is not added");
	    			    		
	    	}
   	
	    	//Submit Button
	    	Thread.sleep(2000);
	    	if(driver.findElement(By.xpath("(//button[@class='button-element blue-dark uppercase'])[1]")).isEnabled()) 
	    	{
	    		Thread.sleep(200);
	    		driver.findElement(By.xpath("(//button[@class='button-element blue-dark uppercase'])[1]")).click();
	    		if(driver.findElement(By.className("notifications-list")).isDisplayed()) {
	    			ReporterLogger.log(" RFQ Published Successfully");
	    		}
	    		else {
	    			ReporterLogger.log(" RFQ not published");
	    		}
	    				
	    	}
	    	else {
	    		ReporterLogger.log(" Submit Button not enabled");
	    	}
	
	    	Thread.sleep(2000);
	    	String url_rfq= driver.getCurrentUrl();
	    	ReporterLogger.log( "RFQ created Successfully" +url_rfq);
	    		
	    	// Split the string by "id_"
	        String[] parts = url_rfq.split("id_");
	        if (parts.length > 1) {
	            String extractedId = parts[1];
	            ReporterLogger.log("Extracted ID: " + extractedId);
	        } else {
	            ReporterLogger.log("No ID found in the string.");
	        }
	    }		    
  
	  }
	 
	//RFQ Verify
	@Test(enabled = true,dependsOnMethods = {"create_rfq"},priority = 2)
	  public void rfq_verify() {
		  testcaseId= "9993";
		  // Define explicit wait
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));  // Wait for 10 seconds
	      // Wait until the element is visible
	      WebElement rfq_header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='request-title request-header-block']")));
	      // Perform actions after the element is visible
	      assert rfq_header.isDisplayed();
	      String rfq_title=driver.findElement(By.xpath("//div[@class='request-title request-header-block']")).getText();
	      ReporterLogger.log(rfq_title);  
		  String url_qc = driver.getCurrentUrl();
		  tender_link = url_qc;
	  }
	 // RFQ ReOpen 
     @Test(enabled = true,priority = 3) 
     public void qc_check() throws InterruptedException {
		testcaseId= "10234"; 
		driver.get(tender_link);  
		Thread.sleep(500);
		//driver.navigate().refresh();   
		//sReporterLogger.log("QC page is Opened");
		ReporterLogger.log(tender_link +" Opened");	   
		//driver.navigate().refresh();
		Thread.sleep(500);
		//Wait until RFQ Activated
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(55));
		By elementXPath = By.xpath("//span[contains(text(),'Assign')]");
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementXPath));
		assert driver.findElement(By.xpath("//span[contains(text(),'Assign')]")).isDisplayed();
		ReporterLogger.log("Tender Published Successfully");
     }
     // RFQ Functions verify
     @Test (enabled = true,dependsOnMethods = {"qc_check"},priority = 4)
     public void qc_action_menu_Verify() throws InterruptedException {
    	testcaseId= "10235"; 
    	 //verify QC element
        driver.navigate().refresh();
        Thread.sleep(500);   
        
        WebElement qc_part= driver.findElement(By.xpath("//div[@class='label-text']"));
        assert qc_part.isDisplayed();
        ReporterLogger.log(qc_part.getText());
        List<WebElement> action_list= driver.findElements(By.xpath("//div[contains(@class, 'actions-bar')]//button[contains(@class, 'button-element white')]"));
        // Assert that elements exist
            if (!action_list.isEmpty()) {
                ReporterLogger.log("Found " + action_list.size() + " buttons.");
                for (WebElement button : action_list) {
                    ReporterLogger.log("Buttons Are : " + button.getText());
                }
            } else {
                ReporterLogger.log("No buttons found!");
               }      
    
      }
     // RFQ Details Check
    
     @Test(enabled = true ,dependsOnMethods = {"qc_check"}, priority = 5)
     public void tab_req_detail() throws InterruptedException {
    	testcaseId= "10236";
//        //driver.navigate().refresh();
//        ReporterLogger.log("Tender opened to verify RFQ detail verify");
//        Thread.sleep(1000);
        driver.get(tender_link);
        //driver.get(tender_lnk);           
        ReporterLogger.log("Tender Opened for RFQ detail verify");
        
        driver.findElement(By.xpath("//span[normalize-space()='Request details']")).click();
        assert driver.findElement(By.xpath("//div[normalize-space()='RFQ type']")).isDisplayed();
        
        ReporterLogger.log("Request Details Open");
        //ReporterLogger.log("Request Details Open");
        
        List<WebElement> rfq_detail_list = driver.findElements(By.xpath("//*[contains(@class,'request-details-row')]"));
        
        for(WebElement each_detail : rfq_detail_list)
        {
           String rfq_line_detail = each_detail.getText();
           Thread.sleep(500);
           assert each_detail.isDisplayed();     
           ReporterLogger.log(rfq_line_detail);       
           
        }
     }
     //Quotes Verify
     @Test(enabled= true, priority = 6)
     public void quote_verify()  throws Throwable {
    	 testcaseId= "10237";
       //Wait until RFQ publish
    	 
//       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//       By elementXPath = By.xpath("//div[@class='quote-item-header']");
//       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementXPath)); 
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    
		 Thread.sleep(1000); 
		 //driver.findElement(By.xpath("//div[@class='quote-item-header']")).click();
		 if(!driver.findElement(By.xpath("//div[@class='quote-item-header']")).isDisplayed()) {
			 
			 driver.findElement(By.xpath("//span[normalize-space()='Quotes']")).click();
			 assert driver.findElement(By.xpath("//div[@class='quote-item-header']")).isDisplayed();
			 ReporterLogger.log("PNs Are  Visible"); 
			 if(!driver.findElement(By.xpath("//*[contains(@class,'quote-item-row')]")).isDisplayed())
			 {
				 driver.findElement(By.xpath("//div[@class='quote-item-header']")).click();
				 ReporterLogger.log("Quote row Clicked");
				 
			 }
			 else {
				 ReporterLogger.log("Quote Row visible");
			 }
			 
		 }
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 List<WebElement> quote_list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'quote-item-row')]")));//driver.findElements(By.xpath("//*[contains(@class,'quote-item-row')]"));
		 int count = quote_list.size();
		 ReporterLogger.log("Total Quote Received: "+ count);
		 if (quote_list.size() !=  0) {
			
			  for (WebElement radio : quote_list) {
			            //radio.click();
			            Thread.sleep(500); // Optional: just to see the clicks in action //*[contains(@class,'part-no-container with-supplier-name')]
			            ReporterLogger.log("Quote is Clicked");
			            js.executeScript("arguments[0].scrollIntoView(true);", radio); 
			            String quote_supplier = radio.findElement(By.xpath(".//*[contains(@class,'part-no-container with-supplier-name')]")).getText();
			            Thread.sleep(500);
			            WebElement hover_quotetype= radio.findElement(By.xpath(".//*[contains(@class,'icon-container source')]"));
			            Actions actions= new Actions(driver);
			            actions.moveToElement(hover_quotetype).perform();
				        String quote_type1= driver.findElement(By.xpath("/html/body/div[2]/div[12]")).getText();
			            ReporterLogger.log("Quote is from: " +quote_supplier + "| Quote Type :" + quote_type1 );

			  }
		 }
		 assert driver.findElement(By.xpath("//div[@class='auto-propsed']")).isDisplayed();
		 if (driver.findElement(By.xpath("//div[@class='auto-propsed']")).isDisplayed()) {
			 ReporterLogger.log("Skyselect  Prefered Quote is Available");
			 ReporterLogger.log( "Quote value : "+ driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div[2]/div[1]/div/div/div[2]/div[4]/div/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[19]/div/div[1]/div[2]/div/span")).getText());

		 }
		 else {ReporterLogger.log("No Skyselect Prefered Quote found.");}
		
		 //Unfocus Tooltip
		 driver.findElement(By.tagName("body")).click();
		 js.executeScript("window.scrollTo(0, 0);");

     }
    
     //Awarding the Quote 
 	@Test (enabled= true,priority = 7)
 	public void Awarding_rfq() throws InterruptedException {
 		 JavascriptExecutor js = (JavascriptExecutor) driver;
 		 Thread.sleep(500);  		  	
 		 ReporterLogger.log("Tender Opened for Awarding");
 		 driver.findElement(By.tagName("body")).click();
 		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 		 By elementXPath = By.xpath("//span[contains(text(),'Award selected quotes')]");
 		 WebElement award_button = wait.until(ExpectedConditions.visibilityOfElementLocated(elementXPath));
 		
 		 js.executeScript("arguments[0].scrollIntoView(true);", award_button);
 		 ReporterLogger.log("Scrolled to Award Button");
 		 if(driver.findElement(By.xpath("//span[contains(text(),'Award selected quotes')]")).isDisplayed()) {
 			  driver.findElement(By.xpath("//span[contains(text(),'Award selected quotes')]")).click();
 			  ReporterLogger.log("Awarding Button Click");
 			  
 			  //AwardingPage Navigation
 		//	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 			  WebElement Awarding_title= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='banner-description']")));
 			  
 			  Thread.sleep(500);
 			  driver.findElement(By.xpath("//div[@class='collapsible-panel-header']")).click();
 			  Thread.sleep(500);
 			  //Part to Be Award
 			  String part_award = driver.findElement(By.xpath("//tr[@class='el-table__row']")).getText();
 			  ReporterLogger.log(part_award);
 			  
 			  driver.findElement(By.xpath("//button[@class='button-element blue-dark uppercase']")).click();
 			  
 			  //awarding Complition Model
 		      driver.findElement(By.xpath("//div[@class='hText']")).getText();
 		      assertEquals(driver.findElement(By.xpath("//div[@class='hText']")).getText(),"Complete awarding and download file");
 		      
 		      assert driver.findElement(By.xpath("//div[@class='el-switch is-checked']//span[@class='el-switch__core']")).isEnabled();
 		      driver.findElement(By.xpath("//div[@class='main-button medium modal-confirm']//button[@type='button']")).click();
 		  
 			  
 			  
 		  }		
 		  else {
 			  ReporterLogger.log("Award Selected Quote not enabled");			  
 		  }
 		  
 		 
 		
 	}
 	
 	//Order draft
 	@Test(enabled= true,priority = 8,dependsOnMethods = {"Awarding_rfq"}) //
 	public void order_draft()  throws Throwable {
   		
		 //JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 WebElement od_draft_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header-title']"))); 
		 assert od_draft_title.isDisplayed();		 
		 order_draft_link = driver.getCurrentUrl();
		 Thread.sleep(1000);	  
		 driver.get("https://demo.skyselect.com/db/orders/dashboard");
		 WebElement ord_lebel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Awaiting Buyer Action']")));
		 assert driver.findElement(By.xpath("//div[@class='btn-inner-wrapper']")).isDisplayed();
		 ReporterLogger.log("Order Dashboard opened");
		 Thread.sleep(1000);
		 driver.get(order_draft_link);
		 Thread.sleep(500);
		 assert driver.findElement(By.xpath("//div[@class='header-title']")).isDisplayed();	
		 ReporterLogger.log("Order Draft Opened");
		 	
 	 }
 	@Test (enabled= true,priority = 9,dependsOnMethods = {"order_draft"})
	  public void order_draft_header() throws InterruptedException{
		  
		JavascriptExecutor js = (JavascriptExecutor) driver;
		assert driver.findElement(By.xpath("//button[@class='button-element blue-dark']")).isEnabled();
		
		
		//Order Number
		driver.findElement(By.xpath("//div[@class='text-input-container']//input[@placeholder='Enter here']")).sendKeys("15071");
		
		//Order type
		
		String Order_type = driver.findElement(By.xpath("//div[@class='draft-data-block po-type']//div[@class='el-select__selection']")).getText();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Purchase order')]")).getText();
		ReporterLogger.log("Order type selected");
		assertFalse(Order_type == null);
		ReporterLogger.log("Order Type Added :"+ Order_type);
		

		//Order Priority
		String Order_Priority =driver.findElement(By.xpath("//div[@class='draft-data-block priority']//div[@class='el-select__wrapper is-filterable el-tooltip__trigger el-tooltip__trigger']")).getText();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Routine')]")).click();
		ReporterLogger.log("Order Priority selected");
		assertFalse(Order_type == null);
		ReporterLogger.log("Order Priority Added" + Order_Priority);
		
		//Supplier
		String Order_supplier = driver.findElement(By.xpath("//div[@class='draft-data-block suppliers']//div[@class='draft-data-block-value']")).getText();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@class='draft-data-block suppliers']//div[@class='draft-data-block-value']")).sendKeys("Best Part");
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/div/div[1]/ul/li[5]/div")).click();
		assertFalse(Order_type == null);
		Thread.sleep(1000);
		ReporterLogger.log("Supplier Added"+ Order_supplier);

		//Supplier Contact Selection
		String  Order_contact = driver.findElement(By.xpath("//div[@class='select-container multiple']//div[@class='el-select__wrapper is-filterable el-tooltip__trigger el-tooltip__trigger']")).getText();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("(//div[@class='details-section-contact-subtitle'])[1]")).click();
		//Thread.sleep(1000);
		//driver.findElement(By.tagName("body")).click();
		assertFalse(Order_contact == null);
		ReporterLogger.log("Supplier Contact Added" + Order_contact);
		js.executeScript("window.scrollTo(0,50)");
		
		
		//Ship to
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[3]/div[2]/form[1]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[10]/div/div/div[1]/ul/li[2]/div")).click();
		
		ReporterLogger.log("Ship to Add Added");
	
		//Ship via
		//Final Destination
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[3]/div[2]/form[1]/div[1]/div[2]/div[3]/div[6]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[13]/div/div/div[1]/ul/li[2]/div")).click();
		ReporterLogger.log("Final Dest Added");

		//Scroll to tail No
		WebElement Lbl_Tail_no= driver.findElement(By.xpath("//div[@class='draft-data-block tail-number']"));
		// Scroll down
		js.executeScript("arguments[0].scrollIntoView(true);", Lbl_Tail_no);
		Thread.sleep(1000);

		//Tail number
		//driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[2]/div[2]/div/div/div/div[2]/input")).sendKeys("TL123");
		ReporterLogger.log("Tail No Added");
		Thread.sleep(1000);
		String Order_tailNo= driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[2]/div[2]/div/div/div/div[2]/input")).getText();
		assertFalse(Order_tailNo == null);
		ReporterLogger.log("Tail No Added");
		
		//Remarks
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[3]/div[2]/div/div[2]/input")).sendKeys("Test Remarks");
		ReporterLogger.log("Remarks Added");
		Thread.sleep(1000);
		String Order_Remark = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[3]/div[2]/div/div[2]/input")).getText();
		assertFalse(Order_Remark == null);
		ReporterLogger.log("Remark Added");
		
		//	Internal Notes
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[4]/div[2]/div/div[2]/input")).sendKeys("Internal Notes");
		ReporterLogger.log("Notes Added");
		Thread.sleep(1000);
		String Order_Notes= driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[4]/div[2]/div/div[2]/input")).getText();
		assertFalse(Order_Notes == null);
		ReporterLogger.log("Notes added");
		Thread.sleep(500);
		
		//Ship by date
		String inptut_date = ul.getCurrentDate();
		WebElement dateInput_shp = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[6]/div[2]/div/div/div/div/div/input")); // replace with actual ID
 
		if (dateInput_shp.getAttribute("value") == null || dateInput_shp.getAttribute("value").isEmpty()) {
			 	Thread.sleep(500);
			 	dateInput_shp.sendKeys(inptut_date); // format: yyyy-MM-dd
			 	driver.findElement(By.tagName("body")).click();
				String Order_shpDate= driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[6]/div[2]/div/div/div/div/div/input")).getText();
				//assertFalse(Order_shpDate == null);
				assertNotNull(Order_shpDate);
				Thread.sleep(500);
				ReporterLogger.log("Ship By Date Added");
				if(driver.findElement(By.xpath("//div[@class='hText']")).isDisplayed())
				{
					ReporterLogger.log("Update Ship By Date Model Opened");
					Thread.sleep(500);
					driver.findElement(By.xpath("//div[@class='main-button medium modal-confirm']")).click();
				}
				
				ReporterLogger.log("Ship By Date added");
				driver.findElement(By.tagName("body")).click();
				Thread.sleep(500);
			 }	
		 else {
			String shp_date =  dateInput_shp.getText();
			Thread.sleep(500);
			ReporterLogger.log(shp_date + "Already there");
		 }
		
		//Need by date
		 Thread.sleep(1000);											
		 WebElement dateInput_need = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[7]/div[2]/div/div/div/div/div/input")); 	 
		 if (dateInput_need.getAttribute("value") == null || dateInput_need.getAttribute("value").isEmpty()) {
				 	Thread.sleep(500);
				 	dateInput_need.sendKeys(inptut_date); // format: yyyy-MM-dd
				 	driver.findElement(By.tagName("body")).click();
					String Order_needDate= driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[7]/div[2]/div/div/div/div/div/input")).getText();
					assertNotNull(Order_needDate);
					Thread.sleep(500);
					ReporterLogger.log("Ship By Date Added");
					if(driver.findElement(By.xpath("//div[@class='hText']")).isDisplayed())
					{
						ReporterLogger.log("Update Need By Date Model Opened");
						Thread.sleep(500);
						driver.findElement(By.xpath("//div[@class='main-button medium modal-confirm']")).click();
					}
					
					ReporterLogger.log("Need By Date added");
					driver.findElement(By.tagName("body")).click();
					Thread.sleep(500);
				 }	
			 else {
				String nd_date =  dateInput_need.getText();
				Thread.sleep(500);
				ReporterLogger.log(nd_date + "Already there");
			 }
		driver.findElement(By.tagName("body")).click();
	  }
 	
 	//Verify Order Part row
 	 @Test (enabled= true,dependsOnMethods = {"order_draft"},priority = 10)//
 	  public void order_part() throws InterruptedException {
 		  JavascriptExecutor js = (JavascriptExecutor) driver;
 	      WebElement od_part= driver.findElement(By.xpath("//div[@class='order-parts-row-container']"));
 	      assert od_part.isDisplayed();
 	      js.executeScript("arguments[0].scrollIntoView(true);", od_part);
 	      ReporterLogger.log(od_part.getText());
 	      List<WebElement> part_row= driver.findElements(By.xpath("*//*[contains(@class, 'order-parts-row-container')]"));
 	      
 	      Set<String> seenValues = new HashSet<>();

 	      List<WebElement> partRows = driver.findElements(By.cssSelector(".order-parts-row-container"));

 	      if (!partRows.isEmpty()) {
 	          ReporterLogger.log("Found " + partRows.size() + " Part Row(s).");

 	          for (WebElement row : partRows) {
 	              assert row.isDisplayed();
 	              ReporterLogger.log("Part Row:");

 	              List<WebElement> children = row.findElements(By.xpath(".//*"));

 	              for (WebElement child : children) {
 	                  String tag = child.getTagName();
 	                  String value = "";

 	                  // Handle inputs, textareas, selects
 	                  if (tag.equalsIgnoreCase("input") || tag.equalsIgnoreCase("textarea") || tag.equalsIgnoreCase("select")) {
 	                      value = child.getAttribute("value");
 	                  } else {
 	                      value = child.getText();
 	                  }

 	                  // Trim and check for non-empty unique values
 	                  value = value != null ? value.trim() : "";

 	                  if (!value.isEmpty() && !seenValues.contains(value)) {
 	                      seenValues.add(value);
 	                      ReporterLogger.log("  → " + tag + ": " + value);
 	                      
 	                  }
 	              }
 	          }
 	      } else {
 	         ReporterLogger.log("No Parts Found!");
 	    }
 	 }
 	 
 	 //Publish the Order
 	 @Test(enabled= true,dependsOnMethods = {"order_draft"},priority = 11)
 	 public void order_Publish() throws InterruptedException {
		 ul.body_Click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		 WebElement ord_btnPublish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button-element blue-dark']")));
		 assertEquals(ord_btnPublish.isEnabled(), "Order Publish not enabled");
		 ord_btnPublish.click();
		 ReporterLogger.log("Order Published Successfully!");
 	 }
	     
}
