package skyselect_Maven.skyselect_Maven;

import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Response;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.utilities;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import java.awt.Desktop.Action;
import java.awt.Scrollbar;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

public class Buyer_Order_create extends BaseTest_Buyer {
	//WebDriver driver; 
	public WebElementsPage webElementsPage; 
	utilities ul= new utilities();
	String order_draft_link= "https://demo.skyselect.com/db/orders/new-order/1154";
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Test(enabled= true) //, priority = 8,dependsOnMethods = {"Awarding_rfq"}
 	public void order_draft_frm_Awrd()  throws Throwable {
   		
		 //JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://demo.skyselect.com/db/orders/new-order/1154");
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 WebElement od_draft_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header-title']"))); 
		 assert od_draft_title.isDisplayed();		 
		 order_draft_link = driver.getCurrentUrl();
		 Thread.sleep(1000);	  
		 driver.get("https://demo.skyselect.com/db/orders/dashboard");
		 WebElement ord_lebel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Awaiting Buyer Action']")));
		 assert driver.findElement(By.xpath("//div[@class='btn-inner-wrapper']")).isDisplayed();
		 Reporter.log("Order Dashboard opened",true);
		 Thread.sleep(1000);
		 driver.get(order_draft_link);
		 Thread.sleep(500);
		 assert driver.findElement(By.xpath("//div[@class='header-title']")).isDisplayed();	
		 Reporter.log("Order Draft Opened",true);
		 	
 	 }
	
	@Test (enabled= false,dependsOnMethods = {"order_draft"})//priority = 9
	public void order_draft_header_frm_Awrd() throws InterruptedException{
		  
		JavascriptExecutor js = (JavascriptExecutor) driver;
		assert driver.findElement(By.xpath("//button[@class='button-element blue-dark']")).isEnabled();
		
		
		//Order Number
		driver.findElement(By.xpath("//div[@class='text-input-container']//input[@placeholder='Enter here']")).sendKeys("15071");
		
		//Order type
		
		String Order_type = driver.findElement(By.xpath("//div[@class='draft-data-block po-type']//div[@class='el-select__selection']")).getText();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Purchase order')]")).getText();
		System.out.println("Order type selected");
		assertFalse(Order_type == null);
		Reporter.log("Order Type Added :"+ Order_type,true);
		

		//Order Priority
		String Order_Priority =driver.findElement(By.xpath("//div[@class='draft-data-block priority']//div[@class='el-select__wrapper is-filterable el-tooltip__trigger el-tooltip__trigger']")).getText();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Routine')]")).click();
		System.out.println("Order Priority selected");
		assertFalse(Order_type == null);
		Reporter.log("Order Priority Added" + Order_Priority,true);
		
		//Supplier
		String Order_supplier = driver.findElement(By.xpath("//div[@class='draft-data-block suppliers']//div[@class='draft-data-block-value']")).getText();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@class='draft-data-block suppliers']//div[@class='draft-data-block-value']")).sendKeys("Best Part");
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/div/div[1]/ul/li[5]/div")).click();
		assertFalse(Order_type == null);
		Thread.sleep(1000);
		Reporter.log("Supplier Added"+ Order_supplier,true);

