package com.framework.Pages.Transaction.Exchange;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.Transaction.FundSelectionPage;

public class ExchangePage {
    
    Logger log = LoggerHelper.getLogger(ExchangePage.class);
    WebDriverWait wait;
    WebDriver driver;
    public ExchangePage(WebDriver driver) {
        log.info("Inside Exchange Page");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FundSelectionPage navigateToFundSelectionPage() {
        return new FundSelectionPage(driver);
    }
    @FindBy(xpath="//h1[contains(text(),'Exchange')]")
    WebElement exchangeHeadertxt;
    
    public void verifyExchangePage() {
        log.info(exchangeHeadertxt.getText());
        Assert.assertTrue(exchangeHeadertxt.isDisplayed());
    }
    @FindBy(xpath="//span[contains(text(),'1.  Account Selection')]")
    WebElement accountSelectionTxt;
    public void verifyAccountSelectioPage(String txt) {
    	log.info("Account selection page"+txt);
    	log.info("Actual txt"+accountSelectionTxt.getText());
    	Assert.assertTrue(accountSelectionTxt.getText().contains(txt));
    	
    }
}
