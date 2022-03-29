package com.framework.Pages.AccountOpening.UGMAAccount;

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

public class InvestingforChildrenPage extends BasePage{
	WebDriver driver;
	Logger log = LoggerHelper.getLogger(InvestingforChildrenPage.class);
	WebDriverWait wait;
	public InvestingforChildrenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[contains(text(),'College Saving Plan')]")
	WebElement clgSavingPlan;
	
	public void clickOnSavingPlan() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(clgSavingPlan));
		clgSavingPlan.click();
	}
	
	public void verifyClgSavingPlan(String expected) {
		log.info("Expected"+expected);	
		log.info("Actual"+clgSavingPlan.getText());
		Assert.assertTrue(expected.equalsIgnoreCase(clgSavingPlan.getText()));
	}
	@FindBy(xpath="//h3[contains(text(),'Transfers to Minors')]")
	WebElement ugmaTab;
	
	public void clickOnUGMAAccount() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(ugmaTab));
		ugmaTab.click();
		this.clickOnNext();
	}
	public void verifyUGMAAccount(String expected) {
		log.info("Expected"+expected);	
		log.info("Actual"+ugmaTab.getText());
		Assert.assertTrue(expected.equalsIgnoreCase(ugmaTab.getText()));
	}
}