		//Supplier Contact Selection
		String  Order_contact = driver.findElement(By.xpath("//div[@class='select-container multiple']//div[@class='el-select__wrapper is-filterable el-tooltip__trigger el-tooltip__trigger']")).getText();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("(//div[@class='details-section-contact-subtitle'])[1]")).click();
		//Thread.sleep(1000);
		//driver.findElement(By.tagName("body")).click();
		assertFalse(Order_contact == null);
		Reporter.log("Supplier Contact Added" + Order_contact,true);
		js.executeScript("window.scrollTo(0,50)");
		
		
		//Ship to
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[3]/div[2]/form[1]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[10]/div/div/div[1]/ul/li[2]/div")).click();
		
		Reporter.log("Ship to Add Added",true);
		
		
		
		
		//Ship via
		//Final Destination
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[3]/div[2]/form[1]/div[1]/div[2]/div[3]/div[6]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[13]/div/div/div[1]/ul/li[2]/div")).click();
		Reporter.log("Final Dest Added",true);

		//Scroll to tail No
		WebElement Lbl_Tail_no= driver.findElement(By.xpath("//div[@class='draft-data-block tail-number']"));
		// Scroll down
		js.executeScript("arguments[0].scrollIntoView(true);", Lbl_Tail_no);
		Thread.sleep(1000);

		//Tail number
		//driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[2]/div[2]/div/div/div/div[2]/input")).sendKeys("TL123");
		System.out.println("Tail No Added");
		Thread.sleep(1000);
		String Order_tailNo= driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[2]/div[2]/div/div/div/div[2]/input")).getText();
		assertFalse(Order_tailNo == null);
		Reporter.log("Tail No Added",true);
		
		
		
		//Remarks
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[3]/div[2]/div/div[2]/input")).sendKeys("Test Remarks");
		System.out.println("Remarks Added");
		Thread.sleep(1000);
		String Order_Remark = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[3]/div[2]/div/div[2]/input")).getText();
		assertFalse(Order_Remark == null);
		Reporter.log("Remark Added",true);
		

		//	Internal Notes
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[4]/div[2]/div/div[2]/input")).sendKeys("Internal Notes");
		System.out.println("Notes Added");
		Thread.sleep(1000);
		String Order_Notes= driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[4]/div[2]/div/div[2]/input")).getText();
		assertFalse(Order_Notes == null);
		Reporter.log("Notes added",true);
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
				Reporter.log("Ship By Date Added",true);
				if(driver.findElement(By.xpath("//div[@class='hText']")).isDisplayed())
				{
					Reporter.log("Update Ship By Date Model Opened",true);
					Thread.sleep(500);
					driver.findElement(By.xpath("//div[@class='main-button medium modal-confirm']")).click();
				}
				
				System.out.println("Ship By Date added");
				driver.findElement(By.tagName("body")).click();
				Thread.sleep(500);
			 }	
		 else {
			String shp_date =  dateInput_shp.getText();
			Thread.sleep(500);
			Reporter.log(shp_date + "Already there",true);
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
					Reporter.log("Ship By Date Added",true);
					if(driver.findElement(By.xpath("//div[@class='hText']")).isDisplayed())
					{
						Reporter.log("Update Need By Date Model Opened",true);
						Thread.sleep(500);
						driver.findElement(By.xpath("//div[@class='main-button medium modal-confirm']")).click();
					}
					
					System.out.println("Need By Date added");
					driver.findElement(By.tagName("body")).click();
					Thread.sleep(500);
				 }	
			 else {
				String nd_date =  dateInput_need.getText();
				Thread.sleep(500);
				Reporter.log(nd_date + "Already there",true);
			 }
		driver.findElement(By.tagName("body")).click();
		  
		  
	  }
  @Test (enabled= true,dependsOnMethods = {"order_draft"})//priority = 2
  	public void order_part_frm_Awrd() throws InterruptedException {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement od_part= driver.findElement(By.xpath("//div[@class='order-parts-row-container']"));
      assert od_part.isDisplayed();
      js.executeScript("arguments[0].scrollIntoView(true);", od_part);
      System.out.println(od_part.getText());
      List<WebElement> part_row= driver.findElements(By.xpath("*//*[contains(@class, 'order-parts-row-container')]"));
      
      Set<String> seenValues = new HashSet<>();

      List<WebElement> partRows = driver.findElements(By.cssSelector(".order-parts-row-container"));

      if (!partRows.isEmpty()) {
          System.out.println("Found " + partRows.size() + " Part Row(s).");

          for (WebElement row : partRows) {
              assert row.isDisplayed();
              Reporter.log("Part Row:");

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
                      Reporter.log("  → " + tag + ": " + value);
                      System.out.println("  → " + tag + ": " + value);
                  }
              }
          }
      } else {
          System.out.println("No Parts Found!");
      }
      
      // Assert that elements exist
          if (!part_row.isEmpty()) {
              System.out.println("Found " + part_row.size() + " Part Row.");
              for (WebElement element : part_row) {
                  assert element.isDisplayed();
                  Reporter.log("Part Data: " + element.getText());
              }
          } else {
              System.out.println("No Parts Found!");
             }      
  
    }
	@Test(enabled= false)
	public void order_draft()  throws Throwable {
	  		webElementsPage = new WebElementsPage(driver);
	  		  //JavascriptExecutor js = (JavascriptExecutor) driver;
			  System.out.println("Login Successfull");
			  Thread.sleep(1000);
			  	  
			  driver.get("https://demo.skyselect.com/db/orders/dashboard");
			  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
			  WebElement ord_lebel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Awaiting Buyer Action']")));
			  assert driver.findElement(By.xpath("//div[@class='btn-inner-wrapper']")).isDisplayed();
			  Reporter.log("Order Dashboard opened",true);
			  System.out.println("Order Dashboard opened");
			  Thread.sleep(1000);
			//  driver.get("https://demo.skyselect.com/db/orders/new-order/1126"); 
			  
			  driver.findElement(By.xpath("//div[@class='main-button small el-tooltip__trigger']")).click();
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("(//div[@class='action'])[2]")).click();
			  
			  WebElement order_draft_lbl= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Enter order details']")));
			  assert order_draft_lbl.isDisplayed();
			 
			  Reporter.log(order_draft_lbl.getText(),true);
			  System.out.println(order_draft_lbl.getText());	   
	}
	@Test (enabled= false,dependsOnMethods = {"order_draft_old"})//,priority = 1
  	public void order_draft_header() throws InterruptedException{
	  
	JavascriptExecutor js = (JavascriptExecutor) driver;
	assertFalse(driver.findElement(By.xpath("//button[@class='button-element blue-dark']")).isEnabled(),"Submit Button should disabled");
	
	
	//Order Number
	driver.findElement(By.xpath("//div[@class='text-input-container']//input[@placeholder='Enter here']")).sendKeys("27062");
	
	//Order type
	
	driver.findElement(By.xpath("//div[@class='draft-data-block po-type']//div[@class='el-select__selection']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[contains(text(),'Purchase order')]")).click();
	System.out.println("Order type selected");
	Reporter.log("Order Type Added",true);
	

	//Order Priority
	driver.findElement(By.xpath("//div[@class='draft-data-block priority']//div[@class='el-select__wrapper is-filterable el-tooltip__trigger el-tooltip__trigger']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[contains(text(),'Routine')]")).click();
	System.out.println("Order Priority selected");
	Reporter.log("Order Priority Added",true);
	
	//Supplier
	driver.findElement(By.xpath("//div[@class='draft-data-block suppliers']//div[@class='draft-data-block-value']")).click();
	Thread.sleep(1000);
	//driver.findElement(By.xpath("//div[@class='draft-data-block suppliers']//div[@class='draft-data-block-value']")).sendKeys("Best Part");
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/div/div[1]/ul/li[5]/div")).click();
	Thread.sleep(1000);
	Reporter.log("Supplier Added",true);

	//Supplier Contact Selection
	driver.findElement(By.xpath("//div[@class='select-container multiple']//div[@class='el-select__wrapper is-filterable el-tooltip__trigger el-tooltip__trigger']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[@class='details-section-contact-subtitle'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.tagName("body")).click();
	Reporter.log("Supplier Contact Added",true);
	js.executeScript("window.scrollTo(0,50)");
	
	
	//Ship to
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[3]/div[2]/form[1]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[2]/div[8]/div/div/div[1]/ul/li[2]/div/div[1]")).click();
	Reporter.log("Ship to Add Added",true);
	
	
	
	
	//Ship via
	//Final Destination
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[3]/div[2]/form[1]/div[1]/div[2]/div[3]/div[6]/div[2]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[2]/div[11]/div/div/div[1]/ul/li[2]/div/div[1]")).click();
	Reporter.log("Final Dest Added",true);

	//Scroll to tail No
	WebElement Lbl_Tail_no= driver.findElement(By.xpath("//div[@class='draft-data-block tail-number']"));
	// Scroll down
	js.executeScript("arguments[0].scrollIntoView(true);", Lbl_Tail_no);
	Thread.sleep(1000);

	//Tail number
	driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[2]/div[2]/div/div/div/div[2]/input")).sendKeys("TL123");
	System.out.println("Tail No Added");
	Thread.sleep(1000);
	Reporter.log("Tail No Added",true);
	
	//Remarks
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[3]/div[2]/div/div[2]/input")).sendKeys("Test Remarks");
	System.out.println("Remarks Added");
	Thread.sleep(1000);
	Reporter.log("Remark Added",true);
	

	//	Internal Notes
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/form/div[1]/div[2]/div[5]/div[4]/div[2]/div/div[2]/input")).sendKeys("Internal Notes");
	System.out.println("Notes Added");
	Thread.sleep(1000);
	Reporter.log("Notes added",true);
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
			Reporter.log("Ship By Date Added",true);
			if(driver.findElement(By.xpath("//div[@class='hText']")).isDisplayed())
			{
				Reporter.log("Update Ship By Date Model Opened",true);
				Thread.sleep(500);
				driver.findElement(By.xpath("//div[@class='main-button medium modal-confirm']")).click();
			}
			
			System.out.println("Ship By Date added");
			driver.findElement(By.tagName("body")).click();
			Thread.sleep(500);
		 }	
	 else {
		String shp_date =  dateInput_shp.getText();
		Thread.sleep(500);
		Reporter.log(shp_date + "Already there",true);
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
				Reporter.log("Ship By Date Added",true);
				if(driver.findElement(By.xpath("//div[@class='hText']")).isDisplayed())
				{
					Reporter.log("Update Need By Date Model Opened",true);
					Thread.sleep(500);
					driver.findElement(By.xpath("//div[@class='main-button medium modal-confirm']")).click();
				}
				
				System.out.println("Need By Date added");
				driver.findElement(By.tagName("body")).click();
				Thread.sleep(500);
			 }	
		 else {
			String nd_date =  dateInput_need.getText();
			Thread.sleep(500);
			Reporter.log(nd_date + "Already there",true);
		 }
	driver.findElement(By.tagName("body")).click();
	  
	  
  }
  @Test (enabled= false,dependsOnMethods = {"order_draft"})//priority = 2
  	public void order_part() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Add_part= driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[2]/form/div[2]/div[1]/span[1]"));
		// Scroll down
		js.executeScript("arguments[0].scrollIntoView(true);", Add_part);
		
		//Click to Add part Button
	
		driver.findElement(By.xpath("//body/div[@class='main-wrapper agate']/div[@class='main']/div[@id='app']/div[@id='app']/div[@class='draft-order-container']/div[@class='draft-order-content']/form/div[2]/div[1]/span[2]/span[1]")).click();
//		WebElement partNumber = driver.findElement(By.className(".draft-data-block-title"));
//		assert partNumber.isDisplayed();
		
		//Enter Part No
		driver.findElement(By.xpath("//div[@class='draft-data-block part-number']//input[@placeholder='Enter here']")).sendKeys("PI1102");
		Reporter.log("Part No Added",true);
		Thread.sleep(1000);
		
		
		//Enter Qty
		driver.findElement(By.xpath("//div[@class='draft-data-block qty']//input[@type='number']")).sendKeys("5");
		Reporter.log("Qty  Added",true);
		Thread.sleep(1000);
		
		//Enter Price
		driver.findElement(By.xpath("//div[@class='draft-data-block unit-price']//input[@type='number']")).sendKeys("1150");
		Reporter.log("Price  Added",true);
		Thread.sleep(1000);
		
		
		//Enter Part Condition
		 driver.findElement(By.xpath("//div[@class='draft-data-block condition']//div[@class='draft-data-block-value']")).click();
		 Thread.sleep(1500);
		 driver.findElement(By.xpath("/html/body/div[2]/div[21]/div/div/div[1]/ul/li[2]")).click();

		  
}
	 //Publish the Order
 @Test(enabled= true,dependsOnMethods = {"order_draft"})
  	public void order_Publish() throws InterruptedException {
		 ul.body_Click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		 WebElement ord_btnPublish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button-element blue-dark']")));
		 assertEquals(ord_btnPublish.isEnabled(), "Order Publish not enabled");
		 ord_btnPublish.click();
}

  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
	public void setup() {
//WebDriverManager.chromedriver().setup();
//	  
//	  driver= new ChromeDriver();
//	  driver.manage().window().maximize();
//	  
//	  driver.manage().deleteAllCookies();
//	  
//	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//	  driver.get("https://demo.skyselect.com");
//	  webElementsPage = new WebElementsPage(driver);
//	  webElementsPage.Login("sales@airindia.com", "Test@123");
//	  
}


}
