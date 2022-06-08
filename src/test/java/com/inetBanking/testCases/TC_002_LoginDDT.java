package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_002_LoginDDT extends BaseClass{

	@Test(dataProvider = "loginData")
	public void loginDDT(String uname, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(uname);
		lp.setPwd(pwd);
		lp.clickLoginBtn();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			lp.clickLogoutBtn();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}
	}
	
	
	@DataProvider(name="loginData")
	String[][] getData() throws IOException{
		String xlfilePath = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/loginData.xlsx";
		
		int rownum = XLUtils.getRowCount(xlfilePath, "Sheet1");
		int colnum = XLUtils.getColCount(xlfilePath, "Sheet1", 1);
		
		System.out.println(rownum);
		System.out.println(colnum);
		
		String loginData[][] = new String[rownum][colnum];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colnum;j++) {
				loginData[i-1][j] = XLUtils.getCellData(xlfilePath,"Sheet1", i, j);
			}
		}
		return loginData;
	}
}
