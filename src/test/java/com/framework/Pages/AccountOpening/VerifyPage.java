package com.framework.Pages.AccountOpening;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;

public class VerifyPage {
	
	Logger log = LoggerHelper.getLogger(VerifyPage.class);
	WebDriver driver;
	public VerifyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(text(),'6.  Verify')]")
	WebElement verifyPageTxt;
	
	public void verifyPage() {
		Assert.assertTrue(verifyPageTxt.isDisplayed());
	}
	
	@FindBy(xpath="//span[contains(text(),'Registration Type')]/../following-sibling::div//span")
	WebElement regTypetxt;
	public void verifyRegistrationType(String regType) {
		log.info("expected"+regType);
		log.info("Actual"+regTypetxt.getText());
		Assert.assertTrue(regType.equalsIgnoreCase(regTypetxt.getText()));
	}
}
