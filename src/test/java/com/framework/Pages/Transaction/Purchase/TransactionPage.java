package com.framework.Pages.Transaction.Purchase;

import java.util.List;

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
import com.framework.Pages.HomePage;

public class TransactionPage extends BasePage{
	
	WebDriverWait wait;
	WebDriver driver;
	Logger log = LoggerHelper.getLogger(TransactionPage.class);
    public TransactionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//div[@class='trans-table-start row']")
    WebElement fundAccounts;
    
    @FindBy(xpath="//a[contains(text(),'Back to My Portfolio')]")
    WebElement backToPortfolio;
    
    public HomePage  navigateToHomePage() {
        return new HomePage(driver);
    }

    public void CheckVisibilityOf_FundsAccount(){
        this.elementVisible(fundAccounts);
    }
    
    public void clickOn_BacktoPortfolio(){
        this.clickOnButton(backToPortfolio);
    }
    
	public void verifyTransactionPage() {
		verifyPageIsLoaded();
		log.info(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("/accountholder"));
        log.info("Navigated to Transaction Page");
	}
	
	@FindBy(xpath="//span[contains(text(),'Current Value')]//following::p[1]")
    WebElement curVal;
	public void verifyCurrentValue() {
		log.info(curVal.getText());
		Assert.assertTrue(curVal.getText().equals(currentVal));
	}
	public void navigateTo(String option){
		WebElement opt=driver.findElement(By.xpath("//div[contains(text(),'"+option+"')]"));
		this.clickOnButton(opt);
	}
	@FindBy(xpath="//div[text()='Summary']")
	WebElement summary;
	
	public void verifyViewDetails() {
		this.verifyPageIsLoaded();
		this.elementVisible(summary);
	}
	@FindBy(xpath="//*[contains(text(),'Account Activity')]")
	WebElement viewActivity;
	public void clickOnViewActivity(){
		this.scrollIntoViewAndClick(viewActivity);
	}
	public void verifyTradeDropdown(String arg1) {
		this.elementVisible(buy);
		this.elementVisible(sell);
		this.elementVisible(exchange);
	}
	public void verifyTradeDropdownForIra(String arg1) {
		this.elementVisible(buy);
		By selll= By.xpath("//div[contains(text(),'Sell')]");
		By exch= By.xpath("//div[contains(text(),'Exchange')]");
		Assert.assertFalse(this.isElementPresent(selll));
		Assert.assertFalse(this.isElementPresent(exch));
	}
	
	@FindBy(xpath="//button[@id='tickerButton']")
    List<WebElement> Ticker;
	public void clickOnTickerBttn() {
		this.clickOnButton(Ticker.get(0));
	}

	public void verifyTickerBttn() {
		this.elementVisible(Ticker.get(0));
	}
	@FindBy(id="tradeButtonMenu")
    WebElement tradeBttn;
	@FindBy(xpath="//div[contains(text(),'View Details')]")
    WebElement viewDetails;
	@FindBy(xpath="//div[contains(text(),'Buy')]")
    WebElement buy;
	@FindBy(xpath="//div[contains(text(),'Sell')]")
    WebElement sell;
	@FindBy(xpath="//div[contains(text(),'Exchange')]")
    WebElement exchange;
	public void verifyTickerDropdown(String arg1, String arg2, String arg3) {
		this.elementVisible(buy);
		this.elementVisible(sell);
		this.elementVisible(exchange);
	}
	public void clickOnTradeBttn() {
		this.clickOnButton(tradeBttn);
	}		 
	public void verifyTradeBttn() {
		this.elementVisible(tradeBttn);
	}
    public void clickOnExistingFund(String fundName) {
        log.info("Fund Name"+fundName);
        wait = new WebDriverWait(driver, 40);
        WebElement showAllFunds =  driver.findElement(By.xpath("//button[text()='Show all Funds']"));   
        wait.until(ExpectedConditions.elementToBeClickable(showAllFunds));
        this.clickOnButtonUsingJs(showAllFunds);
        WebElement existingFund =  driver.findElement(By.xpath("//input[@value='"+fundName+"']"));   
        wait.until(ExpectedConditions.elementToBeClickable(existingFund));
        this.clickOnButtonUsingJs(existingFund);
    }
}
