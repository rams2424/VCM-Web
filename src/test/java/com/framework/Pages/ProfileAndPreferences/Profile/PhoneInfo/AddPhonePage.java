package com.framework.Pages.ProfileAndPreferences.Profile.PhoneInfo;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class AddPhonePage extends BasePage{
	

	Logger log = LoggerHelper.getLogger(AddPhonePage.class);
	WebDriver driver;
	WebDriverWait wait;
	public AddPhonePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h1/span[text()='Add Phone Number']")
	WebElement verifyAddPhnPage;
	
	@FindBy(id="vcm-cms-phone-country-code-0")
	WebElement phnCountryCode;
	
	@FindBy(id="vcm-cms-phone-country-code-0-error")
	WebElement phnCountryCodeError;
	
	@FindBy(id="vcm-cms-phone-number-0")
	WebElement phnNumber;
	
	@FindBy(id="vcm-cms-phone-number-0-error")
	WebElement phnNumberError;
	
	@FindBy(id="vcm-bottom-nav-section-primary")
	WebElement saveBtn;
	
	@FindBy(id="vcm-cms-member-phone-is-mobile")
	WebElement phnIsMobileRadio;
	
	@FindBy(id="vcm-bottom-nav-section-cancel")
	WebElement cancelBtn;
	
	
	public void verifyAddPhonePage() {
		this.elementVisible(verifyAddPhnPage);
	}


	public void verifyCountryCode() {
		this.elementVisible(phnCountryCode);
	}


	public void verifyPhoneNumber() {
		this.elementVisible(phnNumber);
	}


	public void verifyIsMobileRadio() {
		this.elementVisible(phnIsMobileRadio);
	}


	public void verifySave(String status) {
		this.elementVisible(saveBtn);
		if(status.equalsIgnoreCase("disable")){
			Assert.assertFalse(saveBtn.isEnabled());
		}
		else{
			Assert.assertTrue(saveBtn.isEnabled());
		}
	}


	public void enterCountryCode(String arg1) {
		this.clearAndSendKeys(phnCountryCode, arg1);
		phnCountryCode.sendKeys(Keys.TAB);
	}


	public void enterPhoneNumber(String arg1) {
		this.clearAndSendKeys(phnNumber, arg1);
		phnNumber.sendKeys(Keys.TAB);
	}


	public void verifyCountryCodeErrorMsg() {
		this.elementVisible(phnCountryCodeError);
	}
	
	public void verifyPhoneErrorMsg() {
		this.elementVisible(phnNumberError);
	}
	public void clickOnMobileNoRadio() {
		this.clickOnButton(phnIsMobileRadio);
	}
	public void clickOnSaveBttn() {
		this.clickOnButton(saveBtn);
	}
	public void clickOnCancelBttn() {
		this.clickOnButton(cancelBtn);
	}
	public void verifyCancelBttn() {
		this.elementVisible(cancelBtn);
	}

	
}
