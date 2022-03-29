package com.framework.Pages.Transaction.Purchase;

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

public class PurchasePage  extends BasePage {
    Logger log = LoggerHelper.getLogger(PurchasePage.class);
    WebDriverWait wait;
    WebDriver driver;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnAccountType(String accountType) {
        log.info("Account Type"+accountType);
        WebElement accountTypeLink = driver.findElement(By.xpath("//div[text()='"+accountType+"']"));
        this.scrollIntoView(accountTypeLink);
        accountTypeLink.click();
    }
    
    @FindBy(xpath="//button[@buttontext='Cancel']")
    WebElement cancelBtn;
    public void checkVisibilityOfCancelButton() {
    	Assert.assertTrue(cancelBtn.isDisplayed());
    }
    
    public void clickOnCancelBtn(){
        this.scrollIntoViewAndClick(cancelBtn);
    }
    
    @FindBy(css="button[buttontext='Next']")
    WebElement nextBtn;
    
    public void checkVisibilityOfNextButton() {
       Assert.assertTrue(nextBtn.isDisplayed());
    }
    
    public void clickOnNextBtn(){
        this.scrollIntoViewAndClick(nextBtn);
    }
    
    public FundSelectionPage navigateToFundsSelectionPage() {
        return new FundSelectionPage(driver);
    }
    @FindBy(xpath="//span[contains(text(),'1.  Account Selection')]")
  	WebElement verifyaccountSelectionPage; 
	public void verifyPurchasePage() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(verifyaccountSelectionPage));
		Assert.assertEquals(verifyaccountSelectionPage.getText(), "1. Account Selection","Verified Purchase Page");
		log.info("Verified Purchase Page");	
	}

		    
	public void CheckNextButton(String flag) {
		if(flag=="enable"){
			Assert.assertTrue(nextBtn.isEnabled(),"Next Button is enabled");
			log.info(nextBtn+" is enabled");
		}
		else{
			Assert.assertFalse(nextBtn.isEnabled(),"Next Button is enabled");
			log.info(nextBtn+" is disabled");
		}
	}
	
    @FindBy(xpath="//a[text()='Transactions']")
    WebElement TransactionsLink;
    
    public void clickOnTransactions(){
        this.clickOnelement(TransactionsLink);
    }
    
    public TransactionPage navigateToTransactionPage() {
        this.clickOnTransactions();
        return new TransactionPage(driver);
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
        this.clickOnButton(yesBtn);
		return new HomePage(driver);
	}
	@FindBy(xpath="//button[@data-analytic-id='confirmation-modal-cancel']")
    WebElement noBtn;
	
	public void clickOnNo() {
		wait = new WebDriverWait(driver, 40);
        this.elementVisible(noBtn);
		this.clickOnButton(noBtn);
	}
	
	public void ClosePopup(){
		this.verifyPageIsLoaded();
        try{
        	if(this.isElementPresent(By.cssSelector("button#statusMsgClose"))) {
        		WebElement popup=driver.findElement(By.id("statusMsgClose"));
        		this.scrollIntoViewAndClick(popup);	
        		log.info("Pop up is handled");
        	}
        }
        catch(Exception e){
        	log.info("No pop up is displayed");
        }
	}
	public void verifyReturn(){
			Assert.assertTrue(driver.getCurrentUrl().contains("/transactionPurchases"),"Verified navigation to purchase page");	
			log.info("Navigated to "+driver.getCurrentUrl());
			}
		
	}

