package com.framework.Pages.Transaction.Purchase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.Hooks;
import com.framework.Pages.BasePage;

public class EconsentPage extends BasePage{

	Logger log = LoggerHelper.getLogger(EconsentPage.class);
	WebDriverWait wait;
	WebDriver driver;
	Hooks hook;
	public EconsentPage(WebDriver driver) {
	    log.info("Inside Econsent Page");
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'5.  Prospectus Review')]")
	WebElement verifyPage; 
	public void verifyConsentPage() {
		log.info("Actual"+verifyPage.getText());
		Assert.assertEquals(verifyPage.getText(), "5. Prospectus Review","Verified Review Page");
		log.info("Verified Consent Page");	
	}
	@FindBy(id="esignCheck")
	WebElement esignCheck; 

	public void clickOnTermsAcceptanceCheckbox() {
		this.scrollIntoViewAndClick(esignCheck);
	}
	@FindBy(xpath="//span[@data-test='timeStampLabel']")
  	WebElement verifyDateFormat; 
	public void verifyDateFormatDisplayed() {
		this.elementVisible(verifyDateFormat);
	}
	@FindBy(xpath="//span[@data-test='timeStampSection']")
	WebElement verifyTodaysDate; 
	public void verifyTodaysDateDisplayed() {
		this.elementVisible(verifyTodaysDate);
	}

	@FindBy(xpath="//span[text()='Submit']")
	WebElement submitBttn; 
	public void clickOnSubmit() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(submitBttn));
		this.clickOnelement(submitBttn);
	}
}
