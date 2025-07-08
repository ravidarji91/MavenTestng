package skyselect_Maven.skyselect_Maven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class utilities {
	WebDriver driver;
	
	public void scrollUp() {
        // Scroll down first
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Scroll up
        js.executeScript("window.scrollTo(0, 0)");
        
    }
	public void scrollDownMax() {
	        // Scroll down
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    }
	public void scrollDown() {
        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300)");
    }
	
	public void takescreenshot(String fileName)
	{
		// Convert WebDriver object to TakeScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Capture the screenshot as a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        // Save the file at the desired location
        File destFile = new File("screenshots/" + fileName + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

	}
	

}
