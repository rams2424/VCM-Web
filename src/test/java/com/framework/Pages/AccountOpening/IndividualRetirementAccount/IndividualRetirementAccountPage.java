package com.framework.Pages.AccountOpening.IndividualRetirementAccount;

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

public class IndividualRetirementAccountPage extends BasePage{
	
	WebDriverWait wait;
	WebDriver driver;
	Logger log = LoggerHelper.getLogger(IndividualRetirementAccountPage.class);
	public IndividualRetirementAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@aria-current='true']/span[2]")
  	WebElement verifyPage; 
	public void verifyAccountTypePage() {
		Assert.assertEquals(verifyPage.getText(), "Step 1. Account Type","Verified Account Type Page");
		log.info("Verified Account Type");	
	}
	@FindBy(xpath="//*[contains(text(),'Traditional IRA')]")
	WebElement tradIRA;
	
	public void clickOnTradIRA() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(tradIRA));
		tradIRA.click();
		this.clickOnNext();
	}
	public void verifyTradIRA(String expected) {
		log.info("Expected"+expected);
		log.info("Actual"+tradIRA.getText());
		Assert.assertTrue(expected.equalsIgnoreCase(tradIRA.getText()));
	}
	@FindBy(xpath="//h3[contains(text(),'Roth IRA')]")
	WebElement rothIRA;
	
	public void clickOnRothIRA() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(rothIRA));
		rothIRA.click();
		this.clickOnNext();
	}
	public void verifyRothIRA(String expected) {
		log.info("Expected"+expected);
		log.info("Actual"+rothIRA.getText());
		Assert.assertTrue(expected.equalsIgnoreCase(rothIRA.getText()));
	}
	@FindBy(xpath="//h3[contains(text(),'Rollover ')]")
	WebElement rollOver;
	
	public void clickOnRollOver() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(rollOver));
		rollOver.click();
		this.clickOnNext();
	}
	public void verifyRollOver(String expected) {
		log.info("Expected"+expected);
		log.info("Actual"+rollOver.getText());
		Assert.assertTrue(expected.equalsIgnoreCase(rollOver.getText()));
	}
	@FindBy(xpath="//h3[contains(text(),'SEP ')]")
	WebElement sepIRA;
	
	public void clickOnSepIRA() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(sepIRA));
		sepIRA.click();
		this.clickOnNext();
	}
	public void verifySepIRA(String expected) {
		log.info("Expected"+expected);
		log.info("Actual"+sepIRA.getText());
		Assert.assertTrue(expected.equalsIgnoreCase(sepIRA.getText()));
	}
   @FindBy(xpath="//h3[contains(text(),'Simple ')]")
   WebElement simpleIRA;
   
   public void clickOnSimpleIRA() {
	   wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(simpleIRA));
		simpleIRA.click();
		this.clickOnNext();
   }
   public void verifySimpleIRA(String expected) {
	   log.info("Expected"+expected);
	   log.info("Actual"+simpleIRA.getText());
	   Assert.assertTrue(expected.equalsIgnoreCase(simpleIRA.getText()));
   }
   
}
