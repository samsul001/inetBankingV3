package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement newUsrPageLink;
	
	@FindBy(id = "dismiss-button")
	WebElement dismissBtn;
	
	@FindBy(xpath = "//span[text()='Close']")
	WebElement closeBtn;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement custName;
	
	@FindBy(name = "rad1")
	WebElement custGndr;
	
	@FindBy(xpath = "//input[@id='dob']")
	WebElement custDob;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement custAddress;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement custCity;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement custState;
	
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement custAddrPinno;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement custPhoneNumbr;
	
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement custEmail;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement custPassword;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitBtn_custAddPage;
	
	@FindBy(xpath = "//p[text()='Customer Registered Successfully!!!']")
	WebElement regSuccessMsg;
	
	//Action methods
	public void clickNewUsrPageLink() {
		newUsrPageLink.click();
	}
	
	public boolean DismissBtn() {
		boolean pass =dismissBtn.isDisplayed();
		return pass;
	}
	
	public boolean CloseBtn() {
		boolean pass=closeBtn.isDisplayed();
		return pass;
	}
	
	public void clickDismissBtn() {
		dismissBtn.click();
	}
	
	public void clickCloseBtn() {
		closeBtn.click();
	}
	
	public void enterCustName(String cName) {
		custName.sendKeys(cName);
	}
	
	public void clickGender_radBtn(String cgendr) {
		custGndr.click();
	}
	
	public void enterCustDOB(String dd, String mm, String yy) {
		custDob.sendKeys(dd);
		custDob.sendKeys(mm);
		custDob.sendKeys(yy);
	}
	
	public void enterCustAddress(String cAddress) {
		custAddress.sendKeys(cAddress);
	}
	
	public void enterCustCity(String cCity) {
		custCity.sendKeys(cCity);
	}
	
	public void enterCustState(String cState) {
		custState.sendKeys(cState);
	}
	
	public void enterCustPin(String cPin) {
		custAddrPinno.sendKeys(cPin);
	}
	
	public void enterCustMobileNum(String cMobileNum) {
		custPhoneNumbr.sendKeys(cMobileNum);
	}
	
	public void enterCustEmail(String cEmail) {
		custEmail.sendKeys(cEmail);
	}
	
	public void enterPassword(String cPassword) {
		custPassword.sendKeys(cPassword);
	}
	
	public void clickSubmitBtn() {
		submitBtn_custAddPage.click(); 
	}
	
	public boolean validateRegSuccessMsg() {
		boolean pass = regSuccessMsg.isDisplayed();
		return pass;
	}
	
	
}
