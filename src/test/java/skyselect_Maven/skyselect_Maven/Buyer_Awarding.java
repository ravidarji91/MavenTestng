package skyselect_Maven.skyselect_Maven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Buyer_Awarding  {
	WebDriver driver= null; 
	public WebElementsPage webElementsPage; 
	
  @Test
  public void Awarding_dashboard() throws Throwable {
			  System.out.println("Login Successfull");
			  Thread.sleep(1000);
			  driver.get("https://demo.skyselect.com/db/awarding");
			  Thread.sleep(1000);
			  WebElement award_all_parts = driver.findElement(By.xpath("//span[normalize-space()='Award All Parts']"));
		  	  try {	 
				  
				  if(award_all_parts.isDisplayed())
				  {
					  assertEquals(award_all_parts.getText(),"AWARD ALL PARTS");
					  Thread.sleep(1000);
					  
				  }
			 
		  	  }
		  	  	catch (NoSuchElementException e) {
		  		System.out.println("Awarding session is Going ON.");
				  Reporter.log("Awarding session is Going ON.");
		  	} 	  
		  
		  Thread.sleep(1000);		  
		  WebElement btn_award_History = driver.findElement(By.xpath("//span[normalize-space()='Awarding History']"));
		  Thread.sleep(1000);
		  btn_award_History.click();
		  String lbl_history=driver.findElement(By.xpath("//div[@class='hText']")).getText();
		  assertEquals(lbl_history, "Awarding History");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='hClose']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//span[normalize-space()='Select items to award']")).click();
		  Thread.sleep(1000);
		  //assert !award_all_parts.isEnabled();
		  List<WebElement> check_box=driver.findElements(By.cssSelector(".checkbox-container[class$='checkbox-container']"));
		// Select the second checkbox
	      if (!check_box.get(2).isSelected()) {
	    	  check_box.get(2).click();
	      }
	      // Add assertions if needed to verify the selection
	      //assert check_box.get(1).isSelected() : "Part is selected for Awarding.";
	      assert award_all_parts.isEnabled();
	      Thread.sleep(1000);
	      award_all_parts.click(); 
	      String awarding_session = driver.findElement(By.xpath("//span[contains(text(),'Showing the latest state of consolidated awards. Please review before completing.')]")).getText();
	      
	      assertEquals(awarding_session,"Showing the latest state of consolidated awards. Please review before completing.");
	      
	      WebElement btn_award_complete =driver.findElement(By.xpath("//span[normalize-space()='Complete']"));
	      assert btn_award_complete.isDisplayed();
	      btn_award_complete.click();
	      
	      //awarding Complition Model
	      driver.findElement(By.xpath("//div[@class='hText']")).getText();
	      assertEquals(driver.findElement(By.xpath("//div[@class='hText']")).getText(),"Complete awarding and download file");
	      
	      assert driver.findElement(By.xpath("//div[@class='el-switch is-checked']//span[@class='el-switch__core']")).isEnabled();
	      driver.findElement(By.xpath("//div[@class='main-button medium modal-confirm']//button[@type='button']")).click();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
	public void setup() {
WebDriverManager.chromedriver().setup();
	  
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.manage().deleteAllCookies();
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("https://demo.skyselect.com");
	  webElementsPage = new WebElementsPage(driver);
	  webElementsPage.Login("sales@airindia.com", "Test@123");
	  
}

  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  	
  }

  @AfterTest
  public void afterTest() {
  }

}
