package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "uid")
	WebElement usrNameTxtBox;
	
	@FindBy(name = "password")
	WebElement pwdTxtBox;
	
	@FindBy(name = "btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath= "//a[text()='Log out']")
	WebElement logoutBtn;
	
	//Action methods
	public void setUserName(String sName) {
		usrNameTxtBox.sendKeys(sName);
	}
	
	public void setPwd(String sPwd) {
		pwdTxtBox.sendKeys(sPwd);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void clickLogoutBtn() {
		logoutBtn.click();
	}

}
