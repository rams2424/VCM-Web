package com.framework.Pages.Transaction.Exchange;

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
import com.framework.Pages.Transaction.ConfirmationPage;

public class ReviewAndConfirmPage extends BasePage {
	
	Logger log = LoggerHelper.getLogger(ReviewAndConfirmPage.class);
	WebDriverWait wait;
    WebDriver driver;
	public ReviewAndConfirmPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[contains(text(),'Trade Type')]/parent::div//div[@class='sc-eoricN hNrPdK']")
	WebElement tradeTypeTxt;
	
	public void verifyTradeType(String tradeType) {
		log.info("Trade Type"+tradeType);
		log.info("Actual"+tradeTypeTxt.getText());
		Assert.assertEquals(tradeTypeTxt.getText(), tradeType);
	}
	@FindBy(xpath="//*[@data-test='review-page']//*[contains(text(),'Account Selection')]/following-sibling::div//button//span")
	WebElement accSeleditBtn;
	
	public void verifyAccountSelectionEditBtnDisplayed() {	
		log.info(accSeleditBtn.isDisplayed());
		Assert.assertTrue(accSeleditBtn.isDisplayed());
	}
	
	@FindBy(xpath="//*[@data-test='review-page']//*[contains(text(),'Selling Funds')]/following-sibling::div//button//span")
	WebElement sellAmtEditBtn;
	
	public void verifySellAmtEditBtn() {
		log.info(sellAmtEditBtn.isDisplayed());
		Assert.assertTrue(sellAmtEditBtn.isDisplayed());
	}
	
	@FindBy(xpath="//*[@data-test='review-page']//*[contains(text(),'Selected Mutual Fund')]/following-sibling::div//button//span")
	
	WebElement mutualFundEditBtn;
	public void verifyMutualFundEditbtn() {
		log.info(mutualFundEditBtn.isDisplayed());
		Assert.assertTrue(mutualFundEditBtn.isDisplayed());
	}
	
	@FindBy(xpath="//*[contains(text(),'Selling Amount')]//following-sibling::div")
	WebElement sellingAmt;
	
	public void verifySellingAmt(String amount) {
		log.info("Expected Amount"+amount);
		log.info("Actual Amount"+sellingAmt.getText());
		Assert.assertTrue(sellingAmt.getText().contains(amount));
	}
	@FindBy(xpath="//*[text()='Submit']")
	WebElement submitBtn;
	public void clickOnSubmitBtn() {
	    this.verifyPageIsLoaded();
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
	}
	public ConfirmationPage navigateToconfirmationPage() {
		return new ConfirmationPage(driver);
	}
}
