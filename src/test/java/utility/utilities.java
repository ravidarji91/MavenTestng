package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class utilities {
	WebDriver driver;
	private static BufferedWriter writer;

	
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
	//Get Current Date
	public static String getCurrentDate() {
		 LocalDate today = LocalDate.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     return today.format(formatter); 
	}
	//To Click on Body
	public void body_Click() throws InterruptedException {
		driver.findElement(By.tagName("body")).click();
		Thread.sleep(500);
	}
	
	//Logging
	public static void startLogging() {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
            File logFile = new File("logs/ExecutionLog_" + timeStamp + ".txt");
            logFile.getParentFile().mkdirs(); // Create directories if they don't exist
            writer = new BufferedWriter(new FileWriter(logFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        String timestamped = "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) + "] " + message;

        // Log to TestNG's Reporter
        Reporter.log(timestamped, true);

        // Also log to external file
        try {
            writer.write(timestamped);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopLogging() {
        try {
            if (writer != null) writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	

}
