package com.albanero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.albanero.functionlibrary.CommonFunctions;



public class SignUpPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='eg. John']")
	public static WebElement firstNameField;
	
	@FindBy(xpath="//input[@placeholder='eg. Doe']")
	public static WebElement lastNameField;
	
	@FindBy(xpath="//input[@placeholder='eg. Johndoe@gmail.com']")
	public static WebElement emailField;
	
	@FindBy(xpath="//input[@placeholder='eg. JohnDoe88']")
	public static WebElement userNameField;
	
	@FindBy(xpath="//*[@id='mount']/div/div/div/div/div/div/form/div[3]/div/div/div[1]/div/div[2]/span")
	public static WebElement userNameFieldInfoIcon;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	public static WebElement passwordField;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	public static WebElement confirmPasswordField;
	
	@FindBy(xpath="//span[@class='MuiButtonBase-root MuiIconButton-root jss1 MuiCheckbox-root MuiCheckbox-colorSecondary checkbox_color MuiIconButton-colorSecondary']")
	public static WebElement termnsConditionsCheckbox;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	public static WebElement nextButton;
	
	@FindBy(xpath="//a[@data-test-id='sign-in']")
	public static WebElement signInLink;
	
	@FindBy(xpath="//h1[contains(text(),'Sign In')]")
	public WebElement signInPageHeader;
	
	
	static String email = CommonFunctions.getSaltString()+"@gmail.com";


	public SignUpPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void signupTest()
	{
		
			
		 //Enter first name in First Name field
		 firstNameField.sendKeys("testFirstName"); 
		 //Enter last name in Last Name field
		 lastNameField.sendKeys("testLastName");
		 //Enter valid email in EmailID field using random email id generator
		 emailField.sendKeys(email);
		 //Enter UserName in UserName field
		 userNameField.sendKeys("JohnDoe88");
		 
		 //Validate UserName Field Info icon displayed to the user
		if(CommonFunctions.isDisplayed(userNameFieldInfoIcon)==true)
		{
			//Creating object of an Actions class
			Actions action = new Actions(driver);
			//Performing the mouse hover action on the target element
			action.moveToElement(userNameFieldInfoIcon).perform();
		}
		 //Enter Valid password in Password field
		passwordField.sendKeys("Albanero1$");
		confirmPasswordField.sendKeys("Albanero1$");
		//Click on Terms and Conditions check box
		termnsConditionsCheckbox.click();
		//Click on Next button
		nextButton.click();
		
		//Verify on clicking Sigin Page displayed to the user
		signInLink.click();
		
		
		CommonFunctions.fluentlyWaitForElement(signInPageHeader);
		
		if(signInPageHeader.isDisplayed()==true)
		{
			System.out.println("Pass: Application navigated to Sign in page");
		}
		else{
			System.out.println("Fail: Application failed to navigate to Sign in page");
		}
		
	
	
	}
		
	}
	


