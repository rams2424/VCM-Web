package com.framework.Pages.Transaction;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;

public class ConfirmationPage {

	Logger log = LoggerHelper.getLogger(ConfirmationPage.class);
	WebDriverWait wait;
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@data-test='confirmationHeading']")
	WebElement confirmationTxt;
	
	public void verifyConfirmationTxt(String expectedTxt) {
		log.info("Expected Text"+expectedTxt);
		log.info("Actual text"+confirmationTxt.getText());
		Assert.assertEquals(confirmationTxt.getText(), expectedTxt);
	}
	
	@FindBy(css="p[data-test='confirmationMessage']")
	WebElement confirmationMsg;
	
	public void verifyConfirmationMsg(String expected) {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(confirmationMsg));
		log.info("Confirmation Message"+confirmationMsg.getText());
		log.info("Expected"+expected);
		log.info(expected.equalsIgnoreCase(confirmationMsg.getText()));
		Assert.assertTrue(expected.equalsIgnoreCase(confirmationMsg.getText()));
	}
}
