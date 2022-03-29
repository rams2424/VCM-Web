package com.framework.Pages.Transaction.Purchase;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;


public class ConfirmationPage extends BasePage {

	Logger log = LoggerHelper.getLogger(ConfirmationPage.class);
	WebDriverWait wait;
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="div[data-test='confirmationHeading']")
	WebElement confirmationTxt;
	@FindBy(css="p[data-test='errorMessage']")
	WebElement errorMessage;
	
	public void verifyConfirmationTxt(String expectedTxt) {
		log.info("Expected Text"+expectedTxt);
		log.info("Actual text"+confirmationTxt.getText());
		Assert.assertEquals(confirmationTxt.getText(), expectedTxt);
	}
	//Your order has been received and we will begin processing. You will receive confirmation when your order is completed. 
	@FindBy(css="p[data-test='confirmationMessage']")
	WebElement confirmationMsg;
	
	public void verifyConfirmationMsg(String expected) {
		try{
		log.info("Confirmation Message"+confirmationMsg.getText());
		log.info("Expected"+expected);
		log.info(expected.equalsIgnoreCase(confirmationMsg.getText()));
		Assert.assertTrue(expected.equalsIgnoreCase(confirmationMsg.getText()));
		}
		catch(NoSuchElementException e){
			this.elementVisible(errorMessage);
		}
	}
	
	@FindBy(xpath="//div[@alt='Sample for personal check']")
	WebElement verifyCheck;
	
	public void verifyConfirmationForCheck(){
		try{
		Assert.assertTrue(verifyCheck.isDisplayed(),"Verified Confirmation of Check");
		this.elementVisible(verifyCheck);
		}
		catch(Exception e){
			log.info("Error");
		}
	}
	@FindBy(xpath="//h3[text()='Wire Transfer']")
	WebElement verifyWireTransfer;
	public void verifyConfirmationForWireTransfer(){
		Assert.assertTrue(verifyWireTransfer.isDisplayed(),"Verified Confirmation of Wire Tranfer");
		this.elementVisible(verifyWireTransfer);
	}

	public void verifyConfirmationFor(String payType) {
		switch(payType){
		case "Check":{
			this.verifyConfirmationTxt("Confirmation");
			this.verifyConfirmationForCheck();
			break;
		}
		case "Wire Transfer":{
			this.verifyConfirmationTxt("Confirmation");
			this.verifyConfirmationForWireTransfer();
			break;
		}
		case "WELLS FARGO BANK NA (ARIZONA)":{
			this.verifyConfirmationTxt("Confirmation");
			this.verifyConfirmationMsg("Your order has been received and we will begin processing. You will receive confirmation when your order is completed.");			
			break;			
		}
		}
	}
	@FindBy(css="button#products")
	WebElement productTab;
	
	public void clickOnProductLink() {
	    wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(productTab));
        productTab.click();
	}
	@FindBy(xpath="//*[contains(text(),'Home')]")
	WebElement homePageLink;
	public void clickToHomeLink() {
		verifyPageIsLoaded();
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(homePageLink));
		this.clickOnButtonUsingJs(homePageLink);
	}
	
	@FindBy(xpath="//div[@data-test='confirmationHeading']")
	WebElement headingTxt;
	public void verifyConfirmationText(String expected) throws InterruptedException {
	    this.verifyPageIsLoaded();
		log.info("Expected"+expected);
		Assert.assertTrue(headingTxt.getText().equalsIgnoreCase(expected));
	}
}
