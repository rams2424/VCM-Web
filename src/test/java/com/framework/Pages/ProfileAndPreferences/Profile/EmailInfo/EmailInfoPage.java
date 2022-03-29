package com.framework.Pages.ProfileAndPreferences.Profile.EmailInfo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.Hooks;
import com.framework.Pages.BasePage;
import com.framework.Pages.ProfileAndPreferences.Profile.PhoneInfo.PhoneInfoPage;

public class EmailInfoPage extends BasePage{
	WebDriver driver;
	private Hooks hook;
	public EmailInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	Logger log = LoggerHelper.getLogger(PhoneInfoPage.class);
	WebDriverWait wait;
	
	@FindBy(xpath="//h1[contains(text(),'Email Information')]")
	WebElement verifyEmailInfo;
	
    @FindBy(xpath="//button[contains(@aria-label,'More Options on Primary Email ')]")
	WebElement moreOptPrimaryEmail;
	
    @FindBy(xpath="//button[contains(@aria-label,'More Options on Secondary Email ')]")
	WebElement moreOptSecEmail;
	
	@FindBy(xpath="//a[contains(@aria-label,'Add email')]")
	WebElement addEmailBttn;
	
	
	
	public void verifyEmailInfoPage() {
		this.elementVisible(verifyEmailInfo);
	}

	public void verifyAddEmailBttn() {
		this.elementVisible(addEmailBttn);
	}

	public void clickOnAddEmailBttn() {
		this.clickOnButton(addEmailBttn);
	}

		public void clickOnOptionsFor(String arg1) {
		if(arg1.equalsIgnoreCase("Primary Email")){
			this.clickOnButton(moreOptPrimaryEmail);
		}
		else{
			this.clickOnButton(moreOptSecEmail);
		}
	}

		public void verifyDeletion() {
			By newEmail= By.xpath("//button[contains(@aria-label,'More Options on - Secondary Email ')]");
			Assert.assertFalse(this.isElementPresent(newEmail));
		}
}
