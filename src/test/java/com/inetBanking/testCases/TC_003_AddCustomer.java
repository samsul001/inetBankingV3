package com.inetBanking.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_003_AddCustomer extends BaseClass{
	
	@Test
	public void customerReg_Test() {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPwd(password);
		lp.clickLoginBtn();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			Assert.assertTrue(false);
		}
		else if(isAlertPresent()==false) {
			AddCustomerPage cp = new AddCustomerPage(driver);
			cp.clickNewUsrPageLink();
			if(cp.DismissBtn()==true) {
				cp.clickDismissBtn();
			}
			else if(cp.CloseBtn()==true) {
				cp.clickCloseBtn();
			}
			else {
				Assert.assertTrue(false);
			}
			cp.enterCustName("Samsul");
			cp.clickGender_radBtn("female");
			cp.enterCustDOB("15","05","1996");
			cp.enterCustAddress("125/25, streer");
			cp.enterCustCity("Madurai");
			cp.enterCustState("Andhr");
			String pin =randomNumber(6);
			cp.enterCustPin(pin);
			String phoneNum = randomNumber(10);
			cp.enterCustMobileNum(phoneNum);
			String email = randomString(6);
			String email1 = randomString(3);
			String email2 = "gamil.com";
			cp.enterCustEmail(email+email1+email2);
			cp.enterPassword("password3456");
			cp.clickSubmitBtn();
			
			if(cp.validateRegSuccessMsg()==true) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
	}
	
	

}
