package com.framework.Pages.ProfileAndPreferences.Profile.EmailInfo;

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

public class AddEmailPage extends BasePage{
	Logger log = LoggerHelper.getLogger(AddEmailPage.class);
	WebDriverWait wait;
	WebDriver driver;
	public AddEmailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath="//h1/span[text()='Add Email Information']")
	WebElement verifyAddEmailPage;
	
	@FindBy(id="emailId")
	WebElement emailId;
	
	@FindBy(id="emailId-error")
	WebElement emailIdError;
	
	@FindBy(id="vcm-bottom-nav-section-primary")
	WebElement saveBtn;
	
	@FindBy(id="vcm-bottom-nav-section-cancel")
	WebElement cancelBtn;
	
	
	public void verifyAddEmailPage() {
		this.elementVisible(verifyAddEmailPage);
	}


	public void verifyEmailIdField() {
		this.elementVisible(emailId);
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


	public void enterEmailId(String arg1) {
		this.clearAndSendKeys(emailId, arg1);
		emailId.sendKeys(Keys.TAB);
	}
	public void verifyEmailIdErrorMsg() {
		this.elementVisible(emailIdError);
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
