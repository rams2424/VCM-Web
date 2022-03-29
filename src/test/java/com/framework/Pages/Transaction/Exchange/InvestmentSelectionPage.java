package com.framework.Pages.Transaction.Exchange;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class InvestmentSelectionPage extends BasePage{
	
	WebDriverWait wait;
	WebDriver driver;
	Logger log = LoggerHelper.getLogger(InvestmentSelectionPage.class);
	public InvestmentSelectionPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(text(),'3.  Investment Selection')]")
	WebElement verifyInvestMentTxt;
	
	public void verifyInvestMentSelectionPage() {
		this.ElementEnable(verifyInvestMentTxt);
	}
	@FindBy(xpath="//button[@id='nextButton']")
	WebElement Next;
	public ReviewAndConfirmPage navigateToReviewAndConfirmPage() {
		//this.clickOnButtonUsingJs(Next);
		return new ReviewAndConfirmPage(driver);
	}
	public void clickOnFundLink(String fundName) {
		log.info("Fund Name"+fundName);
		WebElement fundLink = driver.findElement(By.xpath("//*[text()='']"));
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(fundLink));
		fundLink.click();
	}
	@FindBy(xpath="//a[contains(text(),'Summary')]")
	WebElement summeryTab;
	
	public void verifySummeryTab() {
	    wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(summeryTab));
		log.info(summeryTab.isDisplayed());
		Assert.assertTrue(summeryTab.isDisplayed());
	}
	@FindBy(xpath="//button[text()='Back To Investment Selection']")
	WebElement backToInvestBtn;
	
	public void clickOnBackToInvestSelectionBtn() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(backToInvestBtn));
		backToInvestBtn.click();
	}
	public void clickOnNewFund(String fundName) {
	    log.info("Fund Name"+fundName);
		wait = new WebDriverWait(driver, 40);
		WebElement element = driver.findElement(By.xpath("//*[text()='"+fundName+"']/../following-sibling::div//div//div[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	@FindBy(css="input#esignCheck")
	WebElement prospectCheckBox;
	
	public void clickOnProspectCheckBox() {
		prospectCheckBox.click();
	}
}
