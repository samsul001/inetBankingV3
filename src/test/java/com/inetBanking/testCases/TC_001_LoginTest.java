package com.inetBanking.testCases;


import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_001_LoginTest extends BaseClass{

	
	
	@Test
	public void loginTest() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
			
		lp.setUserName(username);
		lp.setPwd(password);
		lp.clickLoginBtn();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {		
			Assert.assertTrue(true);
		}
		
		else {
			//captureScreen(driver, "loginTest");
			Assert.assertTrue(false);	
		}
		
	}
	
	@Test
	public void loginTest1() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		//logger.info("URL entered");		
		lp.setUserName(username);
		lp.setPwd(password);
		lp.clickLoginBtn();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {		
			Assert.assertTrue(true);
		}
		
		else {
			//captureScreen(driver, "loginTest");
			Assert.assertTrue(false);	
		}
		
	}
	
	
}
