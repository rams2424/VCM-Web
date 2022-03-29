package com.framework.Pages.Transaction.Liquidation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.BasePage;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.TransactionPage;


public class SellPage extends BasePage {
    Logger log = LoggerHelper.getLogger(SellPage.class);
    WebDriverWait wait;
    WebDriver driver;
    public SellPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//button[@buttontext='Cancel']")
    WebElement cancelBtn;
    public void checkVisibilityOfCancelButton() {
        wait = new WebDriverWait(driver, 40);
        this.elementVisible(cancelBtn);
    }
    
    public void clickOnCancelBtn(){
    	this.clickOnButtonUsingJs(cancelBtn);
        
    }
    
    @FindBy(css="button[buttontext='Next']")
    WebElement nextBtn;
    
    public void checkVisibilityOfNextButton() {
        wait = new WebDriverWait(driver, 40);
        this.elementVisible(nextBtn);
    }
    
    public void clickOnNextBtn(){
        this.scrollIntoViewAndClick(nextBtn);
    }
    public void verifySellPage() {
        if(driver.getCurrentUrl().equals("https://sit.msweb.vcm.com/liquidation")){
            log.info("Navigated to "+driver.getCurrentUrl());
        }
        else{
            log.error("Failed Navigated to "+driver.getCurrentUrl());
        }	
    }
    
    public void CheckNextButton() {
        if(!this.ElementEnable(nextBtn)){
            Assert.assertFalse(nextBtn.isEnabled(),"Next Button is disabled");
        }
        else{
            log.error(nextBtn+" is enabled");
        }
    }
    
    @FindBy(xpath="//a[text()='Transactions']")
    WebElement TransactionsLink;
    
    public void clickOnTransactions(){
        this.elementVisible(TransactionsLink);
        this.clickOnButton(TransactionsLink);
    }
    
    @FindBy(xpath="//a[text()='Portfolio']")
    WebElement PortfolioLink;
    
    public void clickOnPortfolio(){  
        this.elementVisible(PortfolioLink);
        this.clickOnButtonUsingJs(PortfolioLink);
    }
    
    public HomePage navigateToHomePage() {
        this.clickOnPortfolio();
        return new HomePage(driver);
    }
    
    @FindBy(xpath="//div[@aria-labelledby='VCM-Modal-title']")
    WebElement cancelPopup;
    
    public void checkVisibilityOfCancelPopup() {
        wait = new WebDriverWait(driver, 40);
        this.elementVisible(cancelPopup);
    }
    
    @FindBy(xpath="//button[@buttontext='Yes']")
    WebElement yesBtn;
    
    public HomePage clickOnyes() {
        wait = new WebDriverWait(driver, 40);
        this.elementVisible(yesBtn);
        this.clickOnButtonUsingJs(yesBtn);
        return new HomePage(driver);
    }
    @FindBy(xpath="//button[@data-analytic-id='confirmation-modal-cancel']")
    WebElement noBtn;
    
    public void clickOnNo() {
        this.clickOnButtonUsingJs(noBtn);
    }
    @FindBy(id="statusMsgClose")
    WebElement popup;
    public void ClosePopup(){		
        wait = new WebDriverWait(driver, 40);
        if(this.isElementPresent(By.id("statusMsgClose")) && DriverFactory.getInstance().getDriver().findElement(By.id("statusMsgClose")).isDisplayed()) {
            this.clickOnButtonUsingJs(popup);
            log.info("Pop up is handled");
        }
    }
    public void SelectAccount(int accountNumber){
        WebElement accountNumberLink = driver.findElement(By.xpath("//div[text()='"+accountNumber+"']"));
        this.clickOnButtonUsingJs(accountNumberLink);		
    }
    public FundSelectionPage navigatetoFundSelection(){
        this.clickOnNextBtn();
        return new FundSelectionPage(driver);
    }
    public void verifyReturn(){
        if(driver.getCurrentUrl().equals("https://sit.msweb.vcm.com/transactionPurchases")){
            Assert.assertTrue(driver.getCurrentUrl().equals("https://sit.msweb.vcm.com/transactionPurchases"),"Verified navigation to purchase page");	
            log.info("Navigated to "+driver.getCurrentUrl());
        }
        else{
            log.info("Failed Navigation to "+driver.getCurrentUrl());
        }
    }
    public TransactionPage navigateToTransactionPage() {
        this.clickOnTransactions();
        return new TransactionPage(driver);
    }
}
