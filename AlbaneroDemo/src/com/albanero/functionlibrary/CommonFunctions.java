
package com.albanero.functionlibrary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;






public class CommonFunctions {

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;

	public static DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
	public static Date date = new Date();
	
	
	public CommonFunctions(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}


	public static void openBrowser(String appUrl)  {
	
		   //WebDriverManager automatically download latest drivers if there is any mismatch
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-web-security");
			options.addArguments("--disable-site-isolation-trials");
					
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.get(appUrl);

		}
	
	public static String getSaltString() {


		String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;


	}
	
	public static boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void fluentlyWaitForElement(WebElement element) {
		new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(35))
		.pollingEvery(Duration.ofSeconds(7))
		.ignoring(Exception.class);

		

	}


	}

	









