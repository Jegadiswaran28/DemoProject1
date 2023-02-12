package com.albanero.tests;


import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.albanero.functionlibrary.CommonFunctions;
import com.albanero.pages.SignUpPage;




public class SignUpTest {
	
	

	public WebDriver driver;


	@Test
	public void newSignUp() throws InterruptedException, IOException, SQLException {

		//Calling application URL
		String url = "https://demo.albanero.io/register";	 
		CommonFunctions.openBrowser(url);
		
		SignUpPage signf = PageFactory.initElements(CommonFunctions.driver, SignUpPage.class);
		signf.signupTest();


	}

}
